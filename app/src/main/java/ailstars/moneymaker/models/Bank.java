package ailstars.moneymaker.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOT on 31.08.2017.
 */

public class Bank {
    private List<Account> accountList = new ArrayList<>();


    //проверить можно ли выдать кредит/положить депозит
    private boolean proverka(Float countmoney){
        if (0 < countmoney) {
            return true;
        }
        return false;
    }

    //если можно добавить новый пункт в список

    public void createAccount(Account.Types type,Float money,Integer time){
        accountList.add(Account.getInstance(type,getPercent(type),money,time));
    }

    private void addAccount(Account account) {
        accountList.add(account);
    }

    //вернуть весь список

    public static Float getPercent(Account.Types type){
        if(type.equals(Account.Types.CREDIT)){
            return Float.valueOf(15);
        }
        return Float.valueOf(10);
    }



}
