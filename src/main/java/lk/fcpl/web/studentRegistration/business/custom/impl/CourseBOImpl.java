package lk.fcpl.web.studentRegistration.business.custom.impl;

import lk.fcpl.web.studentRegistration.business.custom.CourseBO;
import lk.fcpl.web.studentRegistration.dao.CourseDAO;
import lk.fcpl.web.studentRegistration.dto.CourseDTO;
import lk.fcpl.web.studentRegistration.business.util.EntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
@Transactional
@Service
public class CourseBOImpl implements CourseBO {

    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private EntityDTOMapper mapper;

    public CourseBOImpl() {
    }

    @Override
    public void saveCourse(CourseDTO dto) throws Exception {
        courseDAO.save(mapper.getCourse(dto));
    }

    @Override
    public void updateCourse(CourseDTO dto) throws Exception {
        courseDAO.save(mapper.getCourse(dto));
    }

    @Override
    public void deleteCourse(Integer id) throws Exception {
        courseDAO.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourseDTO> findAllCourses() throws Exception {
       return courseDAO.findAll().stream().map(course -> mapper.getCourseDTO(course)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findCourse(Integer courseId) throws Exception {
        return courseDAO.findById(courseId).map(course -> mapper.getCourseDTO(course)).get();
    }
}
