import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatExpansionModule} from '@angular/material/expansion';
import { ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button'
import {MatCardModule} from '@angular/material/card';
import { FormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { MatDialogModule} from '@angular/material/dialog';
import {MatTabsModule} from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { RegisterComponent } from './register/register.component';
import { PlayerstatsComponent } from './playerstats/playerstats.component';
import { MatchesComponent } from './matches/matches.component';
import {FetchService} from './services/fetch.service';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import { PcardComponent } from './pcard/pcard.component';//npm install ngx-pagination --save
import { RecordService } from './services/record.service';
import { DialogExampleComponent } from './dialog-example/dialog-example.component';
import {MatRadioModule} from '@angular/material/radio';
import { MCardComponent } from './m-card/m-card.component';
import { MatPaginatorModule} from '@angular/material/paginator';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { DashguardGuard } from './dashguard.guard';
import { ErrorComponent } from './error/error.component';
import { RankingComponent } from './ranking/ranking.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    RecommendationComponent,
    RegisterComponent,
    PlayerstatsComponent,
    MatchesComponent,
    PcardComponent,
    DialogExampleComponent,
    MCardComponent,
    ErrorComponent,
    RankingComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    MatToolbarModule,
    MatExpansionModule,
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule,
    FormsModule,
    MatSelectModule,
    MatDialogModule,
    MatTabsModule,
    MatRadioModule,
    MatPaginatorModule,
    MatIconModule,
    MatSidenavModule,
    Ng2SearchPipeModule,
  ],
  providers: [FetchService,RecordService,DashguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
