package service;

import dao.StudentDao;
import domain.Student;

import java.util.List;

/**
 * Created by john on 15-10-14.
 */
public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> listAll() {
        return studentDao.findAll();
    }

    public void addOneStudent(Student student) {
        studentDao.persist(student);

    }

    public Student find(int id, Class<Student> studentClass) {
        return studentDao.find(id);
    }

    public void delSelectedStudents(Integer[] selected) {

        studentDao.delSelectedStudents(selected);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);

    }
}
