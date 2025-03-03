import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-search-bar-template',
  imports: [],
  templateUrl: './search-bar-template.component.html',
  styleUrl: './search-bar-template.component.scss',
  standalone:true,
})
export class SearchBarTemplateComponent {
  @Output() searchEmitter:EventEmitter<any> =new EventEmitter<any>();
  search(value:any){
    this.searchEmitter.emit(value);
  }
}
