package com.SBI.onlinepay.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.SBI.onlinepay.Entity.Student;
import com.SBI.onlinepay.dao.daoservice;

@org.springframework.stereotype.Service
public class ServiceIMPL implements Service {

	@Autowired
	private daoservice dao;

	@Override
	public void addcustomer(Student student) {

		dao.addcustomer(student);
	}

	@Override
	public List<Student> addlogin(String sn, String sa) {
	
		return dao.addlogin(sn, sa);
	}

	@Override
	public Student getSingleStudent(int id) {
		
		return dao.getSingleStudent(id);
	}

	@Override
	public List<Student> getupdate(Student student) {
		
		return dao.getupdate(student);
	}

	@Override
	public List<Student> getDelete(int id) {
		
		return dao.getDelete(id);
	}

	@Override
	public void getFile(MultipartFile file) {

		dao.getFile(file);
		
	}

}
