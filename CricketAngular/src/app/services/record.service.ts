import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Match } from '../model/Match';
import { Player } from '../model/Player';
import { FetchService } from './fetch.service';

@Injectable({
  providedIn: 'root'
})
export class RecordService {

  constructor(private fetch:FetchService,private http:HttpClient) { }
  recPlayers:any[]=[];
  subject:BehaviorSubject<any>=new BehaviorSubject(this.recPlayers);
  recommendedMatches: any[]=[];
  matchsubject: BehaviorSubject<any>=new BehaviorSubject(this.recommendedMatches);
  matchData: any;
  match_type: any;
  match:any;

  getRecList(){
    return this.subject;
  }

  fetchAllPlayers(userName:String){
    this.http.get<any[]>(`http://localhost:8080/api/v1/players/${userName}`,{
      headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)
    }).subscribe(data=>{
        this.recPlayers=data;
        this.subject.next(this.recPlayers);
    })
  }

  fetchAllMatches(userName:String){
    this.recommendedMatches=[];
    this.http.get<Array<Match>>(`http://localhost:8080/api/v1/matches/${userName}`,{
      headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)
    }).subscribe(data=>{
        data.forEach(match=>{
          let r={};
          r['team-1']=match.team1;
          r['team-2']=match.team2;
          r['type']=match.type;
          r['unique_id']=match.unique_id;
          r['date']=match.date;
          this.recommendedMatches.push([r]);
          this.matchsubject.next(this.recommendedMatches);
        });
        
    });
  }

  addToRecList(player:any){
    let p:Player=new Player();
    p.pid=player['pid'];
    p.name=player['name'];
    p.fullName=player['fullName'];
    p.userName=localStorage.getItem("userName");
    this.http.post(`http://localhost:8080/api/v1/players`,p,{
      headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)
    }).subscribe(data=>{
      if(data['message']){
        this.recPlayers.push(p);
      this.subject.next(this.recPlayers);
      }
      else{
        alert("already recommended!");
      }
    });
    

  }

  removeFromRecList(id:number){
    let i=0;
    for(i=0;i<this.recPlayers.length;i++){
      if(this.recPlayers[i]['pid']==id)
      break;
    }
    this.recPlayers.splice(i,1);
    this.subject.next(this.recPlayers);
    this.http.delete(`http://localhost:8080/api/v1/players/${id}/${localStorage.getItem("userName")}`,{
      headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)
    }).subscribe(data=>{

    })

  }
  getRecommendationList(){
    return this.matchsubject;
  }
  addToRecommendation(match:any){
        let m: Match = new Match();
        m.team1 = match['team-1'];
        m.team2= match['team-2'];
        m.date =match['date'];
        m.type = match['type'];
        m.unique_id = match['unique_id'];
        m.userName = localStorage.getItem('userName');
        this.http.post(`http://localhost:8080/api/v1/matches`,m,
            {headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)})
            .subscribe(
                   data=>{
                      if(data['message']){
                        this.recommendedMatches.push([match]);
                        this.matchsubject.next(this.recommendedMatches);
                     }
                     else{
                        alert("already recommended!");
                      }

                }
           );
        }

      removeFromRecommendation(id:number){
        this.recommendedMatches.forEach(data=>{
          if(data[0]['unique_id']==id){
            let index= this.recommendedMatches.indexOf(data);
            this.recommendedMatches.splice(index,1);
          }
        }
        );
        this.matchsubject.next(this.recommendedMatches);
        this.http.delete(`http://localhost:8080/api/v1/matches/${id}/${localStorage.getItem("userName")}`,{
      headers:new HttpHeaders().set(`Authorization`,`Bearer ${localStorage.getItem("token")}`)
    }).subscribe(data=>{

    })
      }

}
