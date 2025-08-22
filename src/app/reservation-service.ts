import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

    createReservation(firstName: string, lastName: string, email: string) {
        console.log(
            `Reservation received: firstName: ${firstName}, lastName: ${lastName}, email: ${email}.`,
        );
    }

}
