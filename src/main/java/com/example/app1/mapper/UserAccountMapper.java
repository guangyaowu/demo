package com.example.app1.mapper;

import com.example.app1.model.UserAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountMapper {

    void insertSelective(UserAccount userAccount);

}
