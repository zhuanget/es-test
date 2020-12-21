package com.zhuanget.estest.pipeline;

import com.zhuanget.estest.util.DownloadUtil;
import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class DownloadImagePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        String user = resultItems.get("user");
        List<String> urls = resultItems.get("imageUrls");
        if (CollectionUtils.isEmpty(urls)) {
            return;
        }
        for (String url : urls) {
            DownloadUtil.downloadPicToLocal(url, user);
        }
    }
}
