package com.medicaldeclare.form_medical_declaration.model;

public class Symptoms {
    private int id;
    private boolean fever;
    private boolean cough;
    private boolean shortnessBreath;
    private boolean soreThroat;
    private boolean vomiting_nausea;
    private boolean Diarrhea;
    private boolean skinHemorrhage;
    private boolean skinRash;

    public Symptoms() {
    }

    public Symptoms(int id, boolean fever, boolean cough, boolean shortnessBreath, boolean soreThroat, boolean vomiting_nausea, boolean diarrhea, boolean skinHemorrhage, boolean skinRash) {
        this.id = id;
        this.fever = fever;
        this.cough = cough;
        this.shortnessBreath = shortnessBreath;
        this.soreThroat = soreThroat;
        this.vomiting_nausea = vomiting_nausea;
        Diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isShortnessBreath() {
        return shortnessBreath;
    }

    public void setShortnessBreath(boolean shortnessBreath) {
        this.shortnessBreath = shortnessBreath;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomiting_nausea() {
        return vomiting_nausea;
    }

    public void setVomiting_nausea(boolean vomiting_nausea) {
        this.vomiting_nausea = vomiting_nausea;
    }

    public boolean isDiarrhea() {
        return Diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        Diarrhea = diarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    @Override
    public String toString() {
        return "Symptoms{" +
                "fever=" + fever +
                ", cough=" + cough +
                ", shortnessBreath=" + shortnessBreath +
                ", soreThroat=" + soreThroat +
                ", vomiting_nausea=" + vomiting_nausea +
                ", Diarrhea=" + Diarrhea +
                ", skinHemorrhage=" + skinHemorrhage +
                ", skinRash=" + skinRash +
                '}';
    }
}
