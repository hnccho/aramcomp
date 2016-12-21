package aramframework.com.uss.olp.qtm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.uss.olp.qtm.dao.QustnrTmplatManageMapper;
import aramframework.com.uss.olp.qtm.domain.QustnrTmplatManageVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 설문템플릿 ServiceImpl Class 구현
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 * @see
 *
 */
@Service
public class QustnrTmplatManageService extends EgovAbstractServiceImpl {

	@Autowired
	private QustnrTmplatManageMapper qustnrTmplatManageMapper;	

	@Autowired
	private EgovIdGnrService qustnrTmplatManageIdGnrService; 

	/**
	 * 설문템플릿 목록을 조회한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public List<EgovMap> selectQustnrTmplatManageList(QustnrTmplatManageVO qustnrTmplatManageVO) {
		return qustnrTmplatManageMapper.selectQustnrTmplatManageList(qustnrTmplatManageVO);
	}

	/**
	 * 설문템플릿를(을) 목록 전체 건수를(을) 조회한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public int selectQustnrTmplatManageListCnt(QustnrTmplatManageVO qustnrTmplatManageVO) {
		return (Integer) qustnrTmplatManageMapper.selectQustnrTmplatManageListCnt(qustnrTmplatManageVO);
	}

	/**
	 * 설문템플릿를(을) 상세조회 한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public QustnrTmplatManageVO selectQustnrTmplatManageDetail(QustnrTmplatManageVO qustnrTmplatManageVO) {
		QustnrTmplatManageVO resultVo = qustnrTmplatManageMapper.selectQustnrTmplatManageDetail(qustnrTmplatManageVO);
		// searchVO 이전 
		resultVo.setSearchVO(qustnrTmplatManageVO.getSearchVO()); 
		return resultVo;
	}

	/**
	 * 템플릿파일명을 조회한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public QustnrTmplatManageVO selectQustnrTmplatManageTmplatImage(QustnrTmplatManageVO qustnrTmplatManageVO) {
		return qustnrTmplatManageMapper.selectQustnrTmplatManageTmplatImage(qustnrTmplatManageVO);
	}

	/**
	 * 설문템플릿를(을) 등록한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public void insertQustnrTmplatManage(QustnrTmplatManageVO qustnrTmplatManageVO) {
		try {
			qustnrTmplatManageVO.setQestnrTmplatId(qustnrTmplatManageIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		qustnrTmplatManageMapper.insertQustnrTmplatManage(qustnrTmplatManageVO);
	}

	/**
	 * 설문템플릿를(을) 수정한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public void updateQustnrTmplatManage(QustnrTmplatManageVO qustnrTmplatManageVO) {
		qustnrTmplatManageMapper.updateQustnrTmplatManage(qustnrTmplatManageVO);
	}

	/**
	 * 설문템플릿를(을) 삭제한다.
	 * 
	 * @param qustnrTmplatManageVO
	 */
	public void deleteQustnrTmplatManage(QustnrTmplatManageVO qustnrTmplatManageVO) {
		qustnrTmplatManageMapper.deleteQustnrTmplatManage(qustnrTmplatManageVO);
	}
	
}
