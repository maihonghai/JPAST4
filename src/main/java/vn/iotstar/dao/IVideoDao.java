package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoDao {
	void insert(Video video);
    void update(Video video);
    void delete(String videoId);
    Video findById(String videoId);
    List<Video> searchByName(String title);

}
