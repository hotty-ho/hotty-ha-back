package kr.co.seoulit.insa.commsvc.systemmgmt.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.systemmgmt.service.SystemMgmtService;

@RestController
public class EmpImgController {
	
	@Autowired
	private SystemMgmtService systemMgmtService;
	
	@PostMapping("/systemmgmt/empImg")
	public ModelMap handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData) {
		
		String imgName = reqData.getDataSetList().get("ds_img").getString(0,"EMP_FILE_NAME");
		byte [] imgFileData = reqData.getDataSetList().get("ds_img").getBlob(0,"IMG_FILE_DATA");
		System.out.println(imgFileData.toString());
		
		try {
			String path = "C:\\nginx-1.20.2\\nginx-1.20.2\\html\\insa\\profile\\" + imgName;
			
			System.out.println(path);
			ImageIcon imageIcon = new ImageIcon(imgFileData);
			Image image = imageIcon.getImage();
			Image resizeImage = image.getScaledInstance( 225, 225, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage( 225, 225, BufferedImage.TYPE_INT_RGB );
			Graphics g = newImage.getGraphics();
			g.drawImage(resizeImage, 0, 0, null);
			g.dispose();
			ImageIO.write(newImage, "jpg", new File(path)); //저장하고자 하는 파일 경로를 입력합니다.
			
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
		return null;
	}

}