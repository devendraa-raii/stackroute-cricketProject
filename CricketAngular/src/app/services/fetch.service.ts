import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class FetchService {
  apiKey: string = "UyjYYsG23LMf2iyBAYIS2EwVKNF2";
  constructor(private http: HttpClient) {}

  getPlayerByName(name:string){
    return this.http.get(`https://cricapi.com/api/playerFinder?apikey=${this.apiKey}&name=${name}`);
  }

  getPlayerById(id:number){
    return this.http.get(`https://cricapi.com/api/playerStats?apikey=${this.apiKey}&pid=${id}`);
  }

  getUpcomingMatches(): any
  {
    return this.http.get(`https://cricapi.com/api/matches?apikey=${this.apiKey}`);
  }

  getOldMatches(){
    return this.http.get(`https://cricapi.com/api/cricket?apikey=${this.apiKey}`);
  }

  getCurrentScore(id:number){
    return this.http.get(`https://cricapi.com/api/cricketScore?apikey=${this.apiKey}&unique_id=${id}`);
  }

  getMatchSummary(id:number){
    return this.http.get(`https://cricapi.com/api/fantasySummary?apikey=${this.apiKey}&unique_id=${id}`);
  }
}
