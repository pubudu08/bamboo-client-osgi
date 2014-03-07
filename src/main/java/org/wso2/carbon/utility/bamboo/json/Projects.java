package org.wso2.carbon.utility.bamboo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pubudu on 2/3/14.
 */
public class Projects {

    private int size;
    private String expand;
    @JsonProperty("start-index")
    private int startIndex;
    @JsonProperty("max-result")
    private int maxResult;
    private Project project[];

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public String getExpand() {
        return expand;
    }

    private void setExpand(String expand) {
        this.expand = expand;
    }

    public int getStartIndex() {
        return startIndex;
    }

    private void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getMaxResult() {
        return maxResult;
    }

    private void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public Project[] getProject() {
        return project;
    }

    private void setProject(Project[] project) {
        this.project = project;
    }
}
