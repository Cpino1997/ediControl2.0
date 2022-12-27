import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_servicios/auth.service';
import { StorageService } from 'src/app/_servicios/storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  
  constructor(private authService: AuthService, private storageService: StorageService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }
  salir(): void {
    this.authService.salir().subscribe({
      next: res => {
        console.log(res);
        this.storageService.clean();    
        window.location.reload();
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
