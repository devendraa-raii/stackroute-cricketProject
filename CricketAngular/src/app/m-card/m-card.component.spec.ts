import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MCardComponent } from './m-card.component';
import { DebugElement } from '@angular/core';
import { async} from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { BrowserModule, By } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatExpansionModule} from '@angular/material/expansion';


import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button'
import {MatCardModule} from '@angular/material/card';

import {MatSelectModule} from '@angular/material/select';
import { MatDialogModule} from '@angular/material/dialog';
import {MatTabsModule} from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';

describe('MCardComponent', () => {
  let component: MCardComponent;
  let fixture: ComponentFixture<MCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MCardComponent ],
      imports:[
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        HttpClientModule,
        MatToolbarModule,
        MatExpansionModule,
        ReactiveFormsModule,
        MatInputModule,
        MatFormFieldModule,
        MatButtonModule,
        MatCardModule,
        FormsModule,
        MatSelectModule,
        MatDialogModule,
        MatTabsModule,
        MatIconModule,
        MatSidenavModule,
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  afterEach(() => {
    fixture.destroy();
  });
  // it('should create', () => {
  //   component.match=new Object();
  //   component.match['type']="afdas";
  //   component.match['date']="afdas";
  //   component.match['team-1']="afdas";
  //   component.match['team-2']="afdas";
  //   fixture.detectChanges();
  //   expect(component).toBeTruthy();
  // });
});
