--Napisz zapytanie SQL, które zwróci wszystkie notatki użytkownika o imieniu i nazwisku: Jan Kowalski.

--1
SELECT note.*, details.name, details.surname FROM note
INNER JOIN user_details AS details
ON note.id_user = details.id_user
WHERE details.name LIKE 'Jan' AND details.surname LIKE 'Kowalski'

--2
SELECT * FROM note
WHERE note.id_user IN
(SELECT id_user FROM user_details WHERE name LIKE 'Jan' AND surname LIKE 'Kowalski')
