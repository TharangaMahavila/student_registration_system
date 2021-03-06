package lk.fcpl.web.studentRegistration.business.custom;

import lk.fcpl.web.studentRegistration.business.SuperBO;
import lk.fcpl.web.studentRegistration.dto.CourseDTO;

import java.util.List;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
public interface CourseBO extends SuperBO {

    public void saveCourse(CourseDTO dto) throws Exception;
    public void updateCourse(CourseDTO dto) throws Exception;
    public void deleteCourse(Integer CourseId) throws Exception;
    public List<CourseDTO> findAllCourses() throws Exception;
    public CourseDTO findCourse(Integer CourseId) throws Exception;
}
