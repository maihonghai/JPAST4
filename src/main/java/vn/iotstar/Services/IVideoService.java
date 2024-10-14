package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoService {
	void insert(Video video);
    void update(Video video);
    void delete(String videoId);
    Video findById(String videoId);
    List<Video> searchByName(String title);

}
