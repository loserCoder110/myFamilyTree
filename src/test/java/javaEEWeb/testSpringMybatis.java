package javaEEWeb;



import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldw.familyTree.test.domain.testCase;
import com.ldw.familyTree.test.service.testCaseService;

/**
 * 使用注解的方式测试mybatis和spring的整合是否成功
 * @author Mu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class testSpringMybatis {
	private static Logger logger = Logger.getLogger(testSpringMybatis.class);
	
	@Resource
	private testCaseService testCaseService = null;
	
	@Test
	public void test1(){	
		testCase test = testCaseService.getTestCaseById(1);
		System.out.println(test.getName());
		logger.info("名字："+test.getName());
	}
}
