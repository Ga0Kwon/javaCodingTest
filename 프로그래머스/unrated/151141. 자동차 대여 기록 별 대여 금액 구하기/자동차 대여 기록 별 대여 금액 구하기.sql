SELECT H.HISTORY_ID,
    round(DAILY_FEE * (DATEDIFF(H.END_DATE,H.START_DATE)+1) * 
          (1 - (
          CASE WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 90 
                THEN (SELECT DISCOUNT_RATE 
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                     WHERE C.CAR_TYPE = SP.CAR_TYPE and DURATION_TYPE = '90일 이상')/100
               WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 30 
                THEN (SELECT DISCOUNT_RATE 
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                     WHERE C.CAR_TYPE = SP.CAR_TYPE and DURATION_TYPE = '30일 이상')/100
               WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1 >= 7 
                THEN (SELECT DISCOUNT_RATE 
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN SP
                     WHERE C.CAR_TYPE = SP.CAR_TYPE and  DURATION_TYPE = '7일 이상')/100
               ELSE 0
               END ))) FEE
    from CAR_RENTAL_COMPANY_CAR as C
        join CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
            on C.CAR_ID = H.CAR_ID
WHERE C.car_type = "트럭"
GROUP BY H.HISTORY_ID
ORDER BY FEE DESC , H.HISTORY_ID DESC
