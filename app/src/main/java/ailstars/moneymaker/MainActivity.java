package ailstars.moneymaker;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button mNextMove;
    TextView mTimeValue;
    TextView mMoneyValue;
    Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkViewParts();
        renderMainView();

        View.OnClickListener createMove = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                renderMainView();

            }
        };

        mNextMove.setOnClickListener(createMove);

    }
     private void renderMainView() {

         mTimeValue.setText(player.getStepValue());
         mMoneyValue.setText(player.getMoneyValue());

     }



     private void LinkViewParts(){

         player = Player.getInstance();
         mNextMove = (Button) findViewById(R.id.buttonnextmove);
         mTimeValue = (TextView) findViewById(R.id.Timeaccount);
         mMoneyValue = (TextView) findViewById(R.id.moneycounter);


     }


    public void job(View view) {
        Intent intent = new Intent(MainActivity.this, Job.class);
        startActivity(intent);

    }

    public void business(View view) {
        Intent intent = new Intent(MainActivity.this, Business.class);
        startActivity(intent);
    }

    public void hobby(View view) {
        Intent intent = new Intent(MainActivity.this, Hobby.class);
        startActivity(intent);

    }

    public void property(View view) {
        Intent intent = new Intent(MainActivity.this, Property.class);
        startActivity(intent);
    }

    public void bank(View view) {
        Intent intent = new Intent(MainActivity.this, Bank.class);
        startActivity(intent);
    }

    public void balance(View view) {
        Intent intent = new Intent(MainActivity.this, Balance.class);
        startActivity(intent);
    }

    public void education(View view) {
        Intent intent = new Intent(MainActivity.this, Education.class);
        startActivity(intent);
    }

    public void conditions(View view) {
        Intent intent = new Intent(MainActivity.this, Conditions.class);
        startActivity(intent);
    }

    public void intertament(View view) {
        Intent intent = new Intent(MainActivity.this, Intertament.class);
        startActivity(intent);
    }
}
