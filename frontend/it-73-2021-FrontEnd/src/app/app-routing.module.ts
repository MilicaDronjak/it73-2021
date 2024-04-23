import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BankaComponent } from './main/banka/banka.component';
import { FilijalaComponent } from './main/filijala/filijala.component';
import { KorisnikUslugeComponent } from './main/korisnik-usluge/korisnik-usluge.component';
import { UslugaComponent } from './main/usluga/usluga.component';
import { HomeComponent } from './utility/home/home.component';
import { AuthorComponent } from './utility/author/author.component';
import { AboutComponent } from './utility/about/about.component';

const routes: Routes = [
  {path:'banka', component:BankaComponent}, 
  {path:'filijala', component:FilijalaComponent},
  {path:'korisnik-usluge', component:KorisnikUslugeComponent},
  {path:'usluga', component:UslugaComponent},
  {path:'home', component:HomeComponent},
  {path:'author', component:AuthorComponent},
  {path:'about', component:AboutComponent},
  {path:'', component:HomeComponent, pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
