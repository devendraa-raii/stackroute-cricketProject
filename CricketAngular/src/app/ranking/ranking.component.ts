import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {
  url:string=`http://localhost:3000/`;
  odi1:any[]=[];
  odi2:any[]=[];
  odi3=[];
  test1=[];
  test2=[];
  test3=[];
  tw1=[];
  tw2=[];
  tw3=[];

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
      this.http.get<any>(this.url+`ODI1`).subscribe(data=>{
        this.odi1=data;
      });
      this.http.get<any>(this.url+`ODI2`).subscribe(data=>{
        this.odi2=data;
      });
      this.http.get<any>(this.url+`ODI3`).subscribe(data=>{
        this.odi3=data;
      });

      this.http.get<any>(this.url+`TEST1`).subscribe(data=>{
        this.test1=data;
      });

      this.http.get<any>(this.url+`TEST2`).subscribe(data=>{
        this.test2=data;
      });
      this.http.get<any>(this.url+`TEST3`).subscribe(data=>{
        this.test3=data;
      });

      this.http.get<any>(this.url+`T201`).subscribe(data=>{
        this.tw1=data;
      });

      this.http.get<any>(this.url+`T202`).subscribe(data=>{
        this.tw2=data;
      });

      this.http.get<any>(this.url+`T203`).subscribe(data=>{
        this.tw3=data;
      });
  }

}
