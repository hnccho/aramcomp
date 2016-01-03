package aramframework.com.sts.ust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aramframework.com.sts.com.StatsVO;
import aramframework.com.sts.ust.service.UserStatsService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 사용자 통계 검색 비즈니스 구현 클래스
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

@Service("userStatsService")
public class UserStatsServiceImpl extends EgovAbstractServiceImpl implements UserStatsService {

	@Resource(name = "userStatsMapper")
	private UserStatsMapper userStatsMapper;	

	/**
	 * 사용자 통계를 조회한다
	 * 
	 * @param statsVO
	 */
	public List<StatsVO> selectUserStats(StatsVO statsVO) {
		return userStatsMapper.selectUserStats(statsVO);
	}

	/**
	 * 사용자 통계를 위한 집계를 하루단위로 작업하는 배치 프로그램
	 * 
	 */
	public void summaryUserStats() {
		userStatsMapper.summaryUserStats();
	}
	
}
