package ailstars.moneymaker.study;

/**
 * Created by KOT on 06.09.2017.
 */


public class UnsoundDuck  implements Duck,  Eatable{
    DuckParams prm = new DuckParams();
    public int getCountOfFood() {
        return prm.food;
    }

    public void eat(int countFoor){
        prm.food+=countFoor;
    }
}
