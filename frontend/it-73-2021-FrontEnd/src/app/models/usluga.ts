import { Korisnik_usluge } from "./korisnik_usluge";
import { Filijala } from "./filijala";

export class Usluga {
    id!:number;
    naziv!:string;
    opis_usluge!:string;
    provizija!:number;
    datum_ugovora!: Date;
    filijala!: Filijala;
    korisnik_usluge!:Korisnik_usluge;
}