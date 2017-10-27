import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { LeadDetails, shareService, dealerInfo, UserInfoCheck, MakeModel, userContext } from './models';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
    selector: 'leadview',
    templateUrl: 'src/views/leadview.html'
})


export class LeadView {
    private states: any = [];
    constructor(private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:

    }
    private userinfocheck: UserInfoCheck = new UserInfoCheck(); private usercontext: userContext; private makemodel: MakeModel;
    private leaddetails: LeadDetails = new LeadDetails();

    ngOnInit() {
        let leadId = sessionStorage.getItem('leadid');
        if (leadId != undefined)
            this.getleadinfo(leadId);
        sessionStorage.removeItem('leadid');
        //this.gettempData();
    }

    getleadinfo(leadid: any) {
        try {
            this.shareservice.showLoader();
            this._service.getlead(leadid).subscribe(
                data => {
                    this.shareservice.hideLoader();
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        this.leaddetails = l_response;
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
        this.leaddetails.leadId = 'LD1002';
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
    }


}