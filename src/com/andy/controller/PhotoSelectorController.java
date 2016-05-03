package com.andy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.andy.model.PhotoSelectorModel;
import com.andy.type.ResponseResult;

@Controller
@RequestMapping("/photoSelector")
public class PhotoSelectorController {
	PhotoSelectorModel photoSelectorModel = new PhotoSelectorModel();
	@RequestMapping(value = "/savePicAndTxt", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public ResponseResult savePicAndTxt(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam Map<String, Object> map,
			@RequestParam List<MultipartFile> files) {
		ResponseResult result = new ResponseResult();
		return result;
	}
	
	@RequestMapping(value = "/savePic", headers=("content-type=multipart/*"),method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public ResponseResult savePic(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="file", required=false) List<MultipartFile> files) throws IOException {
		ResponseResult result = new ResponseResult();
		
		System.out.println("/MyProject/photoSelector/savePic");
		if(files == null){
			System.out.println("没有图片上传");
		}else{
			System.out.println("picNum : "+ files.size());
			photoSelectorModel.savePic(files, request);
		}
		return result;
	}
	
	@RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> xmlOrJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", "hello world");
        System.out.println("/MyProject/photoSelector/test");
        return map;
    }
	
}
