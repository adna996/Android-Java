package com.example.baza.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baza.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

    @Query("delete from student_table")
    void clean();

    @Query("select * from student_table order by ime, prezime asc")
    List<Student> listOrderByName();

    @Query("select * from student_table where id = :id")
    Student loadStudentById(int id);
}
