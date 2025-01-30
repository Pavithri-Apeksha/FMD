package com.developerstack.edumanage.model;

public class Teacher {
    private String code;
    private String name;
    private String address;
    private String contactNo;

    public Teacher() {
    }

    public Teacher(String code, String name, String address, String contactNo) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
