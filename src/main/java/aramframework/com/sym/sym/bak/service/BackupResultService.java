package aramframework.com.sym.sym.bak.service;

import java.util.List;

/**
 * 백업결과관리에 대한 Service Interface를 정의한다.
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

public interface BackupResultService {

	/**
	 * 백업결과 목록을 조회한다.
	 * 
	 * @param backupResultVO
	 */
	public List<BackupResultVO> selectBackupResultList(BackupResultVO backupResultVO);

	/**
	 * 백업결과 목록 전체 건수를(을) 조회한다.
	 * 
	 * @param backupResultVO
	 */
	public int selectBackupResultListCnt(BackupResultVO backupResultVO);

	/**
	 * 백업결과을 상세조회 한다.
	 * 
	 * @param backupResultVO
	 */
	public BackupResultVO selectBackupResult(BackupResultVO backupResultVO);

	/**
	 * 백업결과을 삭제한다.
	 * 
	 * @param backupResultVO
	 */
	public void deleteBackupResult(BackupResultVO backupResultVO);

}