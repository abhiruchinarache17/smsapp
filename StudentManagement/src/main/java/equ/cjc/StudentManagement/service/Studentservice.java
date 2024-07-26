package equ.cjc.StudentManagement.service;


import java.util.List;

import equ.cjc.StudentManagement.model.Student;

public interface Studentservice
{

	void saveData(Student s);
	  List<Student> getAllStudents();
	 
	
	Student getsingleStudent(int studentId);
	
	void updateStudentFess(int studentId, double ammount);
	List<Student> getStudentByBatch(String batchNumber);
	//void updatebatchMode(String batchMode, String batchMode2);
	//void updatebatchMode(String batchNumber, String batchNumber1);
	void updatebatchNumber(int studentId, String batchNumber);
	Student getSingleBatch(int studentId);
	void UpdateStudentBatch(int studentId, String batchNumber);
	
	

}
