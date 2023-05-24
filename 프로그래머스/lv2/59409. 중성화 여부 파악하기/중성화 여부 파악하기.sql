-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, 
    CASE WHEN SUBSTRING_INDEX(SEX_UPON_INTAKE, " ", 1) in ('Neutered', 'Spayed')    THEN 'O' 
    ELSE 'X'
    END '중성화'
    from ANIMAL_INS
    group by ANIMAL_ID
    order by ANIMAL_ID