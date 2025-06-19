package example.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");//data가 키, attributeVlue가 값
        return "hello"; //hello 파일에 가서 랜더링 하라는 뜻
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 헤더부와 바디부가 있는데 바디부에 직접 넣어주겟다. 소스코드로 보면 html 소스가 없이 바로 웹에 뜨는 것을 확인할 수 있다.
    public String helloString(@RequestParam("name") String name){
        return "hello" +name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        //프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
