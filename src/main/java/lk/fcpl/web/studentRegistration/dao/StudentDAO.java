package lk.fcpl.web.studentRegistration.dao;

import lk.fcpl.web.studentRegistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-03-06
 **/
public interface StudentDAO extends JpaRepository<Student, String> {
}
