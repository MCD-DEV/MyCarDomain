import { Component, OnInit, Input } from '@angular/core'
import { HttpModule } from '@angular/http';
import { inventory, shareService, UIStorage } from './models';
import { dealerservice } from './dealerService';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
    selector: 'inventory',
    templateUrl: 'src/views/inventory.html'
})


export class InventoryComponent {

    private inventories: any = [];
    private dealerId: any;
    private isRegistered: boolean;
    private inventory: inventory = new inventory();
    constructor(private router: Router, private _service: dealerservice, private shareservice: shareService) {

    }
    ngOnInit() {
        let l_dealerId = UIStorage.getCookie('dealerId');
        if (l_dealerId == undefined || l_dealerId == null) {
            this.router.navigate(['/login']);
        }
        else
            this.dealerId = l_dealerId;
        this.getvehicles();
        //if (shareService != undefined)
        //    this.inventories = shareService.inventories;
    }
    private isOpen: boolean = false;
    showLeftPanel() {
        this.shareservice.isOpen = (this.shareservice.isOpen) ? false : true;
    }
    addinventory() {
        this.router.navigate(['/addinventory']);
    }
    updateinventory(item:any) {
        sessionStorage.setItem('invid', item.repoId);
        this.router.navigate(['/addinventory']);
    }

    deleteresource(item) {
        try {
            this._service.deleteresource(item.id).subscribe(
                data => {
                    if (data != undefined) {
                        var l_response = JSON.parse(data._body);
                        this.inventories = l_response;
                    }
                },
                err => {
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
    }

    getvehicles() {
        try {
            this.shareservice.showLoader();
            this._service.getvehicles(this.dealerId).subscribe(
                data => {
                    if (data != undefined) {
                        this.shareservice.hideLoader();
                        var l_response = JSON.parse(data['_body']);
                        this.inventories = l_response;
                    }
                },
                err => {
                    this.shareservice.hideLoader();
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
    }

    saveinventory() {
        try {
            this._service.saveinventory(this.dealerId).subscribe(
                data => {
                    if (data != undefined) {
                        var l_response = JSON.parse(data._body);
                        this.resources = l_response;
                    }
                },
                err => {
                    console.log(err);
                }
            );
        }
        catch (_err) {
            console.log(_err);
        }
    }
    getrecentaccounts() {
        try {

        }
        catch (_err) {
            console.log(_err);
        }
    }
}