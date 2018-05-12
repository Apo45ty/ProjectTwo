import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';
@Component({
  selector: 'app-display-graph-and-result',
  templateUrl: './display-graph-and-result.component.html',
  styleUrls: ['./display-graph-and-result.component.css']
})
export class DisplayGraphAndResultComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService) { }

  ngOnInit() {
	  
  }

}
