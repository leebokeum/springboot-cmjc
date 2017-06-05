package info.ildong.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ildong.com.dao.ItemDao; 
import info.ildong.com.vo.Item;

@Controller
public class InitController {
	
	@Autowired
	ItemDao itemDao;
	
	@RequestMapping("/save")
	@ResponseBody
	public Item save(){
		 Item item = new Item(); 
		 item.setItemName("computer");
		 item.setItemNo(1);  
		return itemDao.save(item);
	}
	
	@RequestMapping("/save/{itemName}/{itemNo}")
	@ResponseBody
	public Item saveByItem(@PathVariable String itemName, @PathVariable int itemNo){
		 Item item = new Item(); 
		 item.setItemName(itemName);
		 item.setItemNo(itemNo);  
		return  itemDao.save(item) ;
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public List<Item> getItem(){  
		return itemDao.findAll();
	}
	
	@RequestMapping("/getId/{id}")
	@ResponseBody
	public Item getItemById(@PathVariable int id){  
		return itemDao.findOne(id);
	}
	
	
	@RequestMapping("/getAll")
	@ResponseBody
	public Page<Item> getItemByAllPage(@PageableDefault( sort = { "id" }, direction = Direction.DESC, size = 2) Pageable pageable ){  
		Page<Item> page = itemDao.findAll(pageable);  
		return page;
	}
	
	@RequestMapping("/view") 
	public String initView(Model model, @PageableDefault( sort = { "id" }, direction = Direction.DESC, size = 2) Pageable pageable ){  
		Page<Item> page = itemDao.findAll(pageable);  
		model.addAttribute("page", page); 
		return "home";
	}
 
}
