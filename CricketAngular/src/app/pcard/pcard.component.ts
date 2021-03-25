import { Component, OnInit, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PlayerstatsComponent } from '../playerstats/playerstats.component';
import { RecordService } from '../services/record.service';

@Component({
  selector: 'app-pcard',
  templateUrl: './pcard.component.html',
  styleUrls: ['./pcard.component.css']
})
export class PcardComponent implements OnInit {

  @Input() player:any;
  @Input() defState:number;
  btn:any={
    state:0,
    class:["recommend","unrecommend"],
    val:["Recommend","Unrecommend"]
  };
  constructor(private record:RecordService,private dialog:MatDialog) { }

  ngOnInit(): void {
    if(this.defState==1) this.btn.state=1;
  }
  Switch(){
    if(this.btn.state==0) {
      this.btn.state=1;
      this.record.addToRecList(this.player);
    }
    else {
      this.btn.state=0;
      this.record.removeFromRecList(this.player['pid']);
    }
  }

  openDialog(pid:number){
    this.dialog.open(PlayerstatsComponent,{ data:{ id:pid}});
  }
}
