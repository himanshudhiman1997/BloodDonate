package com.himanshu.android.blooddonate;

public class Donor {
    String donorID;
    String donorName;
    String donorAge;
    String donorGender;
    String donorPhone;
    String donorAddress;
    String donorBloodGroup;

    public Donor() {

    }

    public Donor(String donorID, String donorName, String donorAge, String donorGender, String donorPhone, String donorAddress, String donorBloodGroup) {
        this.donorID = donorID;
        this.donorName = donorName;
        this.donorAge = donorAge;
        this.donorGender = donorGender;
        this.donorPhone = donorPhone;
        this.donorAddress = donorAddress;
        this.donorBloodGroup = donorBloodGroup;
    }

    public String getDonorID() {
        return donorID;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorAge() {
        return donorAge;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public String getDonorBloodGroup() {
        return donorBloodGroup;
    }
}
