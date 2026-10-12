package in.kumar.JpaRelationship.service;

import in.kumar.JpaRelationship.model.Department;
import in.kumar.JpaRelationship.model.Student;
import in.kumar.JpaRelationship.repository.DepartmentRepository;
import in.kumar.JpaRelationship.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student,Long dept_id){
        Department department=
                departmentRepository.getDepartmentById(dept_id);
        student.setDepartment(department);

        department.getStudentList().add(student);

        studentRepository.create(student);
    }
    @Transactional
    public void createStudent(Student student,String deptName){
        Department department=new Department();
        department.setName(deptName);

        student.setDepartment(department);
        department.getStudentList().add(student);

        departmentRepository.create(department);
        studentRepository.create(student);
    }
    @Transactional
    public void updateStudent(Student student,Long id, Long dept_Id){
        Student student1 = studentRepository.findStudentById(id);

        Department department = departmentRepository.getDepartmentById(dept_Id);

        student1.setName(student.getName());
        student1.setDepartment(department);
    }
}
