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
	
}
