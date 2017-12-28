package cn.et.lesson02work.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson02work.dao.DeptMapper;
import cn.et.lesson02work.entity.Dept;
import cn.et.lesson02work.entity.DeptExample;
import cn.et.lesson02work.entity.TreeNode;
import cn.et.lesson02work.service.DeptService;


@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper sm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	public  List<TreeNode> queryTreeNode(Integer pid){
		DeptExample se = new DeptExample();
		se.createCriteria().andPidEqualTo(pid);
		List<Dept> detp = sm.selectByExample(se);
		List<TreeNode> deptList = new ArrayList<TreeNode>();
		for(Dept d:detp){
				TreeNode tn = new TreeNode();
				tn.setId(d.getId());
				tn.setText(d.getDname());
				//�жϵ�ǰ�ڵ��Ƿ�����ӽڵ�
				if(queryTreeNode(d.getId()).size()==0){
					tn.setState("open");
				}
				deptList.add(tn);
			
		}
		return deptList;
	}
}
