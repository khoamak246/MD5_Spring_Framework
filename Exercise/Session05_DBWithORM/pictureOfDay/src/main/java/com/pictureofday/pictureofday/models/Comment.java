package com.pictureofday.pictureofday.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String auth;
    private String feedback;
    private int favorite;
    private LocalDate date;

    public Comment() {
    }

    public Comment(Long id, int rate, String auth, String feedback, int like) {
        this.id = id;
        this.rate = rate;
        this.auth = auth;
        this.feedback = feedback;
        this.favorite = like;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLike() {
        return favorite;
    }

    public void setLike(int like) {
        this.favorite = like;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void clone(Comment comment) {
        this.id = comment.getId();
        this.rate = comment.getRate();
        this.auth = comment.getAuth();
        this.feedback = comment.getFeedback();
        this.favorite = comment.getLike();
        this.date = comment.getDate();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", rate=" + rate +
                ", auth='" + auth + '\'' +
                ", feedback='" + feedback + '\'' +
                ", like=" + favorite +
                ", date=" + date +
                '}';
    }
}
