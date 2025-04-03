package com.example.hellocontroller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //hello, lombok 필드가 필요로 하는 생성자가 롬복에 의해 자동으로 생성된다.
@Getter
public class HelloLombok {
    //final이 붙어야만 생성자가 생성된다. 자료형과 변수명을 변경할 수 없게 한다.
    //final의 특성으로 인해 Setter는 사용하지 않는다.
    private final String hello;
    private final int lombok;

    // 롬복을 사용하지 않을 경우 작성해야 하는 코드
//    public HelloLombok(String hello, int lombok) {
//        this.hello = hello;
//        this.lombok = lombok;
//    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
