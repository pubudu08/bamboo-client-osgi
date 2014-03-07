package org.wso2.carbon.utility.bamboo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.wso2.carbon.utility.bamboo.json.ProjectWrapper;
import org.wso2.carbon.utility.bamboo.service.CIAdminService;


import java.io.IOException;


/**
 * Created by pubudu on 2/3/14.
 */
public class Test {


    public static void main(String[] args) throws IOException {


        String url = "https://wso2.org/bamboo/rest/api/latest/project";
        String USER_AGENT = "Mozilla/5.0";
        String ACCEPT_HEADER="application/json";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        request.addHeader("Accept",ACCEPT_HEADER);
        HttpResponse response = client.execute(request);
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());



        ProjectWrapper projectWrapper = mapper.readValue(response.getEntity().getContent(), ProjectWrapper.class);
        for(int x =0;x<projectWrapper.getProjects().getProject().length;x++)   {

            System.out.println(projectWrapper.getProjects().getProject()[x].getLink().getPublicLink());
        }
        CIAdminService admin = new CIAdminService();
        System.out.println(admin.isCISProjectExist(null, null, null,"https://wso2.org/bamboo/browse/CR001"))  ;


    }
}
