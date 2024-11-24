package com.activecourses.upwork.repository.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activecourses.upwork.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    
}
