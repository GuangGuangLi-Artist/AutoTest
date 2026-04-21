package tendaysjava.firstday;

import org.testng.annotations.Test;

public class Day01Practice {



    private String commodityName;
    private double commodityPrice;
    private int payCount;
    private final double DISCOUNT=0.88;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getPayCount() {
        return payCount;
    }

    public void setPayCount(int payCount) {
        this.payCount = payCount;
    }



    public Day01Practice(String commodityName, double commodityPrice, int payCount) {
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.payCount = payCount;
    }

    public Day01Practice() {
    }

    public int getSum() {
        int count = (int)(this.commodityPrice * this.payCount * this.DISCOUNT);
        return count;
    }




    @Test
    public void testC(){
        Day01Practice day01Practice = new Day01Practice("ball",2.0,5);
        System.out.println("商品：" + day01Practice.getCommodityName() + "，原价："+ day01Practice.getCommodityPrice()
                + ",最终扣费：" + day01Practice.getSum());

    }

}
