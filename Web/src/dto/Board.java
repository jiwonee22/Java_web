package dto;

import java.util.Date;

public class Board {
	
	private int boardno;
	private String title;
	private String userid;
	private String content;
	private int hit;
	private Date write_date;
	
	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", title=" + title + ", userid=" + userid + ", content=" + content
				+ ", hit=" + hit + ", write_date=" + write_date + "]";
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	

}
