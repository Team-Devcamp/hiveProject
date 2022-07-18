package com.spring.miniproject.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

public class QnaDto {
    private int qna_id;
    private int product_id;
    private String qna_title;
    private String qna_content;
    private String writer;
    private Date write_date;
    private Date modify_date;
    private int status;
    private int secret;


    public QnaDto(int qna_id, int product_id, String qna_title, String qna_content, String writer, Date write_date, Date modify_date, int status, int secret) {
        this.qna_id = qna_id;
        this.product_id = product_id;
        this.qna_title = qna_title;
        this.qna_content = qna_content;
        this.writer = writer;
        this.write_date = write_date;
        this.modify_date = modify_date;
        this.status = status;
        this.secret = secret;
    }

    public int getQna_id() {
        return qna_id;
    }

    public void setQna_id(int qna_id) {
        this.qna_id = qna_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getQna_title() {
        return qna_title;
    }

    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }

    public String getQna_content() {
        return qna_content;
    }

    public void setQna_content(String qna_content) {
        this.qna_content = qna_content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Date write_date) {
        this.write_date = write_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }
    @Override
    public String toString() {
        return "QnaDto{" +
                "qna_id=" + qna_id +
                ", product_id=" + product_id +
                ", qna_title='" + qna_title + '\'' +
                ", qna_content='" + qna_content + '\'' +
                ", writer='" + writer + '\'' +
                ", write_date=" + write_date +
                ", modify_date=" + modify_date +
                ", status=" + status +
                ", secret=" + secret +
                '}';
    }
}
