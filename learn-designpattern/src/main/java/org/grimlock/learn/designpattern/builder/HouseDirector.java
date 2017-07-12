package org.grimlock.learn.designpattern.builder;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class HouseDirector {

    public void makeHouse(HouseBuilder builder){
        builder.makeFloor();
        builder.makeWall();
        builder.makeHouseTop();
    }
}
