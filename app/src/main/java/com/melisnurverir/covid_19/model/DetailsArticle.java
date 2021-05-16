package com.melisnurverir.covid_19.model;

public class DetailsArticle {

    //              THIS IS MY MODEL CLASS FOR MY DATA

    Integer id;
    String articleName;
    String imageUrl;
    String fileUrl;

    public DetailsArticle(Integer id, String articleName, String imageUrl, String fileUrl) {
        this.id = id;
        this.articleName = articleName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}


