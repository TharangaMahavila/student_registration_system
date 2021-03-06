package lk.fcpl.web.studentRegistration.business.util;

import lk.fcpl.web.studentRegistration.dto.CourseDTO;
import lk.fcpl.web.studentRegistration.entity.Course;
import org.mapstruct.Mapper;

import java.util.Set;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-03-06
 **/
@Mapper(componentModel = "spring")
public interface CourseListMapper {
    Set<Course> getCourseList(Set<CourseDTO> courseDTOSet);
    Set<CourseDTO> getCourseDTOList(Set<Course> courseSet);
}
