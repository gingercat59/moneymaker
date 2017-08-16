package ailstars.moneymaker.models;

import java.util.List;

/**
 * Created by ailst on 01.08.2017.
 */

public class Player {
    private static Player instance;
    private Integer mStep=0;
    private Float money=Float.valueOf(0);
    private int mood=100;
    private List <Business> business;


    private Player() {
    }

    public static synchronized Player getInstance() {

        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

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
    }

    private void createstep(){
        mStep++;
    }

    public void addBusiness(Business bus){
         business.add(bus);
    }

    public Float getMoneyFromBusiness(){
        Float result=Float.valueOf(0);
        for (Business bus:business){
            result+=bus.getIncome();
        }

        return result;

    }


}
