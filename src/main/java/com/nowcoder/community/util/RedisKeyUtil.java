package com.nowcoder.community.util;

/**
 * @author hpr
 * @date 2022-08-14 16:46
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PREFIX_USER_LIKE = "like:user";
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";
    private static final String PREFIX_KAPTCHA = "kaptcha";
    private static final String PREFIX_TICKET = "ticket";
    private static final String PREFIX_USER = "user";

    /**
     * 某个实体的赞
     * like:entity:entityType:entityId -> set(userId)
     * set(userId)是指有哪些用户点赞了，记录点赞用户ID的集合
     * @param entityType 实体类型（帖子、评论）
     * @param entityId 实体ID
     * @return Redis中的key：ike:entity:entityType:entityId（对应value为set(userId)）
     */
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 某个用户的赞
     * like:user:userId -> int
     * @param userId 用户ID
     * @return Redis中的key：like:user:userId（对应value为int）
     */
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    /**
     * 某个用户关注的实体
     * followee:userId:entityType -> zset(entityId,now)
     * @param userId 用户ID
     * @param entityType 实体类型
     * @return Redis中的key：followee:userId:entityType（对应value为zset(entityId,now)）
     */
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    /**
     * 某个实体拥有的粉丝
     * follower:entityType:entityId -> zset(userId,now)
     * @param entityType 实体类型
     * @param entityId 实体ID
     * @return Redis中的key：follower:entityType:entityId（对应value为zset(userId,now)）
     */
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 登录验证码
     * @param owner Cookie里与该验证码对应的一个凭证
     * @return 验证码的key
     */
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    /**
     * 登录的凭证
     * @param ticket 登录凭证信息
     * @return 登录凭证的key
     */
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }

    /**
     * 用户
     * @param userId 用户ID
     * @return 用户信息的key
     */
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }
}
