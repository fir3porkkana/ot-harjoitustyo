# Miinaharava
Miinaharava on klassinen peli, jossa tarkoituksena on annetun informaation perusteella päätella laudalla olevien miinojen sijainti. Käyttäjä voittaa pelin, kun kaikki miinat on merkitty ja loput ruudut on paljastettu. Häviö tulee, jos pelaaja erehtyy painamaan ruutua, jossa on miina.

#### Dokumentaatio
 
[suoritettavissa oleva mainin koodi](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/Miinaharava/src/main/java/src/Main.java)

[testejä](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/Miinaharava/src/test/java/LogicTest.java)

[käyttöohje](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[arkkitehtuuri](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[tuntikirjanpito](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

### Releaset

[viikko 5](https://github.com/fir3porkkana/ot-harjoitustyo/releases/tag/viikko5)

[viikko 6](https://github.com/fir3porkkana/ot-harjoitustyo/releases/tag/1.01)

[loppupalautus](https://github.com/fir3porkkana/ot-harjoitustyo/releases/tag/1.02)


### Komentorivitoiminnot

#### Testaus 

Testit saa suoritettua komennolla
`mvn test`
Testikattavuusraportin luominen tapahtuu komennolla
`mvn jacoco:report`

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Suoritettavan jarin generointi

Komennolla
`mvn package`
voi generoida target-hakemistoon jar-tiedoston nimeltä Miinaharava-1.0-SNAPSHOT.jar.

### JavaDoc

Komennolla
`mvn javadoc:javadoc`
saa generoitua JavaDocin. Sitä voi tarkastella avaamalla tiedosto target/site/apidocs/index.html selaimella

### Checkstyle

Checkstyle -tarkistukset [(määritelty tässä tiedostossa)](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/Miinaharava/checkstyle.xml) suoritetaan komennolla 
`mvn jxr:jxr checkstyle:checkstyle`
Terminaalissa näkyy alustava virheraportti, ja itse virheitä pääsee tarkastelemaan avaamalla selaimella tiedosto target/site/checkstyle.html
