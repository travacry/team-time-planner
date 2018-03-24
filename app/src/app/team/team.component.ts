import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TeamsHolder } from '../teams.holder';
import { Team } from '../team';

@Component({
    selector: 'app-team',
    templateUrl: './team.component.html',
    styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

    team: Team;

    constructor(
        private route: ActivatedRoute,
        private teamsHolder: TeamsHolder
    ) { }

    ngOnInit() {
        const index = +this.route.snapshot.paramMap.get('index');
        this.team = this.teamsHolder.getTeam(index);
    }

}
