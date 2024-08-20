INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Milica', 'Petrovic', '2104002726819');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Ivan', 'Nikolic', '1207002678445');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Jovana', 'Jovanovic', '0109002666489');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Marko', 'Savic', '2503001721889');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Ana', 'Stojanovic', '3106002099323');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Nikola', 'Markovic', '1108991721123');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Vesna', 'Todorovic', '0806005726545');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Milan', 'Ilic', '1508002890013');
INSERT INTO "korisnik"("id", "ime", "prezime", "maticni_broj") VALUES(nextval('KORISNIK_SEQ'), 'Ljiljana', 'Matic', '9212345678901');

INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'Sberbank Srbija', '+38111224419', 854713925);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'Erste Bank Srbija', '+38111224444', 132465798);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'Komercijalna Banka', '+38111224455', 876543210);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'NLB Banka', '+38111224488', 741852963);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'Addiko Bank', '+38111224410', 369258147);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'ProCredit Bank', '+38111224412', 987654123);
INSERT INTO "banka"("id", "naziv", "kontakt", "pib") VALUES(nextval('BANKA_SEQ'), 'Vojvođanska Banka', '+38111224418', 654789321);

INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Kralja Petra 12, Beograd', 6, true, 2);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Bulevar Kralja Aleksandra 90, Beograd', 7, false, 4);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Nemanjina 4, Beograd', 5, true, 1);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Terazije 14, Beograd', 8, false, 3);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Makedonska 30, Beograd', 4, true, 6);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Resavska 11, Beograd', 3, false, 7);
INSERT INTO "filijala"("id", "adresa", "broj_pultova", "poseduje_sef", "banka") VALUES(nextval('FILIJALA_SEQ'), 'Kneza Miloša 20, Beograd', 6, true, 5);

INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Otvaranje računa', 'Otvaranje novog tekućeg računa', '2023-12-20', 4.0, 1, 5);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Podizanje gotovine', 'Podizanje gotovine na šalteru uz proviziju', '2023-12-20', 3.5, 2, 2);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Mobilno bankarstvo', 'Podnošenje zahteva i aktivacija mobilnog bankarstva', '2023-12-20', 6.0, 3, 4);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Kredit', 'Podnošenje zahteva za odobrenje kredita', '2023-12-20', 12.5, 4, 3);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Štedni račun', 'Otvaranje štednog računa', '2023-12-20', 5.0, 5, 1);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Elektronska uplata', 'Uplata sredstava preko elektronskog bankarstva', '2023-12-20', 2.5, 6, 7);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Promena paketa', 'Prelazak na viši paket usluga', '2023-12-20', 8.0, 7, 6);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Devizni račun', 'Otvaranje deviznog računa', '2023-12-20', 6.5, 8, 2);
INSERT INTO "usluga"("id", "naziv", "opis_usluge", "datum_ugovora", "provizija", "korisnik", "filijala") VALUES(nextval('USLUGA_SEQ'), 'Investicije', 'Ulaganje u investicione fondove', '2023-12-20', 7.5, 9, 4);
