package ailstars.moneymaker.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ailst on 01.08.2017.
 */

public class Player {
    private static Player instance;
    private Integer mStep=0;
    private Float money=Float.valueOf(0);
    private int mood=100;
    private List <Business> business = new ArrayList<>();
    private List <Property> property = new ArrayList<>();


    private Player() {
    }

    public static synchronized Player getInstance() {

        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    Player Playername = Player.getInstance();
    //получить прайс
    // сравнить с ценой
    //если больше то
    // если меньше то


    public String getStepValue(){
        return mStep.toString();
    }

    public String getMoneyValue(){
        return money.toString();
    }

    public void createMove(){
        createstep();
        countmoney();
        countmood();
    }

    private void countmood (){
        mood-=5;
    }

    private void countmoney(){
        money+=100;
        money+=getMoneyFromBusiness();
        money+=getMoneyFromProperty();
    }

    private void createstep(){
        mStep++;
    }

    public void addBusiness(Business bus){
         business.add(bus);
    }



    public void addProperty(Property prop){
        property.add(prop);
    }

    public Float getMoneyFromBusiness(){
        Float result=Float.valueOf(0);
        for (Business bus:business){
            result+=bus.getIncome();
        }

        return result;

    }

    public Float getMoneyFromProperty(){
        Float result=Float.valueOf(0);
        for (Property prop:property){
            result+=prop.getCashflow();
        }
        return result;
    }


}
