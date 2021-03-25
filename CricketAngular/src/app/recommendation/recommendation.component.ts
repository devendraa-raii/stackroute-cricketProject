import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { FetchService } from '../services/fetch.service';
import { RecordService } from '../services/record.service';

@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent implements OnInit {
    playerName:string="";
    players:any[]=[];
    playerSlice:any[]=[];
    recList:any[]=[];
    type:string = "";
    matchData: Array<any>= [];
    match_type: Array<any> = [];
    matchRecommendations: any;
    pageSlice1:any;
    pageSlice2:any;
  constructor(private record:RecordService,private fetch:FetchService) { }
  
  ngOnInit(): void {
    this.record.getRecList().subscribe(data=>{
      this.recList=data;
    });
    this.getData();
    this.getRecommendations();
    this.fetch.getPlayerByName("a")
    .subscribe(data=>{
      this.players=data["data"];
      if(this.players.length<6)
      this.playerSlice=this.players.slice(0,this.players.length);
      else this.playerSlice=this.players.slice(0,6);
    });

    this.fetch.getUpcomingMatches().subscribe(
      response=>{
        let data = response["matches"];
        this.match_type = [];
      this.match_type= data.filter(match => match["type"].toLowerCase() == "ODI".toLowerCase() && match["type"]!="");
      this.pageSlice1  = this.match_type.slice(0,5);
      }
    );
  }

  find(){
    this.fetch.getPlayerByName(this.playerName)
    .subscribe(data=>{
      this.players=data["data"];
      if(this.players.length<6)
      this.playerSlice=this.players.slice(0,this.players.length);
      else this.playerSlice=this.players.slice(0,6);
    });
  }
  
  getData(){
    this.fetch.getUpcomingMatches().subscribe(
      response=>{
        this.matchData = response["matches"];
      }
    )};
    
  showData(type){
      this.match_type = [];
      this.match_type= this.matchData.filter(match => match["type"].toLowerCase() == type.toLowerCase() && match["type"]!="");
      this.pageSlice1  = this.match_type.slice(0,5);
      // this.pageSlice2 = this.matchRecommendations.slice(0,5);
        }

    getRecommendations(){
    this.record.getRecommendationList().subscribe(
      data=>{
        this.matchRecommendations = data;
        console.log(this.matchRecommendations)
      }
    )
  }

  OnpageChange(event:PageEvent){
    const startIndex=event.pageIndex*event.pageSize;
    let endIndex=startIndex+event.pageSize;
    if(endIndex>this.players.length){
      endIndex=this.players.length;
    }
    this.playerSlice=this.players.slice(startIndex,endIndex);
  }
  OnPageChange(event: PageEvent){
    console.log(event);
    const startIndex = event.pageIndex * event.pageSize;
    const startIndex1= event.pageIndex * event.pageSize;
    let endIndex = startIndex + event.pageSize;
    let endIndex1 = startIndex1 + event.pageSize;
    if (endIndex>this.match_type.length){
      endIndex=this.match_type.length;
    }
    if (endIndex1>this.matchRecommendations.length){
      endIndex1=this.matchRecommendations.length;
    }
    this.pageSlice1 = this.match_type.slice(startIndex,endIndex);
    // this.pageSlice2 = this.matchRecommendations.slice(startIndex1,endIndex1);
    // console.log(this.pageSlice2)
  }


}
