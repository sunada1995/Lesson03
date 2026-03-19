package com.seiken_soft.model;

import java.sql.Date;

import com.seiken_soft.entity.TDuty;

public interface DutyRegistModel {
  //インターフェイスは引数と戻り値の型のみを定義
  //勤怠画面用のモデルインターフェース
	Date insert(TDuty record);
	
	Date insertSelective(TDuty record);
	
	Date updateByPrimaryKeySelective(TDuty record);
	
}
