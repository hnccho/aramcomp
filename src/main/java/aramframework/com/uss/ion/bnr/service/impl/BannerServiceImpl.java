package aramframework.com.uss.ion.bnr.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.cmm.service.FileVO;
import aramframework.com.cmm.util.BeanUtil;
import aramframework.com.uss.ion.bnr.service.BannerVO;
import aramframework.com.uss.ion.bnr.service.BannerService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 개요
 * - 배너에 대한 ServiceImpl 클래스를 정의한다.
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
public class BannerServiceImpl extends EgovAbstractServiceImpl implements BannerService {

	@Autowired
	private BannerMapper bannerMapper;
	
	/** Message ID Generation */
	@Autowired
	private EgovIdGnrService bannerIdGnrService;

	/**
	 * 배너를 관리하기 위해 등록된 배너목록을 조회한다.
	 * 
	 * @param bannerVO
	 */
	public List<EgovMap> selectBannerList(BannerVO bannerVO) {
		return bannerMapper.selectBannerList(bannerVO);
	}

	/**
	 * 배너목록 총 갯수를 조회한다.
	 * 
	 * @param bannerVO
	 */
	public int selectBannerListCnt(BannerVO bannerVO) {
		return bannerMapper.selectBannerListCnt(bannerVO);
	}

	/**
	 * 등록된 배너의 상세정보를 조회한다.
	 * 
	 * @param bannerVO
	 */
	public BannerVO selectBanner(BannerVO bannerVO) {
		BannerVO resultVo = bannerMapper.selectBanner(bannerVO);
		// deep copy
		BeanUtil.copyPropertiesCore(resultVo, bannerVO); 
		return resultVo;
	}

	/**
	 * 배너정보를 신규로 등록한다.
	 * 
	 * @param bannerVO
	 */
	public void insertBanner(BannerVO bannerVO) {
		try {
			bannerVO.setBannerId(bannerIdGnrService.getNextStringId());
		} catch (FdlException e) {
			throw new RuntimeException(e);
		}
		bannerMapper.insertBanner(bannerVO);
	}

	/**
	 * 기 등록된 배너정보를 수정한다.
	 * 
	 * @param bannerVO
	 */
	public void updateBanner(BannerVO bannerVO) {
		bannerMapper.updateBanner(bannerVO);
	}

	/**
	 * 기 등록된 배너정보를 삭제한다.
	 * 
	 * @param bannerVO
	 */
	public void deleteBanner(BannerVO bannerVO) {
		deleteBannerFile(bannerVO);
		bannerMapper.deleteBanner(bannerVO);
	}

	/**
	 * 기 등록된 배너정보의 이미지파일을 삭제한다.
	 * 
	 * @param bannerVO
	 */
	public void deleteBannerFile(BannerVO bannerVO) {
		FileVO fileVO = (FileVO) bannerMapper.selectBannerFile(bannerVO);
		File file = new File(fileVO.getFileStreCours() + fileVO.getStreFileNm());
		file.delete();
	}

	/**
	 * 배너가 특정화면에 반영된 결과를 조회한다.
	 * 
	 * @param bannerVO
	 */
	public List<EgovMap> selectBannerResult(BannerVO bannerVO) {
		return bannerMapper.selectBannerResult(bannerVO);
	}

}