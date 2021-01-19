package musign.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;



import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.util.Calendar;



public class Utils {
	private static String toHex(byte hash[]) {
		StringBuffer buf = new StringBuffer(hash.length * 2);
		for(int i = 0; i < hash.length; i++) {
			int intVal = hash[i] & 0xff;
			if(intVal < 0x10) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(intVal));
		}
		return buf.toString();
	}
	public static String getHashString(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return toHex(md.digest());
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return str;
		}
	}
	
	public static synchronized String checkNullString(Object str) 
	{
		String strTmp;
		try 
		{
			if (str != null && str.toString().length() > 0 && !str.equals("") && !str.equals("null"))
			{
				strTmp = str.toString();
			}
			else
			{
				strTmp = "";
			}
		} 
		catch (Exception e) 
		{
			strTmp = "";
		}
		return strTmp;
	}
	
	public static synchronized int checkNullInt(Object num) 
	{
		int numTmp;
		try 
		{
			if (num != null && num.toString().length() > 0 && !num.equals(""))
			{
				numTmp = Integer.parseInt(num.toString().trim());
			}
			else
			{
				numTmp = 0;
			}
		} 
		catch (Exception e) 
		{
			numTmp = 0;
		}
		return numTmp;
	}
	
	public static String getDateNow(String type)
	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String year = (sdf.format(now)).substring(0,4);
		String month = (sdf.format(now)).substring(4,6);
		String day = (sdf.format(now)).substring(6,8);
		
		String ret = "";
		if("year".equals(type))
		{
			ret = year;
		}
		else if("month".equals(type))
		{
			ret = month;
		}
		else if("day".equals(type))
		{
			ret = day;
		}
		return ret;
	} 
	
	public static String getClientIP(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			System.out.println("Proxy-Client-IP : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			System.out.println("WL-Proxy-Client-IP : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			System.out.println("HTTP_CLIENT_IP : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			System.out.println("HTTP_X_FORWARDED_FOR : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
			System.out.println("X-Real-IP : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-RealIP");
			System.out.println("X-RealIP : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("REMOTE_ADDR");
			System.out.println("REMOTE_ADDR : "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			System.out.println("ip : "+ip);
		}
		return ip;
	}
	
	public static String excelDown(String sheetname, String filename, ArrayList<String> db_column, ArrayList<String> print_column, ArrayList<Integer> size_column, List<HashMap<String, Object>> list) throws IOException
	{
		if(db_column.size() != print_column.size())
		{
			return "FAIL : 컬럼 갯수 상이";
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		
		//셀 스타일
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setFillForegroundColor(HSSFColorPredefined.AQUA.getIndex()); //배경색
		headStyle.setAlignment(HorizontalAlignment.CENTER); //가운데정렬
		headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로정렬
		
		//사이즈지정
		for(int i = 0; i < size_column.size(); i++)
		{
			sheet.setColumnWidth(i+1, size_column.get(i)); 
		}
		//셀 스타일

		
		//제목 셋팅
		row = sheet.createRow(1); //한칸띄자 보기좋게
		for(int i = 0; i < print_column.size(); i++)
		{
			cell = row.createCell(i+1); //한칸띄자 보기좋게
			cell.setCellStyle(headStyle);
			cell.setCellValue(print_column.get(i));
		}
		//제목 셋팅
		
		for(int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow(i+2);
			for(int z = 0; z < db_column.size(); z++)
			{
				cell = row.createCell(z+1);
				if(list.get(i).get(db_column.get(z)) != null)
				{
					cell.setCellValue(list.get(i).get(db_column.get(z)).toString());
				}
			}
		}
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\musign design lab\\Documents\\workspace-sts-3.9.6.RELEASE\\ak_culture\\WebContent\\excel\\"+filename);
		workbook.write(fos);
		fos.flush();
		fos.close();
		
		return "SUCCESS";
	}
	
	public static String excelDownforTable(String sheetname, String filename,int countMatches, ArrayList<String> print_column, ArrayList<Integer> size_column, ArrayList<Integer> list) throws IOException
	{
		if(countMatches != print_column.size())
		{
			return "FAIL : 컬럼 갯수 상이";
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		
		ArrayList<String> get_cell = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			Integer a = list.get(i);
		}
		
		//셀 스타일
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setFillForegroundColor(HSSFColorPredefined.AQUA.getIndex()); //배경색
		headStyle.setAlignment(HorizontalAlignment.CENTER); //가운데정렬
		headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로정렬
		
		//사이즈지정
		for(int i = 0; i < size_column.size(); i++)
		{
			sheet.setColumnWidth(i+1, size_column.get(i)); 
		}
		//셀 스타일

		
		//제목 셋팅
		row = sheet.createRow(1); //한칸띄자 보기좋게
		for(int i = 0; i < print_column.size(); i++)
		{
			cell = row.createCell(i+1); //한칸띄자 보기좋게
			cell.setCellStyle(headStyle);
			cell.setCellValue(print_column.get(i));
		}
		//제목 셋팅
		/*
		for(int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow(i+2);
			
			for(int z = 0; z < db_column.size(); z++)
			{
				cell = row.createCell(z+1);
				if(list.get(i).get(db_column.get(z)) != null)
				{
					cell.setCellValue(list.get(i).get(db_column.get(z)).toString());
				}
			}
		}
		*/
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MUSIGN-301\\Documents\\workspace\\ak_culture\\WebContent\\excel\\"+filename);
		workbook.write(fos);
		fos.flush();
		fos.close();
		
		return "SUCCESS";
	}
	
	public static String repWord(String buffer) {
		buffer = buffer.replaceAll("&", "&amt;");
		buffer = buffer.replaceAll("<", "&lt;");
		buffer = buffer.replaceAll(">", "&gt;");
		buffer = buffer.replaceAll("\"", "&quot;");
		buffer = buffer.replaceAll("\'", "&#039;");
		buffer = buffer.replaceAll("\n", "<br>");
		return buffer;
	}
	
	public static String getNowTime() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");
		Date time = new Date();
		String now_time = format1.format(time);
		return now_time;
	}

	public static String f_setfill_zero(String temp_str, int str_length, String str_flag) {
		int temp_len = 0;
		temp_len = trim(temp_str).length();
		if (trim(temp_str) == null)
			return zero(str_length);
		if (temp_len >= str_length)
			return temp_str.substring(0, str_length);
		if (str_flag == "R")
			return trim(temp_str) + zero(str_length - temp_len);
		else if (str_flag == "L")
			return zero(str_length - temp_len) + trim(temp_str);
		else {
			return temp_str;
		}
	}

	public static String trim(String str) {
		return str.trim();
	}

	public String space(int len) {
		String spaceString = "";
		for (int i = 0; i < len; i++) {
			spaceString = spaceString + " ";
		}
		return spaceString;
	}

	public static String zero(int len) {
		String zeroString = "";
		for (int i = 0; i < len; i++) {
			zeroString = zeroString + "0";
		}
		return zeroString;
	}
	public static String convertFileName(String filename, String uploadPath, int seq) {
		if(!"".equals(filename))
		{
			String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
			int i = -1;
			i = filename.lastIndexOf("."); // 파일 확장자 위치
			String realFileName = now + seq + filename.substring(i, filename.length()); // 현재시간과 확장자 합치기
			
			File oldFile = new File(uploadPath + filename);
			File newFile = new File(uploadPath + realFileName);
			oldFile.renameTo(newFile); // 파일명 변경
			
			return realFileName.toString();
		}
		else
		{
			return "";
		}
	}

	public static long calDateBetweenAandB(String date1, String date2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
		Date FirstDate = format.parse(date1);
		Date SecondDate = format.parse(date2);

		// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
		// 연산결과 -950400000. long type 으로 return 된다.
		long calDate = FirstDate.getTime() - SecondDate.getTime();
		// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
		// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
		long calDateDays = calDate / (24 * 60 * 60 * 1000);
		calDateDays = Math.abs(calDateDays);
		
		return calDateDays;
	}
	
	public static String addDate(String dd, int days) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date date = df.parse(dd);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return df.format(cal.getTime());
	}
	
	public static String getMonFlag(String dateString) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		try{
		  date = sdf.parse(dateString);
		}catch(ParseException e){
		}

		Calendar cal = Calendar.getInstance(Locale.KOREA);
		cal.setTime(date);

		cal.add(Calendar.DATE, 2- cal.get(Calendar.DAY_OF_WEEK));
		
		return sdf.format(cal.getTime());
	}
	public static String getSunFlag(String dateString) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		try{
		  date = sdf.parse(dateString);
		}catch(ParseException e){
		}

		Calendar cal = Calendar.getInstance(Locale.KOREA);
		cal.setTime(date);

		cal.add(Calendar.DATE, 2- cal.get(Calendar.DAY_OF_WEEK));
		
		cal.setTime(date);

		cal.add(Calendar.DATE, 8 - cal.get(Calendar.DAY_OF_WEEK));

		return sdf.format(cal.getTime());
	}
	public static String getWeekDays(String inputStartDate, String inputEndDate) throws ParseException {
		final String DATE_PATTERN = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		Date startDate = sdf.parse(inputStartDate);
		Date endDate = sdf.parse(inputEndDate);
		ArrayList<String> dates = new ArrayList<String>();
		Date currentDate = startDate;
		while (currentDate.compareTo(endDate) <= 0) {
			dates.add(sdf.format(currentDate));
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDate = c.getTime();
		}
		String ret = "";
		for (String date : dates) {
			ret += date+"|";
		}
		return ret;
	}
	
	
	public static String encrypt(String planText) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(planText.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	

	

	

}
