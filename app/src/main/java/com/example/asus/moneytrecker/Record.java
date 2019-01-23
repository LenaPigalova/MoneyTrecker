package com.example.asus.moneytrecker;

/**
 * Created by ASUS on 23.01.2019.
 */

public class Record {
    private final String title;
    private final int price;
    String comment;

    public Record(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
