package example.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeConroller {
    @GetMapping("/")
    public String home() {
        return "home";
    } //컨트롤러로 먼저 주소를 찾고 없으면 index파일을 찾아간다.
}
