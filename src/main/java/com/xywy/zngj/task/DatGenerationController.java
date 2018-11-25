package com.xywy.zngj.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.xywy.zngj.common.utils.Binary;

@Service
@Lazy(false)
public class DatGenerationController {
	/*@Autowired
	private XStatisticalRegService  xstatisticalRegService;//用户注册统计
	@Autowired
	private XStatisticalLoginService xstatisticalLoginService; //用户登录统计
	@Autowired
	@Scheduled(cron = "0 0 1 ? * 1")//每周日凌晨1点执行一次   
	public void syn() throws Exception{
		
		List<String> list=new ArrayList<String>();
		for (int i = 1; i < 8; i++) {
			String time=Binary.getFetureDate(i);
			time=time.replace("-", "");
			list.add(time);
		}
		for (int i = 0; i < list.size(); i++) {
			String ll=list.get(i);
			XStatisticalReg xstatisticalReg = new XStatisticalReg();
			xstatisticalReg.setStatisticalRegTime(Integer.valueOf(ll));
			xstatisticalReg.setStatisticalRegTotal(0);
			XStatisticalLogin xstatisticalLogin = new XStatisticalLogin();
			xstatisticalLogin.setStatisticalLoginTime(Integer.valueOf(ll));
			xstatisticalLogin.setStatisticalLoginTotal(0);
			xstatisticalRegService.save(xstatisticalReg);
			xstatisticalLoginService.save(xstatisticalLogin);
		}
	}
	public static void main(String[] args) throws Exception {
		DatGenerationController n=new DatGenerationController();
		n.syn();
	}*/
}
