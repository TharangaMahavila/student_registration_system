package lk.fcpl.web.studentRegistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Course name is required")
    private String name;
    @NotNull(message = "Course duration is required")
    private String duration;
}
