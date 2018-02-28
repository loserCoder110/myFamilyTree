package com.ldw.familyTree.test.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldw.familyTree.test.Dao.testCaseMapper;
import com.ldw.familyTree.test.domain.testCase;
import com.ldw.familyTree.test.service.testCaseService;

@Service("testCaseService123")
public class testCaseServiceImpl implements testCaseService {
	
	@Resource
	public testCaseMapper testDao;

	public testCase getTestCaseById(Integer id) {
		
		return this.testDao.selectByPrimaryKey(id);
	}

}
