package org.grimlock.learn.designpattern.builder;

/**
 * Created by songchunlei on 2017/7/12.
 */
public interface HouseBuilder {
   public void makeFloor();
   public void makeWall();
   public void makeHouseTop();
   public House getHouse();
}
