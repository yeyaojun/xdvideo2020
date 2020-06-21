package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.Service.VidaoService;
import net.xdclass.xdvideo.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vidao")
public class VideoController {

	@Autowired
	private VidaoService vidaoService;

	@PostMapping("page")
	public Object pageVidao(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "size",defaultValue = "10")int size){

		return vidaoService.findAll();
	}

	@PostMapping("findById")
	public Object findById(@RequestParam(value = "id",required = true) int vidaoId){

		return vidaoService.findById(vidaoId);
	}

	@PostMapping("delById")
	public Object delById(@RequestParam(value = "id",required = true) int vidaoId){

		return vidaoService.delete(vidaoId);
	}

	@PostMapping("update")
	public Object update(@RequestBody Video video){

		return vidaoService.update(video);
	}

	@PostMapping("save")
	public Object sava(@RequestBody Video video){

		return vidaoService.save(video);
	}

	@RequestMapping("test")
	public String test(){
		return "hello xdclass.net";
	}
	
	
	
}
