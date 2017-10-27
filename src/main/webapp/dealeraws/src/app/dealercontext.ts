import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { shareService, dealerInfo, userContext, UIStorage, MessageService } from './models';
import { Dealer } from './servermodels';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
    selector: 'login',
    templateUrl: 'src/views/login.html'
})


export class DealerContext {
    loginGroup: FormGroup;
    registerGroup: FormGroup;
    forgotGroup: FormGroup;
    private isinsign: boolean = true;
    private isforgot: boolean;
    private message: string;
    private loader: any;
    constructor(private dataService: MessageService, private route: ActivatedRoute, private _service: dealerservice, private formBuilder: FormBuilder, private router: Router, private shareservice: shareService) {
        //private userinfocheck: UserInfoCheck, private usercontext: userContext, private makemodel: MakeModel, private leaddetails:
        this.loader = shareservice.loader;
    }

    ngOnInit() {
        this.formValidation();
    }

    formValidation() {
        this.loginGroup = this.formBuilder.group({

            email: ['', [Validators.required, Validators.email]],

            password: ['', [Validators.required, Validators.minLength(6)]]

        });//, { validator: this.validatePriceRange }   Validators.compose([Validators.required, this.checkIfA])
        this.registerGroup = this.formBuilder.group({
            email: ['', [Validators.required, Validators.email]],

            password: ['', [Validators.required, Validators.minLength(6)]],
            confmPassword: ['', [Validators.required, Validators.minLength(6)]],
            firstName: ['', [Validators.required, Validators.minLength(2)]],
            lastName: ['', [Validators.required, Validators.minLength(2)]]

        }, { validator: this.pwdcheck });
        this.forgotGroup = this.formBuilder.group({

            email: ['', [Validators.required, Validators.email]]
        });
    }
    pwdcheck(formgroup: FormGroup) {
        if (formgroup.controls["password"].value != formgroup.controls["confmPassword"].value) {
            formgroup.controls["confmPassword"].setErrors({ 'mismatch': true });
            return { 'mismatch': true }
        }
        else {
            return null;
        }
    }
    resetforms() {
        this.forgotGroup.reset();
        this.registerGroup.reset();
        this.loginGroup.reset();
    }
    showforgot() {
        this.forgotGroup.enable();
        this.registerGroup.disable();
        this.loginGroup.disable();
        this.isforgot = true;
        this.resetforms();
    }
    showlogin() {
        this.forgotGroup.disable();
        this.registerGroup.disable();
        this.loginGroup.enable();
        this.isinsign = true;
        this.isforgot = false;
        this.resetforms();
    }
    showsignup() {
        this.forgotGroup.disable();
        this.registerGroup.enable();
        this.loginGroup.disable();
        this.isinsign = false;
        this.isforgot = false;
        this.resetforms();
    }

    createDealerContext() {
        try {
            let l_dealer = this.registerGroup.value;
            this.shareservice.showLoader();
            this._service.createDealerContext(l_dealer).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        shareService.p_dealer = l_response;
                        UIStorage.deleteCookie('dealerId');
                        UIStorage.setCookie('dealerId', l_response.dealerId);
                        let type = sessionStorage.getItem('subscriptiontype');
                        this.setUser(l_dealer.email);

                        if (type != undefined && type != null)
                            this.router.navigate(['/subscribe']);
                        else
                            this.router.navigate(['/home']);
                    }
                },
                err => {
                    this.shareservice.hideLoader();
                    console.log(err);
                }
            );
        }
        catch (err) {
            this.message = err;
        }
    }
    setUser(email:string) {
        let l_usrContext: userContext = new userContext();
        l_usrContext.userName = email;
        l_usrContext.isLoggedIn = true;
        this.dataService.sendMessage(l_usrContext);
    }
    validateDealerContext() {
        try {
            let l_dealer = this.loginGroup.value;

            

            
            //UIStorage.setCookie('dealerId', '54');
            //this.router.navigate(['/home']);
            //return;
            this.shareservice.showLoader();
            this._service.validateDealerContext(l_dealer).subscribe(
                data => {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        shareService.p_dealer = l_response;
                        this.shareservice.hideLoader();
                        this.setUser(l_dealer.email);

                        UIStorage.setCookie('dealerId', l_response.dealerId);
                        let type = sessionStorage.getItem('subscriptiontype');
                        if (type != undefined && type != null)
                            this.router.navigate(['/subscribe']);
                        else
                            this.router.navigate(['/home']);
                    }
                },
                err => {
                    this.shareservice.hideLoader();
                    this.message = err;
                }
            );
        }
        catch (err) {
            this.message = err;
        }
    }

    setLoginInfo(l_dealerId: any) {
        let l_usrContext: userContext = new userContext();
        l_usrContext.userName = 'test123';
        l_usrContext.isLoggedIn = true;
        this.dataService.sendMessage(l_usrContext);
    }

    sendContext() {
        try {
            this._service.sendContext('dealerId').subscribe(
                data => {
                    if (data != undefined) {
                        var l_response = JSON.parse(data['_body']);
                        this.message = 'Password is sent to your registered email';
                    }
                },
                err => {
                    this.message = err;
                }
            );
        }
        catch (err) {
            this.message = err;
        }
    }



}