package com.jiexun.server.controller;

import com.jiexun.api.enums.StatusCode;
import com.jiexun.api.response.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019-09-29.
 */
@Controller
@RequestMapping("base")
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @GetMapping("/welcome")
    public String welcome(String pram, ModelMap modelMap){
        if(StringUtils.isEmpty(pram)){
            pram="这是welcome!";
        }
        modelMap.put("pram",pram);
        return "welcome";
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String getData(String data){
        if(StringUtils.isEmpty(data)){
            data="这是data";
        }
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/response",method = RequestMethod.GET)
    public BaseResponse response(String data){
        BaseResponse response = new BaseResponse(StatusCode.Success);

        if(StringUtils.isEmpty(data)){
            data="这是data";
        }
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){

        return "error";
    }
}
