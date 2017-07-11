package org.grimlock.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class OrderNumGenerator {

    private  static int i=0;
    public String getOrderNum(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        return sdf.format(now)+ ++i;
    }
}
