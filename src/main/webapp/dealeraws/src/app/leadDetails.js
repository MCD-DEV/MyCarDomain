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
var servermodels_1 = require('./servermodels');
var dealerService_1 = require('./dealerService');
var router_1 = require('@angular/router');
var forms_1 = require('@angular/forms');
var LeadInformation = (function () {
    function LeadInformation(route, _service, formBuilder, router, shareservice) {
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:
        this.route = route;
        this._service = _service;
        this.formBuilder = formBuilder;
        this.router = router;
        this.shareservice = shareservice;
        this.states = [];
        this.makes = [];
        this.models = [];
        this.variants = [];
        this.autotrims = [];
        this.quote = new servermodels_1.VehicleQuotation();
    }
    LeadInformation.prototype.ngOnInit = function () {
        this.formValidation();
    };
    LeadInformation.prototype.formValidation = function () {
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
    };
    LeadInformation.prototype.deletedetails = function (indx, items) {
        items.splice(indx, 1);
    };
    LeadInformation.prototype.onyearselect = function (value) {
        this.getmakes();
    };
    LeadInformation.prototype.onmakeselect = function (value) {
        this.selectedMake = value;
        this.getmodels();
    };
    LeadInformation.prototype.onmodelselect = function (value) {
        this.selectedModel = value;
        this.getvariants();
    };
    LeadInformation.prototype.adddetails = function (type) {
        switch (type) {
            case 'details':
                this.quote.vehQuotExtras.push(new servermodels_1.VehQuotExtras());
                break;
            case 'dates':
                this.quote.offerDateList.push(new servermodels_1.OfferDateList());
                break;
            case 'docs':
                this.quote.vehQuotDoc.push(new servermodels_1.VehQuotDoc());
                break;
            case 'terms':
                this.quote.vehQuotTerm.push(new servermodels_1.VehQuotTerm());
                break;
        }
    };
    //onvariantselect(value: any) {
    //    this.selectedvariant = value;
    //    this.getautotrim();
    //}
    LeadInformation.prototype.setmakemodelvariant = function () {
        //this.selectedMake = this.inventory.modelDisplay;
        //this.selectedModel = this.inventory.modelName;
        //this.selectedVariant = this.inventory.modelTrim;
        this.getmakes();
        this.getmodels();
        this.getvariants();
        this.getautotrim();
    };
    LeadInformation.prototype.getmakes = function () {
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
    LeadInformation.prototype.getmodels = function () {
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
    LeadInformation.prototype.getvariants = function () {
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
    LeadInformation.prototype.getautotrim = function () {
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
    LeadInformation = __decorate([
        core_1.Component({
            selector: 'leadinfo',
            templateUrl: 'src/views/leaddetails.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, dealerService_1.dealerservice, forms_1.FormBuilder, router_1.Router, models_1.shareService])
    ], LeadInformation);
    return LeadInformation;
}());
exports.LeadInformation = LeadInformation;
//# sourceMappingURL=leaddetails.js.map