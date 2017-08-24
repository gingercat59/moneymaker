package ailstars.moneymaker;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

import ailstars.moneymaker.models.Business;
import ailstars.moneymaker.models.Job;
import ailstars.moneymaker.models.Player;

public class JobActivity extends AppCompatActivity {
    Player player;
    private List<EditText> editTextList = new ArrayList<EditText>();
    View.OnClickListener getEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        player = Player.getInstance();

        final List <Job> joblist = Job.getJobList();

        final View.OnClickListener addJob = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id=view.getId();

                if( player.canBuyJob(joblist.get(id))){
                    player.buyJob(joblist.get(id));

                    restartActivity();
                }

            }
        };

        LinearLayout lin = (LinearLayout)findViewById(R.id.jobLayout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        /*for (Job job:joblist){
            Button button = new Button(BusinessActivity.this);
            button.setText(job.getName()+", cost:"+String.valueOf(job.getIncome())+", cashflow"+String.valueOf(job.getIncome()));
            layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
            button.setLayoutParams(layoutParams);
            button.setId(businesslist.indexOf(bus));
            if (!player.canBuyBasiness(bus)){
                button.setEnabled(false);
            }
            lin.addView(button);

        }



    }
/*




    public void jobbackward(View view) {
        Intent intent = new Intent(JobActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
