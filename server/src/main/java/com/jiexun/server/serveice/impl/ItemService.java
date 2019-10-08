package com.jiexun.server.serveice.impl;

import com.jiexun.model.entity.ItemKill;
import com.jiexun.model.mapper.ItemKillMapper;
import com.jiexun.model.mapper.ItemMapper;
import com.jiexun.server.serveice.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * Created by Administrator on 2019-09-30.
 */
@Service
public class ItemService implements IItemService {

    private static final Logger logger= LoggerFactory.getLogger(IItemService.class);

    @Autowired
    private ItemKillMapper itemKillMapper;


    /**
     * 获得待秒杀商品列表
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemKill> getKillItems() throws Exception{
        return itemKillMapper.selectAll();
    }

    /**
     * 获得待秒杀商品详情
     * @return
     * @throws Exception
     */
    @Override
    public ItemKill selectById(Integer id) throws Exception{
     ItemKill itemKill =  itemKillMapper.selectById(id);
       if(itemKill==null){
           throw  new Exception("秒杀商品不存在");
       }
        return itemKill;
    }





}
