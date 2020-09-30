package com.zhuanget.estest.controller.test;

import com.zhuanget.estest.exception.NotAuthorizedException;
import com.zhuanget.estest.vo.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 16:25:03
 */
@RestController("/test")
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "success, et!";
    }

    @GetMapping("/authorized")
    public BaseResponse exceptionHandlerTest() {
        throw new NotAuthorizedException("验证失败");
    }
}
