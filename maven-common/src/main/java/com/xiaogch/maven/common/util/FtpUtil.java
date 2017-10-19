package com.xiaogch.maven.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TimeZone;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/10/10 10:06 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class FtpUtil {

    public static boolean uploadFile(String host , int port , String userName , String password , String path , String fileName , InputStream is) {
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);

        FTPClient ftpClient = loginToFtp(host , port , userName , password);

        if (ftpClient == null) {
            return false;
        }

        // 创建目录失败
        if (!createDirectory(ftpClient , path)){
            return false;
        }

        try {
            boolean isExisted = ftpClient.changeWorkingDirectory(path);
            if (!isExisted) {
                logger.info("directory {} not existed" , path);
                return false;
            }
            boolean result = ftpClient.storeFile(fileName , is);
            logger.info("upload file {} to {} on ftp server {}" , fileName , path , result ? "success" : "failure");
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error(e.getMessage() , e);
            }
        }
        return false;
    }

    public static boolean createDirectory(FTPClient ftpClient , String path) {
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);
        try {
            boolean isExisted = ftpClient.changeWorkingDirectory(path);
            if (isExisted) {
                logger.info("{} has exists" , path);
                return true;
            }
            String[] subDirectories = path.split("/");
            String realPath = "";
            for (String directory : subDirectories) {
                if (StringUtils.hasText(directory)) {
                    realPath = realPath + "/" + directory;
                    isExisted = ftpClient.changeWorkingDirectory(realPath);
                    logger.info("directory {} existed ? {}" , realPath , isExisted);
                    if (!isExisted) {
                        boolean result = ftpClient.makeDirectory(realPath);
                        logger.info("create directory {} on ftp server {}" ,  realPath , result ? "success" : "failure");
                        if (!result) {
                            return result;
                        }
                    }
                }
            }
            logger.info("{} not exists and create it success" , realPath);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        }
        logger.info("{} not exists and create it failure" , path);
        return false;
    }

    public static FTPClient loginToFtp(String host , int port , String userName , String password){
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);
        try {
            FTPClientConfig ftpClientConfig = new FTPClientConfig();
            ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
            FTPClient ftpClient = new FTPClient();
            ftpClient.configure(ftpClientConfig);
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(host , port);
            if (ftpClient.login(userName , password)) {
                ftpClient.setDataTimeout(5*60*1000);
                ftpClient.setSoTimeout(5*60*1000);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setSendDataSocketBufferSize(1024);
                ftpClient.setSendBufferSize(1024);
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                logger.info("login to ftp server  host={} port={} userName={} password={} success" , host , port , userName , password);
                return ftpClient;
            }
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        }
        logger.info("login to ftp server host={} port={} userName={} password={} failure" , host , port , userName , password);
        return null;
    }

    public static boolean deleteFile(String host , int port , String userName , String password , String filePath , boolean isDirectory){
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);

        FTPClient ftpClient = loginToFtp(host , port , userName , password);
        if (ftpClient == null) {
            return false;
        }

        try {
            boolean result;
            if (isDirectory) {
                result = ftpClient.removeDirectory(filePath);
                logger.info("remove directory {} on ftp server {}" , filePath , result ? "success" : "failure");
            } else {
                result = ftpClient.deleteFile(filePath);
                logger.info("delete file {} on ftp server {}" , filePath , result ? "success" : "failure");
            }

            return result;
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error(e.getMessage() , e);
            }
        }
        return true;
    }

    public static boolean uploadFileList(String host , int port , String userName , String password , String path ,
                                         Map<String, InputStream> file) {
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);

        FTPClient ftpClient = loginToFtp(host , port , userName , password);

        if (ftpClient == null) {
            return false;
        }

        // 创建目录失败
        if (!createDirectory(ftpClient , path)){
            return false;
        }

        try {
            boolean isExisted = ftpClient.changeWorkingDirectory(path);
            if (!isExisted) {
                logger.info("directory {} not existed" , path);
                return false;
            }

            for (Map.Entry<String, InputStream> entry : file.entrySet()) {

                if(!ftpClient.storeFile(entry.getKey() , entry.getValue())){
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error(e.getMessage() , e);
            }
        }
        return false;
    }

    public static boolean deleteFileList(String host , int port , String userName , String password , Map<String, Boolean> file){
        Logger logger = LoggerFactory.getLogger(FtpUtil.class);

        FTPClient ftpClient = loginToFtp(host , port , userName , password);
        if (ftpClient == null) {
            return false;
        }

        try {
            boolean result = false;
            boolean isDirectory;
            String filePath;
            for (Map.Entry<String, Boolean> entry : file.entrySet()) {
                isDirectory = entry.getValue();
                filePath = entry.getKey();

                if (isDirectory){
                    result = ftpClient.removeDirectory(filePath);
                    logger.info("remove directory {} on ftp server {}" , filePath , result ? "success" : "failure");
                } else {
                    result = ftpClient.deleteFile(filePath);
                    logger.info("delete file {} on ftp server {}" , filePath , result ? "success" : "failure");
                }

                if (!result){
                    return false;
                }

            }

        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error(e.getMessage() , e);
            }
        }
        return true;
    }
}
