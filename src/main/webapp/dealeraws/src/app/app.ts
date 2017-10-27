import { Component, OnInit, OnDestroy, ElementRef } from '@angular/core';
import { HttpModule } from '@angular/http';
import { shareService, UIStorage, userContext, MessageService } from './models';
import { Subscription } from 'rxjs/Subscription';

@Component({
    selector: 'my-app',
    templateUrl: 'src/views/index.html',
    host: {
        '(document:click)': 'onClick($event)',
    }
})

export class AppComponent {

    subscription: Subscription;
    isProfile: boolean = false;
    private loader: any;
    private userCtxt: any = {};
    constructor(private shareservice: shareService, private messageService: MessageService, private eref: ElementRef) {

        this.shareservice = new shareService();
        this.loader = shareservice.loader;
        //this.subscription = this.shareservice.getLogged().subscribe(p => { this.userontext = p; });
        this.subscription = this.messageService.getMessage().subscribe(p => { this.userCtxt = p; });

    }

    onClick(event: any) {
        //if (!this.eref.nativeElement.contains(event.target)) // or some similar check
        if (!this.isProfile) {
            this.userCtxt.showProfile = false;
        }
        this.isProfile = false;
    }

    ngOnInit() {


        //let l_dealerId = UIStorage.getCookie('dealerId');
        //if (l_dealerId != undefined && l_dealerId != null) {
        //    this.usercontext.isLoggedIn = true;
        //} else
        //    this.usercontext.isLoggedIn = false;

    }

    logout() {
        this.userCtxt.isLoggedIn = false;
        UIStorage.deleteCookie('dealerId');
    }
    showprofile() {
        this.userCtxt.showProfile = true;
        this.isProfile = true;
    }
    ngOnDestroy() {
        // unsubscribe to ensure no memory leaks
        this.subscription.unsubscribe();
    }
}