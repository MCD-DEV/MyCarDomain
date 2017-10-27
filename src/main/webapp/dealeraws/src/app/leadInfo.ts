import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { LeadDetails, shareService, dealerInfo, UserInfoCheck, MakeModel, userContext, Quote, UIStorage } from './models';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
    selector: 'lead-s',
    templateUrl: 'src/views/lead.html'
})


export class Leads {
    private leads: Array<LeadDetails> = [];
    constructor(private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:

    }
    private userinfocheck: UserInfoCheck = new UserInfoCheck(); private usercontext: userContext; private makemodel: MakeModel;
    private leaddetails: LeadDetails = new LeadDetails();
    private dealerId;
    ngOnInit() {
        let l_dealerId = UIStorage.getCookie('dealerId');
        if (l_dealerId != undefined && l_dealerId != null) {
            this.dealerId = l_dealerId;
            this.getleads(l_dealerId);
        }
        //this.gettempData();
    }
    goto(item: any, type:string) {
        sessionStorage.setItem('leadid', item.dealerSearchId);
        if (type == 'view') {
            this.getquotes(item.dealerSearchId, this.dealerId);
            this.router.navigate(['/leadview']);
        }
        if (type == 'edit')
            this.router.navigate(['/lead-info']);
    }
    getleads(l_dealerId: any) {
        try {
            this.shareservice.showLoader();
            this._service.getleads(l_dealerId).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.leads = l_response;
                    }
                },
                err => {
                    this.shareservice.hideLoader();
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
    }
    getquotes(leadid:any, l_dealerId: any) {
        try {
            this.shareservice.showLoader();
            this._service.getquotes(leadid, l_dealerId).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.leads = l_response;
                    }
                },
                err => {
                    this.shareservice.hideLoader();
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
    }

    gettempData() {
        this.leaddetails.leadId = 'LD1000001';
        this.leaddetails.generatedDate = '09/18/2017';
        this.leaddetails.newused = 'New';
        this.leaddetails.makemodel.year = 2017;
        this.leaddetails.makemodel.make = 'Honda';
        this.leaddetails.makemodel.model = 'City';
        this.leaddetails.makemodel.autoscoopTrim = 'City | VTi | GM Series  | 1497 Eng | 4 Cyl | 1 Gr | Petro ULP | 2WD | 5 Seats | 4 Drs  | Sedan | Auto CVT | 2017';
        this.leaddetails.mainColour = 'White';
        this.leaddetails.mainColour = 'Grey';
        this.leaddetails.additionalDetails = 'Additional text goes here';
        this.leaddetails.estimatedDate = '12/10/2017';
        this.leaddetails.userinfocheck.creditcardCheck = 'No';
        this.leaddetails.userinfocheck.idCheck = 'Yes';
        this.leaddetails.userinfocheck.mobileCheck = 'Yes';
        this.leaddetails.userinfocheck.finance = 'Yes';
        this.leaddetails.userinfocheck.vehicleSellSwap = 'No';
        let quote: Quote = new Quote();
        quote.quoteId = 'ASC000000007';
        this.leaddetails.quotes.push(quote);
        this.leads.push(this.leaddetails);
        quote = new Quote();
        quote.quoteId = 'ASC000000008';
        this.leaddetails.leadId = 'LD1000002';
        this.leaddetails.quotes.push(quote);
        this.leads.push(this.leaddetails);
        quote = new Quote();
        quote.quoteId = 'ASC000000009';
        this.leaddetails.quotes.push(quote);
        this.leaddetails.leadId = 'LD1000003';
        this.leads.push(this.leaddetails);


    }


}