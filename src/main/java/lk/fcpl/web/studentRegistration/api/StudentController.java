package lk.fcpl.web.studentRegistration.api;

import lk.fcpl.web.studentRegistration.business.custom.StudentBO;
import lk.fcpl.web.studentRegistration.business.util.EntityDTOMapper;
import lk.fcpl.web.studentRegistration.dto.StudentDTO;
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
 * @since : 2021-02-26
 **/
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentBO studentBO;
    @Autowired
    private EntityDTOMapper mapper;

    public StudentController() throws SQLException {
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<StudentDTO>> getAllStudents() throws Exception {
        return new ResponseEntity<List<StudentDTO>>(studentBO.findAllStudents(),HttpStatus.OK);
    }

    @GetMapping(value = "/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Object> getStudent(@PathVariable String studentId) throws Exception {
        try{
            return new ResponseEntity<>(studentBO.findStudent(studentId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody StudentDTO dto) throws Exception {
        System.out.println(mapper.getStudent(dto));
        try{
            studentBO.saveStudent(dto);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> deleteStudent(@PathVariable String studentId) throws Exception {
        try{
            studentBO.findStudent(studentId);
            studentBO.deleteStudent(studentId);
            return new ResponseEntity<>("Successfully deleted the Student", HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("No Student exist",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{studentId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> updateStudent(@Valid @RequestBody StudentDTO dto, @PathVariable String studentId) throws Exception{
        if (!dto.getId().equals(studentId)){
            return new ResponseEntity<>("Mismatched Id",HttpStatus.BAD_REQUEST);
        }
        try{
            studentBO.findStudent(studentId);
            studentBO.updateStudent(dto);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("No Student exist", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
