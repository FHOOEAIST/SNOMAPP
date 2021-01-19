# SNOMAPP
## Einleitung
Die SNOMAPP Anwendung verfolgt das Ziel, die Zuordnung von APPC zu Snomed möglichst einfach zu gestalten und den Anwender dabei zu Unterstützen möglichst schnell, gute Zuordnungen zu finden. Mithilfe der FHIR “Concept Maps” können Zuordnungen einheitlich abgespeichert werden.

### Architektur
![RDM Master Screenshot 1 - Architekture](./Architekturdiagramm.jpg)
## Installation und Starten der Anwendung
### Entwicklungs Setup
Snomapp ist ein auf Maven basierende Spring Boot Applikation. IDE spezifische Mechanismen müssen genutzt werden um die entsprechende Konfiguration aus dem top-level pom.xml File zu laden.  Danach kann die Applikation über die entsprechenden Maven-Lifecycle Schritte gebaut und deployed werden.
Die Applikation bindet sich an Port 8080. Dieser muss daher frei sein.
### Anwendung über Docker
Für die Installation und das Starten der Anwendung muss zuvor Docker installiert werden. 
Mit dem Befehl “docker-compose up” ausgehend aus dem SNOMAPP Verzeichnis kann die Anwendung gestartet werden. Docker führt im anschluss ein komplettes Maven Build der Anwendung durch, was beim ersten Mal durchaus etwas länger dauern könnte. Sobald der Container läuft ist die Applikation wiederum unter port 8080 zu erreichen. Alle persistieren Daten werden im Verzeichnis “./data” abgelegt.
### Snowstorm Server
Die IP - Adresse des Snowstorm Servers, der verwendet werden soll, kann über eine Umgebungsvariable (SNOWSTORM_ADDRESS) gesetzt werden. Anpassung des Servers kann im docker-compose.yml durchgeführt werden.
### Importieren der Datenbank
Die Neo4J Datenbankanbindung kann über die Environment Variable spring.data.neo4j.uri konfiguriert werden. Standardmäßig wird port 7678 verwendet. Sollte Über Docker deployed werden, dann sind alle entsprechenden Datenbankkonfigurationen bereits abgeschlossen.

Wird die Anwendung zum allerersten Mal gestartet so muss das csv-File zuerst in die Datenbank geladen werden. Dies erfolgt auf der Startseite. Anschließend wird der APPC-Baum angezeigt.

