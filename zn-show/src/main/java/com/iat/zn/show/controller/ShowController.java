package com.iat.zn.show.controller;

import com.iat.zn.show.domain.WinInfo;
import com.iat.zn.show.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Author: zhangxin
 * Date:   15-8-28
 */
@Controller
@RequestMapping(value = "show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @RequestMapping(value = "list")
    public String showList(Map<String, Object> model){
        List<WinInfo> yllmList = showService.getYLLMList();
        List<WinInfo> lolList = showService.getLOLList();
        model.put("yllmList",yllmList);
        model.put("lolList",lolList);
        return "show";
    }
}
