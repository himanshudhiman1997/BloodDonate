package com.himanshu.android.blooddonate;

public class Accepter {

    String accepterId;
    String accepterName;
    String accepterAge;
    String accepterGender;
    String accepterPhone;
    String accepterAddress;


    public Accepter() {

    }

    public Accepter(String accepterId, String accepterName, String accepterAge, String accepterGender, String accepterPhone, String accepterAddress) {
        this.accepterId = accepterId;
        this.accepterName = accepterName;
        this.accepterAge = accepterAge;
        this.accepterGender = accepterGender;
        this.accepterPhone = accepterPhone;
        this.accepterAddress = accepterAddress;

    }

    public String getAccepterId() {
        return accepterId;
    }

    public String getAccepterName() {
        return accepterName;
    }

    public String getAccepterAge() {
        return accepterAge;
    }

    public String getAccepterGender() {
        return accepterGender;
    }

    public String getAccepterPhone() {
        return accepterPhone;
    }

    public String getAccepterAddress() {
        return accepterAddress;
    }


}
