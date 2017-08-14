package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Intertament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intertament);
    }

    public void intertamentbackward (View view) {
        Intent intent = new Intent(Intertament.this, MainActivity.class);
        startActivity(intent);
    }
}
