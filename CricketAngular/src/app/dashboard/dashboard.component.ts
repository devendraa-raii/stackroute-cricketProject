import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecordService } from '../services/record.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user:string;
  constructor(private record:RecordService ,private router:Router) { 

    this.record.fetchAllPlayers(localStorage.getItem("userName"));
    this.record.fetchAllMatches(localStorage.getItem("userName"));
  }

  ngOnInit(): void {
    this.user=localStorage.getItem("userName");
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['login']);
  }
}
