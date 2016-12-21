package aramframework.com.uss.ion.bnr.domain;

import aramframework.com.cmm.domain.BaseVO;

/**
 * 개요
 * - 배너에 대한 Vo 클래스를 정의한다.
 *
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 * @see
 *
 */
public class BannerVO extends BaseVO {

	// domain
	/** 배너 ID */
	private String bannerId;
	
	/** 배너 명 */
	private String bannerNm;
	
	/** 링크 URL */
	private String linkUrl;
	
	/** 배너 이미지 */
	private String bannerImage;
	
	/** 배너 설명 */
	private String bannerDc;
	
	/** 반영여부 */
	private String reflctAt;
	
	/** 배너 이미지 파일 */
	private String bannerImageFile;
	
	/** 정렬 순서 */
	private String sortOrdr;
	
	// helper
	/** 사용자 ID */
	private String userId;
	
	/** 등록일자 */
	private String regDate;
	
	/** 파일첨부여부 */
	private boolean isAtchFile;

	/** 결과 반영 타입 vertical : 세로 horizontal : 가로 */
	String resultType = "horizontal";

	// domain
	/**
	 * @return the bannerId
	 */
	public String getBannerId() {
		return bannerId;
	}
	/**
	 * @param bannerId
	 *            the bannerId to set
	 */
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	/**
	 * @return the bannerNm
	 */
	public String getBannerNm() {
		return bannerNm;
	}
	/**
	 * @param bannerNm
	 *            the bannerNm to set
	 */
	public void setBannerNm(String bannerNm) {
		this.bannerNm = bannerNm;
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
	}
	/**
	 * @param linkUrl
	 *            the linkUrl to set
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
	 * @return the bannerImage
	 */
	public String getBannerImage() {
		return bannerImage;
	}
	/**
	 * @param bannerImage
	 *            the bannerImage to set
	 */
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	/**
	 * @return the bannerDc
	 */
	public String getBannerDc() {
		return bannerDc;
	}
	/**
	 * @param bannerDc
	 *            the bannerDc to set
	 */
	public void setBannerDc(String bannerDc) {
		this.bannerDc = bannerDc;
	}

	/**
	 * @return the reflctAt
	 */
	public String getReflctAt() {
		return reflctAt;
	}
	/**
	 * @param reflctAt
	 *            the reflctAt to set
	 */
	public void setReflctAt(String reflctAt) {
		this.reflctAt = reflctAt;
	}

	/**
	 * @return the bannerImageFile
	 */
	public String getBannerImageFile() {
		return bannerImageFile;
	}
	/**
	 * @param bannerImageFile
	 *            the bannerImageFile to set
	 */
	public void setBannerImageFile(String bannerImageFile) {
		this.bannerImageFile = bannerImageFile;
	}

	/**
	 * @return the sortOrdr
	 */
	public String getSortOrdr() {
		return sortOrdr;
	}
	/**
	 * @param sortOrdr
	 *            the sortOrdr to set
	 */
	public void setSortOrdr(String sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	// helper
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate
	 *            the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the isAtchFile
	 */
	public boolean isAtchFile() {
		return isAtchFile;
	}
	/**
	 * @param isAtchFile
	 *            the isAtchFile to set
	 */
	public void setAtchFile(boolean isAtchFile) {
		this.isAtchFile = isAtchFile;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}
	/**
	 * @param resultType
	 *            the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

}
