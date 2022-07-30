import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { bookservice } from '../bookservice.service';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  books: Array<Book>;
  favoritedata: boolean = true;

  constructor(private bookservice:bookservice,private router:Router) { }

  ngOnInit(): void {
    this.bookservice.getFavoriteList().subscribe(data => {
      this.books = data;
    });

  }
}
