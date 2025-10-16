package com.seiken_soft.model.impl;

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
	public void signUp(TDuty tDuty) {
		
		tDutyMapper.insert(tDuty);
	}
	
}
