package ailstars.moneymaker.study;

/**
 * Created by KOT on 06.09.2017.
 */

public class SoundDuck implements Duck, Soundable,Eatable{
    DuckParams prm = new DuckParams();
    public void sound(){
        System.out.print("Кря бля");
    }

    public int getCountOfFood() {
        return prm.food;
    }

    public void eat(int countFoor){
        prm.food+=countFoor;
    }
}
