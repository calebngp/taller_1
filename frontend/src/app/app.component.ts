import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Frontend Angular';
  message = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchHello();
  }

  fetchHello(): void {
    this.http.get<{message: string, status: string}>('http://localhost:8080/api/hello')
      .subscribe({
        next: (data) => {
          this.message = data.message;
        },
        error: (error) => {
          console.error('Error fetching data:', error);
          this.message = 'Error connecting to backend';
        }
      });
  }
}

