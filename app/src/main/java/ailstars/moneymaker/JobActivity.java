package ailstars.moneymaker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

import ailstars.moneymaker.models.Business;
import ailstars.moneymaker.models.Job;
import ailstars.moneymaker.models.Player;

public class JobActivity extends AppCompatActivity {
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        player = Player.getInstance();

        final List <Job> joblist = Job.getJobList();

        final View.OnClickListener setJob = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id=view.getId();
                //проверить может ли устроиться
                if( player.canGetJob(joblist.get(id))){
                    player.setJob(joblist.get(id));
                    restartActivity();
                }

            }
        };


        LinearLayout lin = (LinearLayout)findViewById(R.id.jobLayout);

        LinearLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        for (Job jb:joblist){

            Button button = new Button(JobActivity.this);
            button.setText(jb.getName()+", ЗП:"+String.valueOf(jb.getIncome())+", Настроение:"+String.valueOf(jb.getMoodmod()));
            layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
            button.setLayoutParams(layoutParams);
            button.setId(joblist.indexOf(jb));
            if (player.getJob()!=null&&player.getJob().id.equals(jb.id)){
                    button.setTextColor(Color.BLUE);
            }
            lin.addView(button);
            button.setOnClickListener(setJob);
        }
    }


    private void restartActivity(){
        finish();
        this.startActivity(new Intent(this,this.getClass()));
    }

    public void jobbackward(View view) {
        Intent intent = new Intent(JobActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
