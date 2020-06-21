package net.xdclass.xdvideo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.xdclass.xdvideo.Service.VidaoService;
import net.xdclass.xdvideo.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/api/v1/vidao")
public class VideoAdminController {

	@Autowired
	private VidaoService vidaoService;

	@PostMapping("page")
	public Object pageVidao(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "size",defaultValue = "10")int size){
		PageHelper.startPage(page,size);

		List<Video> list = vidaoService.findAll();
		PageInfo<Video> pageInfo = new PageInfo<>(list);
		Map<String,Object> data = new HashMap<>();
		data.put("total_size",pageInfo.getTotal());//总条数
		data.put("total_page",pageInfo.getPages());//总页数
		data.put("current_page",page);//当前页
		data.put("data",pageInfo.getList());//数据

		return data;
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
