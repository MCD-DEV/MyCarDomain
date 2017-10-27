import { Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import {
    Dealer, VehicleDealerAreaOfOperPostCode, VehicleDealerAreaOfOperRegion, VehicleDealerAreaOfOperState, VehicleDealerDetails
    , VehicleDealerFinanceDetails, VehicleDealerInsuranceDetails, VehicleDealerMakeList, VehicleDealerServMaintDetails
} from './servermodels';
import { dealer } from './models';


@Injectable()
export class dealerservice {

    private _uri: string = '';
    headers = new Headers();
    constructor(private http: Http) {
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('dataType', 'jsonp');
        this.headers.append("Access-Control-Allow-Origin", "*");
        //var refid = UIStorage.getCookie('refId');
        //if (refid != null && refid != undefined && refid != '')
        //    this.headers.append('Authorization', 'Bearer ' + refid);http://autoscoop.com.au/api/tempCarModelMakesForYear?modelYear=2017
        //this._uri = 'http://localhost:43893/';
        this._uri = 'http://localhost:8080/MyCarDomain/';
    }

    getstates() {
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
    }
    getmakes(year: any) {
        return this.http.get(this._uri + 'api/tempCarModelMakesForYear?modelYear=' + year, { headers: this.headers });
    }
    getmodels(year: any, make: any) {
        return this.http.get(this._uri + 'api/tempCarModelNamesForMake?modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    }
    getvariants(year: any, make: string, model: string) {
        return this.http.get(this._uri + 'api/tempCarModelTrimForAllSelect?modelName=' + model + '&modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    }
    getautotrim(year: any, make: string, model: string) {
        return this.http.get(this._uri + 'api/tempCarModelTrimForAllSelect?modelName=' + model + '&modelDisplay=' + make + '&modelYear=' + year, { headers: this.headers });
    }
    getregions(country: string, state: string) {
        return this.http.get(this._uri + 'regions?country=' + country + '&state=' + state, { headers: this.headers });
    }
    getpostalcode(country: string, state: string, region: string) {
        return this.http.get(this._uri + 'postcodes?country=' + country + '&state=' + state + '&region=' + region, { headers: this.headers });
    }
    savesubscription(dealerbasicinfo: any) {
        return this.http.post(this._uri + 'api/dealer/SubscribeSBL', dealerbasicinfo, { headers: this.headers });
    }
    save(statements: any) {
        var data = this.http.post(this._uri + 'api/user/Save', statements, { headers: this.headers });
        return data;
    }
    getdealer(dealerId: any) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId, { headers: this.headers });
    }
    //resource managements
    getresources(dealerId) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    }
    getleads(dealerId: any) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId + '/search', { headers: this.headers });
    }
    getlead(leadId: any) {
        return this.http.get(this._uri + 'api/dealer/search/' + leadId, { headers: this.headers });
    }
    getquotes(leadid: any, dealerid: any) {
        return this.http.get(this._uri + 'api/getExtQtSearchInfoIdDealrId?leadId=' + leadid + '&dealerId=' + dealerid, { headers: this.headers });
    }
    createquote(quote: any) {
        return this.http.put(this._uri + 'api/dealerQuotCreation', quote, { headers: this.headers });
    }
    getvehicles(dealerId: any) {
        return this.http.get(this._uri + 'api/dealer/' + dealerId + '/inventory', { headers: this.headers });
    }
    getinventory(invId: any) {
        return this.http.get(this._uri + 'api/inventory/' + invId, { headers: this.headers });
    }

    updateresource(resourceid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    }

    deleteresource(resourceid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    }
    saveresource(dealerid) {
        return this.http.get(this._uri + 'api/resources?dealerid=1', { headers: this.headers });
    }
    saveinventory(inventory) {
        if (inventory.repoId == undefined || inventory.repoId == null)
            return this.http.post(this._uri + 'api/dealer/addInventory', inventory, { headers: this.headers });
        else
            return this.http.put(this._uri + 'api/dealer/updateInventory', inventory, { headers: this.headers });
    }
    validateDealerContext(dealer: any) {
        return this.http.post(this._uri + 'api/interDeal/verify', dealer, { headers: this.headers });
    }
    sendContext(email: string) {
        return this.http.post(this._uri + 'api/dealer', dealer, { headers: this.headers });
    }
    createDealerContext(dealer: any) {
        return this.http.post(this._uri + 'api/interDeal/login', dealer, { headers: this.headers });
    }
}





