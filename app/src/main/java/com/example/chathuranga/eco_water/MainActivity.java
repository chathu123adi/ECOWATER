package com.example.chathuranga.eco_water;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare the button
    Button click, exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initialize the button and identify it using xml id
        click = (Button)findViewById(R.id.info);

        exit = (Button)findViewById(R.id.exit);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfo();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    public void getInfo(){
        Intent infoActivity= new Intent(this, Fetch_data.class);
        startActivity(infoActivity);
    }
}
