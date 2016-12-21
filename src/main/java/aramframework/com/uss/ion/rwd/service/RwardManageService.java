package aramframework.com.uss.ion.rwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.cmm.util.FileMngUtil;
import aramframework.com.uss.ion.ism.domain.InfrmlSanctnVO;
import aramframework.com.uss.ion.ism.service.InfrmlSanctnService;
import aramframework.com.uss.ion.rwd.dao.RwardManageMapper;
import aramframework.com.uss.ion.rwd.domain.RwardManageVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 개요 - 포상관리에 대한 ServiceImpl 클래스를 정의한다.
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 * @see
 *
 */
@Service
public class RwardManageService extends EgovAbstractServiceImpl {

	@Autowired
	private RwardManageMapper rwardManageMapper;	

	/** ID Generation */
	@Autowired
	private EgovIdGnrService rwardManageIdGnrService; 

	@Autowired
	protected InfrmlSanctnService infrmlSanctnService;

	@Autowired
	private FileMngUtil fileUtil;

	/**
	 * 포상관리정보를 관리하기 위해 등록된 포상관리 목록을 조회한다.
	 * 
	 * @param rwardManageVO
	 */
	public List<EgovMap> selectRwardManageList(RwardManageVO rwardManageVO) {
		return  rwardManageMapper.selectRwardManageList(rwardManageVO);
	}

	/**
	 * 포상관리목록 총 갯수를 조회한다.
	 * 
	 * @param rwardManageVO
	 */
	public int selectRwardManageListCnt(RwardManageVO rwardManageVO) {
		return rwardManageMapper.selectRwardManageListCnt(rwardManageVO);
	}

	/**
	 * 등록된 포상관리의 상세정보를 조회한다.
	 * 
	 * @param rwardManageVO
	 */
	public RwardManageVO selectRwardManage(RwardManageVO rwardManageVO) {
		RwardManageVO resultVo = rwardManageMapper.selectRwardManage(rwardManageVO);
		// searchVO 이전 
		resultVo.setSearchVO(rwardManageVO.getSearchVO()); 
		return resultVo;
	}

	/**
	 * 포상관리정보를 신규로 등록한다.
	 * 
	 * @param rwardManageVO
	 */
	public void insertRwardManage(RwardManageVO rwardManageVO) {

		/*
		 * 포상 승인처리 신청 
		 * infrmlSanctnService.insertInfrmlSanctn("000", vcatnManage);
		 */
		InfrmlSanctnVO infrmlSanctn = infrmlSanctnService.insertInfrmlSanctn(converToInfrmlSanctnObject(rwardManageVO)); // 신청
		rwardManageVO.setInfrmlSanctnId(infrmlSanctn.getInfrmlSanctnId());
		rwardManageVO.setConfmAt(infrmlSanctn.getConfmAt());

		try {
			rwardManageVO.setRwardId(rwardManageIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		rwardManageMapper.insertRwardManage(rwardManageVO);
	}

	/**
	 * 기 등록된 포상관리정보를 수정한다.
	 * 
	 * @param rwardManageVO
	 */
	public void updtRwardManage(RwardManageVO rwardManageVO) {
		rwardManageMapper.updtRwardManage(rwardManageVO);
	}

	/**
	 * 기 등록된 포상관리정보를 삭제한다.
	 * 
	 * @param rwardManageVO
	 */
	public void deleteRwardManage(RwardManageVO rwardManageVO) {
		/*
		 * 포상 승인처리 삭제
		 * infrmlSanctnService.deleteInfrmlSanctn("000", vcatnManage);
		 */
		infrmlSanctnService.deleteInfrmlSanctn(converToInfrmlSanctnObject(rwardManageVO)); // 삭제
		rwardManageMapper.deleteRwardManage(rwardManageVO);
		// 첨부파일 삭제 ....
		fileUtil.deleteMultiFile(rwardManageVO.getAtchFileId());
	}

	/**
	 * 포상관리정보 승인 처리를 위해 신청된 포상관리 목록을 조회한다.
	 * 
	 * @param rwardManageVO
	 */
	public List<EgovMap> selectRwardManageConfmList(RwardManageVO rwardManageVO) {
		return  rwardManageMapper.selectRwardManageConfmList(rwardManageVO);
	}

	/**
	 * 포상승인목록 총 갯수를 조회한다.
	 * 
	 * @param rwardManageVO
	 */
	public int selectRwardManageConfmListCnt(RwardManageVO rwardManageVO) {
		return rwardManageMapper.selectRwardManageConfmListCnt(rwardManageVO);
	}

	/**
	 * 포상정보를 승인/반려처리 한다.
	 * 
	 * @param rwardManageVO
	 */
	public void updtRwardManageConfm(RwardManageVO rwardManageVO) {
		InfrmlSanctnVO infrmlSanctnVO = new InfrmlSanctnVO();
		if (rwardManageVO.getConfmAt().equals("C")) {
			/*
			 * 승인처리
			 */
			infrmlSanctnVO = infrmlSanctnService.updateInfrmlSanctnConfm(converToInfrmlSanctnObject(rwardManageVO)); // 승인
			// infrmlSanctn = infrmlSanctnService.updateInfrmlSanctnConfm("002", rwardManage);
		} else if (rwardManageVO.getConfmAt().equals("R")) {
			/*
			 * 반려처리
			 */
			infrmlSanctnVO = infrmlSanctnService.updateInfrmlSanctnReturn(converToInfrmlSanctnObject(rwardManageVO)); // 반려
			// infrmlSanctn = infrmlSanctnService.updateInfrmlSanctnReturn("002", rwardManage);
		}
		rwardManageVO.setSanctnDt(infrmlSanctnVO.getSanctnDt());
		rwardManageVO.setConfmAt(infrmlSanctnVO.getConfmAt());

		rwardManageMapper.updtRwardManageConfm(rwardManageVO);
	}

	/**
	 * RwardManage model을 InfrmlSanctn model로 변환한다.
	 * 
	 * @param rwardManageVO
	 */
	private InfrmlSanctnVO converToInfrmlSanctnObject(RwardManageVO rwardManageVO) {
		InfrmlSanctnVO infrmlSanctnVO = new InfrmlSanctnVO();
		infrmlSanctnVO.setJobSeCode("002"); // 업무구분코드 (공통코드 COM75)
		infrmlSanctnVO.setApplcntId(rwardManageVO.getRwardManId()); // 포상자ID
		infrmlSanctnVO.setReqstDe(rwardManageVO.getRwardDe()); // 포상일자
		infrmlSanctnVO.setSanctnerId(rwardManageVO.getSanctnerId()); // 결재자ID
		infrmlSanctnVO.setConfmAt(rwardManageVO.getConfmAt()); // 승인구분
		infrmlSanctnVO.setSanctnDt(rwardManageVO.getSanctnDt()); // 결재일시
		infrmlSanctnVO.setReturnResn(rwardManageVO.getReturnResn()); // 반려사유
		infrmlSanctnVO.setFrstRegisterId(rwardManageVO.getFrstRegisterId());
		infrmlSanctnVO.setFrstRegisterPnttm(rwardManageVO.getFrstRegisterPnttm());
		infrmlSanctnVO.setLastUpdusrId(rwardManageVO.getLastUpdusrId());
		infrmlSanctnVO.setLastUpdusrPnttm(rwardManageVO.getLastUpdusrPnttm());
		infrmlSanctnVO.setInfrmlSanctnId(rwardManageVO.getInfrmlSanctnId());// 약식결재ID
		return infrmlSanctnVO;
	}

}
