package org.grimlock.learn.designpattern.builder;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class PingFangBuilder implements HouseBuilder {

    House house = new House();

    public void makeFloor() {
        house.setFloor("平房--》地板");
    }

    public void makeWall() {
        house.setWall("平房--》墙");
    }

    public void makeHouseTop() {
        house.setHouseTop("平房--》屋顶");
    }

    public House getHouse() {
        return house;
    }
}
