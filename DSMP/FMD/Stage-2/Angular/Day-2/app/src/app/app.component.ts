import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ContactComponent} from './Contact/contact.component';

@Component({
  selector: 'app-root',
  imports: [ContactComponent],
  templateUrl: './app.component.html',
  standalone: true,
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'app';
}
