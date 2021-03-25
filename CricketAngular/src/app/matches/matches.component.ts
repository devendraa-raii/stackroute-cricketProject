import { Component, OnInit } from '@angular/core';
import { FetchService } from "../services/fetch.service";
import { MatDialog } from '@angular/material/dialog';
import { DialogExampleComponent } from '../dialog-example/dialog-example.component';
@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  constructor(private api:FetchService,private dialog:MatDialog) { }
  team:string;
  matches:any=[];

  old_matches:any;
  current_match:any[]=[];
  p1:number=1;
  p2:number=1;
  p3:number=1;
  ngOnInit()

  {
    this.api.getUpcomingMatches().subscribe((data: any)=>{
      console.log(data.matches.length);
      this.matches=data.matches;
      this.fillCurrent(data.matches);
    })

    this.api.getOldMatches().subscribe((data: any)=>{
      // console.log(data);
      this.old_matches=data.data;
    })
    


  }

  fillCurrent(matches){
    let today=new Date();
    let year=today.getFullYear();
    let month=''+(today.getMonth()+1);
    
    let day=''+(today.getDate());
    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;
      let dateString=[year,month,day].join('-');
    this.current_match=matches.filter(data=>{
      if(data.date.substring(0,10)==dateString && data['matchStarted'])
      return true;
    })
  }

  currentScore(pid:number,status:boolean):Promise<string>{
    const res=new Promise<string>((resolve,reject)=>{
      this.api.getCurrentScore(pid).subscribe(data=>{
        if(status){
          if(typeof data['score']==='undefined'){
            resolve("Live score is not available");
          }
          else{
            resolve(data['score']);
          }
        }
        else{
          resolve("match has not started yet!");
        }
      });
    });
    return res;
   }
  openDialog(unique_id:number,status:boolean){
      let Score;
      this.currentScore(unique_id,status).then(data=>{
        Score=data;
        this.dialog.open(DialogExampleComponent, {data:{score:Score,id:unique_id}});
      });
    
  }



  filter(){

  }

}
