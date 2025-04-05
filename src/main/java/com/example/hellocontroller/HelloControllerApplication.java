package com.example.hellocontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//프로젝트 이름 + Application : 프로그램을 시작을 담당하는 파일
@SpringBootApplication
@EntityScan(basePackages = "com.mysite.sbb") //h2에 내 엔티티가 등록되게 함
public class HelloControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloControllerApplication.class, args);
    }

}
