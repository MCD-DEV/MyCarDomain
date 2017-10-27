"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var models_1 = require("./models");
var servermodels_1 = require("./servermodels");
var dealerService_1 = require("./dealerService");
var router_1 = require("@angular/router");
var forms_1 = require("@angular/forms");
var SubscribeComponent = (function () {
    function SubscribeComponent(route, _service, formBuilder, router, shareservice) {
        this.route = route;
        this._service = _service;
        this.formBuilder = formBuilder;
        this.router = router;
        this.shareservice = shareservice;
        this.isMakeModeltab = false;
        this.isBasicInfo = true;
        this.isAreaOperation = false;
        this.isRoutes = false;
        this.isSubscription = false;
        this.isPayment = false;
        this.vehicleTypes = [];
        this.selectedVehicleTypes = [];
        this.states = [];
        this.selectedstates = [];
        this.aostates = [];
        this.makes = [];
        this.selectedmakes = [];
        this.selectedmodels = [];
        this.models = [];
        this.regions = [];
        this.fromRegions = [];
        this.toRegions = [];
        this.selectedregions = [];
        this.postcodes = [];
        this.fromPostcodes = [];
        this.toPostcodes = [];
        this.selectedpostcodes = [];
        this.dealerBasicInfo = new servermodels_1.Dealer();
        this.isOpen = false;
        this.insVehicleList = [];
        //this.route
        //    .queryParams
        //    .subscribe(params => {
        //        this.subscriptionType = params['name'];
        //    });
    }
    SubscribeComponent.prototype.ngOnInit = function () {
        this.insVehicleList = [{ name: 'Cars', selected: false }, { name: 'Boats', selected: false }, { name: 'Bikes', selected: false }, { name: 'Caravan', selected: false }, { name: 'Commercial', selected: false }, { name: 'Agri', selected: false }];
        this.vehicleTypes = [{ name: 'Cars', selected: false }, { name: 'Bikes', selected: false }, { name: 'Boats', selected: false }, { name: 'Caravans', selected: false }, { name: 'Commercial Vehicle', selected: false }, { name: 'Sports Vehicle', selected: false }, { name: 'Agricultural Vehicle', selected: false }];
        this.basicInfoValidate();
        var type = sessionStorage.getItem('subscriptiontype');
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
    };
    SubscribeComponent.prototype.showLeftPanel = function () {
        this.shareservice.isOpen = (this.shareservice.isOpen) ? false : true;
    };
    SubscribeComponent.prototype.basicInfoValidate = function () {
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
    };
    SubscribeComponent.prototype.setGroup = function () {
        try {
            if (models_1.shareService.p_dealer != undefined) {
                var dealer_1 = this.setdata();
                if (dealer_1 != undefined) {
                    this.basicGroup.patchValue({
                        basicInfo: dealer_1,
                        serviceM: dealer_1,
                        transport: dealer_1,
                        finance: dealer_1,
                        insurance: dealer_1
                    });
                    if (this.subscriptionType == "Transport") {
                        this.transportGroup.patchValue({
                            transport: dealer_1
                        });
                    }
                    this.subscription = dealer_1.subscription;
                    if (dealer_1.vehicleDealerMakeList != undefined)
                        for (var i = 0; i < dealer_1.vehicleDealerMakeList.length; i++) {
                            this.selectedmakes.push(dealer_1.vehicleDealerMakeList[i].make);
                        }
                    if (dealer_1.vehicleDealerRegion != undefined)
                        for (var i = 0; i < dealer_1.vehicleDealerRegion.length; i++) {
                            this.selectedregions.push(dealer_1.vehicleDealerRegion[i].region);
                        }
                    if (dealer_1.vehicleDealerPostCode != undefined)
                        for (var i = 0; i < dealer_1.vehicleDealerPostCode.length; i++) {
                            this.selectedpostcodes.push(dealer_1.vehicleDealerPostCode[i].postCode);
                        }
                    if (dealer_1.vehicleDealerAreaOfOperState != undefined)
                        for (var i = 0; i < dealer_1.vehicleDealerAreaOfOperState.length; i++) {
                            this.selectedstates.push(dealer_1.vehicleDealerAreaOfOperState[i].state);
                        }
                    if (dealer_1.vehicleDealerInsDetails != undefined) {
                        var l_all = void 0;
                        for (var i = 0; i < dealer_1.vehicleDealerInsDetails.length; i++) {
                            var l_veh = this.insVehicleList.filter(function (p) { return p.name == dealer_1.vehicleDealerInsDetails[i].flex1; });
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
    };
    SubscribeComponent.prototype.setdata = function () {
        try {
            var subList = ['BuyVehicle', 'SellVehicle', 'LeaseVehicle', 'Insurance', 'Finance', 'Servicemaintenance', 'Fuel', 'Sparesaccessories', 'Transport', 'Others'];
            var l_unselected = void 0;
            var l_subtype_1 = this.subscriptionType;
            l_unselected = models_1.shareService.p_dealer.vehicleDealerDetails.filter(function (p) { return p.subscriptionType == l_subtype_1; });
            if (l_unselected != undefined)
                return l_unselected[0];
            else
                return {};
        }
        catch (err) {
        }
    };
    SubscribeComponent.prototype.getheaderno = function (subtype) {
        if (subtype == 'sub')
            return (this.isFinance || this.isInsurance) ? 2 : 4;
        else if (subtype == 'payment') {
            if (this.isFinance || this.isInsurance)
                return 3;
            else
                return 5;
        }
    };
    SubscribeComponent.prototype.onMakeSelect = function (make) {
        //let l_make = this.selectedmakes.map(function (e) { return e; }).indexOf(make.name);
        var indx = this.selectedmakes.findIndex(function (p) { return p.name === make.name; });
        if (indx != -1) {
            this.selectedmakes.splice(indx, 1);
        }
        else
            this.selectedmakes.push(make.name);
    };
    SubscribeComponent.prototype.onModelSelect = function (make) {
        //let l_make = this.selectedmakes.map(function (e) { return e; }).indexOf(make.name);
        var indx = this.selectedmodels.findIndex(function (p) { return p.name === make.name; });
        if (indx != -1) {
            this.selectedmodels.splice(indx, 1);
        }
        else
            this.selectedmodels.push(make.name);
    };
    SubscribeComponent.prototype.onstateSelect = function (state) {
        var indx = this.selectedstates.findIndex(function (p) { return p.name === state.name; });
        if (indx != -1) {
            this.selectedstates.splice(indx, 1);
        }
        else
            this.selectedstates.push(state.name);
        this.getFilteredRegion(state.name);
    };
    SubscribeComponent.prototype.onregionSelect = function (region) {
        var indx = this.selectedregions.findIndex(function (p) { return p.name === region.name; });
        if (indx != -1) {
            this.selectedregions.splice(indx, 1);
        }
        else
            this.selectedregions.push(region.name);
        this.getFilteredPostCodes(this.selectedstates[0], this.selectedregions[0]);
    };
    SubscribeComponent.prototype.onvehicleSelect = function (vhtype) {
        var indx = this.selectedVehicleTypes.findIndex(function (p) { return p.name === vhtype.name; });
        if (indx != -1) {
            this.selectedregions.splice(indx, 1);
        }
        else
            this.selectedregions.push(vhtype.name);
    };
    SubscribeComponent.prototype.onpostcodeSelect = function (postcode) {
        var indx = this.selectedpostcodes.findIndex(function (p) { return p.name === postcode.name; });
        if (indx != -1) {
            this.selectedpostcodes.splice(indx, 1);
        }
        else
            this.selectedpostcodes.push(postcode.name);
    };
    SubscribeComponent.prototype.fromstatechange = function (value, l_type) {
        switch (l_type) {
            case 'tostate':
                this.fromRegions = this.getfromtoRegion(value, 'from');
                break;
            case 'fromstate':
                this.toRegions = this.getfromtoRegion(value, 'to');
                break;
            case 'toregion':
                var l_tostate = this.transportGroup.controls.transport.controls['toState'].value;
                this.fromPostcodes = this.getfromtoPostCodes(l_tostate, value, 'from');
                break;
            case 'fromregion':
                var l_fromstate = this.transportGroup.controls.transport.controls['fromState'].value;
                this.toPostcodes = this.getfromtoPostCodes(l_fromstate, value, 'to');
                break;
        }
    };
    SubscribeComponent.prototype.onAllSelect = function (value) {
        for (var i = 0; i < this.insVehicleList.length; i++) {
            this.insVehicleList[i].selected = value.target.checked;
        }
    };
    SubscribeComponent.prototype.onFinanceVehChange = function (item) {
        var l_ctrl = this.basicGroup.get('finance').get('allselected');
        if (l_ctrl != undefined) {
            if (!item.selected) {
                l_ctrl.setValue(false);
            }
            else {
                var l_unselected = this.insVehicleList.filter(function (p) { return p.selected == false; });
                if (l_unselected != undefined && l_unselected.length == 0)
                    l_ctrl.setValue(true);
            }
        }
    };
    SubscribeComponent.prototype.getStates = function () {
        var _this = this;
        this.aostates = [{ name: "act", selected: false }, { name: "nsw", selected: false }, { name: "nt", selected: false }, { name: "qld", selected: false }, { name: "sa", selected: false }, { name: "tas", selected: false }, { name: "vic", selected: false }, { name: "wa", selected: false }];
        for (var i = 0; i < this.aostates.length; i++) {
            var make = this.selectedstates;
            if (make.indexOf(this.aostates[i].name) != -1)
                this.aostates[i].selected = true;
            else
                this.aostates[i].selected = false;
        }
        return;
        try {
            if (this.aostates == undefined || !this.aostates.length)
                this._service.getstates().subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        _this.aostates = l_response;
                        for (var i = 0; i < l_response.length; i++) {
                            var make = _this.selectedstates;
                            if (make.indexOf(_this.aostates[i].name) != -1)
                                _this.aostates.push({ name: l_response[i], selected: true });
                            else
                                _this.aostates.push({ name: l_response[i], selected: false });
                        }
                    }
                }, function (err) {
                    console.log(err);
                });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getFilteredRegion = function (state) {
        var _this = this;
        try {
            if (this.selectedstates) {
                this.shareservice.showLoader();
                this._service.getregions('australia', state).subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        _this.shareservice.hideLoader();
                        for (var i = 0; i < l_response.length; i++) {
                            var make = _this.selectedregions;
                            if (make.indexOf(l_response[i]) != -1)
                                _this.regions.push({ name: l_response[i], selected: true });
                            else
                                _this.regions.push({ name: l_response[i], selected: false });
                        }
                        return l_response;
                    }
                }, function (err) {
                    _this.shareservice.hideLoader();
                    console.log(err);
                });
            }
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getfromtoRegion = function (state, l_type) {
        var _this = this;
        try {
            if (this.selectedstates) {
                this.shareservice.showLoader();
                this._service.getregions('australia', state).subscribe(function (data) {
                    if (data != undefined) {
                        _this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        if (l_type == 'from')
                            _this.fromRegions = l_response;
                        else
                            _this.toRegions = l_response;
                    }
                }, function (err) {
                    _this.shareservice.hideLoader();
                    console.log(err);
                });
            }
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getfromtoPostCodes = function (state, region, l_type) {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getpostalcode('australia', state, region).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    if (l_type == 'from')
                        _this.fromPostcodes = l_response;
                    else
                        _this.toPostcodes = l_response;
                }
            }, function (err) {
                _this.shareservice.hideLoader();
                console.log(err);
            });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getRegion = function () {
        var _this = this;
        try {
            for (var i = 0; i < models_1.shareService.regions.length; i++) {
                var make = this.selectedregions;
                if (make.indexOf(models_1.shareService.regions[i]) != -1)
                    this.regions.push({ name: models_1.shareService.regions[i], selected: true });
                else
                    this.regions.push({ name: models_1.shareService.regions[i], selected: false });
            }
            return;
            if ((this.selectedstates != undefined && this.selectedstates.length) && this.regions == undefined || !this.regions.length)
                this._service.getregions('australia', this.selectedstates).subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data._body);
                        _this.regions = l_response;
                    }
                }, function (err) {
                    console.log(err);
                });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getFilteredPostCodes = function (state, region) {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getpostalcode('australia', state, region).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    for (var i = 0; i < l_response.length; i++) {
                        var make = _this.selectedpostcodes;
                        if (make.indexOf(l_response[i]) != -1)
                            _this.postcodes.push({ name: l_response[i], selected: true });
                        else
                            _this.postcodes.push({ name: l_response[i], selected: false });
                    }
                }
            }, function (err) {
                _this.shareservice.hideLoader();
                console.log(err);
            });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getPostCodes = function () {
        var _this = this;
        try {
            for (var i = 0; i < models_1.shareService.postcodes.length; i++) {
                var make = this.selectedpostcodes;
                if (make.indexOf(models_1.shareService.postcodes[i]) != -1)
                    this.postcodes.push({ name: models_1.shareService.postcodes[i], selected: true });
                else
                    this.postcodes.push({ name: models_1.shareService.postcodes[i], selected: false });
            }
            return;
            if ((this.selectedregions != undefined && this.selectedregions.length) && this.postcodes == undefined || !this.postcodes.length)
                this._service.getpostalcode('a', 'a', 'a').subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        _this.postcodes = l_response;
                    }
                }, function (err) {
                    console.log(err);
                });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getmakes = function () {
        var _this = this;
        try {
            var l_makes = models_1.shareService.makes;
            for (var i = 0; i < l_makes.length; i++) {
                var make = this.selectedmakes;
                if (make.indexOf(l_makes[i]) != -1)
                    this.makes.push({ name: l_makes[i], selected: true });
                else
                    this.makes.push({ name: l_makes[i], selected: false });
            }
            return;
            if (this.makes == undefined || !this.makes.length)
                this._service.getmakes().subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        _this.makes = l_response;
                    }
                }, function (err) {
                    console.log(err);
                });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.getmodels = function () {
        var _this = this;
        try {
            var l_models = models_1.shareService.models;
            for (var i = 0; i < l_models.length; i++) {
                var make = this.selectedmodels;
                if (make.indexOf(l_models[i]) != -1)
                    this.models.push({ name: l_models[i], selected: true });
                else
                    this.models.push({ name: l_models[i], selected: false });
            }
            return;
            if (this.makes == undefined || !this.makes.length)
                this._service.getmakes().subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        _this.makes = l_response;
                    }
                }, function (err) {
                    console.log(err);
                });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.setFinanceInsTransport = function (l_grp, l_sub) {
        if (this.subscriptionType == 'Finance' || this.subscriptionType == 'Insurance') {
            var l_type = this.subscriptionType == 'Finance' ? 'finance' : 'insurance';
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
    };
    SubscribeComponent.prototype.setGroupSubscribe = function () {
        if (models_1.shareService.p_dealer == undefined)
            models_1.shareService.p_dealer = new servermodels_1.Dealer();
        if (models_1.shareService.p_dealer.vehicleDealerDetails == undefined)
            models_1.shareService.p_dealer.vehicleDealerDetails = [];
        var l_subs = this.basicGroup['_value'].basicInfo;
        this.setFinanceInsTransport(this.basicGroup['_value'], l_subs);
        l_subs.subscription = this.subscription;
        l_subs.subscriptionType = this.subscriptionType;
        var l_postcodes = this.selectedpostcodes;
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
        if (models_1.shareService.p_dealer.vehicleDealerDetails.length) {
            var l_indx = void 0;
            for (var i = 0; i < models_1.shareService.p_dealer.vehicleDealerDetails.length; i++) {
                if (models_1.shareService.p_dealer.vehicleDealerDetails[i].subscriptionType == this.subscriptionType) {
                    l_indx = i;
                    break;
                }
            }
            if (l_indx != undefined) {
                models_1.shareService.p_dealer.vehicleDealerDetails.splice(l_indx, 1, l_subs);
            }
            else {
                models_1.shareService.p_dealer.vehicleDealerDetails.push(l_subs);
            }
        }
        else
            models_1.shareService.p_dealer.vehicleDealerDetails.push(l_subs);
    };
    SubscribeComponent.prototype.setType = function (isLoad) {
        var type = this.subscriptionType;
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
    };
    SubscribeComponent.prototype.saveSubscription = function () {
        var _this = this;
        try {
            this.setGroupSubscribe();
            //return;
            this.shareservice.showLoader();
            this._service.savesubscription(models_1.shareService.p_dealer).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    models_1.shareService.p_dealer = l_response;
                    _this.router.navigate(['/home']);
                }
            }, function (err) {
                _this.shareservice.hideLoader();
                console.log(err);
            });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    SubscribeComponent.prototype.onSubmit = function () {
    };
    SubscribeComponent.prototype.onNext = function (item) {
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
    };
    SubscribeComponent.prototype.onPrevious = function (item) {
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
    };
    return SubscribeComponent;
}());
SubscribeComponent = __decorate([
    core_1.Component({
        selector: 'subscribe',
        templateUrl: 'src/views/subscribe.html'
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute, dealerService_1.dealerservice, forms_1.FormBuilder, router_1.Router, models_1.shareService])
], SubscribeComponent);
exports.SubscribeComponent = SubscribeComponent;
//# sourceMappingURL=subscribecomponent.js.map