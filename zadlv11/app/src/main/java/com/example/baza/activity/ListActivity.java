package com.example.baza.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baza.AppDatabase;
import com.example.baza.R;
import com.example.baza.adapter.StudentAdapter;
import com.example.baza.entity.Student;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    protected static AppDatabase appDatabase;
    private List<Student> studentList;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setMyDatabase(String.valueOf(R.string.student_service));
        setUpMyRecyclerView();
    }

    public void openAddActivity(View view) {
        // todo zavrsiti
        Intent intent = new Intent ( getApplicationContext (), AddActivity.class );
        startActivity ( intent );
    }

    private void setMyDatabase(String serviceName){
        appDatabase = AppDatabase.getInsanceByContextAndService(this, serviceName);
    }


    private void setUpMyRecyclerView(){

        studentList = appDatabase.getStudentService().listAll();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new StudentAdapter(studentList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
