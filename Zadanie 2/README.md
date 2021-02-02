Załóżmy, że w bazie danych SQL znajduje się tablica zawierająca pomiary temperatury "w słońcu", a jej nazwa to temp. 
Pomiary wykonywane są co 60 sekund. Termometr jednak wyłącza się na noc i włącza dopiero gdy wzejdzie słońce. 
W bazie danych nie ma informacji o godzinach wschodu i zachodu słońca. 
Jeżeli słońce jest pod horyzontem do tabeli temp w kolumnie measurement trafiają wartości null, 
jeżeli zaś jest nad horyzontem pojawiają się wartości numeryczne. 
 
Struktura tabeli (fragment przykładowych danych dla wschodu słońca):

+------------+-----------------+---------------------+
| id(AI, PK) | time(timestamp) | measurement(double) |
+------------+-----------------+---------------------+
|          1 |      1612160100 | null                |
|          2 |      1612160160 | null                |
|          3 |      1612160220 | -4.54               |
|          4 |      1612160280 | -4.34               |
|          5 |      1612160340 | -4.29               |
+------------+-----------------+---------------------+

1) Przygotuj CREATE tabeli 'temp'.
2) Przygotuj inserty danych testowych dla 3 dni z rozdzielczościa 60 sekundową. 
3) Przygotuj jedno zapytanie SQL, które zwróci czasy wschodów i zachodów słońca dla każdego dnia, dla danych zgromadzonych w bazie.

* - Możesz użyć dowolnej bazy SQL

4) Czy baza relacyjna to najlepsze rozwiązanie do gromadzenia tego typu danych?

5) Dane zostały pobrane z bazy za pomocą zapytania 'select * from temp'. Napisz kod (Kotlin lub Java), który zwróci dane w takiej samej postaci jak zapytanie SQL z pkt. 3).
	- dane znajdują się w strukturze List<Temp>, klasa Temp odzwierciedla tabele temp
	- możesz przygotować dane testowe w kodzie, nie muszą zawierać 3 dni
	- preferowane jest rozwiązanie bez użycia pętli 
	- jeżeli chcesz pobrać dane z wcześniej przygotowanej bazy, możesz użyć dowolnych frameworków oprócz JPA/Hibernate