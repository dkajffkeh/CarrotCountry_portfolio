package com.javachip.carrotcountry.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	// 기존의 파일(원본 파일)을 전달받아서 수정명 작업을 다 마친 수정된 파일을 반환해주는 메소드
	@Override
	public File rename(File originFile) {
		
		// 원본 파일명
		String originName = originFile.getName();		
		
		// 수정 파일명 : 파일업로드한시간 (년월일시분초) + 5자리랜덤값(10000~99999) + 원본파일명으로부터뽑은확장자
		
		// 1. 파일 업로드한 시간 (String currentTime)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = sdf.format(new Date());	
		
		// 2. 5자리랜덤값 (int random)
		int ranNum = (int)(Math.random() * 90000 + 10000);
		
		// 3. 원본파일명으로부터뽑은 확장자 (String ext)
		int dot = originName.lastIndexOf(".");
		String ext = originName.substring(dot);		
		
		String fileName = currentTime + ranNum + ext;	
		
		// 전달받은 원본파일(originFile)을 수정된파일명(fileName)으로 파일객체 생성해서 리턴
		
		return new File(originFile.getParent(), fileName);
		
		
	}

	
	
	
}
