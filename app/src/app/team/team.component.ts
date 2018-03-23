import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-team',
    templateUrl: './team.component.html',
    styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

    id: string;

    constructor(
        private route: ActivatedRoute
    ) { }

    ngOnInit() {
        this.id = +this.route.snapshot.paramMap.get('id');
    }

}
