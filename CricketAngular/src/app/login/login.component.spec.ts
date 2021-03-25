import { DebugElement } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
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

import { LoginComponent } from './login.component';
import { HttpClientModule } from '@angular/common/http';




describe('LoginComponent', () => {
  let comp: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de:DebugElement;
  let el:HTMLElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
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
    fixture = TestBed.createComponent(LoginComponent);
    comp = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(comp).toBeTruthy();
  });

  it('form should be valid', async(() =>{
    comp.loginForm.controls['userName'].setValue('dfkshf');
    comp.loginForm.controls['password'].setValue('aada');
  
    expect(comp.loginForm.valid).toBeTruthy();
    }));
    
  it('form should be invalid', async(() =>{
      comp.loginForm.controls['userName'].setValue('');
      comp.loginForm.controls['password'].setValue('');
    
      expect(comp.loginForm.valid).toBeFalsy();
      }));

      it('should call the login method', async(() =>{
        fixture.detectChanges();
        spyOn(comp, 'login');
        el = fixture.debugElement.query(By.css('button')).nativeElement;
        el.click();
        expect(comp.login).toHaveBeenCalledTimes(0);
        }));

});
