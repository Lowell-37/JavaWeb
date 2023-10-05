package com.lowell.qqzone.service.impl;

import com.lowell.qqzone.dao.TopicDAO;
import com.lowell.qqzone.pojo.Reply;
import com.lowell.qqzone.pojo.Topic;
import com.lowell.qqzone.pojo.UserBasic;
import com.lowell.qqzone.service.ReplyService;
import com.lowell.qqzone.service.TopicService;
import com.lowell.qqzone.service.UserBasicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null ;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
    // 根据id获取制指定的topic信息，包含这个topic关联的作者信息
    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;

    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if(topic !=null) {
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(id);
        topic.setReplyList(replyList);

        return topic;
    }
}
