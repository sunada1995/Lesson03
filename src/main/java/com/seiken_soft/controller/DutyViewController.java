package com.seiken_soft.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ichiran")
public class DutyViewController {
//勤怠管理一覧画面用のコントローラー
//初期表示時はinit()
	
	@PostMapping("/currentMonthAttendance")
	public String init(Model model) {
		//当月出退勤ボタン押下時
				
		// 現在の月の初日を取得
		LocalDate start = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		// 現在の月の末日を取得
		LocalDate end = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

	    // 初日から末日までの日付リストを作成
		List<String> formattedDateList = start.datesUntil(end.plusDays(1))
        .map(date -> date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
		.collect(Collectors.toList());

		MEmployee memployee = new MEmployee();
		
        for(String DateList: formattedDateList){
        	if(DateList == ) {
        		
        	}
        }
		
		model.addAttribute("dates", formattedDateList);
		return "viewDuty";
				
	}
	
	
	@PostMapping("/back")
	public String back(Model model) {

		return "registDuty";
	}
	
}
