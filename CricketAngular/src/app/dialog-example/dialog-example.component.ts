import { Component, OnInit,Inject} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FetchService } from '../services/fetch.service';
@Component({
  selector: 'app-dialog-example',
  templateUrl: './dialog-example.component.html',
  styleUrls: ['./dialog-example.component.css']
})
export class DialogExampleComponent implements OnInit {
  batting:any[]=[];
  bowling:any[]=[];
  
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private fetchService:FetchService) { }
  ngOnInit(): void {
      let unique_id=this.data.id;
      this.fetchService.getMatchSummary(unique_id).subscribe(res=>{
        this.batting=res['data']['batting'];
        this.bowling=res['data']['bowling'];
      });
  }
}