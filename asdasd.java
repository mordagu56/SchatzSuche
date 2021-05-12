package com.example.lukas.citybike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String CITY_MESSAGE = "city";
    public static final String NUM_TAKEN_MESSAGE = "numTaken";
    public static final String NUM_BIKES_MESSAGE = "numBikes";

    private HashMap<String, String> cityURLMap = new HashMap<String, String>() {{
        put("Vienna", "http://api.citybik.es/v2/networks/citybike-wien");
        put("Paris", "http://api.citybik.es/v2/networks/velib");
        put("London", "http://api.citybik.es/v2/networks/santander-cycles");
    }};

    private Spinner citySpinner;
    private Button confirmButton;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new ArrayList<String>(cityURLMap.keySet()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner = findViewById(R.id.citySpinner);
        citySpinner.setAdapter(adapter);

        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);
    }

    private void processResult(JSONObject apiResponse, String selectedCity) {
        try {
            int freeBikes = 0;
            int emptySlots = 0;

            JSONArray stations = apiResponse.getJSONObject("network").getJSONArray("stations");
            for (int i = 0; i < stations.length(); ++i) {
                JSONObject station = stations.getJSONObject(i);
                freeBikes += station.getInt("free_bikes");
                emptySlots += station.getInt("empty_slots");
            }

            float total = freeBikes + emptySlots;
            float taken = (emptySlots / total) * 100;

            Intent result = new Intent(this, ResultScreen.class);
            result.putExtra(CITY_MESSAGE, selectedCity);
            result.putExtra(NUM_TAKEN_MESSAGE, Float.toString(taken));
            result.putExtra(NUM_BIKES_MESSAGE, Float.toString(total));
            startActivity(result);
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this,
                    "Could not parse API response!",
                    Toast.LENGTH_LONG).show();
            Log.e("PARSER_ERROR", e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
        final String selectedCity = citySpinner.getSelectedItem().toString();
        String URL = cityURLMap.get(selectedCity);

        JsonRequest cityBikeRequest = new JsonObjectRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("API_RESPONSE", response.toString());
                        processResult(response, selectedCity);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,
                                "Please try again!",
                                Toast.LENGTH_LONG).show();
                        Log.e("API_ERROR", error.getMessage());
                    }
                });
        requestQueue.add(cityBikeRequest);
    }
}
