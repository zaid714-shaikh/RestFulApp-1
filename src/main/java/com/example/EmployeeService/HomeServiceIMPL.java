package com.example.EmployeeService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Entity.Employee;
import com.example.Entity.fileInfo;
import com.example.Repository.EmployeeRepository;
import com.example.Repository.FileRepository;

@Service
public class HomeServiceIMPL implements homeService {

	@Autowired
	private EmployeeRepository er;

	@Autowired
	private FileRepository fr;

	@Override
	public void addEmployee(Employee e) {

		System.out.println(e);
		er.save(e);
		System.out.println("Data Saved");
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> emp = (List<Employee>) er.findAll();
		return emp;
	}

	@Override
	public Employee getSingleEmployee(int id) {

		Employee emp = er.findById(id).get();
		return emp;
	}

	@Override
	public void deleteSingleEmployeeUsingID(int id) {

		Employee emp = (Employee) er.findById(id).get();
		er.delete(emp);

	}

	@Override
	public void updateSingleEmployeeUsingID(Employee emp) {

		er.save(emp);

	}

	@Override
	public List<Employee> getEmlpoyeeUsingAddress(String address) {

		List<Employee> le = er.findByEaddress(address);
		return le;

	}

	@Override
	public void UploadFile(MultipartFile file) {

		try {
			fileInfo f = new fileInfo();
			f.setFname(file.getOriginalFilename());
			f.setFdata(file.getBytes());
			fr.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
