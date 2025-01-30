package com.developerstack.edumanage.model;

import java.util.Arrays;

public class Program {
    private String programCode;
    private String programName;
    private String[] technologies;
    private double cost;
    private String teacherId;

    public Program() {
    }

    public Program(String programCode, String programName, String[] technologies, double cost, String teacherId) {
        this.programCode = programCode;
        this.programName = programName;
        this.technologies = technologies;
        this.cost = cost;
        this.teacherId = teacherId;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String[] getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String[] technologies) {
        this.technologies = technologies;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", technologies=" + Arrays.toString(technologies) +
                ", cost=" + cost +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
