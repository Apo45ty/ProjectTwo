import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DatabaseGetterService } from './database-getter.service';
import { AppRoutingModule,routingComponents} from './app-routing.module';
import { DisplayResultsComponent } from './display-results/display-results.component';
import { DisplayGraphAndResultComponent } from './display-graph-and-result/display-graph-and-result.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    DisplayResultsComponent,
    DisplayGraphAndResultComponent,
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	AppRoutingModule
  ],
  providers: [DatabaseGetterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
