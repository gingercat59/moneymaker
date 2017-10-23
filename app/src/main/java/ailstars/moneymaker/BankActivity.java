package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import ailstars.moneymaker.models.Account;
import ailstars.moneymaker.models.Bank;
import ailstars.moneymaker.models.Player;

public class BankActivity extends AppCompatActivity {
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        player = Player.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
    }

    public void bankbackward(View view) {
        Intent intent = new Intent(BankActivity.this, MainActivity.class);
        startActivity(intent);
    }
    Spinner yearCREDIT = (Spinner) findViewById(R.id.yearCREDIT);
    Integer t = (Integer) yearCREDIT.getSelectedItem();

    EditText sumCREDIT = (EditText)findViewById(R.id.sumCREDIT);

    int s = Integer.parseInt(sumCREDIT.getText().toString());

    public void Click(View view){
        if(s>5000 && t>0){
            Bank.canTakeCredit(player.countMoney(),s,t); {

                if(player.countMoney()> Bank.onePayment(s,t)){
                    Bank bank = Bank.getInstance();
                    bank.createAccount(Account.Types.CREDIT,s,t);
                    bank.addAccount();
                }
            }
        }
    }


}
