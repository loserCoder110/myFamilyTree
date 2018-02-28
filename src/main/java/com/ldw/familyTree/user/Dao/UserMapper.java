package com.ldw.familyTree.user.Dao;

import com.ldw.familyTree.persistence.annotation.MybatisDao;
import com.ldw.familyTree.user.domain.User;

@MybatisDao
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}