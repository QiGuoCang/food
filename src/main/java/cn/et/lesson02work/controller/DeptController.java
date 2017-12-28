package cn.et.lesson02work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lesson02work.entity.Emp;
import cn.et.lesson02work.entity.Result;
import cn.et.lesson02work.entity.TreeNode;
import cn.et.lesson02work.service.DeptService;
import cn.et.lesson02work.service.EmpService;
import cn.et.lesson02work.utils.PageTools;




@RestController
public class DeptController {
	@Autowired
	EmpService service;
	@Autowired
	DeptService ser;
	@RequestMapping("/queryDept")
	public List<TreeNode> queryDept(Integer id){
		if(id==null){
			id=0;
		}
		return ser.queryTreeNode(id);
		
	}
	

	@RequestMapping("/queryEmp")
	public List<Emp> queryEmp(Integer id){
		System.out.println("Sdfds");
		return service.queryEmp(id);
	}
	
	

	@RequestMapping("/queryEmp1")
	public PageTools queryEmp1(String ename,Integer page,Integer rows){
		System.out.println("sdf");
		return service.queryEmp1(ename, page, rows);
	}
	
	//���

	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public Result saveStudent(Emp em,MultipartFile aa){
		Result r = new Result();
		r.setCode(1);
		try {
			
			service.saveEmp(em);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
	}
	//ɾ��

	@RequestMapping(value="/emp/{eid}",method=RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable String eid,Integer page,Integer rows){
		String [] temp = eid.split(",");
		Result r = new Result();
		r.setCode(1);
		try {
			for (String str : temp) {
				service.deleteEmp(Integer.parseInt(str));
			}
//			String str = null;
//			str.toString();
			
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
		
		}
	
	//�޸�

	@RequestMapping(value="/emp/{eid}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer eid, Emp emp){
		emp.setId(eid);
		Result r = new Result();
		r.setCode(1);
		try {
			service.updateEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
		
		}
}