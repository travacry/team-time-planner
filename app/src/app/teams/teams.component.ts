import { Component, OnInit } from '@angular/core';
import { TeamsService }      from '../teams.service'
import { Team }              from '../team'

@Component({
    selector: 'app-teams',
    templateUrl: './teams.component.html',
    styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

    teams: Team[];
    teamName: string;

    constructor(private teamsService: TeamsService) { }

    ngOnInit() {
    }

    onCreate() {
        this.teamsService.createTeam(this.teamName).subscribe(team => this.teams.push(team));
    }

}
