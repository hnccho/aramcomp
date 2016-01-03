package aramframework.com.uss.olp.qmc.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 설문관리를 처리하는 Service Class 구현
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

public interface QustnrManageService {

	/**
	 * 설문템플릿 목록을 조회한다.
	 * 
	 * @param qustnrManageVO
	 */
	public List<EgovMap> selectQustnrTmplatManageList(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리 목록을 조회한다.
	 * 
	 * @param qustnrManageVO
	 */
	public List<EgovMap> selectQustnrManageList(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리를(을) 목록 전체 건수를(을) 조회한다.
	 * 
	 * @param qustnrManageVO
	 */
	public int selectQustnrManageListCnt(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리를 상세조회(Model) 한다.
	 * 
	 * @param qustnrManageVO
	 */
	public QustnrManageVO selectQustnrManageDetail(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리를(을) 등록한다.
	 * 
	 * @param qustnrManageVO
	 */
	void insertQustnrManage(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리를(을) 수정한다.
	 * 
	 * @param qustnrManageVO
	 */
	void updateQustnrManage(QustnrManageVO qustnrManageVO);

	/**
	 * 설문관리를(을) 삭제한다.
	 * 
	 * @param qustnrManageVO
	 */
	void deleteQustnrManage(QustnrManageVO qustnrManageVO);

}
