package lk.fcpl.web.studentRegistration.dto;

import lk.fcpl.web.studentRegistration.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-26
 **/
@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO implements Serializable {

    @NotNull(message = "Student id is required")
    private String id;
    @NotNull(message = "Student first name is required")
    private String firstName;
    @NotNull(message = "Student last name is required")
    private String lastName;
    private String streetNo;
    @NotNull(message = "First street name is required")
    private String firstStreet;
    private String secondStreet;
    private String town;
    @NotNull(message = "Contact number is required")
    private String contact;
    private Set<CourseDTO> courseList = new HashSet<>();
}
