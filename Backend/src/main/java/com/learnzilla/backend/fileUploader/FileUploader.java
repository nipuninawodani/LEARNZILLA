package com.learnzilla.backend.fileUploader;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUploader {

    public FileUploader (MultipartFile file , String folder){
        String FTP_ADDRESS = "files.000webhost.com";
        String LOGIN = "learnzillaftp";
        int port = 21;
        String PSW = "learnzillaFTP@";

        String BasePath ="/public_html/learnzilla/";

        FTPClient con = null;

        String saveFileName = file.getOriginalFilename();

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);
            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                String Directory = BasePath+folder;

                boolean mkdir = con.makeDirectory(Directory);

                System.out.println(mkdir);

                boolean result = con.storeFile(Directory+"/"+saveFileName, file.getInputStream());

                System.out.println(result);
                con.logout();
                con.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
