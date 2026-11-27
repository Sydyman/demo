package com.example.demo;

import com.example.demo.practice.Aspirant;
import com.example.demo.practice.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




	public void returnStudenrs(){
		Student student1 = new Student("Илья","Прусикин","A",6);
		Student student2 = new Student("Илья","Прусикичкин","b",5);
		Aspirant aspirant = new Aspirant("Артур","Микайэлян","S",5,"History");
		System.out.println(student1.getScholarship());
		Student[] students = new Student[3];
		students[0] = student1;
		students[1] = student2;
		students[2] = aspirant;

		for(Student studen : students){
			System.out.println(studen.getScholarship());
		}
	}

}
