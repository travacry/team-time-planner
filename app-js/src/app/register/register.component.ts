import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { UserService }       from '../user.service';
import { User }              from '../user';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    user: User;

    constructor(
        private userService: UserService,
        private router: Router
    ) { }

    ngOnInit() {
        this.user = new User();
    }

    onRegister() {
        console.log('register() in component');
        this.userService.register(this.user).subscribe(user => {
            console.log(user);
            this.router.navigateByUrl('/teams');
        });
    }
}
