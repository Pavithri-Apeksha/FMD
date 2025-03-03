import {Component, Input} from '@angular/core';
import {CurrencyPipe} from '@angular/common';

@Component({
  selector: 'app-customer-template',
  imports: [
    CurrencyPipe
  ],
  templateUrl: './customer-template.component.html',
  standalone: true,
  styleUrl: './customer-template.component.scss'

})
export class CustomerTemplateComponent {
  @Input() customer:any;
}
