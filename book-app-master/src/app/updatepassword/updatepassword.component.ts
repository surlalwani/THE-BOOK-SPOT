import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { bookservice } from '../bookservice.service';
import { User } from '../User';

@Component({
  selector: 'app-updatepassword',
  templateUrl: './updatepassword.component.html',
  styleUrls: ['./updatepassword.component.css']
})
export class UpdatepasswordComponent implements OnInit {
  user:User
  disp_msg: string;
  constructor(private bookservice: bookservice, private router: Router) {
    this.user= new User()
   }

  ngOnInit(): void {
  }
  updatePassword(){
   // console.log(this.user)
    console.log(environment.username+"inupdate")
    this.bookservice.updatePassword(this.user,environment.username).subscribe({
      next:(data: any)=>{this.disp_msg="Congratulatins "+this.user.username+" your password updated successfully";this.router.navigate(["/header"])},
      error:(e: any)=>{console.log(e);this.disp_msg="Failed to update your pasword"
      ;
      }
    })
  }
}
