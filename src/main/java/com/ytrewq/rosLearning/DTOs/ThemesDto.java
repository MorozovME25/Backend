package com.ytrewq.rosLearning.DTOs;


import java.time.LocalDateTime;

public class ThemesDto {
    public String title;
    public LocalDateTime dateOfCreation;
    public String description;

    public ThemesDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}