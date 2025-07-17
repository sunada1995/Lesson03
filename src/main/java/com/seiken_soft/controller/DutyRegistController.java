package com.seiken_soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/duty")
public class DutyRegistController {
//勤怠画面用のコントローラー
//初期表示時はinit()
	@RequestMapping("")
	public String init(Model model) {
		return "registDuty";
	}
}
