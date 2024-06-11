package com.becoder.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.becoder.model.Images;
import com.becoder.repository.uploadRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private uploadRepository uploadRepo;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile img) {
		
		Images im=new Images();
		im.setImageName(img.getOriginalFilename());
		
		Images uploadImg=uploadRepo.save(im);
		
		if(uploadImg!=null)
		{
			try {
				
				File saveFile=new ClassPathResource("static/img").getFile();
				
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
				
				Files.copy(img.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	
	{    
		return "redirect:/";
	}
		

}
}
