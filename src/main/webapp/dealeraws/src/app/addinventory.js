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
var dealerService_1 = require("./dealerService");
var router_1 = require("@angular/router");
var forms_1 = require("@angular/forms");
var AddInventoryComponent = (function () {
    function AddInventoryComponent(route, _service, formBuilder, router, shareservice) {
        this.route = route;
        this._service = _service;
        this.formBuilder = formBuilder;
        this.router = router;
        this.shareservice = shareservice;
        this.inventories = [];
        this.inventory = new models_1.inventory();
        this.carExtraList = [];
        this.selectedBanners = [];
        this.featureList = [];
        this.isDriveAway = undefined;
        this.isPrice = undefined;
        this.pricingTypes = [];
        this.makes = [];
        this.models = [];
        this.variants = [];
        this.autotrims = [];
        this.isFixed = true;
        this.isOpen = false;
        this.images = [];
    }
    AddInventoryComponent.prototype.ngOnInit = function () {
        var l_dealerId = models_1.UIStorage.getCookie('dealerId');
        if (l_dealerId != undefined && l_dealerId != null)
            this.dealerId = l_dealerId;
        this.states = ["ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA"];
        this.formValidation();
        this.getVehicleExtras();
        this.edit();
        this.inventories = models_1.shareService.inventories;
        this.pricingTypes = [{ name: 'Fixed', displayName: 'Fixed' }, { name: 'Negotiable', displayName: 'Negotiable' }, { name: 'Range', displayName: 'Price Range' }];
    };
    AddInventoryComponent.prototype.tes = function () {
        //'email': ['', Validators.compose([Validators.required, Validators.pattern(/^\w+[\w-\.]*\@\w+((-\w+)|(\w*))\.[a-z]{2,3}$/)])],
        //    'phn': ['', Validators.compose([Validators.required, Validators.pattern(/^610[0-8]\d{8}$/g)])]
        //'txt': ['', Validators.compose([Validators.required, Validators.pattern(/^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/)])],
    };
    AddInventoryComponent.prototype.formValidation = function () {
        this.inventoryGroup = this.formBuilder.group({
            vehicleDescriptin: ['', forms_1.Validators.required],
            vinNumber: ['', [forms_1.Validators.required, forms_1.Validators.minLength(2)]],
            vendorStockNo: ['', [forms_1.Validators.required, forms_1.Validators.minLength(2)]],
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
        }, { validator: this.validateNewUsed }); //, { validator: this.validatePriceRange }   Validators.compose([Validators.required, this.checkIfA])
    };
    AddInventoryComponent.prototype.validateNewUsed = function (formgroup) {
        return (formgroup.controls["isNewCar"]['_value'] == undefined || formgroup.controls["isUsedCar"]['_value'] == undefined)
            ? { 'required': true } : null;
    };
    AddInventoryComponent.prototype.validatePriceRange = function (formgroup) {
        return ((formgroup.controls["minPrice"]['_value'] != undefined && formgroup.controls["maxPrice"]['_value'] == undefined) || (formgroup.controls["minPrice"]['_value'] == undefined && formgroup.controls["maxPrice"]['_value'] != undefined))
            ? { 'required': true } : null;
    };
    AddInventoryComponent.prototype.getinvbyId = function () {
        this.inventoryGroup.patchValue({
            vehicleDescriptin: this.inventory.vehicleDescriptin,
            vinNumber: this.inventory.vinNumber,
            vendorStockNo: this.inventory.vendorStockNo,
            isNewCar: this.inventory.typeOfCar == 'New' ? true : false,
            isUsedCar: this.inventory.typeOfCar == 'Used' ? true : false,
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
            var featrs_1 = this.inventory.quotationFeatList;
            for (var i = 0; i < featrs_1.length; i++) {
                var l_veh = this.carExtraList.filter(function (p) { return p.name == featrs_1[i].featName; });
                if (l_veh != undefined && l_veh.length)
                    l_veh[0].isChecked = true;
            }
        }
    };
    AddInventoryComponent.prototype.setmakemodelvariant = function () {
        this.selectedMake = this.inventory.modelDisplay;
        this.selectedModel = this.inventory.modelName;
        this.selectedvariant = this.inventory.modelTrim;
        this.getmakes();
        this.getmodels();
        this.getvariants();
        this.getautotrim();
    };
    AddInventoryComponent.prototype.edit = function () {
        var l_id = sessionStorage.getItem('invid');
        if (l_id != undefined) {
            this.inventory.id = +l_id;
            this.id = +l_id;
            sessionStorage.removeItem('invid');
            this.getinventory(+l_id);
        }
    };
    AddInventoryComponent.prototype.carNewChanged = function ($event) {
        this.inventoryGroup.controls['isUsedCar'].setValue(!$event);
    };
    AddInventoryComponent.prototype.carOldChanged = function ($event) {
        this.inventoryGroup.controls['isNewCar'].setValue(!$event);
    };
    AddInventoryComponent.prototype.regoChangeYes = function ($event) {
        this.isRego = $event;
    };
    AddInventoryComponent.prototype.pricingCheck = function (name) {
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
    };
    AddInventoryComponent.prototype.getImage = function (event) {
        var _this = this;
        if (event.target.files && event.target.files[0]) {
            var reader = new FileReader();
            reader.onload = function (event) {
                _this.images.push({ name: '', url: event.target.result });
            };
            reader.readAsDataURL(event.target.files[0]);
        }
    };
    AddInventoryComponent.prototype.showLeftPanel = function () {
        this.shareservice.isOpen = (this.shareservice.isOpen) ? false : true;
    };
    AddInventoryComponent.prototype.regoChange = function ($event) {
        var l_isRego = $event.target;
        if (l_isRego != undefined) {
            this.isRego = l_isRego.checked;
        }
        //throw new Error(`Expected validator to return Promise or Observable.`);
    };
    AddInventoryComponent.prototype.getVehicleExtras = function () {
        this.carExtraList = [{ name: 'Bull Bar', isChecked: false }, { name: 'Nudge Bar', isChecked: false }, { name: 'Side Step', isChecked: false },
            { name: 'Snorkel', isChecked: false }, { name: 'Tow Bar', isChecked: false },
            { name: 'Floor Mats', isChecked: false }, { name: 'Tinted Glass', isChecked: false },
            { name: 'Luggage & Cargo Accessories', isChecked: false }, { name: 'Applicable Roof Racks', isChecked: false },
            { name: 'Tow Accessories', isChecked: false }, { name: 'Seat Cover', isChecked: false },
            { name: 'Bonnet Protection', isChecked: false }, { name: 'Head Lamp Protection', isChecked: false },
            { name: 'Weather Shield', isChecked: false }, { name: 'Medical / first-aid Kit', isChecked: false }, { name: 'Safety Kit', isChecked: false }];
    };
    AddInventoryComponent.prototype.onbannerselect = function (banner) {
        var indx = this.selectedBanners.findIndex(function (p) { return p === banner.name; });
        if (indx != -1) {
            this.selectedBanners.splice(indx, 1);
        }
        else
            this.selectedBanners.push(banner.name);
    };
    AddInventoryComponent.prototype.updateinventory = function (item) {
        sessionStorage.setItem('reourceid', item.id);
    };
    AddInventoryComponent.prototype.onyearselect = function (value) {
        this.getmakes();
    };
    AddInventoryComponent.prototype.onmakeselect = function (value) {
        this.selectedMake = value;
        this.getmodels();
    };
    AddInventoryComponent.prototype.onmodelselect = function (value) {
        this.selectedModel = value;
        this.getvariants();
    };
    AddInventoryComponent.prototype.onvariantselect = function (value) {
        this.selectedvariant = value;
        this.getautotrim();
    };
    AddInventoryComponent.prototype.deleteinventory = function (item) {
        try {
            this._service.deleteresource(item.id).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                }
            }, function (err) {
                console.log(err);
            });
        }
        catch (_err) {
            console.log(_err);
        }
    };
    AddInventoryComponent.prototype.getmakes = function () {
        var _this = this;
        try {
            if (this.makes == undefined || !this.makes.length)
                this.shareservice.showLoader();
            this._service.getmakes(2017).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    _this.makes = l_response;
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
    AddInventoryComponent.prototype.getmodels = function () {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getmodels(2017, this.selectedMake).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    _this.models = l_response;
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
    AddInventoryComponent.prototype.getvariants = function () {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getvariants(2017, this.selectedMake, this.selectedModel).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    _this.variants = l_response;
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
    AddInventoryComponent.prototype.getautotrim = function () {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getvariants(2017, this.selectedMake, this.selectedModel).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    _this.autotrims = l_response;
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
    AddInventoryComponent.prototype.getinventory = function (invid) {
        var _this = this;
        try {
            this.shareservice.showLoader();
            this._service.getinventory(invid).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    _this.inventory = l_response;
                    _this.getinvbyId();
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
    AddInventoryComponent.prototype.setinventory = function () {
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
    };
    AddInventoryComponent.prototype.saveinventory = function () {
        var _this = this;
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
            this._service.saveinventory(this.inventory).subscribe(function (data) {
                _this.shareservice.hideLoader();
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    _this.router.navigate(['/inventory']);
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
    AddInventoryComponent.prototype.getrecentaccounts = function () {
        try {
        }
        catch (_err) {
            console.log(_err);
        }
    };
    return AddInventoryComponent;
}());
AddInventoryComponent = __decorate([
    core_1.Component({
        selector: 'add-inventory',
        templateUrl: 'src/views/addinventory.html'
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute, dealerService_1.dealerservice, forms_1.FormBuilder, router_1.Router, models_1.shareService])
], AddInventoryComponent);
exports.AddInventoryComponent = AddInventoryComponent;
//# sourceMappingURL=addinventory.js.map