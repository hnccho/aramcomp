package aramframework.com.cmm.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import aramframework.com.cmm.constant.CacheKey;
import aramframework.com.cmm.domain.HanjaDicVO;
import aramframework.com.cmm.domain.ImageVO;
import aramframework.com.cmm.excel.ExcelHanjaDicMapping;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * 커뮤니티 정보를 관리하기 위한 서비스 구현 클래스
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 */
@Service
public class OcrHanjaService extends EgovAbstractServiceImpl {

	@Resource(name = "cacheDictionary")
	private Map<String, Object> cacheDictionary;

	/**
	 * 캐쉬로부터 이미지 정보 를 가져온다.
	 * 
	 * @param imageId
	 */
	@SuppressWarnings("unchecked")
	public ImageVO getImageInfo(String imageId) {

		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.OCR_IMG_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.OCR_IMG_CACHE, cacheMap);
        }
        
        ImageVO imageVO = (ImageVO) cacheMap.get(imageId);

		return imageVO;
	}

	@SuppressWarnings("unchecked")
	public ImageVO setImageInfo(String imageId, ImageVO imageVO) {
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.OCR_IMG_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.OCR_IMG_CACHE, cacheMap);
        }
        
       	cacheMap.put(imageId, imageVO);

       	return imageVO;
	}


	/**
	 * 캐쉬로부터 텍스트 정보 를 가져온다.
	 * 
	 * @param imageId
	 */
	@SuppressWarnings("unchecked")
	public String getHanjaText(String imageId) {
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.OCR_TXT_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.OCR_TXT_CACHE, cacheMap);
        }
        
        String hanjaText = (String) cacheMap.get(imageId);

		return hanjaText;
	}

	@SuppressWarnings("unchecked")
	public String setHanjaText(String imageId, String hanjaText) {
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.OCR_TXT_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.OCR_TXT_CACHE, cacheMap);
        }
        
       	cacheMap.put(imageId, hanjaText);

       	return hanjaText;
	}

	/**
	 * 캐쉬로부터 HanjaDicList 정보 를 가져온다.
	 * 
	 * @param cmmntyId
	 */
	@SuppressWarnings("unchecked")
	public String getHanjaDicList() {
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.HANJA_DIC_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.HANJA_DIC_CACHE, cacheMap);
        }
        
        String hanjaDicList = (String) cacheMap.get("hanjaDicList");

		return hanjaDicList;
	}

	/**
	 * 캐쉬로부터 HanjaDicMap 정보 를 가져온다.
	 * 
	 * @param cmmntyId
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getHanjaDicMap() {
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.HANJA_DIC_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.HANJA_DIC_CACHE, cacheMap);
        }
        
        HashMap<String, String> hanjaDicMap = (HashMap<String, String>) cacheMap.get("hanjaDicMap");

		return hanjaDicMap;
	}

	/**
	 * 메뉴 엑셀파일을 등록 또는 수정한다.
	 * 
	 * @param file
	 * @param cmmntyId
	 */
	public void setHanjaDic(InputStream fis) throws Exception {

		ExcelHanjaDicMapping mapping = new ExcelHanjaDicMapping();

		StringBuffer hanjaDicList = new StringBuffer();
		HashMap<String, String> hanjaDicMap = new HashMap<String,String>();
		
		Workbook workbook = new XSSFWorkbook(fis);
		int sheetNum = workbook.getNumberOfSheets();
		for (int k = 0; k < sheetNum; k++) {
			Sheet sheet = workbook.getSheetAt(k);
			int rows = sheet.getPhysicalNumberOfRows();
			if( rows == 0 ) continue;
			
			mapping.setCells(sheet.getRow(0));	// cells 수 설정
			for (int r = 1; r < rows; r++) {
    			Row row = sheet.getRow(r);
    			if (row != null) {
     				HanjaDicVO vo = (HanjaDicVO)mapping.mappingColumn(row);
     				hanjaDicList.append(vo.getHanja());
     				hanjaDicMap.put(vo.getHanja(), vo.getHanjaDic());
    			}
			}
		}
		
		HashMap<String, Object> cacheMap = null;
		cacheMap = (HashMap<String, Object>) cacheDictionary.get(CacheKey.HANJA_DIC_CACHE);
        if( cacheMap == null ) {
        	cacheMap = new HashMap<String, Object>();
        	cacheDictionary.put(CacheKey.HANJA_DIC_CACHE, cacheMap);
        }
        
       	cacheMap.put("hanjaDicList", hanjaDicList.toString());
       	cacheMap.put("hanjaDicMap", hanjaDicMap);
	}

}
