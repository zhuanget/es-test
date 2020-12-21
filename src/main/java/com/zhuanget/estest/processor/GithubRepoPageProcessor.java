package com.zhuanget.estest.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://www\\.jianshu\\.com/\\w+/\\w+)").all());
        page.putField("title", page.getHtml().xpath("//div[@id='list-container]/ul/li/div/a/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor())
                .addUrl("https://www.jianshu.com/")
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5).run();
    }
}
