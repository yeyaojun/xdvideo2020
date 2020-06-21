package net.xdclass.xdvideo.mapper;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* vidao 数据访问层
* */

public interface VidaoMapper {

    @Select("SELECT * FROM video")
       /* @Results({
                @Result(column = "menu_code",property = "menuCode"),
                @Result(column = "menu_id",property = "menuId"),
                @Result(column = "menu_type",property = "menuType"),
                @Result(column = "parent_id",property = "parentId"),
        })*/
    List<Video> findAll();

    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);

//    @Update("UPDATE video SET `title` = #{title} WHERE id = #{id}")
    @UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    int update(Video video);

    @Delete("DELETE FROM video WHERE id = #{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` (`title`, `summary`, `cover_img`, `view_num`, `price`, `create_time`, `online`, `point`) VALUES ( #{title}, #{summary}, #{coverImg}, #{viewNum}, #{price}, NOW(), #{online}, #{point})")
    @Options(useGeneratedKeys=true, keyProperty="vidaoId", keyColumn="id")
    int save(Video video);

}
