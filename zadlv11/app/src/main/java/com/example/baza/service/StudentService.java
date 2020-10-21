package com.example.baza.service;

import com.example.baza.dao.StudentDao;
import com.example.baza.entity.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }



    public List<Student> listAll(){
        return studentDao.listOrderByName();
    }


    private void saveStudent(Student student){
        studentDao.insert(student);
    }


    private void updateStudent(Student student){
        studentDao.update(student);
    }


    public void saveOrUpdate(Student student){
        try {
            saveStudent(student);
        } catch (Exception e){
            updateStudent(student);
        }
    }

    public void deleteStudent(Student student){
        studentDao.delete(student);
    }


    public void deleteAllStudents(){
        studentDao.clean();
    }





    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
