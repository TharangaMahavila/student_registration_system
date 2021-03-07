package lk.fcpl.web.studentRegistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-26
 **/
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "course")
public class Course implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotNull(message = "Course name is reqired")
    @Size(min = 3,message = "Course Name should be at least 3 characters")
    @NotEmpty(message = "Course name should not be empty") @NotBlank(message = "Course name should not be blank")
    private String name;
    @NotNull(message = "Course duration is reqired")
    @NotEmpty(message = "Course duration should not be empty") @NotBlank(message = "Course duration should not be blank")
    private String duration;
}
