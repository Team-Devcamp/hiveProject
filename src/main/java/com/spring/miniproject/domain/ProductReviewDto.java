package com.spring.miniproject.domain;

import java.util.Date;

public class ProductReviewDto {
    private int review_id;
    private int user_id;
    private int product_id;
    private String user_email;
    private String review_content;
    private Date write_date;
    private String upload_file;


    public ProductReviewDto(int review_id, int user_id, int product_id, String user_email, String review_content, Date write_date, String upload_file) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.user_email = user_email;
        this.review_content = review_content;
        this.write_date = write_date;
        this.upload_file = upload_file;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public Date getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Date write_date) {
        this.write_date = write_date;
    }

    public String getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(String upload_file) {
        this.upload_file = upload_file;
    }

    @Override
    public String toString() {
        return "ProductReviewDto{" +
                "review_id=" + review_id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", user_email='" + user_email + '\'' +
                ", review_content='" + review_content + '\'' +
                ", write_date=" + write_date +
                ", upload_file='" + upload_file + '\'' +
                '}';
    }
}
