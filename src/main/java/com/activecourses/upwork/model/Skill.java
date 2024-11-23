package com.activecourses.upwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer id;

    @Column(name = "skill_name", nullable = false, unique = true, length = 50)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Job> jobs;

    @ManyToMany(mappedBy = "skills")
    private Set<UserProfile> userProfiles;
}
