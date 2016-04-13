package com.iat.zn.show.service;

import com.iat.zn.show.domain.WinInfo;
import com.iat.zn.show.util.JacksonMapperUtil;
import com.iat.zn.show.util.RedisParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cnbjpuhui-384 on 2016/4/9.
 */
@Service
public class ShowService {
    @Autowired
    private RedisTemplate redisTemplate;

    public List<WinInfo> getYLLMList() {
        List<WinInfo> list = new ArrayList<WinInfo>();
        List<WinInfo> qmxxList = JacksonMapperUtil.jsonToList(redisTemplate.opsForValue().get(RedisParameter.DOUYU_QMXX).toString(),WinInfo.class);
        List<WinInfo> yllmList = JacksonMapperUtil.jsonToList(redisTemplate.opsForValue().get(RedisParameter.PANDA_YLLM).toString(), WinInfo.class);
        list.addAll(qmxxList);
        list.addAll(yllmList);
        Collections.sort(list);
        return list;
    }

    public List<WinInfo> getLOLList() {
        List<WinInfo> list = new ArrayList<WinInfo>();
        List<WinInfo> qmxxList = JacksonMapperUtil.jsonToList(redisTemplate.opsForValue().get(RedisParameter.DOUYU_LOL).toString(),WinInfo.class);
        List<WinInfo> yllmList = JacksonMapperUtil.jsonToList(redisTemplate.opsForValue().get(RedisParameter.PANDA_LOL).toString(), WinInfo.class);
        list.addAll(qmxxList);
        list.addAll(yllmList);
        Collections.sort(list);
        return list;
    }
}
