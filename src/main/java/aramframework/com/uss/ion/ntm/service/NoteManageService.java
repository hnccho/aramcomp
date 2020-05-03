package aramframework.com.uss.ion.ntm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.cmm.domain.BaseVO;
import aramframework.com.uss.ion.ntm.dao.NoteManageMapper;
import aramframework.com.uss.ion.ntm.domain.NoteManageVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 쪽지 관리(보내기)를 처리하는 ServiceImpl Class 구현
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 */
@Service
public class NoteManageService extends EgovAbstractServiceImpl {

	@Autowired
	private NoteManageMapper noteManageMapper;
	
	/* 쪽지관리 ID Generator Service */
	@Autowired
	private EgovIdGnrService noteManageIdGnrService; 

	/* 보낸쪽지함관리 ID Generator Service */
	@Autowired
	private EgovIdGnrService noteTrnsmitIdGnrService; 

	/* 받은쪽지함관리 ID Generator Service */
	@Autowired
	private EgovIdGnrService noteRecptnIdGnrService; 

	/**
	 * 쪽지관리 정보를 조회한다.
	 * 
	 * @param noteManageVO
	 */
	public EgovMap selectNoteManage(NoteManageVO noteManageVO) {
		return noteManageMapper.selectNoteManage(noteManageVO);
	}

	/**
	 * 쪽지 관리(보내기)를(을) 등록한다.
	 * 
	 * @param noteManageVO
	 * @param commandMap
	 */
	public void insertNoteManage(NoteManageVO noteManageVO, String sRecptnEmpList, String sRecptnSeList) {

		/* ****************************************************************
		 * 쪽지관리 처리
		 * ***************************************************************
		 */
		// 쪽지 ID설정
		try {
			noteManageVO.setNoteId(noteManageIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		// 쪽지 등록
		noteManageMapper.insertNoteManage(noteManageVO);

		/* ****************************************************************
		 * 보낸쪽지 처리
		 * ***************************************************************
		 */
		// 보낸쪽지함 ID설정
		try {
			noteManageVO.setNoteTrnsmitId(noteTrnsmitIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		// 발신자 아이디설정
		noteManageVO.setTrnsmiterId(noteManageVO.getFrstRegisterId());

		// 보낸쪽지등록
		noteManageMapper.insertNoteTrnsmit(noteManageVO);

		// 수신자 리스트
		String[] sRecptnEmpListResult = sRecptnEmpList.split(",");

		// 수신자구분 리스트
		String[] sRecptnSeListResult = sRecptnSeList.split(",");

		/* ****************************************************************
		 * 받은쪽지함 처리
		 * ***************************************************************
		 */
		for (int i = 0; i < sRecptnEmpListResult.length; i++) {

			// 받은쪽지함 ID설정
			try {
				noteManageVO.setNoteRecptnId(noteRecptnIdGnrService.getNextStringId());
			} catch (FdlException e) {
				throw new RuntimeException(e);
			}
			// 받은쪽지함 수신여부 설정
			noteManageVO.setOpenYn("N");
			// 받은쪽지함 수신자 설정
			noteManageVO.setRcverId(sRecptnEmpListResult[i]);
			// 받은쪽지함 수신 구분설정
			noteManageVO.setRecptnSe(sRecptnSeListResult[i]);
			// 받은쪽지함 등록
			noteManageMapper.insertNoteRecptn(noteManageVO);
		}

	}

	/**
	 * 수신자/참조자선택팝업 목록을 조회한다.
	 * 
	 * @param searchVO
	 */
	public List<EgovMap> selectNoteEmpList(BaseVO baseVO) {
		return noteManageMapper.selectNoteEmpList(baseVO);
	}

	/**
	 * 수신자/참조자선택팝업 갯수를 조회한다.
	 * 
	 * @param searchVO
	 */
	public int selectNoteEmpListCnt(BaseVO baseVO) {
		return (Integer) noteManageMapper.selectNoteEmpListCnt(baseVO);
	}
	
}
