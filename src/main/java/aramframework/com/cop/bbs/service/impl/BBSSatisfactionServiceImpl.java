package aramframework.com.cop.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aramframework.com.cmm.util.BeanUtil;
import aramframework.com.cop.bbs.service.BoardMasterVO;
import aramframework.com.cop.bbs.service.BBSSatisfactionService;
import aramframework.com.cop.bbs.service.SatisfactionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 만족도조사를 위한 서비스 구현 클래스
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

@Service("bbsSatisfactionService")
public class BBSSatisfactionServiceImpl extends EgovAbstractServiceImpl implements BBSSatisfactionService {

	@Resource(name = "bbsAddedOptionsMapper")
	private BBSAddedOptionsMapper bbsAddedOptionsMapper;	

	@Resource(name = "bbsSatisfactionMapper")
	private BBSSatisfactionMapper bbsSatisfactionMapper;	

	@Resource(name = "stsfdgNoGnrService")
	private EgovIdGnrService idgenService;
	
	/**
	 * 만족도조사 사용 가능 여부를 확인한다.
	 * 
	 * @param bbsId
	 */
	public boolean canUseSatisfaction(String bbsId) {
		BoardMasterVO options = bbsAddedOptionsMapper.selectAddedOptionsInf(bbsId);
		if (options == null) {
			return false;
		}
		if (options.getStsfdgAt().equals("Y")) {
			return true;
		}
		return false;
	}

	/**
	 * 만족도조사에 대한 목록을 조회 한다.
	 * 
	 * @param satisfactionVO
	 */
	public List<EgovMap> selectSatisfactionList(SatisfactionVO satisfactionVO) {
		return bbsSatisfactionMapper.selectSatisfactionList(satisfactionVO);
	}

	/**
	 * 만족도조사에 대한 목록 총갯수을 조회 한다.
	 * 
	 * @param satisfactionVO
	 */
	public int selectSatisfactionListCnt(SatisfactionVO satisfactionVO) {
		return bbsSatisfactionMapper.selectSatisfactionListCnt(satisfactionVO);
	}

	/**
	 * 만족도조사에 대한 목록 요약점수을 조회 한다.
	 * 
	 * @param satisfactionVO
	 */
	public float getSummary(SatisfactionVO satisfactionVO) {
		return bbsSatisfactionMapper.getSummary(satisfactionVO);
	}

	/**
	 * 만족도조사에 대한 내용을 조회한다.
	 * 
	 * @param satisfactionVO
	 */
	public SatisfactionVO selectSatisfaction(SatisfactionVO satisfactionVO) {
		SatisfactionVO resultVo = bbsSatisfactionMapper.selectSatisfaction(satisfactionVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, satisfactionVO); 
		return resultVo;
	}

	/**
	 * 만족도조사를 등록한다.
	 * 
	 * @param satisfactionVO
	 */
	public void insertSatisfaction(SatisfactionVO satisfactionVO) {
		try {
			satisfactionVO.setStsfdgNo(idgenService.getNextLongId() + "");
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		bbsSatisfactionMapper.insertSatisfaction(satisfactionVO);
	}

	/**
	 * 만족도조사에 대한 내용을 수정한다.
	 * 
	 * @param satisfactionVO
	 */
	public void updateSatisfaction(SatisfactionVO satisfactionVO) {
		bbsSatisfactionMapper.updateSatisfaction(satisfactionVO);
	}

	/**
	 * 만족도조사를 삭제한다.
	 * 
	 * @param satisfactionVO
	 */
	public void deleteSatisfaction(SatisfactionVO satisfactionVO) {
		bbsSatisfactionMapper.deleteSatisfaction(satisfactionVO);
	}

	/**
	 * 만족도조사 패스워드를 가져온다.
	 * 
	 * @param satisfactionVO
	 */
	public String getSatisfactionPassword(SatisfactionVO satisfactionVO) {
		return bbsSatisfactionMapper.getSatisfactionPassword(satisfactionVO);
	}
	
}
