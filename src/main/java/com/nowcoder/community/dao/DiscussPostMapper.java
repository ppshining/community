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

    /**
     * 首页查询不用userId 个人主页查询时需要，考虑到将来功能的适用程度 ==》动态SQL
     * @param userId 用户id（首页不需要）
     * @param offset 起始偏移量
     * @param limit 每页的条数
     * @return 该用户该页的帖子列表
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * Param注解用于给参数起别名
     * 如果只有一个参数 并且在<if>里使用 则必须加别名（SQL里有动态条件）
     * @param userId 用户id
     * @return 该用户的帖子总条数
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);
}
