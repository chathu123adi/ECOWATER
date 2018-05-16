package com.example.chathuranga.eco_water;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fetch_data extends AppCompatActivity {

    // Declare the button
    Button click;
    // Declare the text view
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        // initialize the button and identify it using xml id
        click = (Button)findViewById(R.id.button);
        // initialize the text view and identify it using xml id
        data = (TextView)findViewById(R.id.fetchDate);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                for test the fetchdata class
//                FetchData fetchData= new FetchData();
//                fetchData.execute();

                //create the object of fetchdata class
                Data fetchData2= new Data();
                //execute the class
                fetchData2.execute();
            }
        });




    }
}
