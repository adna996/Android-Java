package com.example.autori;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button showList;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList = findViewById ( R.id.showList );

        showList.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (), ListActivity.class );
                startActivity ( intent );
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate ( R.menu.autor_menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId ();

        if(id == R.id.item1){
            Intent intent = new Intent ( context, AddPerson.class );
            startActivity ( intent );
        }
        return super.onOptionsItemSelected ( item );
    }

    public void onAddAutor(View view) {
        Intent intent = new Intent ( context, AddPerson.class );
        startActivity ( intent );
    }

    public void onAutorClick(int position){
        Intent intent = new
                Intent ( context, AddPerson.class );
        startActivity ( intent );
    }
}
