package com.fuzhu.service;

import com.fuzhu.entity.Score;
import com.fuzhu.entity.User;
import com.fuzhu.entity.vo.UserScore;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface UserService {
    //登录
    User login(String account);
    //根据id查人
    User queryById(long id);
    //查询所有用户
    List<User> queryAll();
    //删除用户
    int deleteUser(long id);
    //增加用户
    int insertUser(User user);
    //排行榜的查找topN
    List<User> queryTopN();
    //根据省份查用户
    List<User> findUserByProvince(String province);
    //查询所有积分用户的信息
    List<Score> FindAll();
    //根据指定用户名查询用户全部积分信息
    List<Score> FindAllByAccount(String account);
    //用户登录验证
    long getFindUserByaccoutAndPassword(User user);
}
