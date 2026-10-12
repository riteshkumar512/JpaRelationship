package in.kumar.JpaRelationship.repository;

import in.kumar.JpaRelationship.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //create
    public void create(Student student){
        entityManager.persist(student);
    }
    //read
    public Student findStudentById(Long id){
       return entityManager.find(Student.class,id);
    }
}
