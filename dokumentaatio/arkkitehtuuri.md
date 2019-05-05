## Rakenne 

Ohjelman pakkausrakenteessa käyttöliittymäluokka GUI sekä main-luokka ovat pakkauksessa src. Sovelluslogiikka on sijoitettu pakkaukseen applogic

## Käyttöliittymä

Käyttöliittymässä on kolme eri näkymää;

  *peliruutu
  *voittonäkymä
  *häviönäkymä

Kukin näistä on toteutettu siten, että ikkuna väritetään tietyllä tavoin tiettyjen ehtojen ollessa voimassa. Siten, ne eivät välttämättä ole täysverisiä "näkymiä." Käyttöliittymän ja sovelluslogiikan toteutukset ovat kuitenkin toisistaan pitkälti eriytetyt.

## Sovelluslogiikka 

![kaavio](/dokumentaatio/paivitettyLuokkakaavio.png)

Logic-luokka on sovelluksen toiminnan kannalta keskeisin. Se sisältää arrayt, joiden avulla pelin tilaa pidetään kasassa ja joiden kautta sen päivitys tapahtuu.

Move-luokka vastaa hiiren liikkeiden ja sen sijainnin seuraamisesta. Tämän avulla logic ja board hoitavat esimerkiksi mouseoveriin reagoimisen.

Click-luokka on klikkauksen tapahtumankäsittelijä, jolla board ja logic voivat tarkistaa, tarvitseeko laudalla muuttaa jotakin klikkauksen seurauksena.

## Heikkoudet, jotka ohjelman rakenteeseen jäivät

Käyttöliittymä ja osa sovelluslogiikan tukipilareista on toteutettu kokonaisuudessaan GUI-luokkaan. Luokkien eriyttäminen olisi sallinut ohjelmalle huomattavasti paremman pakkausrakenteen ja sitä kautta helpottanut sekä suoraviivaistanut tämän laajentamista ja ymmärtämistä. Kuitenkin, sen tekeminen osoittautui liian suureksi haasteeksi, ja käytännön pakon vuoksi rakenne päätyi nykyiselleen.

#### Sovelluslogiikka
Monissa metodeista on suuria määriä toisteista koodia, kuten taulun 144 solua läpi käyvät sisäkkäiset for-loopit.

#### Käyttöliittymä
Board-luokan paintComponent-metodi on kohtuuttoman suuri, mutta se johtuu grafiikassa käytettävässä värien vaihtelun tarpeen runsaudesta.
