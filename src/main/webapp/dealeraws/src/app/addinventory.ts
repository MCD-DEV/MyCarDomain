import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { inventory, feature, shareService, UIStorage } from './models';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { customvalidations } from './customvalidations';



@Component({
    selector: 'add-inventory',
    templateUrl: 'src/views/addinventory.html'
})


export class AddInventoryComponent {


    private inventories: any = [];
    private dealerId: any;
    private isRegistered: boolean;
    private inventory: inventory = new inventory();
    private carExtraList: any = [];
    private selectedBanners: any = [];
    private featureList: any = [];
    private isRego: boolean;
    private states: any;
    private id: any;
    private isDriveAway: boolean = undefined;
    private isPrice: boolean = undefined;
    private pricingTypes: any = [];
    private makes: any = [];
    private models: any = [];
    private variants: any = [];
    private autotrims: any = [];
    constructor(private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {

    }
    inventoryGroup: FormGroup;
    registrationGroup: FormGroup;
    ngOnInit() {
        let l_dealerId = UIStorage.getCookie('dealerId');
        if (l_dealerId != undefined && l_dealerId != null)
            this.dealerId = l_dealerId;
        this.states = ["ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA"];
        this.formValidation();
        this.getVehicleExtras();
        this.edit();
        this.inventories = shareService.inventories;
        this.pricingTypes = [{ name: 'Fixed', displayName: 'Fixed' }, { name: 'Negotiable', displayName: 'Negotiable' }, { name: 'Range', displayName: 'Price Range' }];
    }
    tes() {
        //'email': ['', Validators.compose([Validators.required, Validators.pattern(/^\w+[\w-\.]*\@\w+((-\w+)|(\w*))\.[a-z]{2,3}$/)])],
        //    'phn': ['', Validators.compose([Validators.required, Validators.pattern(/^610[0-8]\d{8}$/g)])]
        //'txt': ['', Validators.compose([Validators.required, Validators.pattern(/^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/)])],
    }
    formValidation() {
        this.inventoryGroup = this.formBuilder.group({

            vehicleDescriptin: ['', Validators.required],

            vinNumber: ['', [Validators.required, Validators.minLength(2)]],
            vendorStockNo: ['', [Validators.required, Validators.minLength(2)]],
            stockItem: [''],
            price: [{ value: '' }],
            dealAmountMin: [{ value: '' }],
            dealAmountMax: [{ value: '' }],
            extColour: [null],
            intColour: [null],
            roadWorthIncluded: [''],
            isVehicleUsed: [''],
            regNo: [''],
            state: [null],
            regExpiryDate: [''],
            isNewCar: [],
            isUsedCar: [],
            demo: [],
            modelYear: [],
            modelDisplay: [],
            modelName: [], modelTrim: [],
            variant: [],
            autoQuote: [],
            classified: [],
            details: [],
            newCar: [],
            negotiablePercent: [],
            kilometer: []
        }, { validator: this.validateNewUsed });//, { validator: this.validatePriceRange }   Validators.compose([Validators.required, this.checkIfA])

    }

    validateNewUsed(formgroup: FormGroup) {
        return (formgroup.controls["isNewCar"]['_value'] == undefined || formgroup.controls["isUsedCar"]['_value'] == undefined)
            ? { 'required': true } : null;
    }
    validatePriceRange(formgroup: FormGroup) {
        return ((formgroup.controls["minPrice"]['_value'] != undefined && formgroup.controls["maxPrice"]['_value'] == undefined) || (formgroup.controls["minPrice"]['_value'] == undefined && formgroup.controls["maxPrice"]['_value'] != undefined))
            ? { 'required': true } : null;
    }

    getinvbyId() {
        this.inventoryGroup.patchValue({
            vehicleDescriptin: this.inventory.vehicleDescriptin,

            vinNumber: this.inventory.vinNumber,
            vendorStockNo: this.inventory.vendorStockNo,
            isNewCar: this.inventory.typeOfCar == 'New' ? true : false,
            isUsedCar: this.inventory.typeOfCar == 'Used' ? true : false,// == 'Used' ? true : false,
            stockItem: this.inventory.stockItem,
            price: this.inventory.price,
            dealAmountMin: this.inventory.dealAmountMin,
            dealAmountMax: this.inventory.dealAmountMax,
            extColour: this.inventory.extColour,
            intColour: this.inventory.intColour,
            roadWorthIncluded: this.inventory.roadWorthIncluded,
            newCar: this.inventory.newCar,
            regNo: this.inventory.regNo,
            state: this.inventory.state,
            regExpiryDate: this.inventory.regExpiryDate,
            details: this.inventory.details,
            demo: this.inventory.demo,
            negotiablePercent: this.inventory.negotiablePercent,
            autoQuote: this.inventory.autoQuote,
            classified: this.inventory.classified,
            kilometer: this.inventory.kilometer,
            modelYear: this.inventory.modelYear,
            modelDisplay: this.inventory.modelDisplay,
            modelName: this.inventory.modelName,
            modelTrim: this.inventory.modelTrim,
            variant: this.inventory.variant
        });
        this.setmakemodelvariant();
        if (this.inventory.regNo != undefined && this.inventory.regNo != '')
            this.isRego = true;
        if (this.inventory.quotationFeatList) {
            let featrs = this.inventory.quotationFeatList;
            for (var i = 0; i < featrs.length; i++) {
                let l_veh = this.carExtraList.filter(function (p: any) { return p.name == featrs[i].featName });
                if (l_veh != undefined && l_veh.length)
                    l_veh[0].isChecked = true;
            }
        }
    }

    setmakemodelvariant() {
        this.selectedMake = this.inventory.modelDisplay;
        this.selectedModel = this.inventory.modelName;
        this.selectedvariant = this.inventory.modelTrim;
        this.getmakes();
        this.getmodels();
        this.getvariants();
        this.getautotrim();
    }

    edit() {
        let l_id = sessionStorage.getItem('invid');
        if (l_id != undefined) {
            this.inventory.id = +l_id;
            this.id = +l_id;
            sessionStorage.removeItem('invid');
            this.getinventory(+l_id);

        }
    }

    carNewChanged($event: any) {
        this.inventoryGroup.controls['isUsedCar'].setValue(!$event);
    }

    carOldChanged($event: any) {
        this.inventoryGroup.controls['isNewCar'].setValue(!$event);
    }

    regoChangeYes($event: any) {
        this.isRego = $event;
    }
    private isFixed: boolean = true;
    private isNegotiable: boolean;
    private isRange: boolean;

    pricingCheck(name: any) {
        // clone the object for immutability
        //this.selectedPrice = Object.assign({}, this.selectedPrice, type);

        if (name == 'Fixed') {
            this.isNegotiable = false;
            this.isRange = false;
            this.isFixed = true;
        }
        else if (name == 'Negotiable') {
            this.isFixed = true;
            this.isNegotiable = true;
            this.isRange = false;
        }
        else if (name == 'Range') {
            this.isRange = true;
            this.isFixed = false;
            this.isNegotiable = false;
        }
    }

    getImage(event: any) {
        if (event.target.files && event.target.files[0]) {
            var reader = new FileReader();
            reader.onload = (event: any) => {
                this.images.push({ name: '', url: event.target.result });
            }
            reader.readAsDataURL(event.target.files[0]);
        }
    }

    private isOpen: boolean = false;
    private images: any = [];

    showLeftPanel() {
        this.shareservice.isOpen = (this.shareservice.isOpen) ? false : true;
    }
    regoChange($event: any) {
        let l_isRego = $event.target;
        if (l_isRego != undefined) {
            this.isRego = l_isRego.checked;
        }
        //throw new Error(`Expected validator to return Promise or Observable.`);
    }
    getVehicleExtras() {

        this.carExtraList = [{ name: 'Bull Bar', isChecked: false }, { name: 'Nudge Bar', isChecked: false }, { name: 'Side Step', isChecked: false },
        { name: 'Snorkel', isChecked: false }, { name: 'Tow Bar', isChecked: false },
        { name: 'Floor Mats', isChecked: false }, { name: 'Tinted Glass', isChecked: false },
        { name: 'Luggage & Cargo Accessories', isChecked: false }, { name: 'Applicable Roof Racks', isChecked: false },
        { name: 'Tow Accessories', isChecked: false }, { name: 'Seat Cover', isChecked: false },
        { name: 'Bonnet Protection', isChecked: false }, { name: 'Head Lamp Protection', isChecked: false },
        { name: 'Weather Shield', isChecked: false }, { name: 'Medical / first-aid Kit', isChecked: false }, { name: 'Safety Kit', isChecked: false }];

    }
    onbannerselect(banner: any) {
        let indx = this.selectedBanners.findIndex((p: any) => p === banner.name);
        if (indx != -1) {
            this.selectedBanners.splice(indx, 1);
        } else
            this.selectedBanners.push(banner.name);
    }
    updateinventory(item: any) {
        sessionStorage.setItem('reourceid', item.id);
    }

    selectedMake: string;
    selectedModel: string;
    selectedvariant: string;

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
    onvariantselect(value: any) {
        this.selectedvariant = value;
        this.getautotrim();
    }
    deleteinventory(item: any) {
        try {
            this._service.deleteresource(item.id).subscribe(
                data => {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                    }
                },
                err => {
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
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
                        this.variants = l_response;
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

    getinventory(invid: number) {
        try {
            this.shareservice.showLoader();
            this._service.getinventory(invid).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.inventory = l_response;
                        this.getinvbyId();
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

    setinventory() {
        this.inventory = this.inventoryGroup['_value'];
        this.inventory.typeOfCar = this.inventoryGroup.controls['isNewCar']['_value'] == false ? 'Used' : 'New';
        //this.inventory.extras = this.selectedBanners;
        if (this.inventory.quotationFeatList == undefined)
            this.inventory.quotationFeatList = [];
        for (var i = 0; i < this.carExtraList.length; i++) {
            if (this.carExtraList[i].isChecked)
                this.inventory.quotationFeatList.push({ featName: this.carExtraList[i].name, featDes: this.carExtraList[i].name });
        }
        this.inventory.refId = this.dealerId;
        this.inventory.repoId = this.id;
    }

    saveinventory() {
        try {
            this.setinventory();
            //if (this.id == undefined) {
            //    this.inventory.id = (shareService.inventories.length + 1).toString();
            //    shareService.inventories.push(this.inventory);
            //}
            //else {
            //    this.inventory.id = this.id;
            //    shareService.inventories.splice((this.inventory.id - 1), 1, this.inventory);
            //}
            //this.router.navigate(['/inventory']);
            //return;
            this.shareservice.showLoader();
            this._service.saveinventory(this.inventory).subscribe(
                data => {
                    this.shareservice.hideLoader();
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        this.router.navigate(['/inventory']);
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
    getrecentaccounts() {
        try {

        }
        catch (_err) {
            console.log(_err);
        }
    }
}