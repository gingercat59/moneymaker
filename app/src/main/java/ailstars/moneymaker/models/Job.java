package ailstars.moneymaker.models;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOT on 24.08.2017.
 */

public class Job {
    public final Integer id;
    private final String name;
    private final Float income;
    private final Integer moodmod;

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public Integer getMoodmod() {
        return moodmod;
    }

    private Job (String name, float income, Integer moodmod,Integer id){
        this.id=id;
        this.name=name;
        this.income=income;
        this.moodmod=moodmod;
    }

    public static Job getInstance (String name, float income, Integer moodmod,Integer id){
        return new Job(name,income,moodmod,id);
    }

    public static List<Job> getJobList(){
        List <Job> list = new ArrayList();
        list.add(getInstance("Уборшик в чикане",1000,0,10 ));
        list.add(getInstance("Охранник алкомаркета",2000,0,20 ));
        list.add(getInstance("Консультант в связном",4000,0,30 ));
        list.add(getInstance("Администратор в пятёрочке",5000,0,40 ));
        list.add(getInstance("Хозяин Шаурмяшной",8000,0,50 ));

        return list;
    }

}
