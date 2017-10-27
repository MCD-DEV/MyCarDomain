"use strict";
var VehicleDealerAreaOfOperState = (function () {
    function VehicleDealerAreaOfOperState() {
    }
    return VehicleDealerAreaOfOperState;
}());
exports.VehicleDealerAreaOfOperState = VehicleDealerAreaOfOperState;
var VehicleDealerAreaOfOperPostCode = (function () {
    function VehicleDealerAreaOfOperPostCode() {
    }
    return VehicleDealerAreaOfOperPostCode;
}());
exports.VehicleDealerAreaOfOperPostCode = VehicleDealerAreaOfOperPostCode;
var VehicleDealerAreaOfOperRegion = (function () {
    function VehicleDealerAreaOfOperRegion() {
    }
    return VehicleDealerAreaOfOperRegion;
}());
exports.VehicleDealerAreaOfOperRegion = VehicleDealerAreaOfOperRegion;
var VehicleDealerInsDetails = (function () {
    function VehicleDealerInsDetails() {
    }
    return VehicleDealerInsDetails;
}());
exports.VehicleDealerInsDetails = VehicleDealerInsDetails;
var Dealer = (function () {
    function Dealer() {
        this.vehicleDealerDetails = [];
        this.vehicleDealerMakeList = [];
        this.vehicleDealerAreaOfOperState = [];
        this.vehicleDealerRegion = [];
        this.vehicleDealerPostCode = [];
        this.financeEntity = null;
    }
    return Dealer;
}());
exports.Dealer = Dealer;
var FinanceEntity = (function () {
    function FinanceEntity() {
    }
    return FinanceEntity;
}());
exports.FinanceEntity = FinanceEntity;
var DealerSearch = (function () {
    function DealerSearch() {
    }
    return DealerSearch;
}());
exports.DealerSearch = DealerSearch;
var VehicleQuotation = (function () {
    function VehicleQuotation() {
        this.vehQuotExtras = [];
        this.vehQuotDoc = [];
        this.vehQuotTerm = [];
        this.offerDateList = [];
    }
    return VehicleQuotation;
}());
exports.VehicleQuotation = VehicleQuotation;
var OfferDateList = (function () {
    function OfferDateList() {
    }
    return OfferDateList;
}());
exports.OfferDateList = OfferDateList;
var VehQuotDoc = (function () {
    function VehQuotDoc() {
    }
    return VehQuotDoc;
}());
exports.VehQuotDoc = VehQuotDoc;
var VehQuotExtras = (function () {
    function VehQuotExtras() {
    }
    return VehQuotExtras;
}());
exports.VehQuotExtras = VehQuotExtras;
var offerDateList = (function () {
    function offerDateList() {
    }
    return offerDateList;
}());
exports.offerDateList = offerDateList;
var VehQuotTerm = (function () {
    function VehQuotTerm() {
    }
    return VehQuotTerm;
}());
exports.VehQuotTerm = VehQuotTerm;
var VehicleDealerDetails = (function () {
    function VehicleDealerDetails() {
        this.insVehicles = []; //type of vehicles (car,boat,...)
        this.vehicleDealerMakeList = [];
        this.vehicleDealerAreaOfOperState = [];
        this.vehicleDealerRegion = [];
        this.vehicleDealerPostCode = [];
        this.vehicleDealerInsDetails = [];
    }
    return VehicleDealerDetails;
}());
exports.VehicleDealerDetails = VehicleDealerDetails;
var VehicleDealerMakeList = (function () {
    function VehicleDealerMakeList() {
    }
    return VehicleDealerMakeList;
}());
exports.VehicleDealerMakeList = VehicleDealerMakeList;
var VehicleDealerTranspDetails = (function () {
    function VehicleDealerTranspDetails() {
    }
    return VehicleDealerTranspDetails;
}());
exports.VehicleDealerTranspDetails = VehicleDealerTranspDetails;
var VehicleDealerFinanceDetails = (function () {
    function VehicleDealerFinanceDetails() {
        this.insVehicles = []; //type of vehicles (car,boat,...)
    }
    return VehicleDealerFinanceDetails;
}());
exports.VehicleDealerFinanceDetails = VehicleDealerFinanceDetails;
var VehicleDealerInsuranceDetails = (function () {
    function VehicleDealerInsuranceDetails() {
    }
    return VehicleDealerInsuranceDetails;
}());
exports.VehicleDealerInsuranceDetails = VehicleDealerInsuranceDetails;
var VehicleDealerServMaintDetails = (function () {
    function VehicleDealerServMaintDetails() {
    }
    return VehicleDealerServMaintDetails;
}());
exports.VehicleDealerServMaintDetails = VehicleDealerServMaintDetails;
//# sourceMappingURL=servermodels.js.map