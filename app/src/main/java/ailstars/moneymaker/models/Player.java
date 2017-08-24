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

    public boolean canBuyBasiness (Business business){
        if (business.getPrice() <= money) {
            return true;
        }
        return false;
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
        money+=15000;
        money+=getMoneyFromBusiness();
        money+=getMoneyFromProperty();
    }

    //сделать ход
    private void createstep(){
        mStep++;
    }

    //добавить бизнес
    private void addBusiness(Business bus){
         business.add(bus);
    }

    //вычетание денег за покупку бизнеса
    public void buyBusiness(Business business){
        addBusiness(business);
        lessMoney(business.getPrice());
    }

    private void lessMoney(Float value){
        money-=value;
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
