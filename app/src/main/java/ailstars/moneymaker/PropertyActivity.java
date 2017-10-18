package ailstars.moneymaker;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

import ailstars.moneymaker.models.Business;
import ailstars.moneymaker.models.Player;
import ailstars.moneymaker.models.Property;
import ailstars.moneymaker.study.ParameterButton;

public class PropertyActivity extends AppCompatActivity {
    Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        player = Player.getInstance();

        //получить список имущества
        final List<Property> propertylist = Property.getPropertyList();
        final List<Property> propertysell = Property.getSellPropertyList();


        //функция обработки
        final View.OnClickListener addProperty = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id = view.getId();
                //проверить можно ли купить
                if (player.canBuyProperty(propertylist.get(id))){
                    player.buyProperty(propertylist.get(id));
                    restartActivity();
                }

            }
        };
        final  View.OnClickListener sellProperty = new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                player.sellProperty(propertylist.get());
            }
        };
        //слой для создания кнопок
        LinearLayout lin = (LinearLayout)findViewById(R.id.propertyLayout);
        //параметры для размешения кнопок
        LinearLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        // в цикле обойти
        for (Property prop:propertylist){
            //создание кнопки для каждого класса

            Button button = new Button(PropertyActivity.this);
            button.setText(prop.getName()+", cost: "+String.valueOf(prop.getPrice())+", cashflow: "+String.valueOf(prop.getCashflow())+", mood: "+String.valueOf(prop.getMoodmod()));
            layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
            button.setLayoutParams(layoutParams);
            button.setId(propertylist.indexOf(prop));
            if (!player.canBuyProperty(prop)){
                button.setEnabled(false);
            }
            lin.addView(button);

            //обработчик для кнопок

            button.setOnClickListener(addProperty);
        }
        for (Property propsell:propertysell){
            ParameterButton button = new ParameterButton(PropertyActivity.this);
            button.id=1;
            button.setText(propsell.getName());
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            button.setLayoutParams(layoutParams);
            lin.addView(button);

        }
    }

    private void restartActivity(){
        finish();
        this.startActivity(new Intent(this,this.getClass()));
    }

    public void propertybackward(View view) {
        Intent intent = new Intent(PropertyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}


