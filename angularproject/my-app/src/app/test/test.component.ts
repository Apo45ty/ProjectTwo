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
  constructor(private _databaseService:DatabaseGetterService,
			  private router:Router) { 
  }
  onPreviousPage(){
	  if(this.page>0){
		  this.page--;
	  }
	  this.getRequests(this);
  }
  onNextPage(){
	  this.page++;
	  this.getRequests(this);
  }
  ngOnInit() {
	this._databaseService.testComponent = this;
	this._databaseService.testComponentCallback = this.getRequests;
  }
  ngAfterContentInit(){
	this.getRequests(this);
  }
  getRequests(me){
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
	let config2 = {
		type: 'doughnut',
		data: {
			datasets: [{
				data: [
					10,
					20
				],
				backgroundColor: [
					chartColors.blue,
					chartColors.orange
				],
				label: 'Dataset 1'
			}],
			labels: [
				'Passed',
				'Failed'
			]
		},
		options: {
			responsive: true,
			legend: {
				position: 'top',
			},
			title: {
				display: true,
				text: 'Passed Vs Failed Test'
			},
			animation: {
				animateScale: true,
				animateRotate: true
			}
		}
	};
	me._databaseService.getTests(me.page).subscribe(
	data => {
		this._databaseService.loadedData=true;
		//Remove the line graph from dom and add a new element with same id
		let para = document.createElement("canvas");
		let att = document.createAttribute("id");       
		att.value = "canvas";                           
		para.setAttributeNode(att);
		let element = document.getElementById("canvasParrent");
		let child = document.getElementById("canvas");
		element.removeChild(child);
		element.appendChild(para);
		
		//Remove the donught graph from dom and add a new element with same id
		para = document.createElement("canvas");
		att = document.createAttribute("id");       
		att.value = "canvas2";                           
		para.setAttributeNode(att);
		element = document.getElementById("canvas2Parrent");
		child = document.getElementById("canvas2");
		element.removeChild(child);
		element.appendChild(para);
		
		//Get the data for the graphs
		let tests = data;
		console.log(data);
		let a = [tests.length];
		let failCount = 0;
		for(let i=0;i<tests.length;i++){
			config.data.labels[i]=''+(i+1);
			if(tests[i].updatedTest.test_context.toLowerCase() == 'FAILED'.toLowerCase()){
				failCount++;
			}
			try{
				let eTime:any = new Date(tests[i].updatedTest.test_end_date); 
				let sTime:any = new Date(tests[i].updatedTest.test_start_date);
				a[i] = eTime - sTime;
			}catch(e) {
			  console.log(e);
			}
		}
		
		//Setup line chart
		var canvas : any = document.getElementById("canvas");
		var ctx = canvas.getContext("2d");
		config.data.datasets[0].data = a;
		let myLine = new Chart(ctx, config);
		myLine.update();
		
		//Setup donught chart
		var canvas2 : any = document.getElementById("canvas2");
		var ctx2 = canvas2.getContext("2d");
		config2.data.datasets[0].data = [tests.length-failCount,failCount];
		let myDoughnut = new Chart(ctx2, config2);
		myDoughnut.update();
	},
	error => me.errorMsg = error);
  }
  
}
