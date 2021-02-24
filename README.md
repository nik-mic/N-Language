# NiMic
im on my way creating my own little skript language

# F E A T U R E S

## 1. Methodes:
	Schreibe einen Topic Namen, gefolgt von Methodennamen mit passenden Parametern
		zb 0: Math count 10 => 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		zb 1: Text say Hello => Hello
	Bei mehreren Übergabeparametern müssen diese mit einem Kommer getrennt werden. 
		zb 0: Math sum 2, 3 => 5

## 2. Mode Operator:
	& SAVE, $ DO {PRINT ETC} 
		zb 0: &Math count 10

	0, 1, 2, .. ist nun unter dem Zeilennamen gespeichert. 
	
## 3. Deref Operation: 
	mit dem Operator ! kann auf die gespeicherten Werte zugegriffen werden. Sie werden Sinngemäß im Code replaced
		zb. 0: &Math count 10
		    1: Text sayBack !0 => 9, 8, 7, 6 .. 
			(Hinweis: bei fehlendem ! Operator geht der Compiler von einem literal als Parameter aus)

## 4. Naming Operation: 
	Eine dessen Wert gespeichert wird, kann mit :: benannt werden. 
		bsp 0: &Math count 10 :: zahlenBis10
		    1: Text sayBack !zahlenBis10 => 9, 8, 7, 6, ...
	Es gibt einige Naming Regeln und Konventionen, auf die später eingegangen wird. 

## 5. Deeber Methode calls 
	Eine Methode kann als Parameter eine weiter Methode übergeben bekommen. Dieses Prinzip lässt sich beliebig tief schachteln. 
		bsp: 0: Math count Math sum 2, 3 => 0, 1, 2, 3, 4

## 6. System
	Mit dem Topic "System" kann auf triviale Verzweigungsoperationen zugegriffen werden um 2 bsp zu nennen: 
		## 6.1: decide 
			Decide erhällt 2 Optionen und eine Bedingung und entscheidet anhand der Bedienung welche zurückgegeben/ausgeführt/gespeichert etc wird.
				bsp: 0: System decide Hello, Bye, 4 > 5 => Bye
				bsp: 1: System decide 0, 1, Math count 10 > Math sum 12, 2 => 0

			Wie in Zeile 1 sichtbar ist auch hier ein weiterer Methoden aufruf möglich.
			mit dem SAVE Operator kann die Auswahl unter einem beliebigen Namen gespeichert werden
				bsp: 2: &System decide Math count 10, Math count 20, 10 >= 20 :: X
				     3: Text say X => 0, 1, 2, ... 19
		## 6.2: loop
			loop wiederholt eine beliebig anzahl an Operationen solange eine Bedienung stimmt. 
			Die Überprüfung findet genau da statt wo die Bedienung der Methode gegeben wurde. 
				bsp: 0: System loop Text say hallo, Text say bye, 1 < 2 => hallo bye hallo bye .. unendlich loop

			gibt man einem loop eine zahl, ohne weitere Operationen, die an jeder hängen, interpretiert loop dies als Counter. 
				bsp: 1: System loop Text say hallo, 5 => hallo hallo hallo hallo hallo

			benutze !loop in einem loop um die akteulle Anzahl der Durchläufe zu erhalten. 

		## 6.3 Weiter Folgen

## 7. Funktionen 
	Wie in Punkt 2 erläutert sind wir in der Lage mit dem SAVE Operator Variablen zu speichern (und sie zu benennen) 
	Genauso ist dies auch mit Funktionen möglich. 
	Funktionen sind gespeicherte Code Zeilen. Sie können temporäre variablen benutzen, die mit # gekennzeichnet sind. 
	Während Variablen feste Werte zugewiesen sind, speichern Funktionen Verhalten, dass von Parametern abhängt. 
		bsp: 0: &Math count #b :: to
		     1: Text sayBack !to 10 => 9, 8, 7, ...

	Auch hier sind unbegrenzt Verschachtelungen und Erweiterungen möglich
	Der Code, der in der Funktiondeklaration erstellt wurde, wird beim Aufruf stump an die richtige Stelle kopiert und dann als Deeb Call ausgewertet. 

## 8. (triviale) Rules
	Beim Referenz erstellen (Variable oder Funktion) muss immer mit einem ! Derefenziert werden. 
	Dies kann stören und den Code unlesbar machen. 
	Als Lösung gibt Es (triviale) Rules. 
	Rules werden vor jeder Anderen Interaktion mit dem Code ausgeführt. 
	Sie beschrieben einen Namen und dessen zu Tauschenden Code/Wert. So kann eine Rule sowohl als Variable (zb Pi wird ersetzt durch 3.14) als auch als 
	Funktion benutzt werden. Durch die Operatore [ ] wird beim Naming angezeigt, dass es sich um eine Rule handelt. 
		bsp: 0: &Math count 10 :: [ to10 ]
		     1: Text say to10 => 0, 1, 2, ... 
	
	Allerdings ist zu beachten, dass dies mit viel Vorsicht zu Benutzen ist. Definiert man zb Die Rule namens "a" statt wie geplant " a ", 
	wird nun in der Zeile jeder Buchstabe a mit dem vorgesehenen Code ersetzt. Dies kann schnell zu Fehlern führen. 

	## 8.1 (operator) Rules => Language Renaming 
	Durch Rules ist es einfach möglich feste Syntaxtische Begriffe für sein eigenes Projekt umzubennen. 
	Die Sprache selber Benutzt diese Art der Umbennung an manchen Stellen für Benutzer Einstellungen. 
		bsp: 0: &Text say = :: [::]
		bsp: &Math count 10 = zahlenBis10
	
	Auch hier ist selbstverständlich Vorsicht geboten. 

## 9. Rules
	Das selbe was wir mit Funktion gelernt haben ist natürlich auch mit Rules möglich. 
	So können wir zum Beispiel die in Punkt 8 Codierte to10 Rule Variable machen. 
	0: &Math count #a :: [ to ]
	1: Text sayBack to 10 => 9, 8, ...

## 10. Reflexions 
	Hier eine grobe Vorbereitung um den Folgepunkt: Reflexions zu verstehen. 
	Die Allgemeine Architektur der Sprache ist so angelet, dass An einer Zentrallen Stelle der Content aller Variablen, Funktion und Rules abgelegt ist.
	Jede Referenz besitzt also primitiv gesagt nur einen Namen und eine Adresse auf die sie drauf zeigen. Dieser Stackt sich mit jedem Element +1
	Durch Reflexions ist es möglich auf diesen Speicher zuzugreifen und zu ändern. 
		zb: 0: System reflect 0, 10 
	Hier wurde die Speicher Adresse 0 (was auch immer dort lag) auf den Wert 10 geändert. 
	Weshalb dies eine Relevante Bedeitung hat, wird später deutlich. 

## 11. auto 
	Im aller ersten Punkt haben wir gelernt wie man Methoden Aufruft. Topic methode parameter
	Allerdings birgt dies eine Menge Renundanzen. 
	Mit dem keyword auto, beheben wir die offensichtlichste. 
	Mit dem Topic sagen wir dem Compiler in welcher Ecke er nach der Methode suchen muss, außerdem vermeiden wir missverständnisse.
	Die Methode "count" die wir aus dem Topic "Math" kennen gibt es nämich noch in vielen anderen Topics. Zum Beispiel "Text", wo sie die Anzahl eines Buchstabens in    	     einem Text zählt. 
	Allerdings gibt es ebenso viele Methoden die einzigartig für ihr Topic sind. Genau für diese Methoden gibt es auto. 
	Das Keyword besitzt eine Liste von einzigartigen Methodennamen, sollte die Methode die du gerade aufrfust darunter sein, kannst du mit auto dem Computer die arbeit 	    überlassen, nach dem richtigen Topic zu schauen.
	Sollte es die Methode doch mehrmals geben, tut "auto" sein bestes, kann aber nichts garantieren.
		bsp: 0: auto fak 4 => 24
	
	Momentan gibt es Pläne, dass Keyword auto ebenfalls unrelevant zu machen. Die Idee: "fak 4" sollte als Code-Zeile reichen. 

## 12. Prozesse 
	Ein sehr wichtiges Thema sind Prozesse. Jede Zeile Code die du schreibst, läuft in einem. Alle Variablen, Funktionen, Ausgaben etc gehören alle dem Prozess. 
	mit dem Operator # # # lässt sich ein neuer Prozess Starten. Dieser weiß nichts mehr von den Daten aus dem vorherigen. // TODO Prozess Coding

## 13. Tags
	Ebenfalls sehr wichtig sind Tags. Jede Code Zeile besitzt theoretisch einen. 
	Tags bestimmen wann eine Code Zeile Compeliert wird. Sie verändern also die Reihenfolge des Codes.
	Jede Zeile ist mit einem dieser 3 trivialen Tags versehen: <now> <> <nev> = now, later, never
	Effekt: 
		<now> : Der Default, Zeile wird wie gewohnt sofort compiled
		<lat> : Die Zeile wird nicht sofort Compiliert. Sondern erst wenn Programm ausgeführt wird.  
		<nev> : Die Zeile wird vollkommen ignoriert. Kann zb für Kommentare Benutzt werden.
 
	Was Beachte, dass trotzdem bei Jeder Zeile die Rulest ausgeführt werden!
	Die als later makierten Zeilen werden Chronologisch abgearbeitet. 
	Konsequenz: Alle Zeilen die Ressourcen aus <lat> Zeilen benutzen müssen Ebenfalls <lat> sein, sonst sind Ressourcen nicht nutzbar
		bsp: 0: <lat> Math count !a 
		     1: <now> &Math sum 12, 12 :: a 
			=> 0, 1, .. 23

	Tags können in Vielen verschiedenen Kontexten aufgegriffen werden. Wir gehen später auf Höhere Techniken mit <lat> ein sowie auf Tags in Verbindung mit Rules

## 14. (Pattern) Rules => Operator Überladung
	Dieses Thema ist besonders interesannt. Um einen Intiuativen Umgang mit der Sprache zu ermöglichen ist es möglich jeden Character, Buchstaben, Zahl zu Überladen. 
	Aber was heißt das? Nehmen wir zum Beispiel dass + Zeichen. So Definiert die Sprache die Standard Funktion der Skalaren Addition. 1 + 1 = 2
	Doch je nachdem in welchem Kontext Code verwendet wird macht es Sinn dem + Zeichen eine ganz andere Rolle zu geben. Reden wir über Vektoren oder Matritzen muss eine    	Addition anders Definiert sein. 
	Wir haben bereits eine Möglichkeit kennengelernt Character zu Replacen. Sollten wir das + nun so Überladen,stoßen wir auf ein großes Problem: 
		0: &Math sum #a, #b :: [+]  // Wir definieren hier das Plus als Summe von a und b. Diese Technik ist in Punkt 9 erklärt.
		1: Math count 3 + 3         // Wollen wir nun unsere Rule benutzen stoßen wir auf ein Problem 
		=> Math count 3 Math sum 3  // Wenn wir die Rule einsetzen passt sie nicht ins Format einer Addierung. 

	Um dies zu beheben haben wir bei Rules die Möglichkeit ein Format mit zu definieren. So wird einserseits die Rule nur benutzt falls exakt dieses Format benutzt, 	 andererseits wird in das Nötige Methode call format umgebaut. 
	Ein Format sieht wie Follgend aus: 
		0: &Math sum #a, #b :: [#a + #b]
		1: Math count 2 + 3 => 0, 1, 2 ...
	Wir geben der Rule ein genaues Format an wie es mit seinen Parametern interagieren muss. Ein weiteres Beispiel
		0: Text toUpperCase #a :: [^#a]
		1: Text say ^hello => HELLO
	Obwohl in diesem Beispiel nötig gewesen wäre, stellt es sicher dass die Rule nur exakt wie gewünscht eingesetzt wird. 


## 15. Referenz Operations
	Auf Referenzen können verschiedene Operationen inline, also ohne weiteren Methodenaufruf getätigt werden.
		0: &Math count 10 :: a
		1: b -> a
	Damit zeigt b jetzt auf die Selbespeicherzeile wie a. Verändert man also a verändere auch b
	Dieser Ausdruck wird durch Rules zu "1: &System link a :: b (Die Methode link tut exakt was oben beschrieben ist)
	Weitere Operationen: 
		0: &Math sum 12, 23 :: a
		1: a++
	Wie aus anderen Sprachen bekannt, kann auch hier der ++Operator für ein Increment benutzt werden. 

## 16. Typunsicherheit
	Das Prinzip der Sprache verbietet kein umtypisieren, da es kaum Typen gibt. 
			
