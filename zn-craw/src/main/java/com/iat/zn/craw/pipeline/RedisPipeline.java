package com.iat.zn.craw.pipeline;

import com.iat.zn.craw.domain.WinInfo;
import com.iat.zn.craw.util.JacksonMapperUtil;
import com.iat.zn.craw.util.RedisParameter;
import com.iat.zn.craw.util.SpringApplicationContextHolder;
import com.iat.zn.craw.util.UrlParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 *
 */
@Component
public class RedisPipeline implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedisTemplate redisTemplate;

    @Override
    public synchronized void process(ResultItems resultItems, Task task) {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate) SpringApplicationContextHolder.getContext().getBean("redisTemplate");
        }
        String key = null;
        if (UrlParameter.URL_PANDA_YLLM.equals(resultItems.getRequest().getUrl())) {
            key = RedisParameter.PANDA_YLLM;
        } else if (UrlParameter.URL_PANDA_LOL.equals(resultItems.getRequest().getUrl())) {
            key = RedisParameter.PANDA_LOL;
        } else if (UrlParameter.URL_DOUYU_QMXX.equals(resultItems.getRequest().getUrl())) {
            key = RedisParameter.DOUYU_QMXX;
        } else if (UrlParameter.URL_DOUYU_LOL.equals(resultItems.getRequest().getUrl())) {
            key = RedisParameter.DOUYU_LOL;
        }
        List<WinInfo> winInfoList = (List<WinInfo>) resultItems.get("repo");
        redisTemplate.opsForValue().set(key, JacksonMapperUtil.listToJson(winInfoList));
        logger.info(key+"=========>success");
    }

}
