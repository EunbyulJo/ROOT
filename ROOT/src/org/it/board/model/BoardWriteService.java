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
	
	// ��Ʈ�ѷ��κ��� �ʿ��� �������� ���޹޾Ƽ� ó��
	// ������ ���� �� MultipartFile�� �޾ƾ��� ( input type="file")
	public int writeService(BoardDto bdto, MultipartFile mpf) throws IllegalStateException, IOException {
		// �信�� ����Ʈ, Ÿ��Ʋ, ������ ��� ������ ��Ʈ�ѷ��� �װ� ĳġ�ؼ� �������� �Ѱ��� ��..
		// �߰��� BoardDto �� writer�� ����������� ( session����.. �α����ѻ��...)
		MemberDto mdto = (MemberDto)session.getAttribute("log");
		bdto.setWriter(mdto.getId());
		int rst = 0;
		
		// MultipartFile �ٲ۰� ���ε尡 ������ �ƴ�
		if(mpf.isEmpty()) {
			rst = bdao.createOne(bdto);
		}else {
			String realfile = mpf.getOriginalFilename();
			mpf.getSize();   // ����ũ��(byte��.. type�� long)
			String tempfile = UUID.randomUUID().toString(); // 16�� 32�°��� ����� ���� ���� ���ڵ��� ����.. �̰� tempfile�� ���
			String path = application.getRealPath("/files");
			File dir = new File(path);  
			dir.mkdirs();  // ���丮 ����
			
			File temp = new File(dir, tempfile);   // dir���丮�� tempfile �̸����� ���� ����
			mpf.transferTo(temp);
			
			fdto.setRealfile(realfile);
			fdto.setTempfile(temp.getAbsolutePath());  // ���ϸ���� ����
			bdao.createOne(bdto);
			rst = fdao.createOne(fdto);
		}
		return rst;
	}
}
