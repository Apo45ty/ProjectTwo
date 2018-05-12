import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest,HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Router} from '@angular/router';
import { Test } from './Test';

@Injectable()
export class DatabaseGetterService {
	public endpoint = 'http://localhost:8080/ProjectTwo';
	public errorMsg;
	public listData;
	constructor(private http:HttpClient,private router:Router) { }
	getTests(page):Observable<Test[]>{
<<<<<<< HEAD
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/GetAllRequest/?format=json&page='+page);
		a.subscribe(
		data => {
			this.listData=data;
			this.loadedData=true;
		},
		error => {
			this.loadedData=true;
			this.errorMsg = error
		});	
		return a;
	}
=======
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/GetAllRequest/?format=json&page='+page);	
		return a;
	}
	getTestsNonTime(page):Observable<Test[]>{
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/GetAllRequest/?format=json&page='+page);	
		return a;
	}
	getSystems(page):Observable<Test[]>{
		let a : Observable<Test[]> = this.http.get<Test[]>(this.endpoint+'/GetAllSystems/?format=json&page='+page);	
		return a;
	}
>>>>>>> 61cc6993e95a493d512cff12e42a32aa3dc55192
	
}
