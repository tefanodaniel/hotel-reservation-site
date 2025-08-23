import { Component, inject } from '@angular/core';
import { HotelOption } from '../hotel-option/hotel-option';
import { HotelInterface } from '../hotel-interface';
import { HotelService } from '../hotel-service';
import { NewHotelInterface } from '../new-hotel-interface';

@Component({
  selector: 'app-home',
  imports: [ HotelOption  ],
  template: `
    <section>
      <form>
        <input type="text" placeholder="Filter by city" #filter />
        <button class="primary" type="button" (click)="filterResults(filter.value)">Search</button>
      </form>
    </section>
    <section class="results">
      @for ( hotelOption of filteredHotelOptionList; track $index ) {
          <app-hotel-option [hotelOption]="hotelOption"></app-hotel-option>
      }
    </section>
  `,
    styleUrls: ['./home.css']
})
export class Home {

    hotelOptionList: NewHotelInterface[] = [];
    filteredHotelOptionList: NewHotelInterface[] = [];
    hotelService: HotelService = inject(HotelService);

    constructor() {
        this.hotelService.getAllNewHotelOptions()
            .then((hotelOptionList: NewHotelInterface[]) => {
                this.hotelOptionList = hotelOptionList;
                this.filteredHotelOptionList = hotelOptionList;
            });
    }

    filterResults(text: string) {

        if (!text) {
            this.filteredHotelOptionList = this.hotelOptionList;
            return;
        }

        this.filteredHotelOptionList = this.hotelOptionList.filter((hotelOption) =>
            hotelOption?.hotel_location.toLowerCase().includes(text.toLowerCase())
        );

    }
}
