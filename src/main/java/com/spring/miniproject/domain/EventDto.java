package com.spring.miniproject.domain;

import java.util.Date;
import java.util.List;

public class EventDto {

    private int event_id;
    private String event_title;
    private String event_content;
    private String writer;
    private Date write_date;
    private Date modify_date;
    private int view_cnt;
    private List upload_file;

    public EventDto(){}

    public EventDto(int event_id, String event_title, String event_content, String writer, Date write_date, Date modify_date, int view_cnt, List upload_file) {
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_content = event_content;
        this.writer = writer;
        this.write_date = write_date;
        this.modify_date = modify_date;
        this.view_cnt = view_cnt;
        this.upload_file = upload_file;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_content() {
        return event_content;
    }

    public void setEvent_content(String event_content) {
        this.event_content = event_content;
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

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public List getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(List upload_file) {
        this.upload_file = upload_file;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "event_id=" + event_id +
                ", event_title='" + event_title + '\'' +
                ", event_content='" + event_content + '\'' +
                ", writer='" + writer + '\'' +
                ", write_date=" + write_date +
                ", modify_date=" + modify_date +
                ", view_cnt=" + view_cnt +
                ", upload_file=" + upload_file +
                '}';
    }
}
