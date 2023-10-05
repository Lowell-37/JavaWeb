package com.lowell.fruit.dao;

import com.lowell.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    List<Fruit> getFruitList();

    Fruit getFruitByFid(Integer fid);

    void updateFruit(Fruit fruit);

    void delFruit(Integer fid);

    void addFruit(Fruit fruit);
}
