package com.huatian.taoshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huatian.common.pojo.EUTreeNode;
import com.huatian.taoshop.mapper.TbItemCatMapper;
import com.huatian.taoshop.mapper.TbItemCatMapper;
import com.huatian.taoshop.pojo.TbItemCat;
import com.huatian.taoshop.pojo.TbItemCatExample;
import com.huatian.taoshop.pojo.TbItemCatExample.Criteria;
import com.huatian.taoshop.service.ItemCatService;
import com.mysql.fabric.xmlrpc.base.Array;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodeList
		for(TbItemCat tbItemCat : list)
		{
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		return resultList;
	}

}
