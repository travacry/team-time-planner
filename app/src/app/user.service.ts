import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable }              from '@angular/core';
import { Observable }              from 'rxjs/Observable';
import { User }                    from './user'

import 'rxjs/add/operator/finally';

@Injectable()
export class UserService {

    authenticated: boolean;

    constructor(private http: HttpClient) { }

    logout(): Observable<Object> {
        return this.http.post('https://team-lunch.herokuapp.com/logout', {}).finally(() => {
            this.authenticated = false;
        });
    }

}
