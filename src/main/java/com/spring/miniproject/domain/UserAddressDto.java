package com.spring.miniproject.domain;

public class UserAddressDto {
    private int address_id;
    private int user_id;
    private String receiver_name;
    private String receiver_phone;
    private String address;
    private String address_detail;
    private String zipcode;

    public UserAddressDto(int user_id, String receiver_name, String receiver_phone, String address, String address_detail, String zipcode) {
        this.user_id = user_id;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.address = address;
        this.address_detail = address_detail;
        this.zipcode = zipcode;
    }
    public UserAddressDto(int address_id, int user_id, String receiver_name, String receiver_phone, String address, String address_detail, String zipcode) {
        this.user_id = user_id;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.address = address;
        this.address_detail = address_detail;
        this.zipcode = zipcode;
        this.address_id = address_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
