package cn.et.lesson02work.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson02work.dao.EmpMapper;
import cn.et.lesson02work.entity.Emp;
import cn.et.lesson02work.entity.EmpExample;
import cn.et.lesson02work.service.EmpService;
import cn.et.lesson02work.utils.PageTools;



@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper emp;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */

	
	public List<Emp> queryEmp(Integer id){
		EmpExample ee = new EmpExample();
		if(id!=null){
				ee.createCriteria().andDeptidEqualTo(id);
			
		}
		return emp.selectByExample(ee);
		
	}
	/**
	 * ģ���ѯ
	 * @param sname
	 * @param page
	 * @param rows
	 * @return
	 */
	public  PageTools queryEmp1(String ename,Integer page,Integer rows){
		if(ename==null){
			ename="";
		}
		//����sql����ѯ��¼��
		EmpExample se = new EmpExample();
		
		se.createCriteria().andEnameLike("%"+ename+"%");
		
		 int total= (int)emp.countByExample(se);
		//limit ��ʼλ��  ��¼����
		PageTools pts = new PageTools(page,total,rows);
		RowBounds rb=new RowBounds(pts.getStartIndex()-1, rows);
		List<Emp> studentList = emp.selectByExampleWithRowbounds(se, rb);
		pts.setRows(studentList);
		return pts;
	}
	
	public void deleteEmp(Integer eid){
		emp.deleteByPrimaryKey(eid);
	}
	
	public void updateEmp(Emp em){
		emp.updateByPrimaryKey(em);
		
	}
	
	public void saveEmp(Emp em){
		emp.insertSelective(em);
	}
}
