package br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.model;

public class User {

    private Double enrollment;
    private Double password;

    public User(Double enrollment, Double password) {
        this.enrollment = enrollment;
        this.password = password;
    }

    public Double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Double enrollment) {
        this.enrollment = enrollment;
    }

    public Double getPassword() {
        return password;
    }

    public void setPassword(Double password) {
        this.password = password;
    }
}
