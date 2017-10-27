export class VehicleDealerAreaOfOperState {
    public country: string;
    public state: string;
    public offered: boolean;
}

export class VehicleDealerAreaOfOperPostCode {

    public country: string;
    public state: string;
    public region: string;
    public postCode: string;

}

export class VehicleDealerAreaOfOperRegion {

    public country: string;
    public state: string;
    public region: string;
    public offered: boolean;

}

export class VehicleDealerInsDetails {
    public flex1: string;
}
export class Dealer {

    public dealerId: string;
    public password: string;
    public email: string;
    public isAdmin: boolean;
    public isDealer: boolean;
    public isInsurer: boolean;
    public isFinancer: boolean;

    public vehicleDealerDetails: Array<VehicleDealerDetails> = [];
    public vehicleDealerMakeList: Array<VehicleDealerMakeList> = [];
    public vehicleDealerAreaOfOperState: Array<VehicleDealerAreaOfOperState> = [];
    public vehicleDealerRegion: Array<VehicleDealerAreaOfOperRegion> = [];
    public vehicleDealerPostCode: Array<VehicleDealerAreaOfOperPostCode> = [];
    public vehicleDealerInsuranceDetails: Array<VehicleDealerInsuranceDetails>;
    public vehicleDealerFinanceDetails: Array<VehicleDealerFinanceDetails>;
    public vehicleDealerServMaintDetails: Array<VehicleDealerServMaintDetails>;
    public financeEntity: Array<VehicleDealerFinanceDetails> = null;
    public vehicleDealerTranspDetails: Array<VehicleDealerTranspDetails>;
}
export class FinanceEntity {

}
export class DealerSearch {
    public dealerSearchId: number;
    public ageOfAdditionalDriver: string;
    public modelYear: string;
    public modelDisplay: string;
    public modelName: String;
    public sModel: string;
    public finance: boolean;
    public insurance: boolean;
    public userId: number;
    public carSearchId: number;
    public mobileCheck: boolean;
    public idCheck: boolean;
}
export class VehicleQuotation {
    public quotId: number;
    public dealerId: number;
    public userId: number;
    public userCreationDate: string;
    public creationDate: string;
    public dealSearchId: number;
    public carSearchId: number;
    public refId: number;
    public modelYear: string;
    public modelDisplay: string;
    public modelName: string;
    public modelTrim: string;
    public vehQuotExtras: Array<VehQuotExtras> = [];
    public vehQuotDoc: Array<VehQuotDoc> = [];
    public vehQuotTerm: Array<VehQuotTerm> = [];
    public offerDateList: Array<OfferDateList> = [];
    public driveAwayPrice: number;
    public quotDate: string;
    public autoscpStockNo: number;
    public dealStockNo: number;
    public basicPrice: number;
    public companyName: string;
    public mobile: string;
    public postalAddress: string;
    public stockTillAvail: boolean;
    public autoscopStockAvl: boolean;
    public offerPrice2: number;
}
export class OfferDateList {
    public offerDate: string;
}
export class VehQuotDoc {
    public amount: number;
    public extras1: number;
    public extras2: string;
    public type: string;
}

export class VehQuotExtras {
    public amount: number;
    public extras1: number;
    public extras2: string;
    public type: string;

}
export class offerDateList {
    public offerDate: string;
}

export class VehQuotTerm {
    public amount: number;
    public extras1: number;//extras1
    public extras2: string;//extras2
    public type: string;

}

export class VehicleDealerDetails {
    public vehicleType: string;
    public isNewCar: boolean;
    public isUsedCar: boolean;
    public isBoth: boolean;
    public abnnumber: string;
    public dealername: string;
    public dealerGroupName: string;//need in server
    public subscription: string; //bronze,basic...
    public subscriptionType: string;//need in server for finance,insurance...
    public acnnumber: string;
    public website: string;
    public delmobile: number;
    public landLine1: number;
    public landLine2: number;
    public streetNumber: string;
    public streetName: string;
    public areaName: string;
    public suborb: string;
    public state: string;
    public postcode: number;
    public designation: string;
    //sm
    public petrol: boolean;
    public diesel: boolean;
    public electric: boolean;
    public all1: boolean;
    public clientPlaceDriveYes: boolean;
    public clientPlaceDriveMaybe: boolean;
    public clientPlaceDriveNo: boolean;
    public roadAssistance: boolean;
    private servMaintInstitute: boolean;

    //transport
    public fromState: string;
    public toState: string;
    public fromRegion: string;
    public toRegion: string;
    public fromPost: string;
    public toPost: string;
    public stateRate: string;
    public regionRate: string;
    public postRate: string;
    public stateRoute: boolean;
    public regionRoute: boolean;
    public postRoute: boolean;

    //finance
    public isIndividual: boolean;
    public isLicensedBroker: boolean;
    public isFinancialInstitute: boolean;
    //Need these in server
    public afslNo: string;//Australian Financial Service Number
    public authRepNo: string;//Authorised Rep Number
    public aclNo: string; //Australian credi licence no
    public brokerLicenceNo: string;
    public insVehicles: Array<string> = [];//type of vehicles (car,boat,...)
    public isLoanNewVeh: boolean;
    public isLoanUsedVeh: boolean;
    //insurance
    public isComprehensive: boolean;
    public isThirdParty: boolean;
    public isThirdProperty: boolean;

    public vehicleDealerMakeList: Array<VehicleDealerMakeList> = [];
    public vehicleDealerAreaOfOperState: Array<VehicleDealerAreaOfOperState> = [];
    public vehicleDealerRegion: Array<VehicleDealerAreaOfOperRegion> = [];
    public vehicleDealerPostCode: Array<VehicleDealerAreaOfOperPostCode> = [];
    public vehicleDealerInsDetails: Array<VehicleDealerInsDetails> = [];
}

export class VehicleDealerMakeList {

    public Make: string;
}
export class VehicleDealerTranspDetails {

    public vehicleDealerTranspDetailId: number;
    public fromState: string;
    public toState: string;
    public fromRegion: string;
    public toRegion: string;
    public fromPost: string;
    public toPost: string;
    public stateRate: string;
    public regionRate: string;
    public postRate: string;
    public isStateRoute: boolean;
    public isRegionRoute: boolean;
    public isPostRoute: boolean;
}
export class VehicleDealerFinanceDetails {

    public vehicleDealerFinanceDetailId: number;

    public vehicleType: string;
    public isIndividual: boolean;
    public isLicensedBroker: boolean;
    public isFinancialInstitute: boolean;
    public isNewCar: boolean;
    public isUsedCar: boolean;
    public isBoth: boolean;
    //Need these in server
    public afslNo: string;//Australian Financial Service Number
    public authRepNo: string;//Authorised Rep Number
    public aclNo: string; //Australian credi licence no
    public brokerLicenceNo: string;
    public insVehicles: Array<string> = [];//type of vehicles (car,boat,...)
    public isLoanNewVeh: boolean;
    public isLoanUsedVeh: boolean;
}

export class VehicleDealerInsuranceDetails {

    public vehicleDealerInsuranceDetailId: number;
    public vehicleType: string;
    public isIndividual: boolean;
    public isLicensedBroker: boolean;
    public isInsuranceInstitute: boolean;
    public isNewCar: boolean;
    public isUsedCar: boolean;
    public isBoth: boolean;
    //New fields for insurance
    public afslNo: string;//Australian Financial Service Number
    public authRepNo: string;//Authorised Rep Number
    public aclNo: string; //Australian credi licence no
    public brokerLicenceNo: string;
    public insVehicles: Array<string>;//type of vehicles (car,boat,...)
    public isComprehensive: boolean;
    public isThirdParty: boolean;
    public isThirdProperty: boolean;
}

export class VehicleDealerServMaintDetails {

    private vehicleDealerServMaintDetailId: number;

    private vehicleType: string;
    private isIndividual: boolean;
    private isLicensedBroker: boolean;
    private isServMaintInstitute: boolean;
    private isNewCar: boolean;
    private isUsedCar: boolean;
    private isBoth: boolean;
    //update in server
    public isPetrol: boolean;
    public isDiesel: boolean;
    public isElectric: boolean;
    public All: boolean;
    public clientPlaceDriveYes: boolean;
    public clientPlaceDriveMaybe: boolean;
    public clientPlaceDriveNo: boolean;
    public roadAssistance: boolean;
}