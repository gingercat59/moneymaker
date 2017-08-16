package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);
    }

    public void conditionsbackward(View view) {
        Intent intent = new Intent(ConditionsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
