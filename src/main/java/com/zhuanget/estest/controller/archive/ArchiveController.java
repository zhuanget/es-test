package com.zhuanget.estest.controller.archive;

import com.alibaba.fastjson.JSONObject;
import com.zhuanget.estest.service.ArchiveService;
import com.zhuanget.estest.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 档案相关controller
 * @author Zhuang_ET
 * @since 2020-09-29 19:20:10
 */
@RestController("/archive")
@RequestMapping("/archive")
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @GetMapping("/test/insert")
    public BaseResponse insertTest() {
        JSONObject data = new JSONObject();
        data.put("aid", "4627795234942617270");
        data.put("age", "23");
        data.put("gender", "male");
        data.put("avatarUrl", "/ifstore000001/M00/C9/B5/wKgNF19EqMyAUJ_mAAAWUsetXsc415.jpg");
        archiveService.insertData(data, 1L);
        return BaseResponse.success(data);
    }
}
