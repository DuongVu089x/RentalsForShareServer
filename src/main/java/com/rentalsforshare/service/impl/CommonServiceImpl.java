package com.rentalsforshare.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rentalsforshare.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Override
	public String uploadFile(MultipartFile file) throws Exception {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		String fileName = System.currentTimeMillis() + convFile.getName();
		FileUtils.moveFile(convFile, new File("static/images/motels", fileName));
		return fileName;
	}

}
