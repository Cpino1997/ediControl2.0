import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { EventBusService } from './_helpers/event-bus.service';
import { AuthService } from './_servicios/auth.service';
import { StorageService } from './_servicios/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  username?: string;

  eventBusSub?: Subscription;

  constructor(
    private storageService: StorageService,
    private authService: AuthService,
    private eventBusService: EventBusService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showUserBoard = this.roles.includes('ROLE_USER');
      this.username = user.username;
    }

    this.eventBusSub = this.eventBusService.on('salir', () => {
      this.salir();
    });
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