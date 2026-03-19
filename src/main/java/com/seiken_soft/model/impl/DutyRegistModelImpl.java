package com.seiken_soft.model.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiken_soft.dao.TDutyMapper;
import com.seiken_soft.entity.TDuty;

@Service
public class DutyRegistModelImpl {
  //勤怠画面用のモデル
	@Autowired
	private TDutyMapper tDutyMapper;
	
	/* データの挿入 */
	/* 出勤時間 */
	public void insertClockin(String shainIdNumber,Date dateTime) {
		
		//myBatis3ではバージョンが古いためLocalDateTime型は使えない？から一応Date型に変えた
		TDuty tduty = new TDuty();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String month = sdf1.format(dateTime);
		String dayOfMonth = sdf2.format(dateTime);

		tduty.setEmployeeId(shainIdNumber);
		tduty.setDutyWorkTimeFrom(dateTime);
		tduty.setDutyMonth(month);
		tduty.setDutyDate(dayOfMonth);
				
		tDutyMapper.insertSelective(tduty);
	}
	
	/* データの挿入 */
	/* 退勤時間 */
	public void insertClockout(String shainIdNumber,Date dateTime) {
		
		TDuty tduty = new TDuty();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String month = sdf1.format(dateTime);
		String dayOfMonth = sdf2.format(dateTime);

		tduty.setEmployeeId(shainIdNumber);
		tduty.setDutyWorkTimeTo(dateTime);
		tduty.setDutyMonth(month);
		tduty.setDutyDate(dayOfMonth);
				
		tDutyMapper.updateByPrimaryKeySelective(tduty);
	}
	
}
