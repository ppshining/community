package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hpr
 * @date 2022-03-23 17:05
 */
@Mapper
public interface MessageMapper {

    /**
     * 查询当前用户的会话列表 针对每个会话只返回一条最新的私信
     * @param userId 用户id
     * @param offset 分页offset
     * @param limit 分页limit
     * @return 该页面的私信列表（每个会话只有最新的一条）
     */
    List<Message> selectConversations(int userId, int offset, int limit);

    /**
     * 查询当前用户的会话数量
     * @param userId 用户id
     * @return 该用户的会话数量
     */
    int selectConversationCount(int userId);

    /**
     * 查询某个会话所包含的私信列表
     * @param conversationId 会话id
     * @param offset 分页offset
     * @param limit 分页limit
     * @return 该会话在该页面的私信列表
     */
    List<Message> selectLetters(String conversationId, int offset, int limit);

    /**
     * 查询某个会话所包含的私信数量
     * @param conversationId 会话id
     * @return 该会话的私信数量
     */
    int selectLetterCount(String conversationId);

    /**
     * 查询未读私信的数量
     * @param userId 用户id
     * @param conversationId 会话id
     * @return 会话id为空时为该用户的总未读私信数量 非空时为该用户该会话的未读私信数量
     */
    int selectLetterUnreadCount(int userId, String conversationId);

    /**
     * 新增消息
     * @param message 新增的消息对象
     * @return 插入成功的行数
     */
    int insertMessage(Message message);

    /**
     * 修改消息的状态
     * @param ids 消息id列表
     * @param status 修改为的状态
     * @return 改变的行数
     */
    int updateStatus(List<Integer> ids, int status);

}
