package model;

import java.time.LocalDateTime;
import java.util.Optional;

public class Comment {

    private Integer id;
    private String webpage;
    private String summary;
    private String comment;
    private Optional<Integer> userId;
    private LocalDateTime createdOn;

    public Comment() {

    }

    public Comment(String webpage, String summary, String comment, Optional<Integer> userId, LocalDateTime createdOn) {
        this.webpage = webpage;
        this.summary = summary;
        this.comment = comment;
        this.userId = userId;
        this.createdOn = createdOn;
    }

    public Comment(Integer id, String webpage, String summary, String comment, Optional<Integer> userId, LocalDateTime createdOn) {
        this.id = id;
        this.webpage = webpage;
        this.summary = summary;
        this.comment = comment;
        this.userId = userId;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public String getWebpage() {
        return webpage;
    }

    public String getSummary() {
        return summary;
    }

    public String getComment() {
        return comment;
    }

    public Optional<Integer> getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUserId(Optional<Integer> userId) {
        this.userId = userId;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
