package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    RadioGroup sizeOptions;
    RadioButton pizza6, pizza8, pizza10, pizza12;
    TextView order;
    TextView PiTop;
    EditText sIns;
    EditText Name, Address, Phone, Email;
    String Toppings = "";
    String Size = "";
    CheckBox Cheese;
    CheckBox Del;
    int spinCheck;
    double sum;
    DecimalFormat df = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner Top = (Spinner) findViewById(R.id.pToppings);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pToppings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Top.setAdapter(adapter);

        sizeOptions = (RadioGroup) findViewById(R.id.pOptions);
        pizza6 = (RadioButton) findViewById(R.id.pSix);
        pizza8 = (RadioButton) findViewById(R.id.pEight);
        pizza10 = (RadioButton) findViewById(R.id.pTen);
        pizza12 = (RadioButton) findViewById(R.id.pTwelve);

        Button result = (Button) findViewById(R.id.Total);

        order = (TextView) findViewById(R.id.pSize);

        PiTop = (TextView) findViewById(R.id.pTop);

        Cheese = (CheckBox) findViewById(R.id.eCheese);

        Del = (CheckBox) findViewById(R.id.delivery);

        sIns = (EditText) findViewById(R.id.instructions);

        Name = (EditText) findViewById(R.id.name);

        Address = (EditText) findViewById(R.id.address);

        Phone = (EditText) findViewById(R.id.phone);

        Email = (EditText) findViewById(R.id.email);



        sizeOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                chooseSize();
            }

        });

        Top.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                i = Top.getSelectedItemPosition();

                if (i == 1){
                    sum += 5;
                    Toppings = "Mushrooms";
                    spinCheck = 1;

                }else if (i == 2){
                    sum += 5;
                    Toppings = "Sun Dried Tomatoes";
                    spinCheck = 1;

                } else if (i == 3){
                    sum += 7;
                    Toppings = "Chicken";
                    spinCheck = 1;

                } else if (i == 4){
                    sum += 8;
                    Toppings = "Ground Beef";
                    spinCheck = 1;

                } else if (i == 5){
                    sum += 10;
                    Toppings = "Shrimps";
                    spinCheck = 1;

                }else if (i == 6){
                    sum += 5;
                    Toppings = "Pineapples";
                    spinCheck = 1;

                }else if (i == 7){
                    sum += 9;
                    Toppings = "Steak";
                    spinCheck = 1;

                }else if (i == 8){
                    sum += 7;
                    Toppings = "Avocado";
                    spinCheck = 1;

                }else if (i == 9){
                    sum += 5;
                    Toppings = "Tuna";
                    spinCheck = 1;

                }else if (i == 10){
                    sum += 8;
                    Toppings = "Broccoli";
                    spinCheck = 1;

                } else {
                    spinCheck = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String Total = String.valueOf(df.format(sum));
                String PizzaToppings = Toppings;
                String PizzaSize = Size;
                String INS = sIns.getText().toString();
                String name = Name.getText().toString();
                String address = Address.getText().toString();
                String phone = Phone.getText().toString();
                String email = Email.getText().toString();

                errorCheck(name, address, phone, email);


                if(!errorCheck(name, address, phone, email)){

                    Toast.makeText(MainActivity.this,"Fill Out Entire Form", Toast.LENGTH_LONG).show();


                } else {

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("keyTotal", Total);
                    intent.putExtra("keyToppings", PizzaToppings);
                    intent.putExtra("keySize", PizzaSize);
                    intent.putExtra("keyInstructions", INS);
                    intent.putExtra("keyName", name);
                    intent.putExtra("keyAddress", address);
                    intent.putExtra("keyPhone", phone);
                    intent.putExtra("keyEmail", email);

                    startActivity(intent);
                }
            }
        });

        Cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum += 5;
                Toppings += " with Extra Cheese";
            }
        });

        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum += 5;
            }
        });



    }

    public void chooseSize() {
        if (pizza6.isChecked()) {
            sum += 5.50;
            Size = "Round Pizza 6 Slices";
        }

        if (pizza8.isChecked()){
            sum += 7.99;
            Size = "Round Pizza 8 Slices";
        }

        if (pizza10.isChecked()){
            sum += 9.50;
            Size = "Round Pizza 10 Slices";
        }

        if (pizza12.isChecked()){
            sum += 11.38;
            Size= "Round Pizza 12 Slices";
        }

    }

    public boolean errorCheck(String n, String a, String p, String e){

        if(sizeOptions.getCheckedRadioButtonId() == -1 || spinCheck == 0 || n.isEmpty() || a.isEmpty() || p.isEmpty() || e.isEmpty()){
            return false;
        } else{
            return true;
        }
    }


}
