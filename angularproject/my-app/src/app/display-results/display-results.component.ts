import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';

@Component({
  selector: 'app-display-results',
  templateUrl: './display-results.component.html',
  styleUrls: ['./display-results.component.css']
})
export class DisplayResultsComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService) { }
  public listData;
  public page = 0;
  public errorMsg;
  getResults(){
	  this._databaseService.getTestsNonTime(this.page)
	.subscribe(
	data => {
		this.listData = data;
	},
	error => this.errorMsg = error);
  }
  ngOnInit() {
	this.getResults();
  }
  onPreviousPage(){
	  if(this.page>0){
		  this.page--;
	  }
	  this.getResults();
  }
  onNextPage(){
	  this.page++;
	  this.getResults();
  }
}
