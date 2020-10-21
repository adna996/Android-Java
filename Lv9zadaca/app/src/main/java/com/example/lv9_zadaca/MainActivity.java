package com.example.lv9_zadaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity<bt1> extends AppCompatActivity {
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        bt1 = findViewById ( R.id.button1 );
        bt2 = findViewById ( R.id.button2 );
        bt3 = findViewById ( R.id.button3 );
        bt4 = findViewById ( R.id.button4 );
        bt5 = findViewById ( R.id.button5 );
        bt1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (), simpleTabs.class );
                startActivity ( intent );
            }
        }  );
        bt2.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (), scrollableTabs.class );
                startActivity ( intent );
            }
        }) ;
        bt3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (),IconTextTabs.class );
                startActivity ( intent );
            }
        } );
        bt4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (),IconTabs.class );
                startActivity ( intent );
            }
        } );
        bt5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (),Bottom.class );
                startActivity ( intent );
            }
        } );


    }

}
