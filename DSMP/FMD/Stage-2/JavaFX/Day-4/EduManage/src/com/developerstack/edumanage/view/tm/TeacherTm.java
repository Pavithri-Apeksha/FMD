package com.developerstack.edumanage.view.tm;


import javafx.scene.control.Button;

public class TeacherTm {
    private String code;
    private String name;
    private String address;
    private String contactNo;
    private Button btn;

    public TeacherTm() {
    }

    public TeacherTm(String code, String name, String address, String contactNo, Button btn) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
