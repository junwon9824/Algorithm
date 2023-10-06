-- 코드를 입력하세요
SELECT   APNT_NO	, PT_NAME	, p.PT_NO,	ap.MCDP_CD	, DR_NAME	, APNT_YMD

from APPOINTMENT ap join DOCTOR d on ap.MDDR_ID =d.DR_ID join PATIENT p  on ap.PT_NO =p.PT_NO


where  ap.MCDP_CD='CS'
and APNT_CNCL_YN='N'
and date_format(ap.APNT_YMD,'%Y-%m-%d')='2022-04-13'

order by  ap.APNT_YMD asc