/**
 * Its all about Car detail screen
 */
// Check if "key" exists in the storage
var value = $.jStorage.get("key");
if(!value){
    // if not - load the data from the server
//alert("can inside");
    /*value = ()*/
    // and save it
    $.jStorage.set("key",value);
}
//alert("can"+value.userId);


var value1 = $.jStorage.get("carKey");
if(!value1){
    // if not - load the data from the server
//alert("can inside");
    /*value1 = load_data_from_server()*/
    // and save it
    $.jStorage.set("carKey",value1);
}
//alert(value1.priceMin+"&priceMax="+value1.priceMax+"I can user");
//alert(JSON.stringify(value1));
console.log(JSON.stringify(value1));
function signingout(){
	
	 $.jStorage.deleteKey("key");
	 $.jStorage.deleteKey("carKey");
	 alert("Successfully Logged Out");
	 window.location="homepage10.html";
}

var modelYear=null;
    var modelDisplay =null;
    var modelName = null;
    var trimValue =  null;
    var modelTrim = null;
    var userId = null;
    firstName=null;
    searchId=null;
    window.onload= function()
    {
    	/* alert("pageName 11  now "); */
    	
    	var priceMin = value1.priceMin;
    	document.getElementById('minValue').innerHTML=priceMin;
    	
    	var priceMax = value1.priceMax;
    	document.getElementById('maxValue').innerHTML=priceMax;
    	
    	var insMin = value1.insMin;
    	document.getElementById('insMin').innerHTML=insMin;
    	
    	var insMax = value1.insMax;
    	document.getElementById('insMax').innerHTML=insMax;
    	
    	var avgSavMin = value1.avgSavMin;
    	document.getElementById('avgSavMin').innerHTML=avgSavMin;
    	
    	var avgSavMax = value1.avgSavMax;
    	document.getElementById('avgSavMax').innerHTML=avgSavMax;
    	
    	var finMin = value1.finMin;
    	document.getElementById('finMin').innerHTML=finMin;
    	
    	var finMax = value1.finMax;
    	document.getElementById('finMax').innerHTML=finMax;
    	
    	var noDealers = value1.noDealers;
    	document.getElementById('noDealers').innerHTML=noDealers;
    	
    	var noStock = value1.noStock;
    	document.getElementById('noStock').innerHTML=noStock;
    	modelYear = value1.modelYear;
    	modelDisplay = value1.modelDisplay;
    	modelName = value1.modelName;
    	modelTrim = value1.modelTrim;
    	trimValue = value1.trimValue;
    	firstName = value.firstName;
    	userId = value.userId;
    	
    	/*alert("yr"+modelYear);
    	alert("model"+modelDisplay);
    	alert("Make"+modelName);
    	alert("modelTrim"+modelTrim);
    	alert("trimValue"+trimValue);
    	alert("firstName"+firstName)
    	
    	alert(userId);
    	alert("inside abc userid"+firstName);*/
    	if(userId!= null){
			//alert(firstName);
			document.getElementById('welcomeDiv').style.display = "block";
			document.getElementById('welcomeDiv1').style.display = "none";
			document.getElementById('userId').innerHTML="<b>"+"Hi "+firstName+"</b>";
		}
/* alert("in onload now"); */
    	
         
      
      var carquery = new CarQuery();
      carquery.init();
     /*  alert("came here"+trimValue); */
    	carquery.populateCarDataSpec('car-model-data',value1); 
    	/* carquery.initYearMakeModelTrim('car-years', 'car-makes', 'car-models', 'car-model-trims'); */
    	/* alert("pageName  22 now "+document.getElementById('minValue').innerHTML);
    	alert("pageName  12322 now "+document.getElementById('maxValue').innerHTML); */
    }
    
    
    

    function redirect() {
    	alert("Thank You. Your are redirected.. ");
    	//alert("userid"+userId);
    	var url="dashboard1.html";
    	//var url="dashboard1.html?userId="+userId+"&searchId="+searchId+"&firstName="+firstName;
    	
    	window.location=url;
    }
    
    
    //angular js
    
    

	var mainApp1 = angular.module("mainApp1", []);
	mainApp1.controller('myController1',function($scope,$http) {
		//alert("inside c"+$('#dateofbirth').val());
		//alert($scope.dateofbirth);
		
		
		$scope.submitSearchForm = function (isValid) {													
 														//alert("submit form");
 														//alert(isValid);
													if(isValid)
														{
														var jsonInputToAPI = 
														{
																"userId":userId,
																"searchLead":{
																	"modelYear":modelYear,
																	"modelDisplay": modelDisplay,
																	"modelName": modelName,															      
																	"modelTrim": modelTrim,
																			"carColor" : $('#carColor').val(),
																			 "postCode":$('#postCode').val(),
																			"make":$('#seats').val(),
																			"bodyType":$('#driveType').val(),
																			"state":$('#fuelType').val(),
																			"region":$('#freetext').val(),
																			"ausCapTer":$('#vehiclePurpose').val(),
																			"region":$('#transmission').val(),
																			"sMake":$('#extraExternal1').val(),
																			"extraExter2":$('#extraExternal2').val(),
																			"extraExter3":$('#extraExternal3').val(),	
																			"extraExter4":$('#extraExternal4').val(),	
																			"extraExter5":$('#extraExternal5').val(),	
																			"extraIntern1":$('#extraInternal1').val(),	
																			"extraIntern2":$('#extraInternal2').val(),	
																			"extraIntern3":$('#extraInternal3').val(),	
																			"extraIntern4":$('#extraInternal4').val(),	
																			"extraIntern5":$('#extraInternal5').val()
																},
																"financeLead":{
																	"modelYear":modelYear,
																	"modelDisplay": modelDisplay,
																	"modelName": modelName,															      
																	"modelTrim": modelTrim,
																	"postCode":$('#postCode').val(),
																	"incomeType":$('#incomeType').val(),
																	"yearEmploymentBusiness":$('#yearEmployement').val(),
																	"incomeBeforeSuperTax":$('#incomebefore').val(),
																	"incomeAfterSuperTax":$('#incomeAfter').val(),
																	"ifBusinessProvideABN":$('#ifBusPABN').val(),
																	"creditRating":$('#creditRating').val(),
																	"vehValue":$('#vehValue').val(),
																	"balloonPay":$('#balloonPay').val(),
																	"annualIncome":$('#annualIncome').val(),
																	"loanAmount":$('#loanAmount').val(),
																	 "loanPeriod":$('#loanPeriod').val(),
																	 "dateOfBirth":null,
																	 "noOfDependence":$('#noDependencies').val()
																},
																"insuranceLead":{
																	"modelYear":modelYear,
																	"modelDisplay": modelDisplay,
																	"modelName": modelName,															      
																	"modelTrim": modelTrim,
																	"postCode":$('#postCode').val(),
																	"insuranceType":$('#insuranceType').val(),
																	"regNo":$('#reg-no').val(),
																	"regoState":$('#regoState').val(),
																	"marketValue":$('#marketValue').val(),
																	"agreedValue":$('#agreedValue').val(),
																	"otherIssues":$('#OtherIssue').val(),
																	"prefExcessAmount":$('#insuranceExcessAmount').val(),
																	"drivingLicenceType":$('#drivingLicenseType').val(),
																	"drivingLicenceNumber":$('drivingLicenseNumber').val(),
																	"drivingLicenceIssuingState":$('drivingLicenseIssuingState').val(),
																	"noOfAtFaultClaims":$('noOfAtFaultsClaims').val(),
																	"dateOfBirth":null,
																	"indicativeExcessAmount":$('indicativeExcessAmount').val(),
																	"ageOfAdditionalDriver":null
																}
															}

														$body = $("body");
														$body.addClass("loading");
													   
														//alert("Before Call");
														var wsURL = 'api/eBid/car';
														//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/car';
														//var wsURL = 'http://www.autoscoop.com.au/api/eBid/car';
																   $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI
																							
																		}).success(function(data) {
																			$body.removeClass("loading");
																			alert("Successfully Stored.. ");
																			var url="dashboard1.html";
																			/*var url="dashboard1.html?userId="+data.userId+"&searchId="+ data.searchId+"&firstName="+firstName;*/
																							alert("Thank You. Your Seach ID is " + data.searchId);
																							window.location=url;								
																						}); 
														}
													else
														{
														alert("Please enter the fields which are mandatory and highlighted in Red.");
														//$("form:input.ng-invalid,select.ng-invalid").first().focus();
														$('input.ng-invalid').first().focus();
														$('select.ng-invalid').first().focus();
														}
																										
													};
					});
