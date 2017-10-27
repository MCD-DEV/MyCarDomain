import { Component, OnInit } from '@angular/core'
import { HttpModule } from '@angular/http';
import { dealerLeads, dealerBasicInfo, shareService, dealer } from './models';
import {
    Dealer, VehicleDealerAreaOfOperPostCode, VehicleDealerAreaOfOperRegion, VehicleDealerAreaOfOperState, VehicleDealerDetails
    , VehicleDealerFinanceDetails, VehicleDealerInsuranceDetails, VehicleDealerMakeList, VehicleDealerServMaintDetails
} from './servermodels';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';




@Component({
    selector: 'subscribe',
    templateUrl: 'src/views/subscribe.html'
})


export class SubscribeComponent {

    private subscriptionType: string;
    private isMakeModeltab: boolean = false;
    private isBasicInfo: boolean = true;
    private isAreaOperation: boolean = false;
    private isRoutes: boolean = false;
    private isSubscription: boolean = false;
    private isPayment: boolean = false;
    private vehicleTypes: any = [];
    private selectedVehicleTypes: any = [];
    private states: any = [];
    private selectedState: string;
    private selectedstates: any = [];
    private aostates: any = [];
    private makes: any = [];
    private selectedmakes: any = [];
    private selectedmodels: any = [];
    private models: any = [];
    private regions: any = [];
    private fromRegions: any = [];
    private toRegions: any = [];
    private selectedregions: any = [];
    private postcodes: any = [];
    private fromPostcodes: any = [];
    private toPostcodes: any = [];
    private selectedpostcodes: any = [];
    private dealerBasicInfo: Dealer = new Dealer();
    private isOpen: boolean = false;
    basicGroup: FormGroup;
    transportGroup: FormGroup;
    private isVehicle: boolean;
    //private isSellVehicle: boolean;
    //private isLeaseVehicle: boolean;
    private isInsurance: boolean;
    private isFinance: boolean;
    private isSM: boolean;
    private isFuel: boolean;
    private isSpares: boolean;
    private isTransport: boolean;
    private isOthers: boolean;
    private insVehicleList: any = [];
    private headNo: string;
    private subscription: string;

    constructor(private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {
        //this.route
        //    .queryParams
        //    .subscribe(params => {
        //        this.subscriptionType = params['name'];
        //    });
    }

    ngOnInit() {
        this.insVehicleList = [{ name: 'Cars', selected: false }, { name: 'Boats', selected: false }, { name: 'Bikes', selected: false }, { name: 'Caravan', selected: false }, { name: 'Commercial', selected: false }, { name: 'Agri', selected: false }];
        this.vehicleTypes = [{ name: 'Cars', selected: false }, { name: 'Bikes', selected: false }, { name: 'Boats', selected: false }, { name: 'Caravans', selected: false }, { name: 'Commercial Vehicle', selected: false }, { name: 'Sports Vehicle', selected: false }, { name: 'Agricultural Vehicle', selected: false }];
        this.basicInfoValidate();
        let type = sessionStorage.getItem('subscriptiontype');
        if (type != undefined && type != null) {
            this.subscriptionType = type;
            this.setType(true);
            sessionStorage.removeItem('subscriptiontype');
        }
        this.setGroup();
        this.states = ["ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA"];

        this.getStates();
        this.getmakes();
        this.getmodels();
        //this.getRegion();
        //this.getPostCodes();
    }

    showLeftPanel() {
        this.shareservice.isOpen = (this.shareservice.isOpen) ? false : true;
    }

    basicInfoValidate() {
        this.transportGroup = this.formBuilder.group({
            transport: this.formBuilder.group({
                fromState: [null],
                toState: [null],
                fromRegion: [null],
                toRegion: [null],
                fromPost: [null],
                toPost: [null],
                stateRate: [''],
                regionRate: [''],
                postRate: [''],
                stateRoute: [''],
                regionRoute: [''],
                postRoute: ['']
            })
        });
        //this.financeGroup = this.formBuilder.group({
        //    afslNo: [''],
        //    authRepNo: [''],
        //    aclNo: [''],
        //    brokerLicenceNo: [''],
        //    insVehicles: [''],
        //    isLoanNewVeh: [''],
        //    isLoanUsedVeh: [''],
        //    allselected: []
        //});
        //this.insuranceGroup = this.formBuilder.group({
        //    afslNo: [''],
        //    authRepNo: [''],
        //    aclNo: [''],
        //    brokerLicenceNo: [''],
        //    insVehicles: [''],
        //    isComprehensive: [''],
        //    isThirdParty: [''],
        //    isThirdProperty: [''],
        //    allselected: []
        //});
        this.basicGroup = this.formBuilder.group({
            basicInfo: this.formBuilder.group({
                vehicleType: ['Car'],
                abnnumber: [''],
                licenceNumber: [''],
                streetName: [''],
                suborb: [''],
                postcode: [''],
                state: [null],
                website: [''],
                newCar: [''],
                usedCar: [''],
                dealerGroupName: [''],
                dealerType: [''],

                contactNumber2: [''],
                dealername: [''],
                designation: [''],
                delmobile: [''],
                landLine1: [],
                dob: [''],
                additionalInfo: [''],
                email: ['']
            }),

            serviceM: this.formBuilder.group({
                petrol: [''],
                diesel: [''],
                electric: [''],
                all1: [''],
                clientPlaceDriveMaybe: [''],
                clientPlaceDriveYes: [''],
                roadAssistance: [''],
                clientPlaceDriveNo: ['']
            }),
            finance: this.formBuilder.group({
                afslNo: [''],
                authRepNo: [''],
                aclNo: [''],
                brokerLicenceNo: [''],
                insVehicles: [''],
                loanNewVeh: [''],
                loanUsedVeh: [''],
                allselected: []
            }),
            insurance: this.formBuilder.group({
                afslNo: [''],
                authRepNo: [''],
                aclNo: [''],
                brokerLicenceNo: [''],
                insVehicles: [''],
                comprehensive: [''],
                thirdParty: [''],
                thirdProperty: [''],
                allselected: []
            })
        });
    }

    setGroup() {
        try {
            if (shareService.p_dealer != undefined) {
                let dealer: any = this.setdata();
                if (dealer != undefined) {
                    this.basicGroup.patchValue({
                        basicInfo: dealer,
                        serviceM: dealer,
                        transport: dealer,
                        finance: dealer,
                        insurance: dealer
                    });
                    if (this.subscriptionType == "Transport") {
                        this.transportGroup.patchValue({
                            transport: dealer
                        });
                    }
                    this.subscription = dealer.subscription;
                    if (dealer.vehicleDealerMakeList != undefined)
                        for (var i = 0; i < dealer.vehicleDealerMakeList.length; i++) {
                            this.selectedmakes.push(dealer.vehicleDealerMakeList[i].make);
                        }
                    if (dealer.vehicleDealerRegion != undefined)
                        for (var i = 0; i < dealer.vehicleDealerRegion.length; i++) {
                            this.selectedregions.push(dealer.vehicleDealerRegion[i].region);
                        }
                    if (dealer.vehicleDealerPostCode != undefined)
                        for (var i = 0; i < dealer.vehicleDealerPostCode.length; i++) {
                            this.selectedpostcodes.push(dealer.vehicleDealerPostCode[i].postCode);
                        }
                    if (dealer.vehicleDealerAreaOfOperState != undefined)
                        for (var i = 0; i < dealer.vehicleDealerAreaOfOperState.length; i++) {
                            this.selectedstates.push(dealer.vehicleDealerAreaOfOperState[i].state);
                        }
                    if (dealer.vehicleDealerInsDetails != undefined) {
                        let l_all;
                        for (var i = 0; i < dealer.vehicleDealerInsDetails.length; i++) {
                            let l_veh = this.insVehicleList.filter(function (p: any) { return p.name == dealer.vehicleDealerInsDetails[i].flex1 });
                            if (l_veh != undefined && l_veh.length)
                                l_veh[0].selected = true;
                            else
                                l_all = true;
                        }
                        if (l_all == undefined) {
                            if (this.subscriptionType == "Insurance")
                                this.basicGroup.controls['finance'].controls['sinsVehicles'].setValue(true);
                            if (this.subscriptionType == "Finance")
                                this.basicGroup.controls['finance'].controls['allselected'].setValue(true);

                        }
                    }
                }
            }
        }
        catch (err) {
            console.log(err);
        }
        //for (var i = 0; i < this.insVehicleList.length; i++) {
        //    let l_vhList;
        //    if (dealer.vehicleDealerFinanceDetails != undefined && dealer.vehicleDealerFinanceDetails.length && dealer.vehicleDealerFinanceDetails[0].insVehicles != undefined) {
        //        l_vhList = dealer.vehicleDealerFinanceDetails[0].insVehicles;
        //    }
        //    if (dealer.vehicleDealerInsuranceDetails != undefined && dealer.vehicleDealerInsuranceDetails.length && dealer.vehicleDealerInsuranceDetails[0].insVehicles != undefined) {
        //        l_vhList = dealer.vehicleDealerInsuranceDetails[0].insVehicles;
        //    }
        //    if (l_vhList != undefined && l_vhList.indexOf(this.insVehicleList[i].name) != -1)
        //        this.insVehicleList[i].selected = true;
        //}
    }




    setdata() {
        try {
            let subList: any = ['BuyVehicle', 'SellVehicle', 'LeaseVehicle', 'Insurance', 'Finance', 'Servicemaintenance', 'Fuel', 'Sparesaccessories', 'Transport', 'Others'];
            let l_unselected; let l_subtype = this.subscriptionType;
            l_unselected = shareService.p_dealer.vehicleDealerDetails.filter(function (p: any) { return p.subscriptionType == l_subtype });
            if (l_unselected != undefined)
                return l_unselected[0];
            else
                return {};
        }
        catch (err) {

        }
    }


    getheaderno(subtype: any) {
        if (subtype == 'sub')
            return (this.isFinance || this.isInsurance) ? 2 : 4;
        else if (subtype == 'payment') {

            if (this.isFinance || this.isInsurance)
                return 3;
            else
                return 5;
        }

    }
    onMakeSelect(make: any) {
        //let l_make = this.selectedmakes.map(function (e) { return e; }).indexOf(make.name);
        let indx = this.selectedmakes.findIndex(p => p.name === make.name);
        if (indx != -1) {
            this.selectedmakes.splice(indx, 1);
        } else
            this.selectedmakes.push(make.name);
    }
    onModelSelect(make: any) {
        //let l_make = this.selectedmakes.map(function (e) { return e; }).indexOf(make.name);
        let indx = this.selectedmodels.findIndex(p => p.name === make.name);
        if (indx != -1) {
            this.selectedmodels.splice(indx, 1);
        } else
            this.selectedmodels.push(make.name);
    }
    onstateSelect(state: any) {
        let indx = this.selectedstates.findIndex(p => p.name === state.name);
        if (indx != -1) {
            this.selectedstates.splice(indx, 1);
        } else
            this.selectedstates.push(state.name);

        this.getFilteredRegion(state.name);
    }
    onregionSelect(region: any) {
        let indx = this.selectedregions.findIndex(p => p.name === region.name);
        if (indx != -1) {
            this.selectedregions.splice(indx, 1);
        } else
            this.selectedregions.push(region.name);

        this.getFilteredPostCodes(this.selectedstates[0], this.selectedregions[0]);
    }
    onvehicleSelect(vhtype: any) {
        let indx = this.selectedVehicleTypes.findIndex((p: any) => p.name === vhtype.name);
        if (indx != -1) {
            this.selectedregions.splice(indx, 1);
        } else
            this.selectedregions.push(vhtype.name);
    }
    onpostcodeSelect(postcode: any) {
        let indx = this.selectedpostcodes.findIndex(p => p.name === postcode.name);
        if (indx != -1) {
            this.selectedpostcodes.splice(indx, 1);
        } else
            this.selectedpostcodes.push(postcode.name);
    }

    fromstatechange(value: any, l_type: string) {
        switch (l_type) {
            case 'tostate':
                this.fromRegions = this.getfromtoRegion(value, 'from');
                break;
            case 'fromstate':
                this.toRegions = this.getfromtoRegion(value, 'to');
                break;
            case 'toregion':
                let l_tostate = this.transportGroup.controls.transport.controls['toState'].value;
                this.fromPostcodes = this.getfromtoPostCodes(l_tostate, value, 'from');
                break;
            case 'fromregion':
                let l_fromstate = this.transportGroup.controls.transport.controls['fromState'].value;
                this.toPostcodes = this.getfromtoPostCodes(l_fromstate, value, 'to');
                break;
        }
    }

    onAllSelect(value: any) {
        for (let i = 0; i < this.insVehicleList.length; i++) {
            this.insVehicleList[i].selected = value.target.checked;
        }
    }
    private allselected: boolean;
    onFinanceVehChange(item: any) {
        let l_ctrl = this.basicGroup.get('finance').get('allselected');
        if (l_ctrl != undefined) {
            if (!item.selected) {
                l_ctrl.setValue(false);
            }
            else {
                let l_unselected = this.insVehicleList.filter(function (p: any) { return p.selected == false });
                if (l_unselected != undefined && l_unselected.length == 0)
                    l_ctrl.setValue(true);
            }
        }
    }


    getStates() {
        this.aostates = [{ name: "act", selected: false }, { name: "nsw", selected: false }, { name: "nt", selected: false }, { name: "qld", selected: false }, { name: "sa", selected: false }, { name: "tas", selected: false }, { name: "vic", selected: false }, { name: "wa", selected: false }];

        for (var i = 0; i < this.aostates.length; i++) {
            let make = this.selectedstates;
            if (make.indexOf(this.aostates[i].name) != -1)
                this.aostates[i].selected = true;
            else
                this.aostates[i].selected = false;
        }
        return;
        try {
            if (this.aostates == undefined || !this.aostates.length)
                this._service.getstates().subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data['_body']);
                            this.aostates = l_response;
                            for (var i = 0; i < l_response.length; i++) {
                                let make = this.selectedstates;
                                if (make.indexOf(this.aostates[i].name) != -1)
                                    this.aostates.push({ name: l_response[i], selected: true });
                                else
                                    this.aostates.push({ name: l_response[i], selected: false });
                            }
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
    getFilteredRegion(state: string) {
        try {
            if (this.selectedstates) {
                this.shareservice.showLoader();
                this._service.getregions('australia', state).subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data['_body']);
                            this.shareservice.hideLoader();
                            for (var i = 0; i < l_response.length; i++) {
                                let make = this.selectedregions;
                                if (make.indexOf(l_response[i]) != -1)
                                    this.regions.push({ name: l_response[i], selected: true });
                                else
                                    this.regions.push({ name: l_response[i], selected: false });
                            }
                            return l_response;
                        }
                    },
                    err => {
                        this.shareservice.hideLoader();
                        console.log(err);
                    }
                );
            }
        }
        catch (_err) {
            console.log(_err);
        }
    }
    getfromtoRegion(state: string, l_type: string) {
        try {
            if (this.selectedstates) {
                this.shareservice.showLoader();
                this._service.getregions('australia', state).subscribe(
                    data => {
                        if (data != undefined) {
                            this.shareservice.hideLoader();
                            var l_response = JSON.parse(data['_body']);
                            if (l_type == 'from')
                                this.fromRegions = l_response;
                            else
                                this.toRegions = l_response;
                        }
                    },
                    err => {
                        this.shareservice.hideLoader();
                        console.log(err);
                    }
                );
            }
        }
        catch (_err) {
            console.log(_err);
        }
    }
    getfromtoPostCodes(state: string, region: string, l_type: string) {
        try {
            this.shareservice.showLoader();
            this._service.getpostalcode('australia', state, region).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        if (l_type == 'from')
                            this.fromPostcodes = l_response;
                        else
                            this.toPostcodes = l_response;
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
    getRegion() {
        try {
            for (var i = 0; i < shareService.regions.length; i++) {
                let make = this.selectedregions;
                if (make.indexOf(shareService.regions[i]) != -1)
                    this.regions.push({ name: shareService.regions[i], selected: true });
                else
                    this.regions.push({ name: shareService.regions[i], selected: false });
            }
            return;
            if ((this.selectedstates != undefined && this.selectedstates.length) && this.regions == undefined || !this.regions.length)
                this._service.getregions('australia', this.selectedstates).subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data._body);
                            this.regions = l_response;
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
    getFilteredPostCodes(state: string, region: string) {
        try {
            this.shareservice.showLoader();
            this._service.getpostalcode('australia', state, region).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        for (var i = 0; i < l_response.length; i++) {
                            let make = this.selectedpostcodes;
                            if (make.indexOf(l_response[i]) != -1)
                                this.postcodes.push({ name: l_response[i], selected: true });
                            else
                                this.postcodes.push({ name: l_response[i], selected: false });
                        }
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
    getPostCodes() {
        try {
            for (var i = 0; i < shareService.postcodes.length; i++) {
                let make = this.selectedpostcodes;
                if (make.indexOf(shareService.postcodes[i]) != -1)
                    this.postcodes.push({ name: shareService.postcodes[i], selected: true });
                else
                    this.postcodes.push({ name: shareService.postcodes[i], selected: false });
            }
            return;
            if ((this.selectedregions != undefined && this.selectedregions.length) && this.postcodes == undefined || !this.postcodes.length)
                this._service.getpostalcode('a', 'a', 'a').subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data['_body']);
                            this.postcodes = l_response;
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
            let l_makes = shareService.makes;
            for (var i = 0; i < l_makes.length; i++) {
                let make = this.selectedmakes;
                if (make.indexOf(l_makes[i]) != -1)
                    this.makes.push({ name: l_makes[i], selected: true });
                else
                    this.makes.push({ name: l_makes[i], selected: false });
            }
            return;
            if (this.makes == undefined || !this.makes.length)
                this._service.getmakes().subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data['_body']);
                            this.makes = l_response;
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
    getmodels() {
        try {
            let l_models = shareService.models;
            for (var i = 0; i < l_models.length; i++) {
                let make = this.selectedmodels;
                if (make.indexOf(l_models[i]) != -1)
                    this.models.push({ name: l_models[i], selected: true });
                else
                    this.models.push({ name: l_models[i], selected: false });
            }
            return;
            if (this.makes == undefined || !this.makes.length)
                this._service.getmakes().subscribe(
                    data => {
                        if (data != undefined) {
                            var l_response = JSON.parse(data['_body']);
                            this.makes = l_response;
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
    setFinanceInsTransport(l_grp: FormGroup, l_sub: any) {
        if (this.subscriptionType == 'Finance' || this.subscriptionType == 'Insurance') {
            let l_type = this.subscriptionType == 'Finance' ? 'finance' : 'insurance';
            l_sub.afslNo = l_grp[l_type].afslNo;
            l_sub.authRepNo = l_grp[l_type].authRepNo;
            l_sub.aclNo = l_grp[l_type].aclNo;
            l_sub.brokerLicenceNo = l_grp[l_type].brokerLicenceNo;
            l_sub.insVehicles = l_grp[l_type].insVehicles;
            l_sub.loanNewVeh = l_grp[l_type].loanNewVeh;
            l_sub.loanUsedVeh = l_grp[l_type].loanUsedVeh;
            if (this.subscriptionType == 'Insurance') {
                l_sub.isComprehensive = l_grp['insurance'].isComprehensive;
                l_sub.thirdParty = l_grp['insurance'].thirdParty;
                l_sub.thirdProperty = l_grp['insurance'].thirdProperty;
            }
        }
        else if (this.subscriptionType == 'Transport') {
            l_grp = this.transportGroup['_value'];
            l_sub.fromState = l_grp['transport'].fromState;
            l_sub.toState = l_grp['transport'].toState;
            l_sub.fromRegion = l_grp['transport'].fromRegion;
            l_sub.toRegion = l_grp['transport'].toRegion;
            l_sub.fromPost = l_grp['transport'].fromPost;
            l_sub.toPost = l_grp['transport'].toPost;
            l_sub.stateRate = l_grp['transport'].stateRate;
            l_sub.regionRate = l_grp['transport'].regionRate;
            l_sub.regionRoute = l_grp['transport'].regionRoute;
            l_sub.postRate = l_grp['transport'].postRate;
            l_sub.stateRoute = l_grp['transport'].stateRoute;
            l_sub.postRoute = l_grp['transport'].postRoute;
        }
        else if (this.subscriptionType == 'Servicemaintenance') {
            l_sub.petrol = l_grp['serviceM'].petrol;
            l_sub.diesel = l_grp['serviceM'].diesel;
            l_sub.electric = l_grp['serviceM'].electric;
            l_sub.all1 = l_grp['serviceM'].all1;
            l_sub.clientPlaceDriveYes = l_grp['serviceM'].clientPlaceDriveYes;
            l_sub.clientPlaceDriveMaybe = l_grp['serviceM'].clientPlaceDriveMaybe;
            l_sub.clientPlaceDriveNo = l_grp['serviceM'].clientPlaceDriveNo;
            l_sub.roadAssistance = l_grp['serviceM'].roadAssistance;
        }
    }
    setGroupSubscribe() {
        if (shareService.p_dealer == undefined)
            shareService.p_dealer = new Dealer();
        if (shareService.p_dealer.vehicleDealerDetails == undefined)
            shareService.p_dealer.vehicleDealerDetails = [];
        let l_subs = this.basicGroup['_value'].basicInfo;
        this.setFinanceInsTransport(this.basicGroup['_value'], l_subs);
        l_subs.subscription = this.subscription;
        l_subs.subscriptionType = this.subscriptionType;
        let l_postcodes = this.selectedpostcodes;
        if (l_subs.vehicleDealerPostCode == undefined)
            l_subs.vehicleDealerPostCode = [];
        if (l_subs.vehicleDealerAreaOfOperState == undefined)
            l_subs.vehicleDealerAreaOfOperState = [];
        if (l_subs.vehicleDealerRegion == undefined)
            l_subs.vehicleDealerRegion = [];
        if (l_subs.vehicleDealerMakeList == undefined)
            l_subs.vehicleDealerMakeList = [];
        if (l_subs.vehicleDealerInsDetails == undefined)
            l_subs.vehicleDealerInsDetails = [];
        for (var i = 0; i < l_postcodes.length; i++) {
            l_subs.vehicleDealerPostCode.push({ postCode: l_postcodes[i] });
        }
        for (var i = 0; i < this.selectedstates.length; i++) {
            l_subs.vehicleDealerAreaOfOperState.push({ state: this.selectedstates[i] });
        }
        for (var i = 0; i < this.selectedregions.length; i++) {
            l_subs.vehicleDealerRegion.push({ region: this.selectedregions[i] });
        }
        for (var i = 0; i < this.selectedmakes.length; i++) {
            l_subs.vehicleDealerMakeList.push({ make: this.selectedmakes[i] });
        }
        for (var i = 0; i < this.insVehicleList.length; i++) {
            if (this.insVehicleList[i].selected)
                l_subs.vehicleDealerInsDetails.push({ flex1: this.insVehicleList[i].name });
        }
        this.setType(false);

        if (shareService.p_dealer.vehicleDealerDetails.length) {
            let l_indx: any;
            for (var i = 0; i < shareService.p_dealer.vehicleDealerDetails.length; i++) {
                if (shareService.p_dealer.vehicleDealerDetails[i].subscriptionType == this.subscriptionType) {
                    l_indx = i;
                    break;
                }
            }
            if (l_indx != undefined) {
                shareService.p_dealer.vehicleDealerDetails.splice(l_indx, 1, l_subs);
            }
            else {
                shareService.p_dealer.vehicleDealerDetails.push(l_subs);
            }
        }
        else
            shareService.p_dealer.vehicleDealerDetails.push(l_subs);
    }



    setType(isLoad: boolean) {

        let type = this.subscriptionType;
        //let subList: any = ['BuyVehicle', 'SellVehicle', 'LeaseVehicle', 'Insurance', 'Finance', 'Servicemaintenance', 'Fuel', 'Sparesaccessories', 'Transport', 'Others'];

        //for (var i = 0; i < subList.length; i++) {
        //    if (subList[i] == type) {
        //        break;
        //    }
        //}

        switch (type) {
            case type = 'BuyVehicle':
                if (isLoad)
                    this.isVehicle = true;
                this.shareservice.defaultSubs.isNew = true;
                break;
            case type = 'SellVehicle':
                if (isLoad)
                    this.isVehicle = true;
                this.shareservice.defaultSubs.isPreOwned = true;
                break;
            case type = 'LeaseVehicle':
                if (isLoad)
                    this.isVehicle = true;
                this.shareservice.defaultSubs.isLease = true;
                break;
            case type = 'Insurance':
                if (isLoad)
                    this.isInsurance = true;
                this.shareservice.defaultSubs.isInsurance = true;
                break;
            case type = 'Finance':
                if (isLoad)
                    this.isFinance = true;
                this.shareservice.defaultSubs.isFinance = true;
                break;
            case type = 'Servicemaintenance':
                if (isLoad)
                    this.isSM = true;
                this.shareservice.defaultSubs.isSM = true;
                break;
            case type = 'Fuel':
                if (isLoad)
                    this.isFuel = true;
                this.shareservice.defaultSubs.isFuel = true;
                break;
            case type = 'Sparesaccessories':
                if (isLoad)
                    this.isSpares = true;
                this.shareservice.defaultSubs.isSpares = true;
                break;
            case type = 'Transport':
                if (isLoad)
                    this.isTransport = true;
                this.shareservice.defaultSubs.isTranssport = true;
                break;
            case type = 'Others':
                if (isLoad)
                    this.isOthers = true;
                this.shareservice.defaultSubs.isOthers = true;
                break;

        }
    }
    saveSubscription() {
        try {
            this.setGroupSubscribe();
            //return;
            this.shareservice.showLoader();
            this._service.savesubscription(shareService.p_dealer).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);

                        shareService.p_dealer = l_response;
                        this.router.navigate(['/home']);
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

    onSubmit() {

    }

    onNext(item: string) {
        switch (item) {
            case "basicinfo":
                this.isBasicInfo = false;

                if (this.isFinance || this.isInsurance)
                    this.isSubscription = true;
                else if (this.isTransport) {
                    this.isRoutes = true;
                }
                else
                    this.isMakeModeltab = true;

                break;
            case "makemodel":
                this.isMakeModeltab = false;
                this.isAreaOperation = true;
                break;
            case "area":
                this.isAreaOperation = false;
                this.isSubscription = true;
                //this.saveSubscription();
                break;
            case "addroutes":
                this.isRoutes = false;
                this.isSubscription = true;
                //this.saveSubscription();
                break;
            case "subscription":
                this.isSubscription = false;
                this.isPayment = true;
                this.saveSubscription();
                break;
            default:
                break;
        }
    }

    onPrevious(item: string) {
        switch (item) {
            case "makemodel":
                this.isBasicInfo = true;
                this.isMakeModeltab = false;
                break;
            case "area":
                this.isMakeModeltab = true;
                this.isAreaOperation = false;
                break;
            case "addroutes":
                this.isRoutes = false;
                this.isBasicInfo = true;
                break;
            case "subscription":
                if (this.isFinance || this.isInsurance)
                    this.isBasicInfo = true;
                else if (this.isTransport)
                    this.isRoutes = true;
                else
                    this.isAreaOperation = true;
                this.isSubscription = false;
                break;
            case "payment":
                this.isSubscription = true;
                this.isPayment = false;
                break;
            default:
                break;
        }
    }
}