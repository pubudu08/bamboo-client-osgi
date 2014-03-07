package org.wso2.carbon.utility.bamboo.util;

import org.wso2.carbon.utility.bamboo.json.Link;
import org.wso2.carbon.utility.bamboo.json.Project;

/**
 * Created by pubudu on 2/3/14.
 */
public class PublicLinkCreator {


    public static String updateLink(Link link,String key){

        String apiHref = link.getHref();
        String publicLink = "https://wso2.org/bamboo/browse/"+key;
        return publicLink;
    }
}
