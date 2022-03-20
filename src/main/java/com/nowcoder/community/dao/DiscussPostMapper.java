package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hpr
 * @date 2022-03-10 10:08
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit); // 首页查询不用userId 个人主页查询时需要，考虑到将来功能的适用程度 ==》动态SQL

    int selectDiscussPostRows(@Param("userId") int userId); // 要在SQL里用到动态的条件，且方法里只有一个参数，这个参数必须起别名不然会报错

}
