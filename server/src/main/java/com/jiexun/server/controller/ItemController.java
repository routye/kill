package com.jiexun.server.controller;

import com.jiexun.model.entity.ItemKill;
import com.jiexun.server.serveice.IItemService;
import com.jiexun.server.serveice.impl.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2019-09-30.
 */

@Controller
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private static final String prefix="item";

    @Autowired
    private IItemService iItemService;
    /**
     * 获取商品列表页面
     * @return
     */
    @RequestMapping(value = {"/","/index",prefix+"/index"},method = RequestMethod.GET)
    public String list(ModelMap modelMap){

        try {
            //获得待秒杀商品列表
         List<ItemKill> list =   iItemService.getKillItems();

         modelMap.put("list",list);

         logger.info("获得待秒杀商品列表-数据 {}",list);

        }catch (Exception e){
            logger.error("获得待秒杀商品列表异常");
            return "redirect:/base/error";
        }
        return "list";
    }

    /**
     * 获取商品详情
     * @return
     */
    @RequestMapping(value = prefix+"/detail/{id}",method = RequestMethod.GET)
    public String getItemKillById(@PathVariable Integer id,ModelMap modelMap){

        if(id == null ||id<=0){
            return "redirect:/base/error";
        }
        try {
           modelMap.put("detail",iItemService.selectById(id)) ;
        }catch (Exception e){
            logger.error("获得待秒杀商品详情异常-id={}",id,e.fillInStackTrace());
        }
        return "info";
    }
}
