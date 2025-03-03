import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgIf, NgForOf, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  standalone:true
})
export class AppComponent {
  title = 'app-2';
  my_name="Apeksha";
  imageLink = "https://www.carpro.com/hs-fs/hubfs/2023-Chevrolet-Corvette-Z06-credit-chevrolet.jpeg?width=1020&name=2023-Chevrolet-Corvette-Z06-credit-chevrolet.jpeg";
  car_width = 500;
  task = "role"
  isActive = true;
  isBac=true;
  fs = '30px';
  changeFontSize(){
    this.fs = '10px';
  }
  customer_name='';
  printData(value:any){
    this.customer_name = value;
  }
  activeDiv = true;
  // hideShow(){
  //   this.activeDiv =false;
  // }

  customer:any [] = [
    {
      name:'nimal',
      age:25
    },
    {
      name:'kamal',
      age:35
    },
    {
      name : 'saman',
      age:38
    }
  ]
  enter_name="";
}

