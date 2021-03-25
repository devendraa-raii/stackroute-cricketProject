import { HttpClient, HttpClientJsonpModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup=new FormGroup({
    userName:new FormControl("",[Validators.required]),
    password:new FormControl("",[Validators.required])
  });
  constructor(private http:HttpClient,private router:Router) { }
  ngOnInit(): void {
  }

  login(){
      this.http.post<any>(`http://localhost:8081/login`,this.loginForm.value).subscribe(data=>{
        localStorage.setItem("token",data.token);
        // console.log(this.loginForm.value.userName):
        localStorage.setItem("userName",this.loginForm.value.userName);
        this.router.navigate(["dashboard"]);
      },error=>{
        console.log(error.error.message);

      })

      
  }
}