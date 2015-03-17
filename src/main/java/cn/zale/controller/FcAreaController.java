package cn.zale.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zale.Interface.DaoInterface;
import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcAlarm;
import cn.zale.model.FcArea;
import cn.zale.model.FcBuilding;
import cn.zale.service.FcAreaService;
import cn.zale.service.FcBuildingService;

@Controller
@RequestMapping("/user")
public class FcAreaController {

	@Autowired
	@Qualifier("fcAreaService")
	private ServiceInterface<FcArea> fcAreaService;
	@Autowired
	@Qualifier("fcAlarmService")
	private ServiceInterface<FcAlarm> fcAlarmService;
	@Autowired
	@Qualifier("fcBuildingService")
	private ServiceInterface<FcBuilding> fcBuildingService;

	@RequestMapping(value = "/showImage/{id}")
	public String showImage(Map<String, Object> map, @PathVariable String id) {

		// /wtpwebapps/tableupload/WEB-INF/classes/
		System.out.println(this.getClass().getClassLoader().getResource("")
				.getPath());
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();

		path = path + "image/";
		map.put("imagePath", "/image/" + id + ".jpg");
		File f = new File(path + id + ".jpg");
		try {
			if (!(f.exists())) {
				f.createNewFile();
				FcArea area = fcAreaService.getClass(id);
				if (!(area.getAreaPic() == null)) {
					ByteArrayInputStream is = new ByteArrayInputStream(
							area.getAreaPic());
					FileUtils.copyInputStreamToFile(is, f);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/ImagePage";
	}
	
	

	@RequestMapping(value = "/commlist")
	public String getCommunityList(Map<String, Object> map) {
		map.put("community_arrays", fcAreaService.listPartData());
		// for (int i = 0; i < fcAreaService.listPartData().size(); i++) {
		// System.out.println(fcAreaService.listPartData().toString());
		// }
		return "/communitelist";
	}

	@RequestMapping(value = "/addCommunite")
	public String addCommunite() {
		return "/addCommunite";
	}

	@RequestMapping(value = "/addCommuniteFinished", method = RequestMethod.POST)
	public String addCommuniteFinished(
			String areaName,
			String areaChinese,
			@RequestParam(value = "myfiles", required = false) MultipartFile file) {

//		String path = this.getClass().getClassLoader().getResource("")
//				.getPath();
//		path = path + "image/";
		//map.put("imagePath", "/image/" + areaId + ".jpg");
//		File f = new File(path + areaId + ".jpg");
		
		
		System.out.println(areaName + " " + areaChinese);
		FcArea fcArea = new FcArea();
		
		try {
			if (!file.isEmpty()) {
//				if (!(f.exists())) {
//					f.createNewFile();
//					FileUtils.copyInputStreamToFile(file.getInputStream(), f);
//				}
				InputStream inputStream = file.getInputStream();

				byte[] b = new byte[inputStream.available()];
				inputStream.read(b);
				if (inputStream != null) {
					inputStream.close();
				}
				fcArea.setAreaPic(b);
			}
			fcArea.setAreaName(areaName);
			fcArea.setAreaChinese(areaChinese);
			fcAreaService.saveClass(fcArea);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/user/commlist";
	}

	@RequestMapping(value = "/editCommunite/{id}")
	public String editCommunite(Map<String, Object> map, @PathVariable String id) {
		map.put("communite", fcAreaService.listPartDataById(id).get(0));
		return "/editCommunite";
	}

	@RequestMapping(value = "/editCommuniteFinished/{areaId}", method = RequestMethod.POST)
	public String editCommuniteFinished(@PathVariable String areaId,
			String areaName, String areaChinese,@RequestParam(value = "myfiles", required = false) MultipartFile file) {
		System.out.println(areaName + " " + areaChinese);
		
		FcArea fcArea = fcAreaService.getClass(areaId);
		
		if (!file.isEmpty()) {
			System.out.println("file is not empty!");
			String path = this.getClass().getClassLoader().getResource("").getPath();
			path = path + "image/";
			//map.put("imagePath", "/image/" + areaId + ".jpg");
			File f = new File(path + areaId + ".jpg");

			try {
				if ((f.exists())) {
					f.delete();
				}
				f.createNewFile();
				FileUtils.copyInputStreamToFile(file.getInputStream(), f);
				InputStream inputStream = file.getInputStream();
				byte[] b = new byte[inputStream.available()];
				inputStream.read(b);
				if (inputStream != null) {
					inputStream.close();
				}
				fcArea.setAreaPic(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fcArea.setAreaName(areaName);
		fcArea.setAreaChinese(areaChinese);
		fcAreaService.saveClass(fcArea);
		return "redirect:/user/commlist";
	}

	// @RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
	// public @ResponseBody String upload(
	// @RequestParam(value = "myfiles", required = false) MultipartFile file,
	// @PathVariable String id) {
	// //File f = new File(id + file.getOriginalFilename());
	// try {
	// //FileUtils.copyInputStreamToFile(file.getInputStream(), f);
	// System.out.println("id is" + id);
	// userService.saveImage(id,file.getInputStream());
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return "上传成功";
	// }

	// @RequestMapping(value = "/boot")
	// public String getpage(Map<String, Object> map)
	// {
	// map.put("userList", userService.listUsers());
	// for (int i = 0; i < userService.listUsers().size(); i++) {
	// System.out.println(userService.listUsers().toString());
	// }
	// return "bootstraptest";
	// }
}
