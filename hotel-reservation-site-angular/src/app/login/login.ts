import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  imports: [],
  template: `
    <section>
        <h1>Login</h1>
        <input type="text" placeholder="username" #username/>
        <input type="text" placeholder="password" #password/>
        <button class="primary" type="button" (click)="submitLogin(username.value, password.value)">Login</button>
    </section>
  `,
  styles: ``
})
export class Login {
    submitLogin(username: string, password: string) {
        console.log(username, password);
    }
}