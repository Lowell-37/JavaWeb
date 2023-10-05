package com.lowell.qqzone.dao.impl;

import com.lowell.myssm.basedao.BaseDAO;
import com.lowell.qqzone.dao.TopicDAO;
import com.lowell.qqzone.pojo.Topic;
import com.lowell.qqzone.pojo.UserBasic;

import java.util.List;

public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ? " , userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {
        executeUpdate("insert into t_topic where id = ?", topic.getId());
    }

    @Override
    public void delTopic(Topic topic) {
        executeUpdate("delete from t_topic where id = ?", topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return load("select * from t_topic where id = ?", id);
    }
}
