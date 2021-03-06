package lk.fcpl.web.studentRegistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
@Data @AllArgsConstructor @NoArgsConstructor
public class CourseDTO implements Serializable {

    private int id;
    @NotNull(message = "Course name is reqired")
    private String name;
    @NotNull(message = "Course duration is reqired")
    private String duration;
}
