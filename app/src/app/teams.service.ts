import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable }              from '@angular/core';
import { Observable }              from 'rxjs/Observable';
import { User }                    from './user'
import { Team }                    from './team'

@Injectable()
export class TeamsService {

    constructor(private http: HttpClient) { }

    getTeams(): Observable<Team[]> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            })
        };
        return this.http.get<Team[]>('https://team-lunch.herokuapp.com/api/teams', httpOptions);
    }

    createTeam(teamName: string): Observable<Team> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            })
        };
        const team = new Team();
        team.name = teamName;
        return this.http.post<Team>('https://team-lunch.herokuapp.com/api/teams', team, httpOptions);
    }
}
