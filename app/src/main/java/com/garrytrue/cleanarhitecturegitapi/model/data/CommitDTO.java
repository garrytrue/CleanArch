package com.garrytrue.cleanarhitecturegitapi.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by garrytrue on 25.06.16.
 */
public class CommitDTO {
    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * @return The sha
     */
    public String getSha() {
        return sha;
    }

    /**
     * @param sha The sha
     */
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
