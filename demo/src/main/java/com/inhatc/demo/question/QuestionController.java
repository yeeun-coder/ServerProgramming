package com.inhatc.demo.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inhatc.demo.answer.AnswerForm;
import com.inhatc.demo.question.QuestionForm;

import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
//		List<Question> questionList = this.questionRepository.findAll();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String create(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String create(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
	
//	@PostMapping("/create")
//	public String create(@RequestParam("subject") String subject,
//						@RequestParam("content") String content) {
//		this.questionService.create(subject, content);
//		return "redirect:/question/list";
//	}
}

////import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class QuestionController {
//	@GetMapping("/question/list")
////	@ResponseBody
//	public String list() {
//		return "question_list";
//	}
//}
