package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import ailstars.moneymaker.models.Bank;

public class BankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
    }

    public void bankbackward(View view) {
        Intent intent = new Intent(BankActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
