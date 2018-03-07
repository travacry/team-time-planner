import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { UserService }       from '../user.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    email: string;
    password: string;

    constructor(
        private userService: UserService,
        private router: Router
    ) { }

    ngOnInit() {
    }

    onLogin() {
        this.userService.login(this.email, this.password).subscribe(user => {
            console.log(user);
            this.router.navigateByUrl('/teams');
        });
    }

}
