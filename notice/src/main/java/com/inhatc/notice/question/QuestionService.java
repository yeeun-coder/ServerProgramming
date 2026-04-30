package com.inhatc.notice.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inhatc.notice.DataNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
//	public List<Question> getList() {
//		return this.questionRepository.findAll();
//	}
	public List<Question> getList() {
	    return questionRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("Question not found.");
		}
	}
	
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
	public void modify(Integer id, String subject, String content) {
	    Question question = questionRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("데이터 없음"));

	    question.setSubject(subject);
	    question.setContent(content);
	    questionRepository.save(question);
	}
	
	public void delete(Integer id) {
	    Question question = questionRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("데이터 없음"));
	    questionRepository.delete(question);
	}
	
	public List<Question> getListOld() {
	    return questionRepository.findAll(Sort.by(Sort.Direction.ASC, "createDate"));
	}

	public List<Question> getListBySubject() {
	    return questionRepository.findAll(Sort.by("subject"));
	}
	
	public List<Question> search(String keyword) {
	    return questionRepository.findBySubjectContaining(keyword);
	}
}
