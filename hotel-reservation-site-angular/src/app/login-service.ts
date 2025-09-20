import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

    dataUrl = 'http://localhost:8080/login';

    async login(username: string, password: string) {
        const res = await fetch(`${this.dataUrl}?username=${username}&?password=${password}`);
        const hotelJson = await res.json();
        return hotelJson[0] ?? {};
    }

    isLoggedin() {
        return true;
    }

    logout() {
        console.log("You've been logged out!")
    }
}
