package org.grimlock.learn.designpattern.builder;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class House {
    //地板
    private String floor;
    //墙
    private String wall;
    //屋顶
    private String houseTop;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getHouseTop() {
        return houseTop;
    }

    public void setHouseTop(String houseTop) {
        this.houseTop = houseTop;
    }
}
