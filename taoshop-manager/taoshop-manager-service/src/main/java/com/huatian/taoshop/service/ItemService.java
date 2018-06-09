package com.huatian.taoshop.service;

import com.huatian.common.pojo.EUDataGridResult;
import com.huatian.taoshop.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	
	EUDataGridResult getItemList(int page,int rows);;

}
