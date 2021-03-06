package ailstars.moneymaker.models;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ailst on 01.08.2017.
 */

public final class Player {
    private static Player instance;
    private Integer mStep = 0;
    private Float money = Float.valueOf(0);
    private int mood = 100;
    private Job job;
    private List<Business> business = new ArrayList<>();
    private List<Property> property = new ArrayList<>();
    private List<Property> myProperty = new ArrayList<>();

    private Player() {
    }

    public static synchronized Player getInstance() {

        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public boolean canBuyBasiness(Business business) {
        if (business.getPrice() <= money) {
            return true;
        }
        return false;
    }

    public boolean canBuyProperty(Property property) {
        if (property.getPrice() <= money) {
            return true;
        }
        return false;
    }

    public boolean canGetJob(Job job) {
        return true;
    }

    public void setJob(Job jb) {
        job = jb;

    }

    public Job getJob(){
        return job;
    }

    public String getStepValue() {
        return mStep.toString();
    }

    public String getMoneyValue() {
        return money.toString();
    }

    public void createMove() {
        createstep();
        addMoney(countMoney());
        countMood();
    }

    //сделать ход
    private void createstep() {
        mStep++;
    }

    //добавить бизнес
    private void addBusiness(Business bus) {
        business.add(bus);
    }

    //вычетание денег за покупку бизнеса
    public void buyBusiness(Business business) {
        addBusiness(business);
        lessMoney(business.getPrice());
    }

    private void addProperty(Property prop) {
        property.add(prop);
    }

    public void buyProperty(Property property) {
        addProperty(property);
        lessMoney(property.getPrice());
    }

    public void sellProperty(Property property){

    }

    // вычетание денег
    private void lessMoney(Float value) {
        money -= value;
    }
    //добавление денег
    public void addMoney(Float money) {
        this.money += money;
    }

    public Float countMoney(){
        Float money=Float.valueOf(0);
        money+=getMoneyFromJob();
        money+=getMoneyFromBusiness();

        return money;
    }

    private void countMood() {
        mood -= 5;
    }

    public Float getMoneyFromBusiness() {
        Float result = Float.valueOf(0);
        for (Business bus : business) {
            result += bus.getIncome();
        }

        return result;

    }

    public Float getMoneyFromProperty() {
        Float result = Float.valueOf(0);
        for (Property prop : property) {
            result += prop.getCashflow();
        }
        return result;
    }

    public Float getMoneyFromJob() {
        if (job != null) {
            return job.getIncome();
        }
        return Float.valueOf(0);
    }

}
