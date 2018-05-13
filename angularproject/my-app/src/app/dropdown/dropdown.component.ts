import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements OnInit {
  
  constructor(private _databaseService:DatabaseGetterService) { }

  ngOnInit() {
  }
  selectChanged(limit){
	  this._databaseService.limitPerPage=limit;
	  this._databaseService.testComponentCallback(this._databaseService.testComponent);
  }
}
