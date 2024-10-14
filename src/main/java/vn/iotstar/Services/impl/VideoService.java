package vn.iotstar.Services.impl;

import java.util.List;

import vn.iotstar.Services.IVideoService;
import vn.iotstar.dao.IVideoDao;
import vn.iotstar.dao.impl.VideoDao;
import vn.iotstar.entity.Video;

public class VideoService implements IVideoService {
	 private IVideoDao videoDao;

	    public VideoService() {
	        this.videoDao = new VideoDao();  // Khởi tạo Dao, bạn có thể sử dụng Dependency Injection (DI) nếu cần
	    }

	@Override
	public void insert(Video video) {
		 videoDao.insert(video);
		
	}

	@Override
	public void update(Video video) {
		videoDao.update(video);
		
	}

	@Override
	public void delete(String videoId) {
		videoDao.delete(videoId);
		
	}

	@Override
	public Video findById(String videoId) {
		 return videoDao.findById(videoId);
	}

	@Override
	public List<Video> searchByName(String title) {
		 return videoDao.searchByName(title);
	}

}
