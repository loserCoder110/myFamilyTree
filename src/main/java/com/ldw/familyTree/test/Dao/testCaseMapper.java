package com.ldw.familyTree.test.Dao;
import com.ldw.familyTree.test.domain.testCase;
import com.ldw.familyTree.persistence.annotation.MybatisDao;

@MybatisDao
public interface testCaseMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(testCase record);
    int insertSelective(testCase record);
    testCase selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(testCase record);
    int updateByPrimaryKey(testCase record);
}