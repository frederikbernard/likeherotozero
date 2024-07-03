# Like Hero To Zero

## Projektbeschreibung

„Like Hero To Zero“ ist eine Webanwendung, die öffentlich zugängliche Daten zu weltweiten CO2-Emissionen darstellt. Sie bietet ein benutzerfreundliches Frontend, das es Bürger:innen ermöglicht, die neuesten verfügbaren CO2-Ausstoßdaten eines Landes abzurufen. Darüber hinaus gibt es eine Backend-Oberfläche, die es registrierten Wissenschaftler:innen erlaubt, neue Daten hinzuzufügen oder bestehende Daten zu korrigieren.

## Technologien

Die Anwendung wurde unter Verwendung der folgenden Technologien entwickelt:

- **Spring Boot**: Als Hauptframework für die Backend-Entwicklung.
- **H2 In-Memory-Datenbank**: Für die schnelle und einfache Verwaltung der Daten während der Entwicklungsphase.
- **Thymeleaf**: Als Template-Engine für die Integration der Frontend-Templates direkt in Spring Boot.

## Installation der Web-Anwendung

### Voraussetzungen

- Java Development Kit (JDK) 11 oder höher
- Git
- Maven

### Schritt-für-Schritt Anleitung

1. **Repository klonen**

Klonen Sie das Repository von GitHub:
git clone https://github.com/frederikbernard/likeherotozero.git
cd likeherotozero

2. **Backend konfigurieren und starten**

Navigieren Sie in das Backend-Verzeichnis: /likeherotozero

Abhängigkeiten installieren und Anwendung starten:

./mvnw clean install
./mvnw spring-boot:run

Hinweis: Maven als Paketmanager muss installiert sein.


Datenbankinitialisierung:
Beim ersten Start der Anwendung wird die H2 In-Memory-Datenbank automatisch mit Beispieldaten initialisiert. Diese Daten können über das Backend-Interface eingesehen und bearbeitet werden.

3. **Nutzung der Anwendung**
Sobald das Backend erfolgreich gestartet wurde, kann die Anwendung im Browser unter http://localhost:8080/ aufgerufen werden. Das Backend ist für registrierte Benutzer zugänglich, während das Frontend öffentlich verfügbar ist.
Das Backend kann erreicht werden unter: http://localhost:8080/

Die Nutzerkennungen, die bereits angelegt sind, lauten:
Joe_Scientist
Mandy_Publisher
Beide haben das Passwort: p123
