package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Business extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);


    }

    public void businessbackward(View view) {
        Intent intent = new Intent(Business.this, MainActivity.class);
        startActivity(intent);

    }
}
