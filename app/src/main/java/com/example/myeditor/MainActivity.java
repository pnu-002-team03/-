package com.example.myeditor;

import android.content.DialogInterface;

import android.content.Intent;

import android.content.SharedPreferences;

import android.graphics.Color;

import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.view.Menu;

import android.view.MenuItem;

import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;

import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1_Font, button2_Font, button3_Font, button4_big, button5_little;
    TextView textview;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button1_Font = (Button)findViewById(R.id.button1);
        button2_Font = (Button)findViewById(R.id.button2);
        button3_Font = (Button)findViewById(R.id.button3);
        button4_big = (Button)findViewById(R.id.button4);
        button5_little = (Button)findViewById(R.id.button5);

        textview = (TextView)findViewById(R.id.textview1);
        button1_Font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface face = Typeface.createFromAsset(getAssets(), "fonts/font1.TTF");

                textview.setText(editText.getText());
                textview.setTypeface(face);

            }
        });
        button2_Font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface face = Typeface.createFromAsset(getAssets(), "fonts/font2.TTF");

                textview.setText(editText.getText());
                textview.setTypeface(face);

            }
        });
        button3_Font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface face = Typeface.createFromAsset(getAssets(), "fonts/font1.TTF");

                textview.setText(editText.getText());
                textview.setTypeface(face);

            }
        });

        button4_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/font1.TTF");

                textview.setText(editText.getText());
                textview.setTextSize(50);

            }
        });
        button5_little.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/font1.TTF");

                textview.setText(editText.getText());
                textview.setTextSize(20);

            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("first", MODE_PRIVATE);

        String savedString = sharedPreferences.getString("sampleString", "");

        editText.setText(savedString);

    }



    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_menu, menu);

        return true;

    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.save:


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("SAVE");

                builder.setMessage("저장하시겠습니까?");

                builder.setIcon(android.R.drawable.ic_dialog_alert);


                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sharedPreferences = getSharedPreferences("first", MODE_PRIVATE);

                        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();


                        // 데이터를 기록한다.

                        sharedPreferencesEditor.putString("sampleString", editText.getText().toString());

                        sharedPreferencesEditor.apply();

                        Toast.makeText(MainActivity.this, editText.getText() + "이(가) 저장되었습니다.", Toast.LENGTH_LONG).show();

                    }

                });

                builder.setNegativeButton("아니오", null);

                builder.create().show();

                return true;


        }

        return super.onOptionsItemSelected(item);

    }



}
