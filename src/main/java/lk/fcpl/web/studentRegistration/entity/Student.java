package lk.fcpl.web.studentRegistration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-24
 **/
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "student")
public class Student implements SuperEntity{

    @Id @NotNull(message = "Student ID is reqired field")
    @Pattern(regexp = "S\\d{3}")
    private String id;
    @NotNull(message = "Student first name is required field")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "Student last name is required field")
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "street_no")
    private String streetNo;
    @Column(name = "first_street")
    private String firstStreet;
    @Column(name = "second_street")
    private String secondStreet;
    private String town;
    @NotNull(message = "Student contact number is required")
    private String contact;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Course> courseList = new HashSet<>();
}
