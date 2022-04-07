package Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringApplication.class, args);
	}

}

/*
JPA - Java Persistance API(rozszerzenie Hibernate)
IDE - Integrated Development Envoirment
API - Aplication Progremming Interface
Bean - obiekt zarządzany przez IoC
IoC - Inversion of Control(związany z DI)
DI - Dependency Injection(wstrzykiwanie zależności)
Entity - Encja, zbiór zależności i atrybutów dla obiektu w bazie danych
DAO - Data Acces Object(obiekt zawierający funkcje pozwalające na pobranie obiektów z bazy danych)
DTO - Data Transfer Object(gettery)
JDBC - Java Database Connectivity(połączenie niskopoziomowe z bazą danych, wykonywanie zapytań w SQL)
SQL - Specyfic Query Language
POJO - Plain Old Java Object(stary dobry obiekt javowy)
Java EE - Enterprice Edition platforma do tworzenia aplikacji biznesowych
EJB - Enterprice Java Bean - komponenty budowy warstw usług aplikacji
DDL - Data Definition Language - definiowanie struktur danych
XML - Extensible Markup Language uniwersalny język znaczników służący np do konfiguracji aplikacji
YAML - Ain't Markup Language(Na początku miał być Yet Another Markup Language ale koncepcja się zmieniła)
- Human Readable Data Serialization Language(może robić to samo co XML) jest ustrukturyzowany, nie zawiera dodatkowych znaków
-(w przeciwieństwie do XML)
Persistance - trwałość


GenerationTypes{
	Persistance Provider Class - HIBERNATE!
	JDBC Batching - przetważanie wsadowe - podanie wielu argumentów w formie zapytania SQL i zwrócenie odpowiedzi jako stream
	stream - strumień(tutaj strumień danych). Plusy : wydajność i spójność danych(bo niskopoziomowe)

	1.GenerationType.AUTO - (default) pozwala persistance provider class wybrać strategię generowania.
	Wybiera domyślnie strategię generowania bazując na dialekcie bazy danych.
	Dla większości dialektów wybiera GenerationType.SEQUENCE

	przykladowy wygląd pola id encji :
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

	2.GenerationType.IDENTITY - najłatwiejsze do używania, ale nie najwydajniejszy.
	Bazuje na automatycznie zwiększających siękolumnach w bazie danych.
	Umożliwia bazie automatyczne wygenerowanie wartości.
	Dobrze zoptymalizowane i nie wymaga dodatkowych warunków.
	Wada jeśli używa Hibernate! : Hibernate wymaga podania wartości klucza podstawowego dla każdej encji
	i natychmiast musi wykonać zapytanie INSERT(zapytanie SQL wstawiające rekord do tabeli).
	Uniemożliwia zastosowanie JDBC Batching!

	przykladowy wygląd pola id encji :
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;


	3.GenerationType.SEQUENCE - wymaga dodatkowej instrukcji SQL aby uzyskać następną wartość z sekwencji
	bazy danych. Przeważnie nie ma to wpływu na wydajność, ale są wyjątki(bardzo dużo encji).
	Można zoptymalizować. Jeśli nie podasz dodatkowych informacji Hibernate zażąda kolejnej wartości ze
	swojej domyślej sekwencji. Podając @SequenceGenerator można to zmienić.

	przykladowy wygląd pola id encji :
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
		@SequenceGenerator(name = "book_generator", table = "id_generator", schema = "book_store")
		private Long id;
	lub
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;

	4.GenerationType.TABLE - rzadko używana, symuluje sekwencje przez przechowywanie i nadpisywanie swojej
	wartości w kolumnie bazy danych. Znacznie lepiej wybrać GenerationType.SEQUENCE

	przykladowy wygląd pola id encji :
		@Id
		@GeneratedValue(strategy = GenerationType.TABLE, generator = "book_generator")
		@TableGenerator(name = "book_generator", table = "id_generator", schema = "book_store")
		private Long id;
}


@SequenceGenerator{
	Adnotacja ta umożliwia zdefiniowanie nazwy generatora, nazwy schematu sekwencji bazy danych oraz
	rozmiaru alokacji(przypisanie zasobu do możliwości ich użycia) sekwencji

	Wtedy id encji może wyglądać tak :
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
		@SequenceGenerator(name = "book_generator", table = "id_generator", schema = "book_store")
		private Long id;
}

@Entity{
	Mówi Hibernate że dany POJO (stary dobry obiekt javowy) jest encja bazodanową
	(zbiór zależności i atrybutów dla obiektu w bazie danych)

	Przykładowa Encja :

		@Entity														//niezbędne do =======
		public class User{
			@Id
			@GeneratedValue(strategy = GenerationType.Auto)
			private int id; 										//==========
			private String name;
			private int age;

			User(){              //niezbędne! konstruktor bezargumentowy potrzebny dla Hibernate! do stworzenia nowej instancji
			}

			(konstruktor...)
			(gettery i settery...)
		}
}


@Column{
	@Column(name = "imie") Ustawienie nazwy kolumny w tabeli
}

@Table{
	@Table(name = "user") Ustawienie nazwy dla tabeli
}

@Id{
	@Id - wskazanie na id obiektu
}

@GeneratedValue{
	@GeneratedValue(strategy = GenerationType.AUTO) - wybiera tryb generowania wartości
}

@Required{
		@Required
  		public void setAge(Integer age) {
      		this.age = age;
   		}
		
	Ta adnotacja jest stosowana w metodach ustawiania Bean'ów gdy trzeba wymusić jakaś wymaganą właściwość.
	@Required wskazuje, że dany komponent bean musi zostać wypełniony w czasie konfiguracji wymaganą właściwością.
	W przeciwnym razie zostanie zgłoszony wyjątek typu BeanInitializationException.
}



Skóty klawiszowe{
	ctrl + alt + s opcje IDE
	aby wyłączyć sprawdzanie słownika ctrl + alt + s Editor>NaturalLanguages>Spelling
}

 */

