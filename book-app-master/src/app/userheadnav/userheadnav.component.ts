import { Component, OnInit } from '@angular/core';
import { bookservice } from '../bookservice.service';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-userheadnav',
  templateUrl: './userheadnav.component.html',
  styleUrls: ['./userheadnav.component.css']
})
export class UserheadnavComponent implements OnInit {
  user_name:any
  constructor(private bookservice:bookservice,private router:Router) { }

  ngOnInit(): void {
    this.user_name=localStorage.getItem("username")
    environment.username=this.user_name
    console.log(environment.username+"inheader")
  }
  logout(){
    console.log("heyy...I am logout")
    // this.cplayerService.logout();
    // this.router.navigate(['/login']);
    this.bookservice.logout();
   this.router.navigate(['/']);

  }
}
