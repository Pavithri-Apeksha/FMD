import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBarTemplateComponent } from './search-bar-template.component';

describe('SearchBarTemplateComponent', () => {
  let component: SearchBarTemplateComponent;
  let fixture: ComponentFixture<SearchBarTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchBarTemplateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchBarTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
