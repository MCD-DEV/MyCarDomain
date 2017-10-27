import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { shareService, UIStorage } from './models';
import { VehicleQuotation, VehQuotDoc, VehQuotExtras, VehQuotTerm, OfferDateList} from './servermodels';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
    selector: 'leadinfo',
    templateUrl: 'src/views/leaddetails.html'
})


export class LeadInformation {
    private states: any = [];
    private selectedMake: string;
    private selectedModel: string;
    private selectedVariant: string;
    private makes: any = [];
    private models: any = [];
    private variants: any = [];
    private autotrims: any = [];
    private quote: VehicleQuotation = new VehicleQuotation();
    quGroup: FormGroup;

    constructor(private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:

    }
    ngOnInit() {
        this.formValidation();
    }
    formValidation() {
        this.quGroup = this.formBuilder.group({

            quoteGroup: this.formBuilder.group({
                driveAwayPrice: [],
                basicPrice: [],
                offerPrice2: [],
                offerPrice3: [],
                autoscpStockNo: [],
                stockTillAvail: [],
                dealStockNo: [],
                stateRate: [''],
                regionRate: [''],
                postRate: [''],
                stateRoute: [''],
                regionRoute: [''],
                postRoute: [''],
                modelYear: [],
                modelDisplay: [],
                modelName: [],
                modelTrim: [],
            })
        });
    }
    deletedetails(indx: number, items: any) {
        items.splice(indx, 1);
    }
    onyearselect(value: any) {
        this.getmakes();
    }
    onmakeselect(value: any) {
        this.selectedMake = value;
        this.getmodels();
    }
    onmodelselect(value: any) {
        this.selectedModel = value;
        this.getvariants();
    }

    adddetails(type: string) {
        switch (type) {
            case 'details':
                this.quote.vehQuotExtras.push(new VehQuotExtras());
                break;
            case 'dates':
                this.quote.offerDateList.push(new OfferDateList());
                break;
            case 'docs':
                this.quote.vehQuotDoc.push(new VehQuotDoc());
                break;
            case 'terms':
                this.quote.vehQuotTerm.push(new VehQuotTerm());
                break;

        }
    }
    //onvariantselect(value: any) {
    //    this.selectedvariant = value;
    //    this.getautotrim();
    //}
    setmakemodelvariant() {
        //this.selectedMake = this.inventory.modelDisplay;
        //this.selectedModel = this.inventory.modelName;
        //this.selectedVariant = this.inventory.modelTrim;
        this.getmakes();
        this.getmodels();
        this.getvariants();
        this.getautotrim();
    }

    getmakes() {
        try {
            if (this.makes == undefined || !this.makes.length)
                this.shareservice.showLoader();
            this._service.getmakes(2017).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.makes = l_response;
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
    getmodels() {
        try {
            this.shareservice.showLoader();
            this._service.getmodels(2017, this.selectedMake).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.models = l_response;
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


    getvariants() {
        try {
            this.shareservice.showLoader();
            this._service.getvariants(2017, this.selectedMake, this.selectedModel).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.autotrims = l_response;
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
    getautotrim() {
        try {
            this.shareservice.showLoader();
            this._service.getvariants(2017, this.selectedMake, this.selectedModel).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.autotrims = l_response;
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


}