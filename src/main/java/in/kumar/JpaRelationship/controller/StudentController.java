package in.kumar.JpaRelationship.controller;

import in.kumar.JpaRelationship.model.Department;
import in.kumar.JpaRelationship.model.Student;
import in.kumar.JpaRelationship.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("Student Created");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("Student Created");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,
                                                @PathVariable Long id,
                                                @RequestParam("deptId") Long deptId){
        studentService.updateStudent(student,id,deptId);
        return ResponseEntity.ok("Updated Successfully");
    }
}
