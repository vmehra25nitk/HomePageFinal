package com.example.vedantmehra.homepagefinal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private MenuItem prof, idea, relations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView nav_view = (NavigationView)findViewById(R.id.navView);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent intent = new Intent(HomePage.this, NewPage.class);

                if(id == R.id.myprof){
                    Toast.makeText(HomePage.this, "My Profile", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else if(id == R.id.relat){
                    Toast.makeText(HomePage.this, "My Relations", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else if(id == R.id.idea){
                    Toast.makeText(HomePage.this, "My Idea", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else if(id == R.id.homePage){
                    Toast.makeText(HomePage.this, "Home Page", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else if(id == R.id.notif){
                    Toast.makeText(HomePage.this, "Notification Page", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
                return true;
            }
        });

    }


    void clicked(View view)
    {
        startActivity(new Intent(this,NewPage.class));
    }

    public void Initialize() {
        prof = (MenuItem)findViewById(R.id.myprof);
        idea = (MenuItem)findViewById(R.id.idea);
        relations = (MenuItem)findViewById(R.id.relat);
    }

    public void SetItems(){
        prof.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener) HomePage.this);
        idea.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener) HomePage.this);
        relations.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener) HomePage.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) ||  super.onOptionsItemSelected(item);
    }

}
