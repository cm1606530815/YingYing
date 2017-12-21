package com.example.yingying.Bean;

/**
 * Created by samsung on 2017/12/18.
 */

public class EventbusMessager {
    private String position;
    private String text;
    public EventbusMessager(String position, String text) {
        this.position = position;
        this.text = text;
    }

    public String getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setText(String text) {
        this.text = text;
    }
}
