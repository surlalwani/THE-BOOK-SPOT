
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../book';

import{ bookservice } from '../bookservice.service'
@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {

  books: Array<Book> = [];
  searchcountry: Array<Book> = [];
  idd: number;
  name: string;
  key:string;
  top_work:string;
  work_count:string
  countryObj: Book;
  statusCode: number;
  errorStatus: string;
 


  constructor(private routes: ActivatedRoute, private bookservice: bookservice) { 
    bookservice.pnameFromkey=this.name
    bookservice.pidFromkey=this.key
  }

  ngOnInit(): void {

    this.bookservice.getAllBookList()
    .subscribe(vari => {
      console.log(vari);
      const data = vari;
      console.log(data);

      console.log(data.docs[1].name);

        this.idd = 0;
        data.docs.forEach((element: any) => {
          console.log(element);


          this.idd++;
          this.countryObj = new Book();
          console.log('hh'+data.docs[1].name)
          this.countryObj.name = data.docs[this.idd].name;
          this.countryObj.key = data.docs[this.idd].key;
          // this.playerObj.name = element["name"];
          this.countryObj.top_work=data.docs[this.idd].top_work;
          // console.log( this.playerObj.pid );
          this.countryObj.work_count=data.docs[this.idd].work_count
          ;
          // console.log(this.playerObj);



          this.books.push(this.countryObj);
          //  console.log(this.cplayers);


        });
      });
  }

  onKey(event: any) {



    if (event.keyCode == 13) {
      this.books = [];
      this.name = event.target.value;

      console.log('countryname', this.name);
      this.bookservice.pnameFromkey=this.name;
      console.log(this.bookservice.pnameFromkey);


      this.bookservice.getBookList(this.name)
        .subscribe(vari => {
          // console.log(player);
          const data = vari;

          this.idd = 0;
          data.docs.forEach((element: any) => {

            this.idd++;
            this.countryObj = new Book();
            console.log(this.bookservice.pnameFromkey +'khdvbdk');
            
            if(data.docs[this.idd].name.toUpperCase()===this.bookservice.pnameFromkey.toUpperCase()){
            this.countryObj.name = data.docs[this.idd].name;
            this.countryObj.key = data.docs[this.idd].key;
            // this.playerObj.name = element["name"];
            this.countryObj.top_work=data.docs[this.idd].top_work

            this.countryObj.work_count=data.docs[this.idd].work_count
            this.books.push(this.countryObj);
            this.searchcountry.push(this.countryObj);
            console.log(this.countryObj.key);
            this.bookservice.pidFromkey=this.countryObj.key;
            console.log("mc id:"+this.bookservice.pidFromkey);


            console.log(this.searchcountry);}

          });
        });
    }
  }
  addToFavoriteList(ccountry: Book) {
    console.log(ccountry);
    
    this.bookservice.addBookToFavoriteList(ccountry).subscribe(
      {next:data=>
        {console.log(data);

    },
    error:e=>
    {this.errorStatus = `${e.status}`;
    const errorMsg = `${e.error.message}`;
    this.statusCode = parseInt(this.errorStatus, 10);}})
  }
  addToFavorite(ccountry: Book) {
    console.log(ccountry)
    this.addToFavoriteList(ccountry);
    console.log("clicked add to favourite...");

  }
  deleteFromFavourite(ccountry: Book){
    console.log("clicked deleted to favourite...");
    console.log(ccountry);
    this.bookservice.deleteBookFromFavouriteList(ccountry).subscribe(data=>{console.log(data);
    })
  }

}


