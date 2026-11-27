package com.example.demo.practice;

public class Aspirant extends Student{

    private String sienceWork;


    public Aspirant(String firstName, String lastName, String group, double averageMark,String sienceWork) {
        super(firstName, lastName, group, averageMark);
        this.sienceWork = sienceWork;
    }

    @Override
    public int getScholarship() {
        if (getAverageMark() == 5){
            return 2500;
        }else return 2200;
    }

    public String getSienceWork() {
        return sienceWork;
    }
}
