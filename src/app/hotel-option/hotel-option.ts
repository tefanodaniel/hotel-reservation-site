import { Component, inject, input, OnInit } from '@angular/core';
import { HotelInterface } from '../hotel-interface';
import { RouterLink, RouterOutlet } from '@angular/router'
import { NewHotelInterface } from '../new-hotel-interface';
import { ImageService } from '../image-service';

@Component({
  selector: 'app-hotel-option',
  imports: [ RouterLink, RouterOutlet],
  template: `
    <section class="hotel">
        
        <img
        class="hotel-photo"
        [src]="photoUrl"
        alt="Exterior photo of {{ hotelOption().hotel_name }}"
        crossorigin
        />

        <h2 class="hotel-heading">{{ hotelOption().hotel_name }}</h2>
        <p class="hotel-location">{{ hotelOption().hotel_city}}, {{ hotelOption().hotel_distance }} km away</p>
        <a [routerLink]="['/details', hotelOption().hotel_id]">Learn More</a>
    </section>
   `,
  styleUrls: [ './hotel-option.css']
})
export class HotelOption implements OnInit {

    hotelOption = input.required<NewHotelInterface>();
    imageService: ImageService = inject(ImageService);
    photoUrl: string = "";

    constructor() {
        
    }

    async ngOnInit() {
        const urls = await this.imageService.getHotelImagesUrls(this.hotelOption().hotel_id);
        this.photoUrl = urls[0] ?? "";
    }

}
