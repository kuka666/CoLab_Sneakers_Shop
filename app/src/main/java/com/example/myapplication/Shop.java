package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AppCompatActivity {
    private final String JSON_URL = "https://gist.githubusercontent.com/kuka666/fbd90ddb0bc91e4baea5ebed9961a9b3/raw/5d6e5747126052d8aa6ae1f000c3abeb06752da8/Sneakers_Colab.json" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Sneakers> lstAnime ;
    private RecyclerView recyclerView ;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        lstAnime = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    public void ClickMenu(View view) {
        //buka drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view) {
        recreate();
    }

    public void ClickAboutUs(View view) {
        MainActivity.redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view) {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Sneakers anime = new Sneakers() ;
                        anime.setName(jsonObject.getString("title"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setPrice(jsonObject.getString("retailPrice"));
                        JSONObject img = jsonObject.getJSONObject("media");
                        anime.setImage_url(img.getString("smallImageUrl"));
                        lstAnime.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstAnime);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(Shop.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Sneakers> lstAnime) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}