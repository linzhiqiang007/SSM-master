package com.fuzhu.dao;

import com.fuzhu.entity.Score;
import com.fuzhu.entity.User;
import com.fuzhu.entity.vo.UserScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface UserDao {
    User login(String account);
    //根据id查人
    User queryById(long id);
    //查询所有用户
    List<User> queryAll();
    //删除用户
    int deleteUser(long id);
    //增加用户
    int insertUser(User user);
    //修改用户积分
    void updateScore(@Param("id") long id, @Param("scoreCount") int scoreCount);
    //排行榜的查找topN
    List<User> queryTopN();
    //根据省份查用户
    List<User> findUserByProvince(@Param("province") String province);
    //查询积分的所有信息
    List<Score> FindAll();
    //查询指定用户积分的信息
    List<Score> FindAllByAccount(String account);
    //用户登录验证
    int getFindUserByaccoutAndPassword(User user);
}
