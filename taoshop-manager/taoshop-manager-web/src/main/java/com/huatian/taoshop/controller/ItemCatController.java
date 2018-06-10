package com.huatian.taoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatian.common.pojo.EUTreeNode;
import com.huatian.taoshop.service.ItemCatService;

@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping(value = "/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId)
	{
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}

}
