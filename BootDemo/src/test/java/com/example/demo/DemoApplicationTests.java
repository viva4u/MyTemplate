package com.example.demo;

import com.example.demo1.BootCompont1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	BootCompont comp;
	@Autowired
	BootCompont1 comp1;
	@Test
	public void contextLoads() {
		this.comp.print();
		this.comp1.print();
	}

}
