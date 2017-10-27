import { Component, NgModule, OnInit, Pipe } from '@angular/core'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { BrowserModule } from '@angular/platform-browser'
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AppComponent } from './app';
import { dealerLeads, feature, shareService, MessageService } from './models';
import { navComponent } from './navigation';
import { SubscribeComponent } from './subscribecomponent';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './homecomponent';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { dealerservice } from './dealerService';
import { ResourceComponent } from './resources';
import { AddResourceComponent } from './addresource';
import { AddInventoryComponent } from './addinventory';
import { InventoryComponent } from './inventory';
import { leftPanelComponent } from './leftpanel';
import { SellVehicleComponent } from './sellvehicle';
import { LeadView } from './leadview';
import { LeadInformation } from './leaddetails';
import { Leads } from './leadinfo';
import { DealerContext } from './dealercontext';


const appRoutes: Routes = [
    //{path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: 'home.html', component: HomeComponent },
    { path: 'home', component: HomeComponent },
    { path: 'subscribe', component: SubscribeComponent },
    { path: 'resources', component: ResourceComponent },
    { path: 'addresource', component: AddResourceComponent },
    { path: 'addinventory', component: AddInventoryComponent },
    { path: 'inventory', component: InventoryComponent },
    { path: 'leadview', component: LeadView },
    { path: 'leads', component: Leads },
    { path: 'lead-info', component: LeadInformation },
    { path: 'login', component: DealerContext },
    { path: '**', component: HomeComponent }
];

@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes), NgbModule.forRoot(), ReactiveFormsModule],
    declarations: [AppComponent, navComponent, SubscribeComponent, HomeComponent, ResourceComponent, AddResourceComponent, AddInventoryComponent, InventoryComponent, leftPanelComponent
        , SellVehicleComponent, LeadView, LeadInformation, Leads, DealerContext
    ],
    providers: [dealerservice, dealerLeads, feature, shareService, MessageService],
    bootstrap: [AppComponent]
})

export class AppModule { }