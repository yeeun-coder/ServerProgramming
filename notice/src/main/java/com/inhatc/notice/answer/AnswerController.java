package com.inhatc.notice.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inhatc.notice.question.Question;
import com.inhatc.notice.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String create(@PathVariable("id") Integer qid,
						@RequestParam("content") String content) {
		Question question = this.questionService.getQuestion(qid);
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", qid);
	}
}
