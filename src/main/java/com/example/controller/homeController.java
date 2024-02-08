package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.EmployeeService.homeService;
import com.example.Entity.Employee;

@RestController
public class homeController {

	@Autowired
	private homeService hs;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String registerEmployee(@RequestBody Employee e) {
		hs.addEmployee(e);
		return "Employee Registerd!!";
	}

	@RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return hs.getAllEmployee();
	}

	@RequestMapping(value = "/getSingleID/{id}")
	public ResponseEntity<Employee> getSingleIDEmployee(@PathVariable("id") int id) {

		return new ResponseEntity(hs.getSingleEmployee(id), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/deleteEmployee/{id}")
	public ResponseEntity<String> deleteSingleEmployeeUsingID(@PathVariable("id") int id) {
		hs.deleteSingleEmployeeUsingID(id);
		return new ResponseEntity("Deleted Successfully!!", HttpStatus.OK);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public String updateSingleEmployee(@RequestBody Employee e) {
		hs.updateSingleEmployeeUsingID(e);
		return "updated Successfully!!";
	}

	@RequestMapping(value = "/address/{add}", method = RequestMethod.GET)
	public List<Employee> getEmployeeByAddress(@PathVariable("add") String e) {

		List<Employee> le = hs.getEmlpoyeeUsingAddress(e);
		return le;
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public String uploadFile(@RequestPart MultipartFile file) {
		
		hs.UploadFile(file);
		
		return "File uploaded !!! ";
	}

	
	
}
