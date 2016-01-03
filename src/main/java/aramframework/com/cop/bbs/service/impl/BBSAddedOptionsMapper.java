package aramframework.com.cop.bbs.service.impl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import aramframework.com.cop.bbs.service.BoardMasterVO;

/**
 * 2단계 기능 추가 (댓글관리, 만족도조사) 관리를 위한 데이터 접근 클래스
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

@Mapper("bbsAddedOptionsMapper")
public interface BBSAddedOptionsMapper  {

	/**
	 * 게시판 추가기능 정보 한 건을 상세조회 한다.
	 * 
	 * @param bbsId
	 */
	public BoardMasterVO selectAddedOptionsInf(String bbsId) ;

	/**
	 * 신규 게시판 추가기능 정보를 등록한다.
	 * 
	 * @param boardMasterVO
	 */
	public void insertAddedOptionsInf(BoardMasterVO boardMasterVO) ;

	/**
	 * 게시판 추가기능 정보를 수정한다.
	 * 
	 * @param boardMasterVO
	 */
	public void updateAddedOptionsInf(BoardMasterVO boardMasterVO) ;
	
}
