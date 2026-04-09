package com.inhatc.demo.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inhatc.demo.question.Question;

public interface AnswerRepository extends JpaRepository<Answer,Integer>{

}
