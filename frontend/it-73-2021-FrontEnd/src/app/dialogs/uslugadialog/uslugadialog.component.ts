
import { UslugaService } from './../../services/usluga.service';
import { KorisnikService } from 'src/app/services/korisnik-usluge.service';
import { Filijala } from 'src/app/models/filijala';
import { Korisnik } from 'src/app/models/korisnik_usluge';
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Usluga } from 'src/app/models/usluga';


@Component({
  selector: 'app-uslugadialog',
  templateUrl: './uslugadialog.component.html',
  styleUrls: ['./uslugadialog.component.css']
})
export class UslugadialogComponent {

  flag!: number;
  korisnici! : Korisnik[]; 

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Usluga>,
    @Inject(MAT_DIALOG_DATA) public data: Usluga,
    public service: UslugaService,
    public korisnikService: KorisnikService
  ) {}

  ngOnInit(): void {
    this.korisnikService.getAllKorisnik().subscribe((data) => {
      
      this.korisnici = data;
    });
  }


  public compare(a:any, b:any) {
    return a.id == b.id;
  }

  public cancel() {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmena!', 'Zatvori!', { duration: 1000 });
  }

  public add() {
    this.service.addUsluga(this.data).subscribe({
      next: (data) => {
        console.log(JSON.stringify(data))
        this.snackBar.open(
          `Usluga sa id ${data.id} je kreirana!`,
          'Zatvori!',
          {
            duration: 1000,
          }
        );
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open('Uspešno kreiranje!', 'Zatvori!', {
          duration: 1000,
        });
      },
    });
  }

  public update() {
    this.service.updateUsluga(this.data).subscribe({
      next: (data) => {
        this.snackBar.open(
          `Usluga sa id ${data.id} je modifikovana!`,
          'Zatvori!',
          {
            duration: 1000,
          }
        );
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open('Neuspešno modifikovanje!', 'Zatvori!', {
          duration: 1000,
        });
      },
    });
  }

  public delete(): void {
    this.service.deleteUsluga(this.data.id).subscribe({
      next: (data) => {
        this.snackBar.open(`Usluga sa id ${this.data.id} je obrisana!`, 'Zatvori!', { duration: 1000 });
        this.dialogRef.close(1);
      },
      error: (err) => {
        console.error('Error deleting usluga:', err);
        this.snackBar.open('Neuspešno brisanje usluge!', 'Zatvori!', { duration: 2000 });
      }
    });
  }



}

