package in.kumar.JpaRelationship.repository;

import in.kumar.JpaRelationship.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    //create
    public void create(Department department){
        entityManager.persist(department);
    }
    //read
    public Department getDepartmentById(Long deptId) {
        return entityManager.find(Department.class,deptId);
    }
}
