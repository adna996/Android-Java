package com.example.baza.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.baza.AppDatabase;
import com.example.baza.R;
import com.example.baza.entity.Student;

public class AddActivity extends AppCompatActivity {
    protected static AppDatabase appDatabase;
    private EditText ime, prezime;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_add );

        ime = findViewById (R.id.imeET);
        prezime = findViewById ( R.id.prezimeET );
        saveBtn = findViewById ( R.id.saveBT );

        saveBtn.setOnClickListener (new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                String studentname = ime.getText ().toString ();
                String studentLastname = prezime.getText ().toString ();

                Student student = new Student ();
                student.setIme ( studentname );
                student.setPrezime ( studentLastname );
                appDatabase.getStudentService().saveOrUpdate(student);
                Intent intent = new Intent ( getApplicationContext (), ListActivity.class );
                startActivity ( intent );

            }
        }) ;

        setMyDatabase(String.valueOf(R.string.student_service));
    }

    private void setMyDatabase(String serviceName) {
        appDatabase = AppDatabase.getInsanceByContextAndService(this, serviceName);
    }

    /*public void backToList(View view) {

        Intent intent = new Intent ( getApplicationContext (), ListActivity.class );
        startActivity ( intent );
    }*/
}
