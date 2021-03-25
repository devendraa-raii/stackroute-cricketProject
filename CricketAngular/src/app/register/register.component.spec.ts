import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterComponent } from './register.component';
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

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let de:DebugElement;
  let el:HTMLElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterComponent ],
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
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('form should be valid', async(() =>{
    component.registerForm.controls['userName'].setValue('dfkshf');
    component.registerForm.controls['password'].setValue('aada');
    component.registerForm.controls['fullName'].setValue('asfafasf');
    component.registerForm.controls['address'].setValue('aada');
    component.registerForm.controls['email'].setValue('aada@adsa.asd');
    expect(component.registerForm.valid).toBeTruthy();
    }));

    it('form should be invalid', async(() =>{
      component.registerForm.controls['userName'].setValue('');
      component.registerForm.controls['password'].setValue('');
      component.registerForm.controls['fullName'].setValue('');
      component.registerForm.controls['address'].setValue('');
      component.registerForm.controls['email'].setValue('aadaadsaasd');
      expect(component.registerForm.valid).toBeFalsy();
      }));

      it('should call the register method', async(() =>{
        fixture.detectChanges();
        spyOn(component, 'register');
        el = fixture.debugElement.query(By.css('button')).nativeElement;
        el.click();
        expect(component.register).toHaveBeenCalledTimes(0);
        }));


        it('form should validate email', async(() =>{
          component.registerForm.controls['userName'].setValue('afaddfad');
          component.registerForm.controls['password'].setValue('afafafs');
          component.registerForm.controls['fullName'].setValue('asfafasf');
          component.registerForm.controls['address'].setValue('diahufka');
          component.registerForm.controls['email'].setValue('aadaadsaasd');
          expect(component.registerForm.valid).toBeFalsy();
          }));
});
