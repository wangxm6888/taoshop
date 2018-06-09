package com.huatian.taoshop.service;

import java.util.List;

import com.huatian.common.pojo.EUTreeNode;

public interface ItemCatService {
	
	List<EUTreeNode> getCatList(long parentId);

}
