package lk.fcpl.web.studentRegistration.dao;

import lk.fcpl.web.studentRegistration.entity.Course;
import lk.fcpl.web.studentRegistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
public interface CourseDAO extends JpaRepository<Course, Integer> {
}
