// app/app.component.ts
import { Component } from '@angular/core';
import { DashboardComponent } from './components/dashboard/dashboard';
import { NavbarComponent } from './components/navbar/navbar';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, DashboardComponent, NavbarComponent], // <-- Aquí cargas tus componentes
  templateUrl: './app.component.html',             // <-- Tu HTML limpio
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mi-proyecto';
}