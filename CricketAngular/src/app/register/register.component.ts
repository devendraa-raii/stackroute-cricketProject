import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/User';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  Roles: any = ['Admin', 'Author', 'Reader'];
  gender:string;

  registerForm:FormGroup=new FormGroup({
    userName:new FormControl("",[Validators.required, Validators.minLength(6)]),
    password:new FormControl("",[Validators.required, Validators.minLength(4)]),
    fullName:new FormControl("",[Validators.required]),
    email:new FormControl("",[Validators.required, Validators.email]),
    address:new FormControl("")
  });
  constructor(private http:HttpClient) { }
  ngOnInit() {
  }

  register(){
    console.log(this.registerForm.value);
    this.http.post<User>(`http://localhost:8081/register`,this.registerForm.value).subscribe(data=>{
        

    })

    this.registerForm.reset();
  }
}