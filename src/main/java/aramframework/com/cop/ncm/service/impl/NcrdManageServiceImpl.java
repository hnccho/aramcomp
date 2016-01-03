package aramframework.com.cop.ncm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aramframework.com.cmm.util.BeanUtil;
import aramframework.com.cop.ncm.service.NcrdManageService;
import aramframework.com.cop.ncm.service.NameCardUseVO;
import aramframework.com.cop.ncm.service.NameCardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 명함정보를 관리하기 위한 서비스 구현 클래스
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

@Service("ncrdManageService")
public class NcrdManageServiceImpl extends EgovAbstractServiceImpl implements NcrdManageService {

	@Resource(name = "ncrdManageMapper")
	private NcrdManageMapper ncrdManageMapper;	

	@Resource(name = "ncrdIdGnrService")
	private EgovIdGnrService idgenService;

	/**
	 * 내가 소유한 명함 정보에 대한 목록을 조회한다.
	 * 
	 * @param nameCardVO
	 */
	public List<EgovMap> selectNcrdListMine(NameCardVO nameCardVO) {
		return ncrdManageMapper.selectNcrdListMine(nameCardVO);
	}

	/**
	 * 내가 소유한 명함 정보에 대한 목록의 총갯수를 조회한다.
	 * 
	 * @param nameCardVO
	 */
	public int selectNcrdListMineCnt(NameCardVO nameCardVO) {
		return ncrdManageMapper.selectNcrdListMineCnt(nameCardVO);
	}

	/**
	 * 명함 정보에 대한 상세정보를 조회한다.
	 * 
	 * @param nameCardVO
	 */
	public NameCardVO selectNcrdItem(NameCardVO nameCardVO) {
		NameCardVO resultVo = ncrdManageMapper.selectNcrdItem(nameCardVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, nameCardVO); 
		return resultVo;
	}

	/**
	 * 명함 정보 및 명함사용자 정보를 등록한다.
	 * 
	 * @param nameCardVO
	 */
	public void insertNcrdItem(NameCardVO nameCardVO) {

		try {
			nameCardVO.setNcrdId(idgenService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}

		nameCardVO.setTelNo(nameCardVO.getNationNo() + "-" + nameCardVO.getAreaNo() + "-" + nameCardVO.getMiddleTelNo() + "-" + nameCardVO.getEndTelNo());
		nameCardVO.setMbtlNum(nameCardVO.getIdntfcNo() + "-" + nameCardVO.getMiddleMbtlNum() + "-" + nameCardVO.getEndMbtlNum());
		ncrdManageMapper.insertNcrdItem(nameCardVO);

		NameCardUseVO nameCardUserVO = new NameCardUseVO();
		nameCardUserVO.setNcrdId(nameCardVO.getNcrdId());
		nameCardUserVO.setEmplyrId(nameCardVO.getFrstRegisterId());
		nameCardUserVO.setRegistSeCode("REGC04");
		nameCardUserVO.setUseAt("Y");

		ncrdManageMapper.insertNcrdUseInf(nameCardUserVO);
	}

	/**
	 * 명함 정보를 수정한다.
	 * 
	 * @param nameCardVO
	 */
	public void updateNcrdItem(NameCardVO nameCardVO) {
		nameCardVO.setTelNo(nameCardVO.getNationNo() + "-" + nameCardVO.getAreaNo() + "-" + nameCardVO.getMiddleTelNo() + "-" + nameCardVO.getEndTelNo());
		nameCardVO.setMbtlNum(nameCardVO.getIdntfcNo() + "-" + nameCardVO.getMiddleMbtlNum() + "-" + nameCardVO.getEndMbtlNum());
		ncrdManageMapper.updateNcrdItem(nameCardVO);
	}

	/**
	 * 명함 정보를 삭제한다.
	 * 
	 * @param nameCardVO
	 */
	public void deleteNcrdItem(NameCardVO nameCardVO) {
		NameCardUseVO nameCardUserVO = new NameCardUseVO();
		nameCardUserVO.setNcrdId(nameCardVO.getNcrdId());
		nameCardUserVO.setEmplyrId(nameCardVO.getLastUpdusrId());

		ncrdManageMapper.deleteNcrdUseInf(nameCardUserVO);
		ncrdManageMapper.deleteNcrdItem(nameCardVO);
	}

	/**
	 * 공개 명함 정보에 대한 목록을 조회한다.
	 * 
	 * @param nameCardVO
	 */
	public List<EgovMap> selectNcrdListPublic(NameCardVO nameCardVO) {
		return ncrdManageMapper.selectNcrdListPublic(nameCardVO);
	}

	/**
	 * 공개 명함 정보에 대한 목록의 총갯수를 조회한다.
	 * 
	 * @param nameCardVO
	 */
	public int selectNcrdListPublicCnt(NameCardVO nameCardVO) {
		return ncrdManageMapper.selectNcrdListPublicCnt(nameCardVO);
	}
	
	/**
	 * 명함사용자 정보를 등록한다.
	 * 
	 * @param nameCardUseVO
	 */
	public void insertNcrdUseInf(NameCardUseVO nameCardUseVO) {
		nameCardUseVO.setRegistSeCode("REGC04");
		ncrdManageMapper.insertNcrdUseInf(nameCardUseVO);
	}

	/**
	 * 명함사용자 정보를 수정한다.
	 * 
	 * @param nameCardUseVO
	 */
	public void updateNcrdUseInf(NameCardUseVO nameCardUseVO) {
		ncrdManageMapper.updateNcrdUseInf(nameCardUseVO);
	}

	/**
	 * 명함사용자 정보를 삭제한다.
	 * 
	 * @param nameCardUseVO
	 */
	public void deleteNcrdUseInf(NameCardUseVO nameCardUseVO) {
		ncrdManageMapper.deleteNcrdUseInf(nameCardUseVO);
	}

}
