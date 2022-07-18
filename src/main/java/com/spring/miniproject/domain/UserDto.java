package com.spring.miniproject.domain;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserDto {

    private String user_id;

    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "유효한 이메일 형식이 아닙니다.")
    private String user_email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 문자,숫자,특수문자를 혼합하여 8-16자리로 작성해 주십시오.")
    private String user_password;

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String user_name;

    @Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "생년월일은 YYYY-MM-DD 형식으로 입력 바랍니다.")
    private String user_birth;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$" , message = "휴대폰 번호는 010-8888-8888과 같이 입력하여 주시기 바랍니다.")
    private String user_phone;

    private String profile_image;
    private Date register_date;
    private Date modify_date;

    public UserDto() {
    }


    public UserDto(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public UserDto(String user_email, String user_password, String user_name, String user_birth, String user_phone) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_birth = user_birth;
        this.user_phone = user_phone;
    }

    public UserDto(String user_id, String user_email, String user_password, String user_name, String user_birth, String user_phone, String profile_image, Date register_date, Date modify_date, String user_nickname) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_birth = user_birth;
        this.user_phone = user_phone;
        this.profile_image = profile_image;
        this.register_date = register_date;
        this.modify_date = modify_date;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id='" + user_id + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_birth=" + user_birth +
                ", user_phone='" + user_phone + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", register_date=" + register_date +
                ", modify_date=" + modify_date +
                '}';
    }
}
