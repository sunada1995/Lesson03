package com.seiken_soft.controller;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seiken_soft.model.impl.DutyRegistModelImpl;

@Controller
@RequestMapping("/duty")
public class DutyRegistController {
	
	// HttpSession型のフィールドを定義する
    private HttpSession session;
    
    // コンストラクタを作成
    public DutyRegistController(HttpSession session) {
        // フィールドに代入する
        this.session = session;
    }
	
    //勤怠画面用のコントローラー
    //初期表示時はinit()
	@GetMapping("/")
	public String init(Model model) {
		session.removeAttribute("clockinTime");
        session.removeAttribute("clockOutTime");
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
			this.session.setAttribute("shainIdText",shainIdNumber);
			this.session.setAttribute("clockinTime",truncatedToSeconds);
			
			DutyRegistModelImpl dutyRegistModelImpl = new DutyRegistModelImpl();
			dutyRegistModelImpl.signUp(null);
		    
		}
		
		//退勤ボタン押下時
		if("clockout".equals(stampingValue)) {
			if(shainIdNumber == "") {
				return "registDuty";
			}			
			this.session.setAttribute("shainIdText",shainIdNumber);
			this.session.setAttribute("clockOutTime",truncatedToSeconds);
		}
		
		
		return "registDuty";
	}
}
