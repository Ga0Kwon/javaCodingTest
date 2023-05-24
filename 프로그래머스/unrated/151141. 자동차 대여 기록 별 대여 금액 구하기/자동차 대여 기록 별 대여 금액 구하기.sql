SELECT HISTORY_ID,
    round(DAILY_FEE * (DATEDIFF(H.END_DATE,H.START_DATE)+1)
    * (1 - P.DISCOUNT_RATE/ 100)) FEE
    from CAR_RENTAL_COMPANY_CAR as C
        join CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
        on C.CAR_ID = H.CAR_ID
        join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as P
        on C.CAR_TYPE = P.CAR_TYPE
WHERE C.car_type = "트럭"
GROUP BY HISTORY_ID
ORDER BY FEE DESC , HISTORY_ID DESC