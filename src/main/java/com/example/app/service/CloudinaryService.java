package com.example.app.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    private static final Logger logger = LoggerFactory.getLogger(CloudinaryService.class);

    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) {
        try {
            logger.info("Đang cố gắng tải lên tệp: {}", file.getOriginalFilename());
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = uploadResult.get("url").toString();
            logger.info("Tệp đã được tải lên thành công. URL: {}", url);
            return url;
        } catch (IOException e) {
            logger.error("Không thể tải lên tệp: {}", file.getOriginalFilename(), e);
            throw new RuntimeException("Không thể tải lên tệp", e);
        }
    }

    public void deleteFile(String publicId) {
        try {
            logger.info("Đang cố gắng xóa tệp với public ID: {}", publicId);
            Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            logger.info("Tệp đã được xóa thành công. Kết quả: {}", result);
        } catch (IOException e) {
            logger.error("Không thể xóa tệp với public ID: {}", publicId, e);
            throw new RuntimeException("Không thể xóa tệp", e);
        }
    }

    public String updateFile(String publicId, MultipartFile newFile) {
        try {
            logger.info("Đang cố gắng cập nhật tệp với public ID: {}", publicId);
            // Xóa tệp cũ
            deleteFile(publicId);
            // Tải lên tệp mới
            return uploadFile(newFile);
        } catch (Exception e) {
            logger.error("Không thể cập nhật tệp với public ID: {}", publicId, e);
            throw new RuntimeException("Không thể cập nhật tệp", e);
        }
    }

    public String getPublicIdFromUrl(String imageUrl) {
        // Giả sử URL có dạng: https://res.cloudinary.com/your_cloud_name/image/upload/v1234567890/public_id.jpg
        String[] urlParts = imageUrl.split("/");
        String fileName = urlParts[urlParts.length - 1];
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }
}