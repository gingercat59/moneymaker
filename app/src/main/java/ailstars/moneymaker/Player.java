package ailstars.moneymaker;

/**
 * Created by ailst on 01.08.2017.
 */

class Player {
    private static Player instance;
    private Integer mStep=0;
    private Float mMoney=Float.valueOf(0);

    private Player() {
    }

    public static synchronized Player getInstance() {

        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public String getStepValue(){
        return mStep.toString();
    }

    public String getMoneyValue(){
        return mMoney.toString();
    }

    public void createMove(){
        mStep++;
        mMoney+=100;
    }


}
