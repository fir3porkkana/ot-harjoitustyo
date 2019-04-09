![kaavio](/dokumentaatio/alustavaLuokkakaavio.png)

Board-luokka on sovelluksen toiminnan kannalta keskeisin. Se sisältää arrayt, joiden avulla pelin tilaa pidetään kasassa ja joiden kautta sen päivitys tapahtuu.

Move-luokka vastaa hiiren liikkeiden ja sen sijainnin seuraamisesta. Tämän avulla board hoitaa esimerkiksi mouseoveriin reagoimisen.

Click-luokka on klikkauksen tapahtumankäsittelijä, jolla board voi tarkistaa, tarvitseeko laudalla muuttaa jotakin klikkauksen seurauksena.
