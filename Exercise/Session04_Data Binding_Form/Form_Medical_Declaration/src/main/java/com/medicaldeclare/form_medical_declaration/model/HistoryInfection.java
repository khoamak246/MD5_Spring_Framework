package com.medicaldeclare.form_medical_declaration.model;

public class HistoryInfection {
    private int id;
    private boolean animalContact;
    private  boolean closeInfectedPerson;

    public HistoryInfection() {
    }

    public HistoryInfection(int id, boolean animalContact, boolean closeInfectedPerson) {
        this.id = id;
        this.animalContact = animalContact;
        this.closeInfectedPerson = closeInfectedPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAnimalContact() {
        return animalContact;
    }

    public void setAnimalContact(boolean animalContact) {
        this.animalContact = animalContact;
    }

    public boolean isCloseInfectedPerson() {
        return closeInfectedPerson;
    }

    public void setCloseInfectedPerson(boolean closeInfectedPerson) {
        this.closeInfectedPerson = closeInfectedPerson;
    }

    @Override
    public String toString() {
        return "HistoryInfection{" +
                "animalContact=" + animalContact +
                ", closeInfectedPerson=" + closeInfectedPerson +
                '}';
    }
}
