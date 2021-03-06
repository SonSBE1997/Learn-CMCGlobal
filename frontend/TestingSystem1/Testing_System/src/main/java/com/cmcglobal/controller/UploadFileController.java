package com.cmcglobal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcglobal.service.UploadFileService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class UploadFileController {

	@Autowired
	private UploadFileService uploadFileService;

	List<String> files = new ArrayList<>();

	@PostMapping(value="/uploadfile")
	public ResponseEntity<String> handleFileUpload(@RequestParam("files") MultipartFile file) {
		String message = "";
		try {
			uploadFileService.saveFile(file);
			files.add(file.getOriginalFilename());
			message = "successfully uploaded" + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "ERROR! can't upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}
