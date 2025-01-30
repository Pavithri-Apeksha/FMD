package com.developerstack.edumanage.model;

import java.util.Date;

public class Intake {
    private String intakeId;
    private Date startDate;
    private String intakeName;
    private boolean intakeComplete;
    private String programId;

    public Intake() {
    }

    public Intake(String intakeId, Date startDate, String intakeName, boolean intakeComplete, String programId) {
        this.intakeId = intakeId;
        this.startDate = startDate;
        this.intakeName = intakeName;
        this.intakeComplete = intakeComplete;
        this.programId = programId;
    }

    public String getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(String intakeId) {
        this.intakeId = intakeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getIntakeName() {
        return intakeName;
    }

    public void setIntakeName(String intakeName) {
        this.intakeName = intakeName;
    }

    public boolean isIntakeComplete() {
        return intakeComplete;
    }

    public void setIntakeComplete(boolean intakeComplete) {
        this.intakeComplete = intakeComplete;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    @Override
    public String toString() {
        return "Intake{" +
                "intakeId='" + intakeId + '\'' +
                ", startDate=" + startDate +
                ", intakeName='" + intakeName + '\'' +
                ", intakeComplete=" + intakeComplete +
                ", programId='" + programId + '\'' +
                '}';
    }
}
