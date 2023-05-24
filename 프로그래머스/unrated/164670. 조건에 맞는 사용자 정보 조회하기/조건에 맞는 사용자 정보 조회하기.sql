-- 코드를 입력하세요
SELECT A.WRITER_ID, B.NICKNAME,
concat(B.city,' ',B.street_address1,' ',B.street_address2) AS 전체주소,
concat(LEFT(tlno,3), '-', MID(tlno,4,4),'-', RIGHT(tlno,4)) AS 전화번호
    FROM USED_GOODS_BOARD A join USED_GOODS_USER B on B.USER_ID = A.WRITER_ID
    group by A.WRITER_ID
    having count(A.WRITER_ID) >= 3
    order by A.WRITER_ID DESC;
    