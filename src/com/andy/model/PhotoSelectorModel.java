package com.andy.model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;


public class PhotoSelectorModel {
	
	public Boolean savePic(List<MultipartFile> files, HttpServletRequest request) throws IOException{
		System.out.println("savaPic");
	
		for(MultipartFile i : files){

			Date dd = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
			String uploadFolder = request.getSession().getServletContext()
					.getRealPath("/");
			uploadFolder = uploadFolder + "temp" + File.separator;
			
			System.out.println(i.getOriginalFilename());
			//获取用户上传文件后缀
			String prefix = i.getOriginalFilename().substring(
					i.getOriginalFilename().lastIndexOf("."));
			String name = sdf.format(dd)+prefix;
			File f = new File(uploadFolder, name);
			FileUtils.copyInputStreamToFile(i.getInputStream(), f);
	
			// 获取本地路径
			String tempFilePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "temp"
					+ File.separator;
			// 获取服务器路径
			String savePath = "E:/upload"
					+ "/engineer/finish" + "/";
			System.out.println(tempFilePath);
			System.out.println(savePath);
			File sourceFile = new File(tempFilePath);
			File destFile = new File(savePath);
			// 服务器路径不存在时,创建路径
			if (!destFile.exists() && !destFile.isDirectory()) {
				destFile.mkdirs();
			}
			// 取得所有的文件名
			File tempFile = new File(tempFilePath, name);
			// 文件copy
			tempFile.renameTo(new File(destFile, name));
			// 文件删除
			tempFile.delete();

			// 文件路径下删除
			FileUtils.deleteDirectory(sourceFile);
		}
		return true;
	}
}
