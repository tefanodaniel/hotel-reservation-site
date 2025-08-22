import { Component, input } from '@angular/core';
import { HotelInterface } from '../hotel-interface';
import { RouterLink, RouterOutlet } from '@angular/router'

@Component({
  selector: 'app-hotel-option',
  imports: [ RouterLink, RouterOutlet],
  template: `
    <section class="hotel">
        <img
        class="hotel-photo"
        [src]="hotelOption().photo"
        alt="Exterior photo of {{ hotelOption().name }}"
        crossorigin
        />
        <h2 class="hotel-heading">{{ hotelOption().name }}</h2>
        <p class="hotel-location">{{ hotelOption().city }}, {{ hotelOption().state }}</p>
        <a [routerLink]="['/details', hotelOption().id]">Learn More</a>
    </section>
   `,
  styleUrls: [ './hotel-option.css']
})
export class HotelOption {
    hotelOption = input.required<HotelInterface>();
}
