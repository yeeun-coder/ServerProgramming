package com.inhatc.notice.baseball;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseballController {
	@GetMapping("/baseball")
    @ResponseBody
    public String baseball() {

        Random random = new Random();
        int[] num = new int[4];

        for (int i = 0; i < 4; i++) {
            num[i] = random.nextInt(10);

            for (int j = 0; j < i; j++) {
                if (num[i] == num[j]) {
                    i--;
                    break;
                }
            }
        }

        return "baseball number : " + num[0] + num[1] + num[2] + num[3];
    }
}
