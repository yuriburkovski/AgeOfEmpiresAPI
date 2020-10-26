# AgeOfEmpiresAPI #
Age Of Empires II API (AOEA)

Cel projektu:

Celem zadania jest zaprojektowanie i implementacja Age of Empires II API (https://age-of-empires-2-api.herokuapp.com/docs/), 
wykorzystującego serwis pośredni w celu zwrócenia możliwie dokładnych na temat gry age of empires.

1. Zadania przygotowawcze:

  Zadanie nr 1. 
Jako programista chciałbym mieć stworzony projekt (AgeOfEmpiresApi) oparty na Spring Boot. Projekt powinien składać się z następujących zależności
Web
Kod źródłowy powinien znajdować się na wybranym przez siebie repozytorium.
Projekt powinien dać budować się za pomocą narzędzia Maven

  Zadanie nr 2.
Jako programista chciałbym mieć opracowaną struktur rozwoju projektu, nazwy i rozłożenie pakietów. 
Ponadto należy opracować strategię pracy w gicie oraz schemat nazewnictwo commitów.

  Nazewnictwo branchy:
Gałąź na nowe funkcjonalności: feature/AOEA-ticket_number, gdzie ticket number jest to numer zadania obecnie wykonywanego,np. feature/AOEA-2.4
Gałąź na błędy wykryte po skończeniu wykonywania zadania: fix/AOEA-ticket_number, gdzie ticket_number jest to numer zadania którego dotyczy odkryty błąd,np. fix/AOEA-3.6
Nazewnictwo commitów:
Struktura: git commit -m “prefix(aoea): ticket short description”
Prefix: 
feature - dodanie nowej funkcjonalności w ramach zadania
fix - usunięcie błędu w ramach dodawanej funkcjonalności
change - modyfikacja fragmentu dodawanej funkcjonalności
delete - usunięcie fragmentu dodawanej funkcjonalności
test -  dodawanie testów jednostkowych w ramach funkcjonalności
Krótki opis: krótki opis commitu, max do 100 znaków
Np. git commit -m “fix(aoea): npe on CivilizationController”
Schematy pracy z gitem:

Gałęzią domyślna dla codziennej pracy będzie gałąź develop. Każde nowe zadanie ma być realizowane w ramach tzw. Feature branch. Po zakończeniu implementacji każdy feature branch powinien być domergowany z powrotem do gałęzi develop. Po wykonaniu każdej sekcji zadań: location, weather, external weather api, tworzony będzie tzw. Release branch na którym inkrementowana będzie wersja aplikacji. Następnie Release branch będzie domergowywany z powrotem do gałęzi develop oraz gałęzi master która następnie będzie tagowania (https://git-scm.com/book/en/v2/Git-Basics-Tagging)

Przykład. Programista ma za zadanie dodać implementację dla zadania 2.2. W gałęzi develop znajduje się najbardziej aktualna wersja kodu źródłowego. Programista powinien stworzyć nową gałąź i dokonać wymaganych zmian, a następnie po pozytywnym review kodu powinien scalić swój branch z gałęzią develop.
git checkout -b feature/AOEA-2.2 -> tworzymy nową gałąź na nową funkcjonalność odchodząc od gałęzi develop
Programista implementuje wymaganą funkcjonalność
git add . -> dodajemy wszystkie zmiany do indexu
git commit -m “feature(aoea): implement feature” -> commitujemy wprowadzone zmiany
git push --set-upstream origin feature/AOEA-2.2 -> wysyłamy zmiany na gałąź zdalną tak by były widoczne na serwerze. W przypadku gdy gałąź zdalna już istnieje wystarczy wykonać polecenie git push
git checkout develop -> przechodzimy na gałąź develop w celu zintegrowania zmian z gałęzi feature/AOEA-2.2
git merge feature/AOEA-2.2 -> scalamy zmiany z feature brancha do gałęzi develop
git push -> wysyłamy zmiany lokalne gałęzi develop na gałąź zdalną origin/develop


  Zadanie nr 3.
Jako użytkownik chciałbym mieć możliwość pobierania informacji o wszystkich cywilizacjach na start działania serwera wykorzystując API: https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations
Celem zadania jest pobranie wszystkich cywilizacji (ich nazw i adresów url) z uwzględnieniem paginacji. Pobrane informację powinno zostać zapisane w bazie danych. 

  Elementy niezbędne:
Encja Civilization: id, name, url (połączenia adresu https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/ + id cywilizacji)
CivilizationRepsitory: do zapisu pobranych cywilizacji do bazy danych
Warstwa modelowa dla AgeOfEmpiresRepository - reprezentująca odpowiedź zwróconą z sieci
AgeOfEmpiresRepository: do pobierania danych z api (z wykorzystaniem RestTemplate)(https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations)
CivilizationLoaderService: do pobierania danych z api oraz zapisu ich do lokanej bazy danych

  Zadanie nr 4.
Jako użytkownik chciałbym mieć możliwość cyklicznej aktualizacji danych pobieranych w ramach zadania 3. 
Oprócz startowego pobierania wartości dane powinny być pobierane raz na 60 min.

  Zadanie nr 5.
Jako użytkownik chciałbym mieć możliwość pobierania danych szczegółowych na temat wybranej cywilizacji po jej nazwie. Żądanie powinno działać jak poniżej:
Wysłanie żądania na serwer
Pobranie nazwy cywilizacji
Weryfikacja czy cywilizacja o danej nazwie znajduje się w bazie
Jeśli cywilizacjia nie istnieje powinien zostać zgłoszony wyjątek (NoCivilizationFoundException)
Jeśli cywilizacja istnieje powinno zostać wysłane żądanie na wskazany z bazy adres url
Powinny zostać pobrane następujące dane: unique_unit, civilization_bonus, expansion, army_type, images

  Zadanie nr 6.
Jako użytkownik chciałbym mieć możliwość pobierania danych szczegółowych na temat wybranych cywilizacji po wskazanych nazwach. 
Powinny zostać pobrane tylko szczegółowe informacje na temat cywilizacji z bazy. Reszta rezultatów.  powinna zostać zignorowana. 

  Zadanie nr 7.
Jako użytkownik chciałbym mieć możliwość zapisywania szczegółów o wyszukanych cywilizacjach w bazie danych. 
Baza danych powinna zawierać tylko szczegóły tych cywilizacji które były treścią odpowiedzi na zapytania w ramach zadań 5 i 6. 
