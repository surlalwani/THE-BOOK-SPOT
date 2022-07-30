import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BooklistComponent } from './booklist/booklist.component';
import { HomeComponent } from './home/home.component';

//angular materials
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatMenuModule} from '@angular/material/menu';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { FavoriteComponent } from './favorite/favorite.component';
import { EdituserComponent } from './edituser/edituser.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { UserheadnavComponent } from './userheadnav/userheadnav.component';
import { UserfootnavComponent } from './userfootnav/userfootnav.component';
import { HomeheadnavComponent } from './homeheadnav/homeheadnav.component';
import { HomesearchcomponentComponent } from './homesearchcomponent/homesearchcomponent.component';
import { SearchComponent } from './search/search.component';
import { AboutComponent } from './about/about.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    SearchbookComponent,
    BooklistComponent,
    HomeComponent,
    FavoriteComponent,
    EdituserComponent,
    UpdatepasswordComponent,
    UserheadnavComponent,
    UserfootnavComponent,
    HomeheadnavComponent,
    HomesearchcomponentComponent,
    SearchComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,MatInputModule,MatDialogModule,MatSnackBarModule,
    AppRoutingModule,MatAutocompleteModule,
    MatToolbarModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatProgressBarModule,
    MatFormFieldModule,
    MatCardModule,
    MatTableModule,
    FormsModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
