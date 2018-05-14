import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService) { }

  ngOnInit() {
  }
  
  runTest(){
	  this._databaseService.runTest();
  }
  
}
