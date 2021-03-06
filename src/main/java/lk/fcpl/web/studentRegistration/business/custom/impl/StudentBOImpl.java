package lk.fcpl.web.studentRegistration.business.custom.impl;

import lk.fcpl.web.studentRegistration.business.custom.StudentBO;
import lk.fcpl.web.studentRegistration.business.util.EntityDTOMapper;
import lk.fcpl.web.studentRegistration.dao.StudentDAO;
import lk.fcpl.web.studentRegistration.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-26
 **/
@Transactional
@Service
public class StudentBOImpl implements StudentBO {

    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private EntityDTOMapper mapper;

    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        studentDAO.save(mapper.getStudent(dto));
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        studentDAO.save(mapper.getStudent(dto));
    }

    @Override
    public void deleteStudent(String studentId) throws Exception {
        studentDAO.deleteById(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findAllStudents() throws Exception {
        return studentDAO.findAll().stream().map(student -> mapper.getStudentDTO(student)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO findStudent(String studentId) throws Exception {
        return studentDAO.findById(studentId).map(rack -> mapper.getStudentDTO(rack)).get();
    }
}
