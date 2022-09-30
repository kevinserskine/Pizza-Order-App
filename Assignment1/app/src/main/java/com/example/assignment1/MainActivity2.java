package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //Variables initialized
    TextView nText, aText, pText, eText;
    TextView specIns, pay, top, pizzasize;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Strings received from activity1 are stored in new strings
        String total = ("Total = " + (getIntent().getStringExtra("keyTotal")));
        String toppings = ("Toppings: " + (getIntent().getStringExtra("keyToppings")));
        String size = ("Size: " + (getIntent().getStringExtra("keySize")));
        String sIns = ("Special Instructions: " + (getIntent().getStringExtra("keyInstructions")));
        String name = ("Name: " + (getIntent().getStringExtra("keyName")));
        String address = ("Address: " + (getIntent().getStringExtra("keyAddress")));
        String phone = ("Phone Number: " + (getIntent().getStringExtra("keyPhone")));
        String email = ("Email: " + (getIntent().getStringExtra("keyEmail")));

        //Variables are set using id
        pay = findViewById(R.id.price);
        top = findViewById(R.id.pTop);
        pizzasize = findViewById(R.id.pSize);
        specIns = findViewById(R.id.sInst);
        nText = findViewById(R.id.nameText);
        aText = findViewById(R.id.addressText);
        pText = findViewById(R.id.phoneText);
        eText = findViewById(R.id.emailText);

        //TextViews are changed to display information obtained from activity1
        pay.setText(total);
        top.setText(toppings);
        pizzasize.setText(size);
        specIns.setText(sIns);
        nText.setText(name);
        aText.setText(address);
        pText.setText(phone);
        eText.setText(email);
    }
}