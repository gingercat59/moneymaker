package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
    }

    public void hobbybackward(View view) {
        Intent intent = new Intent(HobbyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
