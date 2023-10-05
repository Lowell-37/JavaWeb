package com.lowell.qqzone.service;

import com.lowell.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByRepley(Integer replyId);
    void delHostReply(Integer id);
}
