package aramframework.com.sec.grp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aramframework.com.sec.grp.service.GroupAuthorService;
import aramframework.com.sec.grp.service.GroupAuthorVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 권한그룹에 관한 ServiceImpl 클래스를 정의한다.
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

@Service("groupAuthorService")
public class GroupAuthorServiceImpl extends EgovAbstractServiceImpl implements GroupAuthorService {

	@Resource(name = "groupAuthorMapper")
	private GroupAuthorMapper groupAuthorMapper;

	/**
	 * 그룹별 할당된 권한 목록 조회
	 * 
	 * @param groupAuthorVO
	 */
	public List<EgovMap> selectGroupAuthorList(GroupAuthorVO groupAuthorVO) {
		return groupAuthorMapper.selectGroupAuthorList(groupAuthorVO);
	}

	/**
	 * 목록조회 카운트를 반환한다
	 * 
	 * @param groupAuthorVO
	 */
	public int selectGroupAuthorListCnt(GroupAuthorVO groupAuthorVO) {
		return groupAuthorMapper.selectGroupAuthorListCnt(groupAuthorVO);
	}

	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * 
	 * @param groupAuthorVO
	 */
	public void insertGroupAuthor(GroupAuthorVO groupAuthorVO) {
		groupAuthorMapper.insertGroupAuthor(groupAuthorVO);
	}

	/**
	 * 화면에 조회된 그룹권한정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * 
	 * @param groupAuthorVO
	 */
	public void updateGroupAuthor(GroupAuthorVO groupAuthorVO) {
		groupAuthorMapper.updateGroupAuthor(groupAuthorVO);
	}

	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * 
	 * @param groupAuthorVO
	 */
	public void deleteGroupAuthor(GroupAuthorVO groupAuthorVO) {
		groupAuthorMapper.deleteGroupAuthor(groupAuthorVO);
	}

}