import { Component, input } from '@angular/core';
import { HotelInterface } from '../hotel-interface';
import { RouterLink, RouterOutlet } from '@angular/router'
import { NewHotelInterface } from '../new-hotel-interface';

@Component({
  selector: 'app-hotel-option',
  imports: [ RouterLink, RouterOutlet],
  template: `
    <section class="hotel">
        
        <!--> <img
        class="hotel-photo"
        [src]="hotelOption().photo"
        alt="Exterior photo of {{ hotelOption().name }}"
        crossorigin
        /> -->

        <h2 class="hotel-heading">{{ hotelOption().hotel_name }}</h2>
        <p class="hotel-location">{{ hotelOption().hotel_city}}, {{ hotelOption().hotel_distance }} km away</p>
        <a [routerLink]="['/details', hotelOption().hotel_id]">Learn More</a>
    </section>
   `,
  styleUrls: [ './hotel-option.css']
})
export class HotelOption {
    hotelOption = input.required<NewHotelInterface>();
}
