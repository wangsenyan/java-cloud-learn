package com.wsy.cloud.oauth.mapper;

import com.wsy.cloud.oauth.entry.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UmsMemberMapper {
    @Select("select * from ums_member where username=#{username}")
    public UmsMember selectByName(String username);
}
