package Demo;

/**
 * Created by lenovo on 2017/3/22.
 */
public class consignment {
    //private String flight_type;//航班类型
    private int route;//航班路线
    private int num,maxNum;//行李数量；
    private double cash,tprice;//所需钱数
    private int size,maxSize;
    private float weight,maxWeight;//免费重量
    private String position;//仓位
    public consignment(int route ,String position){
        this.route=route;this.position=position;
        if(route==0){
            this.route=0;
           this.maxWeight=50; this.maxSize=200;
            if(position.equals("头等舱")) this.weight=40;
            else if (position.equals("公务舱")) this.weight=30;
            else if (position.equals("经济舱")) this.weight=20;
            maxNum=500;//表示无要求
        }
        else if (route==1){
            this.route=1;
            this.maxWeight=45; this.maxSize=158;
            if(position.equals("头等舱")) {this.weight=32; this.maxNum=3;}
            else if (position.equals("公务舱")) {this.weight=32; this.maxNum=2;}
            else if (position.equals("经济舱")||position.equals("明珠经济舱")) {this.weight=23;this.maxNum=2;}
        }
        else if (route==2){
            this.route=2;
            this.maxWeight=32; this.maxSize=158;
            if(position.equals("头等舱")) {this.weight=32; this.maxNum=3;}
            else if (position.equals("公务舱")) {this.weight=32; this.maxNum=2;}
            else if (position.equals("经济舱")||position.equals("明珠经济舱")) {this.weight=32;this.maxNum=1;}
        }
        else if (route==3){
            this.route=3;
            this.maxWeight=32; this.maxSize=158;
            if(position.equals("头等舱")) {this.weight=32; this.maxNum=3;}
            else if (position.equals("公务舱")) {this.weight=32; this.maxNum=2;}
            else if (position.equals("经济舱")||position.equals("明珠经济舱")) {this.weight=23;this.maxNum=2;}
        }
        else if (route==4){
            this.route=4;
            this.maxWeight=32; this.maxSize=158;
            if(position.equals("头等舱")) {this.weight=32; this.maxNum=3;}
            else if (position.equals("公务舱")) {this.weight=23; this.maxNum=3;}
            else if (position.equals("经济舱")) {this.weight=23;this.maxNum=1;}
            else if (position.equals("明珠经济舱")){
                this.weight=23;this.maxNum=2;
            }
        }
        else if (route==5){
            this.route=5;
            this.maxWeight=32; this.maxSize=158;
            if(position.equals("头等舱")) {this.weight=32; this.maxNum=3;}
            else if (position.equals("公务舱")) {this.weight=32; this.maxNum=2;}
            else if (position.equals("经济舱")) {this.weight=23;this.maxNum=1;}
        }
    }
    public void setPosition(String position){
        this.position=position;
    }
    public void setNum(int num){
        this.num=num;
    }
    public void setTprice(double price){
        this.tprice=price;
    }
    public double getPrice(luggage [] luggages,int c1,int c2,int c3,int c4,int c5){
        if (num<maxNum) {
            for (int i=0;i<num;i++){
                if (159<luggages[i].getSize()&&luggages[i].getSize()<300){
                    cash+=c3;
                }
                else {

                }
                if (luggages[i].getWeight()<=32&&luggages[i].getWeight()>=23){
                    cash+=c5;
                }
                else if (luggages[i].getWeight()<=45&&luggages[i].getWeight()>=32){
                    cash+=c4;
                }
            }
        }
        else{
            for (int i=0;i<maxNum-num;i++){
                if (i==0){
                    cash+=c1;
                }
                else{
                    cash+=c2;
                }
            }
            for (int i=0;i<num;i++){
                if (159<luggages[i].getSize()&&luggages[i].getSize()<300){
                    cash+=c3;
                }
                else {

                }
                if (luggages[i].getWeight()<=32&&luggages[i].getWeight()>=23){
                    cash+=c5;
                }
                else if (luggages[i].getWeight()<=45&&luggages[i].getWeight()>=32){
                    cash+=c4;
                }
            }
        }
        return cash;
    }
    public double Totalamout(luggage[] luggages){
        if (route==0){
            float weightnow=0;
            for (int i=0;i<num;i++){
                weightnow+=luggages[i].getWeight();
            }
            if (weightnow>weight)
            cash=tprice+(weightnow-weight)*tprice*1.5;
            else {
                cash=tprice;
            }
        }
        else if (route==1){
            cash+=tprice;
            if (position.equals("头等舱")||position.equals("公务舱")){
               getPrice(luggages,1000,2000,1000,3000,1000);
            }
            else{
                getPrice(luggages,1000,2000,1000,3000,1000);
            }
        }
        else if (route==2){
            cash+=tprice;
            getPrice(luggages,450,1300,1000,3000,0);
        }
        else if (route==3){
            cash+=tprice;
            if (position.equals("头等舱")||position.equals("公务舱")){
                getPrice(luggages,1000,2000,1000,3000,2000);
            }
            else{
                getPrice(luggages,1000,2000,1000,3000,2000);
            }
        }
        else if (route==4){
            cash+=tprice;
            if (position.equals("头等舱")||position.equals("公务舱")){
                getPrice(luggages,450,1300,1000,3000,3000);
            }
            else{
                getPrice(luggages,450,1300,1000,3000,3000);
            }
        }
        return cash;
    }
}
