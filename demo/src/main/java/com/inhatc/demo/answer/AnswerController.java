package com.inhatc.demo.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inhatc.demo.question.Question;
import com.inhatc.demo.question.QuestionService;

import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String create(Model model, @PathVariable("id") Integer qid, @Valid AnswerForm
						answerForm, BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(qid);
		if (bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		this.answerService.create(question, answerForm.getContent());
		return String.format("redirect:/question/detail/%s", qid);
	}
	
//	@GetMapping("/answer/create/{id}")
//	public String create(Model model, @PathVariable("id") Integer id) {
//		Question question = this.questionService.getQuestion(id);
//		// 구현
//		return String.format("redirect:/question/detail/%s", id);
//	}
}
