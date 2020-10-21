package com.example.baza;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.baza.dao.StudentDao;
import com.example.baza.entity.Student;
import com.example.baza.service.StudentService;

@Database(entities = {
        Student.class
    }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    private StudentService studentService;

    public abstract StudentDao getStudentDao();


    private static AppDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context, AppDatabase.class,
                String.valueOf(R.string.db_name)).allowMainThreadQueries().build();
    }

    private  static AppDatabase setService(String serviceName){
        if(serviceName.equals(String.valueOf(R.string.student_service))){
            appDatabase.setStudentService(new StudentService(appDatabase.getStudentDao()));
        }
        // ovdje idu ostali servisi ako ih ima

        return appDatabase;
    }

    private static AppDatabase setAllServices(){
        appDatabase.setStudentService(new StudentService(appDatabase.getStudentDao()));

        return appDatabase;
    }

    public static AppDatabase getInsanceByContextAndService(Context context, String serviceName){
        if(appDatabase == null){
            appDatabase = buildDatabaseInstance(context);
        }

        if(serviceName.equals(String.valueOf(R.string.all_services))){
            appDatabase = setAllServices();
        } else {
            appDatabase = setService(serviceName);
        }

        return appDatabase;
    }


    public static  void cleanDatabase(Context context){
        if(appDatabase == null){
            appDatabase = buildDatabaseInstance(context);
        }

        setAllServices();
        appDatabase.getStudentService().deleteAllStudents();
    }



    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
