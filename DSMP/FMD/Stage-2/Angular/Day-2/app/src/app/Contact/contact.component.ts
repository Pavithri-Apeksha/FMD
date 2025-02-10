import {Component} from '@angular/core';
import {AboutComponent} from '../about/about.component';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss',
  imports: [
    AboutComponent
  ],
  standalone: true
})
export class ContactComponent{

}
