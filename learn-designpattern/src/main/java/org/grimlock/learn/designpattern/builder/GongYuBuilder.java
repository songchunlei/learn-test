package org.grimlock.learn.designpattern.builder;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class GongYuBuilder implements HouseBuilder {

    House house = new House();

    public void makeFloor() {
        house.setFloor("公寓--》地板");
    }

    public void makeWall() {
        house.setWall("公寓--》墙");
    }

    public void makeHouseTop() {
        house.setHouseTop("公寓--》屋顶");
    }

    public House getHouse() {
        return house;
    }
}
