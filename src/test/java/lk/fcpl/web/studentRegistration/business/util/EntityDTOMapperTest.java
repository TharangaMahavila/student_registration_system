package lk.fcpl.web.studentRegistration.business.util;

import lk.fcpl.web.studentRegistration.dto.CourseDTO;
import lk.fcpl.web.studentRegistration.dto.StudentDTO;
import lk.fcpl.web.studentRegistration.entity.Course;
import lk.fcpl.web.studentRegistration.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/

@SpringBootTest
class EntityDTOMapperTest {

    @Autowired
    EntityDTOMapper mapper;
    @Autowired
    CourseListMapper courseListMapper;

    @Test
    void getCourse() {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(1);
        courseDTO.setName("Diploma in JAVA");
        Course course = mapper.getCourse(courseDTO);
        assertEquals(course.getName(),"Diploma in JAVA");
    }

    @Test
    public void getCourseDTO() {
        Course course = new Course();
        course.setId(1);
        course.setName("Diploma in JAVA");
        course.setDuration("4 months");
        CourseDTO courseDTO = mapper.getCourseDTO(course);
        assertEquals(courseDTO.getId(), 1);
    }

    @Test
    public void getStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId("S001");
        studentDTO.setFirstName("Tharanga");
        studentDTO.setLastName("Mahavila");
        studentDTO.setStreetNo("01");
        studentDTO.setFirstStreet("Arachchihena");
        studentDTO.setSecondStreet("Thiththagalla");
        studentDTO.setTown("Ahangama");
        studentDTO.setContact("0777215112");
        Set<CourseDTO> courseDTOSet = new HashSet<>();
        courseDTOSet.add(new CourseDTO(1,"Diploma in JAVA","4 months"));
        courseDTOSet.add(new CourseDTO(2,"Diploma in Angular","4 months"));
        courseDTOSet.add(new CourseDTO(3,"Diploma in Spring","4 months"));
        studentDTO.setCourseList(courseDTOSet);
        Student student = mapper.getStudent(studentDTO);
        System.out.println(student);
    }

    @Test
    public void getStudentDTO() {

        Student student = new Student();
        student.setId("S001");
        student.setFirstName("Tharanga");
        student.setLastName("Mahavila");
        student.setStreetNo("01");
        student.setFirstStreet("Arachchihena");
        student.setSecondStreet("Thiththagalla");
        student.setTown("Ahangama");
        student.setContact("0777215112");
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(new Course(1,"Diploma in JAVA","4 months"));
        courseSet.add(new Course(2,"Diploma in Angular","4 months"));
        courseSet.add(new Course(3,"Diploma in Spring","4 months"));
        student.setCourseList(courseSet);
        StudentDTO studentDTO = mapper.getStudentDTO(student);
        System.out.println(studentDTO);

    }

    @Test
    public void getCourseList() {

        Set<CourseDTO> courseDTOSet = new HashSet<>();
        courseDTOSet.add(new CourseDTO(1,"Diploma in JAVA","4 months"));
        courseDTOSet.add(new CourseDTO(2,"Diploma in Angular","6 months"));
        courseDTOSet.add(new CourseDTO(3,"Diploma in Spring","6 months"));
        Set<Course> courseList = courseListMapper.getCourseList(courseDTOSet);
        courseList.forEach(System.out::println);
    }

    @Test
    public void getCourseDTOList() {
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(new Course(1,"Diploma in JAVA","4 months"));
        courseSet.add(new Course(2,"Diploma in Angular","6 months"));
        courseSet.add(new Course(3,"Diploma in Spring","6 months"));
        Set<CourseDTO> courseDTOSet = courseListMapper.getCourseDTOList(courseSet);
        courseDTOSet.forEach(System.out::println);
    }
}
