import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DashguardGuard } from './dashguard.guard';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { MatchesComponent } from './matches/matches.component';
import { PlayerstatsComponent } from './playerstats/playerstats.component';
import { RankingComponent } from './ranking/ranking.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate:[DashguardGuard],
    children:[
      {
        path:'myrecommendations',
        component:RecommendationComponent
      },
      {
        path:'matches',
        component:MatchesComponent
      },
      {
        path:'ranking',
        component:RankingComponent
      },
      {
        path:'',
        redirectTo:'matches',
        pathMatch:'full'
      }
    ]
  },
  { 
    path:'',
    redirectTo:'login',
    pathMatch:'full'
  },
  {
    path:'**',
    component:ErrorComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
