package com.lowell.qqzone.service.impl;

import com.lowell.qqzone.dao.ReplyDAO;
import com.lowell.qqzone.pojo.HostReply;
import com.lowell.qqzone.pojo.Reply;
import com.lowell.qqzone.pojo.Topic;
import com.lowell.qqzone.pojo.UserBasic;
import com.lowell.qqzone.service.HostReplyService;
import com.lowell.qqzone.service.ReplyService;
import com.lowell.qqzone.service.UserBasicService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));

        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            // 1. 将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);
            // 2. 将关联的HostReply设置进去
            HostReply hostReply = hostReplyService.getHostReplyByRepley(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        // 1. 根据id获取到reply
        Reply reply = replyDAO.getReply(id);
        if(reply != null){
            // 2. 如果reply有关联的hostReply, 则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByRepley(reply.getId());
            if(hostReply != null) {
                hostReplyService.delHostReply(hostReply.getId());
            }

        }

        // 3. 删除reply
        replyDAO.delReply(id);
    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if(replyList != null) {
            for(Reply reply : replyList) {
                delReply(reply.getId());
            }
        }
    }
}
