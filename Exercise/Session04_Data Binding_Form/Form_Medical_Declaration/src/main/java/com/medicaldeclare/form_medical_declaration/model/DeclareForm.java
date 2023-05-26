package com.medicaldeclare.form_medical_declaration.model;

public class DeclareForm {
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private Symptoms symptoms;
    private HistoryInfection historyInfection;

    public DeclareForm() {
    }

    public DeclareForm(Customer customer, Vehicle vehicle, Symptoms symptoms, HistoryInfection historyInfection) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.symptoms = symptoms;
        this.historyInfection = historyInfection;
    }

    public DeclareForm(int id, Customer customer, Vehicle vehicle, Symptoms symptoms, HistoryInfection historyInfection) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.symptoms = symptoms;
        this.historyInfection = historyInfection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    public HistoryInfection getHistoryInfection() {
        return historyInfection;
    }

    public void setHistoryInfection(HistoryInfection historyInfection) {
        this.historyInfection = historyInfection;
    }

    @Override
    public String toString() {
        return "DeclareForm{" +
                "customer=" + customer +
                ", vehicle=" + vehicle +
                ", symptoms=" + symptoms +
                ", historyInfection=" + historyInfection +
                '}';
    }
}
