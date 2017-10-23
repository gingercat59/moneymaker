package ailstars.moneymaker.models;

/**
 * Created by KOT on 31.08.2017.
 */

public class Account {


    private final Types type;
    private final Float percent;
    private final Float money;
    private final Integer time;
    private Float percentMoney=Float.valueOf(0);

    public Types getType(){
        return type;
    }

    public Float getPercent() {
        return percent;
    }

    public Float getMoney() {
        return money;
    }

    public Integer getTime() {
        return time;
    }

    public static Account getInstance(Types type, Float percent, Integer money, Integer time){
        Account acc= new Account(type,percent,money,time);
        return acc;
    }

    private Account (Types type, Float percent, Float money, Integer time){
        this.type=type;
        this.percent=percent;
        this.money=money;
        this.time=time;
    }



    public static enum Types{
        CREDIT,DEBT
    }

}


