# Vaatimusmäärittely

## Tarkoitus

Tavoitteena on toteuttaa klassinen miinaharava. Toiminnallisuuksina peli itse,
sekä jonkinnäköinen kirjanpito high-scoreista.

## Suunnitellut toiminnallisuudet

miinaharava itsessään, eli pelin perustoiminnallisuus:

* aloitusruutu, jossa näkyy itse pelikenttä

* kentällä on ruutuja, joissa on joko miina tai numero, joka kertoo kuinka monessa ruudun naapureista on miina

* kentät on peitetty, ja ne voi joko merkata miinaksi tai niitä voi painaa

* miinallista ruutua painettaessa peli hävitään, miinatonta ruutua painettaessa numero tulee näkyviin

suurempaa miinatonta aluetta painettaessa kaikki sen ruudut paljastetaan automaattisesti siten, että aluetta reunustaa numerolliset ruudut

* kun kaikki miinat on merkittynä, eikä yksikään ruutu ole peitossa, peli voitetaan

### Ei-niin tähdellisiä jatkokehitysideoita

* mahdollisuus valita kentän koko

* mahdollisuus aloittaa peli uudestaan

* ilmoitus hävitystä pelistä

* pisteytys voitetulle pelille

* high-scorejen tallettaminen yksinkertaiseen tietokantaan

