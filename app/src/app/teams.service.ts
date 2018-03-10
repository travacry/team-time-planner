import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable }              from '@angular/core';
import { Observable }              from 'rxjs/Observable';
import { User }                    from './user'
import { Team }                    from './team'

@Injectable()
export class TeamsService {

    constructor(private http: HttpClient) { }

    getTeams(): Observable<Team[]> {
        console.log('register() in UserService');
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            })
        };
        return this.http.get<Team[]>('https://team-lunch.herokuapp.com/api/teams', httpOptions);
    }
}
