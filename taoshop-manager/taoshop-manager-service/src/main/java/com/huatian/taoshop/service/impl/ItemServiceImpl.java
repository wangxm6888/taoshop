package com.huatian.taoshop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huatian.taoshop.mapper.TbItemMapper;
import com.huatian.taoshop.pojo.TbItem;
import com.huatian.taoshop.pojo.TbItemExample;
import com.huatian.taoshop.pojo.TbItemExample.Criteria;
import com.huatian.taoshop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null && list.size() > 0)
		{
			TbItem tbItem = list.get(0);
			return tbItem;
		}
		return null;
	}

}
