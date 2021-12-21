package com.techoffice.Services.dto.generic;

public class SearchDTO {
    private String accusedName;
    private String requestNumber;
    private String applicantName;

    public void setAccusedName(String accusedName) {
        this.accusedName = accusedName;
    }

    public String getAccusedName() {
        return accusedName;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantName() {
        return applicantName;
    }
}
