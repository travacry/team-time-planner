import { Injectable }              from '@angular/core';
import { Team }                    from './team'

@Injectable()
export class TeamsHolder {

    private teams: Team[];

    constructor() {
        this.teams = [];
    }

    setTeams(teams: Team[]) {
        this.teams = teams;
    }

    addTeam(team: Team) {
        this.teams.push(team);
    }

    getTeam(index: number): Team {
        return this.teams[index];
    }

    getTeams(): Team[] {
        return this.teams;
    }

}
