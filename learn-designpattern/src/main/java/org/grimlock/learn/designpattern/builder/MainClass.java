package org.grimlock.learn.designpattern.builder;

/**
 * 建造者设计模式
 * Created by songchunlei on 2017/7/12.
 */
public class MainClass {
    public static void main(String[] args) {

         /*
        //客户直接造房子
        House house = new House();
        house.setFloor("普通木地板");
        house.setWall("面墙");
        house.setHouseTop("瓦片屋顶");
        */

        /*
        //由工程队来修-修平房的
        HouseBuilder houseBuilder = new PingFangBuilder();
        //调用工程队的方法
        houseBuilder.makeFloor();
        houseBuilder.makeHouseTop();
        houseBuilder.makeWall();
        House house = houseBuilder.getHouse();
         */
        HouseBuilder houseBuilder = new PingFangBuilder();
        //设计师
        HouseDirector director = new HouseDirector();
        director.makeHouse(houseBuilder);
        House house = houseBuilder.getHouse();


        System.out.println("房子结果："+house.getFloor()+house.getWall()+house.getHouseTop());

    }
}
