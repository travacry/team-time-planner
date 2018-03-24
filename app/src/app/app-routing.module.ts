import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeamsComponent }       from './teams/teams.component';
import { TeamComponent }       from './team/team.component';

const routes: Routes = [
    { path: '', redirectTo: '/teams', pathMatch: 'full' },
    { path: 'teams', component: TeamsComponent },
    { path: 'teams/:index', component: TeamComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
