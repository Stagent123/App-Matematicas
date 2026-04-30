
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component'; // Importas el componente raíz

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));