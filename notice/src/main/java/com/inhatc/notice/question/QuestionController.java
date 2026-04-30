package com.inhatc.notice.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
//	@GetMapping("list")
//	public String list(Model model) {
//		List<Question> questionList = this.questionService.getList();
//		model.addAttribute("questionList", questionList);
//		return "question_list";
//	}
	@GetMapping("/list")
	public String list(Model model,
	                   @RequestParam(value="sort", defaultValue="recent") String sort,
	                   @RequestParam(value="keyword", defaultValue="") String keyword) {

	    List<Question> questionList;

	    if (!keyword.isEmpty()) {
	        questionList = questionService.search(keyword);
	    } else if (sort.equals("old")) {
	        questionList = questionService.getListOld();
	    } else if (sort.equals("subject")) {
	        questionList = questionService.getListBySubject();
	    } else {
	        questionList = questionService.getList();
	    }

	    model.addAttribute("questionList", questionList);
	    model.addAttribute("sort", sort);
	    model.addAttribute("keyword", keyword);

	    return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String create() {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("subject") String subject,
						@RequestParam("content") String content) {
		this.questionService.create(subject, content);
		return "redirect:/question/list";
	}
	
	@GetMapping("/modify/{id}")
	public String questionModify(Model model, @PathVariable("id") Integer id) {
	    Question question = questionService.getQuestion(id);
	    model.addAttribute("question", question);
	    return "question_form";
	}
	
	@PostMapping("/modify/{id}")
	public String questionModify(@PathVariable("id") Integer id,
	                             @RequestParam("subject") String subject,
	                             @RequestParam("content") String content) {

	    questionService.modify(id, subject, content);
	    return "redirect:/question/detail/" + id;
	}
	
	@GetMapping("/delete/{id}")
	public String questionDelete(@PathVariable("id") Integer id) {
	    questionService.delete(id);
	    return "redirect:/question/list";
	}
}
