package aramframework.com.ssi.syi.ims.domain;

import aramframework.com.cmm.domain.BaseVO;

/**
 * 연계메시지항목 VO 클래스
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 * @see
 *
 */
public class CntcMessageItemVO extends BaseVO  {

	// domain
	/** 연계메시지ID */
	private String cntcMessageId = "";

	/** 항목ID */
	private String itemId = "";

	/** 항목명 */
	private String itemNm = "";

	/** 항목타입 */
	private String itemType = "";

	/** 항목길이 */
	private int itemLt = 0;

	/**
	 * cntcMessageId attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getCntcMessageId() {
		return cntcMessageId;
	}
	/**
	 * cntcMessageId attribute 값을 설정한다.
	 * 
	 * @param cntcMessageId
	 *            String
	 */
	public void setCntcMessageId(String cntcMessageId) {
		this.cntcMessageId = cntcMessageId;
	}

	/**
	 * itemId attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * itemId attribute 값을 설정한다.
	 * 
	 * @param itemId
	 *            String
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * itemNm attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getItemNm() {
		return itemNm;
	}
	/**
	 * itemNm attribute 값을 설정한다.
	 * 
	 * @param itemNm
	 *            String
	 */
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	/**
	 * itemType attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * itemType attribute 값을 설정한다.
	 * 
	 * @param itemType
	 *            String
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * itemLt attribute 를 리턴한다.
	 * 
	 * @return int
	 */
	public int getItemLt() {
		return itemLt;
	}
	/**
	 * itemLt attribute 값을 설정한다.
	 * 
	 * @param itemLt
	 *            int
	 */
	public void setItemLt(int itemLt) {
		this.itemLt = itemLt;
	}

}
