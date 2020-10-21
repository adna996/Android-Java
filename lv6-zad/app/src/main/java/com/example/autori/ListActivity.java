package com.example.autori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private AutorAdapter autorAdapter;
    private ArrayList<Autor> autorList;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById ( R.id.lista);
        layoutManager = new LinearLayoutManager ( context );
        recyclerView.setLayoutManager ( layoutManager );

        autorList = getAutorList();
        autorAdapter = new AutorAdapter ( autorList );
        recyclerView.setAdapter ( autorAdapter );


        /*add = findViewById ( R.id.addFAB );
        add.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext (), AddPerson.class );
                startActivity ( intent );
            }
        } );*/
        // ToDo: pristupiti RecyclerView-u, kreirati LayouManager i adapter, postaviti adapter na recyclerView
        // ToDo: kreirati listu autora i poslati tu listu adapteru
    }

    private ArrayList<Autor> getAutorList(){
        ArrayList<Autor> autori = new ArrayList<> ();

        Autor autor = new Autor ();
        autor.setFirstName ( "Meša" );
        autor.setLastName ( "Selimović" );
        autor.setObjave ( 35 );
        autor.setBookName ( "Tvrdjava" );
        autor.setProdaja ( 1345 );
        autori.add ( autor );

        autor = new Autor ();
        autor.setFirstName ( "Franz" );
        autor.setLastName ( "Kafka" );
        autor.setObjave ( 100 );
        autor.setBookName ( "Proces" );
        autor.setProdaja ( 2000 );
        autori.add ( autor );

        autor = new Autor ();
        autor.setFirstName ( "Nura" );
        autor.setLastName ( "Bazdulj Hubijar" );
        autor.setObjave ( 25 );
        autor.setBookName ( "Ljubav je sihirbaz babo!" );
        autor.setProdaja ( 890 );
        autori.add ( autor );

        autor = new Autor ();
        autor.setFirstName ( "Lav" );
        autor.setLastName ( "Nikolajevič Tolstoj" );
        autor.setObjave ( 104 );
        autor.setBookName ( "Ana Karenjina" );
        autor.setProdaja ( 1877 );
        autori.add ( autor );

        return autori;
    }
}
