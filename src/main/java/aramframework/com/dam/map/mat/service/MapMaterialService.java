package aramframework.com.dam.map.mat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramframework.com.dam.map.mat.dao.MapMaterialMapper;
import aramframework.com.dam.map.mat.domain.MapMaterialVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 개요 - 지식맵(지식유형)에 대한 ServiceImpl 클래스를 정의한다.
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 */
@Service
public class MapMaterialService extends EgovAbstractServiceImpl {

	@Autowired
	private MapMaterialMapper mapMaterialMapper;

	/**
	 * 등록된 지식맵(지식유형) 정보를 조회 한다.
	 * 
	 * @param mapMaterialVO
	 */
	public List<EgovMap> selectMapMaterialList(MapMaterialVO mapMaterialVO) {
		return mapMaterialMapper.selectMapMaterialList(mapMaterialVO);
	}

	/**
	 * 지식맵(지식유형) 목록 총 갯수를 조회한다.
	 * 
	 * @param mapMaterialVO
	 */
	public int selectMapMaterialListCnt(MapMaterialVO mapMaterialVO) {
		return mapMaterialMapper.selectMapMaterialListCnt(mapMaterialVO);
	}

	/**
	 * 지식맵(지식유형)상세 정보를 조회 한다.
	 * 
	 * @param mapMaterialVO
	 */
	public MapMaterialVO selectMapMaterial(MapMaterialVO mapMaterialVO) {
		MapMaterialVO resultVo = mapMaterialMapper.selectMapMaterial(mapMaterialVO);
		// searchVO 이전 
		resultVo.setSearchVO(mapMaterialVO.getSearchVO()); 
		return resultVo;
	}

	/**
	 * 지식맵(지식유형) 정보를 신규로 등록한다.
	 * 
	 * @param mapMaterialVO
	 */
	public void insertMapMaterial(MapMaterialVO mapMaterialVO) {
		mapMaterialMapper.insertMapMaterial(mapMaterialVO);
	}

	/**
	 * 기 등록 된 지식맵(지식유형)링 정보를 수정 한다.
	 * 
	 * @param mapMaterialVO
	 */
	public void updateMapMaterial(MapMaterialVO mapMaterialVO) {
		mapMaterialMapper.updateMapMaterial(mapMaterialVO);
	}

	/**
	 * 기 등록된 지식맵(지식유형) 정보를 삭제한다.
	 * 
	 * @param mapMaterialVO
	 */
	public void deleteMapMaterial(MapMaterialVO mapMaterialVO) {
		mapMaterialMapper.deleteMapMaterial(mapMaterialVO);
	}

}