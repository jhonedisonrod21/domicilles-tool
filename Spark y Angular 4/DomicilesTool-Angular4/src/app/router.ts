import {AppComponent} from "./app.component";
import {AppHome} from "./home/app.home";
import {Routes} from "@angular/router";

export const Router: Routes=[
  {
    path: 'routerPath',
    component: AppComponent,
    children: [
      {path: 'homePage', component: AppHome}
    ]
  }
];
