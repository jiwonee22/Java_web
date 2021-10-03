package dto;

import java.util.Date;

public class Board {
	
	private int boardNo;
	private String title;
	private String userId;
	private String content;
	private int hit;
	private Date writeDate;
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", userId=" + userId + ", content=" + content
				+ ", hit=" + hit + ", writeDate=" + writeDate + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	


}
