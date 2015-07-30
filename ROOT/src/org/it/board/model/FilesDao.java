package org.it.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilesDao {

	@Autowired
	SqlSession sess;
	
	public int createOne(FilesDto fdto) {
		int r = sess.insert("org.it.board.model.FilesDao.createOne", fdto);
		return r;
	}
	
	public List<FilesDto> readSome(String num) {
		return sess.selectList("org.it.board.model.FilesDao.readSome", num);
	}
	
	public List<FilesDto> readOne(String fnum) {
		return sess.selectOne("org.it.board.model.FilesDao.readOne", fnum);
	}
	
	public int updateCnt(String fnum) {
		return sess.update("org.it.board.model.FilesDao.updateCnt", fnum);
	}
}
