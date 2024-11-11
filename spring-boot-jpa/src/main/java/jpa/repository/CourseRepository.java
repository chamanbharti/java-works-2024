package jpa.repository;

import jpa.entity.Course;
import jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
