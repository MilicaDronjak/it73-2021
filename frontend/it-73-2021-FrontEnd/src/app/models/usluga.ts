import { Filijala } from "./filijala";
import { Korisnik } from "./korisnik_usluge";

export class Usluga {
  id!: number;
  naziv!: string;
  opis_usluge!: string;
  datum_ugovora!: Date;
  provizija!: number;
  filijala!: Filijala;
  korisnik!: Korisnik;
}