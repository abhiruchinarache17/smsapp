package equ.cjc.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import equ.cjc.StudentManagement.model.Student;
import equ.cjc.StudentManagement.service.Studentservice;



@Controller
public class AdminController
{
	@Autowired
	private Studentservice ss;
	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m)
	{
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			List<Student> list=ss.getAllStudents();
			m.addAttribute("data", list);
			
			return "adminscreen";	
			
		} else {
			m.addAttribute( "msg","username & password");
			return "login";
			
		}
		
		
		
	}
	

	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s)
	{
		ss.saveData(s);
		
		
		
		return "adminscreen";
		
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam("batchNumber") String batchNumber,Model m )
	{
		List<Student> list=ss.getStudentByBatch(batchNumber);
		if(list.size()>0)
		{
			m.addAttribute("data",list);
			return "adminscreen";
		}
		else {
			List<Student> list1 =ss.getAllStudents();
		m.addAttribute("data", list1);
		m.addAttribute("message", "No records are available for the batch"+batchNumber+"..");
		}
		return "adminscreen";
		
		
	}
	@RequestMapping("/fess")
	public String onfess(@RequestParam ("id") int studentId,Model m)
	{
		Student s=ss.getsingleStudent(studentId);
		m.addAttribute("st", s);
		return "fess";
		
	}
	@RequestMapping("/payfess")
	public String payfess(@RequestParam("studentId")int studentId,@RequestParam("ammount") double ammount,Model m)
	{
		ss.updateStudentFess(studentId,ammount);
		List<Student> list=ss.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
	
	
	@RequestMapping("/shiftBatch")
	public String shiftbatch(@RequestParam("id")int studentId,Model m)
	{
		Student s=ss.getSingleBatch(studentId);
	m.addAttribute("st", s);
		return "shiftbatch";
		
	}
	@RequestMapping("/changebatch")
	public String changebatch(@RequestParam("studentId") int studentId,@RequestParam("batchNumber") String batchNumber,Model m)
	{
		ss.UpdateStudentBatch(studentId,batchNumber);
		List<Student> list=ss.getAllStudents();
		m.addAttribute("data",list);
		return "adminscreen";
		
	}
	
}

