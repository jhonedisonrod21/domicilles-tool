import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import {AppHome} from "./home/app.home";
import {AppLogin} from "./login/app.login";
import {AppHeader} from "./header/app.header";
import {AppHelp} from "./help/app.help";
import { RouterModule, Routes } from "@angular/router"

const appRoutes: Routes=[
  {
    path: 'home',
    component: AppHome
  },
  {
    path: 'login',
    component: AppLogin
  },
  {
    path: 'help',
    component: AppHelp
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    AppHome,
    AppLogin,
    AppHeader,
    AppHelp
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
