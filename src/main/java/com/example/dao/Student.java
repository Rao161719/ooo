package com.example.dao;

import java.sql.Date;

public class Student {
    private String no;
    private String name;
    private String sex;
    private String  sbirthday;
    private String clas;

    public Student() {
    }

    public Student(String no, String name, String sex, String sbirthday, String clas) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.sbirthday = sbirthday;
        this.clas = clas;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sbirthday=" + sbirthday +
                ", clas='" + clas + '\'' +
                '}';
    }
}
