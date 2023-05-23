-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, O.NAME
    from ANIMAL_INS I join ANIMAL_OUTS O on O.ANIMAL_ID = I.ANIMAL_ID
    where (I.SEX_UPON_INTAKE like 'Intact%' and O.SEX_UPON_OUTCOME like 'Neutered%')
        or (I.SEX_UPON_INTAKE like 'Intact%' and O.SEX_UPON_OUTCOME like 'Spayed%')
    