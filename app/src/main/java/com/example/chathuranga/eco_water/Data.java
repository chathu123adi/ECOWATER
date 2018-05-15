package com.example.chathuranga.eco_water;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Data extends AsyncTask<Void,Void,Void>{

    String data="";
    String saveTheParsedData ="";
    String singleString ="";

    //    background thread
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            //set the Thingspeack get requset url to read the data
            URL url= new URL("https://api.thingspeak.com/channels/366984/feeds.json?results=2");

//            create a connection
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            //input stream
            InputStream inputStream= httpURLConnection.getInputStream();
            //create buffer reader to read the input stream
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));

            //loopoing all the data using while loop
            /*
             *Using this line variable test if the getting input is not null
             * */
            String line="";
            while (line != null){
                line= bufferedReader.readLine();
                data= data+line; // save the each line of the json object as string
            }

            //initilize a JSON object
            JSONObject jsonObject= new JSONObject(data);

            // Get the json only the json object array of "feeds"
            /*{
                "channel": {
                "id": 366984,
                        "name": "Water Quality",
                        "description": "Yarl geek",
                        "latitude": "0.0",
                        "longitude": "0.0",
                        "field1": "Water Quality",
                        "created_at": "2017-11-17T19:37:18Z",
                        "updated_at": "2018-04-02T13:49:11Z",
                        "last_entry_id": 10
              },
                "feeds": [
                {
                    "created_at": "2017-12-10T18:40:45Z",
                        "entry_id": 9,
                        "field1": "552.00"
                },
                {
                    "created_at": "2018-04-02T13:49:11Z",
                        "entry_id": 10,
                        "field1": "0"
                }
                     ]
            }
            *JSON object is like this
            * i'm  getting only the feeds array of json object
            */
            JSONArray jsonArray= jsonObject.getJSONArray("feeds");


            //loop the json oject array of feeds
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jobj= jsonArray.getJSONObject(i);

                singleString = "created_at :" + jobj.getString("created_at") + "\n"+
                        "entry_id :" + jobj.getString("entry_id") + "\n"+
                        "field :" + jobj.getString("field1") + "\n\n\n";

                saveTheParsedData = saveTheParsedData +singleString; // save the all three fields data to saveTheParsedData String variable
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("This is error : " + e);
        }
        catch (JSONException e) {
            System.out.println(e);
        }
        return null;
    }
}
