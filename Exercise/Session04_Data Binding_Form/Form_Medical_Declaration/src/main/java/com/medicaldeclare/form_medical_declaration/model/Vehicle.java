package com.medicaldeclare.form_medical_declaration.model;

import java.util.Date;

public class Vehicle {
    private int id;
    private String name;
    private String identityNumber;
    private int seat;
    private VDate startDate;
    private VDate endDate;

    public Vehicle() {
    }

    public Vehicle(int id, String name, String identityNumber, int seat, VDate startDate, VDate endDate) {
        this.id = id;
        this.name = name;
        this.identityNumber = identityNumber;
        this.seat = seat;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public VDate getStartDate() {
        return startDate;
    }

    public void setStartDate(VDate startDate) {
        this.startDate = startDate;
    }

    public VDate getEndDate() {
        return endDate;
    }

    public void setEndDate(VDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", seat=" + seat +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
