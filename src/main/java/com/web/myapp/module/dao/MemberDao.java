package com.web.myapp.module.dao;

import com.web.myapp.module.entity.Member;
import com.web.myapp.module.entity.MemberExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MemberDao {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    
    Member selectByAccount(Map<String, String> map);
}