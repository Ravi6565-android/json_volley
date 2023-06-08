package com.example.my_j_son_h.comments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_j_son_h.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url="https://jsonplaceholder.typicode.com/comments";
    RecyclerView recyclerView;
ArrayList<data_manager> data= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manage= new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manage);
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array= new JSONArray(response);
                    for (int i=0;i<100;i++){
                        JSONObject mainobj=array.getJSONObject(i);
                        int id=mainobj.getInt("id");
                        String name=mainobj.getString("name");
                        String comment=mainobj.getString("body");
                        String email=mainobj.getString("email");
                        data_manager manager= new data_manager(id,name,email,comment);
                        data.add(manager);


                   }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);


        Adapter adapter= new Adapter(this,data);
        recyclerView.setAdapter(adapter);
    }
}