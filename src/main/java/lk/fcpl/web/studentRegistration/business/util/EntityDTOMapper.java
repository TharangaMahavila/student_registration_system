package lk.fcpl.web.studentRegistration.business.util;

import lk.fcpl.web.studentRegistration.dto.CourseDTO;
import lk.fcpl.web.studentRegistration.dto.StudentDTO;
import lk.fcpl.web.studentRegistration.entity.Course;
import lk.fcpl.web.studentRegistration.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
@Mapper(componentModel = "spring", uses = {CourseListMapper.class})
public interface EntityDTOMapper {

    Student getStudent(StudentDTO dto);
    StudentDTO getStudentDTO(Student student);
    CourseDTO getCourseDTO(Course course);
    Course getCourse(CourseDTO dto);
}
