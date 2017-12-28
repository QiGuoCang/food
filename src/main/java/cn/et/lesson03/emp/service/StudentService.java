package cn.et.lesson03.emp.service;

import cn.et.lesson03.emp.Tools.PageTools;
import cn.et.lesson03.emp.entity.Student;


public interface StudentService {

	public abstract PageTools queryStudent(String sname,Integer page,Integer rows);
	public void deleteStudent(Integer sid);
	public void updateStudent(Student stu);
	public void saveStudent(Student stu);
}