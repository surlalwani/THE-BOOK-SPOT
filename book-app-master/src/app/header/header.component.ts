import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import{ bookservice } from '../bookservice.service'
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  //user_name:any
  constructor(private bookservice:bookservice,private router:Router) { 
      //this.user_name=environment.USER_NAME
  }

  ngOnInit(): void {
    //this.user_name=localStorage.getItem(USER_NAME)
    //this.user_name=ccovidservice
    // this.user_name=localStorage.getItem("username")
    // environment.username=this.user_name
    // console.log(environment.username+"inheader")
  }
}