var value = $.jStorage.get("key");
var fbUserId = $.jStorage.get("fbKey");
var fbToken = $.jStorage.get("fbAToken");

var myVehicleIDuse=null;
function setting(data){
	$.jStorage.set('key',data);
	$.jStorage.setTTL('mykey', 30000); 
}
function refr(){
var url="Db_BetaV1.html";

window.location=url;
}
function alreadyLogged(){
	var value = $.jStorage.get("key");
	if(!value){
	return false;
	}
	else{
		return true;
	}


}
if(!alreadyLogged())
{
		var url="Hm_BetaV1.html";
		window.location=url;
}
if(!value){
    $.jStorage.set("key",value);
}

function signingout(){

	 $.jStorage.deleteKey("key");
	 $.jStorage.deleteKey("carKey");
	 $.jStorage.deleteKey("fbKey");
	 $.jStorage.deleteKey("fbAToken");
	 alert("Successfully Logged Out.. Thank you");
	 window.location="Hm_BetaV1.html";
}
function stringToDate(_date,_format,_delimiter)
{
            var formatLowerCase=_format.toLowerCase();
            var formatItems=formatLowerCase.split(_delimiter);
            var dateItems=_date.split(_delimiter);
            var monthIndex=formatItems.indexOf("mm");
            var dayIndex=formatItems.indexOf("dd");
            var yearIndex=formatItems.indexOf("yyyy");
            var month=parseInt(dateItems[monthIndex]);
            month-=1;
            var formatedDate = new Date(dateItems[yearIndex],month,dateItems[dayIndex]);
            return formatedDate;
}
var userId;
var firstName;
$(document).ready(function(){
	$body = $("body");

	$(document).ajaxStart(function(){
		$body.addClass("loading");
	});

	$(document).ajaxStop(function(){
		$body.removeClass("loading");
	});

	var userDetails ='<h2 class="box-title fullname">' + value.firstName + '</h2>\
		<dl class="term-description">\
	    <dt>user name:</dt><dd>' +value.email+ '</dd>\
	    <dt>first name:</dt><dd>' +value.firstName+ '</dd>\
	    <dt>last name:</dt><dd>' +value.lastName+ '</dd>\
	    <dt>phone number:</dt><dd>' +value.abnNumber+ '</dd>\
	    <dt>Date of Birth:</dt><dd>' +value.dateOfBirth+ '</dd>\
	    <dt>Gender:</dt><dd>' +value.gender+ '</dd>\
	    <dt>Personal Description:</dt><dd>' +value.subOrb+'</dd>\
	   <dt>Street number:</dt><dd>' +value.streetNumber+ '</dd>\
	    <dt>Street Name:</dt><dd>' +value.streetName+ '</dd>\
	    <dt>Post Code:</dt><dd>' +value.postCode+ '</dd>\
	    <dt>Region:</dt><dd>' +value.drivingLicense+ '</dd>\
	    <dt>State:</dt><dd>' +value.state+ '</dd>\
	    <dt>ZIP code:</dt><dd>' +value.postCode+ '</dd>\
	    <dt>Country:</dt><dd>Australia</dd>\
		</dl>';


	userDetails = userDetails.replace(/>null</g, ">--NA--<");
	userDetails = userDetails.replace(/>undefined</g, ">--NA--<");

	$(".userdetails").html(userDetails);
	var default1='https://elasticbeanstalk-us-east-1-675778862308.s3.amazonaws.com/dashboard.png';
	 url="";
	fbdown(value.issueState);
	 // start of image download

	 function fbdown(imageName)
	 {
    // <!-- Facebook Login logic prod 249863545451459 test 238604546585672 -->
      var appId = '249863545451459';

    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';


      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';


      AWS.config.region = 'us-east-1';






      var bucket = new AWS.S3({


          params: {


              Bucket: bucketName


          }


      });
     accessToken = $.jStorage.get("fbAToken");
			bucket.config.credentials = new AWS.WebIdentityCredentials({


	                  ProviderId: 'graph.facebook.com',


	                  RoleArn: roleArn,


	                  WebIdentityToken: accessToken


	              });


			fbUserId = $.jStorage.get("fbKey");
          fbUserId = $.jStorage.get("fbKey");
          var profilePic;
          var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: imageName, Expires: 60};
          url = bucket.getSignedUrl('getObject', params, function (err, url) {
            if (url) {
            	profilePic = '<img width="270" height="263" alt="" src="'+url+'"'+'>';
            	$("#profilePic").html(profilePic);
            }
            else{
				profilePic = '<img width="270" height="263" alt="" src="'+default1+'"'+'>';$("#profilePic").append(profilePic);
				}
          });


       }
	function parseURLParameter(Parameter)
	{

var FullURL= window.location.search.substring(1);

		var parametersArray = FullURL.split('&')

		for (var i=0; i<parametersArray.length; i++)
			{
				var currentParameter = parametersArray[i].split('=');

				if (currentParameter[0] == Parameter)
				{
					return currentParameter[1];
				}
			}
	}
	userId = value.userId;
	firstName = value.firstName;
	document.getElementById('firstName').innerHTML=value.firstName;
	//var searchId = parseURLParameter('searchId');

	if(userId!= null){
		//alert(firstName);
		document.getElementById('welcomeDiv').style.display = "block";
		document.getElementById('welcomeDiv1').style.display = "none";
		document.getElementById('userId').innerHTML="<b>"+"Hi "+firstName+"</b>";
	}
function dashBoardPhotoUpdate()
{
	var jsonInputToAPI = {"userId":userId,
			"photo":null,
			"myVehicleVO":{
				"myVehicleId":null,
				"year": $('#car-years').val(),
				"make":$('#car-makes').val(),
						"model" :$('#car-models').val(),
						 "variant":$('#car-model-trims').val(),
						"vin":$('#vin').val(),
						"regNum":$('#regNo').val(),
						"regState":$('#car-model-trims').val(),
						"regExpDate":null,
						"insProv":$('#regState').val(),
						"insProvMan":$('#insProv').val(),
						"insPremPaid":$('#insPrePaid').val(),
						"insPremPaidFreq":$('#premPaidFreq').val(),
						"insExpiry":null,
						"odoMeter":$('#odoMeter').val(),
						"lastServiceDt":null,
						"nextServiceDt":null,
						"nextServKms":$('#nextServMaiKms').val(),
						"finProvider":$('#finProv').val(),
						"loanAmt1":$('#loanAmount').val(),
						"loanTakenDt":null,
							"loanPaidFreq":$('#loanPaidFreq').val(),
						"loanAmt2":$('#laonAmount1').val(),
						"loanPeriod":$('#laonPeriod').val(),
						"loanInterest":$('#laonIntRate').val(),
							"fuelCardProvider":$('#fuelCardProv').val(),
						"valFuelCard":$('#valFuelCard').val(),
						"fuelType":$('#fuelType').val(),
							"photo1":$('#photo1').val(),
						"photo2":$('#photo2').val(),
						"photo3":$('#photo3').val(),
							"flex1":"flex1",
						"flex2":"flex1",
						"flex3":"flex1",
							"flex4":"flex1",
						"flex5":12,
						"flex6":12,
						"flex7":12,
							"flex8":null,
						"flex9":null
			}
			}
	$.ajax({
		type: "POST",
		url: "api/eBid/updatePhoto?_method=PUT",
		data: jsonInputToAPI,
		contentType:'application/json',
		success: function(result){
			alert("Successfully upated profile.. Plz wait for the image to be uploaded.. Don't refresh or switch your Dashboard..");

		}
	});

}

function dashBoardCallSearch(model_data_id, userid)
{
 this.model_data_id = model_data_id;
    var sender = this;
   var url = "api/user/"+userid;
   $('#car-model-data').html('<img src="images/LoadImg.gif"></img>');
   $('#data1').html('<img src="images/LoadImg.gif"></img>');
   $('#car-model-data2').html('<img src="images/LoadImg.gif"></img>');
   $('#quo-model-data').html('<img src="images/LoadImg.gif"></img>');
   $('#quo-data1').html('<img src="images/LoadImg.gif"></img>');
   $('#quo-model-data2').html('<img src="images/LoadImg.gif"></img>');
   $('#quo-model-data4').html('<img src="images/LoadImg.gif"></img>');
   $('#logBook4').html('<img src="images/LoadImg.gif"></img>');
   $('#fuelCard4').html('<img src="images/LoadImg.gif"></img>');
   $('#servMaint4').html('<img src="images/LoadImg.gif"></img>');

   $('#datatranspserv').html('<img src="images/LoadImg.gif"></img>');
   $('#dataservmaint').html('<img src="images/LoadImg.gif"></img>');

    $.ajax({
   	    type: "GET",
   	    url: url,
   	       success: function(result){
        	               	   //start
										var options = '<option value="">Please choose a car</option>';
										for (i = 0; i < result.myVehicle.length; i++) {
											options += '<option value="'
													+ result.myVehicle[i].myVehicleId
													+ '">'
													+ result.myVehicle[i].make
													+ '</option>';

										}
										$("#vehicleTypeLogBook").html(options);
										// end

										// start
										var option1s = '<option value="">Please choose a car</option>';
										for (i = 0; i < result.myVehicle.length; i++) {
											option1s += '<option value="'
													+ result.myVehicle[i].myVehicleId
													+ '">'
													+ result.myVehicle[i].make
													+ '</option>';

										}
										$("#vehicleTypeServMaint").html(
												option1s);
										// end

										out7 = "";

										out7 += '<tr><th>' + "My Vehicle ID"
												+ '</th><th>' + "Year"
												+ '</th><th>' + "Make"
												+ '</th><th>' + "Model"
												+ '</th></tr>';
										for (i = 0; i < result.myVehicle.length; i++) {

											out7 = out7
													+ '<tr>'
													+ '<td>'
													+ result.myVehicle[i].myVehicleId
													+ '</td>' + '<td>'
													+ result.myVehicle[i].year
													+ '</td>' + '<td>'
													+ result.myVehicle[i].make
													+ '</td>' + '<td>'
													+ result.myVehicle[i].model
													+ '</td>' + '</tr>';

										}
										out7 = out7.replace(/>null</g,
												">--NA--<");
										out7 = out7.replace(/>undefined</g,
												">--NA--<");
										forFinance("logBook4", out7);

										out9 = "";

										out9 += '<tr><th>' + "My Vehicle ID"
												+ '</th><th>' + "Year"
												+ '</th><th>' + "Make"
												+ '</th><th>' + "Model"
												+ '</th></tr>';
										for (i = 0; i < result.myVehicle.length; i++) {

											out9 = out9
													+ '<tr>'
													+ '<td>'
													+ result.myVehicle[i].myVehicleId
													+ '</td>' + '<td>'
													+ result.myVehicle[i].year
													+ '</td>' + '<td>'
													+ result.myVehicle[i].make
													+ '</td>' + '<td>'
													+ result.myVehicle[i].model
													+ '</td>' + '</tr>';

										}
										out9 = out9.replace(/>null</g,
												">--NA--<");
										out9 = out9.replace(/>undefined</g,
												">--NA--<");
										forFinance("servMaint4", out9);
           }
   	  });

}

function forFinance(model_data_id, out)
{
 this.model_data_id = model_data_id;

        	   $("#"+model_data_id).html(out);

}

});

// end of window onload


function redirect() {
	var url = "Hm_BetaV1.html?userId=" + userId + "&firstName=" + firstName;
	window.location = url;
}


//angular JS start
var mainApp1 = angular.module("mainApp13", []);
mainApp1.controller('myController13',function($scope, $http) {
	
  		$('#car-model-data').html('<img src="images/LoadImg.gif"></img>');
  		$('#data1').html('<img src="images/LoadImg.gif"></img>');
	   $('#car-model-data2').html('<img src="images/LoadImg.gif"></img>');
	   $('#quo-model-data').html('<img src="images/LoadImg.gif"></img>');
	   $('#quo-data1').html('<img src="images/LoadImg.gif"></img>');
	   $('#quo-model-data2').html('<img src="images/LoadImg.gif"></img>');
	   $('#quo-model-data4').html('<img src="images/LoadImg.gif"></img>');
	   $('#logBook4').html('<img src="images/LoadImg.gif"></img>');
	   $('#fuelCard4').html('<img src="images/LoadImg.gif"></img>');
	   $('#servMaint4').html('<img src="images/LoadImg.gif"></img>');
	   $('#datatranspserv').html('<img src="images/LoadImg.gif"></img>');
	   $('#dataservmaint').html('<img src="images/LoadImg.gif"></img>');
	   var url1 = window.location.hash;
	    if(url1 == "#l2Profile1")
	    	{
	    		 $('.tabs li:eq(3) a').tab('show');
	    		 carLogBook();
	    		 //angular.element(document.getElementById('myController13')).scope().submitForm1();
	    	}
	    else if(url1 == "#profile"){
	    	$('.tabs li:eq(1) a').tab('show');
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
	    }
	    else if(url1 == "#travel-stories"){
	    	//alert("biscuit");
	    	$('.tabs li:eq(4) a').tab('show');
	    	carEbidRequest();
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
	    }
	    else if(url1 == "#VehicleQuotation12"){
	    	//alert("biscuit");
	    	$('.tabs li:eq(2) a').tab('show');
			carVehicleGarage();
	    }
	    else if(url1 == "#loyalityProgram"){
	    	//alert("biscuit");
	    	$('.tabs li:eq(7) a').tab('show');
	    	loyalityProgram();
	    }else if(url1 == "#sellMyVehicle"){
	    	//alert("biscuit");
	    	$('.tabs li:eq(6) a').tab('show');
	    	sellMyVehicle();
	    }
	    
	    if(url1 == "#travel-stories1"){
			$('.tabs li:eq(4) a').tab('show');
			$('#radioFin').tab('show').prop("checked", true);
			carEbidRequest();
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
		}
		else if(url1 == "#travel-stories2"){
			$('.tabs li:eq(4) a').tab('show');
			$('#radioInsu').tab('show').prop("checked", true);
			carEbidRequest();
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
		}
		else if(url1 == "#travel-stories3"){
			$('.tabs li:eq(4) a').tab('show');
			$('#radioServ').tab('show').prop("checked", true);
			carEbidRequest();
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
		}
		else if(url1 == "#travel-stories4"){
			$('.tabs li:eq(4) a').tab('show');
			$('#radioTrans').tab('show').prop("checked", true);
			carEbidRequest();
			//angular.element(document.getElementById('myController13')).scope().submitForm1();
		}
	$scope.carEbidreq121214=true;
	$scope.scarEbidreq8818=true;
	$scope.qcarEbidreq99=true;
	$body = $("body");
	$scope.UserFirstName=value.firstName;
	$scope.UserLastName=value.lastName;
	$scope.UserPhoneNo=value.abnNumber;
	$scope.UserDOBDate=value.dateOfBirth;
	$scope.abcTitlePerson=value.gender;
	$('#UserPhoneNo').val(value.abnNumber);
	$('#UserFirstName').val(value.firstName);
	$('#UserLastName').val(value.lastName);
	$('#UserStreetNo').val(value.streetNumber);
	$('#UserStreetName').val(value.streetName);
	$('#UserpostCode').val(value.postCode);
	$('#UserRegion').val(value.drivingLicense);
	$('#UserState').val(value.state);
	//call to populate FInance providers
	populateFinanceProv();
	//$scope.populateFinanceProv = function (){
	function populateFinanceProv(){
		$body.addClass("loading");
    	$http({
            method : 'GET',
            url : 'api/financeProv'
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.FinanceProvs = response.data;
        }, function myError(response) {
        	$scope.FinanceProvs = response.statusText;
        });
	}
	//call to populate insurance providers
	populateInsuranceProv();
	//$scope.populateInsuranceProv = function (){
	function populateInsuranceProv(){
		$body.addClass("loading");
    	$http({
            method : 'GET',
            url : 'api/insuranceProv'
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.InsuranceProvs = response.data;
        }, function myError(response) {
        	$scope.InsuranceProvs = response.statusText;
        });
	}
	
	
	populateServicelev1();
	//$scope.populateServicelev1 = function (){
	function populateServicelev1(){
		$body.addClass("loading");
    	$http({
            method : 'GET',
            url : 'api/level1'
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.ServiceLev1s = response.data;
        }, function myError(response) {
        	$scope.ServiceLev1s = response.statusText;
        });
	}
	$scope.populateServicelev2 = function (){
		$body.addClass("loading");
		//alert($scope.ServL1);
    	$http({
            method : 'GET',
            url : 'api/level2?level1='+$scope.ServL1
        }).then(function mySuccess(response) {
        	console.log(response);	
        	 $body.removeClass("loading");
        	 $scope.ServiceLev2s = response.data;
        	 //console.log($scope.ServiceLev2s);
        }, function myError(response) {
        	$scope.ServiceLev2s = response.statusText;
        });
	}
	
	
	//$body.addClass("loading");
	$http({
        method : 'GET',
        url : 'api/tempCarModelYears'
    }).then(function mySuccess(response) {
    	 //$body.removeClass("loading");
    	 $scope.yearsCar = response.data;
    }, function myError(response) {
    	$scope.yearsCar = response.statusText;
    });
	
	
	
	$scope.makeForYear = function (year){
		$body.addClass("loading");
		$scope.MakesCarYear = "";
		$scope.ModelsCarYearMake = "";
		$scope.VarsCarYearMakeMod ="";
		//'api/tempCarModelMakesForYear?modelYear='+$scope.caryearsins
    	$http({
            method : 'GET',
            url : 'api/tempCarModelMakesForYear?modelYear='+year
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.MakesCarYear = response.data;
        }, function myError(response) {
        	$scope.MakesCarYear = response.statusText;
        });
	}
	
	$scope.modelForYearMake = function (make,year){
		$body.addClass("loading");
		//'api/tempCarModelNamesForMake?modelDisplay='+$scope.carmakesins+'&modelYear='+$scope.caryearsins
    	$http({
            method : 'GET',
            url : 'api/tempCarModelNamesForMake?modelDisplay='+make+'&modelYear='+year
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.ModelsCarYearMake = response.data;
        }, function myError(response) {
        	$scope.ModelsCarYearMake = response.statusText;
        });
	}
	
	$scope.varForYearMakeMod = function (model,make,year){
		$body.addClass("loading");
		//'api/tempCarModelVariantForModel?modelName='+$scope.carmodelsins+'&modelDisplay='+$scope.carmakesins+'&modelYear='+$scope.caryearsins
    	$http({
            method : 'GET',
            url : 'api/tempCarModelTrimForAllSelect?modelName='+model+'&modelDisplay='+make+'&modelYear='+year
        }).then(function mySuccess(response) {
        	 $body.removeClass("loading");
        	 $scope.VarsCarYearMakeMod = response.data;
        }, function myError(response) {
        	$scope.VarsCarYearMakeMod = response.statusText;
        });
	}
	
// To get all My Log Book
	/*$scope.carLogBook = function(){
		carLogBook();
	}*/
	//$scope.carLogBook = function(){
	function carLogBook(){	
		//alert("inside log book");
		userId=$.jStorage.get('key').userId;
		var wsURL = 'api/getLogBookByUserId?userid='+userId;
		// change here

	   //$body.addClass("loading");
	    	$http({
				method : 'GET',
				url : wsURL

			}).success(function(result) {
				//$body.removeClass("loading");
				//alert("successfully retreived");
				
					out8="<div class='row'><div class='col-sm-10 col-md-10'></div><div class='col-sm-2 col-md-2 pull-right'><a href='#' class='btn btn-success btn-sm' onclick='printDiv('selectedRecord')'>\
												          <span class='glyphicon glyphicon-print'></span> Print\
												        </a>\
												    </div>\
											    </div>";

               	   out8 += '<tr><th>'+"Activity"+'</th><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Rego No"+'</th><th>'+"Rego Exp"+'</th><th>'+"Vin"+'</th></tr>';
               	   for(i=0;i<result.length;i++)
              		{


               		out8= out8+'<td><a href="#" id="anchor-editDealerVehicleDetailLogBookModal-' + result[i].myVehicleId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleDetailLogBookModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleDetailLogBookModal">LogBook</a></td><td>'+result[i].myVehicleId+'</td>'+'<td>'+result[i].year+'</td>'+'<td>'+result[i].make+'</td>'+'<td>'+result[i].model+'</td>'+'<td>'+result[i].regNum+'</td>'+'<td>'+result[i].regExpDate+'</td>'+'<td>'+result[i].vin+'</td>'+'</tr>';

              		}
               	out8 = out8.replace(/>null</g, ">--NA--<");
             out8 = out8.replace(/>undefined</g, ">--NA--<");
          var LogMyVehLogBoSta = result;

       if(LogMyVehLogBoSta && result.length==0){
       outLogT="";
       outLogT='<h2>No records found</h2>';
    //forFinance("fuelCard4",outLogT);
$("#"+"fuelCard4").html(outLogT);
       } else {
	               	//forFinance("fuelCard4",out8);
		$("#"+"fuelCard4").html(out8);
		}



       registerEditDealerVehicleDetailLogBookModal();
							});
	    	
	    	
	    	
		    	
				    	
	}	
	
	// modal for vehicle Log book
	
	function registerEditDealerVehicleDetailLogBookModal(){
			$('a.anchor-editDealerVehicleDetailLogBookModal').on('click', function(event) {
				$('#fuelCard4').toggle();
				var data = $(event.target).data('details');
				var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
				$('#fuelCard41').toggle();
				myVehicleIDuse = data.myVehicleId;
				angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();
				var editDealerVehicleDetailLogBookForm = '<table>\
					<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"RegoNum"+'</th><th>'+"RegoExpDt"+'</th><th>'+"VIN"+'</th></tr>\
					<tr><td>' + data.myVehicleId + '</td>\
					<td>' + data.year + '</td>\
					<td>' + data.make + '</td>\
					<td>' + data.model + '</td>\
					<td>' + data.regNum + '</td>\
					<td>' + data.regExpDate + '</td>\
					<td>' + data.vin + '</td></tr>\
					</table>';
				editDealerVehicleDetailLogBookForm = editDealerVehicleDetailLogBookForm.replace(/>null</g, ">--NA--<");
				editDealerVehicleDetailLogBookForm = editDealerVehicleDetailLogBookForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-vehicle-detail-logbook-content").html(editDealerVehicleDetailLogBookForm);
				 $("#BackToVehicles").click(function(){
				        $('#fuelCard41').hide();
				        $('#fuelCard4').show();
				    });
			});



			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		}
	
// To get all My Vehicle Garage
	/*$scope.carVehicleGarage = function(){
		carVehicleGarage();
	}*/
	//$scope.carVehicleGarage = function(){
	function carVehicleGarage(){	
		
		userId=$.jStorage.get('key').userId;

		var wsURL = 'api/getLogBookByUserId?userid='+userId;
		// change here

	   //$body.addClass("loading");
	    	$http({
				method : 'GET',
				url : wsURL

			}).success(function(result) {
				//$body.removeClass("loading");
				//alert("successfully retreived");
				
				out6="";

	           	   out6 += '<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th>'+'<th>'+"Rego No"+'</th><th>'+"Operation"+'</th></tr>';
	           	  for(i=result.length-1;i>=0;i--)
	          		{
	           		out6= out6+'<tr>'+'<td>'+result[i].myVehicleId+'</td>'+'<td>'+result[i].year+'</td>'+'<td>'+result[i].make+'</td>'+'<td>'+result[i].model+'</td>'+'<td>'+result[i].regNum+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleDetailModal-' + result[i].myVehicleId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleDetailModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleDetailModal">View</a></td></tr>';
	          		}
	           	out6 = out6.replace(/>null</g, ">--NA--<");
	           	out6 = out6.replace(/>undefined</g, ">--NA--<");
	           	var LogMyVehi = result;

	           	if(LogMyVehi && result.length==0){
		           	outLogT="";
		           	outLogT='<h2>No records found</h2>';
		           	$("#"+"quo-model-data4").html(outLogT);
	           	} else{
	           		$("#"+"quo-model-data4").html(out6);
	           	}
	           	registerEditDealerVehicleDetailModal();
							});
	    	
	    	
	    	
		    	
				    	
	}
	
	// modal for My Vehicle Garage start
	

	function registerEditDealerVehicleDetailModal(){

		var editDealerVehicleDetailModal = '<div class="modal fade" id="editDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View My Vehicle Details</center></h4>\
					<form id="edit-dealer-vehicle-detail-content-form">\
						<div class="row">\
						<div class="col-sm-10 col-md-10"></div>\
			    		<div class="col-sm-2 col-md-2 pull-right">\
			        		<a href="#" class="btn btn-success btn-sm" onclick="printDiv("edit-dealer-vehicle-detail-content-form")">\
					          <span class="glyphicon glyphicon-print"></span> Print\
					        </a>\
					    </div>\
				    </div>\
					<div class="modal-body edit-dealer-vehicle-detail-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			<button type="button" class="btn btn-primary submit-editDealerVehicleDetailModal" data-dismiss="modal">Save changes</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleDetailModal);


		$('a.anchor-editDealerVehicleDetailModal').on('click', function(event) {


			var data = $(event.target).data('details');
			var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
			// start
			var appId = '249863545451459';
		    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
		      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
		      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
		      AWS.config.region = 'us-east-1';
		      var bucket = new AWS.S3({
		          params: {
		              Bucket: bucketName
		          }
		      });
		     accessToken = $.jStorage.get("fbAToken");
		     bucket.config.credentials = new AWS.WebIdentityCredentials({
	                  ProviderId: 'graph.facebook.com',
	                  RoleArn: roleArn,
	                  WebIdentityToken: accessToken
	              });
			fbUserId = $.jStorage.get("fbKey");
			url1=" ";
			var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photo1, Expires: 60};
	        bucket.getSignedUrl('getObject', params, function (err, url) {
	          if (url) {
	          url1=url;
	          var insRemind = '<input type="checkbox" name="insRemind" />';
	  		if(data.insRemind)
	  			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

	  		var maiRemind = '<input type="checkbox" name="maiRemind" />';
	  		if(data.maiRemind)
	  			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

	  		var finRemind = '<input type="checkbox" name="finRemind" />';
	  		if(data.finRemind)
	  			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

	          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
				<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
				<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
				<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
				<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
				<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
				<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
				<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
				<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
				<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
				<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
				<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
				<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
				<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
				<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
				<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
				<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
				<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
				<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
				<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
				<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
				</table>\
				<br/>\
				</table></form>';
			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);
	          }
	          else{
	          alert("not able to retrieve photo for My Vehicle however you an view other details"+err);
	          var insRemind = '<input type="checkbox" name="insRemind" />';
	    		if(data.insRemind)
	    			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

	    		var maiRemind = '<input type="checkbox" name="maiRemind" />';
	    		if(data.maiRemind)
	    			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

	    		var finRemind = '<input type="checkbox" name="finRemind" />';
	    		if(data.finRemind)
	    			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

	          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
				<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
				<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
				<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
				<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
				<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
				<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
				<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
				<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
				<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
				<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
				<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
				<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
				<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
				<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
				<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
				<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
				<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
				<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
				<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
				<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
				<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
				</table>\
				<br/>\
				</table></form>';
			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);

	          }
	        });
			//end
		});

		$('button.submit-editDealerVehicleDetailModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-vehicle-detail-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/myVehicleGarageUpdate?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerVehicleDetailModal-" + result.myVehicleId).data('details', result);
					alert("Successfully upated the My Vehicle Garage Details..");
				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}


	// start of sell my vehicle
	/*$scope.sellMyVehicle = function(){
		sellMyVehicle();
	}*/
		//$scope.sellMyVehicle = function(){
		function sellMyVehicle(){
			//alert("came here");
			userId=$.jStorage.get('key').userId;
			//fbUserId=$.jStorage.get("fbKey");

			var wsURL = 'api/getSellMyVehCarUserId?userid='+userId;
			// change here

		   //$body.addClass("loading");
		    	$http({
					method : 'GET',
					url : wsURL

				}).success(function(result) {
					//$body.removeClass("loading");
					//alert("successfully retreived");
					
					 out3="";
		        	   out3 += '<tr><th>'+"Car Inventory ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Operation"+'</th></tr>';

		        		   for(i=result.length-1;i>=0;i--)
		       		{
		        			   //alert("data"+JSON.stringify(result[i]));
		       		out3= out3+'<tr>'+'<td>'+result[i].repoId+'</td>'+'<td>'+result[i].modelYear+'</td>'+'<td>'+result[i].modelDisplay+'</td>'+'<td>'+result[i].modelName+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleMVQuotationModal-' + result[i].repoId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleMVQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleMVQuotationModal">View</a></td></tr>';


		       		}
		        	   out3 = out3.replace(/>null</g, ">--NA--<");
		        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
		        	   var LogQuotation = result;

		        	   if(LogQuotation && result.length==0){
		        	   outLogT="";
		        	   outLogT='<h2>No records found</h2>';
		        	   //forFinance("quo-model-data",outLogT);
		        	   $("#"+"car-selMV-model-data").html(outLogT);
		        	   }else{
		        	   //forFinance("quo-model-data",out3);
		        	   $("#"+"car-selMV-model-data").html(out3);
				   }

		        	   registerEditDealerVehicleMVQuotationModal();
								});
		    	
		    	
		    	
			    	
			    					    	
		}	
	// end of sell my vehicle

		
// start of reward points
		/*$scope.loyalityProgram = function(){
			loyalityProgram();
		}*/
		//$scope.loyalityProgram = function(){
		function loyalityProgram(){
			//alert("came here");
			userId=$.jStorage.get('key').userId;
			//fbUserId=$.jStorage.get("fbKey");

			var wsURL = 'api/getReferUserId?userid='+userId;
			// change here

		   //$body.addClass("loading");
		    	$http({
					method : 'GET',
					url : wsURL

				}).success(function(result) {
					//$body.removeClass("loading");
					//alert("successfully retreived");
					
					 out3="";
		        	   out3 += '<tr><th>'+"User Refer ID"+'</th><th>'+"Reference email"+'</th><th>'+"Prov Points"+'</th><th>'+"Actual Points"+'</th><th>'+"AUD Value"+'</th><th>'+"Operation"+'</th></tr>';

		        		   for(i=result.length-1;i>=0;i--)
		       		{
		        			   //alert("data"+JSON.stringify(result[i]));
		       		out3= out3+'<tr>'+'<td>'+result[i].userReferPointId+'</td>'+'<td>'+result[i].referedEmailId+'</td>'+'<td>'+result[i].noOfPoints+'</td>'+'<td>'+result[i].actualPoints+'</td>'+'<td>'+result[i].audVal+'</td>'+'<td><a href="#" id="anchor-editDealerRUQuotationModal-' + result[i].userReferPointId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerRUQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerRUQuotationModal">View</a></td></tr>';


		       		}
		        	   out3 = out3.replace(/>null</g, ">--NA--<");
		        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
		        	   var LogQuotation = result;

		        	   if(LogQuotation && result.length==0){
		        	   outLogT="";
		        	   outLogT='<h2>No records found</h2>';
		        	   //forFinance("quo-model-data",outLogT);
		        	   $("#"+"car-ref-points-data").html(outLogT);
		        	   }else{
		        	   //forFinance("quo-model-data",out3);
		        	   $("#"+"car-ref-points-data").html(out3);
				   }
		        	   registerEditDealerVehicleRUQuotationModal();
		        	   		});
		    	
		    	
		    	var wsURL = 'api/getReferencedUserId?userid='+userId;
				// change here

			   //$body.addClass("loading");
			    	$http({
						method : 'GET',
						url : wsURL

					}).success(function(result) {
						//$body.removeClass("loading");
						//alert("successfully retreived");
						
						 out3="";
			        	   out3 += '<tr><th>'+"User Referenced ID"+'</th><th>'+"Referrenced Email"+'</th><th>'+"Prov Points"+'</th><th>'+"Actual Points"+'</th><th>'+"Value"+'</th><th>'+"Operation"+'</th></tr>';

			        		   for(i=result.length-1;i>=0;i--)
			       		{
			        			   //alert("data"+JSON.stringify(result[i]));
			       		out3= out3+'<tr>'+'<td>'+result[i].referPointId+'</td>'+'<td>'+result[i].referencedEmailId+'</td>'+'<td>'+result[i].noOfPoints+'</td>'+'<td>'+result[i].actualPoints+'</td>'+'<td>'+result[i].audVal+'</td>'+'<td><a href="#" id="anchor-editDealerRDQuotationModal-' + result[i].referPointId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerRDQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerRDQuotationModal">View</a></td></tr>';


			       		}
			        	   out3 = out3.replace(/>null</g, ">--NA--<");
			        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
			        	   var LogQuotation = result;

			        	   if(LogQuotation && result.length==0){
			        	   outLogT="";
			        	   outLogT='<h2>No records found</h2>';
			        	   //forFinance("quo-model-data",outLogT);
			        	   $("#"+"car-refd-points-data").html(outLogT);
			        	   }else{
			        	   //forFinance("quo-model-data",out3);
			        	   $("#"+"car-refd-points-data").html(out3);
					   }
			        	   registerEditDealerVehicleRDQuotationModal();
			        	    	});
			    	
			    	
			    	var wsURL = 'api/getBlogUserId?userid='+userId;
					// change here

				   //$body.addClass("loading");
				    	$http({
							method : 'GET',
							url : wsURL

						}).success(function(result) {
							//$body.removeClass("loading");
							//alert("successfully retreived");
							
							 out3="";
				        	   out3 += '<tr><th>'+"User Blog ID"+'</th><th>'+"Blog Name"+'</th><th>'+"Prov Points"+'</th><th>'+"Actual Points"+'</th><th>'+"Aud Value"+'</th><th>'+"Operation"+'</th></tr>';

				        		   for(i=result.length-1;i>=0;i--)
				       		{
				        			   //alert("data"+JSON.stringify(result[i]));
				       		out3= out3+'<tr>'+'<td>'+result[i].blogPointId+'</td>'+'<td>'+result[i].blogName+'</td>'+'<td>'+result[i].noOfPoints+'</td>'+'<td>'+result[i].actualPoints+'</td>'+'<td>'+result[i].audVal+'</td>'+'<td><a href="#" id="anchor-editDealerBGQuotationModal-' + result[i].repoId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerBGQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerBGQuotationModal">View</a></td></tr>';


				       		}
				        	   out3 = out3.replace(/>null</g, ">--NA--<");
				        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
				        	   var LogQuotation = result;

				        	   if(LogQuotation && result.length==0){
				        	   outLogT="";
				        	   outLogT='<h2>No records found</h2>';
				        	   //forFinance("quo-model-data",outLogT);
				        	   $("#"+"car-blog-points").html(outLogT);
				        	   }else{
				        	   //forFinance("quo-model-data",out3);
				        	   $("#"+"car-blog-points").html(out3);
						   }
				        	   registerEditDealerVehicleBGQuotationModal();
				        	    	});
				    	
				    	var wsURL = 'api/getReviewUserId?userid='+userId;
						// change here

					   //$body.addClass("loading");
					    	$http({
								method : 'GET',
								url : wsURL

							}).success(function(result) {
								//$body.removeClass("loading");
								//alert("successfully retreived");
								
								 out3="";
					        	   out3 += '<tr><th>'+"User Reveiw ID"+'</th><th>'+"Review Name"+'</th><th>'+"Prov Points"+'</th><th>'+"Actual Points"+'</th><th>'+"Aud Value"+'</th><th>'+"Operation"+'</th></tr>';

					        		   for(i=result.length-1;i>=0;i--)
					       		{
					        			   //alert("data"+JSON.stringify(result[i]));
					       		out3= out3+'<tr>'+'<td>'+result[i].revPointId+'</td>'+'<td>'+result[i].revName+'</td>'+'<td>'+result[i].noOfPoints+'</td>'+'<td>'+result[i].actualPoints+'</td>'+'<td>'+result[i].audVal+'</td>'+'<td><a href="#" id="anchor-editDealerWRQuotationModal-' + result[i].revPointId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerWRQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerWRQuotationModal">View</a></td></tr>';


					       		}
					        	   out3 = out3.replace(/>null</g, ">--NA--<");
					        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
					        	   var LogQuotation = result;

					        	   if(LogQuotation && result.length==0){
					        	   outLogT="";
					        	   outLogT='<h2>No records found</h2>';
					        	   //forFinance("quo-model-data",outLogT);
					        	   $("#"+"car-review-points").html(outLogT);
					        	   }else{
					        	   //forFinance("quo-model-data",out3);
					        	   $("#"+"car-review-points").html(out3);
							   }
					        	   registerEditDealerWRQuotationModal();
					        	    	});
		    	
					    	var wsURL = 'api/getValTransUserId?userid='+userId;
							// change here

						   //$body.addClass("loading");
						    	$http({
									method : 'GET',
									url : wsURL

								}).success(function(result) {
									//$body.removeClass("loading");
									//alert("successfully retreived");
									
									 out3="";
						        	   out3 += '<tr><th>'+"User Trans ID"+'</th><th>'+"TypeOfTrans"+'</th><th>'+"Prov Points"+'</th><th>'+"Actual Points"+'</th><th>'+"Value"+'</th><th>'+"Operation"+'</th></tr>';

						        		   for(i=result.length-1;i>=0;i--)
						       		{
						        			   //alert("data"+JSON.stringify(result[i]));
						       		out3= out3+'<tr>'+'<td>'+result[i].valTransPointId+'</td>'+'<td>'+result[i].typeOfTrans+'</td>'+'<td>'+result[i].noOfPoints+'</td>'+'<td>'+result[i].actualPoints+'</td>'+'<td>'+result[i].audVal+'</td>'+'<td><a href="#" id="anchor-editDealerVTQuotationModal-' + result[i].repoId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVTQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVTQuotationModal">View</a></td></tr>';


						       		}
						        	   out3 = out3.replace(/>null</g, ">--NA--<");
						        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
						        	   var LogQuotation = result;

						        	   if(LogQuotation && result.length==0){
						        	   outLogT="";
						        	   outLogT='<h2>No records found</h2>';
						        	   //forFinance("quo-model-data",outLogT);
						        	   $("#"+"car-valTrans-points").html(outLogT);
						        	   }else{
						        	   //forFinance("quo-model-data",out3);
						        	   $("#"+"car-valTrans-points").html(out3);
								   }
						        	   registerEditDealerVehicleVTQuotationModal();
						        	    	});
		    	
			    	
			    					    	
		}	
	// end of reward points
		// start of valTranpoints
		function registerEditDealerVehicleVTQuotationModal(){


			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
			var editDealerVTQuotationModal = '<div class="modal fade" id="editDealerVTQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
			    <div class="modal-dialog">\
			        <div class="modal-content">\
			            <div class="modal-header">\
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
			                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
			            </div>\
						<h4 class="modal-title" id="myModalLabel"><center>View Value Transanction Points</center></h4>\
				        <form id="edit-dealer-VT-quotation-content-form">\
						<div class="modal-body edit-dealer-VT-quotation-content">\
			            </div>\
			            <div class="modal-footer">\
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			               </div>\
			            </form>\
						<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
			    </div>\
			</div>';

			$(document.body).append(editDealerVTQuotationModal);


			$('a.anchor-editDealerVTQuotationModal').on('click', function(event) {


						var data = $(event.target).data('details');
/*	    				outInsDrvAdd = "";
	    			    var drvAddInfo = data.vehQuotExtras;
	    				if(drvAddInfo){
	    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
	    					 for(i=0;i<data.vehQuotExtras.length;i++)
	    						{
	    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
	    						}

	    				}
	    				else
	    			    {
	    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    			    }
*/						var quotIdHiddenField = '<input type="hidden" name="valTransPointId" value="' + data.valTransPointId + '" />';
/*						var moveToUser = '<input type="checkbox" name="moveToUser" />';
	    				if(data.newer)
	    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
	    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
	    					if(data.used)
	    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
	    					 status1="Submitted to User for View";
	    	   	         		if(data.status){status1="Submitted to User for View";}
	    				console.log("Vehicle quotation view"+JSON.stringify(data));
*/						var editDealerVTQuotationForm = '<form id="edit-dealer-VT-quotation-content-form"><table>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Value Trans Details</div></div>\
	    					<tr><td>Value Trans ID</td><td>' + data.valTransPointId + '</td></tr>\
	    					<tr><td>' + quotIdHiddenField + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Refer Details</div></div>\
	    					<tr><td>Type Of Trans</td><td>' + data.typeOfTrans + '</td></tr>\
	    					<tr><td>Id</td><td>' + data.id + '</td></tr>\
	    					<tr><td>Provisional Points</td><td>' + data.noOfPoints + '</td></tr>\
	    					<tr><td>Provisional Value</td><td>' + data.rupVal + '</td></tr>\
	    					<tr><td>Actual Points</td><td>' + data.actualPoints + '</td></tr>\
	    					<tr><td>Actual Value</td><td>' + data.audVal + '</td></tr>\
	    					<tr><td>Creation Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<br/>\
	    					</table></form>';
				editDealerVTQuotationForm = editDealerVTQuotationForm.replace(/>null</g, ">--NA--<");
				editDealerVTQuotationForm = editDealerVTQuotationForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-VT-quotation-content").html(editDealerVTQuotationForm);
			});

			$('button.submit-editDealerVTQuotationModal').on('click', function(e) {

				var jsonInput = $("#edit-dealer-VT-quotation-content-form").convertFormDataToJSON();


				$.ajax({
					type: "POST",
					url: "api/transpservQuotation?_method=PUT",
					data: jsonInput,
					contentType:'application/json',
					success: function(result){
						$("#anchor-editDealerVTQuotationModal-" + result.quotId).data('details', result);
						alert("Successfully upated and moved to user");

					}
				});


			});

			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		
	}	
// end of valTranspoints
 // start of ReviewPoint
		function registerEditDealerWRQuotationModal(){


			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
			var editDealerWRQuotationModal = '<div class="modal fade" id="editDealerWRQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
			    <div class="modal-dialog">\
			        <div class="modal-content">\
			            <div class="modal-header">\
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
			                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
			            </div>\
						<h4 class="modal-title" id="myModalLabel"><center>View User Refer Points</center></h4>\
				        <form id="edit-dealer-WR-quotation-content-form">\
						<div class="modal-body edit-dealer-WR-quotation-content">\
			            </div>\
			            <div class="modal-footer">\
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			               </div>\
			            </form>\
						<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
			    </div>\
			</div>';

			$(document.body).append(editDealerWRQuotationModal);


			$('a.anchor-editDealerWRQuotationModal').on('click', function(event) {


						var data = $(event.target).data('details');
/*	    				outInsDrvAdd = "";
	    			    var drvAddInfo = data.vehQuotExtras;
	    				if(drvAddInfo){
	    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
	    					 for(i=0;i<data.vehQuotExtras.length;i++)
	    						{
	    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
	    						}

	    				}
	    				else
	    			    {
	    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    			    }
*/						var quotIdHiddenField = '<input type="hidden" name="revPointId" value="' + data.revPointId + '" />';
/*						var moveToUser = '<input type="checkbox" name="moveToUser" />';
	    				if(data.newer)
	    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
	    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
	    					if(data.used)
	    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
	    					 status1="Submitted to User for View";
	    	   	         		if(data.status){status1="Submitted to User for View";}
	    				console.log("Vehicle quotation view"+JSON.stringify(data));
*/						var editDealerWRQuotationForm = '<form id="edit-dealer-WR-quotation-content-form"><table>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Review Point Details</div></div>\
	    					<tr><td>User Review ID</td><td>' + data.revPointId + '</td></tr>\
	    					<tr><td>' + quotIdHiddenField + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Review Details</div></div>\
	    					<tr><td>Id</td><td>' + data.revId + '</td></tr>\
	    					<tr><td>Review Name</td><td>' + data.revName + '</td></tr>\
	    					<tr><td>Provisional Points</td><td>' + data.noOfPoints + '</td></tr>\
	    					<tr><td>Provisional Value</td><td>' + data.rupVal + '</td></tr>\
	    					<tr><td>Actual Points</td><td>' + data.actualPoints + '</td></tr>\
	    					<tr><td>Actual Value</td><td>' + data.audVal + '</td></tr>\
	    					<tr><td>Creation Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<br/>\
	    					</table></form>';
				editDealerWRQuotationForm = editDealerWRQuotationForm.replace(/>null</g, ">--NA--<");
				editDealerWRQuotationForm = editDealerWRQuotationForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-WR-quotation-content").html(editDealerWRQuotationForm);
			});

			$('button.submit-editDealerWRQuotationModal').on('click', function(e) {

				var jsonInput = $("#edit-dealer-WR-quotation-content-form").convertFormDataToJSON();


				$.ajax({
					type: "POST",
					url: "api/transpservQuotation?_method=PUT",
					data: jsonInput,
					contentType:'application/json',
					success: function(result){
						$("#anchor-editDealerWRQuotationModal-" + result.quotId).data('details', result);
						alert("Successfully upated and moved to user");

					}
				});


			});

			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		
	}	
// end of Reviewpoint	
		
// start of BlogPoint
		function registerEditDealerVehicleBGQuotationModal(){


			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
			var editDealerBGQuotationModal = '<div class="modal fade" id="editDealerBGQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
			    <div class="modal-dialog">\
			        <div class="modal-content">\
			            <div class="modal-header">\
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
			                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
			            </div>\
						<h4 class="modal-title" id="myModalLabel"><center>View User Refer Points</center></h4>\
				        <form id="edit-dealer-BG-quotation-content-form">\
						<div class="modal-body edit-dealer-BG-quotation-content">\
			            </div>\
			            <div class="modal-footer">\
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			               </div>\
			            </form>\
						<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
			    </div>\
			</div>';

			$(document.body).append(editDealerBGQuotationModal);


			$('a.anchor-editDealerBGQuotationModal').on('click', function(event) {


						var data = $(event.target).data('details');
/*	    				outInsDrvAdd = "";
	    			    var drvAddInfo = data.vehQuotExtras;
	    				if(drvAddInfo){
	    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
	    					 for(i=0;i<data.vehQuotExtras.length;i++)
	    						{
	    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
	    						}

	    				}
	    				else
	    			    {
	    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    			    }
*/						var quotIdHiddenField = '<input type="hidden" name="blogPointId" value="' + data.blogPointId + '" />';
/*						var moveToUser = '<input type="checkbox" name="moveToUser" />';
	    				if(data.newer)
	    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
	    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
	    					if(data.used)
	    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
	    					 status1="Submitted to User for View";
	    	   	         		if(data.status){status1="Submitted to User for View";}
	    				console.log("Vehicle quotation view"+JSON.stringify(data));
*/						var editDealerBGQuotationForm = '<form id="edit-dealer-BG-quotation-content-form"><table>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Blog Point Details</div></div>\
	    					<tr><td>User Blog ID</td><td>' + data.blogPointId + '</td></tr>\
	    					<tr><td>' + quotIdHiddenField + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Blog Details</div></div>\
	    					<tr><td>Id</td><td>' + data.blogId + '</td></tr>\
	    					<tr><td>Blog Name</td><td>' + data.blogName + '</td></tr>\
	    					<tr><td>Provisional Points</td><td>' + data.noOfPoints + '</td></tr>\
	    					<tr><td>Provisional Value</td><td>' + data.rupVal + '</td></tr>\
	    					<tr><td>Actual Points</td><td>' + data.actualPoints + '</td></tr>\
	    					<tr><td>Actual Value</td><td>' + data.audVal + '</td></tr>\
	    					<tr><td>Creation Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table></form>';
				editDealerBGQuotationForm = editDealerBGQuotationForm.replace(/>null</g, ">--NA--<");
				editDealerBGQuotationForm = editDealerBGQuotationForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-BG-quotation-content").html(editDealerBGQuotationForm);
			});

			$('button.submit-editDealerBGQuotationModal').on('click', function(e) {

				var jsonInput = $("#edit-dealer-BG-quotation-content-form").convertFormDataToJSON();


				$.ajax({
					type: "POST",
					url: "api/transpservQuotation?_method=PUT",
					data: jsonInput,
					contentType:'application/json',
					success: function(result){
						$("#anchor-editDealerBGQuotationModal-" + result.quotId).data('details', result);
						alert("Successfully upated and moved to user");

					}
				});


			});

			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		
	}	
// end of Blogpoint		

		
// start of ReferencedPoint
		function registerEditDealerVehicleRDQuotationModal(){


			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
			var editDealerRDQuotationModal = '<div class="modal fade" id="editDealerRDQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
			    <div class="modal-dialog">\
			        <div class="modal-content">\
			            <div class="modal-header">\
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
			                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
			            </div>\
						<h4 class="modal-title" id="myModalLabel"><center>View User Referenced Points</center></h4>\
				        <form id="edit-dealer-RD-quotation-content-form">\
						<div class="modal-body edit-dealer-RD-quotation-content">\
			            </div>\
			            <div class="modal-footer">\
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			               </div>\
			            </form>\
						<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
			    </div>\
			</div>';

			$(document.body).append(editDealerRDQuotationModal);


			$('a.anchor-editDealerRDQuotationModal').on('click', function(event) {


						var data = $(event.target).data('details');
/*	    				outInsDrvAdd = "";
	    			    var drvAddInfo = data.vehQuotExtras;
	    				if(drvAddInfo){
	    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
	    					 for(i=0;i<data.vehQuotExtras.length;i++)
	    						{
	    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
	    						}

	    				}
	    				else
	    			    {
	    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    			    }
*/						var quotIdHiddenField = '<input type="hidden" name="referPointId" value="' + data.referPointId + '" />';
/*						var moveToUser = '<input type="checkbox" name="moveToUser" />';
	    				if(data.newer)
	    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
	    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
	    					if(data.used)
	    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
	    					 status1="Submitted to User for View";
	    	   	         		if(data.status){status1="Submitted to User for View";}
	    				console.log("Vehicle quotation view"+JSON.stringify(data));
*/						var editDealerRDQuotationForm = '<form id="edit-dealer-RD-quotation-content-form"><table>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Referrenced Details</div></div>\
	    					<tr><td>User Referrenced ID</td><td>' + data.referPointId + '</td></tr>\
	    					<tr><td>' + quotIdHiddenField + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Referenced Details</div></div>\
	    					<tr><td>Referrenced EmailId</td><td>' + data.referencedEmailId + '</td></tr>\
	    					<tr><td>Referrenced FirstName</td><td>' + data.referencedFirstName + '</td></tr>\
	    					<tr><td>Referrenced LastName</td><td>' + data.referencedLastName + '</td></tr>\
	    					<tr><td>Provisional Points</td><td>' + data.noOfPoints + '</td></tr>\
	    					<tr><td>Provisional Value</td><td>' + data.rupVal + '</td></tr>\
	    					<tr><td>Actual Points</td><td>' + data.actualPoints + '</td></tr>\
	    					<tr><td>Actual Value</td><td>' + data.audVal + '</td></tr>\
	    					<tr><td>Creation Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<br/>\
	    					</table></form>';
				editDealerRDQuotationForm = editDealerRDQuotationForm.replace(/>null</g, ">--NA--<");
				editDealerRDQuotationForm = editDealerRDQuotationForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-RD-quotation-content").html(editDealerRDQuotationForm);
			});

			$('button.submit-editDealerRDQuotationModal').on('click', function(e) {

				var jsonInput = $("#edit-dealer-RD-quotation-content-form").convertFormDataToJSON();


				$.ajax({
					type: "POST",
					url: "api/transpservQuotation?_method=PUT",
					data: jsonInput,
					contentType:'application/json',
					success: function(result){
						$("#anchor-editDealerRDQuotationModal-" + result.quotId).data('details', result);
						alert("Successfully upated and moved to user");

					}
				});


			});

			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		
	}	
// end of ReferencedPoint		
		
// start of userReferPoint
		function registerEditDealerVehicleRUQuotationModal(){


			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
			var editDealerRUQuotationModal = '<div class="modal fade" id="editDealerRUQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
			    <div class="modal-dialog">\
			        <div class="modal-content">\
			            <div class="modal-header">\
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
			                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
			            </div>\
						<h4 class="modal-title" id="myModalLabel"><center>View User Refer Points</center></h4>\
				        <form id="edit-dealer-RU-quotation-content-form">\
						<div class="modal-body edit-dealer-RU-quotation-content">\
			            </div>\
			            <div class="modal-footer">\
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			               </div>\
			            </form>\
						<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
			    </div>\
			</div>';

			$(document.body).append(editDealerRUQuotationModal);


			$('a.anchor-editDealerRUQuotationModal').on('click', function(event) {


						var data = $(event.target).data('details');
/*	    				outInsDrvAdd = "";
	    			    var drvAddInfo = data.vehQuotExtras;
	    				if(drvAddInfo){
	    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
	    					 for(i=0;i<data.vehQuotExtras.length;i++)
	    						{
	    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
	    						}

	    				}
	    				else
	    			    {
	    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    			    }
*/						var quotIdHiddenField = '<input type="hidden" name="userReferPointId" value="' + data.userReferPointId + '" />';
/*						var moveToUser = '<input type="checkbox" name="moveToUser" />';
	    				if(data.newer)
	    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
	    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
	    					if(data.used)
	    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
	    					 status1="Submitted to User for View";
	    	   	         		if(data.status){status1="Submitted to User for View";}
	    				console.log("Vehicle quotation view"+JSON.stringify(data));
*/						var editDealerRUQuotationForm = '<form id="edit-dealer-RU-quotation-content-form"><table>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Refer Details</div></div>\
	    					<tr><td>User Refer ID</td><td>' + data.userReferPointId + '</td></tr>\
	    					<tr><td>' + quotIdHiddenField + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Refer Details</div></div>\
	    					<tr><td>Refered EmailId</td><td>' + data.referedEmailId + '</td></tr>\
	    					<tr><td>firstName</td><td>' + data.firstName + '</td></tr>\
	    					<tr><td>lastName</td><td>' + data.lastName + '</td></tr>\
	    					<tr><td>Provisional Points</td><td>' + data.noOfPoints + '</td></tr>\
	    					<tr><td>Provisional Value</td><td>' + data.rupVal + '</td></tr>\
	    					<tr><td>Actual Points</td><td>' + data.actualPoints + '</td></tr>\
	    					<tr><td>Actual Value</td><td>' + data.audVal + '</td></tr>\
	    					<tr><td>Creation Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<br/>\
	    					</table></form>';
				editDealerRUQuotationForm = editDealerRUQuotationForm.replace(/>null</g, ">--NA--<");
				editDealerRUQuotationForm = editDealerRUQuotationForm.replace(/>undefined</g, ">--NA--<");
				$(".edit-dealer-RU-quotation-content").html(editDealerRUQuotationForm);
			});

			$('button.submit-editDealerRUQuotationModal').on('click', function(e) {

				var jsonInput = $("#edit-dealer-RU-quotation-content-form").convertFormDataToJSON();


				$.ajax({
					type: "POST",
					url: "api/transpservQuotation?_method=PUT",
					data: jsonInput,
					contentType:'application/json',
					success: function(result){
						$("#anchor-editDealerRUQuotationModal-" + result.quotId).data('details', result);
						alert("Successfully upated and moved to user");

					}
				});


			});

			$.fn.convertFormDataToJSON = function(){
				var checkboxes = [];
				$(this).find('input:checkbox:checked').each(function(){
					checkboxes.push($(this).attr("name"));
				});
				var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] != undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            if($.inArray(this.name, checkboxes) != -1)
			              o[this.name].push('true' || '');
			            else
			            	o[this.name].push(this.value || '');
			        } else {
			        	if($.inArray(this.name, checkboxes) != -1)
			        		o[this.name] = 'true' || '';
				        else
				           	o[this.name] = this.value || '';
			        }
			    });
			    return JSON.stringify(o);
			}


		
	}	
// end of userReferPoint
		
// To get all car Quotations
	
	$scope.carCarQuotation = function(){
		
		userId=$.jStorage.get('key').userId;
		var wsURL = 'api/getVehQuotaByUserId?userid='+userId;
		// change here

	   //$body.addClass("loading");
	    	$http({
				method : 'GET',
				url : wsURL

			}).success(function(result) {
				//$body.removeClass("loading");
				//alert("successfully retreived");
				
				 out3="";
	        	   var qtRecd = result.length;
	        	   document.getElementById('qtRecd').innerHTML=qtRecd;
	        	   out3 += '<tr><th>'+"Car Quotation ID"+'</th><th>'+"Dealer Name"+'</th><th>'+"Dealer Stock No"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';

	        		   for(i=result.length-1;i>=0;i--)
	       		{
	        			   //alert("data"+JSON.stringify(result[i]));
	       		out3= out3+'<tr>'+'<td>'+result[i].quotId+'</td>'+'<td>'+result[i].dealerName+'</td>'+'<td>'+result[i].dealerStockNo+'</td>'+'<td>'+result[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleQuotationModal-' + result[i].quotId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleQuotationModal">Edit</a></td></tr>';


	       		}
	        	   out3 = out3.replace(/>null</g, ">--NA--<");
	        	   out3 = out3.replace(/>undefined</g, ">--NA--<");
	        	   var LogQuotation = result;

	        	   if(LogQuotation && result.length==0){
		        	   outLogT="";
		        	   outLogT='<h2>No records found</h2>';
		        	   $("#"+"quo-model-data").html(outLogT);
	        	   }else{
	        		   $("#"+"quo-model-data").html(out3);
	        	   }

	        	   registerEditDealerVehicleQuotationModal();
							});
	    	
	    	
	    	// start of Finance quotation
	    	
	    	var wsURL = 'api/getFinQuotaByUserId?userid='+userId;
			// change here

		   //$body.addClass("loading");
		    	$http({
					method : 'GET',
					url : wsURL

				}).success(function(result) {
					//$body.removeClass("loading");
					//alert("successfully retreived");
					
					out4="";
					var finQCt=result.length;
					document.getElementById('finQCt').innerHTML=finQCt;
					        	   out4 += '<tr><th>'+"Finance Quotation ID"+'</th><th>'+"Dealer Name"+'</th><th>'+"Dealer Stock No"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';

		        		   for(i=result.length-1;i>=0;i--)
		       		{

		        		   out4= out4+'<tr>'+'<td>'+result[i].finQuotId+'</td>'+'<td>'+result[i].dealerName+'</td>'+'<td>'+result[i].dealerStockNo+'</td>'+'<td>'+result[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealerfin12QuotationModal-' + result[i].finQuotId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerfin12QuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerfin12QuotationModal">Edit</a></td></tr>';

		       		}
		        	   out4 = out4.replace(/>null</g, ">--NA--<");
		        	   out4 = out4.replace(/>undefined</g, ">--NA--<");
		        	   var LogFinQuo = result;

		        	   if(LogFinQuo && result.length==0){
		        	   outLogT="";
		        	   outLogT='<h2>No records found</h2>';
		        	   //forFinance("quo-data1",outLogT);
					     $("#"+"quo-data1").html(outLogT);
		        	   }else{
		        	   //forFinance("quo-data1",out4);
				    $("#"+"quo-data1").html(out1);
				   }
		        	   registerEditDealerfin12QuotationModal();
								});
		    	
		    	// start of insurance Quotation
		    	
		    	var wsURL = 'api/getInsQuotaByUserId?userid='+userId;
				// change here

			   //$body.addClass("loading");
			    	$http({
						method : 'GET',
						url : wsURL

					}).success(function(result) {
						//$body.removeClass("loading");
						//alert("successfully retreived");
						
						out5="";
						var insQCt=result.length;
			        	   document.getElementById('insQCt').innerHTML=insQCt;
			        	   out5 += '<tr><th>'+"Car Quotation ID"+'</th><th>'+"Dealer Name"+'</th><th>'+"Dealer Stock No"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';
			        	   for(i=result.length-1;i>=0;i--)
				       		{
				       			out5= out5+'<tr>'+'<td>'+result[i].insQuotId+'</td>'+'<td>'+result[i].dealerName+'</td>'+'<td>'+result[i].dealerStockNo+'</td>'+'<td>'+result[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealerins12QuotationModal-' + result[i].insQuotId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerins12QuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerins12QuotationModal">Edit</a></td></tr>';
				       		}
			        	   out5 = out5.replace(/>null</g, ">--NA--<");
			        	   out5 = out5.replace(/>undefined</g, ">--NA--<");
			        	   var LogInsQuo = result;
	
			        	   if(LogInsQuo && result.length==0){
				        	   	outLogT="";
				        	   	outLogT='<h2>No records found</h2>';
			   			  		$("#"+"quo-model-data2").html(outLogT);
			        	   } else{
	   			        	  	$("#"+"quo-model-data2").html(out5);
			        	   }
	
			        	   registerEditDealerins12QuotationModal();
									});
		    	
			    	// start of servMaint Quotation
			    	
			    	var wsURL = 'api/getServMQuotaByUserId?userid='+userId;
					// change here

				   //$body.addClass("loading");
				    	$http({
							method : 'GET',
							url : wsURL

						}).success(function(result) {
							//$body.removeClass("loading");
							//alert("successfully retreived");
							
							out444="";
				        	   var servQCt = result.length;
				        	   document.getElementById('servQCt').innerHTML=servQCt;
				        	   out444 += '<tr><th>'+"Serv Maint Quotation ID"+'</th><th>'+"Dealer Name"+'</th><th>'+"Dealer Stock No"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';
				        	   for(i=result.length-1;i>=0;i--)
				       		{

				       		out444= out444+'<tr>'+'<td>'+result[i].servMaintQuotId+'</td>'+'<td>'+result[i].dealerName+'</td>'+'<td>'+result[i].dealerStockNo+'</td>'+'<td>'+result[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealerservmaintQuotationModal-' + result[i].servMaintQuotId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerservmaintQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerservmaintQuotationModal">Edit</a></td></tr>';


				       		}
				        	   out444 = out444.replace(/>null</g, ">--NA--<");
				        	   out444 = out444.replace(/>undefined</g, ">--NA--<");
				        	   var LogServMaintQuo = result;

				        	   if(LogServMaintQuo && result.length==0){
					        	   outLogT="";
					        	   outLogT='<h2>No records found</h2>';
					        	   $("#"+"dataservmaintQuot12").html(outLogT);
				        	   } else{
				        		   $("#"+"dataservmaintQuot12").html(out444);
				        	   }

				        	   registerEditDealerservmaintQuotationModal();
										});
		    	    	
				    	
				    	// start of servMaint Quotation
				    	
				    	var wsURL = 'api/getTranpQuotaByUserId?userid='+userId;
						// change here

					   //$body.addClass("loading");
					    	$http({
								method : 'GET',
								url : wsURL

							}).success(function(result) {
								//$body.removeClass("loading");
								//alert("successfully retreived");
								
								out555="";
					        	   var trasQCt = result.length;
					        	   document.getElementById('trasQCt').innerHTML=trasQCt;
					        	   out555 += '<tr><th>'+" Transp Serv Quotation ID"+'</th><th>'+"Dealer Id"+'</th><th>'+"Creation Date"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';
					        	   for(i=result.length-1;i>=0;i--)
						       		{
						       			out555= out555+'<tr>'+'<td>'+result[i].transpServQuotId+'</td>'+'<td>'+result[i].dealerId+'</td>'+'<td>'+result[i].creationDate+'</td>'+'<td>'+result[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealertranspservQuotationModal-' + result[i].TranspServQuotId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealertranspservQuotationModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealertranspservQuotationModal">Edit</a></td></tr>';
						       		}
					        	   out555 = out555.replace(/>null</g, ">--NA--<");
					        	   out555 = out555.replace(/>undefined</g, ">--NA--<");
					        	   var LogTranspServQuo = result;

					        	   if(LogTranspServQuo && result.length==0){
						        	   outLogT="";
						        	   outLogT='<h2>No records found</h2>';
						        	   $("#"+"datatranspservQuot").html(outLogT);
					        	   } else{
					        		   $("#"+"datatranspservQuot").html(out555);
					        	   }


					        	   registerEditDealertranspservQuotationModal();
											});
				    	
	}
	
	// modal for transport Quotation start
	

	function registerEditDealertranspservQuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealertranspservQuotationModal = '<div class="modal fade" id="editDealertranspservQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>Edit Transport Service Quotation</center></h4>\
			        <form id="edit-dealer-transpserv-quotation-content-form">\
					<div class="modal-body edit-dealer-transpserv-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
		                <button type="button" class="btn btn-primary submit-editDealertranspservQuotationModal" data-dismiss="modal">Save changes</button>\
		            </div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
		    </div>\
		</div>';

		$(document.body).append(editDealertranspservQuotationModal);


		$('a.anchor-editDealertranspservQuotationModal').on('click', function(event) {


					var data = $(event.target).data('details');
    				outInsDrvAdd = "";
    			    var drvAddInfo = data.vehQuotExtras;
    				if(drvAddInfo){
    					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
    					 for(i=0;i<data.vehQuotExtras.length;i++)
    						{
    						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
    						}

    				}
    				else
    			    {
    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
    			    }
					var quotIdHiddenField = '<input type="hidden" name="transpServQuotId" value="' + data.transpServQuotId + '" />';
					var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Submitted to User for View";
    	   	         		if(data.status){status1="Submitted to User for View";}
    				console.log("Vehicle quotation view"+JSON.stringify(data));
					var editDealertranspservQuotationForm = '<form id="edit-dealer-transpserv-quotation-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
    					<tr><td>Quotation ID</td><td>' + data.transpServQuotId + '</td></tr>\
    					<tr><td>' + quotIdHiddenField + '</td></tr>\
    					<tr><td>Status</td><td>' + status1 + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Requirement Details</div></div>\
    					<tr><td>Offer Date</td><td>' + data.offerValidDate + '</td></tr>\
    					<tr><td>Estimate Quote for the Job</td><td>' + data.driveAwayPrice + '</td></tr>\
    					<tr><td>Quotated Hourly Rate</td><td>' + data.offerPrice2 + '</td></tr>\
    					<tr><td>Min</td><td>' + data.offerPrice3 + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Items / Services Offered</div></div>\
    					<tr><td></td><td>' +outInsDrvAdd + '</td></tr>\
    					</table>\
    					<table>\
    					<tr><td>Dealer Terms and Conditions</td><td>' + data.fname + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<tr><td>Dealer Lead Id</td><td>' + data.dealTranspServId + '</td></tr>\
    					<tr><td>User Serv Req Id</td><td>' + data.userTranspServId + '</td></tr>\
    					<tr><td>Autoscoop User Id</td><td>' + data.userId + '</td></tr>\
    					<tr><td>User Since</td><td>' + data.userCreationDate + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Looking To Move</div></div>\
    					<tr><td>Type Of Vehicle</td><td>' + data.transTypeReq + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">From</div></div>\
    					<tr><td>Post Code</td><td>' + data.fromPostCodeAddr + '</td></tr>\
    					<tr><td>Street No</td><td>' + data.fromStreetNo + '</td></tr>\
    					<tr><td>Street Name</td><td>' + data.fromStreetName + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">To</div></div>\
    					<tr><td>Post Code</td><td>' + data.toPostCodeAddr + '</td></tr>\
    					<tr><td>Street No</td><td>' + data.toStreetNo + '</td></tr>\
    					<tr><td>Street Name</td><td>' + data.toStreetName + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Transport Stuff</div></div>\
    					<tr><td>When do You want THIS to be picked up & delivered?</td><td>' + data.pickUpDateTime + '</td></tr>\
    					<tr><td>What kin of transport You need?</td><td>' + data.toStreetName + '</td></tr>\
    					<tr><td>I am Flexible</td><td>' + data.flexWithDateDefault + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Stuff</div></div>\
    					<table>\
    					<h6 style="color:#bd191e;"><b>Car Registration</b></h6>\
    					<tr><td>Rego No</td><td>' + data.regoNo + '</td></tr>\
    					<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<h6 style="color:#bd191e;"><b>Vehicle Details</b></h6>\
    					<tr><td>Year</td><td>' + data.year + '</td></tr>\
    					<tr><td>Make</td><td>' + data.make + '</td></tr>\
    					<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
    					<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
    					<tr><td>Free Text</td><td>' + data.freeText + '</td></tr>\
    					</table>\
    					<br/>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
    					<tr><td>Dealer Id</td><td>' + data.dealerId + '</td></tr>\
    					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
    					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
    					<tr><td>Street</td><td>' + data.street + '</td></tr>\
    					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
    					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
    					<tr><td>Post Code</td><td>' + data.dealPostCode + '</td></tr>\
    					<tr><td>Country</td><td>' + data.country + '</td></tr>\
    					<tr><td>Phone</td><td>' + data.phone + '</td></tr>\
    					<tr><td>Website</td><td>' + data.website + '</td></tr>\
    					<tr><td>Mobile</td><td>' + data.mobile + '</td></tr>\
    					<tr><td>Toll Free</td><td>' + data.tollFree + '</td></tr>\
    					<tr><td>Fax</td><td>' + data.fax + '</td></tr>\
    					<tr><td>After Hours</td><td>' + data.afterHours + '</td></tr>\
    					<tr><td>Postal Address</td><td>' + data.postalAddress + '</td></tr>\
    					<tr><td>Email</td><td>' + data.email + '</td></tr>\
    					<tr><td>Longitude</td><td>' + data.longitude + '</td></tr>\
    					<tr><td>Latitude</td><td>' + data.latitude + '</td></tr>\
    					</table>\
    					<br/>\
    					<br/>\
    					</table></form>';
			editDealertranspservQuotationForm = editDealertranspservQuotationForm.replace(/>null</g, ">--NA--<");
			editDealertranspservQuotationForm = editDealertranspservQuotationForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-transpserv-quotation-content").html(editDealertranspservQuotationForm);
		});

		$('button.submit-editDealertranspservQuotationModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-transpserv-quotation-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/transpservQuotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealertranspservQuotationModal-" + result.quotId).data('details', result);
					alert("Successfully upated and moved to user");

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	
}
	
	
	// modal for servMaint Quotation start
	
	function registerEditDealerservmaintQuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerservmaintQuotationModal = '<div class="modal fade" id="editDealerservmaintQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>Edit Vehicle Quotation</center></h4>\
			        <form id="edit-dealer-servmaint-quotation-content-form">\
					<div class="modal-body edit-dealer-servmaint-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
		                <button type="button" class="btn btn-primary submit-editDealerservmaintQuotationModal" data-dismiss="modal">Save changes</button>\
		            </div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerservmaintQuotationModal);


		$('a.anchor-editDealerservmaintQuotationModal').on('click', function(event) {


					var data = $(event.target).data('details');
    				outInsDrvAdd = "";
    			    var drvAddInfo = data.vehQuotExtras;
    				if(drvAddInfo){
	   					 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
						 for(i=0;i<data.vehQuotExtras.length;i++)
							{
							 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
							}

    				}
    				else
    			    {
    			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
    			    }
					var quotIdHiddenField = '<input type="hidden" name="servMaintQuotId" value="' + data.servMaintQuotId + '" />';
					var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    				//console.log("Vehicle quotation view"+JSON.stringify(data));
    				var editDealerservmaintQuotationForm = '<form id="edit-dealer-servmaint-quotation-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
    					<tr><td>Quotation ID</td><td>' + data.servMaintQuotId + '</td></tr>\
    					<tr><td>' + quotIdHiddenField + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Requirement Details</div></div>\
    					<tr><td>Offer Date</td><td>' + data.offerValidDate + '</td></tr>\
    					<tr><td>Estimate Quote for the Job</td><td>' + data.driveAwayPrice + '</td></tr>\
    					<tr><td>Quotated Hourly Rate</td><td>' + data.offerPrice2 + '</td></tr>\
    					<tr><td>Min</td><td>' + data.offerPrice3 + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Items / Services Offered</div></div>\
    					<tr><td></td><td>' +outInsDrvAdd + '</td></tr>\
    					</table>\
    					<table>\
    					<tr><td>Dealer Terms and Conditions</td><td>' + data.fname + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<tr><td>Dealer Lead Id</td><td>' + data.dealServMaintId + '</td></tr>\
    					<tr><td>User Serv Req Id</td><td>' + data.searchServMaintId + '</td></tr>\
    					<tr><td>Autoscoop User Id</td><td>' + data.userId + '</td></tr>\
    					<tr><td>User Since</td><td>' + data.userCreationDate + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Requirement</div></div>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">I am Looking For</div></div>\
    					<tr><td>Service</td><td>' + data.flex1 + '</td></tr>\
    					<tr><td>Service & Maintenance Level 1</td><td>' + data.servMaintL1 + '</td></tr>\
    					<tr><td>Service & Maintenance Level 2</td><td>' + data.servMaintL2 + '</td></tr>\
    					<tr><td>Add Notes</td><td>' + data.freeText + '</td></tr>\
    					</table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
    					<table>\
    					<br/>\
    					<tr><td>Rego No</td><td>' + data.regoNo + '</td></tr>\
    					<tr><td>Rego State</td><td>' + data.regoStat + '</td></tr>\
    					<tr><td>Post code</td><td>' + data.postCode + '</td></tr>\
    					<tr><td>Year</td><td>' + data.year + '</td></tr>\
    					<tr><td>Make</td><td>' + data.make + '</td></tr>\
    					<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
    					<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
    					<tr><td>Fuel Type</td><td>' + data.fuelType + '</td></tr>\
    					</table>\
    					<br/>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">is the Car covered under Insurance</div></div>\
    					<table>\
    					<tr><td>Covered Under Insurance</td><td>' + data.coveredUnderIns + '</td></tr>\
    					<tr><td>Current Insurance Provider</td><td>' + data.curInsProv + '</td></tr>\
    					<br/>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
    					<tr><td>Dealer Id</td><td>' + data.dealerId + '</td></tr>\
    					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
    					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
    					<tr><td>Street</td><td>' + data.street + '</td></tr>\
    					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
    					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
    					<tr><td>Post Code</td><td>' + data.dealPostCode + '</td></tr>\
    					<tr><td>Country</td><td>' + data.country + '</td></tr>\
    					<tr><td>Phone</td><td>' + data.phone + '</td></tr>\
    					<tr><td>Website</td><td>' + data.website + '</td></tr>\
    					<tr><td>Mobile</td><td>' + data.mobile + '</td></tr>\
    					<tr><td>Toll Free</td><td>' + data.tollFree + '</td></tr>\
    					<tr><td>Fax</td><td>' + data.fax + '</td></tr>\
    					<tr><td>After Hours</td><td>' + data.afterHours + '</td></tr>\
    					<tr><td>Postal Address</td><td>' + data.postalAddress + '</td></tr>\
    					<tr><td>Email</td><td>' + data.email + '</td></tr>\
    					<tr><td>Longitude</td><td>' + data.longitude + '</td></tr>\
    					<tr><td>Latitude</td><td>' + data.latitude + '</td></tr>\
    					</table>\
    					<br/>\
    					<br/>\
				</table></form>';
			editDealerservmaintQuotationForm = editDealerservmaintQuotationForm.replace(/>null</g, ">--NA--<");
			editDealerservmaintQuotationForm = editDealerservmaintQuotationForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-servmaint-quotation-content").html(editDealerservmaintQuotationForm);
		});

		$('button.submit-editDealerservmaintQuotationModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-servmaint-quotation-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/servmaintQuotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerservmaintQuotationModal-" + result.quotId).data('details', result);
					alert("Successfully upated and moved to user");

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	
}
	
	// modal for insurance Quotation start
	
	function registerEditDealerins12QuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerins12QuotationModal = '<div class="modal fade" id="editDealerins12QuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>Edit Insurance Quotation</center></h4>\
			        <form id="edit-dealer-ins12-quotation-content-form">\
					<div class="modal-body edit-dealer-ins12-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
		                <button type="button" class="btn btn-primary submit-editDealerins12QuotationModal" data-dismiss="modal">Save changes</button>\
		            </div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerins12QuotationModal);


		$('a.anchor-editDealerins12QuotationModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);
		outInsDrvAdd = "";
	    var drvAddInfo = data.vehQuotExtras;
	    //alert("came here");
		if(drvAddInfo){
			 outInsDrvAdd += '<tr><th>'+"Item No "+'</th><th>'+"Condition & Charges"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
			 for(i=0;i<data.vehQuotExtras.length;i++)
				{
				 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
				}

		}
		else
	    {
	    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
	    }
			var quotIdHiddenField = '<input type="hidden" name="insQuotId" value="' + data.insQuotId + '" />';
			var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
			 status1="Submitted to User for View";
         		if(data.status){status1="Submitted to User for View";}

         		// start of search Insurance
         		outInsDrvAdd1 = "";
    		    var drvAddInfo = data.searchInsAdditionalDriv;
    		    //alert("came here");
    			if(drvAddInfo){
    				 outInsDrvAdd1 += '<tr><th>'+"Additional ID"+'</th><th>'+"First Name"+'</th><th>'+"Last Name"+'</th><th>'+"License Type"+'</th><th>'+'</th><th>'+"DateOfBirth"+'</th></tr>';
    				 for(i=0;i<data.searchInsAdditionalDriv.length;i++)
    					{
    					 outInsDrvAdd1= outInsDrvAdd1+'<tr>'+'<td>'+data.searchInsAdditionalDriv[i].searchInsAddDrivId+'</td><td>'+data.searchInsAdditionalDriv[i].firstName+'</td><td>'+data.searchInsAdditionalDriv[i].lastName+'</td><td>'+data.searchInsAdditionalDriv[i].drivingLicenseType+'</td><td>'+data.searchInsAdditionalDriv[i].dateOfBirth+'</td><td></tr>';
    					}

    			}
    			else
    		    {
    		    	outInsDrvAdd1='<h2>No records for Dealer Search Finance</h2>';
    		    }
    			//alert("inside"+outInsDrvAdd);
    			var quotIdHiddenField = '<input type="hidden" name="financeSearchId" value="' + data.searchInsuranceId + '" />';
    			var moveToUser = '<input type="checkbox" name="moveToUser" />';
    			if(data.newer)
    			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    			if(data.used)
    			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

    			// start of Extra Requirements
    			var extExt1 = '<input type="checkbox" name="extExt1" />';
    			if(data.extExt1)
    				extExt1 = '<input type="checkbox" name="extExt1" checked="checked" />';
    			var intExt2 = '<input type="checkbox" name="intExt2" />';
    			if(data.intExt2)
    				intExt2 = '<input type="checkbox" name="intExt2" checked="checked" />';
    			var extExt2 = '<input type="checkbox" name="extExt2" />';
    			if(data.extExt2)
    				extExt2 = '<input type="checkbox" name="extExt2" checked="checked" />';
    			var intExt3 = '<input type="checkbox" name="intExt3" />';
    			if(data.intExt3)
    				intExt3 = '<input type="checkbox" name="intExt3" checked="checked" />';
    			var extExt3 = '<input type="checkbox" name="extExt3" />';
    			if(data.extExt3)
    				extExt3 = '<input type="checkbox" name="extExt3" checked="checked" />';
    			var intExt4 = '<input type="checkbox" name="intExt4" />';
    			if(data.intExt4)
    				intExt4 = '<input type="checkbox" name="intExt4" checked="checked" />';
    			var extExt4 = '<input type="checkbox" name="extExt4" />';
    			if(data.extExt4)
    				extExt4 = '<input type="checkbox" name="extExt4" checked="checked" />';
    			var intExt5 = '<input type="checkbox" name="intExt5" />';
    			if(data.intExt5)
    				intExt5 = '<input type="checkbox" name="intExt5" checked="checked" />';
    			var extExt5 = '<input type="checkbox" name="extExt5" />';
    			if(data.extExt5)
    				extExt5 = '<input type="checkbox" name="extExt5" checked="checked" />';
    			var intExt6 = '<input type="checkbox" name="intExt6" />';
    			if(data.intExt6)
    				intExt6 = '<input type="checkbox" name="intExt6" checked="checked" />';
    			var intExt1 = '<input type="checkbox" name="intExt1" />';
    			if(data.intExt1)
    				intExt1 = '<input type="checkbox" name="intExt1" checked="checked" />';
    			var intExt7 = '<input type="checkbox" name="intExt7" />';
    			if(data.intExt7)
    				intExt7 = '<input type="checkbox" name="intExt7" checked="checked" />';
    			var intExt8 = '<input type="checkbox" name="intExt8" />';
    			if(data.intExt8)
    				intExt8 = '<input type="checkbox" name="intExt8" checked="checked" />';
         		// end of searc Insurance
         		
			//console.log("Vehicle quotation view"+JSON.stringify(data));
			var editDealerins12QuotationForm = '<form id="edit-dealer-ins12-quotation-content-form"><table>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
			<tr><td>Quotation ID</td><td>' + data.insQuotId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Status</td><td>' + status1 + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Requirement Details</div></div>\
			<tr><td>Offer Date</td><td>' + data.offerValidDate + '</td></tr>\
			<tr><td>Estimate Quote for the Job</td><td>' + data.driveAwayPrice + '</td></tr>\
			<tr><td>Quotated Hourly Rate</td><td>' + data.offerPrice2 + '</td></tr>\
			<tr><td>Min</td><td>' + data.offerPrice3 + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Items / Services Offered</div></div>\
			<tr><td></td><td>' +outInsDrvAdd + '</td></tr>\
			</table>\
			<table>\
			<tr><td>Dealer Terms and Conditions</td><td>' + data.flex1 + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<tr><td>Dealer Lead Id</td><td>' + data.dealSearchId + '</td></tr>\
			<tr><td>User Serv Req Id</td><td>' + data.carSearchId + '</td></tr>\
			<tr><td>Autoscoop User Id</td><td>' + data.userId + '</td></tr>\
			<tr><td>User Since</td><td>' + data.userCreationDate + '</td></tr>\
			</table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Registration</div></div>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Registration</div></div>\
			<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Vehicle Details</b></h6>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model</td><td>' + data.model + '</td></tr>\
			<tr><td>Autoscoop Trim</td><td>' + data.autoscoopTrim + '</td></tr>\
			<tr><td>Average No of Kms</td><td>' + data.avgNoOfKmYr + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Is the Car is Under Finance ?</b></h6>\
			<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
			<tr><td>Finance Provider</td><td>' + data.financeProvider + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Car Parked At Address</b></h6>\
			<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
			<tr><td>Where car Parked?</td><td>' + data.carParkedAt + '</td></tr>\
			<tr><td>Unit/StreetNo </td><td>' + data.streetNO + '</td></tr>\
			<tr><td>Street Name</td><td>' + data.streetName + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Car is Used for</b></h6>\
			<tr><td>Purpose</td><td>' + data.carUsedfor + '</td></tr>\
			<tr><td>Type of Business</td><td>' + data.typeOfBusiness + '</td></tr>\
			</table>\
			<br/>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Coverage Details</div></div>\
			<table>\
			<tr><td>Type of Coverage</td><td>' + data.insuranceType + '</td></tr>\
			</table>\
			<br/>\
			<h6 style="color:#bd191e;"><b>Agreed Value of Car</b></h6>\
			<table>\
			<tr><td>Agreed Value</td><td>' + data.agreedValue + '</td></tr>\
			<tr><td>Market Value</td><td>' + data.marketValue + '</td></tr>\
			</table>\
			<table>\
			<tr><td>Preferred Excess Amount</td><td>' + data.prefExcessAmount + '</td></tr>\
			<tr><td>Current Insurer</td><td>' + data.curInsProv + '</td></tr>\
			</table>\
			<br/>\
			<h5 style="color:#bd191e;"><b>Add Extra Requirements</b></h5>\
			<table>\
			<h6 style="color:#bd191e;"><b>External Requirements</b></h6>\
			<tr><td>Hire Car after Accident(ifany)</td><td>' + extExt1 +'</td><td>No Claim Bonus Protection</td><td>' + intExt2 + '</td></tr>\
			<tr><td>Excess Free Wind Screen</td><td>' + extExt2 +'</td><td>Allow Under 25 Driver</td><td>' + intExt3 + '</td></tr>\
			<tr><td>Excess Free Window Screen</td><td>' + extExt3 +'</td><td>Cover Theft & Fire</td><td>' + intExt4 + '</td></tr>\
			<tr><td>New Car Replace</td><td>' + extExt4 +'</td><td>Cover Towing Cost</td><td>' + intExt5 + '</td></tr>\
			<tr><td>Road Side Assitance</td><td>' + extExt5 +'</td><td>Essential Temporary Repairs</td><td>' + intExt6 + '</td></tr>\
			<tr><td>Life time Warrantly repairs</td><td>' + intExt1 +'</td><td>Accidental Damage</td><td>' + intExt7 + '</td></tr>\
			<tr><td>Emergency Accomdation and Transport</td><td>' + intExt8 + '</td></tr>\
			</table>\
			<br/>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Driver Details</div></div>\
			<table>\
			<tr><td>First Name</td><td>' + data.driverFirstName + '</td></tr>\
			<tr><td>Last Name</td><td>' + data.driverLastName + '</td></tr>\
			<tr><td>Mobile</td><td>' + data.driverMobileNo + '</td></tr>\
			<tr><td>Email</td><td>' + data.driverEmailId + '</td></tr>\
			<tr><td>Date Of Birth</td><td>' + data.dateOfBirth + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Driving Licence Details</b></h6>\
			<tr><td>Driving License Type</td><td>' + data.drivingLicenseType + '</td></tr>\
			<tr><td>Driving License No</td><td>' + data.drivingLicenseNo + '</td></tr>\
			<tr><td>Driving License Issue Date</td><td>' + data.licenseIssueDate + '</td></tr>\
			<tr><td>Driving License Issue State</td><td>' + data.drivingLicenseIssueState + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<h6 style="color:#bd191e;"><b>Drivers Claim History</b></h6>\
			<tr><td>No Of AtFaults</td><td>' + data.noOfAtFaults + '</td></tr>\
			<tr><td>Last AtFault Claim Date</td><td>' + data.lastAtFaultClaimDate + '</td></tr>\
			</table>\
			<br/>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Additional Driver Details</div></div>\
			<table>\
			<tr><td>No Of Drivers more than 1 ?</td><td>' + data.noOfDrivers + '</td></tr>\
			</table>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Additional Driver Information</div></div>\
			<tr><td></td><td>' +outInsDrvAdd1 + '</td></tr>\
			</table>\
			<br/>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
			<tr><td>Dealer Id</td><td>' + data.dealerId + '</td></tr>\
			<tr><td>Category</td><td>' + data.category  + '</td></tr>\
			<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
			<tr><td>Street</td><td>' + data.street + '</td></tr>\
			<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
			<tr><td>State</td><td>' + data.dealState + '</td></tr>\
			<tr><td>Post Code</td><td>' + data.dealPostCode + '</td></tr>\
			<tr><td>Country</td><td>' + data.country + '</td></tr>\
			<tr><td>Phone</td><td>' + data.phone + '</td></tr>\
			<tr><td>Website</td><td>' + data.website + '</td></tr>\
			<tr><td>Mobile</td><td>' + data.mobile + '</td></tr>\
			<tr><td>Toll Free</td><td>' + data.tollFree + '</td></tr>\
			<tr><td>Fax</td><td>' + data.fax + '</td></tr>\
			<tr><td>After Hours</td><td>' + data.afterHours + '</td></tr>\
			<tr><td>Postal Address</td><td>' + data.postalAddress + '</td></tr>\
			<tr><td>Email</td><td>' + data.email + '</td></tr>\
			<tr><td>Longitude</td><td>' + data.longitude + '</td></tr>\
			<tr><td>Latitude</td><td>' + data.latitude + '</td></tr>\
			</table>\
			<br/>\
			<br/>\
				</table></form>';
			editDealerins12QuotationForm = editDealerins12QuotationForm.replace(/>null</g, ">--NA--<");
			editDealerins12QuotationForm = editDealerins12QuotationForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-ins12-quotation-content").html(editDealerins12QuotationForm);
		});

		$('button.submit-editDealerins12QuotationModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-ins12-quotation-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/ins12Quotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerins12QuotationModal-" + result.quotId).data('details', result);
					alert("Successfully upated and moved to user");

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	
}
	
	
	// modal for Finance Quotation start
	
	function registerEditDealerfin12QuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerfin12QuotationModal = '<div class="modal fade" id="editDealerfin12QuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>Edit Finance Quotation</center></h4>\
			        <form id="edit-dealer-fin12-quotation-content-form">\
					<div class="modal-body edit-dealer-fin12-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
		                <button type="button" class="btn btn-primary submit-editDealerfin12QuotationModal" data-dismiss="modal">Save changes</button>\
		            </div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerfin12QuotationModal);


		$('a.anchor-editDealerfin12QuotationModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);

			var quotIdHiddenField = '<input type="hidden" name="finQuotId" value="' + data.finQuotId + '" />';
			var moveToUser = '<input type="checkbox" name="moveToUser" />';
			if(data.moveToUser)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';


			var editDealerfin12QuotationForm = '<form id="edit-dealer-fin12-quotation-content-form"><table>\
				<tr><td>Quotation ID</td><td>' + data.finQuotId + '</td></tr>\
				<tr><td>' + quotIdHiddenField + '</td></tr>\
				<tr><td>User ID</td><td>' + data.userId + '</td></tr>\
				<tr><td>Model Year</td><td>' + data.modelYear + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.modelName + '</td></tr>\
				<tr><td>Model Display</td><td>' + data.modelDisplay + '</td></tr>\
				<tr><td>Auto Bid</td><td>' + data.autoBid + '</td></tr>\
				<tr><td>Dealer Id</td><td>' + data.dealerId + '</td><td>Dealer Search Id</td><td>' + data.dealSearchId + '</td></tr>\
				<tr><td>Car Search Id</td><td>' + data.carSearchId + '</td><td>Ref Id</td><td>' + data.refId + '</td></tr>\
				<tr><td>Dealer Name</td><td>' + data.dealerName + '</td><td>Dealer ABN</td><td>' + data.dealerABN + '</td></tr>\
				<tr><td>Quot Header FreeText</td><td>' + data.quotHeaderFreeText + '</td><td>VIN Number</td><td>' + data.vinNumber + '</td></tr>\
				<tr><td>Rego No</td><td>' + data.regoNo + '</td><td>Rego End Date</td><td>' + data.regoEndDate + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoStat + '</td><td>Dealer Stock No</td><td>' + data.dealerStockNo + '</td></tr>\
				<tr><td>No Of Kms</td><td>' + data.noOfKms + '</td><td>Drive Away Price</td><td>' + data.driveAwayPrice + '</td></tr>\
				<tr><td>Negotiable</td><td>' + data.negotiable + '</td><td>Offer Valid Date</td><td>' + data.offerValidDate + '</td></tr>\
				<tr><td>First Come Serve</td><td>' + data.firstCumServe + '</td><td>Color</td><td>' + data.color + '</td></tr>\
				<tr><td>Transmission</td><td>' + data.transmission + '</td><td>Drive Type</td><td>' + data.driveType + '</td></tr>\
				<tr><td>Fuel Type</td><td>' + data.fuelType + '</td><td>No Of Seats</td><td>' + data.noOfSeats + '</td></tr>\
				<tr><td>No Of Doors</td><td>' + data.noOfDoors + '</td><td>Dealer Preferred Location</td><td>' + data.delPrefLocation + '</td></tr>\
				<tr><td>Offer Price 2</td><td>' + data.offerPrice2 + '</td><td>Offer Price 3</td><td>' + data.offerPrice3 + '</td></tr>\
				</table></form>';
			editDealerfin12QuotationForm = editDealerfin12QuotationForm.replace(/>null</g, ">--NA--<");
			editDealerfin12QuotationForm = editDealerfin12QuotationForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-fin12-quotation-content").html(editDealerfin12QuotationForm);
		});

		$('button.submit-editDealerfin12QuotationModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-fin12-quotation-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/fin12Quotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerfin12QuotationModal-" + result.quotId).data('details', result);
					alert("Successfully upated and moved to user");

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	
	// start of sell my vehicle view
	
	function registerEditDealerVehicleMVQuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicleMVQuotationModal = '<div class="modal fade" id="editDealerVehicleMVQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Sell My Vehicle Details</center></h4>\
			        <form id="edit-dealer-vehicle-mv-quotation-content-form">\
					<div class="modal-body edit-dealer-vehicle-mv-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleMVQuotationModal);


		$('a.anchor-editDealerVehicleMVQuotationModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);
	//alert("datainside"+JSON.stringify(data)); work here
			  var quotIdHiddenField = '<input type="hidden" name="repoId" value="' + data.repoId + '" />';
			// start
				var appId = '249863545451459';
		    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
			      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
		      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
		      AWS.config.region = 'us-east-1';
		      var bucket = new AWS.S3({
		          params: {
		              Bucket: bucketName
		          }
		      });
		     accessToken = $.jStorage.get("fbAToken");
		     bucket.config.credentials = new AWS.WebIdentityCredentials({
	                  ProviderId: 'graph.facebook.com',
	                  RoleArn: roleArn,
	                  WebIdentityToken: accessToken
	              });
		     fbUserId = $.jStorage.get("fbKey");
		     //alert(data.warranty);
		     //console.log(JSON.stringify(data));
		     url1=" ";
		     var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.warranty, Expires: 60};
		     bucket.getSignedUrl('getObject', params, function (err, url) {
	          if (url) {
	          url1=url;
		           var editDealerVehicleMVQuotationForm = '<form id="edit-dealer-vehicle-mv-quotation-content-form">\
					  <table>\
					  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
						<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Sell My Vehicle Details</div></div>\
						<tr><td>Inventory ID</td><td>' + data.repoId + '</td></tr>\
						<tr><td>' + quotIdHiddenField + '</td></tr>\
							<tr><td>Inventory Created Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
	    					<tr><td>Header Text</td><td>' + data.vehicleDescriptin + '</td></tr>\
	    					<tr><td>Condition</td><td>' + data.typeOfCar + '</td></tr>\
	    					<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
	    					<tr><td>Rego state</td><td>' + data.state + '</td></tr>\
	    					<tr><td>Rego End Date</td><td>' + data.regExpiryDate + '</td></tr>\
	    					<tr><td>VIN / HIN Numb</td><td>' + data.vinNumber + '</td></tr>\
	    					<tr><td>Year</td><td>' + data.modelYear + '</td></tr>\
	    					<tr><td>Make</td><td>' + data.modelDisplay + '</td></tr>\
	    					<tr><td>Model</td><td>' + data.modelName + '</td></tr>\
	    					<tr><td>Variant</td><td>' + data.modelTrim + '</td></tr>\
	    					<tr><td>Mileage</td><td>' + data.kilometer + '</td></tr>\
	    					<tr><td>Colour [External]</td><td>' + data.intColor + '</td></tr>\
	    					<tr><td>Colour [Internal]</td><td>' + data.extColor + '</td></tr>\
	    					<tr><td>Road Worthy Prov</td><td>' + data.logBookService + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Pricing</div></div>\
	    					<tr><td>Pricing Type</td><td>' + data.driveType + '</td></tr>\
	    					<tr><td>Amount</td><td>' + data.price + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Listing Type</div></div>\
	    					<tr><td>Auto Quote</td><td>' + data.autoQuote + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Address Details</div></div>\
	    					<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
	    					<tr><td>Address</td><td>' + data.addrSell + '</td></tr>\
	    					<tr><td>Contact Name</td><td>' + data.contName + '</td></tr>\
	    					<tr><td>Mobile No</td><td>' + data.contPhone + '</td></tr>\
	    					</table>\
						<br/>\
						<br/>\
				   </form>';
				  editDealerVehicleMVQuotationForm = editDealerVehicleMVQuotationForm.replace(/>null</g, ">--NA--<");
				  editDealerVehicleMVQuotationForm = editDealerVehicleMVQuotationForm.replace(/>undefined</g, ">--NA--<");
				  $(".edit-dealer-vehicle-mv-quotation-content").html(editDealerVehicleMVQuotationForm);
		          }
		          else{
		          alert("not able to retrieve photo for My sell vehicle however you an view other details"+err);
		           var editDealerVehicleMVQuotationForm = '<form id="edit-dealer-vehicle-mv-quotation-content-form">\
					  <table>\
					  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
						<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Sell My Vehicle Details</div></div>\
						<tr><td>Inventory ID</td><td>' + data.repoId + '</td></tr>\
						<tr><td>' + quotIdHiddenField + '</td></tr>\
							<tr><td>Inventory Created Date</td><td>' + data.creationDate + '</td></tr>\
	    					</table>\
	    					<br/>\
	    					<table>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
	    					<tr><td>Header Text</td><td>' + data.vehicleDescriptin + '</td></tr>\
	    					<tr><td>Condition</td><td>' + data.typeOfCar + '</td></tr>\
	    					<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
	    					<tr><td>Rego state</td><td>' + data.state + '</td></tr>\
	    					<tr><td>Rego End Date</td><td>' + data.regExpiryDate + '</td></tr>\
	    					<tr><td>VIN / HIN Numb</td><td>' + data.vinNumber + '</td></tr>\
	    					<tr><td>Year</td><td>' + data.modelYear + '</td></tr>\
	    					<tr><td>Make</td><td>' + data.modelDisplay + '</td></tr>\
	    					<tr><td>Model</td><td>' + data.modelName + '</td></tr>\
	    					<tr><td>Variant</td><td>' + data.modelTrim + '</td></tr>\
	    					<tr><td>Mileage</td><td>' + data.kilometer + '</td></tr>\
	    					<tr><td>Colour [External]</td><td>' + data.intColor + '</td></tr>\
	    					<tr><td>Colour [Internal]</td><td>' + data.extColor + '</td></tr>\
	    					<tr><td>Road Worthy Prov</td><td>' + data.logBookService + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Pricing</div></div>\
	    					<tr><td>Pricing Type</td><td>' + data.driveType + '</td></tr>\
	    					<tr><td>Amount</td><td>' + data.price + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Listing Type</div></div>\
	    					<tr><td>Auto Quote</td><td>' + data.autoQuote + '</td></tr>\
	    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Address Details</div></div>\
	    					<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
	    					<tr><td>Address</td><td>' + data.addrSell + '</td></tr>\
	    					<tr><td>Contact Name</td><td>' + data.contName + '</td></tr>\
	    					<tr><td>Mobile No</td><td>' + data.contPhone + '</td></tr>\
	    					</table>\
						<br/>\
						<br/>\
				   </form>';
				  editDealerVehicleMVQuotationForm = editDealerVehicleMVQuotationForm.replace(/>null</g, ">--NA--<");
				  editDealerVehicleMVQuotationForm = editDealerVehicleMVQuotationForm.replace(/>undefined</g, ">--NA--<");
				  $(".edit-dealer-vehicle-mv-quotation-content").html(editDealerVehicleMVQuotationForm);

	          }
	        });
		});


		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	
}
	// end of sell my vehicle view
	
	

	
	// modal for vehicle Quotation start
	
	function registerEditDealerVehicleQuotationModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicleQuotationModal = '<div class="modal fade" id="editDealerVehicleQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>Edit Vehicle Quotation</center></h4>\
			        <form id="edit-dealer-vehicle-quotation-content-form">\
					<div class="modal-body edit-dealer-vehicle-quotation-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			<button type="button" class="btn btn-primary submit-editDealerVehicleQuotationModal" data-dismiss="modal">Save changes</button>\
		            </div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleQuotationModal);


		$('a.anchor-editDealerVehicleQuotationModal').on('click', function(event) {


			  var data = $(event.target).data('details');
			  var quotIdHiddenField = '<input type="hidden" name="quotId" value="' + data.quotId + '" />';
			  var moveToUser = '<input type="checkbox" name="moveToUser" />';
			  if(data.moveToUser)
			    moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			  var shortList = '<input type="checkbox" name="shortList" />';
			  var makeOffer = '<input type="checkbox" name="makeOffer" />';
			  var makeDeposit = '<input type="checkbox" name="makeDeposit" />';
			  var chat = '<input type="checkbox" name="chat" />';
			  var rejectIt = '<input type="checkbox" name="rejectIt" />';
			  var postCode = '<input type="text" name="postCode" />';
			  var title = '<input type="text" name="title" />';
			  var lname = '<input type="text" name="lname" />';
			  var fname = '<input type="text" name="fname" />';
			  var address = '<input type="text" name="address" />';
			  var mobileNum = '<input type="text" name="mobileNum" />';
			  var prefDate = '<input type="date" name="prefDate" />';
			  var comment = '<input type="text" name="comment" />';
			  // quotation start
			  outInsDrvAdd = "";
			    var drvAddInfo = data.vehQuotExtras;
			    //alert("came here");
				if(drvAddInfo){
					 outInsDrvAdd += '<tr><th>'+"Extras "+'</th><th>'+"Quantity"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
					 for(i=0;i<data.vehQuotExtras.length;i++)
						{
						 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.vehQuotExtras[i].extras1+'</td><td>'+data.vehQuotExtras[i].extras2+'</td><td>'+data.vehQuotExtras[i].amount+'</td><td></tr>';
						}

				}
				else
			    {
			    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
			    }
				// start of Doc
				outInsDrvDoc = "";
			    var drvAddDoc = data.vehQuotDoc;
			    //alert("came here");
				if(drvAddDoc){
					outInsDrvDoc += '<tr><th>'+"Document Required "+'</th><th>'+"Quantity"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
					 for(i=0;i<data.vehQuotExtras.length;i++)
						{
						 outInsDrvDoc= outInsDrvDoc+'<tr>'+'<td>'+data.vehQuotDoc[i].extras1+'</td><td>'+data.vehQuotDoc[i].extras2+'</td><td>'+data.vehQuotDoc[i].amount+'</td><td></tr>';
						}

				}
				else
			    {
					outInsDrvDoc='<h2>No records for Dealer Search Finance</h2>';
			    }
				// end of Doc
				// start of Term
				outInsDrvTerm = "";
			    var drvAddTerm = data.vehQuotTerm;
			    //alert("came here");
				if(drvAddTerm){
					outInsDrvTerm += '<tr><th>'+"Terms and Conditions "+'</th><th>'+"Quantity"+'</th><th>'+"Price"+'</th>'+'</th></tr>';
					 for(i=0;i<data.vehQuotExtras.length;i++)
						{
						 outInsDrvTerm= outInsDrvTerm+'<tr>'+'<td>'+data.vehQuotTerm[i].extras1+'</td><td>'+data.vehQuotTerm[i].extras2+'</td><td>'+data.vehQuotTerm[i].amount+'</td><td></tr>';
						}

				}
				else
			    {
					outInsDrvTerm='<h2>No records for Dealer Search Finance</h2>';
			    }
				// end of Term

				var quotIdHiddenField = '<input type="hidden" name="quotId" value="' + data.quotId + '" />';
				var moveToUser = '<input type="checkbox" name="moveToUser" />';
				
				if(data.newer)
					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
					if(data.used)
					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
					 status1="Submitted to User for View";
	 	         		if(data.status){status1="Submitted to User for View";}
			  // quotation end
			  
			  
			  // logic to retrieve
         		out5DD = "";
			    var dealDt = data.userQuotationHistoryVO;
			    if(dealDt)
			    {
			    	dealDt = data.userQuotationHistoryVO.length;
		  	   //document.getElementById('finMax').innerHTML=finMax;
			    	out5DD += '<tr><th>'+"Car History ID"+'</th><th>'+"Comment"+'</th><th>'+"Creation Date"+'</th></tr>';
			 	   	for(i=0;i<data.userQuotationHistoryVO.length;i++)
					{
			 		   out5DD= out5DD+'<tr>'+'<td>'+data.userQuotationHistoryVO[i].userQuotationHistoryId+'</td><td>'+data.userQuotationHistoryVO[i].comment+'</td><td>'+data.userQuotationHistoryVO[i].creationDate+'</td><td></tr>';
					}

			    }
			    else
			    {
			    	out5DD='<h2>No records for Dealer Search Finance</h2>';
			    }
			    out5DD1 = "";
			    var dealDt1 = data.dealerQuotationHistoryVO;
			    if(dealDt1)
			    {
			    	dealDt1 = data.dealerQuotationHistoryVO.length;
			    	out5DD1 += '<tr><th>'+"Car History ID"+'</th><th>'+"Comment"+'</th><th>'+"Creation Date"+'</th></tr>';
			    	for(i=0;i<data.dealerQuotationHistoryVO.length;i++)
					{
			    		out5DD1= out5DD1+'<tr>'+'<td>'+data.dealerQuotationHistoryVO[i].dealQuotationHistoryId+'</td><td>'+data.dealerQuotationHistoryVO[i].comment+'</td><td>'+data.dealerQuotationHistoryVO[i].creationDate+'</td><td></tr>';
					}

			    }
			    else
			    {
			    	out5DD1='<h2>No records for Dealer Search Finance</h2>';
			    }
			  if(data.postCode != null)
			   postCode =data.postCode;
			  if(data.title != null)
			   title=data.title;
			  if(data.lname != null)
			   lname=data.lname;
			  if(data.fname != null)
			   fname=data.fname;
			  if(data.address != null)
			   address= data.address;
			  if(data.mobileNum != null)
			   mobileNum=data.mobileNum ;
			  if(data.prefDate != null)
			   prefDate=data.prefDate;
			  if(data.shortList)
			   shortList = '<input type="checkbox" name="shortList" checked="checked" />';
			  if(data.makeOffer)
			    makeOffer = '<input type="checkbox" name="makeOffer" checked="checked"/>';
			  if(data.makeDeposit)
			   makeDeposit='<input type="checkbox" name="makeDeposit" checked="checked"/>';
			  if(data.chat)
			   chat='<input type="checkbox" name="chat" checked="checked"/>';
			  if(data.rejectIt)
			   rejectIt= '<input type="checkbox" name="rejectIt" checked="checked" />';
			  var editDealerVehicleQuotationForm = '<form id="edit-dealer-vehicle-quotation-content-form">\
				  <table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
					<tr><td>Quotation ID</td><td>' + data.quotId + '</td></tr>\
					<tr><td>' + quotIdHiddenField + '</td></tr>\
					<tr><td>Status</td><td>' + status1 + '</td></tr>\
    					<tr><td>Quotation Created Date</td><td>' + data.creationDate + '</td></tr>\
    					</table>\
    					<br/>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Requirement Details</div></div>\
					<tr><td>Offer Date</td><td>' + data.regoEndDate + '</td></tr>\
					<tr><td>Drive Away Price</td><td>' + data.driveAwayPrice + '</td></tr>\
					<tr><td>What you Save</td><td>' + data.offerPrice2 + '</td></tr>\
					<tr><td>Actual Value of Offer</td><td>' + data.offerPrice3 + '</td></tr>\
					</table>\
					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Offer Details</div></div>\
    					<tr><td>Year</td><td>' + data.modelYear + '</td></tr>\
    					<tr><td>Make</td><td>' + data.modelDisplay + '</td></tr>\
    					<tr><td>Model</td><td>' + data.modelName + '</td></tr>\
    					<tr><td>AutoScoop Trim</td><td>' + data.modelTrim + '</td></tr>\
    					<tr><td>Basic price for Make </td><td>' + data.basicPrice + '</td></tr>\
    					</table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Extras Details</div></div>\
    					<tr><td></td><td>' +outInsDrvAdd + '</td></tr>\
    					</table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Document Details</div></div>\
    					<tr><td></td><td>' +outInsDrvDoc + '</td></tr>\
    					</table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Terms and Conditions</div></div>\
    					<tr><td></td><td>' +outInsDrvTerm + '</td></tr>\
    					</table>\
					<table>\
					<tr><td>Dealer Terms and Conditions</td><td>' + data.fname + '</td></tr>\
					</table>\
					<br/>\
					<table>\
					<tr><td>Dealer Lead Id</td><td>' + data.dealSearchId + '</td></tr>\
					<tr><td>User Requirement Id</td><td>' + data.carSearchId + '</td></tr>\
					<tr><td>Autoscoop User Id</td><td>' + data.userId + '</td></tr>\
					<tr><td>User Since</td><td>' + data.userCreationDate + '</td></tr>\
					</table>\
					<br/>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Requirement</div></div>\
					<tr><td>New</td><td>' + moveToUser + '</td></tr>\
					<tr><td>Used</td><td>' + moveToUser1 + '</td></tr>\
					<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
					<tr><td>Insurance</td><td>' + data.insurance + '</td></tr>\
					<tr><td>PostCode</td><td>' + data.postCode + '</td></tr>\
					</table>\
					<br/>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Pick your Fav Color</div></div>\
					<tr><td>Car Color 1</td><td>' + data.color + '</td></tr>\
					<tr><td>Car Color 2</td><td>' + data.transmission + '</td></tr>\
					</table>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">You can add your preferred extras</div></div>\
					<tr><td></td></tr>\
					</table>\
					<br/>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">You can tell More about your requirements</div></div>\
					<tr><td>' + data.driveType + '</td></tr>\
					</table>\
					<table>\
					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
					<tr><td>Dealer Id</td><td>' + data.dealerId + '</td></tr>\
					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
					<tr><td>Street</td><td>' + data.street + '</td></tr>\
					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
					<tr><td>Post Code</td><td>' + data.dealPostCode + '</td></tr>\
					<tr><td>Country</td><td>' + data.country + '</td></tr>\
					<tr><td>Phone</td><td>' + data.phone + '</td></tr>\
					<tr><td>Website</td><td>' + data.website + '</td></tr>\
					<tr><td>Mobile</td><td>' + data.mobile + '</td></tr>\
					<tr><td>Toll Free</td><td>' + data.tollFree + '</td></tr>\
					<tr><td>Fax</td><td>' + data.fax + '</td></tr>\
					<tr><td>After Hours</td><td>' + data.afterHours + '</td></tr>\
					<tr><td>Postal Address</td><td>' + data.postalAddress + '</td></tr>\
					<tr><td>Email</td><td>' + data.email + '</td></tr>\
					<tr><td>Longitude</td><td>' + data.longitude + '</td></tr>\
					<tr><td>Latitude</td><td>' + data.latitude + '</td></tr>\
					</table>\
					<br/>\
					<br/>\
			   <table>\
			   <div class="row"><div class="col-sm-12 col-md-12 product-search-title">Request Test Drive</div></div>\
			   <tr><td>Post Code</td><td>' +postCode + '</td></tr>\
			   <tr><td>Mr </td><td>' + title + '</td><td>First Name </td><td>' +fname  + '</td><td>Last Name </td><td>' +lname + '</td></tr>\
			   <tr><td>Address </td><td>' +address  + '</td><td>Mobile No:</td><td>' +mobileNum  + '</td></tr>\
			   <tr><td>Preferred Date </td><td>' +prefDate + '</td></tr></table>\
			   <table>\
			   <div class="row"><div class="col-sm-12 col-md-12 product-search-title">What can be done to Quotation?</div></div>\
			   <tr><td>Short List </td><td>' + shortList + '</td><td>Make an Offer </td><td>' +makeOffer  + '</td><td>Make a deposit </td><td>' +makeDeposit + '</td></tr>\
			   <tr><td>Chat </td><td>' +chat  + '</td><td>Reject it </td><td>' +rejectIt  + '</td></tr>\
			   </table><br /><br /><br />\
			   <table>\
			   <div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Chat History</div></div>\
			   <tr><td>History</td><td>' +out5DD + '</td></tr></table>\
			   <table>\
			   <div class="row"><div class="col-sm-12 col-md-12 product-search-title">Dealer Chat History</div></div>\
			   <tr><td>History</td><td>' +out5DD1 + '</td></tr></table>\
			   <table>\
			   <div class="row"><div class="col-sm-12 col-md-12 product-search-title">Write a comment</div></div>\
			   <tr><td>Comment</td><td>' +comment + '</td></tr>\
			   </table>\
			   <table>\
			   </form>';
			  editDealerVehicleQuotationForm = editDealerVehicleQuotationForm.replace(/>null</g, ">--NA--<");
			  editDealerVehicleQuotationForm = editDealerVehicleQuotationForm.replace(/>undefined</g, ">--NA--<");
			  $(".edit-dealer-vehicle-quotation-content").html(editDealerVehicleQuotationForm);
			 });

		$('button.submit-editDealerVehicleQuotationModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-vehicle-quotation-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/vehicleSearchQuotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerVehicleQuotationModal-" + result.quotId).data('details', result);
					alert("Successfully upated the Quotations");
					//alert("will call update");
					$scope.carCarQuotation();

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	
}
	
	
	// To get all car Overview default
	carUserNotific();
	//$scope.carUserNotific = function(){
	function  carUserNotific(){	
				userId=$.jStorage.get('key').userId;
				// search
				var finMax = value.searchCount;
				document.getElementById('finMax').innerHTML=finMax;

				//search Finance
				var finCt = value.searchFinCount;
	        	document.getElementById('finCt').innerHTML=finCt;

	        	//search Insurance
	        	var insRCt=value.searchInsCount;
		        document.getElementById('insRCt').innerHTML=insRCt;

		        //search Serv Maint
				var servRCt = value.searchServCount;
        	    document.getElementById('servRCt').innerHTML=servRCt;
				   // search Transp
        	    var trasRCt = value.searchTranspCount;
		      	document.getElementById('trasRCt').innerHTML=trasRCt;
		      	
			     // vehicle Quotation
			   	 var qtRecd = value.vehicleQuotCt;
			   	 document.getElementById('qtRecd').innerHTML=qtRecd;
			   	 // finance Quotation
			   	 var finQCt=value.financeQuotCt;
			   	 document.getElementById('finQCt').innerHTML=finQCt;
				// insurance Quotation
			   	 var insQCt=value.insuranceQuotCt;
			   	 document.getElementById('insQCt').innerHTML=insQCt;
			   	 // Serv Maint Quotation
			   	 var servQCt = value.servMaintQuotCt;
			   	 document.getElementById('servQCt').innerHTML=servQCt;
			   	 // Transport Quotation
			   	 var trasQCt = value.transpServQuotCt;
		   		 document.getElementById('trasQCt').innerHTML=trasQCt;
		      	
		      	
		   		 var wsURL = 'api/getUseNotByUserId?userid='+userId;
		   		 // change here

		   		 //$body.addClass("loading");
	    	$http({
				method : 'GET',
				url : wsURL

			}).success(function(result) {
				//$body.removeClass("loading");
				//alert("successfully retreived");
				
				out12="";
  	         	out12 += '<tr><th>'+"Reminder Type"+'</th><th>'+"Message"+'</th><th>'+"Status"+'</th><th>'+"Operation"+'</th></tr>';

	         	   for(i=result.length-1;i>=0;i--)
	        		{
	         		   status1="Pending";
	         		if(result[i].status){status1="Completed";}
	        		out12= out12+'<tr>'+'<td>'+result[i].code+'</td>'+'<td>'+result[i].comment+'</td>'+'<td>'+status1+'</td>'+'<td><a href="#" id="anchor-editDealerusnVehicletranspModal-' + result[i].userNotificationId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerusnVehicletranspModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerusnVehicletranspModal">View</a></td></tr>';


	        		}
	         	   out12 = out12.replace(/>null</g, ">--NA--<");
	         	   out12 = out12.replace(/>undefined</g, ">--NA--<");
	         	var LogUserNot = result;

	         if(LogUserNot && result.length==0){
		         outLogT="";
		         outLogT='<h2>No records found</h2>';
		         $("#"+"userNotification").html(outLogT);
	         } else {
	        	 $("#"+"userNotification").html(out12);
	         }

	         registerEditDealerusnVehicletranspModal();
							});
	    	
	    	
	    	// start of searchFinance
	    	
	    	var wsURL = 'api/getCurrentOffers';
			// change here

		   $body.addClass("loading");
		    	$http({
					method : 'GET',
					url : wsURL

				}).success(function(result) {
					$body.removeClass("loading");
					//alert("successfully retreived");			
					out14="";
	         	   	for(i=result.length-1;i>=0;i--)
	        		{
	         		   out14= out14+'<tr>'+'<td>'+result[i].code+'</td>'+'<td>'+result[i].makeDescription+'</td></tr>';
	        		}
	         	   	out14 = out14.replace(/>null</g, ">--NA--<");
	         	   	out14 = out14.replace(/>undefined</g, ">--NA--<");
	         	   	$("#"+"currentOffers").html(out14);
								});
		    	
		    	    	
				    	
	}
	
	// modal for user Notification start
	function registerEditDealerusnVehicletranspModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerusnVehicletranspModal = '<div class="modal fade" id="editDealerusnVehicletranspModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View User Notification Details</center></h4>\
			        <form id="edit-dealer-usn-vehicle-transp-content-form">\
					<div class="modal-body edit-dealer-usn-vehicle-transp-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
			<button type="button" class="btn btn-primary submit-editDealerusnVehicletranspModal" data-dismiss="modal">Save changes</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerusnVehicletranspModal);


		$('a.anchor-editDealerusnVehicletranspModal').on('click', function(event) {


			var data = $(event.target).data('details');
			var quotIdHiddenField = '<input type="hidden" name="userNotificationId" value="' + data.userNotificationId + '" />';
			// start work here
			
			var status = '<input type="checkbox" name="status" />';
			if(data.status)
				status = '<input type="checkbox" name="status" checked="checked" />';
			var editDealerusnVehicletranspForm = '<form id="edit-dealer-usn-vehicle-transp-content-form"><table>\
				<tr><td>userNotificationId</td><td>' + data.userNotificationId + '</td></tr>\
				<tr><td>' + quotIdHiddenField + '</td></tr>\
				<tr><td>Reminder Type </td><td>' + data.code + '</td></tr>\
				<tr><td>Vehicle Type </td><td>' + data.typeOfReq + '</td></tr>\
				<tr><td>Reg No / VIN </td><td>' + data.makeDescription + '</td></tr>\
				<tr><td>Due Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="date" class="input-text full-width" value="' + data.flex11 + '"/></td></tr>\
				<tr><td>Message </td><td>' + data.comment + '</td></tr>\
				<tr><td>Status</td><td>' + status + '</td></tr>\
				</table></form>';
			editDealerusnVehicletranspForm = editDealerusnVehicletranspForm.replace(/>null</g, ">--NA--<");
			editDealerusnVehicletranspForm = editDealerusnVehicletranspForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-usn-vehicle-transp-content").html(editDealerusnVehicletranspForm);
		});

		$('button.submit-editDealerusnVehicletranspModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-usn-vehicle-transp-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/myVehicleNotifyeUpdate?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerusnVehicletranspModal-" + result.myVehicleId).data('details', result);
					alert("Successfully upated the My Vehicle Garage Details..");
					//angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();

				}
			});


		});
		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	// end of usn
	
	
	//To get all CarSearch EBID request by userid
	$scope.carEbidRequest = function(){
		carEbidRequest();
	}
	//$scope.carEbidRequest = function(){
		
	function carEbidRequest(){
		
		userId=$.jStorage.get('key').userId;
		//fbUserId=$.jStorage.get("fbKey");

		var wsURL = 'api/getSearchByUserId?userid='+userId;
		// change here

	   //$body.addClass("loading");
	    	$http({
				method : 'GET',
				url : wsURL

			}).success(function(result) {
				//$body.removeClass("loading");
				//alert("successfully retreived");
				
					out="";
	        	   var finMax = result.length;
	        	   document.getElementById('finMax').innerHTML=finMax;

	        	   out += '<tr><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th><th>'+"Operation"+'</th></tr>';
	        	   for(i=result.length-1;i>=0;i--)
		       		{
		       		 	out= out+'<tr>'+'<td>'+result[i].carSearchId+'</td>'+'<td>'+result[i].modelYear+'<td>'+result[i].modelDisplay+'</td>'+'</td>'+'<td>'+result[i].modelName+'</td>'+'<td>'+result[i].modelTrim+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result[i].carSearchId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		       		}
	        	   out = out.replace(/>null</g, ">--NA--<");
	        	   out = out.replace(/>undefined</g, ">--NA--<");
	        	   //alert(out);
	        	   var LogSearch = result;

	        	   if(LogSearch && result.length==0){
		        	   outLogT="";
		        	   outLogT='<h2>No records found</h2>';
		        	   $("#"+"car-model-data").html(outLogT);
	        	   }
	        	   else{
	        		   $("#"+"car-model-data").html(out);
	        	   }
	        	   registerEditDealerVehicleSearchModal();
							});
	    	
	    	
	    	// start of searchFinance
	    	
	    	var wsURL = 'api/getFinanceByUserId?userid='+userId;
			// change here

		   //$body.addClass("loading");
		    	$http({
					method : 'GET',
					url : wsURL

				}).success(function(result) {
					//$body.removeClass("loading");
					//alert("successfully retreived");
					
					out1="";

					var finCt = result.length;
					document.getElementById('finCt').innerHTML=finCt;
					out1 += '<tr><th>'+"Car Finance ID"+'</th><th>'+"Vehicle Value"+'</th><th>'+"Balloon Pay"+'</th><th>'+"Loan Amount"+'</th><th>'+"Operation"+'</th></tr>';

		        	for(i=result.length-1;i>=0;i--)
		       		{
		        		out1= out1+'<tr>'+'<td>'+result[i].searchFinanceId+'</td>'+'<td>'+result[i].vehValue+'</td>'+'<td>'+result[i].balloonPay+'</td>'+'<td>'+result[i].loanAmount+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleFinanceModal-' + result[i].searchFinanceId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleFinanceModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleFinanceModal">View</a></td></tr>';
		       		}
		        	out1 = out1.replace(/>null</g, ">--NA--<");
	        	   	out1 = out1.replace(/>undefined</g, ">--NA--<");

		        	var LogFinance = result;

		        	  if(LogFinance && result.length==0){
			        	  outLogT="";
			        	  outLogT='<h2>No records found</h2>';
			        	  $("#"+"data1").html(outLogT);
		        	  }
		        	  else{
		        		  $("#"+"data1").html(out1);
		        	  }
		        	  registerEditDealerVehicleFinanceModal();
								});
		    	
		    	
		    	// start of searchInsurance
		    	
		    	var wsURL = 'api/getInsuranceByUserId?userid='+userId;
				// change here

			   //$body.addClass("loading");
			    	$http({
						method : 'GET',
						url : wsURL

					}).success(function(result) {
						//$body.removeClass("loading");
						//alert("successfully retreived");
						
						out2="";
			        	  var insRCt=result.length;
			        	   document.getElementById('insRCt').innerHTML=insRCt;
			        	   out2 += '<tr><th>'+"Car Insurance ID"+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th><th>'+"Operation"+'</th></tr>';

			        		   for(i=result.length-1;i>=0;i--)
			       		{

			       		out2= out2+'<tr>'+'<td>'+result[i].searchInsuranceId+'</td>'+'<td>'+result[i].insuranceType+'</td>'+'<td>'+result[i].marketValue+'</td>'+'<td>'+result[i].agreedValue+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleInsuranceModal-' + result[i].searchInsuranceId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleInsuranceModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleInsuranceModal">View</a></td></tr>';


			       		}
			        	   out2 = out2.replace(/>null</g, ">--NA--<");
			        	   out2 = out2.replace(/>undefined</g, ">--NA--<");

			        	   var LogInsurance = result;

			        	   if(LogInsurance && result.length==0){
			        	   outLogT="";
			        	   outLogT='<h2>No records found</h2>';
			        	   //forFinance("car-model-data2",outLogT);
			        	   $("#"+"car-model-data2").html(outLogT);
			        	   }else{
			        	   //forFinance("car-model-data2",out2);
			        	  $("#"+"car-model-data2").html(out2);
					   }
			        	   registerEditDealerVehicleInsuranceModal();
									});
			    	
			    	
			    	// start of servMaint
			    	
			    	var wsURL = 'api/getServMtByUserId?userid='+userId;
					// change here

				   //$body.addClass("loading");
				    	$http({
							method : 'GET',
							url : wsURL

						}).success(function(result) {
							//$body.removeClass("loading");
							//alert("successfully retreived");
							
							out10="";

	        	         	   var servRCt = result.length;
	        	         	   document.getElementById('servRCt').innerHTML=servRCt;
	        	         	   out10 += '<tr><th>'+"Car Serv Maint ID"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th><th>'+"Operation"+'</th></tr>';
	        	         	   for(i=result.length-1;i>=0;i--)
	        	        		{
	        	         		   out10= out10+'<tr>'+'<td>'+result[i].searchServMaintId+'</td>'+'<td>'+result[i].servMaintL1+'</td>'+'<td>'+result[i].servMaintL2+'</td>'+'<td>'+result[i].regoState+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + result[i].searchServMaintId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td></tr>';
	        	        		}
	        	         	   out10 = out10.replace(/>null</g, ">--NA--<");
	        	         	   out10 = out10.replace(/>undefined</g, ">--NA--<");
	        	         	  var LogSearchServMaint = result;

	        	         	 if(LogSearchServMaint && result.length==0){
		        	         	 outLogT="";
		        	         	 outLogT='<h2>No records found</h2>';
		        	         	 $("#"+"dataservmaint").html(outLogT);
	        	         	 } else{
	        	         		$("#"+"dataservmaint").html(out10);
	        	         	 }
	        	         	registerEditDealerVehicleservmaintModal();
										});
				    	
				    	
				    	
				    	// start of transp
				    	
				    	var wsURL = 'api/getTranspByUserId?userid='+userId;
						// change here

					   //$body.addClass("loading");
					    	$http({
								method : 'GET',
								url : wsURL

							}).success(function(result) {
								//$body.removeClass("loading");
								//alert("successfully retreived");
								
								 out11="";

			      	         	   var trasRCt = result.length;
			      	         	   document.getElementById('trasRCt').innerHTML=trasRCt;
			      	         	   out11 += '<tr><th>'+"Car Trans ID"+'</th><th>'+"pickUpDateTime"+'</th><th>'+"noOfCars"+'</th><th>'+"fromPostCodeAddr"+'</th><th>'+"Operation"+'</th></tr>';
			      	         	   for(i=result.length-1;i>=0;i--)
			      	        		{
			      	         		   out11= out11+'<tr>'+'<td>'+result[i].searchTranspId+'</td>'+'<td>'+result[i].pickUpDateTime+'</td>'+'<td>'+result[i].noOfCars+'</td>'+'<td>'+result[i].fromPostCodeAddr+'</td>'+'<td><a href="#" id="anchor-editDealerVehicletranspModal-' + result[i].searchTranspId + '" data-details=\'' + JSON.stringify(result[i]) + '\' class="anchor-editDealerVehicletranspModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicletranspModal">View</a></td></tr>';
			      	        		}
			      	         	   out11 = out11.replace(/>null</g, ">--NA--<");
			      	         	   out11 = out11.replace(/>undefined</g, ">--NA--<");
			      	         	var LogSearchTransp = result;

			      	         	if(LogSearchTransp && result.length==0){
				      	         	outLogT="";
				      	         	outLogT='<h2>No records found</h2>';
				      	         	$("#"+"datatranspserv").html(outLogT);
			      	         	} else {
			      	         		$("#"+"datatranspserv").html(out11);
			      	         	}
			      	         	registerEditDealerVehicletranspModal();
											});
				    	
				    	
	}
	
	// modal for cartransp
	

	function registerEditDealerVehicletranspModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicletranspModal = '<div class="modal fade" id="editDealerVehicletranspModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Transport Lead Details</center></h4>\
			        <form id="edit-dealer-vehicle-transp-content-form">\
					<div class="modal-body edit-dealer-vehicle-transp-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicletranspModal);


		$('a.anchor-editDealerVehicletranspModal').on('click', function(event) {


			var data = $(event.target).data('details');
			var quotIdHiddenField = '<input type="hidden" name="searchTranspId" value="' + data.searchTranspId + '" />';
			// start
			var appId = '249863545451459';
		    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
		      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
		      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
		      AWS.config.region = 'us-east-1';
		      var bucket = new AWS.S3({
		          params: {
		              Bucket: bucketName
		          }
		      });
		     accessToken = $.jStorage.get("fbAToken");
		     bucket.config.credentials = new AWS.WebIdentityCredentials({
	                  ProviderId: 'graph.facebook.com',
	                  RoleArn: roleArn,
	                  WebIdentityToken: accessToken
	              });
			fbUserId = $.jStorage.get("fbKey");
			url1=" ";
			var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.uploadPhotos, Expires: 60};
	        bucket.getSignedUrl('getObject', params, function (err, url) {
	          if (url) { //alert("successfully retrieved 12.."+url);
	          url1=url;
	          var editDealerVehicletranspForm = '<form id="edit-dealer-vehicle-transp-content-form">\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<table>\
				<tr><td>Search ID</td><td>' + data.searchTranspId + '</td></tr>\
				<tr><td>' + quotIdHiddenField + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Looking To Move</div></div>\
				<tr><td>Type Of Vehicle</td><td>' + data.transTypeReq + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">From</div></div>\
				<tr><td>Post Code</td><td>' + data.fromPostCodeAddr + '</td></tr>\
				<tr><td>Street No</td><td>' + data.fromStreetNo + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.fromStreetName + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">To</div></div>\
				<tr><td>Post Code</td><td>' + data.toPostCodeAddr + '</td></tr>\
				<tr><td>Street No</td><td>' + data.toStreetNo + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.toStreetName + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Transport Stuff</div></div>\
				<tr><td>When do You want THIS to be picked up & delivered?</td><td>' + data.pickUpDateTime + '</td></tr>\
				<tr><td>What kin of transport You need?</td><td>' + data.toStreetName + '</td></tr>\
				<tr><td>I am Flexible</td><td>' + data.flexWithDateDefault + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Stuff</div></div>\
				<table>\
				<h6 style="color:#bd191e;"><b>Car Registration</b></h6>\
				<tr><td>Rego No</td><td>' + data.regoNo + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Vehicle Details</b></h6>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
				<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
				<tr><td>Free Text</td><td>' + data.freeText + '</td></tr>\
				</table>\
				</form>';
			editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>null</g, ">--NA--<");
			editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-transp-content").html(editDealerVehicletranspForm);
	          }
	          else{
	        	  alert("not able to retrieve photo for Transport Service with error However you can view the other details"+err);

	          //alert("successfully retrieved 12.."+url);

	          var editDealerVehicletranspForm = '<form id="edit-dealer-vehicle-transp-content-form">\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<table>\
				<tr><td>Search ID</td><td>' + data.searchTranspId + '</td></tr>\
				<tr><td>' + quotIdHiddenField + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Looking To Move</div></div>\
				<tr><td>Type Of Vehicle</td><td>' + data.transTypeReq + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">From</div></div>\
				<tr><td>Post Code</td><td>' + data.fromPostCodeAddr + '</td></tr>\
				<tr><td>Street No</td><td>' + data.fromStreetNo + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.fromStreetName + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">To</div></div>\
				<tr><td>Post Code</td><td>' + data.toPostCodeAddr + '</td></tr>\
				<tr><td>Street No</td><td>' + data.toStreetNo + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.toStreetName + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Transport Stuff</div></div>\
				<tr><td>When do You want THIS to be picked up & delivered?</td><td>' + data.pickUpDateTime + '</td></tr>\
				<tr><td>What kin of transport You need?</td><td>' + data.toStreetName + '</td></tr>\
				<tr><td>I am Flexible</td><td>' + data.flexWithDateDefault + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Stuff</div></div>\
				<table>\
				<h6 style="color:#bd191e;"><b>Car Registration</b></h6>\
				<tr><td>Rego No</td><td>' + data.regoNo + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Vehicle Details</b></h6>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
				<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
				<tr><td>Free Text</td><td>' + data.freeText + '</td></tr>\
				</table>\
				</form>';
			editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>null</g, ">--NA--<");
			editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-transp-content").html(editDealerVehicletranspForm);
	          }
	        });
			//alert("url1 new changes"+url1);

			//end
		});


		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	
	
	
	// modal for carservmaintEbid
	
	
	function registerEditDealerVehicleservmaintModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Service Maintainence Details</center></h4>\
			        <form id="edit-dealer-vehicle-servmaint-content-form">\
					<div class="modal-body edit-dealer-vehicle-servmaint-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleservmaintModal);


		$('a.anchor-editDealerVehicleservmaintModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);

			var quotIdHiddenField = '<input type="hidden" name="servMaintId" value="' + data.searchServMaintId + '" />';
			var appId = '249863545451459';
		    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
		      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
		      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
		      AWS.config.region = 'us-east-1';
		      var bucket = new AWS.S3({
		          params: {
		              Bucket: bucketName
		          }
		      });
		     accessToken = $.jStorage.get("fbAToken");
		     bucket.config.credentials = new AWS.WebIdentityCredentials({
	                  ProviderId: 'graph.facebook.com',
	                  RoleArn: roleArn,
	                  WebIdentityToken: accessToken
	              });
		     fbUserId = $.jStorage.get("fbKey");
		     url1=" ";
		     var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.uploadPhotos, Expires: 60};
		     bucket.getSignedUrl('getObject', params, function (err, url) {
	          if (url) {
	          url1=url;
	          var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<table>\
				<tr><td>Search ID</td><td>' + data.searchServMaintId + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">I am Looking For</div></div>\
				<tr><td>Service</td><td>' + data.lookService + '</td></tr>\
				<tr><td>Service & Maintenance Level 1</td><td>' + data.servMaintL1 + '</td></tr>\
				<tr><td>Service & Maintenance Level 2</td><td>' + data.servMaintL2 + '</td></tr>\
				<tr><td>Add Notes</td><td>' + data.freeText + '</td></tr>\
				</table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
				<table>\
				<br/>\
				<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
				<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
				<tr><td>Fuel Type</td><td>' + data.feulType + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">is the Car covered under Insurance</div></div>\
				<table>\
				<tr><td>Covered Under Insurance</td><td>' + data.coveredUnderIns + '</td></tr>\
				<tr><td>Current Insurance Provider</td><td>' + data.curInsProv + '</td></tr>\
				</table></form>';
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-servmaint-content").html(editDealerVehicleservmaintForm);
	          }
	          else{
	        	  alert("not able to retrieve photo for serv and Maint however you an view other details"+err);
	          //alert("successfully retrieved 12.."+url);

	          var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				<table>\
				<tr><td>Search ID</td><td>' + data.searchServMaintId + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">I am Looking For</div></div>\
				<tr><td>Service</td><td>' + data.lookService + '</td></tr>\
				<tr><td>Service & Maintenance Level 1</td><td>' + data.servMaintL1 + '</td></tr>\
				<tr><td>Service & Maintenance Level 2</td><td>' + data.servMaintL2 + '</td></tr>\
				<tr><td>Add Notes</td><td>' + data.freeText + '</td></tr>\
				</table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
				<table>\
				<br/>\
				<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
				<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
				<tr><td>Fuel Type</td><td>' + data.feulType + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">is the Car covered under Insurance</div></div>\
				<table>\
				<tr><td>Covered Under Insurance</td><td>' + data.coveredUnderIns + '</td></tr>\
				<tr><td>Current Insurance Provider</td><td>' + data.curInsProv + '</td></tr>\
				</table></form>';
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-servmaint-content").html(editDealerVehicleservmaintForm);

	          }
	        });
		});


		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	// Modal for CarInsuranceEbid
	function registerEditDealerVehicleInsuranceModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicleInsuranceModal = '<div class="modal fade" id="editDealerVehicleInsuranceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Insurance Details</center></h4>\
			        <form id="edit-dealer-vehicle-insurance-content-form">\
					<div class="modal-body edit-dealer-vehicle-insurance-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
					</div>\
		            </form>\
		        	<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleInsuranceModal);


		$('a.anchor-editDealerVehicleInsuranceModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);
			//console.log(JSON.stringify(data));
			outInsDrvAdd = "";
		    var drvAddInfo = data.searchInsAdditionalDriv;
		    //alert("came here");
			if(drvAddInfo){
				 outInsDrvAdd += '<tr><th>'+"Additional ID"+'</th><th>'+"First Name"+'</th><th>'+"Last Name"+'</th><th>'+"License Type"+'</th><th>'+'</th><th>'+"DateOfBirth"+'</th></tr>';
				 for(i=0;i<data.searchInsAdditionalDriv.length;i++)
					{
					 outInsDrvAdd= outInsDrvAdd+'<tr>'+'<td>'+data.searchInsAdditionalDriv[i].searchInsAddDrivId+'</td><td>'+data.searchInsAdditionalDriv[i].firstName+'</td><td>'+data.searchInsAdditionalDriv[i].lastName+'</td><td>'+data.searchInsAdditionalDriv[i].drivingLicenseType+'</td><td>'+data.searchInsAdditionalDriv[i].dateOfBirth+'</td><td></tr>';
					}

			}
			else
		    {
		    	outInsDrvAdd='<h2>No records for Dealer Search Finance</h2>';
		    }
			//alert("inside"+outInsDrvAdd);
			var quotIdHiddenField = '<input type="hidden" name="financeSearchId" value="' + data.searchInsuranceId + '" />';
			var moveToUser = '<input type="checkbox" name="moveToUser" />';
			if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

			// start of Extra Requirements
			var extExt1 = '<input type="checkbox" name="extExt1" />';
			if(data.extExt1)
				extExt1 = '<input type="checkbox" name="extExt1" checked="checked" />';
			var intExt2 = '<input type="checkbox" name="intExt2" />';
			if(data.intExt2)
				intExt2 = '<input type="checkbox" name="intExt2" checked="checked" />';
			var extExt2 = '<input type="checkbox" name="extExt2" />';
			if(data.extExt2)
				extExt2 = '<input type="checkbox" name="extExt2" checked="checked" />';
			var intExt3 = '<input type="checkbox" name="intExt3" />';
			if(data.intExt3)
				intExt3 = '<input type="checkbox" name="intExt3" checked="checked" />';
			var extExt3 = '<input type="checkbox" name="extExt3" />';
			if(data.extExt3)
				extExt3 = '<input type="checkbox" name="extExt3" checked="checked" />';
			var intExt4 = '<input type="checkbox" name="intExt4" />';
			if(data.intExt4)
				intExt4 = '<input type="checkbox" name="intExt4" checked="checked" />';
			var extExt4 = '<input type="checkbox" name="extExt4" />';
			if(data.extExt4)
				extExt4 = '<input type="checkbox" name="extExt4" checked="checked" />';
			var intExt5 = '<input type="checkbox" name="intExt5" />';
			if(data.intExt5)
				intExt5 = '<input type="checkbox" name="intExt5" checked="checked" />';
			var extExt5 = '<input type="checkbox" name="extExt5" />';
			if(data.extExt5)
				extExt5 = '<input type="checkbox" name="extExt5" checked="checked" />';
			var intExt6 = '<input type="checkbox" name="intExt6" />';
			if(data.intExt6)
				intExt6 = '<input type="checkbox" name="intExt6" checked="checked" />';
			var intExt1 = '<input type="checkbox" name="intExt1" />';
			if(data.intExt1)
				intExt1 = '<input type="checkbox" name="intExt1" checked="checked" />';
			var intExt7 = '<input type="checkbox" name="intExt7" />';
			if(data.intExt7)
				intExt7 = '<input type="checkbox" name="intExt7" checked="checked" />';
			var intExt8 = '<input type="checkbox" name="intExt8" />';
			if(data.intExt8)
				intExt8 = '<input type="checkbox" name="intExt8" checked="checked" />';
			// end of Extra Requirements


			var editDealerVehicleInsuranceForm = '<form id="edit-dealer-vehicle-insurance-content-form"><table>\
				<tr><td>Search ID</td><td>' + data.searchInsuranceId + '</td></tr>\
				</table>\
				<h4>Car Details</h4>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Registration</div></div>\
				<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Vehicle Details</b></h6>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model</td><td>' + data.model + '</td></tr>\
				<tr><td>Autoscoop Trim</td><td>' + data.autoscoopTrim + '</td></tr>\
				<tr><td>Average No of Kms</td><td>' + data.avgNoOfKmYr + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Is the Car is Under Finance ?</b></h6>\
				<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
				<tr><td>Finance Provider</td><td>' + data.financeProvider + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Car Parked At Address</b></h6>\
				<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
				<tr><td>Where car Parked?</td><td>' + data.carParkedAt + '</td></tr>\
				<tr><td>Unit/StreetNo </td><td>' + data.streetNO + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.streetName + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Car is Used for</b></h6>\
				<tr><td>Purpose</td><td>' + data.carUsedfor + '</td></tr>\
				<tr><td>Type of Business</td><td>' + data.typeOfBusiness + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Coverage Details</div></div>\
				<table>\
				<tr><td>Type of Coverage</td><td>' + data.insuranceType + '</td></tr>\
				</table>\
				<br/>\
				<h6 style="color:#bd191e;"><b>Agreed Value of Car</b></h6>\
				<table>\
				<tr><td>Agreed Value</td><td>' + data.agreedValue + '</td></tr>\
				<tr><td>Market Value</td><td>' + data.marketValue + '</td></tr>\
				</table>\
				<table>\
				<tr><td>Preferred Excess Amount</td><td>' + data.prefExcessAmount + '</td></tr>\
				<tr><td>Current Insurer</td><td>' + data.curInsProv + '</td></tr>\
				</table>\
				<br/>\
				<h5 style="color:#bd191e;"><b>Add Extra Requirements</b></h5>\
				<table>\
				<h6 style="color:#bd191e;"><b>External Requirements</b></h6>\
				<tr><td>Hire Car after Accident(ifany)</td><td>' + extExt1 +'</td><td>No Claim Bonus Protection</td><td>' + intExt2 + '</td></tr>\
				<tr><td>Excess Free Wind Screen</td><td>' + extExt2 +'</td><td>Allow Under 25 Driver</td><td>' + intExt3 + '</td></tr>\
				<tr><td>Excess Free Window Screen</td><td>' + extExt3 +'</td><td>Cover Theft & Fire</td><td>' + intExt4 + '</td></tr>\
				<tr><td>New Car Replace</td><td>' + extExt4 +'</td><td>Cover Towing Cost</td><td>' + intExt5 + '</td></tr>\
				<tr><td>Road Side Assitance</td><td>' + extExt5 +'</td><td>Essential Temporary Repairs</td><td>' + intExt6 + '</td></tr>\
				<tr><td>Life time Warrantly repairs</td><td>' + intExt1 +'</td><td>Accidental Damage</td><td>' + intExt7 + '</td></tr>\
				<tr><td>Emergency Accomdation and Transport</td><td>' + intExt8 + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Driver Details</div></div>\
				<table>\
				<tr><td>First Name</td><td>' + data.driverFirstName + '</td></tr>\
				<tr><td>Last Name</td><td>' + data.driverLastName + '</td></tr>\
				<tr><td>Mobile</td><td>' + data.driverMobileNo + '</td></tr>\
				<tr><td>Email</td><td>' + data.driverEmailId + '</td></tr>\
				<tr><td>Date Of Birth</td><td>' + data.dateOfBirth + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Driving Licence Details</b></h6>\
				<tr><td>Driving License Type</td><td>' + data.drivingLicenseType + '</td></tr>\
				<tr><td>Driving License No</td><td>' + data.drivingLicenseNo + '</td></tr>\
				<tr><td>Driving License Issue Date</td><td>' + data.licenseIssueDate + '</td></tr>\
				<tr><td>Driving License Issue State</td><td>' + data.drivingLicenseIssueState + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<h6 style="color:#bd191e;"><b>Drivers Claim History</b></h6>\
				<tr><td>No Of AtFaults</td><td>' + data.noOfAtFaults + '</td></tr>\
				<tr><td>Last AtFault Claim Date</td><td>' + data.lastAtFaultClaimDate + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Additional Driver Details</div></div>\
				<table>\
				<tr><td>No Of Drivers more than 1 ?</td><td>' + data.noOfDrivers + '</td></tr>\
				</table>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Additional Driver Information</div></div>\
				<tr><td></td><td>' +outInsDrvAdd + '</td></tr>\
				</table>\
				</form>';
			editDealerVehicleInsuranceForm = editDealerVehicleInsuranceForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleInsuranceForm = editDealerVehicleInsuranceForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-insurance-content").html(editDealerVehicleInsuranceForm);
		});


		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}

	
	// Modal for CarFinanceEbid
	
	function registerEditDealerVehicleFinanceModal(){
		var editDealerVehicleFinanceModal = '<div class="modal fade" id="editDealerVehicleFinanceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Finance Details</center></h4>\
			        <form id="edit-dealer-vehicle-finance-content-form">\
					<div class="modal-body edit-dealer-vehicle-finance-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
					</div>\
		            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleFinanceModal);


		$('a.anchor-editDealerVehicleFinanceModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);

			var quotIdHiddenField = '<input type="hidden" name="financeSearchId" value="' + data.searchFinanceId + '" />';
			var moveToUser = '<input type="checkbox" name="moveToUser" />';
			if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';



			var editDealerVehicleFinanceForm = '<form id="edit-dealer-vehicle-finance-content-form"><table>\
				<tr><td>Search Reference ID</td><td>' + data.searchFinanceId + '</td></tr>\
				</table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Registration</div></div>\
				<table>\
				<tr><td>Rego No</td><td>' + data.rego + '</td></tr>\
				<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Details</div></div>\
				<table>\
				<tr><td>Year</td><td>' + data.year + '</td></tr>\
				<tr><td>Make</td><td>' + data.make + '</td></tr>\
				<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
				<tr><td>Autoscoop Trim</td><td>' + data.autoscoopTrim + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Where Do You Live ?	</div></div>\
				<table>\
				<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
				<tr><td>Street No</td><td>' + data.streetNo + '</td></tr>\
				<tr><td>Street Name</td><td>' + data.streetName + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">How much Loan your Looking?</div></div>\
				<table>\
				<tr><td>Loan Amount</td><td>' + data.loanAmount + '</td></tr>\
				<tr><td>Loan Period</td><td>' + data.loanPeriod + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Tell Us About Yourself</div></div>\
				<table>\
				<tr><td>Title</td><td>' + data.mr + '</td></tr>\
				<tr><td>First Name</td><td>' + data.firstName + '</td></tr>\
				<tr><td>Last Name</td><td>' + data.lastName + '</td></tr>\
				<tr><td>Date of Birth</td><td>' + data.dateOfBirth + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Your Income Details</div></div>\
				<table>\
				<tr><td>Income Type</td><td>' + data.incomeType + '</td></tr>\
				<tr><td>Annual Income</td><td>' + data.annualIncome + '</td></tr>\
				<tr><td>Years of Employment Business</td><td>' + data.yearEmploymentBusiness + '</td></tr>\
				</table>\
				<br/>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">My Credit Rating</div></div>\
				<table>\
				<tr><td>Credit Rating</td><td>' + data.creditRating + '</td></tr>\
				</table>\
				<br/>\
				</form>';
			editDealerVehicleFinanceForm = editDealerVehicleFinanceForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleFinanceForm = editDealerVehicleFinanceForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-finance-content").html(editDealerVehicleFinanceForm);
		});


		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	
	
	//Modal for CarSEarchEbid
	
	function registerEditDealerVehicleSearchModal(){


		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
		var editDealerVehicleSearchModal = '<div class="modal fade" id="editDealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
		    <div class="modal-dialog">\
		        <div class="modal-content">\
		            <div class="modal-header">\
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
		            </div>\
					<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Search Details</center></h4>\
			        <form id="edit-dealer-vehicle-search-content-form">\
					<div class="modal-body edit-dealer-vehicle-search-content">\
		            </div>\
		            <div class="modal-footer">\
		                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
			<p><center>&copy; 2017 Autoscoop</center></p>\
				</div>\
		            </form>\
		        </div>\
		    </div>\
		</div>';

		$(document.body).append(editDealerVehicleSearchModal);


		$('a.anchor-editDealerVehicleSearchModal').on('click', function(event) {


			var data = $(event.target).data('details');
			//var json = JSON.stringify(data);

			var quotIdHiddenField = '<input type="hidden" name="carSearchId" value="' + data.carSearchId + '" />';
			var moveToUser = '<input type="checkbox" name="moveToUser" />';
			var shortList = '<input type="checkbox" name="shortList" />';
			var makeOffer = '<input type="checkbox" name="makeOffer" />';
			var makeDeposit = '<input type="checkbox" name="makeDeposit" />';
			var chat = '<input type="checkbox" name="chat" />';
			var rejectIt = '<input type="checkbox" name="rejectIt" />';
			var postCode = '<input type="text" name="postCode" />';
			var mr = '<input type="text" name="mr" />';
			var lastName = '<input type="text" name="lastName" />';
			var firstName = '<input type="text" name="firstName" />';
			var address = '<input type="text" name="address" />';
			var mobileNo = '<input type="text" name="mobileNo" />';
			var preferredDate = '<input type="date" name="preferredDate" />';


			if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';



			//alert(JSON.stringify(data)); to work
			var editDealerVehicleSearchForm = '<form id="edit-dealer-vehicle-search-content-form"><table>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Car Details</div></div>\
				<tr><td>Search ID</td><td>' + data.carSearchId + '</td></tr>\
				<tr><td>' + quotIdHiddenField + '</td></tr>\
				<tr><td>New</td><td>' + moveToUser + '</td></tr>\
				<tr><td>Used</td><td>' + moveToUser1 + '</td></tr>\
				<tr><td>Year</td><td>' + data.modelYear + '</td></tr>\
				<tr><td>Make</td><td>' + data.modelDisplay + '</td></tr>\
				<tr><td>Model</td><td>' + data.modelName + '</td></tr>\
				<tr><td>AutoScoop Trim</td><td>' + data.modelTrim + '</td></tr>\
				<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
				<tr><td>Insurance</td><td>' + data.insurance + '</td></tr>\
				<tr><td>PostCode</td><td>' + data.postCode + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Pick your Fav Color</div></div>\
				<tr><td>Car Color 1</td><td>' + data.carColor + '</td></tr>\
				<tr><td>Car Color 2</td><td>' + data.sModel + '</td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">You can add your preferred extras</div></div>\
				<tr><td></td></tr>\
				</table>\
				<br/>\
				<table>\
				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">You can tell More about your requirements</div></div>\
				<tr><td>' + data.state + '</td></tr>\
				</table>\
				<br/>\
				</table></form>';
			editDealerVehicleSearchForm = editDealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleSearchForm = editDealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-search-content").html(editDealerVehicleSearchForm);
		});
		$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

			var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


			$.ajax({
				type: "POST",
				url: "api/vehicleSearchQuotation?_method=PUT",
				data: jsonInput,
				contentType:'application/json',
				success: function(result){
					$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
					alert("Successfully upated the Quotations");
					//alert("will call update");
					carCarQuotation();

				}
			});


		});

		$.fn.convertFormDataToJSON = function(){
			var checkboxes = [];
			$(this).find('input:checkbox:checked').each(function(){
				checkboxes.push($(this).attr("name"));
			});
			var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] != undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            if($.inArray(this.name, checkboxes) != -1)
		              o[this.name].push('true' || '');
		            else
		            	o[this.name].push(this.value || '');
		        } else {
		        	if($.inArray(this.name, checkboxes) != -1)
		        		o[this.name] = 'true' || '';
			        else
			           	o[this.name] = this.value || '';
		        }
		    });
		    return JSON.stringify(o);
		}


	}
	
		
	
	
	
	
	
	
	$scope.vehicleRetrievalforLogBook = function() {
						//alert("inside ne method");
						var wsURL = 'api/Myvehicle/'+myVehicleIDuse;
						$.ajax({
							type: "GET",
							url: wsURL,
							contentType:'application/json',
							success: function(result){
								var LogT = result.myVehicleLogBook;
								outLogT="";
								if(LogT && result.myVehicleLogBook.length!=0)
									{
									logTlen = result.myVehicleLogBook.length;
									outLogT += '<tr><th>'+"Trip Type"+'</th><th>'+"Trip Desc"+'</th><th>'+"TripStart Date"+'</th><th>'+"Start Post"+'</th><th>'+"Start address"+'</th><th>'+"Start OdoMeter Reading"+'</th><th>'+"Trip End Date"+'</th><th>'+"End Post"+'</th><th>'+"End Address"+'</th><th>'+"End ODOmeter Reading"+'</th><th>'+'View/Update'+'</th></tr>';
					           	    for(i=0;i<logTlen;i++)
					          		 {
					           	    	outLogT= outLogT+'<tr>'+'<td>'+result.myVehicleLogBook[i].tripType+'</td>'+'<td>'+result.myVehicleLogBook[i].tripDescription+'</td>'+'<td>'+result.myVehicleLogBook[i].flex8+'</td>'+'<td>'+result.myVehicleLogBook[i].fromLocation+'</td>'+'<td>'+result.myVehicleLogBook[i].flex1+'</td>'
					           	    	+'<td>'+result.myVehicleLogBook[i].odoMeterStartOfTrip+'</td>'+'<td>'+result.myVehicleLogBook[i].flex9+'</td>'+'<td>'+result.myVehicleLogBook[i].toLocation+'</td>'+'<td>'+result.myVehicleLogBook[i].flex2+'</td>'+'<td>'+result.myVehicleLogBook[i].odoMeterEndOfTrip+'</td>'+'<td><a href="#" id="anchor-editDealerVehiclelogbkModal-' + result.myVehicleLogBook[i].myVehicleLogBookId + '" data-details=\'' + JSON.stringify(result.myVehicleLogBook[i]) + '\' class="anchor-editDealerVehiclelogbkModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehiclelogbkModal">View</a></td></tr>';;
					          		 }
					           	    outLogT = outLogT.replace(/>null</g, ">--NA--<");
					           	    outLogT = outLogT.replace(/>undefined</g, ">--NA--<");
									}
								else
									{
									outLogT='<h2>No records for Log Trips</h2>';
									}
								$('#logTripTable').html(outLogT);//Log Trip Start//Log Trip End
								// end of LogBook
								//Log Trip Start

								registerEditDealerVehiclelogbkModal();
								// start of LogBook
								function registerEditDealerVehiclelogbkModal(){
									//Add a Bootstrap Modal DIV to vehicle logbk Details
									var editDealerVehiclelogbkModal = '<div class="modal fade" id="editDealerVehiclelogbkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
									            </div>\
												<h4 class="modal-title" id="myModalLabel"><center>View Log Expenses Details</center></h4>\
										        <form id="edit-dealer-vehicle-logbk-content-form">\
												<div class="modal-body edit-dealer-vehicle-logbk-content">\
									            </div>\
									            <div class="modal-footer">\
									                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
										<button type="button" class="btn btn-primary submit-editDealerVehiclelogbkModal" data-dismiss="modal">Save changes</button>\
												</div>\
									            </form>\
									        	<p><center>&copy; 2017 Autoscoop</center></p>\
									        </div>\
									    </div>\
									</div>';

									$(document.body).append(editDealerVehiclelogbkModal);


									$('a.anchor-editDealerVehiclelogbkModal').on('click', function(event) {


										var data = $(event.target).data('details');
										var quotIdHiddenField = '<input type="hidden" name="myVehicleLogBookId" value="' + data.myVehicleLogBookId + '" />';
										var editDealerVehiclelogbkForm = '<form id="edit-dealer-vehicle-logbk-content-form"><table>\
								        	 	<tr><td>Log Book ID</td><td> <input type="hidden" name="myVehicleLogBookId" class="input-text full-width" value="' + data.myVehicleLogBookId + '"/></td></tr>\
												</table>\
												<table>\
												<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Book Details</div></div>\
												<tr><td>Trip Type</td><td> <input type="text" name="tripType" class="input-text full-width" value="' + data.tripType + '"/></td></tr>\
												<tr><td>Trip Desc </td><td> <input type="text" name="tripDescription" class="input-text full-width" value="' + data.tripDescription + '"/></td></tr>\
												<tr><td>TripStart Date </td><td> <input type="text" onfocus="(this.type=\'date\')" name="flex8" class="input-text full-width" value="' + data.flex8 + '"/></td></tr>\
												<tr><td>Start Post </td><td> <input type="text" name="fromLocation" class="input-text full-width" value="' + data.fromLocation + '"/></td></tr>\
												<tr><td>Start address</td><td> <input type="text" name="flex1" class="input-text full-width" value="' + data.flex1 + '"/></td></tr>\
												<tr><td>Start OdoMeter Reading</td><td> <input type="text" name="odoMeterStartOfTrip" class="input-text full-width" value="' + data.odoMeterStartOfTrip + '"/></td></tr>\
												<tr><td>Trip End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="flex9" class="input-text full-width" value="' + data.flex9 + '"/></td></tr>\
												<tr><td>End Post</td><td> <input type="text" name="toLocation" class="input-text full-width" value="' + data.toLocation + '"/></td></tr>\
												<tr><td>End Address</td><td> <input type="text" name="flex2" class="input-text full-width" value="' + data.flex2 + '"/></td></tr>\
												<tr><td>End ODOmeter Reading</td><td> <input type="text" name="odoMeterEndOfTrip" class="input-text full-width" value="' + data.odoMeterEndOfTrip + '"/></td></tr>\
												<tr><td>Trip Notes</td><td> <input type="text" name="flex4" class="input-text full-width" value="' + data.flex4 + '"/></td></tr>\
												<tr><td>Trip Kms</td><td> <input type="text" name="routeKm" class="input-text full-width" value="' + data.routeKm + '"/></td></tr>\
												<tr><td>Driver License</td><td> <input type="text" name="flex3" class="input-text full-width" value="' + data.flex3 + '"/></td></tr>\
												</table>\
												</form>';
											editDealerVehiclelogbkForm = editDealerVehiclelogbkForm.replace(/>null</g, ">--NA--<");
											editDealerVehiclelogbkForm = editDealerVehiclelogbkForm.replace(/>undefined</g, ">--NA--<");
											$(".edit-dealer-vehicle-logbk-content").html(editDealerVehiclelogbkForm);
									});

									$('button.submit-editDealerVehiclelogbkModal').on('click', function(e) {

										var jsonInput = $("#edit-dealer-vehicle-logbk-content-form").convertFormDataToJSON();


										$.ajax({
											type: "POST",
											url: "api/myvehicleLogBookUpdate?_method=PUT",
											data: jsonInput,
											contentType:'application/json',
											success: function(result){
												$("#anchor-editDealerVehiclelogbkModal-" + result.myVehicleLogBookId).data('details', result);
												alert("Successfully upated the Logbook..");
												angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();

											}
										});


									});

									$.fn.convertFormDataToJSON = function(){
										var checkboxes = [];
										$(this).find('input:checkbox:checked').each(function(){
											checkboxes.push($(this).attr("name"));
										});
										var o = {};
									    var a = this.serializeArray();
									    $.each(a, function() {
									        if (o[this.name] != undefined) {
									            if (!o[this.name].push) {
									                o[this.name] = [o[this.name]];
									            }
									            if($.inArray(this.name, checkboxes) != -1)
									              o[this.name].push('true' || '');
									            else
									            	o[this.name].push(this.value || '');
									        } else {
									        	if($.inArray(this.name, checkboxes) != -1)
									        		o[this.name] = 'true' || '';
										        else
										           	o[this.name] = this.value || '';
									        }
									    });
									    return JSON.stringify(o);
									}


								}
								// Log Trip End

								
								var LogE = result.myVehicleFuelExpenses;
								outLogE="";
								if(LogE && result.myVehicleFuelExpenses.length!=0)
								{
									logElen = result.myVehicleFuelExpenses.length;

									outLogE += '<tr><th>'+"Expensive Type"+'</th><th>'+"Expensive Category"+'</th><th>'+"Expensive Date"+'</th><th>'+"Expensive Description"+'</th><th>'+"Amount"+'</th><th>'+"Operation"+'</th></tr>';
					           	    for(i=0;i<logElen;i++)
					          		 {
					           	    	outLogE= outLogE+'<tr>'+'<td>'+result.myVehicleFuelExpenses[i].recordType+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].business+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].date+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].others+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].amount+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleexpnsModal-' + result.myVehicleFuelExpenses[i].myVehicleFuelExpensesId + '" data-details=\'' + JSON.stringify(result.myVehicleFuelExpenses[i]) + '\' class="anchor-editDealerVehicleexpnsModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleexpnsModal">View</a></td></tr>';
					          		 }
					           	    outLogE = outLogE.replace(/>null</g, ">--NA--<");
					           	    outLogE = outLogE.replace(/>undefined</g, ">--NA--<");

								}
								else
								{
									outLogE='<h2>No records for log Expenses</h2>';
								}
								$('#logExpTable').html(outLogE);//Log Expense Start ///Log Expense end 
								//Log Expense Start
								

								registerEditDealerVehicleexpnsModal();
								// start of logexpenses
								function registerEditDealerVehicleexpnsModal(){
									//Add a Bootstrap Modal DIV to vehicle expns Details
									var editDealerVehicleexpnsModal = '<div class="modal fade" id="editDealerVehicleexpnsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
									            </div>\
												<h4 class="modal-title" id="myModalLabel"><center>View Log Expenses Details</center></h4>\
										        <form id="edit-dealer-vehicle-expns-content-form">\
												<div class="modal-body edit-dealer-vehicle-expns-content">\
									            </div>\
									            <div class="modal-footer">\
									                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
										<button type="button" class="btn btn-primary submit-editDealerVehicleexpnsModal" data-dismiss="modal">Save changes</button>\
												</div>\
									            </form>\
									        	<p><center>&copy; 2017 Autoscoop</center></p>\
									        </div>\
									    </div>\
									</div>';

									$(document.body).append(editDealerVehicleexpnsModal);


									$('a.anchor-editDealerVehicleexpnsModal').on('click', function(event) {


										var data = $(event.target).data('details');
										var quotIdHiddenField = '<input type="hidden" name="myVehicleFuelExpensesId" value="' + data.myVehicleFuelExpensesId + '" />';
										// start
										var appId = '249863545451459';
									    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
									      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
									      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
									      AWS.config.region = 'us-east-1';
									      var bucket = new AWS.S3({
									          params: {
									              Bucket: bucketName
									          }
									      });
									     accessToken = $.jStorage.get("fbAToken");
									     bucket.config.credentials = new AWS.WebIdentityCredentials({
								                  ProviderId: 'graph.facebook.com',
								                  RoleArn: roleArn,
								                  WebIdentityToken: accessToken
								              });
									          fbUserId = $.jStorage.get("fbKey");
										url1=" ";
										var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photoOfInvoice, Expires: 60};
								        bucket.getSignedUrl('getObject', params, function (err, url) {
								          if (url) {
								          url1=url;
								          var editDealerVehicleexpnsForm = '<form id="edit-dealer-vehicle-expns-content-form"><table>\
								        	  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
												<tr><td>Log Expense ID</td><td> <input type="hidden" name="myVehicleFuelExpensesId" class="input-text full-width" value="' + data.myVehicleFuelExpensesId + '"/></td></tr>\
												</table>\
												<table>\
												<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Expense Details</div></div>\
												<tr><td>Expensive Type</td><td> <input type="text" name="recordType" class="input-text full-width" value="' + data.recordType + '"/></td></tr>\
												<tr><td>Expensive Category</td><td> <input type="text" name="business" class="input-text full-width" value="' + data.business + '"/></td></tr>\
												<tr><td>Expensive Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="date" class="input-text full-width" value="' + data.date + '"/></td></tr>\
												<tr><td>Expensive Description</td><td> <input type="text" name="others" class="input-text full-width" value="' + data.others + '"/></td></tr>\
												<tr><td>Amount</td><td> <input type="text" name="amount" class="input-text full-width" value="' + data.amount + '"/></td></tr>\
												</table>\
												</form>';
											editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>null</g, ">--NA--<");
											editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>undefined</g, ">--NA--<");
											$(".edit-dealer-vehicle-expns-content").html(editDealerVehicleexpnsForm);

								          }
								          else{
								        	  alert("not able to retrieve photo for Log expenses, However you can view other details"+err);
								          //alert("successfully retrieved 12.."+url);

								          var editDealerVehicleexpnsForm = '<form id="edit-dealer-vehicle-expns-content-form"><table>\
								        	  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
								        	  <tr><td>Log Expense ID</td><td> <input type="hidden" name="myVehicleFuelExpensesId" class="input-text full-width" value="' + data.myVehicleFuelExpensesId + '"/></td></tr>\
												</table>\
												<table>\
												<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Expense Details</div></div>\
												<tr><td>Expensive Type</td><td> <input type="text" name="recordType" class="input-text full-width" value="' + data.recordType + '"/></td></tr>\
												<tr><td>Expensive Category</td><td> <input type="text" name="business" class="input-text full-width" value="' + data.business + '"/></td></tr>\
												<tr><td>Expensive Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="date" class="input-text full-width" value="' + data.date + '"/></td></tr>\
												<tr><td>Expensive Description</td><td> <input type="text" name="others" class="input-text full-width" value="' + data.others + '"/></td></tr>\
												<tr><td>Amount</td><td> <input type="text" name="amount" class="input-text full-width" value="' + data.amount + '"/></td></tr>\
												</table>\
												</form>';
											editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>null</g, ">--NA--<");
											editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>undefined</g, ">--NA--<");
											$(".edit-dealer-vehicle-expns-content").html(editDealerVehicleexpnsForm);


								          }});
									});



									$('button.submit-editDealerVehicleexpnsModal').on('click', function(e) {

										var jsonInput = $("#edit-dealer-vehicle-expns-content-form").convertFormDataToJSON();


										$.ajax({
											type: "POST",
											url: "api/myvehicleLogExpensesUpdate?_method=PUT",
											data: jsonInput,
											contentType:'application/json',
											success: function(result){
												$("#anchor-editDealerVehicleexpnsModal-" + result.myVehicleFuelExpensesId).data('details', result);
												alert("Successfully upated the fuel expenses");
												angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();
											}
										});


									});
									$.fn.convertFormDataToJSON = function(){
										var checkboxes = [];
										$(this).find('input:checkbox:checked').each(function(){
											checkboxes.push($(this).attr("name"));
										});
										var o = {};
									    var a = this.serializeArray();
									    $.each(a, function() {
									        if (o[this.name] != undefined) {
									            if (!o[this.name].push) {
									                o[this.name] = [o[this.name]];
									            }
									            if($.inArray(this.name, checkboxes) != -1)
									              o[this.name].push('true' || '');
									            else
									            	o[this.name].push(this.value || '');
									        } else {
									        	if($.inArray(this.name, checkboxes) != -1)
									        		o[this.name] = 'true' || '';
										        else
										           	o[this.name] = this.value || '';
									        }
									    });
									    return JSON.stringify(o);
									}


								}
								//Loge Expense End
								
								//end of logexpenses
								
								var LogS = result.myVehicleServMaint;
								outLogS="";
								if(LogS && result.myVehicleServMaint.length!=0)
								{
									logSlen = result.myVehicleServMaint.length;
									outLogS += '<tr><th>'+"Type"+'</th><th>'+"Type of Service(L1)"+'</th><th>'+"Type of Service(L2)"+'</th><th>'+"Service@ Date"+'</th><th>'+"OdoMeter Reading Kms"+'</th><th>'+"Next S&M Date"+'</th><th>'+"Next S&M Date @ODO Meter Reading"+'</th><th>'+"Cost"+'</th><th>'+"Company Name"+'</th><th>'+"Operation"+'</th></tr>';

					           	    for(i=0;i<logSlen;i++)
					          		 {
					           	    	outLogS= outLogS+'<tr>'+'<td>'+result.myVehicleServMaint[i].typeOfServMaint+'</td>'+'<td>'+result.myVehicleServMaint[i].mechanicAddress+'</td>'+'<td>'+result.myVehicleServMaint[i].contactDetails+'</td>'+'<td>'+result.myVehicleServMaint[i].date+'</td>'+'<td>'+result.myVehicleServMaint[i].odoMeterKm+'</td>'+'<td>'+result.myVehicleServMaint[i].nextServDate+'</td><td>'+result.myVehicleServMaint[i].nextOdoMeterKm+'</td>'+'<td>'+result.myVehicleServMaint[i].totalAmount+'</td>'+result.myVehicleServMaint[i].mechanicName+'</td><td><a href="#" id="anchor-editDealerVehicleservmtModal-' + result.myVehicleServMaint[i].myVehicleServMaintId + '" data-details=\'' + JSON.stringify(result.myVehicleServMaint[i]) + '\' class="anchor-editDealerVehicleservmtModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmtModal">View</a></td></tr>';
					          		 }
					           	    outLogS = outLogS.replace(/>null</g, ">--NA--<");
					           	    outLogS = outLogS.replace(/>undefined</g, ">--NA--<");
								}
								else
								{
									outLogS='<h2>No records for Service maintenance</h2>';
								}
								$('#logServMainTable').html(outLogS);//Log Serv&Maint start//Log Serv&Maint end
								//Log Serv&maint Start
								

								registerEditDealerVehicleservmtModal();
								// start of logsermaint
								function registerEditDealerVehicleservmtModal(){
									//Add a Bootstrap Modal DIV to vehicle expns Details
									var editDealerVehicleservmtModal = '<div class="modal fade" id="editDealerVehicleservmtModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
									            </div>\
												<h4 class="modal-title" id="myModalLabel"><center>View Log Service Maintenance Details</center></h4>\
										        <form id="edit-dealer-vehicle-servmt-content-form">\
												<div class="modal-body edit-dealer-vehicle-servmt-content">\
									            </div>\
									            <div class="modal-footer">\
									                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
										<button type="button" class="btn btn-primary submit-editDealerVehicleservmtModal" data-dismiss="modal">Save changes</button>\
												</div>\
									            </form>\
									        	<p><center>&copy; 2017 Autoscoop</center></p>\
									        </div>\
									    </div>\
									</div>';

									$(document.body).append(editDealerVehicleservmtModal);


									$('a.anchor-editDealerVehicleservmtModal').on('click', function(event) {


										var data = $(event.target).data('details');
										var quotIdHiddenField = '<input type="hidden" name="myVehicleServMaintId" value="' + data.myVehicleServMaintId + '" />';
										// start
										var appId = '249863545451459';
									    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
									      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
									      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
									      AWS.config.region = 'us-east-1';
									      var bucket = new AWS.S3({
									          params: {
									              Bucket: bucketName
									          }
									      });
									     accessToken = $.jStorage.get("fbAToken");
												bucket.config.credentials = new AWS.WebIdentityCredentials({
										                  ProviderId: 'graph.facebook.com',
										                  RoleArn: roleArn,
										                  WebIdentityToken: accessToken
										              });
									          fbUserId = $.jStorage.get("fbKey");
										url1=" ";
										var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.uploadPhoto, Expires: 60};
								        bucket.getSignedUrl('getObject', params, function (err, url) {
								          if (url) {
								          url1=url;
								          var editDealerVehicleservmtForm = '<form id="edit-dealer-vehicle-servmt-content-form"><table>\
								        	  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
												<tr><td>Log Serv Maint ID</td><td> <input type="hidden" name="myVehicleServMaintId" class="input-text full-width" value="' + data.myVehicleServMaintId + '"/></td></tr>\
												</table>\
												<table>\
												<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Service Maintenance Details</div></div>\
												<tr><td>Type</td><td> <input type="text" name="typeOfServMaint" class="input-text full-width" value="' + data.typeOfServMaint + '"/></td></tr>\
												<tr><td>Type of Service(L1)</td><td> <input type="text" name="mechanicAddress" class="input-text full-width" value="' + data.mechanicAddress + '"/></td></tr>\
												<tr><td>Type of Service(L2)</td><td> <input type="text" name="contactDetails" class="input-text full-width" value="' + data.contactDetails + '"/></td></tr>\
												<tr><td>Service@ Date</td><td><input type="text" onfocus="(this.type=\'date\')" name="date" class="input-text full-width" value="' + data.date + '"/></td></tr>\
												<tr><td>OdoMeter Reading Kms</td><td> <input type="text" name="odoMeterKm" class="input-text full-width" value="' + data.odoMeterKm + '"/></td></tr>\
												<tr><td>Next S&M Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServDate" class="input-text full-width" value="' + data.nextServDate + '"/></td></tr>\
												<tr><td>Next S&M Date @ODO Meter Reading</td><td> <input type="text" name="nextOdoMeterKm" class="input-text full-width" value="' + data.nextOdoMeterKm + '"/></td></tr>\
												<tr><td>Cost</td><td> <input type="text" name="totalAmount" class="input-text full-width" value="' + data.totalAmount + '"/></td></tr>\
												<tr><td>Mechanic / Company Name</td><td> <input type="text" name="mechanicName" class="input-text full-width" value="' + data.mechanicName + '"/></td></tr>\
												</table>\
												</form>';
											editDealerVehicleservmtForm = editDealerVehicleservmtForm.replace(/>null</g, ">--NA--<");
											editDealerVehicleservmtForm = editDealerVehicleservmtForm.replace(/>undefined</g, ">--NA--<");
											$(".edit-dealer-vehicle-servmt-content").html(editDealerVehicleservmtForm);

								          }
								          else{alert("not able to retrieve photo for serv and maintenance, However you can view other details "+err)
								          url1=url;
								          var editDealerVehicleservmtForm = '<form id="edit-dealer-vehicle-servmt-content-form"><table>\
								        	  <ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
								        	  <tr><td>Log Serv Maint ID</td><td> <input type="hidden" name="myVehicleServMaintId" class="input-text full-width" value="' + data.myVehicleServMaintId + '"/></td></tr>\
												</table>\
												<table>\
												<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Service Maintenance Details</div></div>\
												<tr><td>Type</td><td> <input type="text" name="typeOfServMaint" class="input-text full-width" value="' + data.typeOfServMaint + '"/></td></tr>\
												<tr><td>Type of Service(L1)</td><td> <input type="text" name="mechanicAddress" class="input-text full-width" value="' + data.mechanicAddress + '"/></td></tr>\
												<tr><td>Type of Service(L2)</td><td> <input type="text" name="contactDetails" class="input-text full-width" value="' + data.contactDetails + '"/></td></tr>\
												<tr><td>Service@ Date</td><td><input type="text" onfocus="(this.type=\'date\')" name="date" class="input-text full-width" value="' + data.date + '"/></td></tr>\
												<tr><td>OdoMeter Reading Kms</td><td> <input type="text" name="odoMeterKm" class="input-text full-width" value="' + data.odoMeterKm + '"/></td></tr>\
												<tr><td>Next S&M Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServDate" class="input-text full-width" value="' + data.nextServDate + '"/></td></tr>\
												<tr><td>Next S&M Date @ODO Meter Reading</td><td> <input type="text" name="nextOdoMeterKm" class="input-text full-width" value="' + data.nextOdoMeterKm + '"/></td></tr>\
												<tr><td>Cost</td><td> <input type="text" name="totalAmount" class="input-text full-width" value="' + data.totalAmount + '"/></td></tr>\
												<tr><td>Mechanic / Company Name</td><td> <input type="text" name="mechanicName" class="input-text full-width" value="' + data.mechanicName + '"/></td></tr>\
												</table>\
												</form>';
											editDealerVehicleservmtForm = editDealerVehicleservmtForm.replace(/>null</g, ">--NA--<");
											editDealerVehicleservmtForm = editDealerVehicleservmtForm.replace(/>undefined</g, ">--NA--<");
											$(".edit-dealer-vehicle-servmt-content").html(editDealerVehicleservmtForm);


								          }});
									});
									$('button.submit-editDealerVehicleservmtModal').on('click', function(e) {

										var jsonInput = $("#edit-dealer-vehicle-servmt-content-form").convertFormDataToJSON();


										$.ajax({
											type: "POST",
											url: "api/myVehicleServMaintUpdate?_method=PUT",
											data: jsonInput,
											contentType:'application/json',
											success: function(result){
												$("#anchor-editDealerVehicleservmtModal-" + result.myVehicleServMaintId).data('details', result);
												alert("Successfully upated the Logbook");
												angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();
											}
										});


									});

									$.fn.convertFormDataToJSON = function(){
										var checkboxes = [];
										$(this).find('input:checkbox:checked').each(function(){
											checkboxes.push($(this).attr("name"));
										});
										var o = {};
									    var a = this.serializeArray();
									    $.each(a, function() {
									        if (o[this.name] != undefined) {
									            if (!o[this.name].push) {
									                o[this.name] = [o[this.name]];
									            }
									            if($.inArray(this.name, checkboxes) != -1)
									              o[this.name].push('true' || '');
									            else
									            	o[this.name].push(this.value || '');
									        } else {
									        	if($.inArray(this.name, checkboxes) != -1)
									        		o[this.name] = 'true' || '';
										        else
										           	o[this.name] = this.value || '';
									        }
									    });
									    return JSON.stringify(o);
									}


								}
								//Log Serv&MAINT END
								//end of logservmaint
							}
						});
					}
	// Rego State Lead Start
	$scope.postRegoStateUrlLead = function(isValid) {
		if(alreadyLogged()){
			if(isValid){
					var wsURL = 'api/regostateurl/getRegoStateUrlFor?vehState='+$('#car-reg-state').val()+'&vehType='+$('#car-reg-vehType').val();
				   $body.addClass("loading");
				    	$http({
							method : 'GET',
							url : wsURL

						}).success(function(data) {
							$body.removeClass("loading");
							if(data.flex2!="nourl"){
								window.open(data.flex2);
							}

										});
			}
			else
			{
				alert("Please fill all the require fields");
			}

		}
		else{alert("Please Login and Build");}



	}

	// Rego State lead end

					$scope.submitSearchForm = function(isValid) {


							if(isValid){

								var fileChooserMyVeh = document.getElementById('file-chooser');
								var fileMyVeh = fileChooserMyVeh.files[0];
								var objKeyMyVeh='noImage';
								if(fileMyVeh){
								objKeyMyVeh = 'facebook-' + fbUserId + '/' + fileMyVeh.name;}

								var fileChooserMyVeh2 = document.getElementById('file-chooser2');
								var fileMyVeh2 = fileChooserMyVeh2.files[0];
								var objKeyMyVeh2='noImage';
								if(fileMyVeh2){
								objKeyMyVeh2 = 'facebook-' + fbUserId + '/' + fileMyVeh2.name;}

								var fileChooserMyVeh3 = document.getElementById('file-chooser3');
								var fileMyVeh3 = fileChooserMyVeh3.files[0];
								var objKeyMyVeh3='noImage';
								if(fileMyVeh3){
								objKeyMyVeh3 = 'facebook-' + fbUserId + '/' + fileMyVeh3.name;}
								var jsonInputToAPI = {"userId":userId,
										"myVehicleVO":{
											"myVehicleId":null,
											"year": $scope.caryears,
											"make":$scope.carmakes,
													"model" :$scope.carmodels,
													 "variant":$scope.carmodeltrims,
													"vin":$scope.vin,
													"regNum":$scope.regNo,
													"regState":$scope.regState,
													"regExpDate":$scope.RegExpDate,
													"insProv":$scope.insProv,
													"insProvMan":"",
													"insPremPaid":$scope.insPrePaid,
													"insPremPaidFreq":"",
													"insExpiry":$scope.InsExpDate,
													"odoMeter":$scope.odoMeter,	//Last serv kms
													"lastServiceDt":$scope.LastServDate,
													"nextServiceDt":$scope.NextServDate,
													"nextServKms":$scope.nextServMaiKms,
													"finProvider":$scope.finProv,
													"loanAmt1":$scope.loanAmount,//Loan Amt
													"loanTakenDt":$scope.LoanTakenDate,
														"loanPaidFreq":"",
													"loanAmt2":0,
													"loanPeriod":$scope.laonPeriod,
													"loanInterest":1,
														"fuelCardProvider":"",
													"valFuelCard":"",
													"fuelType":$scope.vehicleType,//Vehicle type mapped to fuel type
													"photo1":objKeyMyVeh,
													"photo2":objKeyMyVeh2,
													"photo3":objKeyMyVeh3,
														"flex1":"flex1",
													"flex2":"flex1",
													"flex3":"flex1",
														"flex4":"flex1",
													"insRemind":$scope.insRemind,
													"vehIdentRego":$scope.vehIdentRemind,
													"maiRemind":$scope.maiRemind,
													"finRemind":$scope.finRemind,
													"flex5":12,
													"flex6":12,
													"flex7":12,
														"flex8":null,
													"flex9":null
										}
										}
								$body.addClass("loading");
														var wsURL = 'api/eBid/myVehicle';

															    $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI

																		}).success(function(data) {
																			$body.removeClass("loading");
																							alert("Successfully Stored My Vehicle Request with ID"+ data.myVehicleId+"However, Plz wait for the images to upload.. don't refresh or switch from dashboard..  the upload of images will start soon..");
																                			if(fileMyVeh || fileMyVeh2 || fileMyVeh3 ){
																                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																                				myvehicleloadImage();
																	                			document.getElementById("vehFrm").reset();
																	                			}
																                			else {
															                                	alert("No upload of images found..");
																	                			document.getElementById("vehFrm").reset();
															                                }
																							vehicleDetailsLoad();
																							registerEditDealerVehicleDetailModal();
																						});
							}
							else
								{
									alert("Please fill the Required fields");
								}



							};//end of submitsearch



							function registerEditDealerVehicleDetailModal(){


								//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
								//alert("Inside rey");
								var editDealerVehicleDetailModal = '<div class="modal fade" id="editDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
								    <div class="modal-dialog">\
								        <div class="modal-content">\
								            <div class="modal-header">\
								                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
								                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
								            </div>\
											<h4 class="modal-title" id="myModalLabel"><center>View My Vehicle Details</center></h4>\
									        <form id="edit-dealer-vehicle-detail-content-form">\
											<div class="modal-body edit-dealer-vehicle-detail-content">\
								            </div>\
								            <div class="modal-footer">\
								                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
									<button type="button" class="btn btn-primary submit-editDealerVehicleDetailModal" data-dismiss="modal">Save changes</button>\
											</div>\
								            </form>\
											<p><center>&copy; 2017 Autoscoop</center></p>\
								        </div>\
								    </div>\
								</div>';

								$(document.body).append(editDealerVehicleDetailModal);


								$('a.anchor-editDealerVehicleDetailModal').on('click', function(event) {


									var data = $(event.target).data('details');
									var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
									// start
									var appId = '249863545451459';
								    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
								      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
								      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
								      AWS.config.region = 'us-east-1';
								      var bucket = new AWS.S3({
								          params: {
								              Bucket: bucketName
								          }
								      });
								     accessToken = $.jStorage.get("fbAToken");
								     bucket.config.credentials = new AWS.WebIdentityCredentials({
							                  ProviderId: 'graph.facebook.com',
							                  RoleArn: roleArn,
							                  WebIdentityToken: accessToken
							              });
							          fbUserId = $.jStorage.get("fbKey");
									url1=" ";
									var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photo1, Expires: 60};
							        bucket.getSignedUrl('getObject', params, function (err, url) {
							          if (url) {
							          url1=url;
							          var insRemind = '<input type="checkbox" name="insRemind" />';
							          if(data.insRemind)
							  				insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

							  				var maiRemind = '<input type="checkbox" name="maiRemind" />';
				  					if(data.maiRemind)
							  			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

							  		var finRemind = '<input type="checkbox" name="finRemind" />';
							  		if(data.finRemind)
							  			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

							          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
										<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
										<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
										<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
										<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
										<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
										<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
										<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
										</table>\
										<br/>\
										<table>\
										<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
										<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
										<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
										<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
										<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
										<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
										<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
										<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
										<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
										<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
										<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
										<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
										<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
										<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
										<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
										<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
										</table>\
										<br/>\
										</table></form>';
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
									$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);
							          }
							          else{
							          alert("not able to retrieve photo for My Vehicle however you an view other details"+err);
							          //alert("successfully retrieved 12.."+url);
							          var insRemind = '<input type="checkbox" name="insRemind" />';
							    		if(data.insRemind)
							    			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

							    		var maiRemind = '<input type="checkbox" name="maiRemind" />';
							    		if(data.maiRemind)
							    			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

							    		var finRemind = '<input type="checkbox" name="finRemind" />';
							    		if(data.finRemind)
							    			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

							          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
										<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
										<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
										<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
										<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
										<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
										<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
										<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
										</table>\
										<br/>\
										<table>\
										<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
										<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
										<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
										<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
										<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
										<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
										<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
										<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
										<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
										<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
										<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
										<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
										</table>\
										<br/>\
										<table>\
										<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
										<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
										<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
										<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
										<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
										<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
										</table>\
										<br/>\
										</table></form>';
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
									$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);

							          }
							        });
									//end
								});

								$('button.submit-editDealerVehicleDetailModal').on('click', function(e) {

									var jsonInput = $("#edit-dealer-vehicle-detail-content-form").convertFormDataToJSON();


									$.ajax({
										type: "POST",
										url: "api/myVehicleGarageUpdate?_method=PUT",
										data: jsonInput,
										contentType:'application/json',
										success: function(result){
											$("#anchor-editDealerVehicleDetailModal-" + result.myVehicleId).data('details', result);
											alert("Successfully upated the My Vehicle Garage Details..");
											//angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();

										}
									});


								});

								$.fn.convertFormDataToJSON = function(){
									var checkboxes = [];
									$(this).find('input:checkbox:checked').each(function(){
										checkboxes.push($(this).attr("name"));
									});
									var o = {};
								    var a = this.serializeArray();
								    $.each(a, function() {
								        if (o[this.name] != undefined) {
								            if (!o[this.name].push) {
								                o[this.name] = [o[this.name]];
								            }
								            if($.inArray(this.name, checkboxes) != -1)
								              o[this.name].push('true' || '');
								            else
								            	o[this.name].push(this.value || '');
								        } else {
								        	if($.inArray(this.name, checkboxes) != -1)
								        		o[this.name] = 'true' || '';
									        else
									           	o[this.name] = this.value || '';
								        }
								    });
								    return JSON.stringify(o);
								}


							}
							
							// Vehicle Detail Modal Start
							registerEditnwvhDealerVehicleDetailModal();
				           	function registerEditnwvhDealerVehicleDetailModal(){


				           		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
				           		//alert("Inside new vehicle method raa");
				           		var editnwvhDealerVehicleDetailModal = '<div class="modal fade" id="editnwvhDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
				           		    <div class="modal-dialog">\
				           		        <div class="modal-content">\
				           		            <div class="modal-header">\
				           		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
				           		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
				           		            </div>\
				           					<h4 class="modal-title" id="myModalLabel"><center>View My Vehicle Details</center></h4>\
				           			        <form id="edit-nwvh-dealer-vehicle-detail-content-form">\
				           					<div class="modal-body edit-nwvh-dealer-vehicle-detail-content">\
				           		            </div>\
				           		            <div class="modal-footer">\
				           		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
				           			<button type="button" class="btn btn-primary submit-editnwvhDealerVehicleDetailModal" data-dismiss="modal">Save changes</button>\
				           					</div>\
				           		            </form>\
				           					<p><center>&copy; 2017 Autoscoop</center></p>\
				           		        </div>\
				           		    </div>\
				           		</div>';

				           		$(document.body).append(editnwvhDealerVehicleDetailModal);


				           		$('a.anchor-editnwvhDealerVehicleDetailModal').on('click', function(event) {


				           			var data = $(event.target).data('details');
				           			//var json = JSON.stringify(data);

				           			var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
				           			/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
				           			if(data.moveToUser)
				           			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';*/

				           			// start
				           			var appId = '249863545451459';
				           		    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
				           		      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
				           		      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
				           		      AWS.config.region = 'us-east-1';
				           		      var bucket = new AWS.S3({
				           		          params: {
				           		              Bucket: bucketName
				           		          }
				           		      });
				           		     //alert("bis fdscuifsdf t");
				           		     accessToken = $.jStorage.get("fbAToken");
				           		     //alert(accessToken);
				           					bucket.config.credentials = new AWS.WebIdentityCredentials({
				           			                  ProviderId: 'graph.facebook.com',
				           			                  RoleArn: roleArn,
				           			                  WebIdentityToken: accessToken
				           			              });
				           					fbUserId = $.jStorage.get("fbKey");
				           					//alert("Trying to retrieve photo for Serv and Maint..");
				           		          fbUserId = $.jStorage.get("fbKey");
				           			//alert("new changes now");
				           			url1=" ";
				           			var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photo1, Expires: 60};
				           	        bucket.getSignedUrl('getObject', params, function (err, url) {
				           	          if (url) { //alert("successfully retrieved 12.."+url);
				           	          url1=url;
				           	          var insRemind = '<input type="checkbox" name="insRemind" />';
				           	  		if(data.insRemind)
				           	  			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

				           	  		var maiRemind = '<input type="checkbox" name="maiRemind" />';
				           	  		if(data.maiRemind)
				           	  			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

				           	  		var finRemind = '<input type="checkbox" name="finRemind" />';
				           	  		if(data.finRemind)
				           	  			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

				           	          var editnwvhDealerVehicleDetailForm = '<form id="edit-nwvh-dealer-vehicle-detail-content-form"><table>\
				           				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				           				<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
				           				<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
				           				<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
				           				<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
				           				<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
				           				<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
				           				<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
				           				<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
				           				<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
				           				<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
				           				<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
				           				<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
				           				<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
				           				<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
				           				<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
				           				<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
				           				<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
				           				<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
				           				<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
				           				<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
				           				<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				</table></form>';
				           			editnwvhDealerVehicleDetailForm = editnwvhDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
				           			editnwvhDealerVehicleDetailForm = editnwvhDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
				           			$(".edit-nwvh-dealer-vehicle-detail-content").html(editnwvhDealerVehicleDetailForm);
				           	          }
				           	          else{
				           	          alert("not able to retrieve photo for My Vehicle however you an view other details"+err);
				           	          //alert("successfully retrieved 12.."+url);
				           	          var insRemind = '<input type="checkbox" name="insRemind" />';
				           	    		if(data.insRemind)
				           	    			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

				           	    		var maiRemind = '<input type="checkbox" name="maiRemind" />';
				           	    		if(data.maiRemind)
				           	    			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

				           	    		var finRemind = '<input type="checkbox" name="finRemind" />';
				           	    		if(data.finRemind)
				           	    			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

				           	          var editnwvhDealerVehicleDetailForm = '<form id="edit-nwvh-dealer-vehicle-detail-content-form"><table>\
				           				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
				           				<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
				           				<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
				           				<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
				           				<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
				           				<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
				           				<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
				           				<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
				           				<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
				           				<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
				           				<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
				           				<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
				           				<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
				           				<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
				           				<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
				           				<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
				           				<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
				           				<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				<table>\
				           				<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
				           				<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
				           				<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
				           				<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
				           				<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
				           				<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
				           				</table>\
				           				<br/>\
				           				</table></form>';
				           			editnwvhDealerVehicleDetailForm = editnwvhDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
				           			editnwvhDealerVehicleDetailForm = editnwvhDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
				           			$(".edit-nwvh-dealer-vehicle-detail-content").html(editnwvhDealerVehicleDetailForm);

				           	          }
				           	        });
				           			//end
				           		});

				           		$('button.submit-editnwvhDealerVehicleDetailModal').on('click', function(e) {

				           			var jsonInput = $("#edit-nwvh-dealer-vehicle-detail-content-form").convertFormDataToJSON();


				           			$.ajax({
				           				type: "POST",
				           				url: "api/myVehicleGarageUpdate?_method=PUT",
				           				data: jsonInput,
				           				contentType:'application/json',
				           				success: function(result){
				           					$("#anchor-editnwvhDealerVehicleDetailModal-" + result.myVehicleId).data('details', result);
				           					alert("Successfully upated the My Vehicle Garage Details..");
				           					//angular.element(document.getElementById('myController13')).scope().vehicleRetrievalforLogBook();

				           				}
				           			});


				           		});

				           		$.fn.convertFormDataToJSON = function(){
				           			var checkboxes = [];
				           			$(this).find('input:checkbox:checked').each(function(){
				           				checkboxes.push($(this).attr("name"));
				           			});
				           			var o = {};
				           		    var a = this.serializeArray();
				           		    $.each(a, function() {
				           		        if (o[this.name] != undefined) {
				           		            if (!o[this.name].push) {
				           		                o[this.name] = [o[this.name]];
				           		            }
				           		            if($.inArray(this.name, checkboxes) != -1)
				           		              o[this.name].push('true' || '');
				           		            else
				           		            	o[this.name].push(this.value || '');
				           		        } else {
				           		        	if($.inArray(this.name, checkboxes) != -1)
				           		        		o[this.name] = 'true' || '';
				           			        else
				           			           	o[this.name] = this.value || '';
				           		        }
				           		    });
				           		    return JSON.stringify(o);
				           		}


				           	}
							// Vehicle Detail Modal end
						function vehicleDetailsLoad(){
							var wsURL = 'api/userVehicle/'+userId;//"api/user/"+userid;
							//alert(wsURL);
							$body.addClass("loading");
						    $http({
										method : 'GET',
										url : wsURL
									}).success(function(data) {
										outVehicle="";
										outVehicle += '<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Operation"+'</th></tr>';
							           	  for(i=data.length-1;i>=0;i--)
							          		{

							           		outVehicle= outVehicle+'<tr>'+'<td>'+data[i].myVehicleId+'</td>'+'<td>'+data[i].year+'</td>'+'<td>'+data[i].make+'</td>'+'<td>'+data[i].model+'</td>'+'<td><a href="#" id="anchor-editnwvhDealerVehicleDetailModal-' + data[i].myVehicleId + '" data-details=\'' + JSON.stringify(data[i]) + '\' class="anchor-editnwvhDealerVehicleDetailModal btn btn-success btn-sm" data-toggle="modal" data-target="#editnwvhDealerVehicleDetailModal">View</a></td></tr>';
							          		}
							           	outVehicle = outVehicle.replace(/>null</g, ">--NA--<");
							           	outVehicle = outVehicle.replace(/>undefined</g, ">--NA--<");
							           	var LogMyVehic = data;

							           	if(LogMyVehic && data.length==0){
									           	outLT='<h2>No records found</h2>';
									            //forFinance("quo-model-data4",outLT);
									            $("#"+"quo-model-data4").html(outLT);
							           	}
							           	else{
							           	   //forFinance("quo-model-data4",outVehicle);
							           	   $("#"+"quo-model-data4").html(outVehicle);
							           	   }
							           	registerEditDealerVehicleDetailModal();


										$body.removeClass("loading");
													});


						}


						function registerEditDealerVehicleDetailModal(){

							var editDealerVehicleDetailModal = '<div class="modal fade" id="editDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
							    <div class="modal-dialog">\
							        <div class="modal-content">\
							            <div class="modal-header">\
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
							                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
							            </div>\
										<h4 class="modal-title" id="myModalLabel"><center>View My Vehicle Details</center></h4>\
										<form id="edit-dealer-vehicle-detail-content-form">\
											<div class="row">\
											<div class="col-sm-10 col-md-10"></div>\
								    		<div class="col-sm-2 col-md-2 pull-right">\
								        		<a href="#" class="btn btn-success btn-sm" onclick="printDiv("edit-dealer-vehicle-detail-content-form")">\
										          <span class="glyphicon glyphicon-print"></span> Print\
										        </a>\
										    </div>\
									    </div>\
										<div class="modal-body edit-dealer-vehicle-detail-content">\
							            </div>\
							            <div class="modal-footer">\
							                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\
								<button type="button" class="btn btn-primary submit-editDealerVehicleDetailModal" data-dismiss="modal">Save changes</button>\
										</div>\
							            </form>\
										<p><center>&copy; 2017 Autoscoop</center></p>\
							        </div>\
							    </div>\
							</div>';

							$(document.body).append(editDealerVehicleDetailModal);


							$('a.anchor-editDealerVehicleDetailModal').on('click', function(event) {


								var data = $(event.target).data('details');
								var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
								// start
								var appId = '249863545451459';
							    //prod        var roleArn =  'arn:aws:iam::675778862308:role/roleJavaScript'; //local var roleArn = 'arn:aws:iam::675778862308:role/javarolenow';
							      var roleArn = 'arn:aws:iam::675778862308:role/roleJavaScript';
							      var bucketName = 'elasticbeanstalk-us-east-1-675778862308';
							      AWS.config.region = 'us-east-1';
							      var bucket = new AWS.S3({
							          params: {
							              Bucket: bucketName
							          }
							      });
							     accessToken = $.jStorage.get("fbAToken");
							     bucket.config.credentials = new AWS.WebIdentityCredentials({
						                  ProviderId: 'graph.facebook.com',
						                  RoleArn: roleArn,
						                  WebIdentityToken: accessToken
						              });
								fbUserId = $.jStorage.get("fbKey");
								url1=" ";
								var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photo1, Expires: 60};
						        bucket.getSignedUrl('getObject', params, function (err, url) {
						          if (url) {
						          url1=url;
						          var insRemind = '<input type="checkbox" name="insRemind" />';
						  		if(data.insRemind)
						  			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

						  		var maiRemind = '<input type="checkbox" name="maiRemind" />';
						  		if(data.maiRemind)
						  			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

						  		var finRemind = '<input type="checkbox" name="finRemind" />';
						  		if(data.finRemind)
						  			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

						          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
									<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
									<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
									<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
									<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
									<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
									<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
									<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
									</table>\
									<br/>\
									<table>\
									<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
									<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
									<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
									<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
									<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
									<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
									<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
									<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
									<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
									<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
									<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
									<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
									<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
									<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
									<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
									<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
									</table>\
									<br/>\
									</table></form>';
								editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
								editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
								$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);
						          }
						          else{
						          alert("not able to retrieve photo for My Vehicle however you an view other details"+err);
						          var insRemind = '<input type="checkbox" name="insRemind" />';
						    		if(data.insRemind)
						    			insRemind = '<input type="checkbox" name="insRemind" checked="checked" />';

						    		var maiRemind = '<input type="checkbox" name="maiRemind" />';
						    		if(data.maiRemind)
						    			maiRemind = '<input type="checkbox" name="maiRemind" checked="checked" />';

						    		var finRemind = '<input type="checkbox" name="finRemind" />';
						    		if(data.finRemind)
						    			finRemind = '<input type="checkbox" name="finRemind" checked="checked" />';

						          var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
									<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url+'"'+' height="200" width="250"/></li></ul>\
									<tr><td>My Vehicle ID</td><td> <input type="hidden" name="myVehicleId" class="input-text full-width" value="' + data.myVehicleId + '"/></td></tr>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Basic info</div></div>\
									<tr><td>Vehicle Type</td><td> <input type="text" name="fuelType" class="input-text full-width" value="' + data.fuelType + '"/></td></tr>\
									<tr><td>Year</td><td> <input type="text" name="year" class="input-text full-width" value="' + data.year + '"/></td></tr>\
									<tr><td>Make</td><td> <input type="text" name="make" class="input-text full-width" value="' + data.make + '"/></td></tr>\
									<tr><td>Model</td><td> <input type="text" name="model" class="input-text full-width" value="' + data.model + '"/></td></tr>\
									<tr><td>Variant</td><td> <input type="text" name="variant" class="input-text full-width" value="' + data.variant + '"/></td></tr>\
									</table>\
									<br/>\
									<table>\
									<h6 style="color:#bd191e;"><b>Vehicle Identity</b></h6>\
									<tr><td>VIN/HIN Number</td><td> <input type="text" name="vin" class="input-text full-width" value="' + data.vin + '"/></td></tr>\
									<tr><td>Rego No</td><td> <input type="text" name="regNum" class="input-text full-width" value="' + data.regNum + '"/></td></tr>\
									<tr><td>Rego State</td><td> <input type="text" name="regState" class="input-text full-width" value="' + data.regState + '"/></td></tr>\
									<tr><td>Rego End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="regExpDate" class="input-text full-width" value="' + data.regExpDate + '"/></td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Insurance Details</div></div>\
									<tr><td>Insurance Provider</td><td> <input type="text" name="insProv" class="input-text full-width" value="' + data.insProv + '"/></td></tr>\
									<tr><td>Insurance End Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="insExpiry" class="input-text full-width" value="' + data.insExpiry + '"/></td></tr>\
									<tr><td>Insurance Premium Paid</td><td> <input type="text" name="insPremPaid" class="input-text full-width" value="'+ data.insPremPaid + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td>'+ insRemind + '</td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Maintenance Details</div></div>\
									<tr><td>Last Service @Kms</td><td> <input type="text" name="odoMeter" class="input-text full-width" value="' + data.odoMeter + '"/></td></tr>\
									<tr><td>Last Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="lastServiceDt" class="input-text full-width" value="' + data.lastServiceDt + '"/></td></tr>\
									<tr><td>Next Service Dt</td><td> <input type="text" onfocus="(this.type=\'date\')" name="nextServiceDt" class="input-text full-width" value="' + data.nextServiceDt + '"/></td></tr>\
									<tr><td>Next Service @Kms</td><td> <input type="text" name="nextServKms" class="input-text full-width" value="' + data.nextServKms + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td>'+ maiRemind + '</td></tr>\
									</table>\
									<br/>\
									<table>\
									<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Finance Info</div></div>\
									<tr><td>Finance Provider</td><td> <input type="text" name="finProvider" class="input-text full-width" value="' + data.finProvider + '"/></td></tr>\
									<tr><td>Loan Taken Date</td><td> <input type="text" onfocus="(this.type=\'date\')" name="loanTakenDt" class="input-text full-width" value="' + data.loanTakenDt + '"/></td></tr>\
									<tr><td>Loan Amount</td><td> <input type="text" name="loanAmt1" class="input-text full-width" value="' + data.loanAmt1 + '"/></td></tr>\
									<tr><td>Loan Period</td><td> <input type="text" name="loanPeriod" class="input-text full-width" value="' + data.loanPeriod + '"/></td></tr>\
									<tr><td>Insurance Reminder</td><td> '+ finRemind + '</td></tr>\
									</table>\
									<br/>\
									</table></form>';
								editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
								editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
								$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);

						          }
						        });
								//end
							});

							$('button.submit-editDealerVehicleDetailModal').on('click', function(e) {

								var jsonInput = $("#edit-dealer-vehicle-detail-content-form").convertFormDataToJSON();


								$.ajax({
									type: "POST",
									url: "api/myVehicleGarageUpdate?_method=PUT",
									data: jsonInput,
									contentType:'application/json',
									success: function(result){
										$("#anchor-editDealerVehicleDetailModal-" + result.myVehicleId).data('details', result);
										alert("Successfully upated the My Vehicle Garage Details..");
									}
								});


							});

							$.fn.convertFormDataToJSON = function(){
								var checkboxes = [];
								$(this).find('input:checkbox:checked').each(function(){
									checkboxes.push($(this).attr("name"));
								});
								var o = {};
							    var a = this.serializeArray();
							    $.each(a, function() {
							        if (o[this.name] != undefined) {
							            if (!o[this.name].push) {
							                o[this.name] = [o[this.name]];
							            }
							            if($.inArray(this.name, checkboxes) != -1)
							              o[this.name].push('true' || '');
							            else
							            	o[this.name].push(this.value || '');
							        } else {
							        	if($.inArray(this.name, checkboxes) != -1)
							        		o[this.name] = 'true' || '';
								        else
								           	o[this.name] = this.value || '';
							        }
							    });
							    return JSON.stringify(o);
							}


						}




												$scope.submitSearchFormLogBook = function(isValid) {
													 if (isValid) {
													var jsonInputToAPI = {"myVehicleId":myVehicleIDuse,
															"myVehicleLogBookVO":{
																"myVehicleLogBookId":null,
																"recordType": $('#vehicleTypeLogBook').val(),
																"tripType":$('#tripType').val(),
																		"tripDescription" :$('#tripDescription').val(),
																		 "fromLocation":$('#transTpostCode').val(),
																		"toLocation":$('#tAPostCode').val(),
																		"flex1":$('#startStrtSt').val(),
																		"flex2":$('#endStrtSt').val(),
																		"odoMeterStartOfTrip":$('#odoRead').val(),
																		"odoMeterEndOfTrip":$('#odoMtrEnd').val(),
																		"routeKm":$('#tripKmsMiles').val(),
																		"flex4":$('#tripNotes').val(),
																		"flex3":$('#logbookDrivLic').val(),
																		"flex5":0,
																		"flex6":0,
																		"flex8":$('#TripStartDate').val(),
																		"flex9":$('#TripEndDate').val(),
																		"flex7":0
															}
															}
													var wsURL = 'api/myvehicle/addMyVehicleLogBook';
														    $http({
														    		method : 'POST',
																	url : wsURL,
																	data: jsonInputToAPI
														    }).
														    then(function onSuccess(response) {
														      // Handle success
														      var data = response.data;
														      var status = response.status;
														      var statusText = response.statusText;
														      var headers = response.headers;
														      var config = response.config;
														      $scope.vehicleRetrievalforLogBook();
														      alert("Your Log is Successfully Stored..");
									                			document.getElementById("lognewfrm").reset();

														    }, function onError(response) {
														      // Handle error
														      /*var data = response.data;
														      var status = response.status;
														      var statusText = response.statusText;
														      var headers = response.headers;
														      var config = response.config;*/
														      alert("Something went wrong in error storing LogBook\n Please try Again");
														    });
														    }
													};

													$scope.submitSearchFormupdateset = function(isValid) {
														if (isValid) {
															//alert("Date"+$('#abcTitlePerson').val());
														var fileChooserlogupdateset = document.getElementById('file-chooser-updateset');
														var filefileChooserupdateset = fileChooserlogupdateset.files[0];
														var objKeyupdateset ='noImage';
														if(value.issueState){
															objKeyupdateset = value.issueState;
														}

														if(filefileChooserupdateset){
														objKeyupdateset = 'facebook-' + fbUserId + '/' + filefileChooserupdateset.name;}
														var jsonInputToAPI = {"userId":value.userId,"photo":objKeyupdateset, "dob":$('#UserDOBDate').val(),"gender":$('#abcTitlePerson').val(),"phoneNumber":$('#UserPhoneNo').val(), "firstName":$('#UserFirstName').val(),"lastName":$('#UserLastName').val(),"streetNumber":$('#UserStreetNo').val(),"streetName":$('#UserStreetName').val(),"postCode":$('#UserpostCode').val(),"region":$('#UserRegion').val(),"state":$('#UserState').val(),"desc":$('#UserDesc').val()}
														$body.addClass("loading");
														$.ajax({
									                		type: "POST",
									                		url: "api/updatePhoto?_method=PUT",
									                		data: JSON.stringify(jsonInputToAPI),
									                		contentType:'application/json',
									                		success: function(result){
									                			$body.removeClass("loading");
									                			setting(result);
									                			alert("Successfully upated profile.. Plz wait for the image to be uploaded.. Don't refresh or switch your Dashboard..");
									                			if(filefileChooserupdateset){
									                			updateSettingloadImage();}
									                			else{
									                				alert("No upload of image found..");
									                				refr();
									                			}



									                		}
									                	});
													}
														};



													$scope.submitSearchFormServMaint = function(isValid) {
														if (isValid) {
														var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
														var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
														var objKeyfilefileChooserlogservmaint ='noImage';
														if(filefileChooserlogservmaint){
														objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
														var jsonInputToAPI = {"myVehicleId":myVehicleIDuse,
																"myVehicleServMaintVO":{
																	"myVehicleServMaintId":null,
																	"date":$('#vehicleTypeServMaint').val(),
																	"Time":null,
																	"recordType":"Service&Maintenance",
																	"mechanicName":$('#mechanicNameCompanyName').val(),
																	"companyName":"pqrs",
																	"typeOfServMaint":$('#typeServiceMaintenance').val(),
																	"mechanicAddress":$scope.ServL1,
																	"contactDetails":$scope.ServL2,
																	"odoMeterKm":$('#odoMeterKmsMilesServMaint').val(),
																	"totalAmount":$('#totalAmount').val(),
																	"nextOdoMeterKm":$('#NextServiceMaintenanceOdoMeterKmsmils').val(),
																	"nextServDate":$('#nextServiceMaintenanceDate').val(),
																	"uploadPhoto":objKeyfilefileChooserlogservmaint,
																	"flex1":null,
																	"flex2":null,
																	"flex3":null,
																	"flex4":null,
																	"flex5":0,
																	"flex6":0,
																	"flex7":0,
																	"flex8":null,
																	"flex9":null
																}
																}
														var wsURL = 'api/myvehicle/addMyVehicleServMaint';
														$body.addClass("loading");
															    $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI

																		}).success(function(data) {
																			$body.removeClass("loading");
																			$scope.vehicleRetrievalforLogBook();
																			alert("Successfully Stored Service & Maintenance request However, Plz wait for the images to upload.. don't refresh or switch from your dashboard..  the upload of images will start soon..");
												                			if(filefileChooserlogservmaint){
												                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																			logServMaintloadImage();
												                			document.getElementById("logservmaintfrm").reset();
												                			}
												                			else {
											                                	alert("No upload of images found..");
													                			document.getElementById("logservmaintfrm").reset();
											                                }

																						});
													}
														};




														$scope.submitMyVehicleFuelExpenses = function(isValid) {
															alert("inside Fuel Expe"+isValid);
															if (isValid) {
															var fileChooserLogExp = document.getElementById('file-chooser-lognewexp');
															var filelogexp = fileChooserLogExp.files[0];
															var objKeylogexp ='noImage';
															if(filelogexp){
															objKeylogexp = 'facebook-' + fbUserId + '/' + filelogexp.name;}
															var jsonInputToAPI = {"myVehicleId":myVehicleIDuse,
																	"myVehicleFuelExpensesVO":{
																		"myVehicleFuelExpensesId":null,
																		"date":$('#ExpenseDate').val(),
																		"Time":$.now(),
																		"recordType":"Fuel Expense",
																		"noOfLitres":2,
																		"amount":$('#ExpAmt').val(),
																		"business":$('#expenseType').val(),
																		"private2":" ",
																		"others":$('#ExpenseDesc').val(),
																		"photoOfInvoice":objKeylogexp,
																		"flex1":null,
																		"flex2":null,
																		"flex3":null,
																		"flex4":null,
																		"flex5":0,
																		"flex6":0,
																		"flex7":0,
																		"flex8":null,
																		"flex9":null
																	}
																	}
															var wsURL = 'api/myvehicle/addMyVehicleFuelExpenses';
															 $body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: jsonInputToAPI

																			}).success(function(data) {
																				 $body.removeClass("loading");
																				$scope.vehicleRetrievalforLogBook();
																				alert("Successfully Stored Fuel Expenses request However, Plz wait for the images to upload.. don't refresh or switch from your dashboard..  the upload of images will start soon..");
																				if(filelogexp){
																					alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																					logExpensesloadImage();
																					document.getElementById("logexpensefrm").reset();
																				}
																				else {
												                                	alert("No upload of images found..");
												                                	document.getElementById("logexpensefrm").reset();

												                                }


																							});
														}
															};




				});
//angular.bootstrap(document, ['mainApp1']);
//angular JS end




