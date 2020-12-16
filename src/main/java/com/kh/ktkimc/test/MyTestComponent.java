package com.kh.ktkimc.test;

import org.springframework.stereotype.Component;

@Component(value="testcomp")
public class MyTestComponent {
	public void testFunc() {
		System.out.println("테스트 메소드 입니다.");
	}
}
