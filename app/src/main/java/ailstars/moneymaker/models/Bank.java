package ailstars.moneymaker.models;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ailstars.moneymaker.R;

/**
 * Created by KOT on 31.08.2017.
 */

public class Bank {
    private List<Account> accountList = new ArrayList<>();
    private float sumDebt;
    private float sumCredit;
    private float timeCredit;

    //проверить можно ли открыть депозит
    private boolean proverkaDepozit (Float countmoney,Float addMoney) {
        if (sumDebt > addMoney && 0 < countmoney) {
            return true;
        }
        return false;
    }
    //1 платёж
    public static float onePayment (float sumCredit, float timeCredit){
        float n = sumCredit / timeCredit;
        float pers=0;
        for(double i=timeCredit; i>0; i--){
            pers += (float) (pers + Math.pow(((100 + getPercent(Account.Types.CREDIT)) / 100), i) * n);
        }
        return ((sumCredit+pers)/timeCredit)/52;
    }
    //проверка для кредита
    public static boolean canTakeCredit (Float countMoney, float sumCredit, float timeCredit){
        if(countMoney > onePayment(0,0)){
            return true;
        }
        return  false;
    }
    //если можно добавить новый пункт в список
    public void createAccount(Account.Types type, Float money, Integer time) {
        accountList.add(Account.getInstance(type, getPercent(type), money, time));
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
