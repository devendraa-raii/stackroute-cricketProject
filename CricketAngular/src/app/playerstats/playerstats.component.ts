import { Component, Inject, OnInit } from '@angular/core';
import { FetchService } from "../services/fetch.service";
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-playerstats',
  templateUrl: './playerstats.component.html',
  styleUrls: ['./playerstats.component.css']
})
export class PlayerstatsComponent implements OnInit {
  constructor(private api:FetchService,private dialog:MatDialog,@Inject(MAT_DIALOG_DATA) public data:any) { }
  playerStats:any={};
  battingArray : any = [];
  bowlingArray :any = [];
  ngOnInit()
  {
    this.api.getPlayerById(this.data.id).subscribe((data: any)=>{
      console.log(data);
      this.playerStats= data;
      this.battingArray=Object.entries(this.playerStats['data']['batting']);
      this.bowlingArray=Object.entries(this.playerStats['data']['bowling']);
      })
    }  
  }
