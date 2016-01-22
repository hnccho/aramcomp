package aramframework.com.uss.olh.omm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.cmm.util.BeanUtil;
import aramframework.com.uss.olh.omm.service.OnlineManualService;
import aramframework.com.uss.olh.omm.service.OnlineManualVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 온라인메뉴얼를 처리하는 ServiceImpl Class 구현
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

@Service
public class OnlineManualServiceImpl extends EgovAbstractServiceImpl implements OnlineManualService {

	@Autowired
	private OnlineManualMapper onlineManualMapper;	

	@Autowired
	private EgovIdGnrService onlineManualIdGnrService; 

	/**
	 * 온라인메뉴얼를(을) 목록을 조회 한다.
	 * 
	 * @param onlineManualVO
	 */
	public List<EgovMap> selectOnlineManualList(OnlineManualVO onlineManualVO) {
		return onlineManualMapper.selectOnlineManualList(onlineManualVO);
	}

	/**
	 * 온라인메뉴얼를(을) 목록 전체 건수를(을) 조회한다.
	 * 
	 * @param onlineManualVO
	 */
	public int selectOnlineManualListCnt(OnlineManualVO onlineManualVO) {
		return (Integer) onlineManualMapper.selectOnlineManualListCnt(onlineManualVO);
	}

	/**
	 * 온라인메뉴얼를(을) 상세조회 한다.
	 * 
	 * @param onlineManualVO
	 */
	public OnlineManualVO selectOnlineManualDetail(OnlineManualVO onlineManualVO) {
		OnlineManualVO resultVo = onlineManualMapper.selectOnlineManualDetail(onlineManualVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, onlineManualVO); 
		return resultVo;
	}

	/**
	 * 온라인메뉴얼를(을) 등록한다.
	 * 
	 * @param onlineManualVO
	 */
	public void insertOnlineManual(OnlineManualVO onlineManualVO) {
		try {
			onlineManualVO.setOnlineMnlId(onlineManualIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		onlineManualMapper.insertOnlineManual(onlineManualVO);
	}

	/**
	 * 온라인메뉴얼를(을) 수정한다.
	 * 
	 * @param onlineManualVO
	 */
	public void updateOnlineManual(OnlineManualVO onlineManualVO) {
		onlineManualMapper.updateOnlineManual(onlineManualVO);
	}

	/**
	 * 온라인메뉴얼를(을) 삭제한다.
	 * 
	 * @param onlineManualVO
	 */
	public void deleteOnlineManual(OnlineManualVO onlineManualVO) {
		onlineManualMapper.deleteOnlineManual(onlineManualVO);
	}

}
