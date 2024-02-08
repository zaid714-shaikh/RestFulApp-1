package com.SBI.onlinepay.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.SBI.onlinepay.Entity.Student;

public interface Service {

	void addcustomer(Student student);

	List<Student> addlogin(String sn, String sa);

	Student getSingleStudent(int id);

	List<Student> getupdate(Student student);

	List<Student> getDelete(int id);
	
	void getFile(MultipartFile file);
}
