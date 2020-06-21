package net.xdclass.xdvideo.Service.impl;

import net.xdclass.xdvideo.Service.VidaoService;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VidaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VidaoServiceImpl implements VidaoService {

    @Autowired
    private VidaoMapper vidaoMapper;

    @Override
    public List<Video> findAll() {
        return vidaoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return vidaoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
       return vidaoMapper.update(video);
    }

    @Override
    public int delete(int id) {
       return vidaoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
        int rows = vidaoMapper.save(video);
        System.out.print("菜单ID:"+video.getId());
        return rows;
    }
}
