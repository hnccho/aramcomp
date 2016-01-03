package aramframework.com.utl.sys.prm.service;

import java.util.List;

/**
 * 개요 - PROCESS모니터링에 대한 Service Interface를 정의한다.
 * 
 * 상세내용 - PROCESS모니터링에 대한 등록, 수정, 삭제, 조회 기능을 제공한다. 
 *         - PROCESS모니터링의 조회기능은 목록조회, 상세조회로 구분된다.
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

public interface ProcessMonService {

	/**
	 * 등록된 PROCESS모니터링 목록을 조회한다.
	 * 
	 * @param processMonVO
	 */
	public List<ProcessMonVO> selectProcessMonList(ProcessMonVO processMonVO);

	/**
	 * PROCESS모니터링 목록 총 갯수를 조회한다.
	 * 
	 * @param processMonVO
	 */
	int selectProcessMonListCnt(ProcessMonVO searchVO);

	/**
	 * 등록된 PROCESS모니터링의 상세정보를 조회한다.
	 * 
	 * @param processMonVO
	 */
	ProcessMonVO selectProcessMon(ProcessMonVO processMonVO);

	/**
	 * PROCESS모니터링 정보를 신규로 등록한다.
	 * 
	 * @param processMonVO
	 */
	public void insertProcessMon(ProcessMonVO processMonVO);

	/**
	 * 기 등록된 PROCESS모니터링 정보를 수정한다.
	 * 
	 * @param processMonVO
	 */
	public void updateProcessMon(ProcessMonVO processMonVO);

	/**
	 * 기 등록된 PROCESS모니터링 정보를 삭제한다.
	 * 
	 * @param processMonVO
	 */
	public void deleteProcessMon(ProcessMonVO processMonVO);

	/**
	 * 프로세스 모니터링 결과를 수정한다.
	 * 
	 * @param processMonVO
	 */
	public void updateProcessMonSttus(ProcessMonVO processMonVO);

	/**
	 * 프로세스 모니터링로그 목록을 조회한다.
	 * 
	 * @param processMonLogVO
	 */
	public List<ProcessMonLogVO> selectProcessMonLogList(ProcessMonLogVO processMonLogVO);

	/**
	 * 등록된 프로세스 모니터링로그 목록 총 갯수를 조회한다.
	 * 
	 * @param processMonLogVO
	 */
	public int selectProcessMonLogListCnt(ProcessMonLogVO processMonLogVO);

	/**
	 * 프로세스 모니터링로그의 상세정보를 조회한다.
	 * 
	 * @param processMonLogVO
	 */
	public ProcessMonLogVO selectProcessMonLog(ProcessMonLogVO processMonLogVO);

	/**
	 * 프로세스 모니터링로그를 등록한다.
	 * 
	 * @param processMonLogVO
	 */
	public void insertProcessMonLog(ProcessMonLogVO processMonLogVO);

}