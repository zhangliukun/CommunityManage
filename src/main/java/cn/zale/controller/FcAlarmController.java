package cn.zale.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcAlarm;
import cn.zale.model.FcArea;
import cn.zale.model.FcBuilding;


@Controller
@RequestMapping("/user")
public class FcAlarmController {

	@Autowired
	@Qualifier("fcAreaService")
	private ServiceInterface<FcArea> fcAreaService;
	@Autowired
	@Qualifier("fcAlarmService")
	private ServiceInterface<FcAlarm> fcAlarmService;
	@Autowired
	@Qualifier("fcBuildingService")
	private ServiceInterface<FcBuilding> fcBuildingService;
	
	@RequestMapping(value = "/alarmlist/{buildingId}")
	public String getAlarmList(Map<String, Object> map, @PathVariable String buildingId) {
		map.put("alarm_arrays", fcAlarmService.listPartDataById(buildingId));
		map.put("buildingId", buildingId);
		return "/alarmlist";
	}
	
	@RequestMapping(value = "/editAlarm/{alarmId}")
	public String editAlarm(Map<String, Object> map, @PathVariable String alarmId) {
		map.put("alarm", fcAlarmService.getClass(alarmId));
		System.out.println( fcAlarmService.getClass(alarmId));
		return "/editAlarm";
	}
	
	@RequestMapping(value = "/addAlarm/{buildingId}")
	public String addAlarm(Map<String, Object> map, @PathVariable String buildingId) {
		map.put("buildingId", buildingId);
		return "/addAlarm";
	}
	
	@RequestMapping(value = "/addAlarmFinished/{buildingId}", method = RequestMethod.POST)
	public String addAlarmFinished(@PathVariable String buildingId,
			String alarmFont, String alarmX, String alarmY) {
		System.out.println(buildingId + " " + alarmFont + " " + alarmX
				+ " " + alarmY);
		
		FcAlarm alarm = new FcAlarm();
		alarm.setAlarmFont(alarmFont);
		alarm.setAlarmX(Integer.valueOf(alarmX));
		alarm.setAlarmY(Integer.valueOf(alarmY));
		alarm.setBuildingId(Integer.valueOf(buildingId));
		fcAlarmService.saveClass(alarm);
		
		return "redirect:/user/alarmlist/" + buildingId;
	}
	
	@RequestMapping(value = "/editAlarmFinished/{alarmId}/{buildingId}", method = RequestMethod.POST)
	public String editAlarmFinished(@PathVariable String alarmId,@PathVariable String buildingId,
			String alarmFont, String alarmX, String alarmY) {
		System.out.println(alarmId + buildingId + " " + alarmFont + " " + alarmX
				+ " " + alarmY);
		
		FcAlarm alarm = fcAlarmService.getClass(alarmId);
		alarm.setAlarmFont(alarmFont);
		alarm.setAlarmX(Integer.valueOf(alarmX));
		alarm.setAlarmY(Integer.valueOf(alarmY));
		fcAlarmService.saveClass(alarm);
		
		return "redirect:/user/alarmlist/" + buildingId;
	}
}
