package com.lowell.fruit.dao.impl;

import com.lowell.fruit.dao.FruitDAO;
import com.lowell.fruit.myssm.basedao.BaseDAO;
import com.lowell.fruit.pojo.Fruit;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
