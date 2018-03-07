import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable }              from '@angular/core';
import { Observable }              from 'rxjs/Observable';
import { User }                    from './user'

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    register(user: User): Observable<User> {
        console.log('register() in UserService');
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            })
        };
        return this.http.post<User>('https://team-lunch.herokuapp.com/api/users', user, httpOptions);
    }

    login(email: string, password: string): Observable<User> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Basic ' + btoa(email + ':' + password)
            })
        };
        return this.http.get<User>('https://team-lunch.herokuapp.com/api/users/login', httpOptions);
    }

}
