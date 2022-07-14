package com.empose.dtos;


import javax.validation.constraints.NotEmpty;

public class EmailSenderDto {

    @NotEmpty
    private String toEmail;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String body;


    public EmailSenderDto(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public EmailSenderDto() {
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailSenderDto{" +
                "toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
