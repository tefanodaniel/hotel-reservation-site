import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { HotelDetails } from "./hotel-details/hotel-details"
import { Login } from "./login/login";

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
    {
        path: 'login',
        component: Login,
        title: "Login",
    }
];
export default routeConfig;