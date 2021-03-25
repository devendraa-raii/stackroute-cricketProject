import { Component, Input, OnInit } from '@angular/core';
import { Match } from '../model/Match';
import { RecordService } from '../services/record.service';
@Component({
  selector: 'app-m-card',
  templateUrl: './m-card.component.html',
  styleUrls: ['./m-card.component.css']
})
export class MCardComponent implements OnInit {
  @Input() match: any;
  @Input() defState: number;
  btn:any={
    state:0,
    class:["recommend","unrecommend"],
    val:["Recommend","Unrecommend"]
  }; 

  mat:Match;
  constructor(private record: RecordService) { }
  ngOnInit(): void {
    // this.mat=new Match();
    // this.mat.unique_id=this.match['unique_id'];
    // this.mat.team1=this.match['team-1'];
    // this.mat.team2=this.match['team-2'];
    // this.mat.date=this.match['date'].substring(0,10);
    // this.mat.type=this.match['type'];
    if(this.defState==1){
      this.btn.state=1;
    }
  }
  Switch(){
    if(this.btn.state==0){
      this.btn.state=1;
      this.record.addToRecommendation(this.match);
    }
    else {
      this.btn.state=0;
      this.record.removeFromRecommendation(this.match["unique_id"]);
    }
  }
  }