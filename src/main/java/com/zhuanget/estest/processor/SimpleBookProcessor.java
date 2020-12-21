package com.zhuanget.estest.processor;

import com.zhuanget.estest.constant.SimpleBookCrawlConst;
import com.zhuanget.estest.scheduler.CountableScheduler;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class SimpleBookProcessor implements PageProcessor {

    private Site site = Site.me().setRetrySleepTime(1000).setRetryTimes(3);
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex(SimpleBookCrawlConst.ARTICLE_URL).all());
        if (page.getUrl().equals(SimpleBookCrawlConst.BASE_URL)) {
            List<String> titleList = page.getHtml().xpath("//*[@class='title']/@href").all();
            List<String> fullTitleList = new ArrayList<>(titleList.size());
            for (String titleUrl : titleList) {
                fullTitleList.add(SimpleBookCrawlConst.BASE_URL + titleUrl);
            }
            page.addTargetRequests(fullTitleList);
            //load-more
//            page.addTargetRequest(SimpleBookCrawlConst.BASE_URL);
            page.setSkip(true);
        }else if (page.getUrl().regex(SimpleBookCrawlConst.ARTICLE_URL).match()) {
            page.putField("title", page.getHtml().xpath("//*[@class='_1RuRku']/text()").toString());
            page.putField("user", page.getHtml().xpath("//*[@class='_22gUMi']/text()").toString());
            List<String> imgList = page.getHtml().xpath("//*[@class=\"image-view\"]/img/@data-original-src").all();
            List<String> realImgList = new ArrayList<>(imgList.size());
            for (String imgUrl : imgList) {
                realImgList.add("https:" + imgUrl);
            }
            page.putField("imageUrls", realImgList);
        }else {
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new SimpleBookProcessor())
                .addUrl(SimpleBookCrawlConst.BASE_URL)
                .setScheduler(new CountableScheduler().setCount(30))
//                .addPipeline(new MySqlPipeline())
//                .addPipeline(new DownloadImagePipeline())
                .addPipeline(new JsonFilePipeline("F:\\webmagic\\"))
                .thread(5)
                .run();
    }
}
