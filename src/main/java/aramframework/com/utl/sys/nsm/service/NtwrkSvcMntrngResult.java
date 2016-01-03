package aramframework.com.utl.sys.nsm.service;

/**
 * 개요 - 네트워크서비스 모니터링에 대한 결과 클래스를 정의한다.
 * 
 * 상세내용 - 모니터링 정상여부, 원인 Exception 항목을 관리한다.
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

public class NtwrkSvcMntrngResult {

	/**
	 * 모니터링 정상여부
	 */
	private boolean nrmltAt;
	/**
	 * 원인 Exception
	 */
	private Throwable cause;

	public boolean isNrmltAt() {
		return nrmltAt;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setNrmltAt(boolean nrmltAt) {
		this.nrmltAt = nrmltAt;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public NtwrkSvcMntrngResult(boolean nrmltAt, Throwable cause) {
		this.nrmltAt = nrmltAt;
		this.cause = cause;
	}

}