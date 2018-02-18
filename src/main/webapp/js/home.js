/**
 * 
 */
        var userId = null;
        email = null;
        flex1 = null;
        flex2 = null;
        flex3 = null;
        firstName = null;

        var mainApp1 = angular.module("mainApp1", []);
        mainApp1
            .controller(
            'myController1',
            function ($scope, $http) {
        		
                //Login start
            	 function carDetailHtml(data) {
                     //alert("storage");
                     $.jStorage.set('carKey', data);
                     $.jStorage.setTTL('userSession', 30000); 

                 }
        		$scope.newUsedCarSearch = "true";
        		//$scope.usedCarSearch = true;
        		fbloadphoto12();
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
            		alert($scope.ServL1);
                	$http({
                        method : 'GET',
                        url : 'api/level2?level1='+$scope.ServL1
                    }).then(function mySuccess(response) {
                    	console.log(response);	
                    	 $body.removeClass("loading");
                    	 $scope.ServiceLev2s = response.data;
                    	 console.log($scope.ServiceLev2s);
                    }, function myError(response) {
                    	$scope.ServiceLev2s = response.statusText;
                    });
            	}
            	
            	
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
            	//newUsedChange();
            	$scope.VyearsCar =["2017"];
            	$scope.newUsedChange = function(){
            	//function newUsedChange(){
            		//alert($scope.newUsedCarSearch);
            		if($scope.newUsedCarSearch === "true"){
            			//alert("here");
            			$scope.VyearsCar =["2017"];
            		}
            		else{
            			//alert("biscuit");
            			populateVYears();
            		}
            	}
            	
            	function populateVYears(){
            		$body.addClass("loading");
                	$http({
                        method : 'GET',
                        url : 'api/tempCarModelYears'
                    }).then(function mySuccess(response) {
                    	 $body.removeClass("loading");
                    	 $scope.VyearsCar = response.data;
                    }, function myError(response) {
                    	$scope.VyearsCar = response.statusText;
                    });
            	}
            	
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
            	
            	
            	
            	$body.addClass("loading");
            	$http({
                    method : 'GET',
                    url : 'api/tempCarModelYears'
                }).then(function mySuccess(response) {
                	 $body.removeClass("loading");
                	 $scope.yearsCar = response.data;
                }, function myError(response) {
                	$scope.yearsCar = response.statusText;
                });
            	
            	$scope.VmakeForYear = function (year){
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
                    	 $scope.VMakesCarYear = response.data;
                    }, function myError(response) {
                    	$scope.VMakesCarYear = response.statusText;
                    });
            	}
            	
            	$scope.VmodelForYearMake = function (make,year){
            		$body.addClass("loading");
            		//'api/tempCarModelNamesForMake?modelDisplay='+$scope.carmakesins+'&modelYear='+$scope.caryearsins
                	$http({
                        method : 'GET',
                        url : 'api/tempCarModelNamesForMake?modelDisplay='+make+'&modelYear='+year
                    }).then(function mySuccess(response) {
                    	 $body.removeClass("loading");
                    	 $scope.VModelsCarYearMake = response.data;
                    }, function myError(response) {
                    	$scope.VModelsCarYearMake = response.statusText;
                    });
            	}
            	
            	$scope.VvarForYearMakeMod = function (model,make,year){
            		$body.addClass("loading");
            		//'api/tempCarModelVariantForModel?modelName='+$scope.carmodelsins+'&modelDisplay='+$scope.carmakesins+'&modelYear='+$scope.caryearsins
                	$http({
                        method : 'GET',
                        url : 'api/tempCarModelTrimForAllSelect?modelName='+model+'&modelDisplay='+make+'&modelYear='+year
                    }).then(function mySuccess(response) {
                    	 $body.removeClass("loading");
                    	 $scope.VVarsCarYearMakeMod = response.data;
                    }, function myError(response) {
                    	$scope.VVarsCarYearMakeMod = response.statusText;
                    });
            	}
            	
            	
            	/*$scope.modelForYear = function (){
            		$body.addClass("loading");
                	$http({
                        method : 'GET',
                        url : 'api/tempCarModelYears'
                    }).then(function mySuccess(response) {
                    	 $body.removeClass("loading");
                    	 $scope.ModelsCarYear = response.data;
                    }, function myError(response) {
                    	$scope.ModelsCarYear = response.statusText;
                    });
            	}*/
                $scope.submitForm12 = function () {
                    //alert("invoke login ");
                    /*alert($scope.email);
                    alert(email); */

                    var jsonInputToAPI = { "email": "", "password": "" };
                    jsonInputToAPI.email = document.getElementById("exampleEmail").value;
                    jsonInputToAPI.password = document.getElementById("examplePass").value;
											/* alert(jsonInputToAPI.email);
											alert(jsonInputToAPI.password) */;
                    var wsURL = 'api/user/login';
                    //var wsURL = 'http://localhost:8080/MyCarDomain/api/user/login';
                    //  var wsURL = 'http://www.autoscoop.com.au/api/user/login';
                    /* alert(jsonInputToAPI.comingSoonUserEmail);
                    alert(jsonInputToAPI.flex1);
                    alert(jsonInputToAPI.flex2);
                    alert(jsonInputToAPI.flex3); */
                    $http({
                        method: 'POST',
                        url: wsURL,
                        data: jsonInputToAPI

                    }).success(function (data) {
                        alert("successful Login will set session");
                        setting(data);
                        /* $.jStorage.set("key",data);
                        $.jStorage.setTTL("key", 3000); // expires in 3 seconds
                                  alert("successfully set to session key"+data.userId);*/
                        //alert("userid"+data.userId);
                        userId = data.userId;
                        firstName = data.firstName;
                        //alert(data.firstName);
                        //document.getElementById('status').innerHTML = ' <div class="alert alert-success"> <strong>Success!</strong> You will be surely Notified! </div>';
                        if (userId != null) {
                            //alert(data.firstName);
                            document.getElementById('welcomeDiv').style.display = "block";
                            document.getElementById('welcomeDiv1').style.display = "none";
                            document.getElementById('userId').innerHTML = "<b>" + "Hi " + data.firstName + "</b>";
                        }
                        else {
                            alert("User Id or password not present");
                        }
                    });




                }

                //Login End

                // social login start

                $scope.submitForm1 = function () {
                	$('.login-social').html('<i class="fa fa-spinner fa-spin" style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">&nbsp;Logging in,Please wait...<span>');
                    var jsonInputToAPI = { "userId": 73, "password": " ", "abnNumber": " ", "firstName": "muf", "lastName": "ss", "email": "ss@gmail.com", "mobile": 98, "landLine": 98, "streetNumber": " ", "streetName": " ", "areaName": " ", "subOrb": " ", "state": " ", "postCode": 98, "drivingLicense": " ", "issueState": " ", "facebook": false, "payDeposit": true, "search": null, "searchInsurance": null, "searchFinance": null, "searchServMaint": null, "searchTransp": null, "vehicleQuotation": null, "insuranceQuotation": null, "financeQuotation": null };
                    jsonInputToAPI.email = email;
                    jsonInputToAPI.firstName = flex1;
                    jsonInputToAPI.lastName = flex1;

                    //alert(flex1);
                    var wsURL = 'api/user/login/social';

                    $body = $("body");
                    //$body.addClass("moSign");
                    $body.addClass("loading");

                    if (flex3 == 1 || flex3 == 2 || flex3 == 3 || flex3 == 4 || flex3 == 5) {

                        $http({
                            method: 'POST',
                            url: wsURL,
                            data: jsonInputToAPI

                        }).success(function (data) {
                            $body.removeClass("loading");
                            //alert("successful login set to session");
                            $('.login-social').html('<i style="font-size:24px"></i>Successfully logged in..');
                            setting(data);
                            userId = data.userId;
                            firstName = data.firstName;
                            //document.getElementById('status').innerHTML = '<div class="row"><div class="col-sm-1 col-md-1"></div> <div class="alert alert-success col-sm-11 col-md-11"> <strong>Login Success!</strong> Discover the Auto World... </div></div>';
                            $(".social").hide();
                            if (userId != null) {
                                //alert(data.firstName);
                                document.getElementById('welcomeDiv').style.display = "block";
                                document.getElementById('welcomeDiv1').style.display = "none";
                                document.getElementById('userId').innerHTML = "<b>" + "Hi " + data.firstName + "</b>";
                            }
                            //alert(data.loyalityFlag);
                            if(data.refer == false){
                            	//alert("inside loyality prog");
                            	//$("#loyalityModal").modal('show'); 
                            	$('.opacity-overlay').click();
                            	$("#loyalityBtn").click();
                            }
                            
                        });
                    }
                    //$body.removeClass("moSign");




                }

                //social login end

            	$scope.loyalityFrmSub = function (isValid){
            		if(isValid){
                		$('.loyaStatus').html('<i class="fa fa-spinner fa-spin" style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">&nbsp;Submitting,Please wait...<span>');
                		var wsURL = 'api/eBid/referencedPoints';
                		userId=$.jStorage.get('key').userId;
                		//alert(userId);
                		var jsonInputToAPI = { "referPointId":null,"refUserId": userId, "referencedFirstName":$scope.loyalityFname, "referencedLastName": $scope.loyalityLname, "referencedEmailId": $scope.loyalityEmail};
                		/*jsonInputToAPI = JSON.stringify(jsonInputToAPI);
                		console.log(JSON.stringify(jsonInputToAPI));*/
	            		$http({
	                        method: 'POST',
	                        url: wsURL,
	                        data: jsonInputToAPI
	
	                    }).success(function (data) {
	                        alert("successful");
	                        $('.loyaStatus').html('<i style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">Successfully stored...<span>');
	                    });
            		}
            	}
            	// query on real loyality Program
            	$scope.inviteFrmSub12 = function (isValid){
            		//if (alreadyLogged()) {
            		//alert("came here");
	            		if(isValid){
	                		$('.loyaStatus1').html('<i class="fa fa-spinner fa-spin" style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">&nbsp;Submitting,Please wait...<span>');
	                		var wsURL = 'api/eBid/questionRealLoyal';
	                		/*userId=$.jStorage.get('key').userId;
	                		firstName=$.jStorage.get('key').firstName;
	                		lastName=$.jStorage.get('key').lastName;*/
	                		userId=0;
	                		
	                		//alert(userId);
	                		var jsonInputToAPI = { "userReferPointId":null,"userId": userId, "fName":$scope.loyalityQuestion,"firstName":$scope.loyalityFname1, "lastName": $scope.loyalityLname1, "referedEmailId": $scope.loyalityEmail1};
	                		/*jsonInputToAPI = JSON.stringify(jsonInputToAPI);
	                		console.log(JSON.stringify(jsonInputToAPI));*/
		            		$http({
		                        method: 'POST',
		                        url: wsURL,
		                        data: jsonInputToAPI
		
		                    }).success(function (data) {
		                    	
		                        alert("Successful");
		                        $('.loyaStatus1').html('<i style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">Successfully stored...<span>');
		                    	
		                    });
	            		}
            		/*//}
            		else{
            			alert("Please login to invite your friends");
            		}*/
            	}
            	// query on real loyality Program end
            	
            	
            	
            	//invite frm method
            	
            	$scope.inviteFrmSub = function (isValid){
            		if (alreadyLogged()) {
	            		if(isValid){
	                		$('.loyaStatus1').html('<i class="fa fa-spinner fa-spin" style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">&nbsp;Submitting,Please wait...<span>');
	                		var wsURL = 'api/eBid/userReferPoints';
	                		userId=$.jStorage.get('key').userId;
	                		firstName=$.jStorage.get('key').firstName;
	                		lastName=$.jStorage.get('key').lastName;
	                		//alert(userId);
	                		var jsonInputToAPI = { "userReferPointId":null,"userId": userId, "fName":firstName, "lName": lastName,"firstName":$scope.inviteFname, "lastName": $scope.inviteLname, "referedEmailId": $scope.inviteEmail};
	                		/*jsonInputToAPI = JSON.stringify(jsonInputToAPI);
	                		console.log(JSON.stringify(jsonInputToAPI));*/
		            		$http({
		                        method: 'POST',
		                        url: wsURL,
		                        data: jsonInputToAPI
		
		                    }).success(function (data) {
		                    	if(data.action=="INITIATED"){
		                        alert("Successful");
		                        $('.loyaStatus1').html('<i style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">Successfully stored...<span>');
		                    	}
		                    	else{
		                    		alert("Invitation already Sent for Email Id"+data.referedEmailId);
		                    		$('.loyaStatus1').html('<i style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">Thank you for the support!They are already referred by you...<span>');
		                    	}
		                    });
	            		}
            		}
            		else{
            			alert("Please login to invite your friends");
            		}
            	}
            	
            	
                // trans Lead post start
                // Insurance lead posthey a
                $scope.posttransLead = function (isValid) {
                    if (alreadyLogged()) {
                        if (isValid) {

                            userId = $.jStorage.get('key').userId;
                            fbUserId = $.jStorage.get("fbKey");
                            var fileChoosertranp1 = document.getElementById('uploadPhotoTrans1');
                            var filetranp1 = fileChoosertranp1.files[0];
                            var objKeyMyVeh1 = 'noImage';
                            if (filetranp1) {
                                objKeyMyVeh1 = 'facebook-' + fbUserId + '/' + filetranp1.name;
                                $scope.uploadPhotoTrans1 = objKeyMyVeh1;
                            }
                            var fileChoosertranp2 = document.getElementById('uploadPhotoTrans2');
                            var filetranp2 = fileChoosertranp2.files[0];
                            var objKeyMyVeh2 = 'noImage';
                            if (filetranp2) {
                                objKeyMyVeh2 = 'facebook-' + fbUserId + '/' + filetranp2.name;
                                $scope.photo = objKeyMyVeh2;
                            }
							var jsonInputToAPI = {
                                "userId": userId,
                                "searchTranspLead": {
                                    "searchTranspId": null,
                                    "carModel":{},
                                    "fromPostCodeAddr": $scope.transFpostCode,
                                    "toPostCodeAddr": $scope.transTpostCode,
                                    /* "transTypeReq": $scope.transVehicle, */
                                    "year": $scope.caryearstrans,
                                    "make": $scope.carmakestrans,
                                    "model": $scope.carmodelstrans,
                                    "variant": $scope.carmodeltrimstrans,
                                    "pickUpDateTime": $scope.transPickup,
                                    "noOfCars": 0,
                                    "freeText": $scope.transAddNotes,
                                    "transpInsReq": true,
                                    "fromStreetNo": $scope.transFStreetNo,
                                    /* "toStreetName": $scope.transTStreetName, */
                                    "toStreetNo": $scope.transTStreetNo,
                                    /* "fromStreetName": $scope.transFStreetName, */
                                    "flexWithDateDefault": $scope.transPickConfirm,
                                    /* "howMay": $scope.transHow, */
                                    "kindOfTransport": $scope.transKind,
                                    "photo": $scope.uploadPhotoTrans2,
                                    "regoNo": $scope.transregono12,
                                    "regoState": $scope.transregost,
                                    "photo": $scope.photo,
                                    "uploadPhotos": $scope.uploadPhotoTrans1
                                }
                            };
                            var table1 = $("#my-table922");
							//Year as Variant
                            var table = table1.tableToJSON({
                                ignoreColumns:[0],
                                headings: ['flex1', 'flex2', 'flex3','flex4','variant','make','model','transpSearchMakeListId']
                              });
                            //delete table[0];
                            table.splice(0,1);
                            jsonInputToAPI.searchTranspLead.carModel = table;

                           

                            var wsURL = 'api/eBid/transserv';

                            // change here

                            $body.addClass("loading");
                            $http({
                                method: 'POST',
                                url: wsURL,
                                data: jsonInputToAPI

                            }).success(function (data) {
                                $body.removeClass("loading");
                                alert("Successfully Stored transport Request However, Plz wait for the images to upload.. don't refresh or switch from homepage..  the upload of images will start soon..");
                                if (filetranp1 || filetranp2) {
                                	alert("Plz wait for the images to upload.. don't refresh or switch from homepage.. the upload of images will start soon..");
                                fbtranspServ();}
                                else {
                                	alert("No upload of images found. Redirecting to your dashboard..");
                                	 var url = "Db_BetaV1.html#travel-stories4";

                                     window.location = url;
                                }

                            });


                        }
                        else {
                            alert("Please fill all the require fields");
                        }

                    }
                    else {
                        alert("Please Login and Build");
                    }



                }

                // trans lead end

                // Rego State Lead Start
                $scope.postRegoStateUrlLead = function (isValid) {
                    //alert("invoke in postRegoState lead");


                    /*alert($scope.email);
                    alert(email); */
                    if (alreadyLogged()) {
                        if (isValid) {
                            userId = $.jStorage.get('key').userId;
                            fbUserId = $.jStorage.get("fbKey");

                            var wsURL = 'api/regostateurl/getRegoStateUrlFor?vehState=' + $('#car-reg-state').val() + '&vehType=' + $('#car-reg-vehType').val();
                            // change here

                            $body.addClass("loading");
                            $http({
                                method: 'GET',
                                url: wsURL

                            }).success(function (data) {
                                $body.removeClass("loading");
                                alert("successfully retreived" + data.flex2);
                                if (data.flex2 != "nourl") {
                                    window.open(data.flex2);
                                }

                            });
                        }
                        else {
                            alert("Please fill all the require fields");
                        }

                    }
                    else { alert("Please Login and Build") }



                }

                // Rego State lead end


                // servmaint Lead post start
                // Insurance lead post
                $scope.postServMaintLead = function (isValid) {
                    //alert("invoke in ins lead");
                    /*alert($scope.email);
                    alert(email); */
                    if (alreadyLogged()) {
                        if (isValid) {

                            userId = $.jStorage.get('key').userId;
                            fbUserId = $.jStorage.get("fbKey");
                            //alert("inside insurance user id"+fbUserId);
                            var fileChooserserv1 = document.getElementById('uploadPhotoServ1');
                            var fileServ1 = fileChooserserv1.files[0];
                            var objKeyMyVeh = 'noImage';
                            if (fileServ1) {
                                objKeyMyVeh = 'facebook-' + fbUserId + '/' + fileServ1.name;
                                $scope.uploadPhotoServ1 = objKeyMyVeh;
                            }
                            var fileChooserserv2 = document.getElementById('uploadPhotoServ2');
                            var fileServ2 = fileChooserserv2.files[0];
                            var objKeyMyVeh2 = 'noImage';
                            if (fileServ2) {
                                objKeyMyVeh2 = 'facebook-' + fbUserId + '/' + fileServ2.name;
                                $scope.uploadPhotoServ2 = objKeyMyVeh2;
                            }
                            var fileChooserserv3 = document.getElementById('uploadPhotoServ3');
                            var fileServ3 = fileChooserserv3.files[0];
                            var objKeyMyVeh3 = 'noImage';
                            if (fileServ3) {
                                objKeyMyVeh3 = 'facebook-' + fbUserId + '/' + fileServ3.name;
                                $scope.uploadPhotoServ3 = objKeyMyVeh3;
                            }
                            var fileChooserserv4 = document.getElementById('uploadPhotoServ4');
                            var objKeyMyVeh4 = 'noImage';
                            if (fileServ4) {
                                var fileServ4 = fileChooserserv4.files[0];
                                objKeyMyVeh4 = 'facebook-' + fbUserId + '/' + fileServ4.name;
                                $scope.uploadPhotoServ4 = objKeyMyVeh4;
                            }

                            //alert("Image of MyVehicle"+objKeyMyVeh);
                            var jsonInputToAPI = {
                                "userId": userId,
                                "servMaintLead": {
                                    "searchServMaintId": null,
                                    "postCode": $scope.servpostCode,
                                    "regNo": $scope.servregono,
                                    "regoState": $scope.regoStateServ,
                                    "year": $scope.caryearsserv,
                                    "make": $scope.carmakesserv,
                                    "model": $scope.carmodelsserv,
                                    "variant": $scope.carmodeltrimsserv,
                                    "feulType": $scope.fuelTypeServ,
                                    "servMaintL1": $scope.ServL1,
                                    "servMaintL2": $scope.ServL2,
                                    "uploadPhotos": $scope.uploadPhotoServ1,
                                    "coveredUnderIns": $scope.coverInsServ,
                                    "curInsProv": $scope.InsprovServ,
                                    "photo1": $scope.uploadPhotoServ2,
                                    "photo2": $scope.uploadPhotoServ3,
                                    "photo3": $scope.uploadPhotoServ4,
                                    "coveredUnderFin": $scope.servFinPro,
                                    "curFinProv": $scope.servFinProlist,
                                    "lookService": $scope.lookService,
                                    "autoscoopTrim": $scope.carmodelAutotrimsserv,
                                    "freeText": $scope.servAddNotes
                                }
                            };


                            console.log(jsonInputToAPI);
                            console.log(JSON.stringify(jsonInputToAPI));
                            var wsURL = 'api/eBid/servmaint';

                            // change here

                            $body.addClass("loading");
                            $http({
                                method: 'POST',
                                url: wsURL,
                                data: jsonInputToAPI

                            }).success(function (data) {
                                $body.removeClass("loading");
                                alert("Successfully Stored Service && Maintenance Request However, Plz wait for the images to upload.. don't refresh or switch from homepage.. the upload of images will start soon..");
                                if (fileServ1 || fileServ2 || fileServ3 || fileServ4) {
                                	alert("Plz wait for the images to upload.. don't refresh or switch from homepage.. the upload of images will start soon..");
                                fbloadphoto();}
                                else {
                                	alert("No upload of images found. Redirecting to your dashboard..");
                                	 var url = "Db_BetaV1.html#travel-stories3";

                                     //window.location = url;
                                }

                            });
                        }
                        else {
                            alert("Please fill all the require fields");
                        }

                    }
                    else { alert("Please Login and Build") }



                }

                // servmaint lead end

                // Insurance lead post
                $scope.postInsuranceLead = function (isValid) {
                    if (alreadyLogged()) {

                        if (isValid) {
                            userId = $.jStorage.get('key').userId;


                            $scope.usedCarInsuran = false;
                            $scope.newCarInsuran = false;
                            if ($scope.newCarInsuran) {
                                $scope.newCarInsuran = true;
                            } else {
                                $scope.usedCarInsuran = true;
                            }
							//{ "flex5": 0, "flex6": 0, "flex7": 0, "flex8": 0, "flex9": 0, "flex10": 0, "lastName": "ss", "firstName": "ss", "drivingLicenseType": "ss", "dateOfBirth": null, "isflex13": 0, "isflex14": 0, "flex11": null, "flex12": null, "flex1": "ss", "flex2": "ss", "flex3": "ss", "flex4": "ss" }
                            var jsonInputToAPI = {
                                "userId": userId,
                                "insuranceLead": {
                                    "newer": $scope.newCarInsuran,
                                    "used": $scope.usedCarInsuran,
                                    "searchInsAdditionalDriv": [],
                                    "searchInsuranceId": null,
                                    "postCode": $scope.postcode1111,
                                    "insuranceType": $scope.insuranceType,
                                    "regNo": $scope.regono12,
                                    "regoState": $scope.insregost,
                                    "year": $scope.caryearsins,
                                    "make": $scope.carmakesins,
                                    "model": $scope.carmodelsins,
                                    "variant": $scope.carmodeltrimsins,
                                    "autoscoopTrim": $scope.carmodelAutotrimsins,
                                    "marketValue": $scope.market,
                                    "agreedValue": $scope.agree,
                                    "finance": $scope.insfinance,
                                    "financeProvider": $scope.insfinprov,
                                    "drivingLicenseType": $scope.inslictype,
                                    "drivingLicenseNo": $scope.licno,
                                    "drivingLicenseIssueState": $scope.inslicissstate,
                                    "noOfAtFaults": $scope.insfaults,
                                    "otherIssues": "lssa",
                                    "curInsProv": $scope.currinsprov,
                                    "prefExcessAmount": $scope.excessAmount,
                                    "dateOfBirth": $scope.insDriverDOB,
                                    "ageOfAdditionalDriver": null,
                                    "carParkedAt": $scope.inscarParked,
                                    "streetNO": $scope.insStreetNo,
                                    "streetName": $scope.insStreetName,
                                    "carUsedfor": $scope.insCarUsage,
                                    "typeOfBusiness": $scope.insifBusiness,
                                    "driverFirstName": $scope.Insfirstname,
                                    "driverLastName": $scope.Inslastname,
                                    "driverMobileNo": $scope.InsMobile,
                                    "driverEmailId": $scope.InsEmail,
                                    "licenseIssueDate": $scope.insLicIssueDt,
                                    "lastAtFaultClaimDate": $scope.insLastfaultDt,
                                    "reasonForSuspension": $scope.insReasonSusp,
                                    "AnyDriver": $scope.intExt3,//Allow Under 25 Driver
                                    "FreeWindScreen": $scope.extExt2,//Excess Free wind Screen
                                    "RentalCar": $scope.extExt3,//Excess Free Window Screen
                                    "NewCarRepl": $scope.extExt4,// New Car Replace
                                    "Roadsideasst":$scope.extExt5,//Road Side Assistance
                                    "LifetimeWarrep":$scope.intExt1,//Life time Warranty repairs
                                    "intsnokel": $scope.intExt2,//No Claim Bonus Protection
                                    "intBullBar": $scope.intExt4,//Cover Theft & Fire
                                    "intNudgeBar": $scope.intExt5,//Cover Towing Cost
                                    "HireCar": $scope.extExt1,//Hire Car after Accident(if any)
                                    "extsnokel":$scope.intExt6, //Essential Temporary Repairs
                                    "extBullBar":$scope.intExt7, //Accidental Damage
                                    "extNudgeBar":$scope.intExt8,//Emergency accommodation and Transport
                                    "avgNoOfKmYr": $scope.insAvgNoOfKms,
                                    "noOfDrivers": $scope.insDriversCt,
                                    "licenseGotSuspened": $scope.insLICSusp
                                }
                            };




                            var table1 = $("#my-table944");
                            var table = table1.tableToJSON({
                                ignoreColumns:[0],
                                headings: ['firstName', 'lastName', 'drivingLicenseType','dateOfBirth']
                              });
                            //delete table[0];

                            table.splice(0,1);

                            jsonInputToAPI.insuranceLead.searchInsAdditionalDriv = table ;



                            var wsURL = 'api/eBid/insurance';
                            $body.addClass("loading");
                            $http({
                                method: 'POST',
                                url: wsURL,
                                data: jsonInputToAPI

                            }).success(function (data) {
                                $body.removeClass("loading");
                                alert("successfully stored");
                                alert("Redirecting to Dashboard..");
                                var url = "Db_BetaV1.html#travel-stories2";

                                window.location = url;

                            });

                        }
                        else {
                            alert("Please fill all the require fields");
                        }

                    }
                    else {
                        alert("Please Login and Build");
                    }



                }     // Insurance lead post end
                
                //Sell my Vehicle
                
                $scope.submitSearchForm = function() {
                	
                	if (alreadyLogged()) {
            				$('.result').html('<i class="fa fa-spinner fa-spin" style="font-size:24px"></i>Saving,Please wait...');
                            userId = $.jStorage.get('key').userId;
							var autobid=false;
							autobid = document.getElementById("autoBid").value;
							//var classified = document.getElementById("postClassified").value;
							//alert("Came here c"+autobid);			SellvehicleType
							var jsonInputToAPI = {
																"refId":35,
														"modelYear": $scope.sellVehYear,
														"modelDisplay": $scope.SellVehMake,
														"modelName": $scope.sellVehModel,															      
														"modelTrim": $scope.sellVehAutotrim,
														"typeOfCar": $scope.vehicleCondition,
														"vehicleDescriptin": $scope.headerText,
														"make": $scope.financeOwning,
														"variant": $scope.hotOffer,
														"price": $scope.displayPrice,
														"bodyType":$scope.bodyType,
														"transmission": $scope.transmission,
														"fuelType": $scope.fuelType,
														"engine": null,
														"regNo": $scope.regno,
														"driveType": $scope.driveType,
														"kilometer": 120,
														"extColor": null,
														"warranty": null,
														"regExpiryDate": null,
														"vinNumber": $scope.vinnumber,
														"vendorStockNo": $scope.stockNo,
														"noOfDoors": 0,
														"intColor": null,
														"wheelSize": $scope.labelOnVehicle,
														"seatMake": $scope.detailDescription,
														"extFittingFlex1": $scope.extraExternal,
														"extFittingFlex2": null,
														"extFittingFlex3": null,
														"extFittingFlex4": null,
														"extFittingFlex5": null,
														"extFittingFlex6": null,
														"extFittingFlex7": null,
														"extFittingFlex8": null,
														"extFittingFlex9": null,
														"extFittingFlex10": null,
														"intFittingFlex1": $scope.extraInternal,
														"intFittingFlex2": null,
														"intFittingFlex3": null,
														"intFittingFlex4": null,
														"intFittingFlex5": null,
														"intFittingFlex6": null,
														"intFittingFlex7": null,
														"intFittingFlex8": null,
														"intFittingFlex9": null,
														"intFittingFlex10": null,
														"salePersonLooking": $scope.accidentHistory,
														"contName": null,
														"contPhone": 0,
														"contEmail": null,
														"logBookService": false,
														"cameIntoInv": null,
														"counterOfViewingCar": 0,
														"counterOfEnquiryCar": 0,
														"saleDate": null,
														"features": [],
														"photos": [],
														"carColor": $scope.color,
														"state": $scope.RegState,
														"region": $scope.SellvehicleType,
														"postCode": 0,
														"yearOfMake": null,
														"ausCapTer": null,
														"insCompAmountMin": 0,
														"insCompAmountMax": 0,
														"dealAmountMin": $scope.QRangeMin,
														"dealAmountMax": $scope.QRangeMax,
														"insthirdInsuanceMin": 0,
														"insthirdInsuanceMax": 0,
														"finAmountMin": 0,
														"newCar": false,
														"StockItem": autoBid
										}
										var wsURL = 'api/dealer/addInventory';
											    $http({
															method : 'POST',
															url : wsURL,
															data: jsonInputToAPI
																			
														}).success(function(data) {
															$('.result').html('Successfully Stored....');
															alert("Successfully Stored.. ");
															alert("Thank You. Your Inventory is saved"+data.inventoryId);
																							
																		});
                	}

                    else {
                        alert("Please Login and Make Sell");
                    }
			};

           

                // Finance lead post
                $scope.postFinanceLead = function (isValid) {
                    //alert("invoke in ins finance lead");
                    /*alert($scope.email);
                    alert(email); */
                    if (alreadyLogged()) {
                        if (isValid) {
                            userId = $.jStorage.get('key').userId;
                            //alert("user"+userId);
                            var newCarFinance = false;
                            //newCarFinance = document.getElementById("newCarFinance").value;
                            if (newCarFinance == "on") newCarFinance = false;
                            var usedCarFinance = false;
                            //usedCarFinance = document.getElementById("usedCarFinance").value;
                            if (usedCarFinance == "on") usedCarFinance = false;
                            //var dateInFormatFinDOB = stringToDate($('#date_of_birth').val(), "dd/MM/yyyy", "/");
                            $scope.usedCarFinance = false;
                            $scope.newCarFinance = false;
                            if ($scope.newCarFinance) {
                                $scope.newCarFinance = true;
                            } else {
                                $scope.usedCarFinance = true;
                            }
                            var jsonInputToAPI = {
                                "userId": userId,
                                "financeLead": {
                                    "newer": newCarFinance,
                                    "used": usedCarFinance,
                                    "year": $scope.caryearsfin,
                                    "make": $scope.carmakesfin,
                                    "model": $scope.carmodelsfin,
                                    "variant": $scope.carmodeltrimsfin,
                                    "autoscoopTrim": $scope.carmodelAutotrimsfin,
                                    "postCode": $scope.finVehicleValue1,
                                    "incomeType": $scope.finIncomeType,
                                    "yearEmploymentBusiness": $scope.finNoofYears,
                                    "incomeBeforeSuperTax": "",
                                    "incomeAfterSuperTax": "",
                                    "ifBusinessProvideABN": "",
                                    "creditRating": $scope.finCreditRating,
                                    "vehValue": 0.0,
                                    "balloonPay": "",
                                    "annualIncome": $scope.finAnnualIncome,
                                    "loanAmount": $scope.finLoanAmount,
                                    "loanPeriod": $scope.finLoanPeriod,
                                    "dateOfBirth": $scope.finDOB,
                                    "rego": $scope.finRego,
                                    "regoState": $scope.finRegoState,
                                    "streetNo": $scope.finStreetNo,
                                    /* "streetName": $scope.finStreetName, */
                                    "mr": $scope.finTitlePerson,
                                    "firstName": $scope.finFnameperson,
                                    "lastName": $scope.finLnameperson
                                }
                            };
                            var wsURL = 'api/eBid/finance';
                            $body.addClass("loading");
                            $http({
                                method: 'POST',
                                url: wsURL,
                                data: jsonInputToAPI

                            }).success(function (data) {
                                $body.removeClass("loading");
                                alert("successfully stored");
                                alert("Redirecting to Dashboard..");
                                var url = "Db_BetaV1.html#travel-stories1";

                                window.location = url;

                            });
                        }
                        else {
                            alert("Please fill all the required fields");
                        }
                    }
                    else {
                        alert("Please Login and Build");
                    }




                }

                // Insurance lead post end

                $scope.predicate = 'name';
                $scope.reverse = true;
                $scope.currentPage = 1;
                $scope.order = function (predicate) {
                    $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse
                        : false;
                    $scope.predicate = predicate;
                };

                $scope.updatePagination = function () {
                    $scope.totalItems = $scope.biil.details.length;
                    $scope.numPerPage = 5;
                    $scope.paginate = function (value) {
                        var begin, end, index;
                        begin = ($scope.currentPage - 1)
                            * $scope.numPerPage;
                        end = begin + $scope.numPerPage;
                        index = $scope.biil.details.indexOf(value);
                        return (begin <= index && index < end);
                    };
                };
                /// ISFinance & ISinsurance
                
                /* var isChecked896 = true; */
                allSelected896();
                allSelected996();
                
                $scope.isFinanceb = true;
                $scope.isInsuranceb = true;

                function allSelected896() {
                    var flag= document.getElementById("carEbidFinan").checked;
                    var data="";
                    if(flag){
                    	data="FChecked";

                    }
                    else
                   	{
                    	data="FNC";
                    	 $scope.isFinanceb = false;
                   	}

                	$.jStorage.set('finCheckKey', data);
                    $.jStorage.setTTL('mynewkey', 30000);
                    /* if (isChecked896) {
                        document.getElementById("carEbidFinan").value = false;
                        isChecked896 = !isChecked896;
                    }
                    else {
                        document.getElementById("carEbidFinan").value = true;
                    } */
                }

                /* var isChecked996 = true; */

                function allSelected996() {
                	var flag= document.getElementById("carEbidInsur").checked;
                	var data="";
                    if(flag){

                    	data="IChecked";
                    }
                    else
                   	{
                    	data="INC";
                    	$scope.isInsuranceb = false;
                   	}
                    $.jStorage.set('insCheckKey', data);
                    $.jStorage.setTTL('myinsnewkey', 30000);
                    /* if (isChecked996) {
                        document.getElementById("carEbidInsur").value = false;
                        isChecked996 = !isChecked996;
                    }
                    else {
                        document.getElementById("carEbidInsur").value = true;
                    } */
                }


                $scope.submitForm = function (isValid) {
                   /* var usedCarEbid;
                    var newCarEbid= document.getElementById("newUsedCarEbid").checked;
                    if(!newCarEbid){
                    	usedCarEbid = false;
                    	//alert("used is checked");
                    }*/
                    
                    var usedCarEbid;
                    var newCarEbid;
                    if($scope.newUsedCarSearch === "true"){
            			//alert("here");
                    	newCarEbid =true;
            		}
            		else{
            			//alert("biscuit");
            			usedCarEbid = false;
            		}
                    var carEbidFinan = $scope.isFinanceb;
                    var carEbidInsur = $scope.isInsuranceb;
                    

                    var wsURL = 'api/inventory/getStatisticsFor?modelYear=' + $scope.caryears + '&modelDisplay=' + $scope.carmakes + '&modelName=' +  $scope.carmodels + '&autoscoopTrim=' + $scope.carmodelAutotrims;

                    var modelYear = $scope.caryears;
                    var modelDisplay = $scope.carmakes;
                    var modelName = $scope.carmodels;
                    //var trimValue=$('#car-model-trims').val();
                    //var modelTrim=strUser;
                    var autoTrim = $scope.carmodelAutotrims;
                    //alert ("model"+modelYear);
                    if (alreadyLogged()) {
                        if (isValid) {
                            $body.addClass("loading");
                            $.ajax({
                                url: wsURL,
                                type: 'GET',
                                success: function (data) {

                                    data.modelYear = modelYear;
                                    data.modelDisplay = modelDisplay;
                                    data.modelName = modelName;
                                    /* data.modelTrim=modelTrim;
                                    data.trimValue=trimValue; */
                                    data.autoTrim = autoTrim;
                                    data.newCarEbid = newCarEbid;
                                    data.usedCarEbid = usedCarEbid;
                                    data.carEbidFinan = carEbidFinan;
                                    data.carEbidInsur = carEbidInsur;
                                    carDetailHtml(data);
                                    $body.removeClass("loading");
                                    var url = "Cd_BetaV1.html";
                                    window.location = url;
                                }


                            });
                        }
                        else {
                            alert("Please fill all the required fields");
                        }

                    }
                    else { alert("Please Login and Build") }

                    // start

                };

                $scope.init = function () {
                    $scope.biil = {
                        details: []
                    };
                    $scope.submitForm();
                };

            });
