package com.SBI.onlinepay.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.SBI.onlinepay.Entity.FileUpload;
import com.SBI.onlinepay.Entity.Student;

@Repository
public class DaoIMPL implements daoservice {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addcustomer(Student student) {
		Session s = sf.openSession();
		s.save(student);
		s.beginTransaction().commit();
		System.out.println("Data inserted");

	}

	@Override
	public List<Student> addlogin(String sn, String sa) {
		Session s = sf.openSession();
		List<Student> sl = new ArrayList<Student>();
		if ("admin".equals(sn) && "admin".equals(sa)) {
			Query<Student> query = s.createQuery("from Student");
			sl = query.getResultList();

		} else {
			try {
				Query<Student> q = s.createQuery("from Student where sname=:sn and saddress=:sa");
				q.setParameter("sn", sn);
				q.setParameter("sa", sa);
				Student st = q.getSingleResult();
				sl.add(st);
			} catch (Exception e) {
				System.out.println(e);
				return sl;
			}

		}
		return sl;
	}

	@Override
	public Student getSingleStudent(int id) {
		Session s = sf.openSession();
		Query<Student> query = s.createQuery("from Student where sid=:id");
		query.setParameter("id", id);
		Student student = query.getSingleResult();
		return student;
	}

	@Override
	public List<Student> getupdate(Student student) {
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(student);

		s.getTransaction().commit();
		System.out.println("Data Updated!!");

		Query<Student> query = s.createQuery("from Student");
		List<Student> slist = query.getResultList();
		return slist;
	}

	@Override
	public List<Student> getDelete(int id) {
		Session s = sf.openSession();
		s.beginTransaction();
		Student student = s.get(Student.class, id);
		s.delete(student);

		s.getTransaction().commit();
		System.out.println("Data deleted!!");

		Query<Student> query = s.createQuery("from Student");
		List<Student> slist = query.getResultList();
		return slist;

	}

	@Override
	public void getFile(MultipartFile file) {
		Session s = sf.openSession();
		try {
			FileUpload f = new FileUpload();
			f.setFname(file.getOriginalFilename());
			f.setFdata(file.getBytes());
			s.save(file);
			s.beginTransaction().commit();
			System.out.println(" File Uploaded");
		} catch (Exception e) {

			System.out.println(e);
		}

	}

}
