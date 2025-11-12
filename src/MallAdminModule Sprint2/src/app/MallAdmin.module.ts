 import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MallAdminComponent } from './MallAdmin.component';

@NgModule({
  declarations: [
    MallAdminComponent 
  ],
  imports: [
    BrowserModule,  
    FormsModule,    
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [MallAdminComponent] 
})
export class MallAdminModule {}
