import { Component, inject } from '@angular/core';
import { HotelOption } from '../hotel-option/hotel-option';
import { HotelInterface } from '../hotel-interface';
import { HotelService } from '../hotel-service';

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

    hotelOptionList: HotelInterface[] = [];
    filteredHotelOptionList: HotelInterface[] = [];
    hotelService: HotelService = inject(HotelService);

    constructor() {
        this.hotelOptionList = this.hotelService.getAllHotelOptions();
        this.filteredHotelOptionList = this.hotelOptionList;
    }

    filterResults(text: string) {

        if (!text) {
            this.filteredHotelOptionList = this.hotelOptionList;
            return;
        }

        this.filteredHotelOptionList = this.hotelOptionList.filter((hotelOption) =>
            hotelOption?.city.toLowerCase().includes(text.toLowerCase())
        );

    }
}
