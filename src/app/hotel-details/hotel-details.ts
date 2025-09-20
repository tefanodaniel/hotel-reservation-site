import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HotelInterface } from '../hotel-interface';
import { HotelService } from '../hotel-service';
import { ImageService } from '../image-service';
import { NewHotelInterface } from '../new-hotel-interface';
import { ReservationService } from '../reservation-service';

@Component({
  selector: 'app-hotel-details',
  imports: [ ReactiveFormsModule ],
  template: `
    <article>
      
      <img
        class="hotel-photo"
        [src]="photoUrl"
        alt="Exterior photo of {{ hotelOption?.hotel_name }}"
        crossorigin
      /> 
      
      
      <section class="hotel-description">
        <h2 class="hotel-heading">{{ hotelOption?.hotel_name }}</h2>
        <p class="hotel-location">{{ hotelOption?.hotel_city }}, {{ hotelOption?.hotel_distance }} km away</p>
      </section>
      <section class="hotel-features">
        <h2 class="section-heading">About this hotel option</h2>
        <ul>
          <li>Rating: {{ hotelOption?.hotel_stars }} / 5 based on X reviews.</li>
          <li>Average rate: {{ hotelOption?.hotel_avg_rate }} </li>
          <li>All rates: {{ hotelOption?.hotel_price_min }} - {{ hotelOption?.hotel_price_max }}</li>
          <li>Phone number: {{ hotelOption?.hotel_phone}}</li>
          <li>Availability: {{ hotelOption?.hotel_availability}}</li>
        </ul>
      </section>
      <section class="reservation-form">
        <h2 class="section-heading"> Make a reservation </h2>
        <form [formGroup]="reservationForm" (submit) = "submitReservation()"> 
            <label for="first-name"> First Name </label>
            <input id="first-name" type="text" formControlName="firstName" />
            <label for="last-name"> Last Name </label>
            <input id="last-name" type="text" formControlName="lastName" />
            <label for="email"> Email </label>
            <input id="email" type="email" formControlName="email" />
            <button type="submit" class="primary" > Submit </button>
        </form>
      </section>
    </article>
  `,
  styleUrls: [ './hotel-details.css' ]
})
export class HotelDetails {
    route: ActivatedRoute = inject(ActivatedRoute);
    hotelService = inject(HotelService);
    reservationService = inject(ReservationService);
    imageService = inject(ImageService);
    hotelOption: NewHotelInterface | undefined;
    photoUrl: string | undefined;

    reservationForm = new FormGroup({
        firstName: new FormControl(''),
        lastName: new FormControl(''),
        email: new FormControl(''),
    });

    constructor() {
        
    }

    async ngOnInit() {
        const hotelId = Number(this.route.snapshot.params['id']);
        this.hotelService.getNewHotelOptionById(hotelId)
            .then((hotelOption: NewHotelInterface | undefined) => {
                this.hotelOption = hotelOption;
            });

        const urls = await this.imageService.getHotelImagesUrls(hotelId);
        this.photoUrl = urls[0] ?? "";
    }

    submitReservation() {
        this.reservationService.createReservation(
            this.reservationForm.value.firstName ?? '',
            this.reservationForm.value.lastName ?? '',
            this.reservationForm.value.email ?? '',
        );
    }
}
