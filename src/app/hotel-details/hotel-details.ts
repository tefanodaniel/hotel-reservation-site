import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HotelInterface } from '../hotel-interface';
import { HotelService } from '../hotel-service';
import { ReservationService } from '../reservation-service';

@Component({
  selector: 'app-hotel-details',
  imports: [ ReactiveFormsModule ],
  template: `
    <article>
      <img
        class="hotel-photo"
        [src]="hotelOption?.photo"
        alt="Exterior photo of {{ hotelOption?.name }}"
        crossorigin
      />
      <section class="hotel-description">
        <h2 class="hotel-heading">{{ hotelOption?.name }}</h2>
        <p class="hotel-location">{{ hotelOption?.city }}, {{ hotelOption?.state }}</p>
      </section>
      <section class="hotel-features">
        <h2 class="section-heading">About this hotel option</h2>
        <ul>
          <li>Units available: {{ hotelOption?.availableUnits }}</li>
          <li>Does this hotel have wifi: {{ hotelOption?.wifi }}</li>
          <li>Does this hotel have laundry: {{ hotelOption?.laundry }}</li>
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
    hotelOption: HotelInterface | undefined;

    reservationForm = new FormGroup({
        firstName: new FormControl(''),
        lastName: new FormControl(''),
        email: new FormControl(''),
    });

    constructor() {
        const hotelId = Number(this.route.snapshot.params['id']);
        this.hotelOption = this.hotelService.getHotelOptionById(hotelId);
    }

    submitReservation() {
        this.reservationService.createReservation(
            this.reservationForm.value.firstName ?? '',
            this.reservationForm.value.lastName ?? '',
            this.reservationForm.value.email ?? '',
        );
    }
}
