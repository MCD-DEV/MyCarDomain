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
var http_1 = require("@angular/http");
var core_1 = require("@angular/core");
var http_2 = require("@angular/http");
var models_1 = require("./models");
var dealerservice = (function () {
    function dealerservice(http) {
        this.http = http;
        this._uri = '';
        this.headers = new http_1.Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('dataType', 'jsonp');
        this.headers.append("Access-Control-Allow-Origin", "*");
        //var refid = UIStorage.getCookie('refId');
        //if (refid != null && refid != undefined && refid != '')
        //    this.headers.append('Authorization', 'Bearer ' + refid);http://autoscoop.com.au/api/tempCarModelMakesForYear?modelYear=2017
        //this._uri = 'http://localhost:43893/';
        this._uri = 'http://localhost:8080/MyCarDomain/';
    }
    dealerservice.prototype.getstates = function () {
        //var xhr = new XMLHttpRequest();
        //xhr.open("GET", "states?country=australia", true);
        //xhr.onreadystatechange = function () {
        //    debugger;
        //    if (xhr.readyState == 4) {
        //        // JSON.parse does not evaluate the attacker's scripts.
        //        return JSON.parse(xhr.responseText);
        //    }
        //}
        //xhr.send();
        return this.http.get(this._uri + 'states?country=australia', { headers: this.headers });
    };
    dealerservice.prototype.getmakes = function (year) {
        return this.http.get(this._uri + 'api/tempCarModelMakesForYear?modelYear=' + year, { headers: this.headers });
    };
    dealerservice.prototype.getmodels = function (year, make) {
        return this.http.get(this._uri + 'api/tempCarModelNamesForMake?modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    };
    dealerservice.prototype.getvariants = function (year, make, model) {
        return this.http.get(this._uri + 'api/tempCarModelTrimForAllSelect?modelName=' + model + '&modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    };
    dealerservice.prototype.getautotrim = function (year, make, model) {
        return this.http.get(this._uri + 'api/tempCarModelTrimForAllSelect?modelName=' + model + '&modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    };
    dealerservice.prototype.getregions = function (country, state) {
        return this.http.get(this._uri + 'regions?country=' + country + '&state=' + state, { headers: this.headers });
    };
    dealerservice.prototype.getpostalcode = function (country, state, region) {
        return this.http.get(this._uri + 'postcodes?country=' + country + '&state=' + state + '&region=' + region, { headers: this.headers });
    };
    dealerservice.prototype.savesubscription = function (dealerbasicinfo) {
        return this.http.post(this._uri + 'api/dealer/SubscribeSBL', dealerbasicinfo, { headers: this.headers });
    };
    dealerservice.prototype.save = function (statements) {
        var data = this.http.post(this._uri + 'api/user/Save', statements, { headers: this.headers });
        return data;
    };
    dealerservice.prototype.getdealer = function (dealerId) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId, { headers: this.headers });
    };
    //resource managements
    dealerservice.prototype.getresources = function (dealerId) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    };
    dealerservice.prototype.getleads = function (dealerId) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId + '/search', { headers: this.headers });
    };
    dealerservice.prototype.getlead = function (leadId) {
        return this.http.get(this._uri + 'api/dealer/search/' + leadId, { headers: this.headers });
    };
    dealerservice.prototype.getquotes = function (leadid, dealerid) {
        return this.http.get(this._uri + 'api/getExtQtSearchInfoIdDealrId?leadId=' + leadid + '&dealerId=' + dealerid, { headers: this.headers });
    };
    dealerservice.prototype.createquote = function (quote) {
        return this.http.put(this._uri + 'api/dealerQuotCreation', quote, { headers: this.headers });
    };
    dealerservice.prototype.getvehicles = function (dealerId) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId + '/inventory', { headers: this.headers });
    };
    dealerservice.prototype.getinventory = function (invId) {
        return this.http.get(this._uri + 'api/inventory/' + invId, { headers: this.headers });
    };
    dealerservice.prototype.updateresource = function (resourceid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    };
    dealerservice.prototype.deleteresource = function (resourceid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    };
    dealerservice.prototype.saveresource = function (dealerid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    };
    dealerservice.prototype.saveinventory = function (inventory) {
        if (inventory.repoId == undefined || inventory.repoId == null)
            return this.http.post(this._uri + 'api/dealer/addInventory', inventory, { headers: this.headers });
        else
            return this.http.put(this._uri + 'api/dealer/updateInventory', inventory, { headers: this.headers });
    };
    dealerservice.prototype.validateDealerContext = function (dealer) {
        return this.http.post(this._uri + 'api/interDeal/verify', dealer, { headers: this.headers });
    };
    dealerservice.prototype.sendContext = function (email) {
        return this.http.post(this._uri + 'api/dealer', models_1.dealer, { headers: this.headers });
    };
    dealerservice.prototype.createDealerContext = function (dealer) {
        return this.http.post(this._uri + 'api/interDeal/login', dealer, { headers: this.headers });
    };
    return dealerservice;
}());
dealerservice = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_2.Http])
], dealerservice);
exports.dealerservice = dealerservice;
//# sourceMappingURL=dealerService.js.map