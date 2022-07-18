package com.spring.miniproject.domain;

public class UserProfileDto {
    private String user_email;
    private String profile_image;


    public UserProfileDto(String user_email, String profile_image) {
        this.user_email = user_email;
        this.profile_image = profile_image;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }


    @Override
    public String toString() {
        return "UserProfileDto{" +
                "user_email='" + user_email + '\'' +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
