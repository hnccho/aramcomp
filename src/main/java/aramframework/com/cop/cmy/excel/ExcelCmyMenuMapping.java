package aramframework.com.cop.cmy.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import aramframework.com.cop.cmy.domain.CommunityMenuVO;

/**
 * Excel 매핑 클래스
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 */
public class ExcelCmyMenuMapping {

	public Object mappingColumn(Row row) {
		
		CommunityMenuVO vo = new CommunityMenuVO();

		String value = "";
		int cells = row.getPhysicalNumberOfCells();
		for (short c = 0; c < cells; c = (short)(c + 1)) {
			Cell cell = row.getCell(c);
			if (cell != null) {
				switch (cell.getCellType()) {
					case 0:
						value = String.valueOf(cell.getNumericCellValue());
						break;
					case 1:
						value = cell.getStringCellValue();
						break;
					case 2:
						value = cell.getCellFormula();
						break;
					case 3:
						value = null;
						break;
					case 4:
						value = String.valueOf(cell.getBooleanCellValue());
						break;
					case 5:
						value = String.valueOf(cell.getErrorCellValue());
					default:
						break;
				}
			}
			else {
				value = "";
			}

			switch (c) {
				case 0:		// MENU_NO(매뉴번호)
					vo.setMenuNo((int)Double.parseDouble(value));								
					break;
				case 1:		// MENU_NM(메뉴명)
					vo.setMenuNm(value);
					break;
				case 2:		// PROGRM_FILE_NM(프로그램명)
					vo.setProgrmFileNm(value);
					break;
				case 3:		// MENU_DC(메뉴설명)
					vo.setMenuDc(value);
					break;
				case 4:		// USE_AT(사용여부)
					vo.setUseAt(value);
					break;
				case 5:		// MGR_AT(관리자메뉴여부)
					vo.setMgrAt(value);
					break;
				case 6:		// DIRECT_URL(바로가기url)
					vo.setDirectUrl(value);
					break;
				case 7:		// TOPMENU_AT(톱메뉴여부)
					vo.setTopMenuAt(value);
					break;
				case 8:		// MENU_ALIAS(메뉴별명)
					vo.setMenuAlias(value);
					break;
			}
		}

		return vo;
	}
	
}
