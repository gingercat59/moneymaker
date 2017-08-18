package ailstars.moneymaker.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.08.2017.
 */

public class Property {
    private final String name;
    private final Float price;
    private final Float cashflow;
    private final Integer moodmod;


    public String getName() {
        return name;
    }

    public float getPrice(){
        return price;
    }

    public float getCashflow() {
        return cashflow;
    }

    public Integer getMoodmod() {
        return moodmod;
    }

    private Property (String name,float price,float cashflow,Integer moodmod){
        this.name=name;
        this.price=price;
        this.cashflow=cashflow;
        this.moodmod=moodmod;
    }

    public static Property getInstance (String name,float price, float cashflow, Integer moodmod){
        return new Property(name, price, cashflow, moodmod);
    }

    public static List <Property> getPropertyList(){
        List <Property> list = new ArrayList();
        list.add(getInstance("Палатка",5000,0,0));
        list.add(getInstance("Комната в общаге",400000,6000,0));
        list.add(getInstance("Однушка на окраине",1500000,12000,0));
        list.add(getInstance("Трёшка на окраине",4000000,25000,0));
        list.add(getInstance("Однушка в центре",3500000,30000,0));

        return list;
    }

}


