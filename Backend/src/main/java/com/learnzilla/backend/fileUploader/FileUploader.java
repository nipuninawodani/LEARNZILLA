package com.learnzilla.backend.fileUploader;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUploader {

    public FileUploader (MultipartFile file , String prefix){
        String FTP_ADDRESS = "files.000webhost.com";
        String LOGIN = "learnzillaftp";
        int port = 21;
        String PSW = "learnzillaFTP@";

        FTPClient con = null;

        String saveFileName = prefix + file.getOriginalFilename();

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);
            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                boolean result = con.storeFile("/public_html/learnzilla/"+saveFileName, file.getInputStream());

                con.logout();
                con.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
