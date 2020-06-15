package com.example.possible_vulnerabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CVE implements Serializable {
    @SerializedName("cve_id")
    @Expose
    private String cveId;
    @SerializedName("cwe_id")
    @Expose
    private String cweId;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("cvss_score")
    @Expose
    private String cvssScore;
    @SerializedName("exploit_count")
    @Expose
    private String exploitCount;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("update_date")
    @Expose
    private String updateDate;
    @SerializedName("url")
    @Expose
    private String url;

    public String getCveId() {
        return cveId;
    }

    public void setCveId(String cveId) {
        this.cveId = cveId;
    }

    public String getCweId() {
        return cweId;
    }

    public void setCweId(String cweId) {
        this.cweId = cweId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCvssScore() {
        return cvssScore;
    }

    public void setCvssScore(String cvssScore) {
        this.cvssScore = cvssScore;
    }

    public String getExploitCount() {
        return exploitCount;
    }

    public void setExploitCount(String exploitCount) {
        this.exploitCount = exploitCount;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CVE{" +
                "cveId='" + cveId + '\'' +
                ", cweId='" + cweId + '\'' +
                ", summary='" + summary + '\'' +
                ", cvssScore='" + cvssScore + '\'' +
                ", exploitCount='" + exploitCount + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
