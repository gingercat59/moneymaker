package ailstars.moneymaker.study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOT on 06.09.2017.
 */

public class DuckFabric {

    public static List<Duck>  getDucks(){
        List<Duck> dkList= new ArrayList<>();
        dkList.add(new SoundDuck());
        dkList.add(new RubberDuck());
        dkList.add(new UnsoundDuck());
        return dkList;
    }


}
