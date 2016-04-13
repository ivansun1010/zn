package com.iat.zn.craw.controller;

import com.iat.zn.craw.pipeline.RedisPipeline;
import com.iat.zn.craw.processor.DouyuProcessor;
import com.iat.zn.craw.processor.PandaProcessor;
import com.iat.zn.craw.util.UrlParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * Author: zhangxin
 * Date:   15-8-28
 */
@RestController
@RequestMapping(value = "v1")
public class RedisController {

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    public void setValue() {
        //Spider.create(new PandaProcessor()).addUrl(UrlParameter.URL_PANDA_YLLM).addPipeline(new RedisPipeline()).run();
        Spider.create(new DouyuProcessor()).addUrl(UrlParameter.URL_DOUYU_QMXX).addPipeline(new RedisPipeline()).thread(2).run();
    }
    @RequestMapping(value = "redis2", method = RequestMethod.GET)
    public void setValue2() {
        Spider.create(new PandaProcessor()).addUrl(UrlParameter.URL_PANDA_YLLM).addPipeline(new RedisPipeline()).run();
        //Spider.create(new DouyuProcessor()).addUrl(UrlParameter.URL_DOUYU_QMXX).addPipeline(new RedisPipeline()).thread(2).run();
    }
}
