package ailstars.moneymaker.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 16.08.2017.
 */

public class Business {
    private final String name;
    private final float price;
    private final float income;



    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getIncome() {
        return income;
    }

    private Business(String name,float price, float income){
        this.name=name;
        this.price=price;
        this.income=income;
    }

    public static Business getInstance (String name,float price, float income){
        return new Business(name,price,income);
    }

    public static List <Business> getBusinessList(){
        List <Business> list = new ArrayList();
        list.add(getInstance("Шаурмяшная",500000 ,9000 ));
        list.add(getInstance("Автосервис у Ашота",1000000,19000));
        list.add(getInstance("филиал Старбакса",400000,7500));
        list.add(getInstance("Автомойка в гараже",300000,6000));
        list.add(getInstance("Филиал Рыжий кот",150000,3000));

        return list;
    }

}