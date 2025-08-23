import { Injectable } from '@angular/core';
import { HotelInterface } from './hotel-interface';
import { NewHotelInterface } from './new-hotel-interface';


@Injectable({
  providedIn: 'root'
})
export class HotelService {

    readonly baseUrl = 'https://angular.dev/assets/images/tutorials/common';

    dataUrl = 'http://localhost:8080/hotels';

    hotelOptionList: HotelInterface[] = [
        {
            id: 0,
            name: 'Acme Fresh Start Housing',
            city: 'Chicago',
            state: 'IL',
            photo: `${this.baseUrl}/bernard-hermant-CLKGGwIBTaY-unsplash.jpg`,
            availableUnits: 4,
            wifi: true,
            laundry: true,
        },
        {
            id: 1,
            name: 'A113 Transitional Housing',
            city: 'Santa Monica',
            state: 'CA',
            photo: `${this.baseUrl}/brandon-griggs-wR11KBaB86U-unsplash.jpg`,
            availableUnits: 0,
            wifi: false,
            laundry: true,
        },
        {
            id: 2,
            name: 'Warm Beds Housing Support', city: 'Juneau', state: 'AK', photo: `${this.baseUrl}/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg`, availableUnits: 1, wifi: false, laundry: false,
        },
        {
            id: 3,
            name: 'Homesteady Housing', city: 'Chicago', state: 'IL', photo: `${this.baseUrl}/ian-macdonald-W8z6aiwfi1E-unsplash.jpg`, availableUnits: 1, wifi: true, laundry: false,
        },
        {
            id: 4,
            name: 'Happy Homes Group', city: 'Gary', state: 'IN', photo: `${this.baseUrl}/krzysztof-hepner-978RAXoXnH4-unsplash.jpg`, availableUnits: 1, wifi: true, laundry: false,
        },
        {
            id: 5,
            name: 'Hopeful Apartment Group', city: 'Oakland', state: 'CA', photo: `${this.baseUrl}/r-architecture-JvQ0Q5IkeMM-unsplash.jpg`, availableUnits: 2, wifi: true, laundry: true,
        },
        {
            id: 6,
            name: 'Seriously Safe Towns', city: 'Oakland', state: 'CA', photo: `${this.baseUrl}/phil-hearing-IYfp2Ixe9nM-unsplash.jpg`, availableUnits: 5, wifi: true, laundry: true,
        },
        {
            id: 7,
            name: 'Hopeful Housing Solutions',
            city: 'Oakland',
            state: 'CA',
            photo: `${this.baseUrl}/r-architecture-GGupkreKwxA-unsplash.jpg`,
            availableUnits: 2,
            wifi: true,
            laundry: true,
        },
        {
            id: 8,
            name: 'Seriously Safe Towns',
            city: 'Oakland',
            state: 'CA',
            photo: `${this.baseUrl}/saru-robert-9rP3mxf8qWI-unsplash.jpg`,
            availableUnits: 10,
            wifi: false,
            laundry: false,
        },
        {
            id: 9,
            name: 'Capital Safe Towns', city: 'Portland', state: 'OR', photo: `${this.baseUrl}/webaliser-_TPTXZd9mOo-unsplash.jpg`, availableUnits: 6, wifi: true, laundry: true,
        }
    ]

    newHotelOptionListLocal: NewHotelInterface[] = [
        {
            hotel_id: 4,
            hotel_name: "Ramses Hilton Hotel",
            hotel_city: "Cairo",
            hotel_stars: "5",
            hotel_location: "https://goo.gl/maps/LEy98S7EHX5mcnQZ6",
            hotel_distance: "50",
            hotel_phone: "01129348206",
            hotel_price_min: "100",
            hotel_price_max: "500",
            hotel_avg_rate: "300",
            hotel_availability: "All week"
        },
        {
            hotel_id: 5,
            hotel_name: "The Luxury Collection Hotels & Resorts.",
            hotel_city: "Giza",
            hotel_stars: "4",
            hotel_location:	"https://goo.gl/maps/LEy98S7EHX5mcnQZ6",
            hotel_distance:	"150",
            hotel_phone: "01129348206",
            hotel_price_min: "250",
            hotel_price_max: "1000",
            hotel_avg_rate: "625",
            hotel_availability:	"From Sat to Thr"
        },
        {
            hotel_id: 6,
            hotel_name: "Rosewood Hotels & Resorts.",
            hotel_city: "Cairo",
            hotel_stars: "5",
            hotel_location: "https://goo.gl/maps/LEy98S7EHX5mcnQZ6",
            hotel_distance: "100",
            hotel_phone: "01129348206",
            hotel_price_min: "150",
            hotel_price_max: "800",
            hotel_avg_rate: "475",
            hotel_availability: "All week"
        }
    ]

    getAllHotelOptions(): HotelInterface[] {
        return this.hotelOptionList;
    }

    getHotelOptionById(id: number): HotelInterface | undefined {
        return this.hotelOptionList.find((hotelOption) => hotelOption.id === id)
    }

    async getAllNewHotelOptions(): Promise<NewHotelInterface[]> {
        const data = await fetch(this.dataUrl);
        return (await data.json()) ?? [];
    }

    async getNewHotelOptionById(id: number): Promise<NewHotelInterface | undefined> {
        const data = await fetch(`${this.dataUrl}?id=${id}`);
        const hotelJson = await data.json();
        return hotelJson[0] ?? {};
    }
}
