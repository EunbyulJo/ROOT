package org.it.board.model;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.it.member.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BoardWriteService {
	
	@Autowired
	HttpSession session;
	@Autowired
	FilesDto fdto;
	@Autowired
	BoardDao bdao;
	@Autowired
	ServletContext application;
	@Autowired
	FilesDao fdao;
	
	// 컨트롤러로부터 필요한 정보들을 전달받아서 처리
	// 파일은 받을 때 MultipartFile로 받아야함 ( input type="file")
	public int writeService(BoardDto bdto, MultipartFile mpf) throws IllegalStateException, IOException {
		// 뷰에서 컨텐트, 타이틀, 파일을 골라 본내고 컨트롤러는 그걸 캐치해서 이쪽으로 넘겨준 것..
		// 추가로 BoardDto 에 writer를 세팅해줘야함 ( session으로.. 로그인한사람...)
		MemberDto mdto = (MemberDto)session.getAttribute("log");
		bdto.setWriter(mdto.getId());
		int rst = 0;
		
		// MultipartFile 바꾼게 업로드가 끝난게 아님
		if(mpf.isEmpty()) {
			rst = bdao.createOne(bdto);
		}else {
			String realfile = mpf.getOriginalFilename();
			mpf.getSize();   // 파일크기(byte로.. type은 long)
			String tempfile = UUID.randomUUID().toString(); // 16의 32승개의 경우의 수를 갖는 숫자들이 나옴.. 이걸 tempfile로 사용
			String path = application.getRealPath("/files");
			File dir = new File(path);  
			dir.mkdirs();  // 디렉토리 생성
			
			File temp = new File(dir, tempfile);   // dir디렉토리에 tempfile 이름으로 파일 생성
			mpf.transferTo(temp);
			
			fdto.setRealfile(realfile);
			fdto.setTempfile(temp.getAbsolutePath());  // 파일명까지 나옴
			bdao.createOne(bdto);
			rst = fdao.createOne(fdto);
		}
		return rst;
	}
}
