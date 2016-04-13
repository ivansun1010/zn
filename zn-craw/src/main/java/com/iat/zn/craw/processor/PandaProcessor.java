package com.iat.zn.craw.processor;

import com.iat.zn.craw.domain.WinInfo;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.5.1
 */
@Service
public class PandaProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.panda\\.tv/cate/yzdr").all());
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.panda\\.tv/cate/lol").all());
        List<WinInfo> winInfoList = new ArrayList<WinInfo>();
        for(int i = 1;i<11;i++){
            WinInfo winInfo = new WinInfo();
            winInfo.setUserName(page.getHtml().xpath("//ul[@id='sortdetail-container']//li["+i+"]//a//div[@class='video-info']//span[@class='video-nickname']/tidyText()").toString());
            String watchNumStr = page.getHtml().xpath("//ul[@id='sortdetail-container']//li[" + i + "]//a//div[@class='video-info']//span[@class='video-number']/tidyText()").toString();
            int watchNum=0;
            if(watchNumStr.endsWith("万")){
                watchNum = Integer.valueOf(watchNumStr.split("\\.")[0])*10000;
            }else{
                watchNum = Integer.valueOf(watchNumStr);
            }
            winInfo.setWatchNum(watchNum);
            winInfo.setWinName(page.getHtml().xpath("//ul[@id='sortdetail-container']//li["+i+"]//a//div[@class='video-title']/tidyText()").toString());
            winInfo.setPicUrl(page.getHtml().xpath("//ul[@id='sortdetail-container']//li["+i+"]//a//div[@class='video-cover']//img/@data-original").toString());
            winInfo.setWatchUrl("http://www.panda.tv/" + page.getHtml().xpath("//ul[@id='sortdetail-container']//li["+i+"]//a/@data-id").toString());
            winInfoList.add(winInfo);
        }
        page.putField("repo", winInfoList);
    }

    @Override
    public Site getSite() {
        return site;
    }

}
