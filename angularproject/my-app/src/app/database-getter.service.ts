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
	constructor(private http:HttpClient,private router:Router) { }
	getTests(page):Observable<Test[]>{
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/GetAllRequest/?format=json&page='+page);
		a.subscribe(
			data => {
				this.listData = data;
			},
			error => this.errorMsg = error);	
		return a;
	}
}
