import { Component }   from '@angular/core';
import { Router }      from '@angular/router';
import { UserService } from './user.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'Team Lunch Planner';

    constructor(
        private userService: UserService,
        private router: Router
    ) {}

    logout() {
        this.userService.logout().subscribe(() => this.router.navigateByUrl('/login'));
    }
}
