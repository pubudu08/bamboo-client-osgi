package org.wso2.carbon.utility.bamboo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.wso2.carbon.utility.bamboo.json.Project;
import org.wso2.carbon.utility.bamboo.json.ProjectWrapper;
import org.wso2.carbon.utility.continuousintegration.IContinuousIntegration;

import java.io.IOException;

/**
 * Created by pubudu on 2/3/14.
 */
public class CIAdminService implements IContinuousIntegration {

    private static final Log logger = LogFactory.getLog(CIAdminService.class);
    private String USER_AGENT = "Mozilla/5.0";
    private String ACCEPT_HEADER="application/json";

    @Override
    public String getCISType() {
        return "Bamboo";
    }

    @Override
    public boolean createCISProject(String username, String password, String endPoint, String projectName) {
        //not yet supported by the Bamboo REST API ( 3/2/2014 )  use this method body to create a project
        return false;
    }


    @Override
    public boolean isCISProjectExist(String username, String password, String projectLink, String projectName) {
        String url ;
        String[] parts = projectName.split("/bamboo/");
        url = parts[0]+"/bamboo/rest/api/latest/project";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        request.addHeader("Accept",ACCEPT_HEADER);
        Project[] listOfProjects = null;
        try {
            HttpResponse response = client.execute(request);
            ObjectMapper mapper = new ObjectMapper();
            logger.info("Response Code : "
                    + response.getStatusLine().getStatusCode());
            ProjectWrapper projectWrapper = mapper.readValue(response.getEntity().getContent(), ProjectWrapper.class);
            listOfProjects = projectWrapper.getProjects().getProject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Project projects : listOfProjects) {
            //logger.info(projects.getName()+" "+projects.getKey()+" "+projects.getLink().getPublicLink());
            if(projects.getLink().getPublicLink().equals(projectName)){
                return true;
            }
        }
        return false;
    }


}
