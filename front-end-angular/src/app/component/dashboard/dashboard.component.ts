import { Component, OnInit } from '@angular/core';
import { UrlShortenerService } from 'src/app/shared/url-shortener.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  url: string = "";
  originalUrl: string = "";
  isUrlGenerated: boolean = false;
  isErrorGenerated: boolean = false;
  shortUrl: string = "";
  errorMsg : string = "" ; 
  constructor(private urlShortnerService: UrlShortenerService) { }

  ngOnInit(): void {
    this.isUrlGenerated = false;
  }

  generateShortUrl() {
    this.urlShortnerService.getShortUrl(this.url).subscribe(res => {
      if (res == null) {
        this.isErrorGenerated = true;
      } else {
        this.isUrlGenerated = true;
        this.isErrorGenerated = false;
        this.shortUrl = res.shorturl;
        this.originalUrl = res.originalurl;
      }
    }, err => {
      console.log(err) ; 
      if (err.error && err.error.message) {
        this.errorMsg = err.error.message;
      } else if (err.message) {
        this.errorMsg = err.message;
      } else {
        // Handle any other error scenarios here
        this.errorMsg = 'An unknown error occurred.';
      }
      this.isUrlGenerated = false;
      this.isErrorGenerated = true;
    })
  }
}
