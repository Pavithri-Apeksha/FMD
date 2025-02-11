import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgIf, NgForOf, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  name = "Pavithri Apeksha";
  imageLink = "https://images.pexels.com/photos/675920/pexels-photo-675920.jpeg?cs=srgb&dl=pexels-minan1398-675920.jpg&fm=jpg";
  width = 500;
  task = "role";
  isActive = true;
  isDivStyle = true;
  fontSize = '50px';
  changeFontSize(){
    this.fontSize = '20px';
  }
  customerName = '';
  printData(value:any){
    this.customerName = value;
  }
  state = true;

  customers:any[] =[
    {
      name:'nimal',
      age:25
    },
    {
      name:'kamal',
      age:35
    },
    {
      name: 'saman',
      age:30
    }
  ];
  studentName = '';
}
