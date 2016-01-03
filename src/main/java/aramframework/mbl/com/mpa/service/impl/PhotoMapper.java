package aramframework.mbl.com.mpa.service.impl;

import java.util.List;

import aramframework.mbl.com.mpa.service.PhotoVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 개요
 * - 사진에 대한 DB상의 접근, 변경을 처리한다.
 * 
 * 상세내용
 * - 사진에 대한 등록, 수정, 삭제, 조회 기능을 제공한다.
 * - 사진에 대한 조회기능은 목록, 상세조회로 구분된다.
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

@Mapper("photoMapper")
public interface PhotoMapper {

    /**
     * 사진 목록 DB 조회 메서드
     * 
     * @param photoVO
     */
    public List<EgovMap> selectPhotoList(PhotoVO photoVO);
 
    /**
     * 사진 정보의 총 갯수를 조회한다.
     * 
     * @param photoVO
     */
    public int selectPhotoListCnt(PhotoVO photoVO);
 
    /**
     * 사진 정보 상세 DB 조회 메서드
     * 
     * @param photoVO
     */
    public PhotoVO selectPhoto(PhotoVO photoVO);
 
    /**
     * 사진 정보 DB 등록 메서드
     * 
     * @param photoVO
     */
    public void insertPhoto(PhotoVO photoVO);

    /**
     * 사진 정보 DB 삭제 메서드
     * 
     * @param photoVO
     */
    public void deletePhoto(PhotoVO photoVO);
 
    /**
     * 사진 정보 DB 수정 메서드
     * 
     * @param photoVO
     */
    public void updatePhoto(PhotoVO photoVO);

}
