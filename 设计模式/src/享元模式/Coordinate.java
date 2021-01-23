package 享元模式;

/**
 * @author lxy
 * @date 2021/1/23 15:19
 **/

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 * 定义树得坐标
 */

public class Coordinate {

    private String x;
    private String y;

    public Coordinate(String x, String y) {
        this.x = x;
        this.y = y;
    }
    public String getX(){
        return x;
    }
    public String getY(){
        return y;
    }
}
