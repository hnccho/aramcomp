package aramframework.com.uss.ion.ntr.domain;

import aramframework.com.cmm.domain.SearchVO;

/**
 * 받은쪽지함관리 Model and VO Class 구현
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 * @see
 *
 * <pre>
 * 
 * << 개정이력(Modification Information) >>
 *   
 *   수정일            수정자          수정내용
 *   -------     ------   ---------------------------
 *   2014.11.11  조헌철         최초 생성
 * 
 * </pre>
 */

public class NoteRecptnVO extends SearchVO {

	// domain
	/** 쪽지 수신 ID */
	private String noteRecptnId;

	/** 쪽지 ID */
	private String noteId;

	/** 쪽지 송신 ID */
	private String noteTrnsmitId;

	/** 수신자 ID */
	private String rcverId;

	/** 개봉여부 */
	private String openYn;

	/** 수신구분 */
	private String recptnSe;

	// helper
	/** 쪽지 제목 */
	private String noteSj;

	/** 쪽지 내용 */
	private String noteCn;

	/** 보낸 시작날짜 */
	private String searchFromDate;

	/** 보낸 종료날짜 */
	private String searchToDate;

	/** 쪽지 첨부파일 */
	private byte[] atchFileId;

	// domain
	/**
	 * @return the noteRecptnId
	 */
	public String getNoteRecptnId() {
		return noteRecptnId;
	}
	/**
	 * @param noteRecptnId
	 *            the noteRecptnId to set
	 */
	public void setNoteRecptnId(String noteRecptnId) {
		this.noteRecptnId = noteRecptnId;
	}

	/**
	 * @return the noteId
	 */
	public String getNoteId() {
		return noteId;
	}
	/**
	 * @param noteId
	 *            the noteId to set
	 */
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	/**
	 * @return the noteTrnsmitId
	 */
	public String getNoteTrnsmitId() {
		return noteTrnsmitId;
	}
	/**
	 * @param noteTrnsmitId
	 *            the noteTrnsmitId to set
	 */
	public void setNoteTrnsmitId(String noteTrnsmitId) {
		this.noteTrnsmitId = noteTrnsmitId;
	}

	/**
	 * @return the rcverId
	 */
	public String getRcverId() {
		return rcverId;
	}
	/**
	 * @param rcverId
	 *            the rcverId to set
	 */
	public void setRcverId(String rcverId) {
		this.rcverId = rcverId;
	}

	/**
	 * @return the openYn
	 */
	public String getOpenYn() {
		return openYn;
	}
	/**
	 * @param openYn
	 *            the openYn to set
	 */
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

	/**
	 * @return the recptnSe
	 */
	public String getRecptnSe() {
		return recptnSe;
	}
	/**
	 * @param recptnSe
	 *            the recptnSe to set
	 */
	public void setRecptnSe(String recptnSe) {
		this.recptnSe = recptnSe;
	}

	// helper
	/**
	 * @return the noteSj
	 */
	public String getNoteSj() {
		return noteSj;
	}
	/**
	 * @param noteSj
	 *            the noteSj to set
	 */
	public void setNoteSj(String noteSj) {
		this.noteSj = noteSj;
	}

	/**
	 * @return the noteCn
	 */
	public String getNoteCn() {
		return noteCn;
	}
	/**
	 * @param noteCn
	 *            the noteCn to set
	 */
	public void setNoteCn(String noteCn) {
		this.noteCn = noteCn;
	}

	/**
	 * @return the searchFromDate
	 */
	public String getSearchFromDate() {
		return searchFromDate;
	}
	/**
	 * @param searchFromDate
	 *            the searchFromDate to set
	 */
	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}

	/**
	 * @return the searchToDate
	 */
	public String getSearchToDate() {
		return searchToDate;
	}
	/**
	 * @param searchToDate
	 *            the searchToDate to set
	 */
	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}

	/**
	 * @return the atchFileId
	 */
	public byte[] getAtchFileId() {
		return atchFileId;
	}
	/**
	 * @param atchFileId
	 *            the atchFileId to set
	 */
	public void setAtchFileId(byte[] atchFileId) {
		this.atchFileId = atchFileId;
	}

}
