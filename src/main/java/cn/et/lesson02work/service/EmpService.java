package cn.et.lesson02work.service;

import java.util.List;

import cn.et.lesson02work.entity.Emp;
import cn.et.lesson02work.utils.PageTools;

public interface EmpService {
	
	public List<Emp> queryEmp(Integer id);
	public  PageTools queryEmp1(String ename,Integer page,Integer rows);
	
	public void updateEmp(Emp em);
	public void deleteEmp(Integer eid);
	
	public void saveEmp(Emp em);
}
