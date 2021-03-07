package lk.fcpl.web.studentRegistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
@Data @AllArgsConstructor @NoArgsConstructor
public class CourseDTO implements Serializable {

    private int id;
    @NotNull(message = "Course name is reqired")
    @Size(min = 3,message = "Course Name should be at least 3 characters")
    @NotEmpty(message = "Course name should not be empty") @NotBlank(message = "Course name should not be blank")
    private String name;
    @NotNull(message = "Course duration is reqired")
    @NotEmpty(message = "Course duration should not be empty") @NotBlank(message = "Course duration should not be blank")
    private String duration;
}
