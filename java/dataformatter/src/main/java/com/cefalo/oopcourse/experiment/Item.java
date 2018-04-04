package com.cefalo.oopcourse.experiment;

/**
 * Basic item with properties
 * <p>
 * Created by jobaer on Dec-19-2017.
 */
public class Item {
    private String id;
    private String title;
    private double value;

    public Item(String id, String title, double value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
