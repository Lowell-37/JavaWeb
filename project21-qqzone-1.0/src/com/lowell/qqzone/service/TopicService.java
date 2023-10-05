package com.lowell.qqzone.service;

import com.lowell.qqzone.pojo.Topic;
import com.lowell.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic) ;
}
