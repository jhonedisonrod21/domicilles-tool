import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './app.login.html',
  styleUrls: ['./app.login.css']
})
export class AppLogin implements OnInit {
  title = 'app';
  results: string[];

  constructor(private http: HttpClient, public router: Router) {}

  ngOnInit(): void {
  }

  validateLogin() {
    var userName = (<HTMLInputElement> document.getElementById("user_name"));
    var password = (<HTMLInputElement> document.getElementById("password"));
    const body = {userName: userName.value, password: password.value};
    this.http.post('http://localhost:4567/Login', body).subscribe(data => {
      if (data['loginSuccess'] === true) {
        alert("Conectado");
        this.router.navigate(['/home']);
      }else {
        alert("usuario o contraseña incorrectos");
      }
    });
  }
}
