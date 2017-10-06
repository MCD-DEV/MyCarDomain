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
var core_1 = require('@angular/core');
var models_1 = require('./models');
var dealerService_1 = require('./dealerService');
var router_1 = require('@angular/router');
var forms_1 = require('@angular/forms');
var SubscribeComponent = (function () {
    function SubscribeComponent(route, _service, formBuilder, router, shareservice) {
        //this.route
        //    .queryParams
        //    .subscribe(params => {
        //        this.subscriptionType = params['name'];
        //    });
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
        this.dealerBasicInfo = new models_1.dealer();
        this.isOpen = false;
        this.insVehicleList = [];
    }
    SubscribeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.vehicleTypes = [{ name: 'Cars', selected: false }, { name: 'Bikes', selected: false }, { name: 'Boats', selected: false }, { name: 'Caravans', selected: false }, { name: 'Commercial Vehicle', selected: false }, { name: 'Sports Vehicle', selected: false }, { name: 'Agricultural Vehicle', selected: false }];
        this.basicInfoValidate();
        var type = sessionStorage.getItem('subscriptiontype');
        if (type != undefined && type != null) {
            this.subscriptionType = type;
            this.setType(true);
            sessionStorage.removeItem('subscriptiontype');
        }
        if (models_1.shareService.subscriptions.length) {
            var l_subs = models_1.shareService.subscriptions.filter(function (p) { return p.subscriptionType == _this.subscriptionType; });
            if (l_subs != undefined && l_subs.length > 0) {
                this.setGroup(l_subs[0]);
            }
        }
        this.states = ["ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA"];
        this.insVehicleList = [{ name: 'Cars', selected: false }, { name: 'Boats', selected: false }, { name: 'Bikes', selected: false }, { name: 'Caravan', selected: false }, { name: 'Commercial', selected: false }, { name: 'Agri', selected: false }];
        this.getStates();
        this.getmakes();
        this.getmodels();
        this.getRegion();
        this.getPostCodes();
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
                isStateRoute: [''],
                isRegionRoute: [''],
                isPostRoute: ['']
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
                licenceABNNumber: [''],
                licenceNumber: [''],
                address: [''],
                suburb: [''],
                postCode: [''],
                state: [null],
                website: [''],
                isNew: [''],
                isUsed: [''],
                dealerGroupName: ['']
            }),
            contactDetails: this.formBuilder.group({
                contactNumber2: [''],
                contactPerson: [''],
                designation: [''],
                contactNumber1: [''],
                dob: [''],
                additionalInfo: [''],
                email: ['']
            }),
            serviceM: this.formBuilder.group({
                isPetrol: [''],
                isDiesel: [''],
                isElectric: [''],
                All: [''],
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
                isLoanNewVeh: [''],
                isLoanUsedVeh: [''],
                allselected: []
            }),
            insurance: this.formBuilder.group({
                afslNo: [''],
                authRepNo: [''],
                aclNo: [''],
                brokerLicenceNo: [''],
                insVehicles: [''],
                isComprehensive: [''],
                isThirdParty: [''],
                isThirdProperty: [''],
                allselected: []
            })
        });
    };
    SubscribeComponent.prototype.setGroup = function (dealer) {
        this.basicGroup.patchValue({
            basicInfo: dealer.basicInfo,
            contactDetails: dealer.contactDetails,
            serviceM: dealer.service != undefined ? dealer.service : {},
            transport: dealer.transport != undefined ? dealer.transport : {},
            finance: dealer.finance != undefined ? dealer.finance : {}
        });
        this.dealerBasicInfo.subscription = dealer.subscription;
        this.selectedmakes = dealer.make;
        this.selectedmodels = dealer.model;
        this.selectedregions = dealer.areaofOperation.area;
        this.selectedpostcodes = dealer.areaofOperation.postCode;
        this.selectedstates = dealer.areaofOperation.state;
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
    };
    SubscribeComponent.prototype.onregionSelect = function (region) {
        var indx = this.selectedregions.findIndex(function (p) { return p.name === region.name; });
        if (indx != -1) {
            this.selectedregions.splice(indx, 1);
        }
        else
            this.selectedregions.push(region.name);
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
                this.fromRegions = this.getFilteredRegion(value);
                break;
            case 'fromstate':
                this.toRegions = this.getFilteredRegion(value);
                break;
            case 'toregion':
                var l_tostate = this.transportGroup.controls["toState"]['_value'];
                this.fromPostcodes = this.getFilteredPostCodes(l_tostate, value);
                break;
            case 'fromregion':
                var l_fromstate = this.transportGroup.controls["fromState"]['_value'];
                this.toPostcodes = this.getFilteredPostCodes(l_fromstate, value);
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
        this.aostates = [{ name: "ACT", selected: false }, { name: "NSW", selected: false }, { name: "NT", selected: false }, { name: "QLD", selected: false }, { name: "SA", selected: false }, { name: "TAS", selected: false }, { name: "VIC", selected: false }, { name: "WA", selected: false }];
        return;
        try {
            if (this.states == undefined || !this.states.length)
                this._service.getstates().subscribe(function (data) {
                    if (data != undefined) {
                        var l_response = JSON.parse(data._body);
                        _this.states = l_response;
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
        try {
            this._service.getregions('australia', state).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    return l_response;
                }
            }, function (err) {
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
        try {
            this._service.getpostalcode('australia', state, region).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    return l_response;
                }
            }, function (err) {
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
    SubscribeComponent.prototype.setGroupSubscribe = function () {
        this.dealerBasicInfo.contactDetails = this.basicGroup['_value'].contactDetails;
        this.dealerBasicInfo.basicInfo = this.basicGroup['_value'].basicInfo;
        if (this.isSM)
            this.dealerBasicInfo.service = this.basicGroup['_value'].serviceM;
        if (this.isFinance) {
            this.dealerBasicInfo.finance = this.basicGroup['_value'].finance;
            this.dealerBasicInfo.finance.insVehicles = [];
            for (var i_1 = 0; i_1 < this.insVehicleList.length; i_1++) {
                this.dealerBasicInfo.finance.insVehicles.push(this.insVehicleList[i_1]);
            }
        }
        if (this.isInsurance) {
            this.dealerBasicInfo.insurance = this.basicGroup['_value'].insurance;
            this.dealerBasicInfo.insurance.insVehicles = [];
            for (var i_2 = 0; i_2 < this.insVehicleList.length; i_2++) {
                this.dealerBasicInfo.insurance.insVehicles.push(this.insVehicleList[i_2]);
            }
        }
        if (this.isTransport)
            this.dealerBasicInfo.transport = this.transportGroup['_value'].transport;
        var l_postcodes = this.selectedpostcodes;
        for (var i = 0; i < l_postcodes.length; i++) {
            this.dealerBasicInfo.areaofOperation.postCode.push(l_postcodes[i]);
        }
        for (var i = 0; i < this.selectedregions.length; i++) {
            this.dealerBasicInfo.areaofOperation.area.push(this.selectedregions[i]);
        }
        for (var i = 0; i < this.selectedmakes.length; i++) {
            this.dealerBasicInfo.make.push(this.selectedmakes[i]);
        }
        for (var i = 0; i < this.selectedmodels.length; i++) {
            this.dealerBasicInfo.model.push(this.selectedmodels[i]);
        }
        this.dealerBasicInfo.subscriptionType = this.subscriptionType;
        this.setType(false);
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
        try {
            this.setGroupSubscribe();
            if (models_1.shareService.subscriptions != undefined && models_1.shareService.subscriptions.length) {
                var l_indx = void 0;
                for (var i = 0; i < models_1.shareService.subscriptions.length; i++) {
                    if (models_1.shareService.subscriptions[i].subscriptionType == this.subscriptionType) {
                        l_indx = i;
                        break;
                    }
                }
                if (l_indx != undefined) {
                    models_1.shareService.subscriptions.splice(l_indx, 1, this.dealerBasicInfo);
                }
                else {
                    models_1.shareService.subscriptions.push(this.dealerBasicInfo);
                }
            }
            else
                models_1.shareService.subscriptions.push(this.dealerBasicInfo);
            this.router.navigate(['/home']);
            return;
            this._service.savesubscription(this.dealerBasicInfo).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data._body);
                }
            }, function (err) {
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
    SubscribeComponent = __decorate([
        core_1.Component({
            selector: 'subscribe',
            templateUrl: 'views/subscribe.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, dealerService_1.dealerservice, forms_1.FormBuilder, router_1.Router, models_1.shareService])
    ], SubscribeComponent);
    return SubscribeComponent;
}());
exports.SubscribeComponent = SubscribeComponent;
//# sourceMappingURL=subscribecomponent.js.map