import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest,HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Router} from '@angular/router';
import { Test } from './Test';

@Injectable()
export class DatabaseGetterService {
	public endpoint = 'http://localhost:8080/ProjectTwo/';
	public errorMsg;
	constructor(private http:HttpClient,private router:Router) { }
	getTests(page):Observable<Test[]>{
		return this.http.get<Test[]>(this.endpoint+'/getAll/?format=json&page='+page);
	}
}
