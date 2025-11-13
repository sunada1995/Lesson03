package com.seiken_soft.controller;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/duty")
public class DutyRegistController {
//勤怠画面用のコントローラー
//初期表示時はinit()
	@GetMapping("/")
	public String init(Model model) {
		return "registDuty";
	}
	@PostMapping
	public String stamping(Model model) {
		
		LocalTime now = LocalTime.now();
		LocalTime truncatedToSeconds = now.truncatedTo(ChronoUnit.SECONDS);
		
		model.addAttribute("clockinTime",truncatedToSeconds);
		
		return "registDuty";
	}
}
