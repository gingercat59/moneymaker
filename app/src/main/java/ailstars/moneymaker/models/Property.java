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
    private final int type;


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

    private Property(String name, int type, float price, float cashflow, Integer moodmod){
        this.name=name;
        this.price=price;
        this.cashflow=cashflow;
        this.moodmod=moodmod;
        this.type=type;
    }

    public static Property getInstance (String name,int type,float price, float cashflow, Integer moodmod){
        return new Property(name, type, price, cashflow, moodmod);
    }

    public static List <Property> getPropertyList(){
        List <Property> list = new ArrayList();
        list.add(getInstance("Палатка",1,5000,0,0));
        list.add(getInstance("Комната в общаге",2,400000,6000,0));
        list.add(getInstance("Однушка на окраине",3,1500000,12000,0));
        list.add(getInstance("Трёшка на окраине",4,4000000,25000,0));
        list.add(getInstance("Однушка в центре",5,3500000,30000,0));

        return list;
    }
    public  static  List<Property> getMyPropertyList(){
        List<Property> myProperty = new ArrayList<>();

    }
}


