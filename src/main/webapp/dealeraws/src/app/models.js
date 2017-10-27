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
var Subject_1 = require('rxjs/Subject');
var core_1 = require('@angular/core');
var dealerLeads = (function () {
    function dealerLeads() {
    }
    return dealerLeads;
}());
exports.dealerLeads = dealerLeads;
var offering = (function () {
    function offering() {
    }
    return offering;
}());
exports.offering = offering;
var dealer = (function () {
    function dealer() {
        this.basicInfo = new basicInfo();
        this.contactDetails = new contactDetails();
        this.make = [];
        this.model = [];
        this.areaofOperation = new areaOperation();
    }
    return dealer;
}());
exports.dealer = dealer;
var dealerBasicInfo = (function () {
    function dealerBasicInfo() {
    }
    return dealerBasicInfo;
}());
exports.dealerBasicInfo = dealerBasicInfo;
var basicInfo = (function () {
    function basicInfo() {
        this.make = [];
        this.model = [];
    }
    return basicInfo;
}());
exports.basicInfo = basicInfo;
var Service = (function () {
    function Service() {
    }
    return Service;
}());
exports.Service = Service;
var Transport = (function () {
    function Transport() {
    }
    return Transport;
}());
exports.Transport = Transport;
var Finance = (function () {
    function Finance() {
        this.insVehicles = [];
    }
    return Finance;
}());
exports.Finance = Finance;
var Insurance = (function () {
    function Insurance() {
    }
    return Insurance;
}());
exports.Insurance = Insurance;
var contactDetails = (function () {
    function contactDetails() {
    }
    return contactDetails;
}());
exports.contactDetails = contactDetails;
var areaOperation = (function () {
    function areaOperation() {
        this.postCode = [];
        this.state = [];
        this.area = [];
    }
    return areaOperation;
}());
exports.areaOperation = areaOperation;
var resource = (function () {
    function resource() {
        this.contactDetails = new contactDetails();
        this.socialMedia = [];
    }
    return resource;
}());
exports.resource = resource;
var socialMedia = (function () {
    function socialMedia() {
    }
    return socialMedia;
}());
exports.socialMedia = socialMedia;
var inventory = (function () {
    function inventory() {
        this.quotationFeatList = [];
        this.banners = [];
        this.photos = [];
        this.extras = [];
    }
    return inventory;
}());
exports.inventory = inventory;
var SellVehicle = (function () {
    function SellVehicle() {
        this.features = [];
        this.extras = [];
        this.photos = [];
    }
    return SellVehicle;
}());
exports.SellVehicle = SellVehicle;
var feature = (function () {
    function feature() {
    }
    return feature;
}());
exports.feature = feature;
var subscription = (function () {
    function subscription() {
        this.isNew = false;
        this.isPreOwned = false;
        this.isLease = false;
        this.isFinance = false;
        this.isInsurance = false;
        this.isSM = false;
        this.isTranssport = false;
        this.isSpares = false;
        this.isParking = false;
        this.isFuel = false;
        this.isOthers = false;
    }
    return subscription;
}());
exports.subscription = subscription;
var LeadDetails = (function () {
    function LeadDetails() {
        //public isNewCar: boolean;
        //public isUsedCar: boolean;
        this.makemodel = new MakeModel();
        this.userinfocheck = new UserInfoCheck();
        this.usercontext = new userContext();
        this.quotes = [];
    }
    return LeadDetails;
}());
exports.LeadDetails = LeadDetails;
var Quote = (function () {
    function Quote() {
        this.additions = [];
        this.documents = [];
        this.termsConditions = [];
        this.appointments = [];
    }
    return Quote;
}());
exports.Quote = Quote;
var dealerInfo = (function () {
    function dealerInfo() {
    }
    return dealerInfo;
}());
exports.dealerInfo = dealerInfo;
var UserInfoCheck = (function () {
    function UserInfoCheck() {
    }
    return UserInfoCheck;
}());
exports.UserInfoCheck = UserInfoCheck;
var MakeModel = (function () {
    function MakeModel() {
    }
    return MakeModel;
}());
exports.MakeModel = MakeModel;
var userContext = (function () {
    function userContext() {
        this.isLoggedIn = false;
        this.isProfile = false;
    }
    return userContext;
}());
exports.userContext = userContext;
var shareService = (function () {
    function shareService() {
        this.isOpen = false;
        this.defaultSubs = new subscription();
        this.loader = { isLoading: false };
        this.subject = new Subject_1.Subject();
        this.states = [
            "ACT",
            "NSW",
            "NT",
            "QLD",
            "SA",
            "TAS",
            "VIC",
            "WA"
        ];
    }
    shareService.prototype.showLoader = function () {
        this.loader.isLoading = true;
    };
    shareService.prototype.hideLoader = function () {
        this.loader.isLoading = false;
    };
    shareService.prototype.setLogged = function (usrCtxt) {
        this.userontext = usrCtxt;
        this.subject.next(usrCtxt);
    };
    shareService.prototype.getLogged = function () {
        return this.subject.asObservable();
    };
    shareService.prototype.nav = function () {
    };
    shareService.resources = [];
    shareService.subscriptions = [];
    shareService.inventories = [];
    shareService.isLoad = false;
    shareService.makes = [
        "Abarth", "Audi",
        "BMW",
        "Ford",
        "Holden",
        "Holden SPV",
        "Honda",
        "Hyundai",
        "Infiniti",
        "Isuzu",
        "Jaguar",
        "Jeep",
        "Kia",
        "Lamborghini",
        "Land Rover",
        "LDV",
        "Lexus",
        "Maserati",
        "Mazda",
        "Mercedes-Benz",
        "MINI",
        "Mitsubishi",
        "Nissan",
        "Tesla",
        "Toyota",
        "Volkswagen",
        "Volvo"
    ];
    shareService.models = [
        "A1",
        "A3",
        "A4",
        "A6",
        "A7",
        "A8",
        "Q2",
        "Q3",
        "Q7",
        "R8",
        "RS",
        "RS6",
        "RS7",
        "S1",
        "S3",
        "S4",
        "S6",
        "S7",
        "S8",
        "SQ7",
        "TT"
    ];
    shareService.regions = [
        "CANBERRA",
        "SOUTH CANBERRA",
        "NORTH CANBERRA",
        "WODEN VALLEY",
        "WESTON CREEK",
        "COREE",
        "BELCONNEN",
        "TUGGERANONG",
        "GUNGAHLIN"
    ];
    shareService.postcodes = [
        221,
        2600,
        2603,
        2604,
        2609
    ];
    shareService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], shareService);
    return shareService;
}());
exports.shareService = shareService;
var MessageService = (function () {
    function MessageService() {
        this.subject = new Subject_1.Subject();
    }
    MessageService.prototype.sendMessage = function (usrCtxt) {
        this.subject.next({ userName: usrCtxt.userName, isLoggedIn: usrCtxt.isLoggedIn, isProfile: usrCtxt.isProfile });
    };
    MessageService.prototype.clearMessage = function () {
        this.subject.next();
    };
    MessageService.prototype.getMessage = function () {
        return this.subject.asObservable();
    };
    MessageService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], MessageService);
    return MessageService;
}());
exports.MessageService = MessageService;
var UIStorage = (function () {
    function UIStorage() {
    }
    /**
     * Gets a single cookie by it's key
     *
     * @param  {string} name key of the Cookie
     * @returns The Cookie's value
     */
    UIStorage.getCookie = function (cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ')
                c = c.substring(1);
            if (c.indexOf(name) == 0)
                return decodeURI(c.substring(name.length, c.length));
        }
        return undefined;
    };
    /**
     * Save the Cookie
     *
     * @param  {string} name key
     * @param  {string} value Cookie's value
     * @param  {number} expires Cookie's expiration date in days from now. If it's undefined the cookie is a session Cookie
     * @param  {string} path Path relative to the domain where the cookie should be avaiable. Default / root folder
     * @param  {string} domain Domain where the cookie should be avaiable. Default current domain
     */
    UIStorage.setCookie = function (name, value, expires, path, domain) {
        if (path === void 0) { path = '/'; }
        var cookieStr = encodeURI(name) + '=' + encodeURI(value) + ';';
        if (expires) {
            var dtExpires = new Date(new Date().getTime() + expires * 1000 * 60 * 60 * 24);
            cookieStr += 'expires=' + dtExpires.toUTCString() + ';';
        }
        if (path) {
            cookieStr += 'path=' + path + ';';
        }
        if (domain) {
            cookieStr += 'domain=' + domain + ';';
        }
        document.cookie = cookieStr;
    };
    /**
    * Save the Cookie without any encoding
    *
    * @param  {string} name key
    * @param  {string} value Cookie's value
    * @param  {number} expires Cookie's expiration date in days from now. If it's undefined the cookie is a session Cookie
    * @param  {string} path Path relative to the domain where the cookie should be avaiable. Default / root folder
    * @param  {string} domain Domain where the cookie should be avaiable. Default current domain
    */
    UIStorage.setCookieWithoutEncoding = function (name, value, expires, path, domain) {
        if (path === void 0) { path = '/'; }
        var cookieStr = name + '=' + value + ';';
        if (expires) {
            var dtExpires = new Date(new Date().getTime() + expires * 1000 * 60 * 60 * 24);
            cookieStr += 'expires=' + dtExpires.toUTCString() + ';';
        }
        if (path) {
            cookieStr += 'path=' + path + ';';
        }
        if (domain) {
            cookieStr += 'domain=' + domain + ';';
        }
        document.cookie = cookieStr;
    };
    /**
 * Deletes specified Cookie based on the key
 *
 * @param  {string} name Cookie's key
 * @param  {string} path Path relative to the domain where the cookie should be avaiable. Default /
 * @param  {string} domain Domain where the cookie should be avaiable. Default current domain
 */
    UIStorage.deleteCookie = function (name, path, domain) {
        if (path === void 0) { path = '/'; }
        // If the cookie exists
        if (this.getCookie(name)) {
            this.setCookie(name, '', -1, path, domain);
        }
    };
    return UIStorage;
}());
exports.UIStorage = UIStorage;
//# sourceMappingURL=models.js.map