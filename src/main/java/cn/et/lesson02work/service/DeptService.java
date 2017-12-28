package cn.et.lesson02work.service;

import java.util.List;

import cn.et.lesson02work.entity.TreeNode;

public interface DeptService {
	

	public List<TreeNode> queryTreeNode(Integer pid);
	

}