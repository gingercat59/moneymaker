package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
    }

    public void propertybackward(View view) {
        Intent intent = new Intent(PropertyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
