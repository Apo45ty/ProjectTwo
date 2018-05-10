import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';

@Component({
  selector: 'app-display-results',
  templateUrl: './display-results.component.html',
  styleUrls: ['./display-results.component.css']
})
export class DisplayResultsComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService) { }

  ngOnInit() {
  }

}
