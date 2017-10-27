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
var AppComponent = (function () {
    function AppComponent(shareservice, messageService, eref) {
        var _this = this;
        this.shareservice = shareservice;
        this.messageService = messageService;
        this.eref = eref;
        this.isProfile = false;
        this.userCtxt = {};
        this.shareservice = new models_1.shareService();
        this.loader = shareservice.loader;
        //this.subscription = this.shareservice.getLogged().subscribe(p => { this.userontext = p; });
        this.subscription = this.messageService.getMessage().subscribe(function (p) { _this.userCtxt = p; });
    }
    AppComponent.prototype.onClick = function (event) {
        //if (!this.eref.nativeElement.contains(event.target)) // or some similar check
        if (!this.isProfile) {
            this.userCtxt.showProfile = false;
        }
        this.isProfile = false;
    };
    AppComponent.prototype.ngOnInit = function () {
        //let l_dealerId = UIStorage.getCookie('dealerId');
        //if (l_dealerId != undefined && l_dealerId != null) {
        //    this.usercontext.isLoggedIn = true;
        //} else
        //    this.usercontext.isLoggedIn = false;
    };
    AppComponent.prototype.logout = function () {
        this.userCtxt.isLoggedIn = false;
        models_1.UIStorage.deleteCookie('dealerId');
    };
    AppComponent.prototype.showprofile = function () {
        this.userCtxt.showProfile = true;
        this.isProfile = true;
    };
    AppComponent.prototype.ngOnDestroy = function () {
        // unsubscribe to ensure no memory leaks
        this.subscription.unsubscribe();
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        templateUrl: 'src/views/index.html',
        host: {
            '(document:click)': 'onClick($event)',
        }
    }),
    __metadata("design:paramtypes", [models_1.shareService, models_1.MessageService, core_1.ElementRef])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.js.map