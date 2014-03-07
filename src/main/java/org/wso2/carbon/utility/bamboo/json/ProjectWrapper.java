package org.wso2.carbon.utility.bamboo.json;

/**
 * Created by pubudu on 2/3/14.
 */
public class ProjectWrapper {
    private String expand;
    private Link link;
    private Projects projects;

    public String getExpand() {
        return expand;
    }

    private void setExpand(String expand) {
        this.expand = expand;
    }

    public Link getLink() {
        return link;
    }

    private void setLink(Link link) {
        this.link = link;
    }

    public Projects getProjects() {
        return projects;
    }

    private void setProjects(Projects projects) {
        this.projects = projects;
    }
}
