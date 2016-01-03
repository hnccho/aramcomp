package aramframework.com.cop.smt.lsm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aramframework.com.cmm.util.BeanUtil;
import aramframework.com.cop.smt.lsm.service.LeaderSchdulService;
import aramframework.com.cop.smt.lsm.service.LeaderSchdulVO;
import aramframework.com.cop.smt.lsm.service.LeaderSttusVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 개요 - 간부일정에 대한 ServiceImpl 클래스를 정의한다.
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

@Service("leaderSchdulService")
public class LeaderSchdulServiceImpl extends EgovAbstractServiceImpl implements LeaderSchdulService {

	@Resource(name = "leaderSchdulMapper")
	private LeaderSchdulMapper leaderSchdulMapper;	

	@Resource(name = "leaderSchdulIdGnrService")
	private EgovIdGnrService idgenService;

	/**
	 * 월별 간부일정 목록을 조회한다.
	 * 
	 * @param leaderSchdulVO
	 */
	public List<EgovMap> selectLeaderSchdulList(LeaderSchdulVO leaderSchdulVO) {
		return (List<EgovMap>) leaderSchdulMapper.selectLeaderSchdulList(leaderSchdulVO);
	}

	/**
	 * 간부일정 정보를 조회한다.
	 * 
	 * @param LeaderSchdulVO
	 */
	public LeaderSchdulVO selectLeaderSchdul(LeaderSchdulVO leaderSchdulVO) {
		LeaderSchdulVO resultVo = leaderSchdulMapper.selectLeaderSchdul(leaderSchdulVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, leaderSchdulVO); 
		return resultVo;
	}

	/**
	 * 간부일정 정보를 수정한다.
	 * 
	 * @param leaderSchdulVO
	 */
	public void updateLeaderSchdul(LeaderSchdulVO leaderSchdulVo) {
		leaderSchdulMapper.updateLeaderSchdul(leaderSchdulVo);
	}

	/**
	 * 간부일정 정보를 등록한다.
	 * 
	 * @param leaderSchdulVO
	 */
	public void insertLeaderSchdul(LeaderSchdulVO leaderSchdulVo) {
		try {
			leaderSchdulVo.setSchdulId(idgenService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		leaderSchdulMapper.insertLeaderSchdul(leaderSchdulVo);
	}

	/**
	 * 간부일정 정보를 삭제한다.
	 * 
	 * @param leaderSchdulVO
	 */
	public void deleteLeaderSchdul(LeaderSchdulVO leaderSchdulVo) {
		leaderSchdulMapper.deleteLeaderSchdul(leaderSchdulVo);
	}

	/**
	 * 간부상태 목록을 조회한다.
	 * 
	 * @param leaderSttusVO
	 */
	public List<EgovMap> selectLeaderSttusList(LeaderSttusVO leaderSttusVO) {
		return leaderSchdulMapper.selectLeaderSttusList(leaderSttusVO);
	}

	/**
	 * 간부상태 총횟수를 조회한다.
	 * 
	 * @param leaderSttusVO
	 */
	public int selectLeaderSttusListCnt(LeaderSttusVO leaderSttusVO) {
		return leaderSchdulMapper.selectLeaderSttusListCnt(leaderSttusVO);
	}

	/**
	 * 간부상태 정보를 조회한다.
	 * 
	 * @param leaderSttusVO
	 */
	public LeaderSttusVO selectLeaderSttus(LeaderSttusVO leaderSttusVO) {
		LeaderSttusVO resultVo = leaderSchdulMapper.selectLeaderSttus(leaderSttusVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, leaderSttusVO); 
		return resultVo;
	}

	/**
	 * 간부상태를 등록하기 위한 중복 조회를 수행한다.
	 * 
	 * @param leaderSttusVO
	 */
	public int selectLeaderSttusCheck(LeaderSttusVO leaderSttusVO) {
		return leaderSchdulMapper.selectLeaderSttusCheck(leaderSttusVO);
	}

	/**
	 * 간부상태 정보를 등록한다.
	 * 
	 * @param leaderSttusVO
	 */
	public void insertLeaderSttus(LeaderSttusVO leaderSttusVO) {
		leaderSchdulMapper.insertLeaderSttus(leaderSttusVO);
	}

	/**
	 * 간부상태 정보를 수정한다.
	 * 
	 * @param leaderSttusVO
	 */
	public void updateLeaderSttus(LeaderSttusVO leaderSttusVO) {
		leaderSchdulMapper.updateLeaderSttus(leaderSttusVO);
	}

	/**
	 * 간부상태 정보를 삭제한다.
	 * 
	 * @param leaderSttusVO
	 */
	public void deleteLeaderSttus(LeaderSttusVO leaderSttusVO) {
		leaderSchdulMapper.deleteLeaderSttus(leaderSttusVO);
	}

}