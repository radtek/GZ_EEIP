package org.pangolin.eeip.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    /**
     * 文件上传
     * @param path 目标路径
     * @param file 文件流
     * @return
     */
	public static String uploadFile(String path ,MultipartFile file){ 
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath = path + File.separatorChar +uploadFolderName;  
        File saveDirectory = new File(saveDirectoryPath); 
        String filePath="";
        if (!saveDirectory.exists()) {
			saveDirectory.mkdirs();
		}  
        if (!file.isEmpty()) {  
            String fileName = file.getOriginalFilename();  
            String fileExtension = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, UUIDHexGenerator.getInstance().generate()+"."+fileExtension);
            filePath = rootFile.getPath();
            try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
        } else{
        	return null;
        }
		return filePath;
	} 
}
