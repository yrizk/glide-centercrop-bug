package com.amg.android.projectt.model;

import org.json.JSONObject;

public class ImgurImage { //TODO use a generic name?

    private String id; //TODO is this needed?
    private String title;
    private String description;  //TODO is this needed?
    private String link;


    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    private void setLink(String link) {
        this.link = link;
    }

    public boolean isValid(){
        return id != null && id.length() > 0 &&
                title != null && title.length() > 0 &&
                description != null && description.length() > 0 &&
                link != null && link.length() > 0;
    }

    public void parse(JSONObject jsonObject) {
        if (jsonObject != null) {
            setId(jsonObject.optString("id"));
            setTitle(jsonObject.optString("title"));
            setDescription(jsonObject.optString("description"));
            setLink(jsonObject.optString("link"));
        }
    }

}
