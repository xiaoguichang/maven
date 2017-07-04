package com.xiaogch.maven.mybatis.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaogch.maven.mybatis.dao.UserDao;
import com.xiaogch.maven.mybatis.entity.UserBean;
import com.xiaogch.maven.mybatis.junit.SpringJunitTestBase;


public class UserDaoImplTest extends SpringJunitTestBase {

	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	
//	@Test
	public void testQueryUserList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		File file = new File("d:\\maven\\logs\\maven-mybatis\\2017log.txt");
		FileOutputStream fos = null;
		PrintWriter pw = null; 
		
		long beginTime = 20170101000000l;
		long finalEndTime = 20170323000000l;
		
		Date beginDate = null;
		try {
			beginDate = sdf.parse(Long.toString(beginTime));
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos); 
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate);
		while (beginTime < finalEndTime) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			long endTime = Long.parseLong(sdf.format(calendar.getTime()));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("beginTime", beginTime);
			parameters.put("endTime", endTime);
			List<UserBean> userBeans = userDao.queryUserList(parameters);
			logger.info("beginTime=" + beginTime + " endTime=" + endTime + " userBeans " + (userBeans == null ? "is null" :("size is " + userBeans.size())));
			for (UserBean userBean : userBeans) {
				pw.println(userBean.toString());
			}
			pw.flush();
			beginTime = endTime;
		}
		
		if (pw != null) {
			pw.close();
		}
		
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Test
	public void singleRecord() {
		File infile = new File("d:\\maven\\logs\\maven-mybatis\\2017log.txt");
		File outfile = new File("d:\\maven\\logs\\maven-mybatis\\2017log_1.txt");
		Map<String , Byte> result = new HashMap<String , Byte>();
		try {
			RandomAccessFile rafin = new RandomAccessFile(infile, "r");
			FileChannel inchannel = rafin.getChannel();
			ByteBuffer dsts = ByteBuffer.allocate(1024);
			readFileByLine(1024, inchannel, dsts, result);
			inchannel.close();
			rafin.close();
			
			RandomAccessFile rafout = new RandomAccessFile(outfile, "w");
			FileChannel outchannel = rafout.getChannel();
			Set<String> keys = result.keySet();
			StringBuffer buffer = new StringBuffer();
			int index = 0;
			for (String key : keys) {
				index ++;
				buffer.append(key).append("\n");
				if (index % 10000 == 0) {
					writeFileByLine(outchannel, buffer.toString());
					System.out.println(index);
					buffer = new StringBuffer();
				}
			}
			writeFileByLine(outchannel, buffer.toString());
			outchannel.close();
			rafout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void readFileByLine(int bufSize, FileChannel fcin, ByteBuffer rBuffer, Map<String , Byte> result){  
        String enterStr = "\n";  
        try{  
            byte[] bs = new byte[bufSize];  
            StringBuffer strBuf = new StringBuffer("");  
            while(fcin.read(rBuffer) != -1){  
                int rSize = rBuffer.position();  
                rBuffer.rewind();//将position置为0，为读做准备  
                rBuffer.get(bs);//从上述position=0的位置开始读  
                rBuffer.clear();  
                String tempString = new String(bs, 0, rSize);  
                int fromIndex = 0;  
                int endIndex = 0;  
                //查找换行符符号\n，如果找到了，则写文件，如果没有找到则继续读取  
                while((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1){  
                    String line = tempString.substring(fromIndex, endIndex);  
                    line = strBuf.toString() + line;  
                    result.put(line.trim(), (byte)1);
                    strBuf.delete(0, strBuf.length());  
                    fromIndex = endIndex + 1;  
                }  
  
                if(rSize > tempString.length()){  
                    strBuf.append(tempString.substring(fromIndex, tempString.length()));  
                }else{  
                    strBuf.append(tempString.substring(fromIndex, rSize));  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void writeFileByLine(FileChannel fcout, String line){  
        try {  
            fcout.write(ByteBuffer.wrap(line.getBytes()), fcout.size());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }

}
