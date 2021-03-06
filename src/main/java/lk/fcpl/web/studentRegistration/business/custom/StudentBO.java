package lk.fcpl.web.studentRegistration.business.custom;

import lk.fcpl.web.studentRegistration.business.SuperBO;
import lk.fcpl.web.studentRegistration.dto.StudentDTO;

import java.util.List;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-26
 **/
public interface StudentBO extends SuperBO {

    public void saveStudent(StudentDTO dto) throws Exception;
    public void updateStudent(StudentDTO dto) throws Exception;
    public void deleteStudent(String studentId) throws Exception;
    public List<StudentDTO> findAllStudents() throws Exception;
    public StudentDTO findStudent(String studentId) throws Exception;

}
