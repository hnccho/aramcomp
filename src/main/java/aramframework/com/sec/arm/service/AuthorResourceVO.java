package aramframework.com.sec.arm.service;

import aramframework.com.cmm.SearchVO;

/**
 * 권한별 롤 관리에 대한 model 클래스를 정의한다.
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

public class AuthorResourceVO extends SearchVO {

	private static final long serialVersionUID = 1L;

	// 추가 검색 설정
	/** 검색조건 */
	private String saveSearchCondition = "";

	/** 검색Keyword */
	private String saveSearchKeyword = "";

	/** 현재페이지 */
	private int savePageIndex = 1;
	
	// DOMAIN 설정
	/** 권한코드 */
	private String authorCode;
	
	/** 롤코드 */
	private String resourceCode;
	
	/** 롤명 */
	private String resourceNm;
	
	/** 롤 패턴 */
	private String resourcePttrn;
	
	/** 롤 설명 */
	private String resourceDc;
	
	/** 롤 타입 */
	private String resourceTy;
	
	/** 롤 순서정렬 */
	private String resourceSort;
	
	/** 롤 등록여부 */
	private String regYn;
	
	/** 등록일자 */
	private String creatDt;

	/**
	 * searchCondition attribute 값을 리턴한다.
	 * 
	 * @return String
	 */
	public String getSaveSearchCondition() {
		return saveSearchCondition;
	}
	/**
	 * searchCondition attribute 값을 설정한다.
	 * 
	 * @param searchCondition
	 *            String
	 */
	public void setSaveSearchCondition(String saveSearchCondition) {
		this.saveSearchCondition = saveSearchCondition;
	}

	/**
	 * searchKeyword attribute 값을 리턴한다.
	 * 
	 * @return String
	 */
	public String getSaveSearchKeyword() {
		return saveSearchKeyword;
	}
	/**
	 * searchKeyword attribute 값을 설정한다.
	 * 
	 * @param searchKeyword
	 *            String
	 */
	public void setSaveSearchKeyword(String saveSearchKeyword) {
		this.saveSearchKeyword = saveSearchKeyword;
	}

	/**
	 * pageIndex attribute 값을 리턴한다.
	 * 
	 * @return int
	 */
	public int getSavePageIndex() {
		return savePageIndex;
	}
	/**
	 * pageIndex attribute 값을 설정한다.
	 * 
	 * @param pageIndex
	 *            int
	 */
	public void setSavePageIndex(int savePageIndex) {
		this.savePageIndex = savePageIndex;
	}

	/**
	 * authorCode attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * authorCode attribute 값을 설정한다.
	 * 
	 * @param authorCode
	 *            String
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}

	/**
	 * resourceCode attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourceCode() {
		return resourceCode;
	}
	/**
	 * resourceCode attribute 값을 설정한다.
	 * 
	 * @param resourceCode
	 *            String
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	/**
	 * resourceNm attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourceNm() {
		return resourceNm;
	}
	/**
	 * resourceNm attribute 값을 설정한다.
	 * 
	 * @param resourceNm
	 *            String
	 */
	public void setResourceNm(String resourceNm) {
		this.resourceNm = resourceNm;
	}

	/**
	 * resourcePttrn attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourcePttrn() {
		return resourcePttrn;
	}
	/**
	 * resourcePttrn attribute 값을 설정한다.
	 * 
	 * @param resourcePttrn
	 *            String
	 */
	public void setResourcePttrn(String resourcePttrn) {
		this.resourcePttrn = resourcePttrn;
	}

	/**
	 * resourceDc attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourceDc() {
		return resourceDc;
	}
	/**
	 * resourceDc attribute 값을 설정한다.
	 * 
	 * @param resourceDc
	 *            String
	 */
	public void setResourceDc(String resourceDc) {
		this.resourceDc = resourceDc;
	}

	/**
	 * resourceTy attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourceTy() {
		return resourceTy;
	}
	/**
	 * resourceTy attribute 값을 설정한다.
	 * 
	 * @param resourceTy
	 *            String
	 */
	public void setResourceTy(String resourceTy) {
		this.resourceTy = resourceTy;
	}

	/**
	 * resourceSort attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getResourceSort() {
		return resourceSort;
	}
	/**
	 * resourceSort attribute 값을 설정한다.
	 * 
	 * @param resourceSort
	 *            String
	 */
	public void setResourceSort(String resourceSort) {
		this.resourceSort = resourceSort;
	}

	/**
	 * regYn attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getRegYn() {
		return regYn;
	}
	/**
	 * regYn attribute 값을 설정한다.
	 * 
	 * @param regYn
	 *            String
	 */
	public void setRegYn(String regYn) {
		this.regYn = regYn;
	}

	/**
	 * creatDt attribute 를 리턴한다.
	 * 
	 * @return String
	 */
	public String getCreatDt() {
		return creatDt;
	}
	/**
	 * creatDt attribute 값을 설정한다.
	 * 
	 * @param creatDt
	 *            String
	 */
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}

}
