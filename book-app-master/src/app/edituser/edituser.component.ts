import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { bookservice } from '../bookservice.service';
import { User } from '../User';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {
  user:User
  disp_msg: string;
  constructor(private bookservice: bookservice, private router: Router) { 
    this.user= new User()
  }

  ngOnInit(): void {
  }
  changedetails(){
    console.log(this.user)
    console.log(environment.username+"inedit")
    this.bookservice.changedetails(this.user,environment.username).subscribe({
      next:(data: any)=>{this.disp_msg="Congratulatins "+this.user.username+" your details changed successfully";this.logout()
      //this.router.navigate(["/header"])
    },
      error:(e: any)=>{console.log(e);this.disp_msg="Failed to change your account details"
      ;
      }
    })
  }
  logout(){
    console.log("heyy...I am logout")
    this.bookservice.logout();
   this.router.navigate(['/login']);

  }
}
