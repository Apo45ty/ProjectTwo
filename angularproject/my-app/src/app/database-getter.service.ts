import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest,HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Router} from '@angular/router';
import { Test } from './Test';

@Injectable()
export class DatabaseGetterService {
	public endpoint = 'http://ec2-18-219-104-154.us-east-2.compute.amazonaws.com:8090/ProjectTwo';
	public errorMsg;
	public listData;
	public loadedData = false;
	public limitPerPage = 25;
	public testComponentCallback;
	public testComponent;
	constructor(private http:HttpClient,private router:Router) { }
	getTests(page):Observable<Test[]>{
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/getAllRequest/?format=json&page='+page+'&limit='+this.limitPerPage);
		a.subscribe(
		data => {
			this.listData=data;
			this.loadedData=true;
			for(let i=0;i<this.listData.length;i++){
				try{
					let eTime:any = new Date(this.listData[i].updatedTest.test_end_date); 
					let sTime:any = new Date(this.listData[i].updatedTest.test_start_date);
					this.listData[i].updatedTest.runtime = eTime - sTime;
				}catch(e) {
				  console.log(e);
				}
			}
		},
		error => {
			this.loadedData=true;
			this.errorMsg = error
		});	
		return a;
	}
	
	runTest(){
		let a = this.http.get(this.endpoint+'/runTest/');
		a.subscribe(
		data => {
		},
		error => {
			this.errorMsg = error
		});	
	}
	
	
}
