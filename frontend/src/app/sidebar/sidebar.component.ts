import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  toggleCollapse(id: string) {
    const element = document.getElementById(id);
    if (element) {
      element.classList.toggle('show');
    }
  }
}
