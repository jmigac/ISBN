package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitapp.fragments.BarcodeFragment;
import com.example.registracija.Registracija;

import java.util.ArrayList;

public class Glavni_Izbornik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavni__izbornik);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View logoView = getToolbarLogoView(toolbar);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(Glavni_Izbornik.this, Profil.class);
                    startActivity(i);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        Button btnPokreniSkener = findViewById(R.id.btnBarkodSkener);
        btnPokreniSkener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnBarkodSkener:
                        try{
                            System.out.println("Pokrenul activity barkoda!");
                            startActivity(new Intent(Glavni_Izbornik.this,BarkodSkenerActivity.class));

                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
        });
/*
        Button button = (Button) findViewById(R.id.registracija);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.registracija:

                        Intent intent = new Intent(Glavni_Izbornik.this, Registracija.class);
                        startActivity(intent);
                        break;
                }

            }
        });

         */
    }

    public static View getToolbarLogoView(Toolbar toolbar){
        boolean hadContentDescription = android.text.TextUtils.isEmpty(toolbar.getLogoDescription());
        String contentDescription = String.valueOf(!hadContentDescription ? toolbar.getLogoDescription() : "logoContentDescription");
        toolbar.setLogoDescription(contentDescription);
        ArrayList<View> potentialViews = new ArrayList<View>();
        toolbar.findViewsWithText(potentialViews,contentDescription, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        View logoIcon = null;

        if(potentialViews.size() > 0){
            logoIcon = potentialViews.get(0);
        }

        if(hadContentDescription)
            toolbar.setLogoDescription(null);

        return logoIcon;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

         if(id==R.id.search){
            Toast.makeText(getApplicationContext(), "You can click search", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.settings){
            Toast.makeText(getApplicationContext(), "You can click settings", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
     */
}
