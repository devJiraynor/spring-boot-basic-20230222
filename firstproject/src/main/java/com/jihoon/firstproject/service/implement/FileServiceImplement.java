package com.jihoon.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jihoon.firstproject.service.FileService;

@Service
public class FileServiceImplement implements FileService {

    @Value("${file.path}") 
    private String FILE_PATH;
    @Value("${file.url}") 
    private String FILE_URL;

    @Override
    public String upload(MultipartFile file) {
        
        if (file.isEmpty()) return null;

        //* 파일명 가져오기 */
        String originalFileName = file.getOriginalFilename();
        //* 확장자 가져오기 */
        int extensionIndex = originalFileName.lastIndexOf(".");
        String extension = originalFileName.substring(extensionIndex);

        //* 파일의 새로운 이름 지정 */

    }
    
}
