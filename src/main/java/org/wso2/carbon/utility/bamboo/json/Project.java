package org.wso2.carbon.utility.bamboo.json;

import org.wso2.carbon.utility.bamboo.util.PublicLinkCreator;
import sun.net.www.content.text.plain;

/**
 * Created by pubudu on 2/3/14.
 */
public class Project {

    private String name;
    private String key;
    private Link link;


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    public Link getLink() {
        return link;
    }

    private void setLink(Link link) {
        this.link = link;
        link.setPublicLink(PublicLinkCreator.updateLink(link,getKey()));
    }
}
