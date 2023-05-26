package com.medicaldeclare.form_medical_declaration.model;

public class VDate {
    private int id;
    private int date;
    private int month;
    private int year;

    public VDate() {
    }

    public VDate(int id, int date, int month, int year) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "VDate{" +
                "date=" + date +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
