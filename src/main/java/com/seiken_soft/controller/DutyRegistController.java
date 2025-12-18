package com.seiken_soft.controller;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String stamping
	(@RequestParam("stamping") String stampingValue,@RequestParam("shainIdNumber") String shainIdNumber,Model model) {
		
		LocalTime now = LocalTime.now();
		LocalTime truncatedToSeconds = now.truncatedTo(ChronoUnit.SECONDS);
		
		//出勤ボタン押下時		
		if("clockin".equals(stampingValue)) {
			if(shainIdNumber == "") {
				return "registDuty";
			}
			model.addAttribute("shainIdText",shainIdNumber);
			model.addAttribute("clockinTime",truncatedToSeconds);
		}
		//退勤ボタン押下時
		if("clockout".equals(stampingValue)) {
			if(shainIdNumber == "") {
				return "registDuty";
			}
			model.addAttribute("shainIdText",shainIdNumber);
			model.addAttribute("clockOutTime",truncatedToSeconds);
		}
		//当月出退勤ボタン押下時
		//if("clockinAndclockoutCheck".equals(stampingValue)) {
		//	model.addAttribute("clockOutTime",truncatedToSeconds);
		//	return "viewDuty";
		//}
		
		
		return "registDuty";
	}
}
