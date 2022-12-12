package com.sab.microservices.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sab.microservices.pojo.PostPOJO;
import com.sab.microservices.pojo.Users;

@Component
public interface UserService {
	
	public boolean save(MultipartFile file);
	public List<Users> getAllUsers();
	public PostPOJO[] restTemplateImpl();
	public Map<String,List<String>> segragaate(List<String> values);

}
