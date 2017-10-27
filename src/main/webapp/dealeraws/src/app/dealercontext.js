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
var DealerContext = (function () {
    function DealerContext(dataService, route, _service, formBuilder, router, shareservice) {
        this.dataService = dataService;
        this.route = route;
        this._service = _service;
        this.formBuilder = formBuilder;
        this.router = router;
        this.shareservice = shareservice;
        this.isinsign = true;
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:
        this.loader = shareservice.loader;
    }
    DealerContext.prototype.ngOnInit = function () {
        this.formValidation();
    };
    DealerContext.prototype.formValidation = function () {
        this.loginGroup = this.formBuilder.group({
            email: ['', [forms_1.Validators.required, forms_1.Validators.email]],
            password: ['', [forms_1.Validators.required, forms_1.Validators.minLength(6)]]
        }); //, { validator: this.validatePriceRange }   Validators.compose([Validators.required, this.checkIfA])
        this.registerGroup = this.formBuilder.group({
            email: ['', [forms_1.Validators.required, forms_1.Validators.email]],
            password: ['', [forms_1.Validators.required, forms_1.Validators.minLength(6)]],
            confmPassword: ['', [forms_1.Validators.required, forms_1.Validators.minLength(6)]],
            firstName: ['', [forms_1.Validators.required, forms_1.Validators.minLength(2)]],
            lastName: ['', [forms_1.Validators.required, forms_1.Validators.minLength(2)]]
        }, { validator: this.pwdcheck });
        this.forgotGroup = this.formBuilder.group({
            email: ['', [forms_1.Validators.required, forms_1.Validators.email]]
        });
    };
    DealerContext.prototype.pwdcheck = function (formgroup) {
        if (formgroup.controls["password"].value != formgroup.controls["confmPassword"].value) {
            formgroup.controls["confmPassword"].setErrors({ 'mismatch': true });
            return { 'mismatch': true };
        }
        else {
            return null;
        }
    };
    DealerContext.prototype.resetforms = function () {
        this.forgotGroup.reset();
        this.registerGroup.reset();
        this.loginGroup.reset();
    };
    DealerContext.prototype.showforgot = function () {
        this.forgotGroup.enable();
        this.registerGroup.disable();
        this.loginGroup.disable();
        this.isforgot = true;
        this.resetforms();
    };
    DealerContext.prototype.showlogin = function () {
        this.forgotGroup.disable();
        this.registerGroup.disable();
        this.loginGroup.enable();
        this.isinsign = true;
        this.isforgot = false;
        this.resetforms();
    };
    DealerContext.prototype.showsignup = function () {
        this.forgotGroup.disable();
        this.registerGroup.enable();
        this.loginGroup.disable();
        this.isinsign = false;
        this.isforgot = false;
        this.resetforms();
    };
    DealerContext.prototype.createDealerContext = function () {
        var _this = this;
        try {
            var l_dealer_1 = this.registerGroup.value;
            this.shareservice.showLoader();
            this._service.createDealerContext(l_dealer_1).subscribe(function (data) {
                if (data != undefined) {
                    _this.shareservice.hideLoader();
                    var l_response = JSON.parse(data['_body']);
                    models_1.shareService.p_dealer = l_response;
                    models_1.UIStorage.deleteCookie('dealerId');
                    models_1.UIStorage.setCookie('dealerId', l_response.dealerId);
                    var type = sessionStorage.getItem('subscriptiontype');
                    _this.setUser(l_dealer_1.email);
                    if (type != undefined && type != null)
                        _this.router.navigate(['/subscribe']);
                    else
                        _this.router.navigate(['/home']);
                }
            }, function (err) {
                _this.shareservice.hideLoader();
                console.log(err);
            });
        }
        catch (err) {
            this.message = err;
        }
    };
    DealerContext.prototype.setUser = function (email) {
        var l_usrContext = new models_1.userContext();
        l_usrContext.userName = email;
        l_usrContext.isLoggedIn = true;
        this.dataService.sendMessage(l_usrContext);
    };
    DealerContext.prototype.validateDealerContext = function () {
        var _this = this;
        try {
            var l_dealer_2 = this.loginGroup.value;
            //UIStorage.setCookie('dealerId', '54');
            //this.router.navigate(['/home']);
            //return;
            this.shareservice.showLoader();
            this._service.validateDealerContext(l_dealer_2).subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    models_1.shareService.p_dealer = l_response;
                    _this.shareservice.hideLoader();
                    _this.setUser(l_dealer_2.email);
                    models_1.UIStorage.setCookie('dealerId', l_response.dealerId);
                    var type = sessionStorage.getItem('subscriptiontype');
                    if (type != undefined && type != null)
                        _this.router.navigate(['/subscribe']);
                    else
                        _this.router.navigate(['/home']);
                }
            }, function (err) {
                _this.shareservice.hideLoader();
                _this.message = err;
            });
        }
        catch (err) {
            this.message = err;
        }
    };
    DealerContext.prototype.setLoginInfo = function (l_dealerId) {
        var l_usrContext = new models_1.userContext();
        l_usrContext.userName = 'test123';
        l_usrContext.isLoggedIn = true;
        this.dataService.sendMessage(l_usrContext);
    };
    DealerContext.prototype.sendContext = function () {
        var _this = this;
        try {
            this._service.sendContext('dealerId').subscribe(function (data) {
                if (data != undefined) {
                    var l_response = JSON.parse(data['_body']);
                    _this.message = 'Password is sent to your registered email';
                }
            }, function (err) {
                _this.message = err;
            });
        }
        catch (err) {
            this.message = err;
        }
    };
    return DealerContext;
}());
DealerContext = __decorate([
    core_1.Component({
        selector: 'login',
        templateUrl: 'src/views/login.html'
    }),
    __metadata("design:paramtypes", [models_1.MessageService, router_1.ActivatedRoute, dealerService_1.dealerservice, forms_1.FormBuilder, router_1.Router, models_1.shareService])
], DealerContext);
exports.DealerContext = DealerContext;
//# sourceMappingURL=dealercontext.js.map