package lk.fcpl.web.studentRegistration.api;

import lk.fcpl.web.studentRegistration.business.custom.CourseBO;
import lk.fcpl.web.studentRegistration.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-23
 **/
@RequestMapping("/api/v1/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseBO courseBO;

    public CourseController() throws SQLException {
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<CourseDTO>> getAllcourses() throws Exception {
        return new ResponseEntity<List<CourseDTO>>(courseBO.findAllCourses(),HttpStatus.OK);
    }

    @GetMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Object> getCourseById(@PathVariable Integer courseId) throws Exception {
        System.out.println(courseId);
        try{
            return new ResponseEntity<>(courseBO.findCourse(courseId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("No Course Found",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> saveCourse(@Valid @RequestBody CourseDTO dto) throws Exception {
        try{
            courseBO.saveCourse(dto);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId) throws Exception {
        try{
            courseBO.findCourse(courseId);
            courseBO.deleteCourse(courseId);
            return new ResponseEntity<>("Successfully deleted the course",HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("No course exist",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{courseId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> updateCourse(@Valid @RequestBody CourseDTO dto, @PathVariable Integer courseId) throws Exception{
        if (dto.getId() != Integer.valueOf(courseId)){
            return new ResponseEntity<>("Mismatched Id",HttpStatus.BAD_REQUEST);
        }
        try{
            courseBO.findCourse(courseId);
            courseBO.updateCourse(dto);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("No course exist", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
