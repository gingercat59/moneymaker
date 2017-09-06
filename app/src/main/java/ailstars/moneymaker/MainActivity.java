package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

import ailstars.moneymaker.models.Player;
import ailstars.moneymaker.study.Duck;
import ailstars.moneymaker.study.DuckFabric;
import ailstars.moneymaker.study.Eatable;
import ailstars.moneymaker.study.RubberDuck;
import ailstars.moneymaker.study.Soundable;

public class MainActivity extends AppCompatActivity {
    public Button mNextMove;
    TextView mTimeValue;
    TextView mMoneyValue;
    Player player;
    private int mood = 0;
    private ProgressBar moodbar;
    private TextView tvProgressHorizontal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /**DUCKS
        *  List<Duck> dkList= DuckFabric.getDucks();
        for(Duck dc:dkList){
            if(dc instanceof Eatable) {
                Eatable xc= (Eatable)dc;
                xc.eat(223);
                xc.getCountOfFood();
            }
            if(dc instanceof Soundable) {
                Soundable xc= (Soundable)dc;
                xc.sound();
            }
        }
        */

        LinkViewParts();
        renderMainView();

        View.OnClickListener createMove = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                player.createMove();
                renderMainView();

            }
        };

        mNextMove.setOnClickListener(createMove);



    }
     private void renderMainView() {

         mTimeValue.setText("Прошло "+player.getStepValue() + " недель" );
         mMoneyValue.setText(player.getMoneyValue());
         moodbar.setProgress(mood);
         Button business = (Button) findViewById(R.id.buttonbusiness);
         business.setText("Бизнес: "+player.getMoneyFromBusiness());
         Button property = (Button) findViewById(R.id.buttonproperty);
         property.setText("Имущество: "+player.getMoneyFromProperty());
         Button job = (Button) findViewById(R.id.buttonjob);
         job.setText("Работа: "+player.getMoneyFromJob());

     }



     private void LinkViewParts(){

         player = Player.getInstance();
         mNextMove = (Button) findViewById(R.id.buttonnextmove);
         mTimeValue = (TextView) findViewById(R.id.Timeaccount);
         mMoneyValue = (TextView) findViewById(R.id.moneycounter);
         moodbar = (ProgressBar) findViewById(R.id.moodbar);
         tvProgressHorizontal = (TextView) findViewById(R.id.moodvalue);


     }


    public void job(View view) {
        Intent intent = new Intent(MainActivity.this, JobActivity.class);
        startActivity(intent);

    }

    public void business(View view) {
        Intent intent = new Intent(MainActivity.this, BusinessActivity.class);
        startActivity(intent);
    }

    public void hobby(View view) {
        Intent intent = new Intent(MainActivity.this, HobbyActivity.class);
        startActivity(intent);

    }

    public void property(View view) {
        Intent intent = new Intent(MainActivity.this, PropertyActivity.class);
        startActivity(intent);
    }

    public void bank(View view) {
        Intent intent = new Intent(MainActivity.this, BankActivity.class);
        startActivity(intent);
    }

    public void balance(View view) {
        Intent intent = new Intent(MainActivity.this, BalanceActivity.class);
        startActivity(intent);
    }

    public void education(View view) {
        Intent intent = new Intent(MainActivity.this, EducationActivity.class);
        startActivity(intent);
    }

    public void conditions(View view) {
        Intent intent = new Intent(MainActivity.this, ConditionsActivity.class);
        startActivity(intent);
    }

    public void intertament(View view) {
        Intent intent = new Intent(MainActivity.this, IntertamentActivity.class);
        startActivity(intent);
    }
}
