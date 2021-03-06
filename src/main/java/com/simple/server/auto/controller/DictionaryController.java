package com.simple.server.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;

import com.simple.core.base.user.entity.*;
import com.simple.core.base.user.service.*;

import com.simple.server.bz.entity.*;
import com.simple.server.bz.service.*;

import com.simple.server.auto.entity.*;
import com.simple.server.auto.service.*;
import com.simple.server.auto.dao.*;


//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	@Autowired
	DictionaryService service;

	@Autowired
    DictionaryQueryDao queryDao;

    
    @Autowired
       private  CategoryService categoryService;
    


   
   @ResponseBody
   @RequestMapping(value = "/queryByCategory", method = RequestMethod.GET)
   public List<Dictionary> queryByCategory(@RequestParam("id") Long id) {
       List<Dictionary> result = service.findByCategory(id);
       return result;
   }

   


	@RequestMapping(value= "/", method=RequestMethod.GET)
    public String rootpage(){
    	       return "index";
    }
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Dictionary> findAll() {
		return service.findAll();
	}
	@ResponseBody
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public Dictionary findByKeyId(@PathVariable Long id) {
       	System.out.println("input param Id:" + id);
       	Dictionary result = service.findById(id);
    	return result;
    }
    @ResponseBody
    @RequestMapping(value = "/queryByNameLike/", method = RequestMethod.GET)
    public List<Dictionary> findByNameLike(@RequestParam("name") String name ) {
           	System.out.println("input param Name:" + name);
            return service.findByNameLike(name);

    }


    @ResponseBody
    @RequestMapping(value = "/queryByName", method = RequestMethod.GET)
    public List<Dictionary> findByName(@RequestParam("name") String name ) {
           	System.out.println("input param Name:" + name);
            return queryDao.findByName(name);

    }

    @ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Dictionary save2(@RequestBody Dictionary item) {

		System.out.println("input device params:" + item.toString());
		Dictionary result = service.save(item);
		System.out.println("output device result data:" + result.toString());
		return result;
	}



 	@ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Dictionary updateSave(@RequestBody Dictionary item,@PathVariable Long id) {

     	 System.out.println("input device params:" + item.toString());
     	 Dictionary result = service.save(item);
     	 System.out.println("output device result data:" + result.toString());
     	 return result;
    }



    @ResponseBody
   	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   	public Long remove(@PathVariable Long id) {
		service.remove(id);
        return id;
    }
    @ResponseBody
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public Long removeById(@PathVariable Long id) {
    	service.remove(id);
    	return id;
    }


   
   	@ResponseBody
    @RequestMapping(value = "/queryByCategoryName/", method = RequestMethod.GET)
    public List<Dictionary> findByCategoryName(@RequestParam("category") String categoryName) {
           	System.out.println("input param category:" + categoryName);
            Category cItem  = categoryService.findOneByName(categoryName);
            if(cItem==null){return null;}else{
                List<Dictionary> result = service.findByCategory(cItem.getId());
                return result;
            }
    }
    

    

}