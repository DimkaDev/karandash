import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  template: `
    <main aria-label="SiteForge development scaffold">
      <p>Development scaffold. Product screens are not implemented.</p>
    </main>
    <router-outlet />
  `,
})
export class App {}
