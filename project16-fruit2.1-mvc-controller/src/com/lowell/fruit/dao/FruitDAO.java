package com.lowell.fruit.dao;

import com.lowell.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    // 获取指定页码上的库存列表信息
    List<Fruit> getFruitList(String keyword, Integer pageNo);

    Fruit getFruitByFid(Integer fid);

    void updateFruit(Fruit fruit);

    void delFruit(Integer fid);

    void addFruit(Fruit fruit);

    int getFruitCount(String keyword);
}
