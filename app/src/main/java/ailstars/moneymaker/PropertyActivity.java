package ailstars.moneymaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import ailstars.moneymaker.models.Business;
import ailstars.moneymaker.models.Player;
import ailstars.moneymaker.models.Property;

public class PropertyActivity extends AppCompatActivity {
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        player = Player.getInstance();

        //получить список имущества
        final List<Property> Propertylist = Property.getPropertyList();

        //функция обработки
        final View.OnClickListener addProperty = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id = view.getId();
                player.addProperty(propertylist.get(id));

            }
        };

        //слой для создания кнопок
        LinearLayout lin = (LinearLayout)findViewById(R.id.propertylayout);
        //параметры для размешения кнопок
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public void propertybackward(View view) {
        Intent intent = new Intent(PropertyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}


