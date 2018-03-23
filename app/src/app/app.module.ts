import { BrowserModule }    from '@angular/platform-browser';
import { NgModule }         from '@angular/core';
import { FormsModule }      from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { UserService } from './user.service';
import { TeamsComponent } from './teams/teams.component';
import { TeamsService } from './teams.service';
import { TeamComponent } from './team/team.component';


@NgModule({
    declarations: [
        AppComponent,
        TeamsComponent,
        TeamComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        HttpClientModule
    ],
    providers: [UserService, TeamsService],
    bootstrap: [AppComponent]
})
export class AppModule { }
