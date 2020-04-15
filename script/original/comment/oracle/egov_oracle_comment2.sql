﻿COMMENT ON TABLE COMTECOPSEQ IS 'COMTECOPSEQ'; 
COMMENT ON COLUMN COMTECOPSEQ.TABLE_NAME IS '테이블명'; 
COMMENT ON COLUMN COMTECOPSEQ.NEXT_ID IS '다음아이디'; 


COMMENT ON TABLE COMTNFILE IS '파일속성'; 
COMMENT ON COLUMN COMTNFILE.ATCH_FILE_ID IS '첨부파일ID'; 
COMMENT ON COLUMN COMTNFILE.CREAT_DT IS '생성일시'; 
COMMENT ON COLUMN COMTNFILE.USE_AT IS '사용여부'; 


COMMENT ON TABLE COMTNFILEDETAIL IS '파일상세정보'; 
COMMENT ON COLUMN COMTNFILEDETAIL.ATCH_FILE_ID IS '첨부파일ID'; 
COMMENT ON COLUMN COMTNFILEDETAIL.FILE_SN IS '파일순번'; 
COMMENT ON COLUMN COMTNFILEDETAIL.FILE_STRE_COURS IS '파일저장경로'; 
COMMENT ON COLUMN COMTNFILEDETAIL.STRE_FILE_NM IS '저장파일명'; 
COMMENT ON COLUMN COMTNFILEDETAIL.ORIGNL_FILE_NM IS '원파일명'; 
COMMENT ON COLUMN COMTNFILEDETAIL.FILE_EXTSN IS '파일확장자'; 
COMMENT ON COLUMN COMTNFILEDETAIL.FILE_CN IS '파일내용'; 
COMMENT ON COLUMN COMTNFILEDETAIL.FILE_SIZE IS '파일크기'; 


COMMENT ON TABLE COMTNLOGINPOLICY IS '로그인정책'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.EMPLYR_ID IS '업무사용자ID'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.IP_INFO IS 'IP정보'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.DPLCT_PERM_AT IS '중복허용여부'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.LMTT_AT IS '제한여부'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.FRST_REGISTER_ID IS '최초등록자ID'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.FRST_REGIST_PNTTM IS '최초등록시점'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.LAST_UPDUSR_ID IS '최종수정자ID'; 
COMMENT ON COLUMN COMTNLOGINPOLICY.LAST_UPDT_PNTTM IS '최종수정시점'; 


COMMENT ON TABLE COMTNORGNZTINFO IS '조직정보'; 
COMMENT ON COLUMN COMTNORGNZTINFO.ORGNZT_ID IS '조직ID'; 
COMMENT ON COLUMN COMTNORGNZTINFO.ORGNZT_NM IS '조직명'; 
COMMENT ON COLUMN COMTNORGNZTINFO.ORGNZT_DC IS '조직설명'; 


COMMENT ON TABLE COMTNAUTHORGROUPINFO IS '권한그룹정보'; 
COMMENT ON COLUMN COMTNAUTHORGROUPINFO.GROUP_ID IS '그룹ID'; 
COMMENT ON COLUMN COMTNAUTHORGROUPINFO.GROUP_NM IS '그룹명'; 
COMMENT ON COLUMN COMTNAUTHORGROUPINFO.GROUP_CREAT_DE IS '그룹생성일'; 
COMMENT ON COLUMN COMTNAUTHORGROUPINFO.GROUP_DC IS '그룹설명'; 
 

COMMENT ON TABLE COMTNEMPLYRINFO IS '업무사용자정보'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.EMPLYR_ID IS '업무사용자ID'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.ORGNZT_ID IS '조직ID'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.USER_NM IS '사용자명'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.PASSWORD IS '비밀번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.EMPL_NO IS '사원번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.IHIDNUM IS '주민등록번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.SEXDSTN_CODE IS '성별코드'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.BRTHDY IS '생일'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.FXNUM IS '팩스번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.HOUSE_ADRES IS '주택주소'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.PASSWORD_HINT IS '비밀번호힌트'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.PASSWORD_CNSR IS '비밀번호정답'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.HOUSE_END_TELNO IS '주택끝전화번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.AREA_NO IS '지역번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.DETAIL_ADRES IS '상세주소'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.ZIP IS '우편번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.OFFM_TELNO IS '사무실전화번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.MBTLNUM IS '이동전화번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.EMAIL_ADRES IS '이메일주소'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.OFCPS_NM IS '직위명'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.HOUSE_MIDDLE_TELNO IS '주택중간전화번호'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.GROUP_ID IS '그룹ID'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.PSTINST_CODE IS '소속기관코드'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.EMPLYR_STTUS_CODE IS '사용자상태코드'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.ESNTL_ID IS '고유ID'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.CRTFC_DN_VALUE IS '인증DN값'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.SBSCRB_DE IS '가입일자'; 
COMMENT ON COLUMN COMTNEMPLYRINFO.LOCK_AT IS '잠금여부';
COMMENT ON COLUMN COMTNEMPLYRINFO.LOCK_CNT IS '잠금회수';
COMMENT ON COLUMN COMTNEMPLYRINFO.LOCK_LAST_PNTTM IS '잠금최종시점';


COMMENT ON TABLE COMTHEMPLYRINFOCHANGEDTLS IS '업무사용자정보변경내역'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.EMPLYR_ID IS '업무사용자ID'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.CHANGE_DE IS '변경일'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.ORGNZT_ID IS '조직ID'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.GROUP_ID IS '그룹ID'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.EMPL_NO IS '사원번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.SEXDSTN_CODE IS '성별코드'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.BRTHDY IS '생일'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.FXNUM IS '팩스번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.HOUSE_ADRES IS '주택주소'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.HOUSE_END_TELNO IS '주택끝전화번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.AREA_NO IS '지역번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.DETAIL_ADRES IS '상세주소'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.ZIP IS '우편번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.OFFM_TELNO IS '사무실전화번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.MBTLNUM IS '이동전화번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.EMAIL_ADRES IS '이메일주소'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.HOUSE_MIDDLE_TELNO IS '주택중간전화번호'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.PSTINST_CODE IS '소속기관코드'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.EMPLYR_STTUS_CODE IS '사용자상태코드'; 
COMMENT ON COLUMN COMTHEMPLYRINFOCHANGEDTLS.ESNTL_ID IS '고유ID'; 


COMMENT ON TABLE COMTNENTRPRSMBER IS '기업회원'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MBER_ID IS '기업회원ID'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_SE_CODE IS '기업구분코드'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.BIZRNO IS '사업자등록번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.JURIRNO IS '법인등록번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.CMPNY_NM IS '회사명'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.CXFC IS '대표이사'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ZIP IS '우편번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ADRES IS '주소'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MIDDLE_TELNO IS '기업중간전화번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.FXNUM IS '팩스번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.INDUTY_CODE IS '업종코드'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.APPLCNT_NM IS '신청인명'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.APPLCNT_IHIDNUM IS '신청인주민등록번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.SBSCRB_DE IS '가입일자'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MBER_STTUS IS '기업회원상태'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MBER_PASSWORD IS '기업회원비밀번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MBER_PASSWORD_HINT IS '기업회원비밀번호힌트'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_MBER_PASSWORD_CNSR IS '기업회원비밀번호정답'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.GROUP_ID IS '그룹ID'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.DETAIL_ADRES IS '상세주소'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ENTRPRS_END_TELNO IS '기업끝전화번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.AREA_NO IS '지역번호'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.APPLCNT_EMAIL_ADRES IS '신청자이메일주소'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.ESNTL_ID IS '고유ID'; 
COMMENT ON COLUMN COMTNENTRPRSMBER.LOCK_AT IS '잠금여부';
COMMENT ON COLUMN COMTNENTRPRSMBER.LOCK_CNT IS '잠금회수';
COMMENT ON COLUMN COMTNENTRPRSMBER.LOCK_LAST_PNTTM IS '잠금최종시점';


COMMENT ON TABLE COMTNGNRLMBER IS '일반회원'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBER_ID IS '회원ID'; 
COMMENT ON COLUMN COMTNGNRLMBER.PASSWORD IS '비밀번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.PASSWORD_HINT IS '비밀번호힌트'; 
COMMENT ON COLUMN COMTNGNRLMBER.PASSWORD_CNSR IS '비밀번호정답'; 
COMMENT ON COLUMN COMTNGNRLMBER.IHIDNUM IS '주민등록번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBER_NM IS '회원명'; 
COMMENT ON COLUMN COMTNGNRLMBER.ZIP IS '우편번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.ADRES IS '주소'; 
COMMENT ON COLUMN COMTNGNRLMBER.AREA_NO IS '지역번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBER_STTUS IS '회원상태'; 
COMMENT ON COLUMN COMTNGNRLMBER.DETAIL_ADRES IS '상세주소'; 
COMMENT ON COLUMN COMTNGNRLMBER.END_TELNO IS '끝전화번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBTLNUM IS '이동전화번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.GROUP_ID IS '그룹ID'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBER_FXNUM IS '회원팩스번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.MBER_EMAIL_ADRES IS '회원이메일주소'; 
COMMENT ON COLUMN COMTNGNRLMBER.MIDDLE_TELNO IS '중간전화번호'; 
COMMENT ON COLUMN COMTNGNRLMBER.SBSCRB_DE IS '가입일자'; 
COMMENT ON COLUMN COMTNGNRLMBER.SEXDSTN_CODE IS '성별코드'; 
COMMENT ON COLUMN COMTNGNRLMBER.ESNTL_ID IS '고유ID'; 
COMMENT ON COLUMN COMTNGNRLMBER.LOCK_AT IS '잠금여부';
COMMENT ON COLUMN COMTNGNRLMBER.LOCK_CNT IS '잠금회수';
COMMENT ON COLUMN COMTNGNRLMBER.LOCK_LAST_PNTTM IS '잠금최종시점';



