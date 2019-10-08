package com.jiexun.server.serveice;

import com.jiexun.model.entity.ItemKill;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019-09-30.
 */

public interface IItemService {

    List<ItemKill> getKillItems() throws Exception;

    ItemKill selectById(Integer id) throws Exception;
}
