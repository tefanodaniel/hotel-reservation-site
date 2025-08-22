import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { HotelDetails } from "./hotel-details/hotel-details"

const routeConfig: Routes = [
    {
        path: '',
        component: Home,
        title: 'Home page',
    },
    {
        path: 'details/:id',
        component: HotelDetails,
        title: 'Hotel details',
    },
];
export default routeConfig;