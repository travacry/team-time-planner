import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable }              from '@angular/core';
import { Observable }              from 'rxjs/Observable';
import { User }                    from './user'
import { Team }                    from './team'

@Injectable()
export class TeamsService {

    constructor(private http: HttpClient) { }

    getTeams(user: User): Observable<Team> {
        console.log('register() in UserService');
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Basic ' + btoa(user.email + ':' + user.password)
            })
        };
        return this.http.get<Team>('https://team-lunch.herokuapp.com/api/teams', httpOptions);
    }
}
