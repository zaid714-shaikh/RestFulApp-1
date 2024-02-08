package com.SBI.onlinepay.Controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.SBI.onlinepay.Entity.Student;
import com.SBI.onlinepay.Service.Service;

@Controller
public class HomeController {

	@Autowired
	private Service hs;

	@RequestMapping("/")
	public String getpage() {
		return "index";
	}

	@RequestMapping("reg")
	public String getRegister(@ModelAttribute Student s) {
		System.out.println("student data:-" + s);
		hs.addcustomer(s);
		return "login";
	}

	@RequestMapping("log")
	public String getLogin(@RequestParam("sname") String sn, @RequestParam("saddress") String sa, Model model) {
		List<Student> sl = hs.addlogin(sn, sa);
		if (sl != null && !sl.isEmpty()) {
			model.addAttribute("slist", sl);
			return "data";
		} else {
			String message = "invlaid Username and password";
			model.addAttribute("msg", message);
			return "login";
		}

	}

	@RequestMapping("edit")
	public String getID(@RequestParam("sid") int id, Model m) {
		Student student = hs.getSingleStudent(id);
		m.addAttribute("singleStudent", student);
		return "updatePage";
	}

	@RequestMapping("up")
	public String getUpdate(@ModelAttribute Student student, Model model) {
		List<Student> sl = hs.getupdate(student);
		if (sl != null) {
			model.addAttribute("slist", sl);
			return "data";
		}
		return "login";
	}

	@RequestMapping("del")
	public String getDelete(@RequestParam("sid") int id, Model model) {
		List<Student> sl = hs.getDelete(id);
		if (sl != null) {
			model.addAttribute("slist", sl);
			return "data";
		}
		return "login";
	}

	@RequestMapping("fp")
	public String getFile(@RequestPart MultipartFile file) {
		hs.getFile(file);
		return "index";
	}

}
