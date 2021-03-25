import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashguardGuard implements CanActivate {
  constructor(private http:HttpClient,private router:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      return new Promise<boolean>((resolve,reject)=>{
        this.http.get<any>(`http://localhost:8080/api/v1/isAuthenticated`,{
          headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem('token')}`)
        }).subscribe(data=>{
          resolve(data.message);
        },
        error=>{
          resolve(false);
          this.router.navigate(['login']);
        });
    });
  
    
    
      // return this.http.get<any>(`http://localhost:8080/api/v1/isAuthenticated`,{
      //   headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem('token')}`)
      // }).subscribe(data=>{
      //   if(data.message){
      //     return true;
      //   }
      // },
      // error=>{
      //   return false;
      // })
    
  }
  
}
