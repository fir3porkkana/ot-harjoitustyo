# Testausdokumentti

Ohjelman testaus on suoritettu automaattisilla yksikkö- ja integraatiotesteillä, sekä manuaalisesti järjestelmätasolla.

## Yksikkö- ja integraatiotestit

### Sovelluslogiikka

Automaattisen testauksen pääosan muodostavat integraatiotestit, jotka testaavat pakkauksen [applogic](https://github.com/fir3porkkana/ot-harjoitustyo/tree/master/Miinaharava/src/main/java/applogic) luokan Logic määrittelemää sovelluslogiikkaa.

Loppu toiminnallisuudesta on käyttöliittymässä (GUI), joka koostuu lähinnä gettereistä ja settereistä.

### Testauskattavuus

Käyttöliittymä pois lukien sovelluslogiikan testikattavuus on rivien osalta 92%, ja vastaavasti haarautumakattavuus on 98%.

![testauskattavuus](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/Screenshot%20at%2021-54-43.png)


## Järjestelmätestaus

Testaus järjestelmätasolla on suoritettu sekä yllämainittujen integraatiotestien avulla että manuaalisesti.

### Asennus ja konfiguraatio

Sovellus on haettu ja sitä on testattu manuaalisesti [käyttöohjeen](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) Linux-ympäristössä. Sovellus ei tarvitse ylimääräisiä tiedostoja käynnistyäkseen ja toimiakseen.

### Toiminnallisuudet

[Määrittelydokumentin](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) ja [käyttöohjeen](https://github.com/fir3porkkana/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) listaama toiminnallisuus on käyty läpi manuaalisesti, niin voittoon kuin häviöönkin johtavat skenaariot.
