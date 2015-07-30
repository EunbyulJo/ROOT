package org.it.board.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FilesDto {
	private int num;
	private int fnum;
	private String realfile;
	private String tempfile;
	private int cnt;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getRealfile() {
		return realfile;
	}
	public void setRealfile(String realfile) {
		this.realfile = realfile;
	}
	public String getTempfile() {
		return tempfile;
	}
	public void setTempfile(String tempfile) {
		this.tempfile = tempfile;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
