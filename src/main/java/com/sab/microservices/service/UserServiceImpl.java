package com.sab.microservices.service;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.sab.microservices.pojo.PostPOJO;
import com.sab.microservices.pojo.Users;

@Service
public class UserServiceImpl implements UserService {
	//for mac users we can define path like this
	//private final String PATH = "/Users/vickyverma/Downloads";
	private final String PATH = "C://Files";
	private final String URL = "https://jsonplaceholder.typicode.com";
	RestTemplate restTemplate = new RestTemplate();
	public Map<String, List<String>> segragaate(List<String> values) {
		
		Map<String, Integer> mp = new HashMap<>();
		List<String> unique = new ArrayList<>();
		List<String> duplicate = new ArrayList<>();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		for (String i : values) {
			if (mp.containsKey(i)) {
				mp.put(i, mp.get(i) + 1);
			} else {
				mp.put(i, 1);
			}
		}
		Set<String> keys = mp.keySet();
		for (String i : keys) {
			if (mp.get(i) > 1) {
				duplicate.add(i);
			} else {
				unique.add(i);
			}
		}
		result.put("Unique", unique);
		result.put("Duplicate", duplicate);
		
		return result;
	}
	//make sure you have the desired path in your system
	public boolean save(MultipartFile file) {
		boolean flag = false;
		try {
			Files.copy(file.getInputStream(), Paths.get(PATH + File.separator +"tempFile.pdf"),
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;
		} catch (Exception e) {
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return flag;
	}


	public PostPOJO[] restTemplateImpl() {
		return restTemplate.getForObject(URL + "/posts", PostPOJO[].class);
		
	}

	public List<Users> getAllUsers() {
		return Arrays.asList(new Users("Vikash", "vicky111", "testuser", "123456789", "address1"),
				new Users("Pankaj", "pankaj111", "testuser2", "222222222", "address2"));
	}


}
