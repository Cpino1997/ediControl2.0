import { Component, OnInit } from '@angular/core';
import { EventBusService } from 'src/app/_helpers/event-bus.service';
import { AuthService } from 'src/app/_servicios/auth.service';
import { StorageService } from 'src/app/_servicios/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private storageService: StorageService, 
    private eventBusService: EventBusService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login(username, password).subscribe({
      next: data => {
        this.storageService.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.storageService.getUser().roles;
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
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