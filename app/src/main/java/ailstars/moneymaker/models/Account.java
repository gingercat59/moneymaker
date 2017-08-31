package ailstars.moneymaker.models;

/**
 * Created by KOT on 31.08.2017.
 */

public class Account {
    private final String type;
    private final Float percent;
    private final Float money;
    private final Integer time;

    public String getType(){
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

    public Account (String type, Float percent, Float money, Integer time){
        this.type=type;
        this.percent=percent;
        this.money=money;
        this.time=time;
    }
}
