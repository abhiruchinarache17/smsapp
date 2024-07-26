package equ.cjc.StudentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equ.cjc.StudentManagement.model.Student;
@Repository
public interface Studentrepository extends JpaRepository <Student,Integer>
{

	

	List<Student> findAllByBatchNumber(String batchNumber);

	
	

}

