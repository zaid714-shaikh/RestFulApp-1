package com.example.EmployeeService;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Entity.Employee;

public interface homeService {

	public void addEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public Employee getSingleEmployee(int id);

	public void deleteSingleEmployeeUsingID(int id);

	public void updateSingleEmployeeUsingID(Employee e);

	public List<Employee> getEmlpoyeeUsingAddress(String address);
	
	public void UploadFile(MultipartFile file);
}
