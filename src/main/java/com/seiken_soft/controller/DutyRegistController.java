package com.seiken_soft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    //自動DI(依存性注入)
    //@AutowiredをつけることによってSpringがオブジェクトを作る
    //Controllerに自動で渡す
    @Autowired
    private DutyRegistModelImpl dutyRegistModelImpl;
    
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
		
		//現在時刻の取得
		Date date = new Date();
		//フォーマットを指定
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		//現在時刻をString型で指定したフォーマットに変換。→"HH:mm:ss"
		String currrentTime = sdf.format(date);
				
		
		//出勤ボタン押下時		
		if("clockin".equals(stampingValue)) {
			if(shainIdNumber == "") {
				return "registDuty";
			}
			this.session.setAttribute("shainIdText",shainIdNumber);
			this.session.setAttribute("clockinTime",currrentTime);
			
			dutyRegistModelImpl.insertClockin(shainIdNumber,date);
		    
		}
		
		//退勤ボタン押下時
		if("clockout".equals(stampingValue)) {
			if(shainIdNumber == "") {
				return "registDuty";
			}			
			this.session.setAttribute("shainIdText",shainIdNumber);
			this.session.setAttribute("clockOutTime",currrentTime);
			
			dutyRegistModelImpl.insertClockout(shainIdNumber,date);
		}
		
		
		return "registDuty";
	}
}
