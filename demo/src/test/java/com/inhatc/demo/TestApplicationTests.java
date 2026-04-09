package com.inhatc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.inhatc.demo.answer.Answer;
import com.inhatc.demo.answer.AnswerRepository;
import com.inhatc.demo.question.Question;
import com.inhatc.demo.question.QuestionRepository;

@SpringBootTest
public class TestApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		List<Answer> answers = q.getAnswers();
		assertEquals(1, answers.size());
		assertEquals("있습니다.", answers.get(0).getContent());
	}
	
//	@Test
//	void testJPA() {
//		Optional<Answer> oa = this.answerRepository.findById(2);  // ID 1번 행 가져오기
//		assertTrue(oa.isPresent());  // assert 행 존재 여부 확인
//		Answer a = oa.get();  // 바로 사용할 수 있는 인스턴스로 바꾸기
//		assertEquals(2, a.getQuestion().getId());
//	}
	
//	@Test
//	void testJPA() {
//		Optional<Question> oq = this.questionRepository.findById(2);  // ID 2번 행 가져오기
//		assertTrue(oq.isPresent());  // assert 행 존재 여부 확인
//		Question q = oq.get();  // 바로 사용할 수 있는 인스턴스로 바꾸기
//		Answer a = new Answer();  // 답변(Answer) 객체 생성
//		a.setContent("있습니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);  // 저장하기
//	}
	
//	@Test
//	void testfindBySubjectLike() {
//		assertEquals(2, this.questionRepository.count());  // assert로 전체 개수 확인
//		Optional<Question> oq = this.questionRepository.findById(1);  // ID 1번 행 가져오기
//		assertTrue(oq.isPresent()); // assert 행 존재 여부 확인
//		Question q = oq.get();
//		this.questionRepository.delete(q);  // 해당 행을 삭제하기
//		assertEquals(1, this.questionRepository.count());  // 삭제 후 개수 확인
//	}
	
//	@Test
//	void testfindBySubjectLike() {
//		// ID 1번 제목을 "질문"으로 바꾸기
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("질문");
//		this.questionRepository.save(q);
//	}
	
//	@Test
//	void testfindBySubjectLike() {
//		List<Question> list = this.questionRepository.findBySubjectLike("%스프링%");
//		assertEquals(1, list.size());
//	}
	
//	@Test
//	void testfindBySubjectAndContent() {
//		Question q = this.questionRepository.findBySubjectAndContent("스프링 부트에 대한 질문", "Spring은 무슨 뜻인가요?");
//		assertEquals(1, q.getId());
//	}
	
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("스프링 부트에 대한 질문");
//		assertEquals(1, q.getId());
//	}

	
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		if (oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("수업에 대한 질문", q.getSubject());
//		}
//	}
	
//	@Test
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		Question q = all.get(0);
//		assertEquals("스프링 부트에 대한 질문", q.getSubject());
//	}
	
//	@Test
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("스프링 부트에 대한 질문");
//		q1.setContent("Spring은 무슨 뜻인가요?");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		Question q2 = new Question();
//		q2.setSubject("수업에 대한 질문");
//		q2.setContent("쉬는 시간은 있나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//	}
}
