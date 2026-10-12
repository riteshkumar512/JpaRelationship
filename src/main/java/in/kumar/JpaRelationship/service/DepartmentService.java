package in.kumar.JpaRelationship.service;

import in.kumar.JpaRelationship.model.Department;
import in.kumar.JpaRelationship.model.Student;
import in.kumar.JpaRelationship.repository.DepartmentRepository;
import in.kumar.JpaRelationship.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.create(department);
    }
    @Transactional
    public void createDepartment(Department department,String name) {
        Student student = new Student();
        student.setName(name);
        student.setDepartment(department);

        department.getStudentList().add(student);

        studentRepository.create(student);
        departmentRepository.create(department);
    }


}
