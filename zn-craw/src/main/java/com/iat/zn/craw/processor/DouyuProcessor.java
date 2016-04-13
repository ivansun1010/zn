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
public class DouyuProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.douyu\\.com/directory/game/qmxx").all());
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.douyu\\.com/directory/game/LOL").all());
        List<WinInfo> winInfoList = new ArrayList<WinInfo>();
        for(int i = 1;i<11;i++){
            WinInfo winInfo = new WinInfo();
            winInfo.setUserName(page.getHtml().xpath("//ul[@id='live-list-contentbox']//li["+i+"]//a//div[@class='mes']//p//span[1]/text()").toString());
            String watchNumStr = page.getHtml().xpath("//ul[@id='live-list-contentbox']//li["+i+"]//a//div[@class='mes']//p//span[2]/text()").toString();
            int watchNum=0;
            if(watchNumStr.endsWith("万")){
                if (watchNumStr.split("\\.").length!=2){
                    watchNum = Integer.valueOf(watchNumStr.split("万")[0])*10000;
                }else{
                    watchNum = Integer.valueOf(watchNumStr.split("\\.")[0])*10000;
                }
            }else{
                watchNum = Integer.valueOf(watchNumStr);
            }
            winInfo.setWatchNum(watchNum);
            winInfo.setWinName(page.getHtml().xpath("//ul[@id='live-list-contentbox']//li["+i+"]//a//div[@class='mes']//div[@class='mes-tit']//h3[@class='ellipsis']/text()").toString());
            winInfo.setPicUrl(page.getHtml().xpath("//ul[@id='live-list-contentbox']//li["+i+"]//a//span[@class='imgbox']//img/@data-original").toString());
            winInfo.setWatchUrl( page.getHtml().xpath("//ul[@id='live-list-contentbox']//li["+i+"]//a/@href").toString());
            winInfoList.add(winInfo);
        }
        page.putField("repo", winInfoList);
    }

    @Override
    public Site getSite() {
        return site;
    }

}
