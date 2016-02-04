package aramframework.com.cmm.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import aramframework.com.cmm.domain.ComCodeVO;
import aramframework.com.cmm.domain.SearchCodeVO;

/**
 * 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 데이터 접근 클래스
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

@Mapper
public interface CmmUseMapper {

	/**
	 * 주어진 조건에 따른 공통코드를 불러온다.
	 * 
	 * @param searchCodeVO
	 */
	public List<ComCodeVO> selectCmmCodeList(SearchCodeVO searchCodeVO);

	/**
	 * 주어진 조건에 따른 공통코드를 불러온다.
	 * 
	 * @param searchCodeVO
	 */
	public ComCodeVO selectCmmCode(SearchCodeVO searchCodeVO);

	/**
	 * 공통코드로 사용할 조직정보를 를 불러온다.
	 * 
	 * @param searchCodeVO
	 */
	public List<ComCodeVO> selectOgrnztIdList(SearchCodeVO searchCodeVO);

}
