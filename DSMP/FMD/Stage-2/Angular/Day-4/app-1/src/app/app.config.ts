import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { HomeComponent } from './component/home/home.component';

export const routes = [
  { path: 'home', component: HomeComponent },
];

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)]
};
