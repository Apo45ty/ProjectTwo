import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { DatabaseGetterService } from '../database-getter.service';
import {Chart} from 'chart.js';
@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public errorMsg;
  public page = 0;
  public tests;
  public osOptions=[];
  constructor(private _databaseService:DatabaseGetterService,
			  private router:Router) { 
  }
  onPreviousPage(){
	  if(this.page>0){
		  this.page--;
	  }
	  this.getRequests();
  }
  onNextPage(){
	  this.page++;
	  this.getRequests();
  }
  ngOnInit() {
	this.getRequests();
	this.getSystems();
  }
   
  selectChanged(){
  }
  getSystems(){
		this._databaseService.getSystems(this.page).subscribe(
		data => {
			this.osOptions = data;
			this.osOptions.push({
				testSystem:{
					os:"All",
					cpu:"All",
					id:"All",
					diskDrive:"All",
					ram:"All"
				}
			});
		},
		error => this.errorMsg = error);
  }
  getRequests(){
	let chartColors = {
		red: 'rgb(255, 99, 132)',
		orange: 'rgb(255, 159, 64)',
		yellow: 'rgb(255, 205, 86)',
		green: 'rgb(75, 192, 192)',
		blue: 'rgb(54, 162, 235)',
		purple: 'rgb(153, 102, 255)',
		grey: 'rgb(201, 203, 207)'
	};
	let config = {
		type: 'line',
		data: {
			labels: ['1', '2', '3', '4', '5', '6', '7'],
			datasets: [{
				label: 'Runtime Plot',
				fill: false,
				backgroundColor: chartColors.blue,
				borderColor: chartColors.blue,
				data: [
				10,11
				],
			}]
		},
		options: {
			responsive: true,
			title: {
				display: true,
				text: 'Example Of Charts'
			},
			tooltips: {
				mode: 'index',
				intersect: false,
			},
			hover: {
				mode: 'nearest',
				intersect: true
			},
			scales: {
				xAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: 'Runs'
					}
				}],
				yAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: 'Miliseconds'
					}
				}]
			}
		}
	};
	this._databaseService.getTests(this.page).subscribe(
	data => {
		this.tests = data;
		console.log(data);
		let a = [this.tests.length];
		for(let i=0;i<this.tests.length;i++){
			config.data.labels[i]=''+(i+1);
			try{
				let eTime:any = new Date(this.tests[i].updatedTest.test_end_date);
				console.log(eTime);
				let sTime:any = new Date(this.tests[i].updatedTest.test_start_date);
				console.log(sTime);
				a[i] = eTime - sTime;
			}catch(e) {
			  console.log(e);
			}
		}
		var canvas : any = document.getElementById("canvas");
		var ctx = canvas.getContext("2d");
		config.data.datasets[0].data = a;
		let myLine = new Chart(ctx, config);
	},
	error => this.errorMsg = error);
  }
}
