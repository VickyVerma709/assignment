package com.sab.microservices.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sab.microservices.pojo.PostPOJO;
import com.sab.microservices.pojo.Users;
import com.sab.microservices.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	//API 1
	@PostMapping("/segragateRecords")
	public ResponseEntity<Map<String, List<String>>> segregateRecordsController(@RequestBody List<String> values) {
		if(values.size()==20) {
			return ResponseEntity.ok(userService.segragaate(values));
		}
		else {
			Map<String, List<String>> temp = new HashMap<String, List<String>>();
			List<String> temp1  =  new ArrayList<>();
			temp1.add("Please provide the set of 20 emails");
			temp.put("Exception", temp1);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(temp);
		}
	}
	
	//API 2
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please upload file");
			}
			if (userService.save(file)) {
				return ResponseEntity.ok("file inserted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occoured while uploading the file");

	}

	//API 3
	@GetMapping("/posts")
	public ResponseEntity<PostPOJO[]> restTemplateUse() {
		return ResponseEntity.ok(userService.restTemplateImpl());
	}
	
	//API 4
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
}
