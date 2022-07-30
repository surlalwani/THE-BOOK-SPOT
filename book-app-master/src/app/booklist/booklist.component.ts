import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { bookservice } from '../bookservice.service';
import { SearchbookComponent } from '../searchbook/searchbook.component';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
 

  @Input()
  Book: Book;
  constructor(private bookservice:bookservice,private router:Router) { }

  @Input()
  favoritedata: boolean;

  @Output()
  addToFavoriteList = new EventEmitter();
  
  ngOnInit(): void {
  }


  addToFavorite(book: Book) {
    console.log(book)
    this.addToFavoriteList.emit(book);
    console.log("clicked add to favourite...");

  }
  deleteFromFavourite(book: Book){
    console.log("clicked deleted to favourite...");
    console.log(book);
    this.bookservice.deleteBookFromFavouriteList(book).subscribe((data: any)=>{console.log(data);
    })
  }
  
}
