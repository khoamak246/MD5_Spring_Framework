package com.uploadmusic.upload_music.model;

import org.springframework.web.multipart.MultipartFile;

public class AudioForm {
    private int id;

    private String name;

    private String description;

    private MultipartFile url;

    public AudioForm() {
    }

    public AudioForm(int id, String name, String description, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
