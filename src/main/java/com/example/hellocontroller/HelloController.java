package com.example.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //HelloController 클래스가 컨트롤러의 기능을 수행한다는 것을 알려준다.
public class HelloController {

    @GetMapping("/sbb")
    @ResponseBody
    public String sbb(){
        return "안녕하세요. sbb에 오신것을 환영합니다.";
    }
}
