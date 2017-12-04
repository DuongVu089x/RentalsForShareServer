package com.rentalsforshare.service;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	String uploadFile(MultipartFile file) throws Exception;
}
