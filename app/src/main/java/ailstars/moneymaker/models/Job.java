package ailstars.moneymaker.models;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOT on 24.08.2017.
 */

public class Job {
    private final String name;
    private final Float income;
    private final Float timeCost;
    private final Integer moodmod;

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public float getTimeCost() {
        return timeCost;
    }

    public Integer getMoodmod() {
        return moodmod;
    }

    private Job (String name, float income, float timeCost, Integer moodmod){
        this.name=name;
        this.income=income;
        this.timeCost=timeCost;
        this.moodmod=moodmod;
    }

    public static Job getInstance (String name, float income, float timeCost, Integer moodmod){
        return new Job(name,income,timeCost,moodmod);
    }

    public static List<Job> getJobList(){
        List <Job> list = new ArrayList();
        list.add(getInstance("Уборшик в чикане",1000,4,0 ));
        list.add(getInstance("Охранник алкомаркета",2000,8,0 ));
        list.add(getInstance("Консультант в связном",4000,8,0 ));
        list.add(getInstance("Администратор в пятёрочке",5000,8,0 ));
        list.add(getInstance("Хозяин Шаурмяшной",8000,8,0 ));
        return list;
    }

}
