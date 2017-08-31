package ailstars.moneymaker;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout.LayoutParams;


import java.util.ArrayList;
import java.util.List;

import ailstars.moneymaker.models.Business;
import ailstars.moneymaker.models.Player;

public class BusinessActivity extends AppCompatActivity {
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        player = Player.getInstance();

        //Получить список Бизнесов
        final List <Business> businesslist = Business.getBusinessList();

        //СоздФункцию обработки

        final View.OnClickListener addBusiness = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id=view.getId();
                //проверить может ли купить
                if( player.canBuyBasiness(businesslist.get(id))){
                    player.buyBusiness(businesslist.get(id));
                    restartActivity();
                }

            }
        };


        //Ищу слой для создания кнопок
        LinearLayout lin = (LinearLayout)findViewById(R.id.businessLayout);
        //Определяю параметры для размещения кноопк
        LinearLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

        //В цикле обойти
        for (Business bus:businesslist){
            //Для каждого экземпляра создать кнопку

            Button button = new Button(BusinessActivity.this);
            button.setText(bus.getName()+", cost:"+String.valueOf(bus.getPrice())+", cashflow"+String.valueOf(bus.getIncome()));
            layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
            button.setLayoutParams(layoutParams);
            button.setId(businesslist.indexOf(bus));
            if (!player.canBuyBasiness(bus)){
                button.setEnabled(false);
            }
            lin.addView(button);

            //Повесить на кнопки обработчик
            button.setOnClickListener(addBusiness);
        }
    }



    private void restartActivity(){
        finish();
        this.startActivity(new Intent(this,this.getClass()));
    }

    public void businessbackward(View view) {
        Intent intent = new Intent(BusinessActivity.this, MainActivity.class);
        startActivity(intent);

    }




}
