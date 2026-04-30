package com.inhatc.demo.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	// 메시지 없이
	@NotEmpty(message="Subject is required.")
	@Size(max=100)
	private String subject;
	
	// 메시지 추가
//	@NotEmpty(message="Subject is required.")
//	@Size(max=10, message="Check!")
//	private String subject;
	
	// 최대값 출력 - {max}
//	@NotEmpty(message="Subject is required.")
//	@Size(max=10, message="Check {max}")
//	private String subject;
	
	// 입력한 값 출력- '${validatedValue}'
//	@NotEmpty(message="Subject is required.")
//	@Size(max=10, message="Input: '${validatedValue}'")
//	private String subject;
	
	@NotEmpty(message="Content is required.")
	private String content;
}
