package equ.cjc.StudentManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equ.cjc.StudentManagement.model.Student;
import equ.cjc.StudentManagement.repository.Studentrepository;
import equ.cjc.StudentManagement.service.Studentservice;

@Service
public class Studentserviceimpl implements Studentservice
{
	
	@Autowired
	private Studentrepository sr;
	@Override
	public void saveData(Student s)
	{
		sr.save(s);
	}
	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}
	@Override
	public List<Student> getStudentByBatch(String batchNumber) {

		return sr.findAllByBatchNumber(batchNumber);
	}
	
	@Override
	public Student getsingleStudent(int studentId) 
	{
		//Optional<Student> opStudent=sr.findById(studentId);
		
		return sr.findById(studentId).get();
	}
	@Override
	public void updateStudentFess(int studentId, double ammount) {
		Student s = sr.findById(studentId).get();
		s.setFessPaid(s.getFessPaid()+ammount);
		
	}
	@Override
	public void updatebatchNumber(int studentId, String batchNumber) {
		List<Student> s = sr.findAllByBatchNumber(batchNumber);
	

	
	
		
	}
	@Override
	public Student getSingleBatch(int studentId) {
		
		return sr.findById(studentId).get();
	}
	@Override
	public void UpdateStudentBatch(int studentId, String batchNumber)
	{
		Student s=sr.findById(studentId).get();
		s.setBatchNumber(batchNumber);
		sr.save(s);
		
	}
		
	
	
	
	
	

	
}
