package com.example.bitcom.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bitcom.test.View.TopBar;

public class MainActivity extends AppCompatActivity {
    private TopBar topBar;
    private String test=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBar=(TopBar) findViewById(R.id.topbar);
        topBar.setOnLeftClickListener(new TopBar.onLeftClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this,"左边",Toast.LENGTH_SHORT).show();
            }
        });


        topBar.setOnRightClickListener(new TopBar.onRightClickListener() {
            @Override
            public void onRightClick() {
                Toast.makeText(MainActivity.this,"右边",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
