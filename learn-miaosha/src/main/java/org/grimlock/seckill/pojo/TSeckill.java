package org.grimlock.seckill.pojo;

/**
 * Created by songchunlei on 2017/7/14.
 */
public class TSeckill {
    private String sku;
    private Integer num;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
