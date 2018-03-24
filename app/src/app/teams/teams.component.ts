import { Component, OnInit } from '@angular/core';
import { TeamsService }      from '../teams.service';
import { TeamsHolder }       from '../teams.holder';
import { Team }              from '../team';

@Component({
    selector: 'app-teams',
    templateUrl: './teams.component.html',
    styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

    private teamName: string;

    constructor(
        private teamsService: TeamsService,
        private teamsHolder: TeamsHolder
    ) { }

    ngOnInit() {
        this.teamsService.getTeams().subscribe(teams => this.teamsHolder.setTeams(teams));
    }

    onCreate() {
        this.teamsService.createTeam(this.teamName).subscribe(team => {
            this.teamsHolder.addTeam(team);
            this.teamName = '';
        });
    }

    getTeamName(): string {
        return this.teamName;
    }

    getTeams(): Team[] {
        return this.teamsHolder.getTeams();
    }
}
