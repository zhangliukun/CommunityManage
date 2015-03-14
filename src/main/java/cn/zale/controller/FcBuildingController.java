package cn.zale.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcAlarm;
import cn.zale.model.FcArea;
import cn.zale.model.FcBuilding;

@Controller
@RequestMapping("/user")
public class FcBuildingController {

	@Autowired
	@Qualifier("fcAreaService")
	private ServiceInterface<FcArea> fcAreaService;
	@Autowired
	@Qualifier("fcAlarmService")
	private ServiceInterface<FcAlarm> fcAlarmService;
	@Autowired
	@Qualifier("fcBuildingService")
	private ServiceInterface<FcBuilding> fcBuildingService;

	
	
	@RequestMapping(value = "/showBuildingImage/{buildingId}")
	public String showImage(Map<String, Object> map,
			@PathVariable String buildingId) {

		// /wtpwebapps/tableupload/WEB-INF/classes/
		System.out.println(this.getClass().getClassLoader().getResource("")
				.getPath());
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		//这里可以性能优化下，在没有图片时再getclass，这样如果有图片的话就不会再去将数据库中的图片文件取出来提高速度
		FcBuilding building = fcBuildingService.getClass(buildingId);

		path = path + "image/";
		map.put("imagePath", "/image/" + building.getAreaId() + "." + buildingId
				+ ".jpg");

		System.out.println(path + building.getAreaId() + "." + buildingId + ".jpg");
		
		File f = new File(path + building.getAreaId() + "." + buildingId + ".jpg");
		try {
			if (!(f.exists())) {
				f.createNewFile();
				if (!(building.getBuildingPic()==null)) {
					ByteArrayInputStream is = new ByteArrayInputStream(
							building.getBuildingPic());
					FileUtils.copyInputStreamToFile(is, f);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/ImagePage";
	}

	@RequestMapping(value = "/editBuilding/{buildingId}")
	public String editBuilding(Map<String, Object> map,
			@PathVariable String buildingId) {
		map.put("building", fcBuildingService.getClass(buildingId));
		return "/editBuilding";
	}

	@RequestMapping(value = "/buildinglist/{id}")
	public String getBuildingList(Map<String, Object> map,
			@PathVariable String id) {
		// FcBuildingService.listPartData();
		List<FcBuilding> buildings = fcBuildingService.listPartDataById(id);
		System.out.println(buildings.size());
		if (buildings.size() > 0) {
			map.put("buliding_arrays", buildings);
			map.put("areaId", buildings.get(0).getAreaId());
		}
		// for (int i = 0; i < FcBuildingService.listPartData().size(); i++) {
		// System.out.println(FcBuildingService.listPartData().get(0));
		// }
		return "/buildinglist";
	}

	@RequestMapping(value = "/addBuilding/{id}")
	public String addBuilding(Map<String, Object> map, @PathVariable String id) {
		map.put("areaId", id);
		return "/addBuilding";
	}

	@RequestMapping(value = "/addBuildingFinished/{areaId}", method = RequestMethod.POST)
	public String addBuildingFinished(
			@PathVariable String areaId,
			String buildingNumber,
			String buildingX,
			String buildingY,
			@RequestParam(value = "myfiles", required = false) MultipartFile file) {
		System.out.println(areaId + " " + buildingNumber + " " + buildingX
				+ " " + buildingY);

		InputStream inputStream;
		byte[] b;
		try {
			inputStream = file.getInputStream();
			b = new byte[inputStream.available()];
			inputStream.read(b);
			if (inputStream != null) {
				inputStream.close();
			}
			FcBuilding building = new FcBuilding();
			building.setAreaId(Integer.valueOf(areaId));
			building.setBuildingNumber(Integer.valueOf(buildingNumber));
			building.setBuildingX(Integer.valueOf(buildingX));
			building.setBuildingY(Integer.valueOf(buildingY));
			building.setBuildingPic(b);
			fcBuildingService.saveClass(building);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/user/buildinglist/" + areaId;
	}

	@RequestMapping(value = "/editBuildingFinished/{buildingId}", method = RequestMethod.POST)
	public String editBuildingFinished(
			@PathVariable String buildingId,
			String buildingNumber,
			String buildingX,
			String buildingY,
			@RequestParam(value = "myfiles", required = false) MultipartFile file) {
		System.out.println(buildingNumber + " " + buildingX + " " + buildingY);

		FcBuilding building = fcBuildingService.getClass(buildingId);
		String areaId = String.valueOf(building.getAreaId());

		if (!file.isEmpty()) {
			System.out.println("file is not empty!");
			String path = this.getClass().getClassLoader().getResource("")
					.getPath();
			path = path + "image/";
			// map.put("imagePath", "/image/" + areaId + ".jpg");
			File f = new File(path + areaId + "." + buildingId + ".jpg");

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
				building.setBuildingPic(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		building.setBuildingNumber(Integer.valueOf(buildingNumber));
		building.setBuildingX(Integer.valueOf(buildingX));
		building.setBuildingY(Integer.valueOf(buildingY));
		fcBuildingService.saveClass(building);

		return "redirect:/user/buildinglist/" + areaId;
	}

}
