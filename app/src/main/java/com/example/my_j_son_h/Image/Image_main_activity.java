package com.example.my_j_son_h.Image;

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
import com.example.my_j_son_h.Image.comments.image_adapter;
import com.example.my_j_son_h.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Image_main_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    String url="https://jsonplaceholder.typicode.com/photos";
    ArrayList<imagedata> imagedata= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_main);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        RequestQueue queue= Volley.newRequestQueue(Image_main_activity.this);

        StringRequest request= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array= new JSONArray(response);
                    for (int i=0;i<response.length();i++){

                        JSONObject object= array.getJSONObject(i);
                        int id=object.getInt("id");
                        String title=object.getString("title");
                        String image= object.getString("url");
                        imagedata imagedata1= new imagedata(id,title,url);
                        imagedata.add(imagedata1);
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

        image_adapter adapter= new image_adapter(Image_main_activity.this,imagedata);

        recyclerView.setAdapter(adapter);

    }
}