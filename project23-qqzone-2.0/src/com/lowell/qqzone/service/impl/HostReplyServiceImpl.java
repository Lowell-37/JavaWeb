package com.lowell.qqzone.service.impl;

import com.lowell.qqzone.dao.HostReplyDAO;
import com.lowell.qqzone.pojo.HostReply;
import com.lowell.qqzone.service.HostReplyService;

public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByRepley(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
