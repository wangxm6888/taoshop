package com.huatian.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatian.taoshop.mapper.TbItemMapper;
import com.huatian.taoshop.pojo.TbItem;
import com.huatian.taoshop.pojo.TbItemExample;

public class TestPageHelper {
	
	@Test
	public void testPageHelper()
	{
		//创建一个spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		//从spring容器中获取Mapper的代理对象
		TbItemMapper tbItemMapper = ac.getBean(TbItemMapper.class);
		//执行查询，并分页
		TbItemExample tbItemExample = new TbItemExample();
		//分页处理
		PageHelper.startPage(1, 10);
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		for(TbItem tbItem : list)
		{
			System.out.println(tbItem.getTitle());
			
			System.out.println();
		}
		//获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品 ： " + total);
	}

}
