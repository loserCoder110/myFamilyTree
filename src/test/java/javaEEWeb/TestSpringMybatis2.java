package javaEEWeb;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldw.familyTree.test.service.testCaseService;

/**
 * ʹ�÷�ע��ķ�ʽ����spring��Mybatis�������Ƿ�ɹ�
 * @author Mu
 *
 */
public class TestSpringMybatis2 {
	
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		testCaseService tcs = (testCaseService)ac.getBean("testCaseService123");
		System.out.println(tcs.getTestCaseById(2).getName());
	}
	
	

}
