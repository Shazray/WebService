package com.example.virgi.webservice.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.virgi.webservice.R;
import com.example.virgi.webservice.data.ServiceQueueSingleton;
import com.example.virgi.webservice.data.Telefono;
import com.example.virgi.webservice.logic.GsonRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text);
        final TextView screenSize = (TextView) findViewById(R.id.screenSize);
        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading..");
        dialog.show();
        String url = "https://androidtutorialpoint.com/api/volleyJsonObject";

        GsonRequest jsonObjectReq = new GsonRequest(url, Telefono.class, null,
                new Response.Listener<Telefono>() {
                    @Override
                    public void onResponse(Telefono response) {
                        screenSize.setText("Screensize: "+ response.getScreenSize());

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });







        /*JsonObjectRequest jsonObjectReq = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("SERVICE", "Response: " + response.toString());
                        Toast.makeText(getApplicationContext(), response.toString(),
                                Toast.LENGTH_LONG).show();

                        textView.setText(response.toString());
                        dialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("VOLLEY", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(),
                        Toast.LENGTH_LONG).show();
                textView.setText(error.getMessage());
                dialog.hide();
            }
        });*/



// Access the RequestQueue through your singleton class.
        ServiceQueueSingleton.getInstance(this).addToRequestQueue(jsonObjectReq);




    }


}
