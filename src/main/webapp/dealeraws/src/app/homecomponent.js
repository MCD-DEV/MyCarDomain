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
var router_1 = require("@angular/router");
var HomeComponent = (function () {
    function HomeComponent(dataService, router, shareservice) {
        this.dataService = dataService;
        this.router = router;
        this.shareservice = shareservice;
        this.offerings = [];
        this.leads = [];
        this.isLoggedIn = false;
        //this.shareservice = new shareService();
        this.shareservice.defaultSubs = new models_1.subscription();
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.setOfferings();
        this.setLeads();
        var l_dealerId = models_1.UIStorage.getCookie('dealerId');
        if (l_dealerId != undefined && l_dealerId != null) {
            if (models_1.shareService.p_dealer != undefined && models_1.shareService.p_dealer != null && models_1.shareService.p_dealer.vehicleDealerDetails != undefined && models_1.shareService.p_dealer.vehicleDealerDetails != null) {
                //if (shareService.p_dealer.vehicleDealerDetails.length)
                //    this.shareservice.userontext.userName = shareService.p_dealer.vehicleDealerDetails[0].dealername;
                for (var i = 0; i < this.offerings.length; i++) {
                    var l_vehicles = models_1.shareService.p_dealer.vehicleDealerDetails.filter(function (p) { return p.subscriptionType == _this.offerings[i].type; });
                    if (l_vehicles != undefined && l_vehicles.length > 0)
                        this.offerings[i].isSubscribed = true;
                }
            }
            else {
                //this.getdealer(l_dealerId);
            }
        }
    };
    HomeComponent.prototype.getdealer = function (dealerId) {
        var _this = this;
        try {
            this._service.getdealer(+dealerId).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    models_1.shareService.p_dealer = l_response;
                    _this.setUser(l_response.dealerName);
                }
            }, function (err) {
                console.log(err);
            });
        }
        catch (err) {
        }
    };
    HomeComponent.prototype.setUser = function (email) {
        var l_usrContext = new models_1.userContext();
        l_usrContext.userName = email;
        l_usrContext.isLoggedIn = true;
        this.dataService.sendMessage(l_usrContext);
    };
    HomeComponent.prototype.subscribe = function (item) {
        sessionStorage.setItem('subscriptiontype', item.type);
        var l_dealerId = models_1.UIStorage.getCookie('dealerId');
        if (l_dealerId != undefined && l_dealerId != null)
            this.router.navigate(['/subscribe']);
        else
            this.router.navigate(['/login']);
    };
    HomeComponent.prototype.setOfferings = function () {
        this.offerings.push(this.offering('SellVehicle', 'Sell Vehicle', false, 0, 0, 'Total Leads', 'Value', false, 'images/sell_vehicle.jpg', 'flaticon-car-steering-wheel', true));
        this.offerings.push(this.offering('LeaseVehicle', 'Lease Vehicle', true, 0, 0, 'Total Leads', 'Value', false, 'images/buy_vehicle.jpg', 'flaticon-car-steering-wheel', true));
        this.offerings.push(this.offering('BuyVehicle', 'Buy Vehicle', true, 0, 0, 'Total Leads', 'Value', false, 'images/buy_vehicle.jpg', 'flaticon-car-steering-wheel', true));
        this.offerings.push(this.offering('Insurance', 'Insurance', false, 0, 0, 'Total Leads', 'Value', false, 'images/car_insurance.jpg', 'flaticon-umbrella', true));
        this.offerings.push(this.offering('Finance', 'Finance', false, 0, 0, 'Total Leads', 'Value', false, 'images/car-finance.jpg', 'flaticon-money-bag-with-dollar-symbol', true));
        this.offerings.push(this.offering('Servicemaintenance', 'Service & Maintenance', false, 0, 0, 'Total Leads', 'Value', false, 'images/service_maintenance.jpg', 'flaticon-work-tools-cross', true));
        this.offerings.push(this.offering('Transport', 'Transport', false, 0, 0, 'Total Leads', 'Value', false, 'images/service_maintenance.jpg', 'flaticon-work-tools-cross', true));
        this.offerings.push(this.offering('Fuel', 'Fuel', false, 0, 0, 'Total Leads', 'Value', false, 'images/fuel_cards.jpg', 'flaticon-money-bag-with-dollar-symbol', false));
        this.offerings.push(this.offering('Sparesaccessories', 'Spares & Accessories', false, 0, 0, 'Total Leads', 'Value', false, 'images/spares.jpg', 'flaticon-money-bag-with-dollar-symbol', false));
        //this.offerings.push(this.offering('Others', 'Others', false, 0, 0, 'Total Leads', 'Value', false, 'images/miscellaneous.jpg', 'flaticon-money-bag-with-dollar-symbol'));
    };
    HomeComponent.prototype.setLeads = function () {
        this.leads.push(this.offering('SellVehicle', 'Sell Vehicle', false, 0, 0, 'Total Leads', 'Value', false, 'images/sell_vehicle.jpg', 'flaticon-car-steering-wheel'));
        this.leads.push(this.offering('LeaseVehicle', 'Lease Vehicle', true, 0, 0, 'Total Leads', 'Value', false, 'images/buy_vehicle.jpg', 'flaticon-car-steering-wheel'));
        this.leads.push(this.offering('BuyVehicle', 'Buy Vehicle', true, 0, 0, 'Total Leads', 'Value', false, 'images/buy_vehicle.jpg', 'flaticon-car-steering-wheel'));
        this.leads.push(this.offering('Insurance', 'Insurance', false, 0, 0, 'Total Leads', 'Value', false, 'images/car_insurance.jpg', 'flaticon-umbrella'));
        this.leads.push(this.offering('Finance', 'Finance', false, 0, 0, 'Total Leads', 'Value', false, 'images/car-finance.jpg', 'flaticon-money-bag-with-dollar-symbol'));
        this.leads.push(this.offering('Servicemaintenance', 'Service & Maintenance', false, 0, 0, 'Total Leads', 'Value', false, 'images/service_maintenance.jpg', 'flaticon-work-tools-cross'));
        this.leads.push(this.offering('Transport', 'Transport', false, 0, 0, 'Total Leads', 'Value', false, 'images/service_maintenance.jpg', 'flaticon-work-tools-cross'));
        this.leads.push(this.offering('Fuel', 'Fuel', false, 0, 0, 'Total Leads', 'Value', false, 'images/fuel_cards.jpg', 'flaticon-money-bag-with-dollar-symbol'));
        this.leads.push(this.offering('Sparesaccessories', 'Spares & Accessories', false, 0, 0, 'Total Leads', 'Value', false, 'images/spares.jpg', 'flaticon-money-bag-with-dollar-symbol'));
        //this.leads.push(this.offering('Others', 'Others', false, 0, 0, 'Total Leads', 'Value', false, 'images/miscellaneous.jpg', 'flaticon-money-bag-with-dollar-symbol'));
    };
    HomeComponent.prototype.offering = function (type, displayName, isSubscribed, count, leadCount, leadName, valueName, isSubShow, url, icon, show) {
        return { type: type, displayName: displayName, isSubscribed: false, count: 0, leadCount: 0, leadName: leadName, valueName: valueName, isSubShow: isSubShow, url: url, icon: icon, show: show };
    };
    HomeComponent.prototype.editSubscription = function (item) {
        sessionStorage.setItem('subscriptiontype', item.type);
        this.router.navigate(['/subscribe']);
    };
    HomeComponent.prototype.showSubscription = function (item) {
        item.isSubShow = item.isSubShow ? false : true;
    };
    HomeComponent.prototype.comingsoon = function (l_type) {
        if (l_type === 'Fuel' || l_type === 'Sparesaccessories')
            return true;
    };
    HomeComponent.prototype.showSubs = function (l_type) {
        if (l_type === 'Fuel' || l_type === 'Sparesaccessories')
            this.isSubShow = false;
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    core_1.Component({
        selector: 'content',
        templateUrl: 'src/views/homecontent.html'
    }),
    __metadata("design:paramtypes", [models_1.MessageService, router_1.Router, models_1.shareService])
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=homecomponent.js.map