package org.wso2.carbon.utility.bamboo.json;

/**
 * Created by pubudu on 2/3/14.
 */
public class Link {

    private String href ;
    private String rel;

    public String getPublicLink() {
        return publicLink;
    }

    public void setPublicLink(String publicLink) {
        this.publicLink = publicLink;
    }

    private String publicLink;

    public String getHref() {
        return href;
    }

    private void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    private void setRel(String rel) {
        this.rel = rel;
    }
}
