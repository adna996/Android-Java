package com.example.zadaca1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        Button but1=(Button)findViewById(R.id.button1);
        Button but2=(Button)findViewById ( R.id.button2 );
        Button but3=(Button)findViewById ( R.id.button3 );

        but1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(MainActivity.this,SecondActivity.class);
                startActivity ( int1 );
            }
        } );
        but2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent ( MainActivity.this, ThirdActivity.class );
                MainActivity.this.startActivity ( int2 );
            }
        } );
        but3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent ( MainActivity.this, FourthActivity.class );
                MainActivity.this.startActivity ( int3 );
            }
        } );
    }

}
