import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment'

@Injectable({
  providedIn: 'root'
})
export class UrlShortenerService {

  serviceUrl : string = '';
  constructor(private http : HttpClient) { 
    this.serviceUrl = environment.apiUrl;
  }

  getShortUrl(url : string) {
    return this.http.post<any>(this.serviceUrl,url);
  }
  
}
