// Check if "key" exists in the storage
var value = $.jStorage.get("key");
var fbUserId = $.jStorage.get("fbKey");
var fbToken = $.jStorage.get("fbAToken");

var myVehicleIDuse=null;
/*function setting(data){
	//alert("cameheretoset");
	//$.jStorage.deleteKey(key);
	$.jStorage.set('key',data);
	$.jStorage.setTTL('mykey', 30000); // expires in 3 seconds
         // alert("came here");

}*/
/*function refr(){
var url="Db_BetaV1.html";

window.location=url;
}*/
function alreadyLogged(){
	var value = $.jStorage.get("Akey");
	//alert("here");
	//alert("Checking logged or not");
	if(!value){
	    // if not - return false
		//alert("biscuit");
	return false;
	}
	else{
		//alert("Successfully logged in..");
		return true;
	}


}
if(!alreadyLogged())
{
		var url="Ad_Betav1.html";
		window.location=url;
}

function signingout(){

	 $.jStorage.deleteKey("Akey");
	 window.location="Ad_Betav1.html";
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
//window.onload= function(){
$(document).ready(function(){

	//alert("user js");
	$body = $("body");

	$(document).ajaxStart(function(){
		$body.addClass("loading");
	});

	$(document).ajaxStop(function(){
		$body.removeClass("loading");
	});


	//changed to Onload

/*	var userDetails ='<h2 class="box-title fullname">' + value.firstName + '</h2>\
		<dl class="term-description">\
	    <dt>user name:</dt><dd>' +value.email+ '</dd>\
	    <dt>first name:</dt><dd>' +value.firstName+ '</dd>\
	    <dt>last name:</dt><dd>' +value.lastName+ '</dd>\
	    <dt>phone number:</dt><dd>' +value.abnNumber+ '</dd>\
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
	alert("onload");
		alert(userDetails);
		console.log(userDetails); <dt>Date of birth:</dt><dd>15 August 1985</dd>\
	    

	$(".userdetails").append(userDetails);
	var default1='https://elasticbeanstalk-us-east-1-675778862308.s3.amazonaws.com/dashboard.png';
	 url="";*/
/*	fbdown(value.issueState);*/
	 // start of image download

	 function fbdown(imageName)
	 {
    // <!-- Facebook Login logic prod 249863545451459 test 238604546585672 -->
     //alert("before call12");
     //window.fbAsyncInit();
     //alert("before call12");
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
     /*alert(imageName);
     alert("bis fdscuifsdf t");*/
     accessToken = $.jStorage.get("fbAToken");
     //alert(accessToken);


			bucket.config.credentials = new AWS.WebIdentityCredentials({


	                  ProviderId: 'graph.facebook.com',


	                  RoleArn: roleArn,


	                  WebIdentityToken: accessToken


	              });


			fbUserId = $.jStorage.get("fbKey");
			//alert("Trying to retrieve thfh  d 	tge photo..");
          fbUserId = $.jStorage.get("fbKey");
          var profilePic;
          var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: imageName, Expires: 60};
          url = bucket.getSignedUrl('getObject', params, function (err, url) {
            if (url) { //alert("successfully retrieved.."+url);
            	profilePic = '<img width="270" height="263" alt="" src="'+url+'"'+'>';
            	$("#profilePic").append(profilePic);
            }
            else{
				//alert("Your Idle time as exceeded more than 10 mins, so can you plz log in again");
				//signingout();
				//alert("error"+err);
				profilePic = '<img width="270" height="263" alt="" src="'+default1+'"'+'>';$("#profilePic").append(profilePic);
				}
          });


       }	/*
	alert("inside userDashboard"+url);
	var profilePic;
if(url!="" ){
	profilePic = '<img width="270" height="263" alt="" src="'+url+'"'+'>';
}
else{profilePic = '<img width="270" height="263" alt="" src="'+default1+'"'+'>';}
	//alert(profilePic);
	$("#profilePic").append(profilePic);*/
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
	/* alert("pageName 11  now "); */

/*	userId = value.userId;
	firstName = value.firstName;
	//userId="71";
	//document.getElementById('minValue').innerHTML=priceMin;
	document.getElementById('firstName').innerHTML=value.firstName;
	//var searchId = parseURLParameter('searchId');

	if(userId!= null){
		//alert(firstName);
		document.getElementById('welcomeDiv').style.display = "block";
		document.getElementById('welcomeDiv1').style.display = "none";
		document.getElementById('userId').innerHTML="<b>"+"Hi "+firstName+"</b>";
	}
*/




  //alert("Before call");
	/*dashBoardCallSearch('car-model-data',userId);

  createCORSRequest("GET", "api/user/70");


function createCORSRequest(method, url){

    var xhr = new XMLHttpRequest();
    if ("withCredentials" in xhr){
        // XHR has 'withCredentials' property only if it supports CORS
        xhr.open(method, url, true);
    } else if (typeof XDomainRequest != "undefined"){ // if IE use XDR
    	//alert("came here");
    	xhr = new XDomainRequest();
        //alert(xhr.open(method, url));
    } else {
        xhr = null;
    }
    return xhr;
}*/
/*function dashBoardPhotoUpdate()
{
// start of

	//alert("came her");
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

*/
	//alert("Before Call");
	//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
	//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';


		   /* $http({
						method : 'POST',
						url : wsURL,
						data: jsonInputToAPI

					}).success(function(data) {
						alert("Successfully Stored..");
										alert("Thank You. Your MyVehicle ID is " + data.myVehicleId);

									});	*/

/*	$.ajax({
		type: "POST",
		url: "api/eBid/updatePhoto?_method=PUT",
		data: jsonInputToAPI,
		contentType:'application/json',
		success: function(result){
			// change here
			//alert("Successfully updated ....");
			alert("Successfully upated profile.. Plz wait for the image to be uploaded.. Don't refresh or switch your Dashboard..");

		}
	});

}
*/
function registerEditDealerservmaintQuotationModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerservmaintQuotationModal = '<div class="modal fade" id="editDealerservmaintQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="servMaintQuotId" value="' + data.servMaintQuotId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';


		var editDealerservmaintQuotationForm = '<form id="edit-dealer-servmaint-quotation-content-form"><table>\
			<tr><td>Quotation ID</td><td>' + data.servMaintQuotId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>User ID</td><td>' + data.userId + '</td></tr>\
			<tr><td>Model Year</td><td>' + data.modelYear + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.modelName + '</td></tr>\
			<tr><td>Model Display</td><td>' + data.modelDisplay + '</td></tr>\
			<tr><td>Auto Bid</td><td>' + data.autoBid + '</td></tr>\
			<tr><td>Dealer Id</td><td>' + data.dealerId + '</td><td>Dealer Search Id</td><td>' + data.dealServMaintId + '</td></tr>\
			<tr><td>Car Search Id</td><td>' + data.carServMaintId + '</td><td>Ref Id</td><td>' + data.refId + '</td></tr>\
			<tr><td>Dealer Name</td><td>' + data.dealerName + '</td><td>Dealer ABN</td><td>' + data.dealerABN + '</td></tr>\
			<tr><td>Quot Header FreeText</td><td>' + data.quotHeaderFreeText + '</td><td>servMaintL1</td><td>' + data.servMaintL1 + '</td></tr>\
			<tr><td>Rego No</td><td>' + data.regoNo + '</td><td>servMaintL2</td><td>' + data.servMaintL2 + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regoStat + '</td><td>Dealer Stock No</td><td>' + data.dealerStockNo + '</td></tr>\
			<tr><td>No Of Kms</td><td>' + data.noOfKms + '</td><td>Drive Away Price</td><td>' + data.driveAwayPrice + '</td></tr>\
			<tr><td>Negotiable</td><td>' + data.negotiable + '</td><td>Offer Valid Date</td><td>' + data.offerValidDate + '</td></tr>\
			<tr><td>First Come Serve</td><td>' + data.firstCumServe + '</td><td>curInsProv</td><td>' + data.curInsProv + '</td></tr>\
			<tr><td>Fuel Type</td><td>' + data.fuelType + '</td><td>Dealer Preferred Location</td><td>' + data.delPrefLocation + '</td></tr>\
			<tr><td>Offer Price 2</td><td>' + data.offerPrice2 + '</td><td>Offer Price 3</td><td>' + data.offerPrice3 + '</td></tr>\
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

function registerEditDealertranspservQuotationModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealertranspservQuotationModal = '<div class="modal fade" id="editDealertranspservQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="TranspServQuotId" value="' + data.TranspServQuotId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';


		var editDealertranspservQuotationForm = '<form id="edit-dealer-transpserv-quotation-content-form"><table>\
			<tr><td>Quotation ID</td><td>' + data.TranspServQuotId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>User ID</td><td>' + data.userId + '</td></tr>\
			<tr><td>Model Year</td><td>' + data.modelYear + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.modelName + '</td></tr>\
			<tr><td>Model Display</td><td>' + data.modelDisplay + '</td></tr>\
			<tr><td>Auto Bid</td><td>' + data.autoBid + '</td></tr>\
			<tr><td>Dealer Id</td><td>' + data.dealerId + '</td><td>Dealer Search Id</td><td>' + data.dealTranspServId + '</td></tr>\
			<tr><td>Car Search Id</td><td>' + data.userTranspServId + '</td><td>Ref Id</td><td>' + data.refId + '</td></tr>\
			<tr><td>Dealer Name</td><td>' + data.dealerName + '</td><td>Dealer ABN</td><td>' + data.dealerABN + '</td></tr>\
			<tr><td>Quot Header FreeText</td><td>' + data.quotHeaderFreeText + '</td><td>fromPostCodeAddr</td><td>' + data.fromPostCodeAddr + '</td></tr>\
			<tr><td>toPostCodeAddr</td><td>' + data.toPostCodeAddr + '</td><td>transTypeReq</td><td>' + data.transTypeReq + '</td></tr>\
			<tr><td>pickUpDateTime</td><td>' + data.pickUpDateTime + '</td><td>Dealer Stock No</td><td>' + data.dealerStockNo + '</td></tr>\
			<tr><td>No Of Kms</td><td>' + data.noOfKms + '</td><td>Drive Away Price</td><td>' + data.driveAwayPrice + '</td></tr>\
			<tr><td>Negotiable</td><td>' + data.negotiable + '</td><td>Offer Valid Date</td><td>' + data.offerValidDate + '</td></tr>\
			<tr><td>First Come Serve</td><td>' + data.firstCumServe + '</td><td>noOfCars</td><td>' + data.noOfCars + '</td></tr>\
			<tr><td>transpInsReq</td><td>' + data.transpInsReq + '</td><td>howMay</td><td>' + data.howMay + '</td></tr>\
			<tr><td>fromStreetNo</td><td>' + data.fromStreetNo + '</td><td>toStreetName</td><td>' + data.toStreetName + '</td></tr>\
			<tr><td>toStreetNo</td><td>' + data.toStreetNo + '</td><td>Dealer Preferred Location</td><td>' + data.delPrefLocation + '</td></tr>\
			<tr><td>Offer Price 2</td><td>' + data.offerPrice2 + '</td><td>Offer Price 3</td><td>' + data.offerPrice3 + '</td></tr>\
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

function registerEditDealerfin12QuotationModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerfin12QuotationModal = '<div class="modal fade" id="editDealerfin12QuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
function registerEditDealerins12QuotationModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerins12QuotationModal = '<div class="modal fade" id="editDealerins12QuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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

		var quotIdHiddenField = '<input type="hidden" name="insQuotId" value="' + data.insQuotId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';


		var editDealerins12QuotationForm = '<form id="edit-dealer-ins12-quotation-content-form"><table>\
			<tr><td>Quotation ID</td><td>' + data.insQuotId + '</td></tr>\
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
function registerEditDealerVehicleQuotationModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicleQuotationModal = '<div class="modal fade" id="editDealerVehicleQuotationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		  //var json = JSON.stringify(data);
//alert("datainside"+JSON.stringify(data));
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

		    //forFinance("deal-operation",out5DD);
		    //alert("userHistory"+out5DD);

		    out5DD1 = "";
		    var dealDt1 = data.dealerQuotationHistoryVO;
		    if(dealDt1)
		    {
		    	dealDt1 = data.dealerQuotationHistoryVO.length;
	  	   //document.getElementById('finMax').innerHTML=finMax;
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

		    //forFinance("deal-operation",out5DD);
		    //alert("userHistory"+out5DD1);
		  // logic to retrieve

		  //alert("data.oi"+data.postCode);
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
		  var editDealerVehicleQuotationForm = '<form id="edit-dealer-vehicle-quotation-content-form"><table>\
		   <tr><td>Quotation ID</td><td>' + data.quotId + '</td></tr>\
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
		   </table><table>\
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
		alert("data");
		console.log(JSON.stringify(jsonInput));

		$.ajax({
			type: "POST",
			url: "api/vehicleSearchQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleQuotationModal-" + result.quotId).data('details', result);
				alert("Successfully upated the Quotations");

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

function registerEditDealerVehicleSearchModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicleSearchModal = '<div class="modal fade" id="editDealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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

// start of usn
function registerEditDealerusnVehicletranspModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerusnVehicletranspModal = '<div class="modal fade" id="editDealerusnVehicletranspModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="userNotificationId" value="' + data.userNotificationId + '" />';
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.newer)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
		var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
		if(data.used)
		  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';*/

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

function registerEditDealerVehicletranspModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicletranspModal = '<div class="modal fade" id="editDealerVehicletranspModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="searchTranspId" value="' + data.searchTranspId + '" />';
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.newer)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
		var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
		if(data.used)
		  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';*/

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






		/*var editDealerVehicletranspForm = '<form id="edit-dealer-vehicle-transp-content-form"><table>\
			<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+data.uploadPhotos+'"'+' height="200" width="250"/></li></ul>\
			<tr><td>Search ID</td><td>' + data.searchTranspId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
			<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
			<tr><td>From PostCode Addr</td><td>' + data.fromPostCodeAddr + '</td></tr>\
			<tr><td>To PostCode Addr;</td><td>' + data.toPostCodeAddr + '</td></tr>\
			<tr><td>transport Type Request</td><td>' + data.transTypeReq + '</td></tr>\
			<tr><td>pickUpDateTime</td><td>' + data.pickUpDateTime + '</td></tr>\
			<tr><td>noOfCars</td><td>' + data.noOfCars + '</td></tr>\
			<tr><td>Free Text</td><td>' + data.freeText + '</td></tr>\
			<tr><td>transpInsReq</td><td>' + data.transpInsReq + '</td></tr>\
			</table></form>';
		editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>null</g, ">--NA--<");
		editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-dealer-vehicle-transp-content").html(editDealerVehicletranspForm);*/
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
function registerEditDealerVehicleservmaintModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
		if(data.newer)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
		var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
		if(data.used)
		  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';  // come here*/
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
		var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.uploadPhotos, Expires: 60};
        bucket.getSignedUrl('getObject', params, function (err, url) {
          if (url) { //alert("successfully retrieved 12.."+url);
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
		//alert("url1 new changes"+url1);

		/*var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form"><table>\
			<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+url1+'"'+' height="200" width="250"/></li></ul>\
			<tr><td>Search ID</td><td>' + data.searchServMaintId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
			<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
			<tr><td>Fuel Type</td><td>' + data.feulType + '</td></tr>\
			<tr><td>Service Level 1</td><td>' + data.servMaintL1 + '</td></tr>\
			<tr><td>Service Level 2</td><td>' + data.servMaintL2 + '</td></tr>\
			<tr><td>Covered Under Insurance</td><td>' + data.coveredUnderIns + '</td></tr>\
			<tr><td>Current Insurance Provider</td><td>' + data.curInsProv + '</td></tr>\
			<tr><td>Free Text</td><td>' + data.freeText + '</td></tr>\
			<tr><td>Rego No</td><td>' + data.regNo + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
			</table></form>';
		editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>null</g, ">--NA--<");
		editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-dealer-vehicle-servmaint-content").html(editDealerVehicleservmaintForm);*/
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
function registerEditDealerVehicleFinanceModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicleFinanceModal = '<div class="modal fade" id="editDealerVehicleFinanceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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




function registerEditDealerVehicleInsuranceModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editDealerVehicleInsuranceModal = '<div class="modal fade" id="editDealerVehicleInsuranceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		console.log(JSON.stringify(data));
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

function registerEditDealerVehicleDetailModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	//alert("Inside rey");
	var editDealerVehicleDetailModal = '<div class="modal fade" id="editDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
		//alert("url1 new changes"+url1);

		//end



		/*var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
			<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+data.photo1+'"'+' height="200" width="250"/></li></ul>\
			<tr><td>My Vehicle ID</td><td>' + data.myVehicleId + '</td></tr>\
			<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model</td><td>' + data.model + '</td></tr>\
			<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
			<tr><td>VIN</td><td>' + data.vin + '</td></tr>\
			<tr><td>Registration No:</td><td>' + data.regNum + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regState + '</td></tr>\
			<tr><td>Reg Expirty Date</td><td>' + data.regExpDate + '</td></tr>\
			<tr><td>Insurance Provider</td><td>' + data.insProv + '</td></tr>\
			<tr><td>Insurance Provider Man</td><td>' + data.insProvMan + '</td></tr>\
			<tr><td>Insurance Premium Paid</td><td>'+ data.insPremPaid + '</td></tr>\
			<tr><td>Insurance Premium Freq</td><td>' + data.insPremPaidFreq + '</td></tr>\
			<tr><td>Insurance Expiry</td><td>' + data.insExpiry + '</td></tr>\
			<tr><td>ODO Meter</td><td>' + data.odoMeter + '</td></tr>\
			<tr><td>Last Service Dt</td><td>' + data.lastServiceDt + '</td></tr>\
			<tr><td>Next Service Dt</td><td>' + data.nextServiceDt + '</td></tr>\
			<tr><td>Next Service Kms</td><td>' + data.nextServKms + '</td></tr>\
			<tr><td>Finance Provider</td><td>' + data.finProvider + '</td></tr>\
			<tr><td>Loan Amount1</td><td>' + data.loanAmt1 + '</td></tr>\
			<tr><td>Age Of Additional Driver</td><td>' + data.loanTakenDt + '</td></tr>\
			<tr><td>Loan Paid Freq</td><td>' + data.loanPaidFreq + '</td></tr>\
			<tr><td>Loan Period</td><td>' + data.loanPeriod + '</td></tr>\
			<tr><td>Loan Interest</td><td>' + data.loanInterest + '</td></tr>\
			<tr><td>Fuel Card Provider</td><td>' + data.fuelCardProvider + '</td></tr>\
			<tr><td>value Fuel Card</td><td>' + data.valFuelCard + '</td></tr>\
			<tr><td>Fuel Type</td><td>' + data.fuelType + '</td></tr>\
			</table></form>';
		editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
		editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);*/
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

function registerEditDealerVehicleDetailLogBookModal(){

	$('a.anchor-editDealerVehicleDetailLogBookModal').on('click', function(event) {
		//alert("invoke sscs clddaick");
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
		/*<td>' + data.variant + '</td></tr>\*/
		editDealerVehicleDetailLogBookForm = editDealerVehicleDetailLogBookForm.replace(/>null</g, ">--NA--<");
		editDealerVehicleDetailLogBookForm = editDealerVehicleDetailLogBookForm.replace(/>undefined</g, ">--NA--<");
		//$("#fuelCard41").append(editDealerVehicleDetailLogBookModal);
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


});

// end of window onload


function redirect() {
	//alert("Thank You. Your Seach ID is ");

	var url="Hm_BetaV1.html?userId="+userId+"&firstName="+firstName;

	window.location=url;
}


//angular JS start
var mainApp1 = angular.module("mainApp13", []);
mainApp1.controller('myController13',function($scope, $http) {
					//alert("in user con");function vehicleRetrievalforLogBook(){
	//alert("in angular");
	$scope.vehicleData;
	$scope.flag = "";
	
	$scope.srchServnfo ={};
	$scope.srchTranInfo ={};
	$scope.srchInsInfo ={};
	$scope.srchFinInfo ={};
	
	$scope.carEbidreq121214=true;
	$scope.scarEbidreq8818=true;
	$scope.qcarEbidreq99=true;
	$body = $("body");
	
	$http({
		method : 'GET',
		url : 'api/getReferredDetails'

	}).success(function(result) {
		
		 out3="";
    	   out3 += '<tr><th>'+"Referenced ID"+'</th><th>'+"Referrenced Email"+'</th><th>'+"Status"+'</th><th>'+"Referer"+'</th><th>'+"Operation"+'</th></tr>';
    	   console.log("from referred Details",result);
    		   for(i=result.length-1;i>=0;i--)
   		{
    			   //alert("data"+JSON.stringify(result[i]));
   		out3= out3+'<tr>'+'<td>'+result[i].userReferPointId+'</td>'+'<td>'+result[i].referedEmailId+'</td>'+'<td>'+result[i].status+'</td>'+'<td>'+result[i].userId+'</td>'+'<td>'+"Verify Send Updates"+'</td>'+'</tr>';


   		}
    	   out3 = out3.replace(/>null</g, ">--NA--<");
    	   out3 = out3.replace(/>undefined</g, ">--NA--<");
    	   var LogQuotation = result;

    	   if(LogQuotation && result.length==0){
    	   outLogT="";
    	   outLogT='<h2>No records found</h2>';
    	   //forFinance("quo-model-data",outLogT);
    	   $("#"+"referencedUsers").html(outLogT);
    	   }else{
    	   //forFinance("quo-model-data",out3);
    	   $("#"+"referencedUsers").html(out3);
	   }
    	   
    	    	});
	

	
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
	
	/*$scope.UserFirstName=value.firstName;
	$scope.UserLastName=value.lastName;
	$scope.UserPhoneNo=value.abnNumber;
	$('#UserPhoneNo').val(value.abnNumber);
	$('#UserFirstName').val(value.firstName);
	$('#UserLastName').val(value.lastName);
	$('#UserStreetNo').val(value.streetNumber);
	$('#UserStreetName').val(value.streetName);
	$('#UserpostCode').val(value.postCode);
	$('#User	Region').val(value.drivingLicense);
	$('#UserState').val(value.state);
	*/
	
	function pullDealerIds(subscriptionType){
		
		console.log("pullDealerIds"+subscriptionType);
		$http({
	        method : 'GET',
	        url : 'api/dealerIDs/'+subscriptionType
	    }).then(function mySuccess(response) {
	    	if(subscriptionType === "Finance"){
	    		$scope.dealerIdsF = response.data;
	    	}else if(subscriptionType === "Insurance"){
	    		$scope.dealerIdsI = response.data;
	    	}else if(subscriptionType === "Servicemaintenance"){
	    		$scope.dealerIdsSM = response.data;
	    	}else if(subscriptionType === "Transport"){
	    		$scope.dealerIdsT = response.data;
	    	}else if(subscriptionType === "SellVehicle"){
	    		$scope.dealerIds = response.data;
	    	}
	    	
	    }, function myError(response) {
	    	if(subscriptionType === "Finance"){
	    		$scope.dealerIdsF = response.statusText;
	    	}else if(subscriptionType === "Insurance"){
	    		$scope.dealerIdsI = response.statusText;
	    	}else if(subscriptionType === "Servicemaintenance"){
	    		$scope.dealerIdsSM = response.statusText;
	    	}else if(subscriptionType === "Transport"){
	    		$scope.dealerIdsT = response.statusText;
	    	}else if(subscriptionType === "SellVehicle"){
	    		$scope.dealerIds = response.data;
	    	}
	    });
		
	}
	
	
	
	$scope.isDealerIdsNull = function(dealerId){
		if(dealerId === null){
			return false;
		}
		return true;
		
	}
	//Pulling dealer Information
	
	$scope.dealerSvInfoForID = function(){
		console.log("Pulling Dealer Info");
		$http({
	        method : 'GET',
	        url : 'api/dealerInfoforID?dealerID='+ $scope.LeadSvDealerId
	    }).then(function mySuccess(response) {
	    	 console.log("response.data",response.data);
	    	 $scope.leadSvDealerName = response.data.dealername;
	    	 $scope.leadSvDealerABN = response.data.abnnumber;
	    	 $scope.leadSvDealerEmail = response.data.email;
	    }, function myError(response) {
	    	$scope.leadSvDealerName = response.statusText;
	    });
	
	}
	
	// start of External Dealer creation
$scope.carCarQuotation = function(userId){
		alert("came here");
		//userId=$.jStorage.get('key').userId;
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

	//end of external dealer Creation
	
	// start of Insurance Lead Requests
	$scope.submitInsMyLeadNewExtfrm = function() {
		//alert("ibnvsscv"+$scope.LeadSvCategory+""+$scope.leadSvExtpost);
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealIns?category='+$scope.LeadInsCategory+ '&postCode=' +$scope.leadInsExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 alert("Retrieved"+data1.externalDealerVO.length);
	    	 var options="" ;
	    	 //alert("started retrieved Lead Id"); 
	    	 $("#ExtInsDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	  //alert("options in external"+options);
               	 $("#ExtInsDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadInsExtDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
	// start of Finance Lead Requests
	$scope.submitFinMyLeadNewExtfrm = function() {
		//alert("ibnvsscv"+$scope.LeadSvCategory+""+$scope.leadSvExtpost);
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealFin?category='+$scope.LeadFinCategory+ '&postCode=' +$scope.leadFinExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 alert("Retrieved"+data1.externalDealerVO.length);
	    	 var options="" ;
	    	 //alert("started retrieved Lead Id"); 
	    	 $("#ExtFinDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	  //alert("options in external"+options);
               	 $("#ExtFinDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadFinExtDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	// end of Finance Lead Requests
	
	
	// Tp start 
	$scope.submitTpMyLeadNewExtfrm = function() {
		//alert("ibnvsscv"+$scope.LeadSvCategory+""+$scope.leadSvExtpost);
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealTp?category='+$scope.LeadTpCategory+ '&postCode=' +$scope.leadTpExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 alert("Retrieved"+data1.externalDealerVO.length);
	    	 var options="" ;
	    	 //alert("started retrieved Lead Id"); 
	    	 $("#ExtTpDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	  //alert("options in external"+options);
               	 $("#ExtTpDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadTpExtDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
	
	// S&M start
	$scope.submitSvMyLeadNewExtfrm = function() {
		//alert("ibnvsscv"+$scope.LeadSvCategory+""+$scope.leadSvExtpost);
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealSM?category='+$scope.LeadSvCategory+ '&postCode=' +$scope.leadSvExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 alert("Retrieved"+data1.externalDealerVO.length);
	    	 var options="" ;
	    	 //alert("started retrieved Lead Id"); 
	    	 $("#ExtSvDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	  //alert("options in external"+options);
               	 $("#ExtSvDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadSvExtDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
// Insurance Lead Creation Start
	
	$scope.submitInsMyLeadNewfrmext = function() {
		alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		//console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["extDealerSearchId"]=null;
		alert("Dealer id"+$scope.ExtInsDealerId);
		
		//console.log($scope.ExtDealerId);
			jsonInput["dealerId"]=$scope.ExtInsDealerId;
		
		
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1); 26/06
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
			//console.log(JSON.stringify(jsonInput));
			var jsonStr = '{"extDealerSearchVO":[]}';

			var obj = JSON.parse(jsonStr);
			obj['extDealerSearchVO'].push(jsonInput);
			jsonStr = JSON.stringify(obj);
			jsonStr.replace(/\\/g, "");
			
			
			var json1 =jsonStr.split('"searchInsuranceId":').join('"carSearchId":');
			var json2= json1.split('"idp":').join('"userid":');
			json2.replace(/\\/g, "");
		 alert(" ssssss"+json2);
		 console.log(json2);
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/extDealerInsLeadCreation?_method=PUT',
			data: json2
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Successfully Saved External Dealer Lead");
	    	 //console.log(response.data);
	    }, function myError(response) {
	    	alert("Error Successfully Saved External Dealer Lead");
	    	//console.log(response.statusText);
	    });
		
	}
	// end of Insurance Lead Creation 

	// Finance Lead Creation Start
	
	$scope.submitFinMyLeadNewfrmext = function() {
		alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		//console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["extDealerSearchId"]=null;
		//alert("Dealer id"+$scope.ExtDealerId);
		
		//console.log($scope.ExtDealerId);
			jsonInput["dealerId"]=$scope.ExtFinDealerId;
		
		
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1); 26/06
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
			//console.log(JSON.stringify(jsonInput));
			var jsonStr = '{"extDealerSearchVO":[]}';

			var obj = JSON.parse(jsonStr);
			obj['extDealerSearchVO'].push(jsonInput);
			jsonStr = JSON.stringify(obj);
			jsonStr.replace(/\\/g, "");
			
			
			var json1 =jsonStr.split('"searchFinanceId":').join('"carSearchId":');
			var json2= json1.split('"idp":').join('"userid":');
			json2.replace(/\\/g, "");
		 alert(" ssssss"+json2);
		 console.log(json2);
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/extDealerFinLeadCreation?_method=PUT',
			data: json2
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Successfully Saved External Dealer Lead");
	    	 //console.log(response.data);
	    }, function myError(response) {
	    	alert("Error Successfully Saved External Dealer Lead");
	    	//console.log(response.statusText);
	    });
		
	}
	// end of Finance Lead Creation 
	
	// transport Lead creation Start
	$scope.submitTpMyLeadNewfrmext = function() {
		alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		//console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["extDealerSearchId"]=null;
		//alert("Dealer id"+$scope.ExtDealerId);
		
		//console.log($scope.ExtDealerId);
			jsonInput["dealerId"]=$scope.ExtTpDealerId;
		
		
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1); 26/06
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
			//console.log(JSON.stringify(jsonInput));
			var jsonStr = '{"extDealerSearchVO":[]}';

			var obj = JSON.parse(jsonStr);
			obj['extDealerSearchVO'].push(jsonInput);
			jsonStr = JSON.stringify(obj);
			jsonStr.replace(/\\/g, "");
			
			
			var json1 =jsonStr.split('"searchTranspId":').join('"carSearchId":');
			var json2= json1.split('"idp":').join('"userid":');
			json2.replace(/\\/g, "");
		 alert(" ssssss"+json2);
		 console.log(json2);
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/extDealerTpLeadCreation?_method=PUT',
			data: json2
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Successfully Saved External Dealer Lead");
	    	 //console.log(response.data);
	    }, function myError(response) {
	    	alert("Error Successfully Saved External Dealer Lead");
	    	//console.log(response.statusText);
	    });
		
	}
	// transport Lead creation end
	$scope.submitSvMyLeadNewfrmext = function() {
		///alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		//console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["extDealerSearchId"]=null;
		//alert("Dealer id"+$scope.ExtDealerId);
		
		//console.log($scope.ExtDealerId);
			jsonInput["dealerId"]=$scope.ExtSvDealerId;
		
		
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1); 26/06
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
			//console.log(JSON.stringify(jsonInput));
			var jsonStr = '{"extDealerSearchVO":[]}';

			var obj = JSON.parse(jsonStr);
			obj['extDealerSearchVO'].push(jsonInput);
			jsonStr = JSON.stringify(obj);
			jsonStr.replace(/\\/g, "");
			
			
			var json1 =jsonStr.split('"searchServMaintId":').join('"carSearchId":');
			var json2= json1.split('"idp":').join('"userid":');
			json2.replace(/\\/g, "");
		 //alert(" ssssss"+json2);
		 //console.log(json2);
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/extDealerSvLeadCreation?_method=PUT',
			data: json2
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Successfully Saved External Dealer Lead");
	    	 //console.log(response.data);
	    }, function myError(response) {
	    	alert("Error Successfully Saved External Dealer Lead");
	    	//console.log(response.statusText);
	    });
		
	}
	
	/*// start of check 
	$scope.submitMyLeadNewExtChkfrm = function() {
		alert("ibnvsscv");
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealSearch?category='+$scope.LeadChkCategory+ '&postCode=' +$scope.leadChkExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 //alert("Retrieved");
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 var options ;
	    	 //$(".ExtDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	//options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	//options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	 //$(".ExtDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadExtChkDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	// end of check
*/	
	
	
	// S&M end
	
	$scope.submitMyLeadNewExtfrm = function() {
		//alert("ibnvsscv");
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/getExtDealSearch?category='+$scope.LeadCategory+ '&postCode=' +$scope.leadExtpost
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 //alert("Retrieved");
	    	 out="";
	    	 data1 = response.data;
	    	 //console.log(data1);
	    	 //console.log(data1.externalDealerVO);
	    	 //alert(data1.externalDealerVO.length);
	    	 //alert(data1.externalDealerVO)
	    	 // change here
	    	 var options ;
	    	 $(".ExtDealerId").empty();
             if(data1.externalDealerVO.length!=0)
           	  {
               	  out += '<tr><th>'+"Operation"+'</th><th>'+"Ext Dealer Id"+'</th><th>'+"Company Name"+'</th><th>'+"Phone No"+'</th>'+'<th>'+"Email"+'</th><th>'+"Website URL"+'</th></tr>';
               	options += '<option value="" selected disabled>Select a Dealer ID</option>';
               	  for(i=0;i<data1.externalDealerVO.length;i++)
  	          		{
  	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

  	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data1.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data1.externalDealerVO[i].companyName+'</td>'+'<td>'+data1.externalDealerVO[i].phone+'<td>'+data1.externalDealerVO[i].email+'</td>'+'</td>'+'<td>'+data1.externalDealerVO[i].website+'</td></tr>';
  	          	 //options += '<option>' +data1.externalDealerVO[i].externalDealerId+ '</option>';
  	          	options += '<option value="' + data1.externalDealerVO[i].externalDealerId + '">' + data1.externalDealerVO[i].externalDealerId + '</option>';
  	          		}
               	 $(".ExtDealerId").html(options);
           	  }
      	 
             else{
      		out='<h2>No Dealers for the Combination</h2>';
      	   }
      	
      	   out = out.replace(/>null</g, ">--NA--<");
      	   out = out.replace(/>undefined</g, ">--NA--<");
      	   $("#LeadExtDealTable").html(out);
	    	 //console.log(data);
	    	 //console.log(data.externalDealerVO);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
	
	$scope.submitMyLeadNewfrm = function() {
		//alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["dealerSearchId"]=null;
			jsonInput["dealerId"]=$scope.LeadDealerId;
		
			
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1);
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
//			console.log(JSON.stringify(new_obj));
		 
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/dealerLeadCreation?_method=PUT',
			data: jsonInput
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Saved");
	    	 console.log(response.data);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
	$scope.submitMyLeadNewfrmext = function() {
		//alert("Insisdsssssde");
		//alert(JSON.stringify($scope.vehicleData));
		console.log(JSON.stringify($scope.vehicleData));
		//jsonInput = JSON.stringify($scope.vehicleData);
		jsonInput = $scope.vehicleData;
		
		jsonInput["extDealerSearchId"]=null;
		//alert("Dealer id"+$scope.ExtDealerId);
		//$scope.ExtDealerId=128;
		console.log($scope.ExtDealerId);
			jsonInput["dealerId"]=$scope.ExtDealerId;
		
		
		/*var jsonInput1 ={
				 "dealerSearchId": null,
				 "dealerId" : $scope.LeadDealerId,
				 "lastName": "Smith",
				 "phoneNumber": "123-456-7890"
				}*/
		
		/*var concattedjson = jsonInput.concat(jsonInput1); 26/06
		console.log(concattedjson);*//*
		$scope.leadDealerName = response.data.dealername;
		 $scope.leadDealerABN = response.data.abnnumber;
		 $scope.leadDealerEmail = response.data.email;*/
			//console.log(JSON.stringify(jsonInput));
			var jsonStr = '{"extDealerSearchVO":[]}';

			var obj = JSON.parse(jsonStr);
			obj['extDealerSearchVO'].push(jsonInput);
			jsonStr = JSON.stringify(obj);
			jsonStr.replace(/\\/g, "");
			//jsonStr.replace('"state"', '"insuranceType"');
			
		 //alert("before sss"+jsonStr);
		 console.log(jsonStr);
		 
		$body.addClass("loading");
		$http({
	        method : 'POST',
	        url : 'api/extDealerLeadCreation?_method=PUT',
			data: jsonStr
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 alert("Successfully Saved External Dealer Lead");
	    	 //console.log(response.data);
	    }, function myError(response) {
	    	alert(response);
	    	console.log(response);
	    	alert("Error Successfully Saved External Dealer Lead");
	    	//console.log(response.statusText);
	    });
		
	}
	
	
	
	$scope.dealerInfoForID = function() {
		//alert("Hi Dude");
		console.log("Pulling Dealer Info");
		$body.addClass("loading");
		$http({
	        method : 'GET',
	        url : 'api/dealerInfoforID?dealerID='+$scope.LeadDealerId
	    }).then(function mySuccess(response) {
	    	 $body.removeClass("loading");
	    	 //alert("Bis");
	    	 //alert(response.data.dealername);
	    	 $scope.leadDealerName = response.data.dealername;
    		 $scope.leadDealerABN = response.data.ABNNumber;
			 $scope.leadDealerEmail = response.data.email;
	    	 console.log(response.data);
	    }, function myError(response) {
	    	console.log(response.statusText);
	    });
		
	}
	
	// get loyality Program Start
	 $scope.getalllylInfor = function () {
	        
         var wsURL = 'api/adminlylall';
        
 $body.addClass("loading");
 $http({
     method: 'GET',
     url: wsURL

 }).success(function (data) {
     $body.removeClass("loading");
     //alert("successfully retrieved"+data.userVO.length);
     out="";

	   out += '<tr><th>'+"S.no"+'</th><th>'+"Loyality ID"+'</th><th>'+"Review Name"+'</th>'+'<th>'+"Referred Name"+'</th><th>'+"userReferred Name"+'</th><th>'+"Type of Regis"+'</th><th>'+"Type of Sell"+'</th><th>'+"Operation"+'</th></tr>';
	   for(i=data.userVO.length-1;i>=0;i--)
		{
		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.userVO[i].loyalityProgramId+'</td>'+'<td>'+data.userVO[i].revName+'<td>'+data.userVO[i].referredName+'</td>'+'</td>'+'<td>'+data.userVO[i].userReferName+'</td>'+'<td>'+data.userVO[i].typeOfTrans+'</td>'+'<td>'+data.userVO[i].typeOfSell+'</td>'+'<td><a href="#" id="anchor-editDealerlkVehicleSearchModal-' + data.userVO[i].loyalityProgramId + '" data-details=\'' + JSON.stringify(data.userVO[i]) + '\' class="anchor-editDealerlkVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerlkVehicleSearchModal">View</a></td></tr>';

		}
	   out = out.replace(/>null</g, ">--NA--<");
	   out = out.replace(/>undefined</g, ">--NA--<");
	   //alert(out);
	   var LogSearch = data.userVO;

	   if(LogSearch && data.userVO.length==0){
	   outLogT="";
	   outLogT='<h2>No records found</h2>';
	   forFinance("car-lylty-data",outLogT);
	   }
	   else{
	   forFinance("car-lylty-data",out);}
	  registerEditDealerlkVehicleSearchModal();

 });

}

	// end of loyality Program 
// start of retrieval
	 function registerEditDealerlkVehicleSearchModal(){


	    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	    	var editDealerlkVehicleSearchModal = '<div class="modal fade" id="editDealerlkVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    	    <div class="modal-dialog">\
	    	        <div class="modal-content">\
	    	            <div class="modal-header">\
	    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
	    	            </div>\
	    				<h4 class="modal-title" id="myModalLabel"><center>View User Details</center></h4>\
	    		        <form id="edit-dealer-lk-vehicle-search-content-form">\
	    				<div class="modal-body edit-dealer-lk-vehicle-search-content">\
	    	            </div>\
	    	            <div class="modal-footer">\
	    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
	    		<button type="button" class="btn btn-primary submit-editDealerlkVehicleSearchModal" data-dismiss="modal">Save changes</button>\
	    		<p><center>&copy; 2017 Autoscoop</center></p>\
	    			</div>\
	    	            </form>\
	    	        </div>\
	    	    </div>\
	    	</div>';

	    	$(document.body).append(editDealerlkVehicleSearchModal);


	    	$('a.anchor-editDealerlkVehicleSearchModal').on('click', function(event) {


	    		var data = $(event.target).data('details');
	    		//var json = JSON.stringify(data);
	    		var quotIdHiddenField = '<input type="hidden" name="loyalityProgramId" value="' + data.loyalityProgramId + '" />';
	    		var moveToUser = '<input type="checkbox" name="status" />';
				if(data.status)
					  moveToUser = '<input type="checkbox" name="status" checked="checked" />';


	    		//alert(JSON.stringify(data)); to work
	    		var editDealerlkVehicleSearchForm = '<form id="edit-dealer-lk-vehicle-search-content-form"><table>\
	    			<table>\
	    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
	    			<tr><td>Loyality ID</td><td>' + data.loyalityProgramId + '</td></tr>\
	    			<tr><td>' + quotIdHiddenField + '</td></tr>\
	    			<tr><td>Review Name</td><td> <input type="text" name="revName" class="input-text full-width" value="' + data.revName + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="revAction1" class="input-text full-width" value="' + data.revAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="revDivByAct1" class="input-text full-width" value="' + data.revDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="revDivByAct2" class="input-text full-width" value="' + data.revDivByAct2 + '"/></td></tr>\
	    			<tr><td>Blog Name</td><td> <input type="text" name="blogName" class="input-text full-width" value="' + data.blogName + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="blogAction1" class="input-text full-width" value="' + data.blogAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="blogDivByAct1" class="input-text full-width" value="' + data.blogDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="blogDivByAct2" class="input-text full-width" value="' + data.blogDivByAct2 + '"/></td></tr>\
	    			<tr><td>Referred Name</td><td> <input type="text" name="referredName" class="input-text full-width" value="' + data.referredName + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="referredAction1" class="input-text full-width" value="' + data.referredAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="referredDivByAct1" class="input-text full-width" value="' + data.referredDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="referredDivByAct2" class="input-text full-width" value="' + data.referredDivByAct2 + '"/></td></tr>\
	    			<tr><td>User Refer Name</td><td> <input type="text" name="userReferName" class="input-text full-width" value="' + data.userReferName + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="userReferAction1" class="input-text full-width" value="' + data.userReferAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="userReferDivByAct1" class="input-text full-width" value="' + data.userReferDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="userReferDivByAct2" class="input-text full-width" value="' + data.userReferDivByAct2 + '"/></td></tr>\
	    			<tr><td>Buy Value Transa</td><td> <input type="text" name="typeOfTrans" class="input-text full-width" value="' + data.typeOfTrans + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="buyCarAction1" class="input-text full-width" value="' + data.buyCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="buyCarDivByAct1" class="input-text full-width" value="' + data.buyCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="buyCarDivByAct2" class="input-text full-width" value="' + data.buyCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Sell Value Transa</td><td> <input type="text" name="typeOfSell" class="input-text full-width" value="' + data.typeOfSell + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="sellCarAction1" class="input-text full-width" value="' + data.sellCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="sellCarDivByAct1" class="input-text full-width" value="' + data.sellCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="sellCarDivByAct2" class="input-text full-width" value="' + data.sellCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Finance Value Transa</td><td> <input type="text" name="typeOfFin" class="input-text full-width" value="' + data.typeOfFin + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="finCarAction1" class="input-text full-width" value="' + data.finCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="finCarDivByAct1" class="input-text full-width" value="' + data.finCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="finCarDivByAct2" class="input-text full-width" value="' + data.finCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Insurance Value Transa</td><td> <input type="text" name="typeOfIns" class="input-text full-width" value="' + data.typeOfIns + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="insCarAction1" class="input-text full-width" value="' + data.insCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="insCarDivByAct1" class="input-text full-width" value="' + data.insCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="insCarDivByAct2" class="input-text full-width" value="' + data.insCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Transport Value Transa</td><td> <input type="text" name="typeOfTrnp" class="input-text full-width" value="' + data.typeOfTrnp + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="transpCarAction1" class="input-text full-width" value="' + data.transpCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="transpCarDivByAct1" class="input-text full-width" value="' + data.transpCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="transpCarDivByAct2" class="input-text full-width" value="' + data.transpCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Service Maint Value Transa</td><td> <input type="text" name="typeOfServ" class="input-text full-width" value="' + data.typeOfServ + '"/></td></tr>\
	    			<tr><td>Calculate Points</td><td> <input type="text" name="servCarAction1" class="input-text full-width" value="' + data.servCarAction1 + '"/></td></tr>\
	    			<tr><td>Initial Provisional Points</td><td> <input type="text" name="servCarDivByAct1" class="input-text full-width" value="' + data.servCarDivByAct1 + '"/></td></tr>\
	    			<tr><td>Complete Trans Division</td><td> <input type="text" name="servCarDivByAct2" class="input-text full-width" value="' + data.servCarDivByAct2 + '"/></td></tr>\
	    			<tr><td>Active Status</td><td>' + moveToUser + '</td></tr>\
	    			</table></table></form>';
	    		editDealerlkVehicleSearchForm = editDealerlkVehicleSearchForm.replace(/>null</g, ">--NA--<");
	    		editDealerlkVehicleSearchForm = editDealerlkVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
	    		$(".edit-dealer-lk-vehicle-search-content").html(editDealerlkVehicleSearchForm);
	    	});
	    	$('button.submit-editDealerlkVehicleSearchModal').on('click', function(e) {

	    		var jsonInput = $("#edit-dealer-lk-vehicle-search-content-form").convertFormDataToJSON();
//alert("changes12"+jsonInput);

	    		$.ajax({
	    			type: "POST",
	    			url: "api/loyalityUpdate?_method=PUT",
	    			data: jsonInput,
	    			contentType:'application/json',
	    			success: function(result){
	    				$("#anchor-editDealerlkVehicleSearchModal-" + result.loyalityProgramId).data('details', result);
	    				alert("Successfully upated the Loyality Program");

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
	 // end of retrieval
	
	
	// get all userinfo start
	 $scope.getallUserInfor = function () {
	        
	                        var wsURL = 'api/adminuserall';
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.userVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"User ID"+'</th><th>'+"First Name"+'</th>'+'<th>'+"Last Name"+'</th><th>'+"Email Id"+'</th><th>'+"Wecome Sent"+'</th><th>'+"Address"+'</th><th>'+"Date of Reg"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.userVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.userVO[i].userId+'</td>'+'<td>'+data.userVO[i].firstName+'<td>'+data.userVO[i].lastName+'</td>'+'</td>'+'<td>'+data.userVO[i].email+'</td>'+'<td>'+data.userVO[i].welstatus+'</td>'+'<td>'+data.userVO[i].streetNumber+data.userVO[i].streetName+data.userVO[i].streetName+data.userVO[i].postCode+data.userVO[i].drivingLicense+data.userVO[i].state+'</td>'+'<td>'+data.userVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleSearchModal-' + data.userVO[i].userId + '" data-details=\'' + JSON.stringify(data.userVO[i]) + '\' class="anchor-editDealerssVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleSearchModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.userVO;

	             	   if(LogSearch && data.userVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-data",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-data",out);}
	             	  registerEditDealerssVehicleSearchModal();

	                });

	            }
	// end get all userinfo
	
	// get all dealerinfo start
	 $scope.getallDealerInfor = function () {
	        alert("start");
	                        var wsURL = 'api/getExtDealNu?category='+$scope.categoryExtS+ '&state=' +$scope.stateExtDeal;
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.externalDealerVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"External Dealer ID"+'</th><th>'+"Category"+'</th>'+'<th>'+"CompanyName"+'</th><th>'+"State"+'</th><th>'+"PostCode"+'</th><th>'+"Email"+'</th><th>'+"Phone"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.externalDealerVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data.externalDealerVO[i].category+'<td>'+data.externalDealerVO[i].companyName+'</td>'+'</td>'+'<td>'+data.externalDealerVO[i].state+'</td>'+'<td>'+data.externalDealerVO[i].postCode+'</td>'+'<td>'+data.externalDealerVO[i].email+data.externalDealerVO[i].postCode+data.externalDealerVO[i].phone+data.externalDealerVO[i].website+'</td>'+'<td>'+data.externalDealerVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleExtDealNuModal-' + data.externalDealerVO[i].externalDealerId + '" data-details=\'' + JSON.stringify(data.externalDealerVO[i]) + '\' class="anchor-editDealerssVehicleExtDealNuModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleExtDealNuModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.externalDealerVO;

	             	   if(LogSearch && data.externalDealerVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-dealerData",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-dealerData",out);}
	             	  registereditDealerssVehicleExtDealNuModal();

	                });

	            }
	// end get all Dealerinfo
	 
	// get all dealerSv start
	 $scope.getallDealerSvInfo = function () {
	        alert("start");
	                        var wsURL = 'api/getExtDealSmSt?category='+$scope.categorySvExtSh+ '&state=' +$scope.stateSvExtSh;
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.externalDealerVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"External Dealer ID"+'</th><th>'+"Category"+'</th>'+'<th>'+"CompanyName"+'</th><th>'+"State"+'</th><th>'+"PostCode"+'</th><th>'+"Email"+'</th><th>'+"Phone"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.externalDealerVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data.externalDealerVO[i].category+'<td>'+data.externalDealerVO[i].companyName+'</td>'+'</td>'+'<td>'+data.externalDealerVO[i].state+'</td>'+'<td>'+data.externalDealerVO[i].postCode+'</td>'+'<td>'+data.externalDealerVO[i].email+data.externalDealerVO[i].postCode+data.externalDealerVO[i].phone+data.externalDealerVO[i].website+'</td>'+'<td>'+data.externalDealerVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleExtDealSvModal-' + data.externalDealerVO[i].externalDealerId + '" data-details=\'' + JSON.stringify(data.externalDealerVO[i]) + '\' class="anchor-editDealerssVehicleExtDealSvModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleExtDealSvModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.externalDealerVO;

	             	   if(LogSearch && data.externalDealerVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-dealerDataSm",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-dealerDataSm",out);}
	             	  registereditDealerssVehicleExtDealSvModal();

	                });

	            }
	// end get all service 
	 // start of transport
	 $scope.getallDealerTpInfo = function () {
	        alert("start");
	                        var wsURL = 'api/getExtDealTpSt?category='+$scope.categoryTpExtSrh+ '&state=' +$scope.stateTpExtSrh;
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.externalDealerVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"External Dealer ID"+'</th><th>'+"Category"+'</th>'+'<th>'+"CompanyName"+'</th><th>'+"State"+'</th><th>'+"PostCode"+'</th><th>'+"Email"+'</th><th>'+"Phone"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.externalDealerVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data.externalDealerVO[i].category+'<td>'+data.externalDealerVO[i].companyName+'</td>'+'</td>'+'<td>'+data.externalDealerVO[i].state+'</td>'+'<td>'+data.externalDealerVO[i].postCode+'</td>'+'<td>'+data.externalDealerVO[i].email+data.externalDealerVO[i].postCode+data.externalDealerVO[i].phone+data.externalDealerVO[i].website+'</td>'+'<td>'+data.externalDealerVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleExtDealTpModal-' + data.externalDealerVO[i].externalDealerId + '" data-details=\'' + JSON.stringify(data.externalDealerVO[i]) + '\' class="anchor-editDealerssVehicleExtDealTpModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleExtDealTpModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.externalDealerVO;

	             	   if(LogSearch && data.externalDealerVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-dealerDataTp",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-dealerDataTp",out);}
	             	  registereditDealerssVehicleExtDealTpModal();

	                });

	            }
	// end get all transport 

	// start of finance
	 $scope.getallDealerFnInfo = function () {
	        alert("start");
	                        var wsURL = 'api/getExtDealFinSt?category='+$scope.categoryFinExtSrh+ '&state=' +$scope.stateFinExtSrh;
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.externalDealerVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"External Dealer ID"+'</th><th>'+"Category"+'</th>'+'<th>'+"CompanyName"+'</th><th>'+"State"+'</th><th>'+"PostCode"+'</th><th>'+"Email"+'</th><th>'+"Phone"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.externalDealerVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data.externalDealerVO[i].category+'<td>'+data.externalDealerVO[i].companyName+'</td>'+'</td>'+'<td>'+data.externalDealerVO[i].state+'</td>'+'<td>'+data.externalDealerVO[i].postCode+'</td>'+'<td>'+data.externalDealerVO[i].email+data.externalDealerVO[i].postCode+data.externalDealerVO[i].phone+data.externalDealerVO[i].website+'</td>'+'<td>'+data.externalDealerVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleExtDealFnModal-' + data.externalDealerVO[i].externalDealerId + '" data-details=\'' + JSON.stringify(data.externalDealerVO[i]) + '\' class="anchor-editDealerssVehicleExtDealFnModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleExtDealFnModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.externalDealerVO;

	             	   if(LogSearch && data.externalDealerVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-dealerDataFin",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-dealerDataFin",out);}
	             	  registereditDealerssVehicleExtDealFnModal();

	                });

	            }
	// end get all finance 

	 //Send Lead to Dealer
	 
	 

		$scope.submitMyLeadNewSvfrm = function() {
			console.log("submitMyLeadNewSvfrm");
			console.log("srchTranInfo"+$scope.srchServnfo);
			//var new_jsonstr = $scope.srchServnfo.replace('"idp"', '"userid"');
			$http({
		        method : 'POST',
		        url : 'post/dealerSnM/'+$scope.LeadSvDealerId,
				data: $scope.srchServnfo
		    }).then(function mySuccess(response) {
		    	 alert("Successfully Saved Internal Dealer Lead");
		    	 console.log(response);
		    }, function myError(response) {
		    	alert("Error Successfully Saved Internal Dealer Lead");
		    });

		}
		$scope.submitMyLeadNewFfrm = function() {
			console.log("submitMyLeadNewFfrm");
			
			console.log("srchTranInfo"+$scope.srchFinInfo);
			$http({
		        method : 'POST',
		        url : 'post/dealerFin/'+$scope.LeadSvDealerId,
				data: $scope.srchFinInfo
		    }).then(function mySuccess(response) {
		    	 alert("Successfully Saved Internal Dealer Lead");
		    	 console.log(response);
		    }, function myError(response) {
		    	alert("Error Successfully Saved Internal Dealer Lead");
		    });
		}
		$scope.submitMyLeadNewIfrm = function() {
			console.log("submitMyLeadNewIfrm");
			console.log("srchTranInfo"+$scope.srchInsInfo);
			$http({
		        method : 'POST',
		        url : 'post/dealerIns/'+$scope.LeadSvDealerId,
				data: $scope.srchInsInfo
		    }).then(function mySuccess(response) {
		    	 alert("Successfully Saved Internal Dealer Lead");
		    	 console.log(response);
		    }, function myError(response) {
		    	alert("Error Successfully Saved Internal Dealer Lead");
		    });
		}
		$scope.submitMyLeadNewTfrm = function() {
			console.log("submitMyLeadNewTfrm");

			console.log("srchTranInfo"+$scope.srchTranInfo);
			$http({
		        method : 'POST',
		        url : 'post/dealerTrans/'+$scope.LeadSvDealerId,
				data: $scope.srchTranInfo
		    }).then(function mySuccess(response) {
		    	 alert("Successfully Saved Internal Dealer Lead");
		    	 console.log(response);
		    }, function myError(response) {
		    	alert("Error Successfully Saved Internal Dealer Lead");
		    });
		}
	 
	 
	 
	// start of insurance
	 $scope.getallDealerIsInfo = function () {
	        alert("start");
	                        var wsURL = 'api/getExtDealInsSt?category='+$scope.categoryInsExtSrh+ '&state=' +$scope.stateInsExtSrh;
	                       
	                $body.addClass("loading");
	                $http({
	                    method: 'GET',
	                    url: wsURL

	                }).success(function (data) {
	                    $body.removeClass("loading");
	                    alert("successfully retrieved"+data.externalDealerVO.length);
	                    out="";

	             	   out += '<tr><th>'+"S.no"+'</th><th>'+"External Dealer ID"+'</th><th>'+"Category"+'</th>'+'<th>'+"CompanyName"+'</th><th>'+"State"+'</th><th>'+"PostCode"+'</th><th>'+"Email"+'</th><th>'+"Phone"+'</th><th>'+"Operation"+'</th></tr>';
	             	   for(i=data.externalDealerVO.length-1;i>=0;i--)
	            		{
	             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	            		 out= out+'<tr>'+'<td>'+i+'</td>'+'<td>'+data.externalDealerVO[i].externalDealerId+'</td>'+'<td>'+data.externalDealerVO[i].category+'<td>'+data.externalDealerVO[i].companyName+'</td>'+'</td>'+'<td>'+data.externalDealerVO[i].state+'</td>'+'<td>'+data.externalDealerVO[i].postCode+'</td>'+'<td>'+data.externalDealerVO[i].email+data.externalDealerVO[i].postCode+data.externalDealerVO[i].phone+data.externalDealerVO[i].website+'</td>'+'<td>'+data.externalDealerVO[i].creationDate+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleExtDealIsModal-' + data.externalDealerVO[i].externalDealerId + '" data-details=\'' + JSON.stringify(data.externalDealerVO[i]) + '\' class="anchor-editDealerssVehicleExtDealIsModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleExtDealIsModal">View</a></td></tr>';

	            		}
	             	   out = out.replace(/>null</g, ">--NA--<");
	             	   out = out.replace(/>undefined</g, ">--NA--<");
	             	   //alert(out);
	             	   var LogSearch = data.externalDealerVO;

	             	   if(LogSearch && data.externalDealerVO.length==0){
	             	   outLogT="";
	             	   outLogT='<h2>No records found</h2>';
	             	   forFinance("car-model-dealerDataIns",outLogT);
	             	   }
	             	   else{
	             	   forFinance("car-model-dealerDataIns",out);}
	             	  registereditDealerssVehicleExtDealIsModal();

	                });

	            }
	// end get all insurance 
	 
	 
	// Insurance lead post
    $scope.getUserInfor = function () {
        //alert("invoke in before call ins lead");
        //alert("invoke in ins firstname"+$scope.firstName+$scope.lastName+$scope.emailId+$scope.creationDate);
                        var jsonInputToAPI = {
                    "firstName": $scope.firstName,
                    "lastName": $scope.lastName,
                    "email": $scope.emailId,
                    "creationDate": $scope.creationDate,
                    "userVO":null
                };

                        var wsURL = 'api/adminuser?firstName='+ $scope.firstName + '&lastName=' +$scope.lastName + '&email=' + $scope.emailId + '&creationDate=' +$scope.creationDate;
                       
             if($scope.creationDate ==="undefined"){
            	 wsURL = 'api/adminuserOtDate?firstName='+ $scope.firstName + '&lastName=' +$scope.lastName + '&email=' + $scope.emailId;
             } 
                //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
                //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
                /* alert(jsonInputToAPI.comingSoonUserEmail);
                alert(jsonInputToAPI.flex1);
                alert(jsonInputToAPI.flex2);
                alert(jsonInputToAPI.flex3); */
                // change here

                $body.addClass("loading");
                $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.userVO.length);
                    out="";

             	   out += '<tr><th>'+"User ID"+'</th><th>'+"First Name"+'</th>'+'<th>'+"Last Name"+'</th><th>'+"Email Id"+'</th><th>'+"Wecome Sent"+'</th><th>'+"Address"+'</th><th>'+"Operation"+'</th></tr>';
             	   for(i=data.userVO.length-1;i>=0;i--)
            		{
             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

            		 out= out+'<tr>'+'<td>'+data.userVO[i].userId+'</td>'+'<td>'+data.userVO[i].firstName+'<td>'+data.userVO[i].lastName+'</td>'+'</td>'+'<td>'+data.userVO[i].email+'</td>'+'<td>'+data.userVO[i].welstatus+'</td>'+'<td>'+data.userVO[i].postCode+'</td>'+'<td><a href="#" id="anchor-editDealerssVehicleSearchModal-' + data.userVO[i].userId + '" data-details=\'' + JSON.stringify(data.userVO[i]) + '\' class="anchor-editDealerssVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerssVehicleSearchModal">View</a></td></tr>';

            		}
             	   out = out.replace(/>null</g, ">--NA--<");
             	   out = out.replace(/>undefined</g, ">--NA--<");
             	   //alert(out);
             	   var LogSearch = data.userVO;

             	   if(LogSearch && data.userVO.length==0){
             	   outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance("car-model-data",outLogT);
             	   }
             	   else{
             	   forFinance("car-model-data",out);}
             	  registerEditDealerssVehicleSearchModal();

                });

            }
           
    // start of external Dealer N U
    function registereditDealerssVehicleExtDealNuModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleExtDealNuModal = '<div class="modal fade" id="editDealerssVehicleExtDealNuModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Dealer Details</center></h4>\
    		        <form id="edit-dealer-nu-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-nu-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleExtDealNuModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleExtDealNuModal);


    	$('a.anchor-editDealerssVehicleExtDealNuModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="externalDealerId" value="' + data.externalDealerId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleExtDealNuModal = '<form id="edit-dealer-nu-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>External Id</td><td>' + data.externalDealerId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>Category</td><td>' + data.category + '</td></tr>\
    			<tr><td>Company Name</td><td>' + data.companyName + '</td></tr>\
    			<tr><td>State</td><td>' + data.state + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>phone</td><td>' + data.phone + '</td></tr>\
    			<tr><td>Address</td><td>' + data.street +  data.suburb +'</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>website</td><td>' + data.website + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleExtDealNuModal = editDealerssVehicleExtDealNuModal.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleExtDealNuModal = editDealerssVehicleExtDealNuModal.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-nu-vehicle-search-content").html(editDealerssVehicleExtDealNuModal);
    	});
    	$('button.submit-editDealerssVehicleExtDealNuModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-nu-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMailExtD",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleExtDealNuModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }
    // end of external Dealer N U
    
    // start of external dealer Serv
    
    function registereditDealerssVehicleExtDealSvModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleExtDealSvModal = '<div class="modal fade" id="editDealerssVehicleExtDealSvModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Dealer Details</center></h4>\
    		        <form id="edit-dealer-sv-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-sv-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleExtDealSvModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleExtDealSvModal);


    	$('a.anchor-editDealerssVehicleExtDealSvModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="externalDealerId" value="' + data.externalDealerId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleExtDealSvModal = '<form id="edit-dealer-sv-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>External Id</td><td>' + data.externalDealerId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>Category</td><td>' + data.category + '</td></tr>\
    			<tr><td>Company Name</td><td>' + data.companyName + '</td></tr>\
    			<tr><td>State</td><td>' + data.state + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>phone</td><td>' + data.phone + '</td></tr>\
    			<tr><td>Address</td><td>' + data.street +  data.suburb +'</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>website</td><td>' + data.website + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleExtDealSvModal = editDealerssVehicleExtDealSvModal.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleExtDealSvModal = editDealerssVehicleExtDealSvModal.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-sv-vehicle-search-content").html(editDealerssVehicleExtDealSvModal);
    	});
    	$('button.submit-editDealerssVehicleExtDealSvModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-sv-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMailExtD",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleExtDealSvModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }
    // end of external dealer Serv
// start of external dealer tranp
   
    function registereditDealerssVehicleExtDealTpModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleExtDealTpModal = '<div class="modal fade" id="editDealerssVehicleExtDealTpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Dealer Details</center></h4>\
    		        <form id="edit-dealer-tp-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-tp-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleExtDealTpModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleExtDealTpModal);


    	$('a.anchor-editDealerssVehicleExtDealSvModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="externalDealerId" value="' + data.externalDealerId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleExtDealTpModal = '<form id="edit-dealer-tp-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>External Id</td><td>' + data.externalDealerId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>Category</td><td>' + data.category + '</td></tr>\
    			<tr><td>Company Name</td><td>' + data.companyName + '</td></tr>\
    			<tr><td>State</td><td>' + data.state + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>phone</td><td>' + data.phone + '</td></tr>\
    			<tr><td>Address</td><td>' + data.street +  data.suburb +'</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>website</td><td>' + data.website + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleExtDealTpModal = editDealerssVehicleExtDealTpModal.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleExtDealTpModal = editDealerssVehicleExtDealTpModal.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-tp-vehicle-search-content").html(editDealerssVehicleExtDealTpModal);
    	});
    	$('button.submit-editDealerssVehicleExtDealTpModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-tp-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMailExtD",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleExtDealTpModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }
 // end of external dealer tranp    
// start of External Dealer Finance
    function registereditDealerssVehicleExtDealFnModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleExtDealFnModal = '<div class="modal fade" id="editDealerssVehicleExtDealFnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Dealer Details</center></h4>\
    		        <form id="edit-dealer-fn-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-fn-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleExtDealFnModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleExtDealFnModal);


    	$('a.anchor-editDealerssVehicleExtDealSvModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="externalDealerId" value="' + data.externalDealerId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleExtDealFnModal = '<form id="edit-dealer-fn-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>External Id</td><td>' + data.externalDealerId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>Category</td><td>' + data.category + '</td></tr>\
    			<tr><td>Company Name</td><td>' + data.companyName + '</td></tr>\
    			<tr><td>State</td><td>' + data.state + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>phone</td><td>' + data.phone + '</td></tr>\
    			<tr><td>Address</td><td>' + data.street +  data.suburb +'</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>website</td><td>' + data.website + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleExtDealFnModal = editDealerssVehicleExtDealFnModal.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleExtDealFnModal = editDealerssVehicleExtDealFnModal.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-fn-vehicle-search-content").html(editDealerssVehicleExtDealFnModal);
    	});
    	$('button.submit-editDealerssVehicleExtDealFnModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-fn-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMailExtD",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleExtDealFnModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }
    // end of External Dealer Finance
// start of External Dealer Insurance

    function registereditDealerssVehicleExtDealIsModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleExtDealIsModal = '<div class="modal fade" id="editDealerssVehicleExtDealIsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Dealer Details</center></h4>\
    		        <form id="edit-dealer-is-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-is-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleExtDealIsModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleExtDealIsModal);


    	$('a.anchor-editDealerssVehicleExtDealSvModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="externalDealerId" value="' + data.externalDealerId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleExtDealIsModal = '<form id="edit-dealer-is-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>External Id</td><td>' + data.externalDealerId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>Category</td><td>' + data.category + '</td></tr>\
    			<tr><td>Company Name</td><td>' + data.companyName + '</td></tr>\
    			<tr><td>State</td><td>' + data.state + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>phone</td><td>' + data.phone + '</td></tr>\
    			<tr><td>Address</td><td>' + data.street +  data.suburb +'</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>website</td><td>' + data.website + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleExtDealIsModal = editDealerssVehicleExtDealIsModal.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleExtDealIsModal = editDealerssVehicleExtDealIsModal.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-is-vehicle-search-content").html(editDealerssVehicleExtDealIsModal);
    	});
    	$('button.submit-editDealerssVehicleExtDealIsModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-is-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMailExtD",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleExtDealIsModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }
 // end of external dealer tranp
    // end of External Dealer Finance

    // end of External Dealer Insurance
    function registerEditDealerssVehicleSearchModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerssVehicleSearchModal = '<div class="modal fade" id="editDealerssVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View User Details</center></h4>\
    		        <form id="edit-dealer-ss-vehicle-search-content-form">\
    				<div class="modal-body edit-dealer-ss-vehicle-search-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<button type="button" class="btn btn-primary submit-editDealerssVehicleSearchModal" data-dismiss="modal">Send Welcome Mail</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerssVehicleSearchModal);


    	$('a.anchor-editDealerssVehicleSearchModal').on('click', function(event) {


    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);
    		var quotIdHiddenField = '<input type="hidden" name="userId" value="' + data.userId + '" />';
    		


    		//alert(JSON.stringify(data)); to work
    		var editDealerssVehicleSearchForm = '<form id="edit-dealer-ss-vehicle-search-content-form"><table>\
    			<table>\
    			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">User Details</div></div>\
    			<tr><td>User ID</td><td>' + data.userId + '</td></tr>\
    			<tr><td>' + quotIdHiddenField + '</td></tr>\
    			<tr><td>firstName</td><td>' + data.firstName + '</td></tr>\
    			<tr><td>lastName</td><td>' + data.lastName + '</td></tr>\
    			<tr><td>email</td><td>' + data.email + '</td></tr>\
    			<tr><td>mobile</td><td>' + data.mobile + '</td></tr>\
    			<tr><td>postCode</td><td>' + data.postCode + '</td></tr>\
    			<tr><td>creationDate</td><td>' + data.creationDate + '</td></tr>\
    			</table></form>';
    		editDealerssVehicleSearchForm = editDealerssVehicleSearchForm.replace(/>null</g, ">--NA--<");
    		editDealerssVehicleSearchForm = editDealerssVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    		$(".edit-dealer-ss-vehicle-search-content").html(editDealerssVehicleSearchForm);
    	});
    	$('button.submit-editDealerssVehicleSearchModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-ss-vehicle-search-content-form").convertFormDataToJSON();
alert("data"+jsonInput);

    		$.ajax({
    			type: "POST",
    			url: "eBid/welcomeMail",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerssVehicleSearchModal-" + result.userId).data('details', result);
    				alert("Successfully Mail Sent....");

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
    function forFinance(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }

    
  // start of S&M all retreived..
    $scope.getsmInforAll = function () {
        
                       var wsURL = 'api/getsmInforAll';
                $scope.flag = "Servicemaintenance";     
                pullDealerIds($scope.flag);
                $body.addClass("loading");
               $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out10="";

 /*	         	   var servRCt = result.length;
 	         	   document.getElementById('servRCt').innerHTML=servRCt;*/
 	         	   out10 += '<tr><th>'+"Operation"+'</th><th>'+"Car Serv Maint ID"+'</th><th>'+"User id"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th></tr>';
 	         	   for(i=data.searchVO.length-1;i>=0;i--)
 	        		{
 	         		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
 	         		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
 	        		out10= out10+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchServMaintId+'</td>'+'<td>'+data.searchVO[i].idp+'</td>'+'<td>'+data.searchVO[i].servMaintL1+'</td>'+'<td>'+data.searchVO[i].servMaintL2+'</td>'+'<td>'+data.searchVO[i].regoState+'</td>'+'</tr>';


 	        		}
 	         	   out10 = out10.replace(/>null</g, ">--NA--<");
 	         	   out10 = out10.replace(/>undefined</g, ">--NA--<");
 	         	  var LogSearchServMaint = data.searchVO;

 	         	 if(LogSearchServMaint && data.searchVO.length==0){
 	         	  outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-Sv-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-Sv-model-data12",out10);}
 	         	registerEditDealerVehicleservmaintModal();
								});

            }
    // end of S&M all retreived..
 /* //invite frm method
	
	$scope.inviteFrmSub = function (isValid){
		if (alreadyLogged()) {
    		if(isValid){
        		$('.loyaStatus1').html('<i class="fa fa-spinner fa-spin" style="font-size:24px;color:green;"></i><span style="font-size:18px;color:green">&nbsp;Submitting,Please wait...<span>');
        		var wsURL = 'api/eBid/sendInviteEmailFrAd';
        		userId=$.jStorage.get('key').userId;
        		firstName=$.jStorage.get('key').firstName;
        		lastName=$.jStorage.get('key').lastName;
        		//alert(userId);
        		var jsonInputToAPI = { "userReferPointId":null,"userId": userId, "fName":firstName, "lName": lastName,"firstName":$scope.inviteFname, "lastName": $scope.inviteLname, "referedEmailId": $scope.inviteEmail};
        		jsonInputToAPI = JSON.stringify(jsonInputToAPI);
        		console.log(JSON.stringify(jsonInputToAPI));
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
	}*/
	
    
    // start of S&M
    $scope.getsmInfor = function () {
        //alert("invoke in before call getEbidInfor lead"+$scope.caryears+$scope.creationDateLd);
    	$scope.flag = "Servicemaintenance";     
        pullDealerIds($scope.flag);
                        var jsonInputToAPI = {
                    "modelYear": $scope.caryears,
                    "modelDisplay": $scope.carmakes,
                    "modelName": $scope.carmodels,
                    "modelTrim": $scope.carmodeltrims,
                    "creationDate": $scope.creationDateLd,
                    "searchVO":null
                };

                       var wsURL = 'api/getSmInfor?modelYear='+ $scope.caryearssm + '&modelDisplay=' +$scope.carmakessm + '&modelName=' + $scope.carmodelssm + '&modelTrim=' + $scope.carmodeltrimssm + '&creationDate=' +$scope.creationDateSv;
                        //alert("value"+$scope.creationDateLd);
                        if($scope.creationDateLd === "undefined"){
                        	 //alert("value"+$scope.creationDateLd);
                        	wsURL = 'api/getSearchInforOtDate?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims;
                        }    
             
                //var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
                //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
                //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
                /* alert(jsonInputToAPI.comingSoonUserEmail);
                alert(jsonInputToAPI.flex1);
                alert(jsonInputToAPI.flex2);
                alert(jsonInputToAPI.flex3); */
                // change here

                $body.addClass("loading");
               $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out10="";

 /*	         	   var servRCt = result.length;
 	         	   document.getElementById('servRCt').innerHTML=servRCt;*/
 	         	   out10 += '<tr><th>'+"Car Serv Maint ID"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th><th>'+"Operation"+'</th></tr>';
 	         	   for(i=data.searchVO.length-1;i>=0;i--)
 	        		{
 	         		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
 	         		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
 	        		out10= out10+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchServMaintId+'</td>'+'<td>'+data.searchVO[i].servMaintL1+'</td>'+'<td>'+data.searchVO[i].servMaintL2+'</td>'+'<td>'+data.searchVO[i].regoState+'</td>'+'</tr>';


 	        		}
 	         	   out10 = out10.replace(/>null</g, ">--NA--<");
 	         	   out10 = out10.replace(/>undefined</g, ">--NA--<");
 	         	  var LogSearchServMaint = data.searchVO;

 	         	 if(LogSearchServMaint && data.searchVO.length==0){
 	         	  outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-Sv-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-Sv-model-data12",out10);}
 	         	registerEditDealerVehicleservmaintModal();
								});

            }

           
    function registerEditDealerVehicleservmaintModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	/*var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Search Details</center></h4>\
    		        <form id="edit-dealer-vehicle-servmaint-content-form">\
    				<div class="modal-body edit-dealer-vehicle-servmaint-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerVehicleservmaintModal);
*/

    	$('a.anchor-editDealerVehicleservmaintModal').on('click', function(event) {

    		$('#car-Sv-model-data12').toggle();
    		$('#fuelCard4124').toggle();
    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);

       		//alert(data);
       		//console.log(data);
    		$scope.srchServnfo = data;
       		$scope.vehicleData = data;
    		var quotIdHiddenField = '<input type="hidden" name="servMaintId" value="' + data.searchServMaintId + '" />';
			/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
			if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';  // come here*/


    		if(data.newer)
    		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    		var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    		if(data.used)
    		  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

    		var editDealerVehicleservmaintForm = '<table>\
    			<tr><th>'+"Serv Ebid ID"+'</th><th>'+'</th><th>'+"Service"+'</th><th>'+"Used"+"Service Maint L1"+'</th><th>'+"Service Maint L2"+'</th>'+'<th>'+"Add Notes"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th></tr>\
    			<tr><td>' + data.searchServMaintId + '</td><td>' + data.lookService + '</td><td>' + '</td><td>' + data.servMaintL1 + '</td><td>' + data.servMaintL2 + '</td><td>' + data.freeText + '</td><td>' + data.make + '</td><td>' + data.model + '</td></tr>\
    			</table>';

    		//alert(JSON.stringify(data)); to work
    		 /*var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
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
				</table></form>';*/
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>null</g, ">--NA--<");
			editDealerVehicleservmaintForm = editDealerVehicleservmaintForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-servmaint-content").html(editDealerVehicleservmaintForm);
			console.log(data);
    		if(data.carSearchId != null){
    			var wsURL = 'api/getDealSearchInfoId?carSearchId='+data.carSearchId ;
      		  	$body.addClass("loading");
        		$.ajax({
    				type: "GET",
    				url: wsURL,
    				success: function(data){
    					$body.removeClass("loading");
    	                  //alert("successfully retrieved");
    	                  out="";
    	                  if(data.dealerSearchVO && data.dealerSearchVO.length!=0)
    	                	  {
    		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
    		   	           	   for(i=0;i<data.dealerSearchVO.length;i++)
    		   	          		{
    		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
    	
    		   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.dealerSearchVO[i].carSearchId+'</td>'+'<td>'+data.dealerSearchVO[i].modelYear+'<td>'+data.dealerSearchVO[i].modelDisplay+'</td>'+'</td>'+'<td>'+data.dealerSearchVO[i].modelName+'</td>'+'<td>'+data.dealerSearchVO[i].modelTrim+'</td></tr>';
    	
    		   	          		}
    	                	  }
    	           	 
    	                  else{
    	           		out='<h2>No records</h2>';
    	           	   }
    	           	
    	           	   out = out.replace(/>null</g, ">--NA--<");
    	           	   out = out.replace(/>undefined</g, ">--NA--<");
    	           	   $("#LeadTable").html(out);

    				}
    			});
    		}
    		
    		
    		
    		
    		//$scope.leadIDs = "";
    		var wsURL = 'api/getExtDealServMtInfoId?searchServMaintId='+data.searchServMaintId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("started retrieved Lead Id"); 
	                  out="";
	                  var options ="";
	                 $("#LeadSvQuoteId").empty();
                  if(data.extDealerSearchVO && data.extDealerSearchVO.length!=0)
                	  {
	                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Lead ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Lead Creation Date"+'</th></tr>';
	                		options += '<option value="" selected disabled>Select a Lead ID</option>';
	                	  for(i=0;i<data.extDealerSearchVO.length;i++)
	   	          		{
	   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.extDealerSearchVO[i].extDealerSearchId+'</td>'+'<td>'+data.extDealerSearchVO[i].dealerId+'<td>'+data.extDealerSearchVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.extDealerSearchVO[i].userid+'</td>'+'<td>'+'<td><a href="#" id="anchor-editlda1DealerVehicleSearchModal-' + data.extDealerSearchVO[i].extDealerSearchId + '" data-details=\'' + JSON.stringify(data.extDealerSearchVO[i]) + '\' class="anchor-editlda1DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editlda1DealerVehicleSearchModal">View</a></td></tr>';
	   	          		// options += '<option>' +data.extDealerSearchVO[i].extDealerSearchId+ '</option>';
	   	          	//alert("insidecssdssretrieved Lead Id"+data.extDealerSearchVO[i].extDealerSearchId); 
	   	          		 options += '<option>' + data.extDealerSearchVO[i].extDealerSearchId + '</option>';
	   	          		}
	   	           	   //$("#LeadQuoteId").html(options);
	                		//alert("options"+options); 
	   	            $("#LeadSvQuoteId").html(options);
                	  }
           	 
                  else{
           		out='<h2>No records</h2>';
           	   }
           	
           	   out = out.replace(/>null</g, ">--NA--<");
           	   out = out.replace(/>undefined</g, ">--NA--<");
           	   $("#LeadSvExtTable").html(out);
	           	registerEditlda1DealerVehicleSearchModal();
				}
			});
    		// start of view of Lead
    		function registerEditlda1DealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editlda1DealerVehicleSearchModal = '<div class="modal fade" id="editlda1DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    			                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Lead Details</center></h4>\
    				        <form id="edit-lda1-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-lda1-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    				<p><center>&copy; 2017 Autoscoop</center></p>\
    					</div>\
    			            </form>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editlda1DealerVehicleSearchModal);


    			$('a.anchor-editlda1DealerVehicleSearchModal').on('click', function(event) {


    				var data = $(event.target).data('details');
    				//var json = JSON.stringify(data);

    				var quotIdHiddenField = '<input type="hidden" name="extDealerSearchId" value="' + data.extDealerSearchId + '" />';
    				var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Pending (Quotation not created)";
    	   	         		if(data.status){status1="Quotation Completed";}

    				//alert(JSON.stringify(data)); to work
    				var editlda1DealerVehicleSearchForm = '<form id="edit-lda1-dealer-vehicle-search-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Details</div></div>\
    					<tr><td>Dealer Lead ID</td><td>' + data.extDealerSearchId + '</td></tr>\
    					<tr><td>' + quotIdHiddenField + '</td></tr>\
    					<tr><td>Status</td><td>' + status1 + '</td></tr>\
    					<tr><td>User Serv Req Id</td><td>' + data.carSearchId + '</td></tr>\
    					<tr><td>Autoscoop User Id</td><td>' + data.userid + '</td></tr>\
    					<tr><td>User Since</td><td>' + data.creationDate + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
    					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
    					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
    					<tr><td>Street</td><td>' + data.street + '</td></tr>\
    					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
    					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
    					<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
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
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Requirement</div></div>\
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
    					<br/>\
    					<br/>\
    					</table></form>';
    				editlda1DealerVehicleSearchForm = editlda1DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editlda1DealerVehicleSearchForm = editlda1DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-lda1-dealer-vehicle-search-content").html(editlda1DealerVehicleSearchForm);
    			});
    			$('button.submit-editlda1DealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-lda1-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");

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
    		// end of view of Lead
    		//$scope.leadIDs = "";
    		//alert("data.searchServMaintId "+data.searchServMaintId );
    		var wsURL = 'api/getExtQtDealSmInfoId?searchServMaintId='+data.searchServMaintId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("inside Service Quotation");
	                  out="";
	                  //var options ;
	                  if(data.serviceMaintQuotationVO && data.serviceMaintQuotationVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Quotation ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Quotation Creation Date"+'</th></tr>';
		   	           	   for(i=0;i<data.serviceMaintQuotationVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td><a href="#" id="anchor-editqta1DealerVehicleSearchModal-' + data.serviceMaintQuotationVO[i].servMaintQuotId + '" data-details=\'' + JSON.stringify(data.serviceMaintQuotationVO[i]) + '\' class="anchor-editqta1DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editqta1DealerVehicleSearchModal">View</a></td>'+'<td>'+data.serviceMaintQuotationVO[i].servMaintQuotId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].dealerId+'<td>'+data.serviceMaintQuotationVO[i].carServMaintId+'</td>'+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].userId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].creationDate+'</tr>';
		   	          		 //options += '<option>' +data.vehicleQuotationVO[i].extDealerSearchId+ '</option>';
		   	          		}
		   	           	   //$("#LeadQuoteId").html(options);
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#QuoteSvTable").html(out);
	           	registerEditqta1DealerVehicleSearchModal();
				}	
			});
    		// start of view of Quotation
    		function registerEditqta1DealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editqta1DealerVehicleSearchModal = '<div class="modal fade" id="editqta1DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    			                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Quotation Details</center></h4>\
    				        <form id="edit-qta1-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-qta1-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    				<p><center>&copy; 2017 Autoscoop</center></p>\
    					</div>\
    			            </form>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editqta1DealerVehicleSearchModal);


    			$('a.anchor-editqta1DealerVehicleSearchModal').on('click', function(event) {


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
    				var quotIdHiddenField = '<input type="hidden" name="servMaintQuotId" value="' + data.servMaintQuotId + '" />';
    				var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Submitted to User for View";
    	   	         		if(data.status){status1="Submitted to User for View";}

    				//alert("vehicle quotation view"+JSON.stringify(data));
    				console.log("Vehicle quotation view"+JSON.stringify(data));
    				var editqta1DealerVehicleSearchForm = '<form id="edit-qta1-dealer-vehicle-search-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
    					<tr><td>Quotation ID</td><td>' + data.servMaintQuotId + '</td></tr>\
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
    				editqta1DealerVehicleSearchForm = editqta1DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editqta1DealerVehicleSearchForm = editqta1DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-qta1-dealer-vehicle-search-content").html(editqta1DealerVehicleSearchForm);
    			});
    			$('button.submit-editqta1DealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-qta1-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");

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
    		// end of view of Lead
    		
    	});
    	
    	
    	/*$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    		$.ajax({
    			type: "POST",
    			url: "api/vehicleSearchQuotation?_method=PUT",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    				alert("Successfully upated the Quotations");

    			}
    		});


    	});*/
    	
    	
    	 $("#BackToVehicles1").click(function(){
		        $('#fuelCard412').hide();
		        //$( "#fuelCard41" ).empty();
		        $('#car-model-data12').show();
		        //document.getElementById("fuelCard41").style.display = "none";
		        //document.getElementById("fuelCard4").style.display = "block";
		        //alert("The paragraph ssswas showed.");
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
    function forFinance1(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }

    // start of Insurance changes
    $scope.getinsInforAll = function () {
        
        var wsURL = 'api/getinsInforAll';
         $scope.flag="Insurance";
         pullDealerIds($scope.flag);
 $body.addClass("loading");
$http({
     method: 'GET',
     url: wsURL

 }).success(function (data) {
     $body.removeClass("loading");
     alert("successfully retrieved"+data.searchVO.length);
     out2="";

/*	         	   var servRCt = result.length;
	   document.getElementById('servRCt').innerHTML=servRCt;*/
	   out2 += '<tr><th>'+"Operation"+'</th><th>'+"Car Ins ID"+'</th><th>'+"User id"+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th></tr>';
	   for(i=data.searchVO.length-1;i>=0;i--)
		{
		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
		out2= out2+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleInsuranceModal-' + data.searchVO[i].searchInsuranceId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleInsuranceModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleInsuranceModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchInsuranceId+'</td>'+'<td>'+data.searchVO[i].idp+'</td>'+'<td>'+data.searchVO[i].insuranceType+'</td>'+'<td>'+data.searchVO[i].marketValue+'</td>'+'<td>'+data.searchVO[i].agreedValue+'</td>'+'</tr>';


		}
	   
	   
	   out2 = out2.replace(/>null</g, ">--NA--<");
	   out2 = out2.replace(/>undefined</g, ">--NA--<");
	  var LogSearchServMaint = data.searchVO;

	 if(LogSearchServMaint && data.searchVO.length==0){
	  outLogT="";
	   outLogT='<h2>No records found</h2>';
	   forFinance1("car-ins-model-data12",outLogT);
	   }
	   else{
	   forFinance1("car-ins-model-data12",out2);
	   
	   
	   }
	 registerEditDealerVehicleInsuranceModal();
					});

}


/*$scope.getsmInfor = function () {
//alert("invoke in before call getEbidInfor lead"+$scope.caryears+$scope.creationDateLd);

         var jsonInputToAPI = {
     "modelYear": $scope.caryears,
     "modelDisplay": $scope.carmakes,
     "modelName": $scope.carmodels,
     "modelTrim": $scope.carmodeltrims,
     "creationDate": $scope.creationDateLd,
     "searchVO":null
 };

        var wsURL = 'api/getSmInfor?modelYear='+ $scope.caryearssm + '&modelDisplay=' +$scope.carmakessm + '&modelName=' + $scope.carmodelssm + '&modelTrim=' + $scope.carmodeltrimssm + '&creationDate=' +$scope.creationDateSv;
         //alert("value"+$scope.creationDateLd);
         if($scope.creationDateLd === "undefined"){
         	 //alert("value"+$scope.creationDateLd);
         	wsURL = 'api/getSearchInforOtDate?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims;
         }    

 //var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
 //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
 //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
  alert(jsonInputToAPI.comingSoonUserEmail);
 alert(jsonInputToAPI.flex1);
 alert(jsonInputToAPI.flex2);
 alert(jsonInputToAPI.flex3); 
 // change here

 $body.addClass("loading");
$http({
     method: 'GET',
     url: wsURL

 }).success(function (data) {
     $body.removeClass("loading");
     alert("successfully retrieved"+data.searchVO.length);
     out10="";

	         	   var servRCt = result.length;
	   document.getElementById('servRCt').innerHTML=servRCt;
	   out10 += '<tr><th>'+"Car Serv Maint ID"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th><th>'+"Operation"+'</th></tr>';
	   for(i=data.searchVO.length-1;i>=0;i--)
		{
		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
		out10= out10+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchServMaintId+'</td>'+'<td>'+data.searchVO[i].servMaintL1+'</td>'+'<td>'+data.searchVO[i].servMaintL2+'</td>'+'<td>'+data.searchVO[i].regoState+'</td>'+'</tr>';


		}
	   out10 = out10.replace(/>null</g, ">--NA--<");
	   out10 = out10.replace(/>undefined</g, ">--NA--<");
	  var LogSearchServMaint = data.searchVO;

	 if(LogSearchServMaint && data.searchVO.length==0){
	  outLogT="";
	   outLogT='<h2>No records found</h2>';
	   forFinance1("car-Sv-model-data12",outLogT);
	   }
	   else{
	   forFinance1("car-Sv-model-data12",out10);}
	registerEditDealerVehicleservmaintModal();
					});

}*/


function registerEditDealerVehicleInsuranceModal(){


//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
/*var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
<div class="modal-dialog">\
 <div class="modal-content">\
     <div class="modal-header">\
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
         <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
     </div>\
		<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Search Details</center></h4>\
     <form id="edit-dealer-vehicle-servmaint-content-form">\
		<div class="modal-body edit-dealer-vehicle-servmaint-content">\
     </div>\
     <div class="modal-footer">\
         <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
<p><center>&copy; 2017 Autoscoop</center></p>\
	</div>\
     </form>\
 </div>\
</div>\
</div>';

$(document.body).append(editDealerVehicleservmaintModal);
*/

$('a.anchor-editDealerVehicleInsuranceModal').on('click', function(event) {

$('#car-ins-model-data12').toggle();
$('#fuelCard41249').toggle();
var data = $(event.target).data('details');
//var json = JSON.stringify(data);

//alert(data);
//console.log(data);
$scope.srchInsInfo = data;
$scope.vehicleData = data;
var quotIdHiddenField = '<input type="hidden" name="searchInsuranceId" value="' + data.searchInsuranceId + '" />';
/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
if(data.newer)
moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
if(data.used)
moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';  // come here*/


if(data.newer)
moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
if(data.used)
moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

var editDealerVehicleInsuranceForm = '<table>\
	<tr><th>'+"Ins Ebid ID"+'</th><th>'+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th></tr>\
	<tr><td>' + data.searchInsuranceId + '</td><td>' + data.insuranceType + '</td><td>' + '</td><td>' + data.marketValue + '</td><td>' + data.agreedValue + '</td></tr>\
	</table>';

//alert(JSON.stringify(data)); to work
/*var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
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
	</table></form>';*/
editDealerVehicleInsuranceForm = editDealerVehicleInsuranceForm.replace(/>null</g, ">--NA--<");
editDealerVehicleInsuranceForm = editDealerVehicleInsuranceForm.replace(/>undefined</g, ">--NA--<");
$(".edit-dealer-vehicle-insurance-content").html(editDealerVehicleInsuranceForm);

var wsURL = 'api/getDealSearchInfoId?carSearchId='+data.carSearchId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("successfully retrieved");
       out="";
       if(data.dealerSearchVO && data.dealerSearchVO.length!=0)
     	  {
         	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
           	   for(i=0;i<data.dealerSearchVO.length;i++)
          		{
           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.dealerSearchVO[i].carSearchId+'</td>'+'<td>'+data.dealerSearchVO[i].modelYear+'<td>'+data.dealerSearchVO[i].modelDisplay+'</td>'+'</td>'+'<td>'+data.dealerSearchVO[i].modelName+'</td>'+'<td>'+data.dealerSearchVO[i].modelTrim+'</td></tr>';

          		}
     	  }
	 
       else{
		out='<h2>No records</h2>';
	   }
	
	   out = out.replace(/>null</g, ">--NA--<");
	   out = out.replace(/>undefined</g, ">--NA--<");
	   $("#LeadTable").html(out);

	}
});



//$scope.leadIDs = "";
var wsURL = 'api/getExtDealInsInfoId?searchInsuranceId='+data.searchInsuranceId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("started retrieved Lead Id"); 
       out="";
       var options ="";
      $("#LeadInsQuoteId").empty();
   if(data.extDealerSearchVO && data.extDealerSearchVO.length!=0)
 	  {
     	  out += '<tr><th>'+"Operation"+'</th><th>'+"Lead ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Lead Creation Date"+'</th></tr>';
     		options += '<option value="" selected disabled>Select a Lead ID</option>';
     	  for(i=0;i<data.extDealerSearchVO.length;i++)
      		{
       		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

      		 out= out+'<tr>'+'<td></td>'+'<td>'+data.extDealerSearchVO[i].extDealerSearchId+'</td>'+'<td>'+data.extDealerSearchVO[i].dealerId+'<td>'+data.extDealerSearchVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.extDealerSearchVO[i].userid+'</td>'+'<td>'+'<td><a href="#" id="anchor-editlda8DealerVehicleSearchModal-' + data.extDealerSearchVO[i].extDealerSearchId + '" data-details=\'' + JSON.stringify(data.extDealerSearchVO[i]) + '\' class="anchor-editlda8DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editlda8DealerVehicleSearchModal">View</a></td></tr>';
      		// options += '<option>' +data.extDealerSearchVO[i].extDealerSearchId+ '</option>';
      	//alert("insidecssdssretrieved Lead Id"+data.extDealerSearchVO[i].extDealerSearchId); 
      		 options += '<option>' + data.extDealerSearchVO[i].extDealerSearchId + '</option>';
      		}
       	   //$("#LeadQuoteId").html(options);
     		//alert("options"+options); 
        $("#LeadInsQuoteId").html(options);
 	  }
 
   else{
	out='<h2>No records</h2>';
   }

   out = out.replace(/>null</g, ">--NA--<");
   out = out.replace(/>undefined</g, ">--NA--<");
   $("#LeadInsExtTable").html(out);
	registerEditlda8DealerVehicleSearchModal();
	}
});
// start of view of Lead
function registerEditlda8DealerVehicleSearchModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editlda8DealerVehicleSearchModal = '<div class="modal fade" id="editlda8DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
	            </div>\
				<h4 class="modal-title" id="myModalLabel"><center>View Lead Details</center></h4>\
		        <form id="edit-lda8-dealer-vehicle-search-content-form">\
				<div class="modal-body edit-lda8-dealer-vehicle-search-content">\
	            </div>\
	            <div class="modal-footer">\
	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
		<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
	            </form>\
	        </div>\
	    </div>\
	</div>';

	$(document.body).append(editlda8DealerVehicleSearchModal);


	$('a.anchor-editlda8DealerVehicleSearchModal').on('click', function(event) {


		var data = $(event.target).data('details');
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="extDealerSearchId" value="' + data.extDealerSearchId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		
		if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
			 status1="Pending (Quotation not created)";
         		if(data.status){status1="Quotation Completed";}
         		
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

		//alert(JSON.stringify(data)); to work
		var editlda8DealerVehicleSearchForm = '<form id="edit-lda8-dealer-vehicle-search-content-form"><table>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Details</div></div>\
			<tr><td>Dealer Lead ID</td><td>' + data.extDealerSearchId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Status</td><td>' + status1 + '</td></tr>\
			<tr><td>User Serv Req Id</td><td>' + data.carSearchId + '</td></tr>\
			<tr><td>Autoscoop User Id</td><td>' + data.userid + '</td></tr>\
			<tr><td>User Since</td><td>' + data.creationDate + '</td></tr>\
			</table>\
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
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
			<tr><td>Category</td><td>' + data.category  + '</td></tr>\
			<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
			<tr><td>Street</td><td>' + data.street + '</td></tr>\
			<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
			<tr><td>State</td><td>' + data.dealState + '</td></tr>\
			<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
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
			</table></form>';
		editlda8DealerVehicleSearchForm = editlda8DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
		editlda8DealerVehicleSearchForm = editlda8DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-lda8-dealer-vehicle-search-content").html(editlda8DealerVehicleSearchForm);
	});
	$('button.submit-editlda8DealerVehicleSearchModal').on('click', function(e) {

		var jsonInput = $("#edit-lda8-dealer-vehicle-Search-content-form").convertFormDataToJSON();


		$.ajax({
			type: "POST",
			url: "api/vehicleSearchQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
				alert("Successfully upated the Quotations");

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
// end of view of Lead
//$scope.leadIDs = "";
//alert("data.searchServMaintId "+data.searchServMaintId );
var wsURL = 'api/getExtQtDealInsInfoId?searchInsuranceId='+data.searchInsuranceId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("inside Service Quotation");
       out="";
       //var options ;
       if(data.serviceMaintQuotationVO && data.serviceMaintQuotationVO.length!=0)
     	  {
         	  out += '<tr><th>'+"Operation"+'</th><th>'+"Quotation ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Quotation Creation Date"+'</th></tr>';
           	   for(i=0;i<data.serviceMaintQuotationVO.length;i++)
          		{
           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.serviceMaintQuotationVO[i].insQuotId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].dealerId+'<td>'+data.serviceMaintQuotationVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].userId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].creationDate+'<td><a href="#" id="anchor-editqta8DealerVehicleSearchModal-' + data.serviceMaintQuotationVO[i].insQuotId + '" data-details=\'' + JSON.stringify(data.serviceMaintQuotationVO[i]) + '\' class="anchor-editqta8DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editqta8DealerVehicleSearchModal">View</a></td></tr>';
          		 //options += '<option>' +data.vehicleQuotationVO[i].extDealerSearchId+ '</option>';
          		}
           	   //$("#LeadQuoteId").html(options);
     	  }
	 
       else{
		out='<h2>No records</h2>';
	   }
	
	   out = out.replace(/>null</g, ">--NA--<");
	   out = out.replace(/>undefined</g, ">--NA--<");
	   $("#QuoteInsTable").html(out);
	registerEditqta8DealerVehicleSearchModal();
	}	
});
// start of view of Quotation
function registerEditqta8DealerVehicleSearchModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editqta8DealerVehicleSearchModal = '<div class="modal fade" id="editqta8DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
	            </div>\
				<h4 class="modal-title" id="myModalLabel"><center>View Quotation Details</center></h4>\
		        <form id="edit-qta8-dealer-vehicle-search-content-form">\
				<div class="modal-body edit-qta8-dealer-vehicle-search-content">\
	            </div>\
	            <div class="modal-footer">\
	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
		<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
	            </form>\
	        </div>\
	    </div>\
	</div>';

	$(document.body).append(editqta8DealerVehicleSearchModal);


	$('a.anchor-editqta8DealerVehicleSearchModal').on('click', function(event) {


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
         		
         		
         		
		//alert("vehicle quotation view"+JSON.stringify(data));
		console.log("Vehicle quotation view"+JSON.stringify(data));
		var editqta8DealerVehicleSearchForm = '<form id="edit-qta8-dealer-vehicle-search-content-form"><table>\
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
		editqta8DealerVehicleSearchForm = editqta8DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
		editqta8DealerVehicleSearchForm = editqta8DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-qta8-dealer-vehicle-search-content").html(editqta8DealerVehicleSearchForm);
	});
	$('button.submit-editqta8DealerVehicleSearchModal').on('click', function(e) {

		var jsonInput = $("#edit-qta8-dealer-vehicle-Search-content-form").convertFormDataToJSON();


		$.ajax({
			type: "POST",
			url: "api/vehicleSearchQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
				alert("Successfully upated the Quotations");

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
// end of view of Lead

});


/*$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


$.ajax({
	type: "POST",
	url: "api/vehicleSearchQuotation?_method=PUT",
	data: jsonInput,
	contentType:'application/json',
	success: function(result){
		$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
		alert("Successfully upated the Quotations");

	}
});


});*/


$("#BackToVehicles1").click(function(){
 $('#fuelCard412').hide();
 //$( "#fuelCard41" ).empty();
 $('#car-model-data12').show();
 //document.getElementById("fuelCard41").style.display = "none";
 //document.getElementById("fuelCard4").style.display = "block";
 //alert("The paragraph ssswas showed.");
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
function forFinance1(model_data_id, out)
{
this.model_data_id = model_data_id;

	   $("#"+model_data_id).html(out);

}

// end of Insurance changes
    
    
    // start of Finance changes
    
    $scope.getfinInforAll = function () {
        
        var wsURL = 'api/getfinInforAll';
         $scope.flag = "Finance";
         pullDealerIds($scope.flag);
 $body.addClass("loading");
$http({
     method: 'GET',
     url: wsURL

 }).success(function (data) {
     $body.removeClass("loading");
     alert("successfully retrieved"+data.searchVO.length);
     out1="";

/*	         	   var servRCt = result.length;
	   document.getElementById('servRCt').innerHTML=servRCt;*/
	   out1 += '<tr><th>'+"Operation"+'</th><th>'+"Car Fin ID"+'</th><th>'+"User id"+'</th><th>'+"Vehicle Value"+'</th><th>'+"Balloon Pay"+'</th><th>'+"Loan Amount"+'</th></tr>';
	   for(i=data.searchVO.length-1;i>=0;i--)
		{
		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
		out1= out1+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleFinanceModal-' + data.searchVO[i].searchFinanceId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleFinanceModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleFinanceModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchFinanceId+'</td>'+'<td>'+data.searchVO[i].idp+'</td>'+'<td>'+data.searchVO[i].vehValue+'</td>'+'<td>'+data.searchVO[i].balloonPay+'</td>'+'<td>'+data.searchVO[i].loanAmount+'</td>'+'</tr>';


		}
	   
	   
	   out1 = out1.replace(/>null</g, ">--NA--<");
	   out1 = out1.replace(/>undefined</g, ">--NA--<");
	  var LogSearchServMaint = data.searchVO;

	 if(LogSearchServMaint && data.searchVO.length==0){
	  outLogT="";
	   outLogT='<h2>No records found</h2>';
	   forFinance1("car-fin-model-data12",outLogT);
	   }
	   else{
	   forFinance1("car-fin-model-data12",out1);
	   
	   
	   }
	 registerEditDealerVehicleFinanceModal();
					});

}


/*$scope.getsmInfor = function () {
//alert("invoke in before call getEbidInfor lead"+$scope.caryears+$scope.creationDateLd);

         var jsonInputToAPI = {
     "modelYear": $scope.caryears,
     "modelDisplay": $scope.carmakes,
     "modelName": $scope.carmodels,
     "modelTrim": $scope.carmodeltrims,
     "creationDate": $scope.creationDateLd,
     "searchVO":null
 };

        var wsURL = 'api/getSmInfor?modelYear='+ $scope.caryearssm + '&modelDisplay=' +$scope.carmakessm + '&modelName=' + $scope.carmodelssm + '&modelTrim=' + $scope.carmodeltrimssm + '&creationDate=' +$scope.creationDateSv;
         //alert("value"+$scope.creationDateLd);
         if($scope.creationDateLd === "undefined"){
         	 //alert("value"+$scope.creationDateLd);
         	wsURL = 'api/getSearchInforOtDate?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims;
         }    

 //var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
 //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
 //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
  alert(jsonInputToAPI.comingSoonUserEmail);
 alert(jsonInputToAPI.flex1);
 alert(jsonInputToAPI.flex2);
 alert(jsonInputToAPI.flex3); 
 // change here

 $body.addClass("loading");
$http({
     method: 'GET',
     url: wsURL

 }).success(function (data) {
     $body.removeClass("loading");
     alert("successfully retrieved"+data.searchVO.length);
     out10="";

	         	   var servRCt = result.length;
	   document.getElementById('servRCt').innerHTML=servRCt;
	   out10 += '<tr><th>'+"Car Serv Maint ID"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th><th>'+"Operation"+'</th></tr>';
	   for(i=data.searchVO.length-1;i>=0;i--)
		{
		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
		out10= out10+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchServMaintId+'</td>'+'<td>'+data.searchVO[i].servMaintL1+'</td>'+'<td>'+data.searchVO[i].servMaintL2+'</td>'+'<td>'+data.searchVO[i].regoState+'</td>'+'</tr>';


		}
	   out10 = out10.replace(/>null</g, ">--NA--<");
	   out10 = out10.replace(/>undefined</g, ">--NA--<");
	  var LogSearchServMaint = data.searchVO;

	 if(LogSearchServMaint && data.searchVO.length==0){
	  outLogT="";
	   outLogT='<h2>No records found</h2>';
	   forFinance1("car-Sv-model-data12",outLogT);
	   }
	   else{
	   forFinance1("car-Sv-model-data12",out10);}
	registerEditDealerVehicleservmaintModal();
					});

}*/


function registerEditDealerVehicleFinanceModal(){


//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
/*var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
<div class="modal-dialog">\
 <div class="modal-content">\
     <div class="modal-header">\
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
         <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
     </div>\
		<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Search Details</center></h4>\
     <form id="edit-dealer-vehicle-servmaint-content-form">\
		<div class="modal-body edit-dealer-vehicle-servmaint-content">\
     </div>\
     <div class="modal-footer">\
         <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
<p><center>&copy; 2017 Autoscoop</center></p>\
	</div>\
     </form>\
 </div>\
</div>\
</div>';

$(document.body).append(editDealerVehicleservmaintModal);
*/

$('a.anchor-editDealerVehicleFinanceModal').on('click', function(event) {

$('#car-fin-model-data12').toggle();
$('#fuelCard41248').toggle();
var data = $(event.target).data('details');
//var json = JSON.stringify(data);

//alert(data);
//console.log(data);
$scope.srchFinInfo = data;
$scope.vehicleData = data;
var quotIdHiddenField = '<input type="hidden" name="searchFinanceId" value="' + data.searchFinanceId + '" />';
/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
if(data.newer)
moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
if(data.used)
moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';  // come here*/


if(data.newer)
moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
if(data.used)
moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

var editDealerVehicleFinanceForm = '<table>\
	<tr><th>'+"Fin Ebid ID"+'</th><th>'+'</th><th>'+"Rego No"+'</th><th>'+"Rego State"+'</th><th>'+"Post Code"+'</th></tr>\
	<tr><td>' + data.searchFinanceId + '</td><td>' + data.rego + '</td><td>' + '</td><td>' + data.regoState + '</td><td>' + data.postCode + '</td></tr>\
	</table>';

//alert(JSON.stringify(data)); to work
/*var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
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
	</table></form>';*/
editDealerVehicleFinanceForm = editDealerVehicleFinanceForm.replace(/>null</g, ">--NA--<");
editDealerVehicleFinanceForm = editDealerVehicleFinanceForm.replace(/>undefined</g, ">--NA--<");
$(".edit-dealer-vehicle-finance-content").html(editDealerVehicleFinanceForm);

var wsURL = 'api/getDealSearchInfoId?carSearchId='+data.carSearchId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("successfully retrieved");
       out="";
       if(data.dealerSearchVO && data.dealerSearchVO.length!=0)
     	  {
         	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
           	   for(i=0;i<data.dealerSearchVO.length;i++)
          		{
           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.dealerSearchVO[i].carSearchId+'</td>'+'<td>'+data.dealerSearchVO[i].modelYear+'<td>'+data.dealerSearchVO[i].modelDisplay+'</td>'+'</td>'+'<td>'+data.dealerSearchVO[i].modelName+'</td>'+'<td>'+data.dealerSearchVO[i].modelTrim+'</td></tr>';

          		}
     	  }
	 
       else{
		out='<h2>No records</h2>';
	   }
	
	   out = out.replace(/>null</g, ">--NA--<");
	   out = out.replace(/>undefined</g, ">--NA--<");
	   $("#LeadTable").html(out);

	}
});



//$scope.leadIDs = "";
var wsURL = 'api/getExtDealFinInfoId?searchFinanceId='+data.searchFinanceId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("started retrieved Lead Id"); 
       out="";
       var options ="";
      $("#LeadFinQuoteId").empty();
   if(data.extDealerSearchVO && data.extDealerSearchVO.length!=0)
 	  {
     	  out += '<tr><th>'+"Operation"+'</th><th>'+"Lead ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Lead Creation Date"+'</th></tr>';
     		options += '<option value="" selected disabled>Select a Lead ID</option>';
     	  for(i=0;i<data.extDealerSearchVO.length;i++)
      		{
       		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

      		 out= out+'<tr>'+'<td></td>'+'<td>'+data.extDealerSearchVO[i].extDealerSearchId+'</td>'+'<td>'+data.extDealerSearchVO[i].dealerId+'<td>'+data.extDealerSearchVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.extDealerSearchVO[i].userid+'</td>'+'<td>'+'<td><a href="#" id="anchor-editlda4DealerVehicleSearchModal-' + data.extDealerSearchVO[i].extDealerSearchId + '" data-details=\'' + JSON.stringify(data.extDealerSearchVO[i]) + '\' class="anchor-editlda4DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editlda4DealerVehicleSearchModal">View</a></td></tr>';
      		// options += '<option>' +data.extDealerSearchVO[i].extDealerSearchId+ '</option>';
      	//alert("insidecssdssretrieved Lead Id"+data.extDealerSearchVO[i].extDealerSearchId); 
      		 options += '<option>' + data.extDealerSearchVO[i].extDealerSearchId + '</option>';
      		}
       	   //$("#LeadQuoteId").html(options);
     		//alert("options"+options); 
        $("#LeadFinQuoteId").html(options);
 	  }
 
   else{
	out='<h2>No records</h2>';
   }

   out = out.replace(/>null</g, ">--NA--<");
   out = out.replace(/>undefined</g, ">--NA--<");
   $("#LeadFinExtTable").html(out);
	registerEditlda4DealerVehicleSearchModal();
	}
});
// start of view of Lead
function registerEditlda4DealerVehicleSearchModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editlda4DealerVehicleSearchModal = '<div class="modal fade" id="editlda4DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
	            </div>\
				<h4 class="modal-title" id="myModalLabel"><center>View Lead Details</center></h4>\
		        <form id="edit-lda4-dealer-vehicle-search-content-form">\
				<div class="modal-body edit-lda4-dealer-vehicle-search-content">\
	            </div>\
	            <div class="modal-footer">\
	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
		<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
	            </form>\
	        </div>\
	    </div>\
	</div>';

	$(document.body).append(editlda4DealerVehicleSearchModal);


	$('a.anchor-editlda4DealerVehicleSearchModal').on('click', function(event) {


		var data = $(event.target).data('details');
		//var json = JSON.stringify(data);

		var quotIdHiddenField = '<input type="hidden" name="extDealerSearchId" value="' + data.extDealerSearchId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		
		if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
			 status1="Pending (Quotation not created)";
         		if(data.status){status1="Quotation Completed";}

		//alert(JSON.stringify(data)); to work
		var editlda4DealerVehicleSearchForm = '<form id="edit-lda4-dealer-vehicle-search-content-form"><table>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Details</div></div>\
			<tr><td>Dealer Lead ID</td><td>' + data.extDealerSearchId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Status</td><td>' + status1 + '</td></tr>\
			<tr><td>User Serv Req Id</td><td>' + data.carSearchId + '</td></tr>\
			<tr><td>Autoscoop User Id</td><td>' + data.userid + '</td></tr>\
			<tr><td>User Since</td><td>' + data.creationDate + '</td></tr>\
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
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
			<tr><td>Category</td><td>' + data.category  + '</td></tr>\
			<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
			<tr><td>Street</td><td>' + data.street + '</td></tr>\
			<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
			<tr><td>State</td><td>' + data.dealState + '</td></tr>\
			<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
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
			</table></form>';
		editlda4DealerVehicleSearchForm = editlda4DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
		editlda4DealerVehicleSearchForm = editlda4DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-lda4-dealer-vehicle-search-content").html(editlda4DealerVehicleSearchForm);
	});
	$('button.submit-editlda4DealerVehicleSearchModal').on('click', function(e) {

		var jsonInput = $("#edit-lda4-dealer-vehicle-Search-content-form").convertFormDataToJSON();


		$.ajax({
			type: "POST",
			url: "api/vehicleSearchQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
				alert("Successfully upated the Quotations");

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
// end of view of Lead
//$scope.leadIDs = "";
//alert("data.searchServMaintId "+data.searchServMaintId );
var wsURL = 'api/getExtQtDealFinInfoId?searchFinanceId='+data.searchFinanceId ;
	$body.addClass("loading");
$.ajax({
	type: "GET",
	url: wsURL,
	success: function(data){
		$body.removeClass("loading");
       //alert("inside Service Quotation");
       out="";
       //var options ;
       if(data.serviceMaintQuotationVO && data.serviceMaintQuotationVO.length!=0)
     	  {
         	  out += '<tr><th>'+"Operation"+'</th><th>'+"Quotation ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Quotation Creation Date"+'</th></tr>';
           	   for(i=0;i<data.serviceMaintQuotationVO.length;i++)
          		{
           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.serviceMaintQuotationVO[i].finQuotId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].dealerId+'<td>'+data.serviceMaintQuotationVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].userId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].creationDate+'<td><a href="#" id="anchor-editqta4DealerVehicleSearchModal-' + data.serviceMaintQuotationVO[i].finQuotId + '" data-details=\'' + JSON.stringify(data.serviceMaintQuotationVO[i]) + '\' class="anchor-editqta4DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editqta4DealerVehicleSearchModal">View</a></td></tr>';
          		 //options += '<option>' +data.vehicleQuotationVO[i].extDealerSearchId+ '</option>';
          		}
           	   //$("#LeadQuoteId").html(options);
     	  }
	 
       else{
		out='<h2>No records</h2>';
	   }
	
	   out = out.replace(/>null</g, ">--NA--<");
	   out = out.replace(/>undefined</g, ">--NA--<");
	   $("#QuoteFinTable").html(out);
	registerEditqta4DealerVehicleSearchModal();
	}	
});
// start of view of Quotation
function registerEditqta4DealerVehicleSearchModal(){


	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	var editqta4DealerVehicleSearchModal = '<div class="modal fade" id="editqta4DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
	    <div class="modal-dialog">\
	        <div class="modal-content">\
	            <div class="modal-header">\
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
	            </div>\
				<h4 class="modal-title" id="myModalLabel"><center>View Quotation Details</center></h4>\
		        <form id="edit-qta4-dealer-vehicle-search-content-form">\
				<div class="modal-body edit-qta4-dealer-vehicle-search-content">\
	            </div>\
	            <div class="modal-footer">\
	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
		<p><center>&copy; 2017 Autoscoop</center></p>\
			</div>\
	            </form>\
	        </div>\
	    </div>\
	</div>';

	$(document.body).append(editqta4DealerVehicleSearchModal);


	$('a.anchor-editqta4DealerVehicleSearchModal').on('click', function(event) {


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
		var quotIdHiddenField = '<input type="hidden" name="finQuotId" value="' + data.finQuotId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />';
		
		if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
			 status1="Submitted to User for View";
         		if(data.status){status1="Submitted to User for View";}

		//alert("vehicle quotation view"+JSON.stringify(data));
		console.log("Vehicle quotation view"+JSON.stringify(data));
		var editqta4DealerVehicleSearchForm = '<form id="edit-qta4-dealer-vehicle-search-content-form"><table>\
			<table>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Quotation Details</div></div>\
			<tr><td>Quotation ID</td><td>' + data.finQuotId + '</td></tr>\
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
			<tr><td>Rego No</td><td>' + data.rego + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
			</table>\
			<br/>\
			<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Vehicle Details</div></div>\
			<table>\
			<tr><td>Year</td><td>' + data.modelYear + '</td></tr>\
			<tr><td>Make</td><td>' + data.modelDisplay + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.modelName + '</td></tr>\
			<tr><td>Autoscoop Trim</td><td>' + data.modelTrim + '</td></tr>\
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
		editqta4DealerVehicleSearchForm = editqta4DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
		editqta4DealerVehicleSearchForm = editqta4DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
		$(".edit-qta4-dealer-vehicle-search-content").html(editqta4DealerVehicleSearchForm);
	});
	$('button.submit-editqta4DealerVehicleSearchModal').on('click', function(e) {

		var jsonInput = $("#edit-qta4-dealer-vehicle-Search-content-form").convertFormDataToJSON();


		$.ajax({
			type: "POST",
			url: "api/vehicleSearchQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
				alert("Successfully upated the Quotations");

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
// end of view of Lead

});


/*$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


$.ajax({
	type: "POST",
	url: "api/vehicleSearchQuotation?_method=PUT",
	data: jsonInput,
	contentType:'application/json',
	success: function(result){
		$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
		alert("Successfully upated the Quotations");

	}
});


});*/


$("#BackToVehicles1").click(function(){
 $('#fuelCard412').hide();
 //$( "#fuelCard41" ).empty();
 $('#car-model-data12').show();
 //document.getElementById("fuelCard41").style.display = "none";
 //document.getElementById("fuelCard4").style.display = "block";
 //alert("The paragraph ssswas showed.");
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
function forFinance1(model_data_id, out)
{
this.model_data_id = model_data_id;

	   $("#"+model_data_id).html(out);

}


    // end of Finance changes
    
    

    // start of Transport changes
 // start of S&M all retreived..
    $scope.gettpInforAll = function () {
        
                       var wsURL = 'api/gettpInforAll';
                        $scope.flag = "Transport";
                        pullDealerIds($scope.flag);
                $body.addClass("loading");
               $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out11="";

 /*	         	   var servRCt = result.length;
 	         	   document.getElementById('servRCt').innerHTML=servRCt;*/
 	         	   out11 += '<tr><th>'+"Operation"+'</th><th>'+"Car Trans ID"+'</th><th>'+"User id"+'</th><th>'+"pickUpDateTime"+'</th><th>'+"noOfCars"+'</th><th>'+"fromPostCodeAddr"+'</th></tr>';
 	         	   for(i=data.searchVO.length-1;i>=0;i--)
 	        		{
 	         		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
 	         		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
 	        		out11= out11+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicletranspModal-' + data.searchVO[i].searchTranspId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicletranspModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicletranspModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchTranspId+'</td>'+'<td>'+data.searchVO[i].idp+'</td>'+'<td>'+data.searchVO[i].pickUpDateTime+'</td>'+'<td>'+data.searchVO[i].noOfCars+'</td>'+'<td>'+data.searchVO[i].fromPostCodeAddr+'</td>'+'</tr>';


 	        		}
 	         	   out11 = out11.replace(/>null</g, ">--NA--<");
 	         	   out11 = out11.replace(/>undefined</g, ">--NA--<");
 	         	  var LogSearchServMaint = data.searchVO;

 	         	 if(LogSearchServMaint && data.searchVO.length==0){
 	         	  outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-Tp-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-Tp-model-data12",out11);
             	   
             	   
             	   }
 	         	registerEditDealerVehicletranspModal();
								});

            }
    
/*
    $scope.getsmInfor = function () {
        //alert("invoke in before call getEbidInfor lead"+$scope.caryears+$scope.creationDateLd);
      
                        var jsonInputToAPI = {
                    "modelYear": $scope.caryears,
                    "modelDisplay": $scope.carmakes,
                    "modelName": $scope.carmodels,
                    "modelTrim": $scope.carmodeltrims,
                    "creationDate": $scope.creationDateLd,
                    "searchVO":null
                };

                       var wsURL = 'api/getSmInfor?modelYear='+ $scope.caryearssm + '&modelDisplay=' +$scope.carmakessm + '&modelName=' + $scope.carmodelssm + '&modelTrim=' + $scope.carmodeltrimssm + '&creationDate=' +$scope.creationDateSv;
                        //alert("value"+$scope.creationDateLd);
                        if($scope.creationDateLd === "undefined"){
                        	 //alert("value"+$scope.creationDateLd);
                        	wsURL = 'api/getSearchInforOtDate?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims;
                        }    
             
                //var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
                //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
                //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
                 alert(jsonInputToAPI.comingSoonUserEmail);
                alert(jsonInputToAPI.flex1);
                alert(jsonInputToAPI.flex2);
                alert(jsonInputToAPI.flex3); 
                // change here

                $body.addClass("loading");
               $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out10="";

 	         	   var servRCt = result.length;
 	         	   document.getElementById('servRCt').innerHTML=servRCt;
 	         	   out10 += '<tr><th>'+"Car Serv Maint ID"+'</th><th>'+"Servic L1"+'</th><th>'+"Service L2"+'</th><th>'+"Rego State"+'</th><th>'+"Operation"+'</th></tr>';
 	         	   for(i=data.searchVO.length-1;i>=0;i--)
 	        		{
 	         		   //+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">View</a></td>
 	         		 //out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+
 	        		out10= out10+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleservmaintModal-' + data.searchVO[i].searchServMaintId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleservmaintModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleservmaintModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].searchServMaintId+'</td>'+'<td>'+data.searchVO[i].servMaintL1+'</td>'+'<td>'+data.searchVO[i].servMaintL2+'</td>'+'<td>'+data.searchVO[i].regoState+'</td>'+'</tr>';


 	        		}
 	         	   out10 = out10.replace(/>null</g, ">--NA--<");
 	         	   out10 = out10.replace(/>undefined</g, ">--NA--<");
 	         	  var LogSearchServMaint = data.searchVO;

 	         	 if(LogSearchServMaint && data.searchVO.length==0){
 	         	  outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-Sv-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-Sv-model-data12",out10);}
 	         	registerEditDealerVehicleservmaintModal();
								});

            }*/

           
    function registerEditDealerVehicletranspModal(){


    	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	/*var editDealerVehicleservmaintModal = '<div class="modal fade" id="editDealerVehicleservmaintModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    	            </div>\
    				<h4 class="modal-title" id="myModalLabel"><center>View Vehicle Search Details</center></h4>\
    		        <form id="edit-dealer-vehicle-servmaint-content-form">\
    				<div class="modal-body edit-dealer-vehicle-servmaint-content">\
    	            </div>\
    	            <div class="modal-footer">\
    	                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    		<p><center>&copy; 2017 Autoscoop</center></p>\
    			</div>\
    	            </form>\
    	        </div>\
    	    </div>\
    	</div>';

    	$(document.body).append(editDealerVehicleservmaintModal);
*/

    	$('a.anchor-editDealerVehicletranspModal').on('click', function(event) {

    		$('#car-Tp-model-data12').toggle();
    		$('#fuelCard41246').toggle();
    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);

       		//alert(data);
       		//console.log(data);
    		$scope.srchTranInfo = data;
       		$scope.vehicleData = data;
    		var quotIdHiddenField = '<input type="hidden" name="searchTranspId" value="' + data.searchTranspId + '" />';
			/*var moveToUser = '<input type="checkbox" name="moveToUser" />';
			if(data.newer)
			  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
			var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
			if(data.used)
			  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';  // come here*/


    		if(data.newer)
    		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    		var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    		if(data.used)
    		  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';

    		var editDealerVehicletranspForm = '<table>\
    			<tr><th>'+"Transp Ebid ID"+'</th><th>'+'</th><th>'+"PickupDate"+'</th><th>'+"noOfCars"+'</th><th>'+"frompostcodeaddress"+'</th></tr>\
    			<tr><td>' + data.searchTranspId + '</td><td>' + data.pickUpDateTime + '</td><td>' + '</td><td>' + data.noOfCars + '</td><td>' + data.fromPostCodeAddr + '</td></tr>\
    			</table>';

    		//alert(JSON.stringify(data)); to work
    		 /*var editDealerVehicleservmaintForm = '<form id="edit-dealer-vehicle-servmaint-content-form">\
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
				</table></form>';*/
    		editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>null</g, ">--NA--<");
			editDealerVehicletranspForm = editDealerVehicletranspForm.replace(/>undefined</g, ">--NA--<");
			$(".edit-dealer-vehicle-transp-content").html(editDealerVehicletranspForm);
    		
    		var wsURL = 'api/getDealSearchInfoId?carSearchId='+data.carSearchId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("successfully retrieved");
	                  out="";
	                  if(data.dealerSearchVO && data.dealerSearchVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
		   	           	   for(i=0;i<data.dealerSearchVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.dealerSearchVO[i].carSearchId+'</td>'+'<td>'+data.dealerSearchVO[i].modelYear+'<td>'+data.dealerSearchVO[i].modelDisplay+'</td>'+'</td>'+'<td>'+data.dealerSearchVO[i].modelName+'</td>'+'<td>'+data.dealerSearchVO[i].modelTrim+'</td></tr>';
	
		   	          		}
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#LeadTable").html(out);

				}
			});
    		
    		
    		
    		//$scope.leadIDs = "";
    		var wsURL = 'api/getExtDealTrnpInfoId?searchTranspId='+data.searchTranspId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("started retrieved Lead Id"); 
	                  out="";
	                  var options ="";
	                 $("#LeadTpQuoteId").empty();
                  if(data.extDealerSearchVO && data.extDealerSearchVO.length!=0)
                	  {
	                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Lead ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Lead Creation Date"+'</th></tr>';
	                		options += '<option value="" selected disabled>Select a Lead ID</option>';
	                	  for(i=0;i<data.extDealerSearchVO.length;i++)
	   	          		{
	   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

	   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.extDealerSearchVO[i].extDealerSearchId+'</td>'+'<td>'+data.extDealerSearchVO[i].dealerId+'<td>'+data.extDealerSearchVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.extDealerSearchVO[i].userid+'</td>'+'<td>'+'<td><a href="#" id="anchor-editlda2DealerVehicleSearchModal-' + data.extDealerSearchVO[i].extDealerSearchId + '" data-details=\'' + JSON.stringify(data.extDealerSearchVO[i]) + '\' class="anchor-editlda2DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editlda2DealerVehicleSearchModal">View</a></td></tr>';
	   	          		// options += '<option>' +data.extDealerSearchVO[i].extDealerSearchId+ '</option>';
	   	          	//alert("insidecssdssretrieved Lead Id"+data.extDealerSearchVO[i].extDealerSearchId); 
	   	          		 options += '<option>' + data.extDealerSearchVO[i].extDealerSearchId + '</option>';
	   	          		}
	   	           	   //$("#LeadQuoteId").html(options);
	                		//alert("options"+options); 
	   	            $("#LeadTpQuoteId").html(options);
                	  }
           	 
                  else{
           		out='<h2>No records</h2>';
           	   }
           	
           	   out = out.replace(/>null</g, ">--NA--<");
           	   out = out.replace(/>undefined</g, ">--NA--<");
           	   $("#LeadTpExtTable").html(out);
	           	registerEditlda2DealerVehicleSearchModal();
				}
			});
    		// start of view of Lead
    		function registerEditlda2DealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editlda2DealerVehicleSearchModal = '<div class="modal fade" id="editlda2DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    			                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Lead Details</center></h4>\
    				        <form id="edit-lda2-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-lda2-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    				<p><center>&copy; 2017 Autoscoop</center></p>\
    					</div>\
    			            </form>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editlda2DealerVehicleSearchModal);


    			$('a.anchor-editlda2DealerVehicleSearchModal').on('click', function(event) {


    				var data = $(event.target).data('details');
    				//var json = JSON.stringify(data);

    				var quotIdHiddenField = '<input type="hidden" name="extDealerSearchId" value="' + data.extDealerSearchId + '" />';
    				var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Pending (Quotation not created)";
    	   	         		if(data.status){status1="Quotation Completed";}

    				//alert(JSON.stringify(data)); to work
    				var editlda2DealerVehicleSearchForm = '<form id="edit-lda2-dealer-vehicle-search-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Details</div></div>\
    					<tr><td>Dealer Lead ID</td><td>' + data.extDealerSearchId + '</td></tr>\
    					<tr><td>' + quotIdHiddenField + '</td></tr>\
    					<tr><td>Status</td><td>' + status1 + '</td></tr>\
    					<tr><td>User Serv Req Id</td><td>' + data.carSearchId + '</td></tr>\
    					<tr><td>Autoscoop User Id</td><td>' + data.userid + '</td></tr>\
    					<tr><td>User Since</td><td>' + data.creationDate + '</td></tr>\
    					</table>\
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
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
    					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
    					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
    					<tr><td>Street</td><td>' + data.street + '</td></tr>\
    					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
    					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
    					<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
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
    					</table></form>';
    				editlda2DealerVehicleSearchForm = editlda2DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editlda2DealerVehicleSearchForm = editlda2DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-lda2-dealer-vehicle-search-content").html(editlda2DealerVehicleSearchForm);
    			});
    			$('button.submit-editlda2DealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-lda2-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");

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
    		// end of view of Lead
    		//$scope.leadIDs = "";
    		//alert("data.searchServMaintId "+data.searchServMaintId );
    		var wsURL = 'api/getExtQtDealTpInfoId?searchTranpsId='+data.searchTranspId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("inside Service Quotation");
	                  out="";
	                  //var options ;
	                  if(data.serviceMaintQuotationVO && data.serviceMaintQuotationVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Quotation ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Quotation Creation Date"+'</th></tr>';
		   	           	   for(i=0;i<data.serviceMaintQuotationVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.serviceMaintQuotationVO[i].transpServQuotId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].dealerId+'<td>'+data.serviceMaintQuotationVO[i].userTranspServId+'</td>'+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].userId+'</td>'+'<td>'+data.serviceMaintQuotationVO[i].creationDate+'<td><a href="#" id="anchor-editqta2DealerVehicleSearchModal-' + data.serviceMaintQuotationVO[i].transpServQuotId + '" data-details=\'' + JSON.stringify(data.serviceMaintQuotationVO[i]) + '\' class="anchor-editqta2DealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editqta2DealerVehicleSearchModal">View</a></td></tr>';
		   	          		 //options += '<option>' +data.vehicleQuotationVO[i].extDealerSearchId+ '</option>';
		   	          		}
		   	           	   //$("#LeadQuoteId").html(options);
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#QuoteTpTable").html(out);
	           	registerEditqta2DealerVehicleSearchModal();
				}	
			});
    		// start of view of Quotation
    		function registerEditqta2DealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editqta2DealerVehicleSearchModal = '<div class="modal fade" id="editqta2DealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    			                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Quotation Details</center></h4>\
    				        <form id="edit-qta2-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-qta2-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    				<p><center>&copy; 2017 Autoscoop</center></p>\
    					</div>\
    			            </form>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editqta2DealerVehicleSearchModal);


    			$('a.anchor-editqta2DealerVehicleSearchModal').on('click', function(event) {


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
    				var quotIdHiddenField = '<input type="hidden" name="transpServQuotId" value="' + data.transpServQuotId + '" />';
    				var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Submitted to User for View";
    	   	         		if(data.status){status1="Submitted to User for View";}

    				//alert("vehicle quotation view"+JSON.stringify(data));
    				console.log("Vehicle quotation view"+JSON.stringify(data));
    				var editqta2DealerVehicleSearchForm = '<form id="edit-qta2-dealer-vehicle-search-content-form"><table>\
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
    				editqta2DealerVehicleSearchForm = editqta2DealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editqta2DealerVehicleSearchForm = editqta2DealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-qta2-dealer-vehicle-search-content").html(editqta2DealerVehicleSearchForm);
    			});
    			$('button.submit-editqta2DealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-qta2-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");

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
    		// end of view of Lead
    		
    	});
    	
    	
    	/*$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    		$.ajax({
    			type: "POST",
    			url: "api/vehicleSearchQuotation?_method=PUT",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    				alert("Successfully upated the Quotations");

    			}
    		});


    	});*/
    	
    	
    	 $("#BackToVehicles1").click(function(){
		        $('#fuelCard412').hide();
		        //$( "#fuelCard41" ).empty();
		        $('#car-model-data12').show();
		        //document.getElementById("fuelCard41").style.display = "none";
		        //document.getElementById("fuelCard4").style.display = "block";
		        //alert("The paragraph ssswas showed.");
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
    function forFinance1(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }

    // end of Transport changes
    
    
    
    
    
    // get all Ebid requests start
    $scope.getAllEbidInfor = function () {
        
                        var wsURL = 'api/getSearchInforAll';
                        $scope.flag = "SellVehicle";     
                        pullDealerIds($scope.flag);
                $body.addClass("loading");
                $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out="";

             	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"User Id"+'</th><th>'+"Post Code"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Trim"+'</th></tr>';
             	   for(i=data.searchVO.length-1;i>=0;i--)
            		{
             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

            		 out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + data.searchVO[i].carSearchId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].carSearchId+'</td>'+'<td>'+data.searchVO[i].userid+'<td>'+data.searchVO[i].postCode+'</td>'+data.searchVO[i].modelYear+'<td>'+data.searchVO[i].modelDisplay+'</td>'+'<td>'+data.searchVO[i].modelName+'</td>'+'<td>'+data.searchVO[i].modelTrim+'</td></tr>';

            		}
             	   out = out.replace(/>null</g, ">--NA--<");
             	   out = out.replace(/>undefined</g, ">--NA--<");
             	   //alert(out);
             	   var LogSearch = data.searchVO;


             	   if(LogSearch && data.searchVO.length==0){
             	   outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-model-data12",out);}
             	  registerEditDealerVehicleSearchModal();

                });

            }
    // get all Ebid requests end
    
    
    
    // end of S&M    
 // User Search lead start
    $scope.getEbidInfor = function () {
        //alert("invoke in before call getEbidInfor lead"+$scope.caryears+$scope.creationDateLd);
      
                        var jsonInputToAPI = {
                    "modelYear": $scope.caryears,
                    "modelDisplay": $scope.carmakes,
                    "modelName": $scope.carmodels,
                    "modelTrim": $scope.carmodeltrims,
                    "creationDate": $scope.creationDateLd,
                    "searchVO":null
                };

                        var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
                        //alert("value"+$scope.creationDateLd);
                        if($scope.creationDateLd === "undefined"){
                        	 //alert("value"+$scope.creationDateLd);
                        	wsURL = 'api/getSearchInforOtDate?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims;
                        }    
             
                //var wsURL = 'api/getSearchInfor?modelYear='+ $scope.caryears + '&modelDisplay=' +$scope.carmakes + '&modelName=' + $scope.carmodels + '&modelTrim=' + $scope.carmodeltrims + '&creationDate=' +$scope.creationDateLd;
                //var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/insurance';
                //var wsURL = 'http://www.autoscoop.com.au/api/eBid/insurance';
                /* alert(jsonInputToAPI.comingSoonUserEmail);
                alert(jsonInputToAPI.flex1);
                alert(jsonInputToAPI.flex2);
                alert(jsonInputToAPI.flex3); */
                // change here

                $body.addClass("loading");
                $http({
                    method: 'GET',
                    url: wsURL

                }).success(function (data) {
                    $body.removeClass("loading");
                    alert("successfully retrieved"+data.searchVO.length);
                    out="";

             	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+"Post Code"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
             	   for(i=data.searchVO.length-1;i>=0;i--)
            		{
             		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';

            		 out= out+'<tr>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + data.searchVO[i].carSearchId + '" data-details=\'' + JSON.stringify(data.searchVO[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">Create Lead/Quotation</a></td>'+'<td>'+data.searchVO[i].carSearchId+'</td>'+'<td>'+data.searchVO[i].postCode+'</td>'+data.searchVO[i].modelYear+'<td>'+data.searchVO[i].modelDisplay+'</td>'+'<td>'+data.searchVO[i].modelName+'</td>'+'<td>'+data.searchVO[i].modelTrim+'</td></tr>';

            		}
             	   out = out.replace(/>null</g, ">--NA--<");
             	   out = out.replace(/>undefined</g, ">--NA--<");
             	   //alert(out);
             	   var LogSearch = data.searchVO;


             	   if(LogSearch && data.searchVO.length==0){
             	   outLogT="";
             	   outLogT='<h2>No records found</h2>';
             	   forFinance1("car-model-data12",outLogT);
             	   }
             	   else{
             	   forFinance1("car-model-data12",out);}
             	  registerEditDealerVehicleSearchModal();

                });

            }
           
    function registerEditDealerVehicleSearchModal(){


    	/*//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    	var editDealerVehicleSearchModal = '<div class="modal fade" id="editDealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    	    <div class="modal-dialog">\
    	        <div class="modal-content">\
    	            <div class="modal-header">\
    	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    	                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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

    	$(document.body).append(editDealerVehicleSearchModal);*/


    	$('a.anchor-editDealerVehicleSearchModal').on('click', function(event) {
    		
    		
    		$scope.VerfMob = "";
    		$scope.VerfLIC = "";
    		
    		$scope.mobCheck = false;
    		$scope.idCheck = false;
    		
    		
    		$('#car-model-data12').toggle();
    		$('#fuelCard412').toggle();
    		var data = $(event.target).data('details');
    		//var json = JSON.stringify(data);

       		//alert(data);
       		//console.log(data);
       		$scope.vehicleData = data;
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



    		//console.log(JSON.stringify(data));// to work
    		
    		condtion ="";
    		if(data.newer){
    			condition = "NEW";
    		}
    		else{
    			condition = "USED";
    		}
    		var editDealerVehicleSearchForm = '<table>\
    			<tr><th>'+ "Verification"+'</th>'+'<th>'+"eBID ID"+'</th><th>'+"Condition"+'</th><th>'+"Post Code"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>\
    			<tr><td><a href="#" id="anchor-intrModal-' + data.carSearchId + '" data-details=\'' + JSON.stringify(data) + '\' class="anchor-intrModal btn btn-success btn-sm" data-toggle="modal" data-target="#inviteModal">Verification</a></td><td>' + data.carSearchId + '</td>' + '<td>' + condition + '</td><td>' + data.postCode + '</td><td>' + data.modelYear + '</td><td>' + data.modelDisplay + '</td><td>' + data.modelName + '</td><td>' + data.modelTrim + '</td></tr>\
    			</table>';
    		editDealerVehicleSearchForm = editDealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    		editDealerVehicleSearchForm = editDealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    		
/*
        	$('.anchor-intrModal').on('click', function(event) {
        		
        		var data = $(event.target).data('details');
        		
    			$scope.VerfMob = data.mobile;
        		$scope.VerfLIC = data.drivingLicense;
        		
        		$scope.mobCheck = data.mobCheck;
        		$scope.idCheck = data.idCheck;
        		
        		alert($scope.mobCheck);
        		alert($scope.VerfMob);
        		alert($scope.VerfLIC);
        		alert($scope.idCheck);
    		});
        */	
    		
    		$scope.carSearchId = data.carSearchId;
			$scope.VerfMob = data.mobile;
    		$scope.VerfLIC = data.drivingLicense;
    		
    		$scope.mobCheck = data.mobCheck;
    		$scope.idCheck = data.idCheck;
    	
    		
    		$(".edit-dealer-vehicle-search-content").html(editDealerVehicleSearchForm);
    		
    		var wsURL = 'api/getDealSearchInfoId?carSearchId='+data.carSearchId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("successfully retrieved");
	                  out="";
	                  if(data.dealerSearchVO && data.dealerSearchVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th></tr>';
		   	           	   for(i=0;i<data.dealerSearchVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.dealerSearchVO[i].carSearchId+'</td>'+'<td>'+data.dealerSearchVO[i].modelYear+'<td>'+data.dealerSearchVO[i].modelDisplay+'</td>'+'</td>'+'<td>'+data.dealerSearchVO[i].modelName+'</td>'+'<td>'+data.dealerSearchVO[i].modelTrim+'</td></tr>';
	
		   	          		}
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#LeadTable").html(out);

				}
			});
    		
    		
    		
    		//$scope.leadIDs = "";
    		var wsURL = 'api/getExtDealSearchInfoId?carSearchId='+data.carSearchId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("started retrieved Lead Id"); 
	                  out="";
	                  var options ="";
	                  $("#LeadQuoteId").empty();
	                  if(data.extDealerSearchVO && data.extDealerSearchVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Lead ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Lead Creation Date"+'</th></tr>';
		                		options += '<option value="" selected disabled>Select a Lead ID</option>';
		                	  for(i=0;i<data.extDealerSearchVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td></td>'+'<td>'+data.extDealerSearchVO[i].extDealerSearchId+'</td>'+'<td>'+data.extDealerSearchVO[i].dealerId+'<td>'+data.extDealerSearchVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.extDealerSearchVO[i].userid+'</td>'+'<td>'+data.extDealerSearchVO[i].ageOfAdditionalDriver+'<td><a href="#" id="anchor-editldaDealerVehicleSearchModal-' + data.extDealerSearchVO[i].extDealerSearchId + '" data-details=\'' + JSON.stringify(data.extDealerSearchVO[i]) + '\' class="anchor-editldaDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editldaDealerVehicleSearchModal">View</a></td></tr>';
		   	          		// options += '<option>' +data.extDealerSearchVO[i].extDealerSearchId+ '</option>';
		   	          	//alert("insidecssdssretrieved Lead Id"+data.extDealerSearchVO[i].extDealerSearchId); 
		   	          		 options += '<option>' + data.extDealerSearchVO[i].extDealerSearchId + '</option>';
		   	          		}
		   	           	   //$("#LeadQuoteId").html(options);
		                		//alert("options"+options); 
		   	            $("#LeadQuoteId").html(options);
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#LeadExtTable").html(out);
	           	registerEditldaDealerVehicleSearchModal();
				}
			});
    		// start of view of Lead
    		function registerEditldaDealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editldaDealerVehicleSearchModal = '<div class="modal fade" id="editldaDealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
    			                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Lead Details</center></h4>\
    				        <form id="edit-lda-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-lda-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
    				<p><center>&copy; 2017 Autoscoop</center></p>\
    					</div>\
    			            </form>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editldaDealerVehicleSearchModal);


    			$('a.anchor-editldaDealerVehicleSearchModal').on('click', function(event) {


    				var data = $(event.target).data('details');
    				//var json = JSON.stringify(data);

    				var quotIdHiddenField = '<input type="hidden" name="extDealerSearchId" value="' + data.extDealerSearchId + '" />';
    				var moveToUser = '<input type="checkbox" name="moveToUser" />';
    				
    				if(data.newer)
    					  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
    					var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
    					if(data.used)
    					  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';
    					 status1="Pending (Quotation not created)";
    	   	         		if(data.status){status1="Quotation Completed";}

    				//alert(JSON.stringify(data)); to work
    				var editldaDealerVehicleSearchForm = '<form id="edit-lda-dealer-vehicle-search-content-form"><table>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Details</div></div>\
    					<tr><td>Dealer Lead ID</td><td>' + data.extDealerSearchId + '</td></tr>\
    					<tr><td>' + quotIdHiddenField + '</td></tr>\
    					<tr><td>Status</td><td>' + status1 + '</td></tr>\
    					<tr><td>User Requirement Id</td><td>' + data.carSearchId + '</td></tr>\
    					<tr><td>Autoscoop User Id</td><td>' + data.userid + '</td></tr>\
    					<tr><td>User Since</td><td>' + data.creationDate + '</td></tr>\
    					<tr><td>Lead Created Date</td><td>' + data.ageOfAdditionalDriver + '</td></tr>\
    					</table>\
    					<br/>\
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">External Dealer Details</div></div>\
    					<tr><td>Category</td><td>' + data.category  + '</td></tr>\
    					<tr><td>Company Name</td><td>' + data.companyName  + '</td></tr>\
    					<tr><td>Street</td><td>' + data.street + '</td></tr>\
    					<tr><td>Suburb</td><td>' + data.suburb + '</td></tr>\
    					<tr><td>State</td><td>' + data.dealState + '</td></tr>\
    					<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
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
    					<table>\
    					<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Lead Requirement</div></div>\
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
    				editldaDealerVehicleSearchForm = editldaDealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editldaDealerVehicleSearchForm = editldaDealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-lda-dealer-vehicle-search-content").html(editldaDealerVehicleSearchForm);
    			});
    			$('button.submit-editldaDealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-lda-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");

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
    		// end of view of Lead
    		//$scope.leadIDs = "";
    		var wsURL = 'api/getExtQtDealSearchInfoId?carSearchId='+data.carSearchId ;
  		  	$body.addClass("loading");
    		$.ajax({
				type: "GET",
				url: wsURL,
				success: function(data){
					$body.removeClass("loading");
	                  //alert("successfully retrieved"); read here
	                  out="";
	                  //var options ;
	                  if(data.vehicleQuotationVO && data.vehicleQuotationVO.length!=0)
	                	  {
		                	  out += '<tr><th>'+"Operation"+'</th><th>'+"Quotation ID"+'</th><th>'+"Dealer Id"+'</th>'+'<th>'+"Car Ebid Id"+'</th><th>'+"User Id"+'</th><th>'+"Quotation Creation Date"+'</th></tr>';
		   	           	   for(i=0;i<data.vehicleQuotationVO.length;i++)
		   	          		{
		   	           		   //out= out+'<tr>'+'<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+result.search[i].photo1+' alt'+'='+'"'+'" /></li></ul>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
	
		   	          		 out= out+'<tr>'+'<td><a href="#" id="anchor-editqtaDealerVehicleSearchModal-' + data.vehicleQuotationVO[i].quotId + '" data-details=\'' + JSON.stringify(data.vehicleQuotationVO[i]) + '\' class="anchor-editqtaDealerVehicleSearchModal btn btn-success btn-sm" data-toggle="modal" data-target="#editqtaDealerVehicleSearchModal">View</a></td>'+'<td>'+data.vehicleQuotationVO[i].quotId+'</td>'+'<td>'+data.vehicleQuotationVO[i].dealerId+'<td>'+data.vehicleQuotationVO[i].carSearchId+'</td>'+'</td>'+'<td>'+data.vehicleQuotationVO[i].userId+'</td>'+'<td>'+data.vehicleQuotationVO[i].creationDate+'</tr>';
		   	          		 //options += '<option>' +data.vehicleQuotationVO[i].extDealerSearchId+ '</option>';
		   	          		}
		   	           	   //$("#LeadQuoteId").html(options);
	                	  }
	           	 
	                  else{
	           		out='<h2>No records</h2>';
	           	   }
	           	
	           	   out = out.replace(/>null</g, ">--NA--<");
	           	   out = out.replace(/>undefined</g, ">--NA--<");
	           	   $("#QuoteTable").html(out);
	           	registerEditqtaDealerVehicleSearchModal();
				}	
			});
    		// start of view of Quotation
    		function registerEditqtaDealerVehicleSearchModal(){


    			//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
    			var editqtaDealerVehicleSearchModal = '<div class="modal fade" id="editqtaDealerVehicleSearchModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
    			    <div class="modal-dialog">\
    			        <div class="modal-content">\
    			            <div class="modal-header">\
    			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
		                <h3 class="modal-title product-search-title" id="myModalLabel"><center>AutoScoop</center></h3>\
    			            </div>\
    						<h4 class="modal-title" id="myModalLabel"><center>View Quotation Details</center></h4>\
    				        <form id="edit-qta-dealer-vehicle-search-content-form">\
    						<div class="modal-body edit-qta-dealer-vehicle-search-content">\
    			            </div>\
    			            <div class="modal-footer">\
    			                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
			<button type="button" class="btn btn-primary submit-editqtaDealerVehicleSearchModal" data-dismiss="modal">Save changes</button>\
    					</div>\
    			            </form>\
					<p><center>&copy; 2017 Autoscoop</center></p>\
    			        </div>\
    			    </div>\
    			</div>';

    			$(document.body).append(editqtaDealerVehicleSearchModal);


    			$('a.anchor-editqtaDealerVehicleSearchModal').on('click', function(event) {


    				var data = $(event.target).data('details');
    				//var json = JSON.stringify(data);
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

			    //forFinance("deal-operation",out5DD);
			    //alert("userHistory"+out5DD);

			    out5DD1 = "";
			    var dealDt1 = data.dealerQuotationHistoryVO;
			    if(dealDt1)
			    {
			    	dealDt1 = data.dealerQuotationHistoryVO.length;
		  	   //document.getElementById('finMax').innerHTML=finMax;
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

			    //forFinance("deal-operation",out5DD);
			    //alert("userHistory"+out5DD1);
			  // logic to retrieve

			  //alert("data.oi"+data.postCode);
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
    				var editqtaDealerVehicleSearchForm = '<form id="edit-qta-dealer-vehicle-search-content-form">\
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
    				editqtaDealerVehicleSearchForm = editqtaDealerVehicleSearchForm.replace(/>null</g, ">--NA--<");
    				editqtaDealerVehicleSearchForm = editqtaDealerVehicleSearchForm.replace(/>undefined</g, ">--NA--<");
    				$(".edit-qta-dealer-vehicle-search-content").html(editqtaDealerVehicleSearchForm);
    			});
    			$('button.submit-editqtaDealerVehicleSearchModal').on('click', function(e) {

    				var jsonInput = $("#edit-qta-dealer-vehicle-search-content-form").convertFormDataToJSON();
    				//alert("data12");
    				//console.log(JSON.stringify(jsonInput));

    				$.ajax({
    					type: "POST",
    					url: "api/vehicleSearchDealQuotation?_method=PUT",
    					data: jsonInput,
    					contentType:'application/json',
    					success: function(result){
    						//console.log(JSON.stringify(result));
    						$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    						alert("Successfully upated the Quotations");
					//alert("will call update12"+result.userId);
					//console.log(JSON.stringify(result));
					//$scope.carCarQuotation(result.userId);

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
    		// end of view of Lead
    		
    	});
    	
    	
    	
    	
    	/*$('button.submit-editDealerVehicleSearchModal').on('click', function(e) {

    		var jsonInput = $("#edit-dealer-vehicle-Search-content-form").convertFormDataToJSON();


    		$.ajax({
    			type: "POST",
    			url: "api/vehicleSearchQuotation?_method=PUT",
    			data: jsonInput,
    			contentType:'application/json',
    			success: function(result){
    				$("#anchor-editDealerVehicleSearchModal-" + result.quotId).data('details', result);
    				alert("Successfully upated the Quotations");

    			}
    		});


    	});*/
    	
    	
    	 $("#BackToVehicles1").click(function(){
		        $('#fuelCard412').hide();
		        //$( "#fuelCard41" ).empty();
		        $('#car-model-data12').show();
		        //document.getElementById("fuelCard41").style.display = "none";
		        //document.getElementById("fuelCard4").style.display = "block";
		        //alert("The paragraph ssswas showed.");
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
    function forFinance1(model_data_id, out)
    {
     this.model_data_id = model_data_id;

            	   $("#"+model_data_id).html(out);

    }

    // Insurance lead post end
    
    
	$scope.vehicleRetrievalforLogBook = function() {
						var wsURL = 'api/Myvehicle/'+myVehicleIDuse;
						$.ajax({
							type: "GET",
							url: wsURL,
							contentType:'application/json',
							success: function(result){
								//alert(JSON.stringify(result));
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
								$('#logTripTable').html(outLogT);
								registerEditDealerVehiclelogbkModal();
								// start of LogBook
								function registerEditDealerVehiclelogbkModal(){
									var editDealerVehiclelogbkModal = '<div class="modal fade" id="editDealerVehiclelogbkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
										//var json = JSON.stringify(data);

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




										/*var editDealerVehicleexpnsForm = '<form id="edit-dealer-vehicle-expns-content-form"><table>\
											<tr><td>Log Expense ID</td><td>' + data.myVehicleFuelExpensesId + '</td></tr>\
											</table>\
											<table>\
											<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Expense Details</div></div>\
											<tr><td>Expensive Type</td><td>' + data.recordType + '</td></tr>\
											<tr><td>Expensive Category</td><td>' + data.business + '</td></tr>\
											<tr><td>Expensive Date</td><td>' + data.date + '</td></tr>\
											<tr><td>Expensive Description</td><td>' + data.others + '</td></tr>\
											<tr><td>Amount</td><td>' + data.amount + '</td></tr>\
											</table>\
											</form>';
										editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>null</g, ">--NA--<");
										editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>undefined</g, ">--NA--<");
										$(".edit-dealer-vehicle-expns-content").html(editDealerVehicleexpnsForm);*/
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
								// end of LogBook
								var LogE = result.myVehicleFuelExpenses;
								outLogE="";
								//alert(result.myVehicleFuelExpenses.length);
								if(LogE && result.myVehicleFuelExpenses.length!=0)
								{
									/*var  logServMainTable = '<table>\
										<tr><th>'+"Type of Service"+'</th><th>'+"Date of Service"+'</th><th>'+"Mileage/OdoMeter @Service"+'</th><th>'+"Detail Work Performed"+'</th><th>'+"List of Service"+'</th><th>'+"Notes"+'</th><th>'+"Technician"+'</th><th>'+"Service & maintenancec Company"+'</th><th>'+"Uploadedd Maintenance record"+'</th></tr>\
										<tr><td>' + data.myVehicleId + '</td>\
										<td>' + data.year + '</td>\
										<td>' + data.make + '</td>\
										<td>' + data.model + '</td>\
										<td>' + data.variant + '</td></tr>\
										</table>';*/
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
								$('#logExpTable').html(outLogE);
								registerEditDealerVehicleexpnsModal();
								// start of logexpenses
								function registerEditDealerVehicleexpnsModal(){

//alert("came inside log expenses");
									//Add a Bootstrap Modal DIV to vehicle expns Details
									var editDealerVehicleexpnsModal = '<div class="modal fade" id="editDealerVehicleexpnsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
										//var json = JSON.stringify(data);

										var quotIdHiddenField = '<input type="hidden" name="myVehicleFuelExpensesId" value="' + data.myVehicleFuelExpensesId + '" />';
										/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; */
										/*if(data.newer)
										  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
										var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
										if(data.used)
										  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';*/

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
										var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.photoOfInvoice, Expires: 60};
								        bucket.getSignedUrl('getObject', params, function (err, url) {
								          if (url) { //alert("successfully retrieved 12.."+url);
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

										/*var editDealerVehicleexpnsForm = '<form id="edit-dealer-vehicle-expns-content-form"><table>\
											<tr><td>Log Expense ID</td><td>' + data.myVehicleFuelExpensesId + '</td></tr>\
											</table>\
											<table>\
											<div class="row"><div class="col-sm-12 col-md-12 product-search-title">Log Expense Details</div></div>\
											<tr><td>Expensive Type</td><td>' + data.recordType + '</td></tr>\
											<tr><td>Expensive Category</td><td>' + data.business + '</td></tr>\
											<tr><td>Expensive Date</td><td>' + data.date + '</td></tr>\
											<tr><td>Expensive Description</td><td>' + data.others + '</td></tr>\
											<tr><td>Amount</td><td>' + data.amount + '</td></tr>\
											</table>\
											</form>';
										editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>null</g, ">--NA--<");
										editDealerVehicleexpnsForm = editDealerVehicleexpnsForm.replace(/>undefined</g, ">--NA--<");
										$(".edit-dealer-vehicle-expns-content").html(editDealerVehicleexpnsForm);*/
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
								//end of logexpenses

								//alert(result.myVehicleServMaint.length);
								var LogS = result.myVehicleServMaint;
								outLogS="";
								if(LogS && result.myVehicleServMaint.length!=0)
								{
									/*var logExpTable = '<table>\
										<tr><th>'+"Expensive Type"+'</th><th>'+"Expensive Category"+'</th><th>'+"Expensive Date"+'</th><th>'+"Expensive Description"+'</th><th>'+"Amount"+'</th><th>'+"Uploaded Photo"+'</th></tr>\
										<tr><td>' + data.myVehicleId + '</td>\
										<td>' + data.year + '</td>\
										<td>' + data.make + '</td>\
										<td>' + data.model + '</td>\
										<td>' + data.variant + '</td></tr>\
										</table>';
									*/
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
								$('#logServMainTable').html(outLogS);
								registerEditDealerVehicleservmtModal();
								// start of logsermaint
								function registerEditDealerVehicleservmtModal(){

//alert("came inside log servmaint");
									//Add a Bootstrap Modal DIV to vehicle expns Details
									var editDealerVehicleservmtModal = '<div class="modal fade" id="editDealerVehicleservmtModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
									    <div class="modal-dialog">\
									        <div class="modal-content">\
									            <div class="modal-header">\
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
									                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
										//var json = JSON.stringify(data);

										var quotIdHiddenField = '<input type="hidden" name="myVehicleServMaintId" value="' + data.myVehicleServMaintId + '" />';
										/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; */
										/*if(data.newer)
										  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
										var moveToUser1 = '<input type="checkbox" name="moveToUser1" />';
										if(data.used)
										  moveToUser1 = '<input type="checkbox" name="moveToUser1" checked="checked" />';*/
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
										var params = {Bucket: 'elasticbeanstalk-us-east-1-675778862308', Key: data.uploadPhoto, Expires: 60};
								        bucket.getSignedUrl('getObject', params, function (err, url) {
								          if (url) { //alert("successfully retrieved 12.."+url);
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
								          //alert("successfully retrieved 12.."+url);
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
								//end of logservmaint
							}
						});
					}
	// Rego State Lead Start
	$scope.postRegoStateUrlLead = function(isValid) {
	//alert("invoke in postRegoState lead");


		/*alert($scope.email);
		alert(email); */
		if(alreadyLogged()){
			if(isValid){
					userId=$.jStorage.get('key').userId;
					fbUserId=$.jStorage.get("fbKey");

					var wsURL = 'api/regostateurl/getRegoStateUrlFor?vehState='+$('#car-reg-state').val()+'&vehType='+$('#car-reg-vehType').val();
					// change here

				   $body.addClass("loading");
				    	$http({
							method : 'GET',
							url : wsURL

						}).success(function(data) {
							$body.removeClass("loading");
							alert("successfully retreived"+data.flex2);
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
		else{alert("Please Login and Build")}



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
									//alert("Image of MyVehicle"+objKeyMyVeh);
								/*var RegExpDate= stringToDate($('#RegExpDate').val(),"dd/MM/yyyy","/");
								var InsExpDate= stringToDate($('#InsExpDate').val(),"dd/MM/yyyy","/");
								var LastServDate= stringToDate($('#LastServDate').val(),"dd/MM/yyyy","/");
								var NextServDate= stringToDate($('#NextServDate').val(),"dd/MM/yyyy","/");
								var LoanTakenDate = stringToDate($('#LoanTakenDate').val(),"dd/MM/yyyy","/");
*/
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

								//alert(JSON.stringify(jsonInputToAPI));
								$body.addClass("loading");
														//alert("Before Call");
														//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
														//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
														var wsURL = 'api/eBid/myVehicle';

															    $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI

																		}).success(function(data) {
																			$body.removeClass("loading");
																			//alert("Successfully Stored..");
																							//alert("Thank You. Your MyVehicle ID is " + data.myVehicleId +"and it is updating to dashboard");
																							alert("Successfully Stored My Vehicle Request with ID"+ data.myVehicleId+"However, Plz wait for the images to upload.. don't refresh or switch from dashboard..  the upload of images will start soon..");


																                			//$("#vehFrm")[0].reset();
																                			//$('#editprofilefrm').trigger("reset");
																                			if(fileMyVeh || fileMyVeh2 || fileMyVeh3 ){
																                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																                				myvehicleloadImage();
																                				//alert("Before reset correct15689899");
																	                			document.getElementById("vehFrm").reset();
																	                			}
																                			else {
															                                	alert("No upload of images found..");
															                                	//alert("Before reset correct15689899");
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
								                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
									//alert("url1 new changes"+url1);

									//end



									/*var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
										<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+data.photo1+'"'+' height="200" width="250"/></li></ul>\
										<tr><td>My Vehicle ID</td><td>' + data.myVehicleId + '</td></tr>\
										<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
										<tr><td>Year</td><td>' + data.year + '</td></tr>\
										<tr><td>Make</td><td>' + data.make + '</td></tr>\
										<tr><td>Model</td><td>' + data.model + '</td></tr>\
										<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
										<tr><td>VIN</td><td>' + data.vin + '</td></tr>\
										<tr><td>Registration No:</td><td>' + data.regNum + '</td></tr>\
										<tr><td>Rego State</td><td>' + data.regState + '</td></tr>\
										<tr><td>Reg Expirty Date</td><td>' + data.regExpDate + '</td></tr>\
										<tr><td>Insurance Provider</td><td>' + data.insProv + '</td></tr>\
										<tr><td>Insurance Provider Man</td><td>' + data.insProvMan + '</td></tr>\
										<tr><td>Insurance Premium Paid</td><td>'+ data.insPremPaid + '</td></tr>\
										<tr><td>Insurance Premium Freq</td><td>' + data.insPremPaidFreq + '</td></tr>\
										<tr><td>Insurance Expiry</td><td>' + data.insExpiry + '</td></tr>\
										<tr><td>ODO Meter</td><td>' + data.odoMeter + '</td></tr>\
										<tr><td>Last Service Dt</td><td>' + data.lastServiceDt + '</td></tr>\
										<tr><td>Next Service Dt</td><td>' + data.nextServiceDt + '</td></tr>\
										<tr><td>Next Service Kms</td><td>' + data.nextServKms + '</td></tr>\
										<tr><td>Finance Provider</td><td>' + data.finProvider + '</td></tr>\
										<tr><td>Loan Amount1</td><td>' + data.loanAmt1 + '</td></tr>\
										<tr><td>Age Of Additional Driver</td><td>' + data.loanTakenDt + '</td></tr>\
										<tr><td>Loan Paid Freq</td><td>' + data.loanPaidFreq + '</td></tr>\
										<tr><td>Loan Period</td><td>' + data.loanPeriod + '</td></tr>\
										<tr><td>Loan Interest</td><td>' + data.loanInterest + '</td></tr>\
										<tr><td>Fuel Card Provider</td><td>' + data.fuelCardProvider + '</td></tr>\
										<tr><td>value Fuel Card</td><td>' + data.valFuelCard + '</td></tr>\
										<tr><td>Fuel Type</td><td>' + data.fuelType + '</td></tr>\
										</table></form>';
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
									editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
									$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);*/
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


						function vehicleDetailsLoad(){
							//alert("In ch lfsfoad");
							var wsURL = 'api/userVehicle/'+userId;//"api/user/"+userid;
							//alert(wsURL);
							$body.addClass("loading");
						    $http({
										method : 'GET',
										url : wsURL
									}).success(function(data) {
										/*alert(data);
										alert(JSON.stringify(data));*/
										outVehicle="";
							        	/*alert(data.length);
							        	alert(data[0].myVehicleId);*/
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
							           	   registerEditnwvhDealerVehicleDetailModal();
							           	function registerEditnwvhDealerVehicleDetailModal(){


							           		//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
							           		//alert("Inside new vehicle method raa");
							           		var editnwvhDealerVehicleDetailModal = '<div class="modal fade" id="editnwvhDealerVehicleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
							           		    <div class="modal-dialog">\
							           		        <div class="modal-content">\
							           		            <div class="modal-header">\
							           		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
							           		                <h3 class="modal-title" id="myModalLabel"><center>Autoscoop.com.au</center></h3>\
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
							           			//alert("url1 new changes"+url1);

							           			//end



							           			/*var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
							           				<ul class'+'='+'"'+'slides'+'"'+'><li><img src'+'='+'"'+data.photo1+'"'+' height="200" width="250"/></li></ul>\
							           				<tr><td>My Vehicle ID</td><td>' + data.myVehicleId + '</td></tr>\
							           				<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
							           				<tr><td>Year</td><td>' + data.year + '</td></tr>\
							           				<tr><td>Make</td><td>' + data.make + '</td></tr>\
							           				<tr><td>Model</td><td>' + data.model + '</td></tr>\
							           				<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
							           				<tr><td>VIN</td><td>' + data.vin + '</td></tr>\
							           				<tr><td>Registration No:</td><td>' + data.regNum + '</td></tr>\
							           				<tr><td>Rego State</td><td>' + data.regState + '</td></tr>\
							           				<tr><td>Reg Expirty Date</td><td>' + data.regExpDate + '</td></tr>\
							           				<tr><td>Insurance Provider</td><td>' + data.insProv + '</td></tr>\
							           				<tr><td>Insurance Provider Man</td><td>' + data.insProvMan + '</td></tr>\
							           				<tr><td>Insurance Premium Paid</td><td>'+ data.insPremPaid + '</td></tr>\
							           				<tr><td>Insurance Premium Freq</td><td>' + data.insPremPaidFreq + '</td></tr>\
							           				<tr><td>Insurance Expiry</td><td>' + data.insExpiry + '</td></tr>\
							           				<tr><td>ODO Meter</td><td>' + data.odoMeter + '</td></tr>\
							           				<tr><td>Last Service Dt</td><td>' + data.lastServiceDt + '</td></tr>\
							           				<tr><td>Next Service Dt</td><td>' + data.nextServiceDt + '</td></tr>\
							           				<tr><td>Next Service Kms</td><td>' + data.nextServKms + '</td></tr>\
							           				<tr><td>Finance Provider</td><td>' + data.finProvider + '</td></tr>\
							           				<tr><td>Loan Amount1</td><td>' + data.loanAmt1 + '</td></tr>\
							           				<tr><td>Age Of Additional Driver</td><td>' + data.loanTakenDt + '</td></tr>\
							           				<tr><td>Loan Paid Freq</td><td>' + data.loanPaidFreq + '</td></tr>\
							           				<tr><td>Loan Period</td><td>' + data.loanPeriod + '</td></tr>\
							           				<tr><td>Loan Interest</td><td>' + data.loanInterest + '</td></tr>\
							           				<tr><td>Fuel Card Provider</td><td>' + data.fuelCardProvider + '</td></tr>\
							           				<tr><td>value Fuel Card</td><td>' + data.valFuelCard + '</td></tr>\
							           				<tr><td>Fuel Type</td><td>' + data.fuelType + '</td></tr>\
							           				</table></form>';
							           			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>null</g, ">--NA--<");
							           			editDealerVehicleDetailForm = editDealerVehicleDetailForm.replace(/>undefined</g, ">--NA--<");
							           			$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);*/
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

										$body.removeClass("loading");
													});


						}







												$scope.submitSearchFormLogBook = function(isValid) {
													//alert("inside Log Book"+isValid);
													/*alert("inside Log Book");
													alert(myVehicleIDuse);	*/
													 if (isValid) {
													//alert(data.myVehicleId);
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

													//console.log(JSON.stringify(jsonInputToAPI));
													//alert("Before Call");"flex2":$('#logBookDriverName').val(),
													//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
													//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
													var wsURL = 'api/myvehicle/addMyVehicleLogBook';

														  /*  $http({
																		method : 'POST',
																		url : wsURL,
																		data: jsonInputToAPI

																	}).success(function(data) {
																		alert("Successfully Stored..");
																						alert("Thank You. Your MyVehicle ID is ");

																					});
														    */


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
														      /*alert(status);
														      alert(statusText);
														      alert(JSON.stringify(data));
														      alert(headers);
														      alert(config);*/
														      $scope.vehicleRetrievalforLogBook();
														      alert("Your Log is Successfully Stored..");

														      //alert("Before reset correct15689899");
									                			document.getElementById("lognewfrm").reset();
														      //alert("Thank You. Your MyVehicle ID is ");

														    }, function onError(response) {
														      // Handle error
														      /*var data = response.data;
														      var status = response.status;
														      var statusText = response.statusText;
														      var headers = response.headers;
														      var config = response.config;*/
														      alert("Something went wrong in error storing LogBook\n Please try Again");
														     /* alert(status);
														      alert(statusText);
														      alert(JSON.stringify(data));
														      alert(headers);
														      alert(config);*/
														    });
														    }
													};

													submitSearchFormupdateset = function(isValid) {
														//alert("inside Update Settings"+isValid);
														if (isValid) {
														//updateSettingloadImage();
														//alert("Date"+$scope.abcDriverDOB);
														//alert("Date"+$('#abcDriverDOB').val());
														//alert("vachindi");
														//alert("vachindi");
														//alert("inside updatset");
														/*alert("inside Sesdarv Maint");
														alert(myVehicleIDuse);*/
														/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
														var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/
														var fileChooserlogupdateset = document.getElementById('file-chooser-updateset');
														var filefileChooserupdateset = fileChooserlogupdateset.files[0];
														var objKeyupdateset ='noImage';
														if(value.issueState){
															objKeyupdateset = value.issueState;
														}

														if(filefileChooserupdateset){
														objKeyupdateset = 'facebook-' + fbUserId + '/' + filefileChooserupdateset.name;}
														//alert(objKeyupdateset);
														var jsonInputToAPI = {"userId":value.userId,"photo":objKeyupdateset, "dateOfBirth":$('#abcDriverDOB').val(),"phoneNumber":$('#UserPhoneNo').val(), "firstName":$('#UserFirstName').val(),"lastName":$('#UserLastName').val(),"streetNumber":$('#UserStreetNo').val(),"streetName":$('#UserStreetName').val(),"postCode":$('#UserpostCode').val(),"region":$('#UserRegion').val(),"state":$('#UserState').val(),"desc":$('#UserDesc').val()}

														/*var jsonInputToAPI = {"myVehicleId":myVehicleIDuse,
																"myVehicleServMaintVO":{
																	"myVehicleServMaintId":null,
																	"date":$('#vehicleTypeServMaint').val(),
																	"Time":null,
																	"recordType":"Service&Maintenance",
																	"mechanicName":$('#mechanicNameCompanyName').val(),
																	"companyName":"pqrs",
																	"typeOfServMaint":$('#typeServiceMaintenance').val(),
																	"mechanicAddress":$('#mechanicAddress').val(),
																	"contactDetails":$('#contactDetails').val(),
																	"odoMeterKm":$('#odoMeterKmsMilesServMaint').val(),
																	"totalAmount":$('#totalAmount').val(),
																	"nextOdoMeterKm":$('#NextServiceMaintenanceOdoMeterKmsmils').val(),
																	"nextServDate":$('#nextServiceMaintenanceDate').val(),
																	"uploadPhoto":objKeyupdateset,
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
																}*/


														//alert("Before Call");
														//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
														//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';


															   /* $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI

																		}).success(function(data) {
																			$scope.vehicleRetrievalforLogBook();
																			alert("Service & Maintenance Successfully Stored..");

																						});*/
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
														
														
// start of finance creation
														
														$scope.submitInsMyQuoteNewfrm = function(isValid) {
															alert("inside Ins Qu"+isValid);
															if (isValid) {
															/*alert("inside Sesdarv Maint");
															alert(myVehicleIDuse);*/
															/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
															var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/

															//logServMaintloadImage();
															var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
															var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
															var objKeyfilefileChooserlogservmaint ='noImage';
															if(filefileChooserlogservmaint){
															objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
															//alert(objKeyfilefileChooserlogservmaint);
															/*//alert(objKeyfilefileChooserlogservmaint);
															var jsonInputToAPI = {
																		"dealerId":null,
																		"userId":null,
																		"dealSearchId":null,
																		"carSearchId":null,
																		"refId":null,
																		"dealerStockNo":null,
																		"driveAwayPrice":null,
																		"modelYear":null,
																		"modelDisplay":null,
																		"modelName":null,
																		"modelTrim":null
																	}*/
															
															jsonInput = $scope.vehicleData;
															
															jsonInput["insQuotId"]=null;
															jsonInput["refId"]=0;
															//$scope.LeadSvQuoteId;
															//alert("dealer Lead id"+$scope.LeadSvQuoteId);
															//alert("rego end date"+$scope.finSvDOB);
															//alert("Exter dealer id"+$scope.ExtSvDealerId);
															//$scope.ExtDealerId=0;
															
															jsonInput["dealerId"]=$scope.ExtInsDealerId;
															jsonInput["driveAwayPrice"]=$scope.finInsAnnualIncome;
															jsonInput["offerPrice2"]=$scope.finInsAnnualIncome1;
															jsonInput["offerPrice3"]=$scope.finInsAnnualIncome2;
															jsonInput["offerValidDate"]=$scope.finInsDOB;
															// 07072017
															jsonInput["dealSearchId"]=$scope.LeadInsQuoteId;
															jsonInput["address"]=objKeyfilefileChooserlogservmaint;
															jsonInput["modelYear"]=$scope.caryearsfin;
															        jsonInput["modelDisplay"]=$scope.carmakesfin;
															                    jsonInput["modelName"]=$scope.carmodelsfin;
															                              jsonInput["modelTrim"]=$scope.carmodelAutotrimsfin;
															                              
															                              jsonInput["flex1"]=$scope.servSvAddNotes;
															var table1 = $("#my-table999");
								                            var table = table1.tableToJSON({
								                                ignoreColumns:[0],
								                                headings: ['extras1', 'extras2', 'amount']
								                              });
								                            //delete table[0];

								                            table.splice(0,1);

								                            jsonInput.vehQuotExtras = table ;
															//alert("value"+jsonInput);
															
															
															// Transfer the object to a JSON string
															var jsonstr1 = JSON.stringify(jsonInput);

															// HERE you do the transform
															
															//var new_jsonstr = jsonstr1.replace('"searchServMaintId"', '"carSearchId"');
															var new_jsonstr = jsonstr1.replace('"idp"', '"userId"');
															var new_jsonstr1 = new_jsonstr.replace('"creationDate"', '"userCreationDate"');
															var new_jsonstr2 = new_jsonstr1.replace('"searchInsuranceId"', '"carSearchId"');
															//var new_jsonstr3 = new_jsonstr2.replace('"regoState"', '"regoStat"');
															//var new_jsonstr4 = new_jsonstr3.replace('"feulType"', '"fuelType"');
															//var new_jsonstr5 = new_jsonstr4.replace('"fname"', '"freeText"');
															//var new_jsonstr6 = new_jsonstr5.replace('"coveredUnderIns"', '"coveredUnderIns"');
															//var new_jsonstr7 = new_jsonstr6.replace('"curInsProv"', '"CURINSPROV"');
															//var new_jsonstr8 = new_jsonstr4.replace('"lookService"', '"flex1"');
															//var new_jsonstr9 = new_jsonstr8.replace('"carColor"', '"color"');
															// You probably want to parse the altered string later
															var new_obj = JSON.parse(new_jsonstr2);

															
															//alert("new"+JSON.stringify(new_obj));
															
															//console.log(JSON.stringify(new_obj));
															//alert("Before Call");
															//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
															//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
															var wsURL = 'api/dealerQuotInsCreation?_method=PUT';
															//var wsURL = '';
															$body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: JSON.stringify(new_obj)

																			}).success(function(data) {
																				$body.removeClass("loading");
																				$scope.vehicleRetrievalforLogBook();
																				alert("Successfully Stored Quotation However, Plz wait for the images to upload.. don't refresh or switch from your page..  the upload of images will start soon..");
																				//alert("Service & Maintenance Successfully Stored..");


													                			if(filefileChooserlogservmaint){
													                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																				logServMaintloadImage();
																				//alert("Before reset correct15689899");
													                			document.getElementById("QuoteNewfrm").reset();
													                			}
													                			else {
												                                	alert("No upload of images found..");
												                                	//alert("Before reset correct15689899");
														                			document.getElementById("QuoteNewfrm").reset();
												                                }

																							});
														}
															};
														// end of insurance creatioin

														// start of finance creation
														
														$scope.submitFinMyQuoteNewfrm = function(isValid) {
															//alert("inside Sesdarv Maint"+isValid);
															if (isValid) {
															/*alert("inside Sesdarv Maint");
															alert(myVehicleIDuse);*/
															/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
															var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/

															//logServMaintloadImage();
															var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
															var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
															var objKeyfilefileChooserlogservmaint ='noImage';
															if(filefileChooserlogservmaint){
															objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
															//alert(objKeyfilefileChooserlogservmaint);
															/*//alert(objKeyfilefileChooserlogservmaint);
															var jsonInputToAPI = {
																		"dealerId":null,
																		"userId":null,
																		"dealSearchId":null,
																		"carSearchId":null,
																		"refId":null,
																		"dealerStockNo":null,
																		"driveAwayPrice":null,
																		"modelYear":null,
																		"modelDisplay":null,
																		"modelName":null,
																		"modelTrim":null
																	}*/
															
															jsonInput = $scope.vehicleData;
															
															jsonInput["finQuotId"]=null;
															jsonInput["refId"]=0;
															//$scope.LeadSvQuoteId;
															//alert("dealer Lead id"+$scope.LeadSvQuoteId);
															//alert("rego end date"+$scope.finSvDOB);
															//alert("Exter dealer id"+$scope.ExtSvDealerId);
															//$scope.ExtDealerId=0;
															
															jsonInput["dealerId"]=$scope.ExtFinDealerId;
															jsonInput["driveAwayPrice"]=$scope.finFinAnnualIncome;
															jsonInput["offerPrice2"]=$scope.finFinAnnualIncome1;
															jsonInput["offerPrice3"]=$scope.finFinAnnualIncome2;
															jsonInput["offerValidDate"]=$scope.finFinDOB;
															// 07072017
															jsonInput["dealSearchId"]=$scope.LeadFinQuoteId;
															jsonInput["address"]=objKeyfilefileChooserlogservmaint;
															jsonInput["modelYear"]=$scope.caryearsfin;
															        jsonInput["modelDisplay"]=$scope.carmakesfin;
															                    jsonInput["modelName"]=$scope.carmodelsfin;
															                              jsonInput["modelTrim"]=$scope.carmodelAutotrimsfin;
															                              
															                              jsonInput["flex1"]=$scope.servSvAddNotes;
															var table1 = $("#my-table988");
								                            var table = table1.tableToJSON({
								                                ignoreColumns:[0],
								                                headings: ['extras1', 'extras2', 'amount']
								                              });
								                            //delete table[0];

								                            table.splice(0,1);

								                            jsonInput.vehQuotExtras = table ;
															//alert("value"+jsonInput);
															
															
															// Transfer the object to a JSON string
															var jsonstr1 = JSON.stringify(jsonInput);

															// HERE you do the transform
															
															//var new_jsonstr = jsonstr1.replace('"searchServMaintId"', '"carSearchId"');
															var new_jsonstr = jsonstr1.replace('"idp"', '"userId"');
															var new_jsonstr1 = new_jsonstr.replace('"creationDate"', '"userCreationDate"');
															var new_jsonstr2 = new_jsonstr1.replace('"searchFinanceId"', '"carSearchId"');
															//var new_jsonstr3 = new_jsonstr2.replace('"regoState"', '"regoStat"');
															//var new_jsonstr4 = new_jsonstr3.replace('"feulType"', '"fuelType"');
															//var new_jsonstr5 = new_jsonstr4.replace('"fname"', '"freeText"');
															//var new_jsonstr6 = new_jsonstr5.replace('"coveredUnderIns"', '"coveredUnderIns"');
															//var new_jsonstr7 = new_jsonstr6.replace('"curInsProv"', '"CURINSPROV"');
															//var new_jsonstr8 = new_jsonstr4.replace('"lookService"', '"flex1"');
															//var new_jsonstr9 = new_jsonstr8.replace('"carColor"', '"color"');
															// You probably want to parse the altered string later
															var new_obj = JSON.parse(new_jsonstr2);

															
															//alert("new"+JSON.stringify(new_obj));
															
															///console.log(JSON.stringify(new_obj));
															//alert("Before Call");
															//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
															//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
															var wsURL = 'api/dealerQuotFinCreation?_method=PUT';
															//var wsURL = '';
															$body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: JSON.stringify(new_obj)

																			}).success(function(data) {
																				$body.removeClass("loading");
																				$scope.vehicleRetrievalforLogBook();
																				alert("Successfully Stored Quotation However, Plz wait for the images to upload.. don't refresh or switch from your page..  the upload of images will start soon..");
																				//alert("Service & Maintenance Successfully Stored..");


													                			if(filefileChooserlogservmaint){
													                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																				logServMaintloadImage();
																				//alert("Before reset correct15689899");
													                			document.getElementById("QuoteNewfrm").reset();
													                			}
													                			else {
												                                	alert("No upload of images found..");
												                                	//alert("Before reset correct15689899");
														                			document.getElementById("QuoteNewfrm").reset();
												                                }

																							});
														}
															};
														// end of finance creatioin

														// start of QUotation Creation
														$scope.submitTpMyQuoteNewfrm = function(isValid) {
															//alert("inside Sesdarv Maint"+isValid);
															if (isValid) {
															/*alert("inside Sesdarv Maint");
															alert(myVehicleIDuse);*/
															/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
															var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/

															//logServMaintloadImage();
															var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
															var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
															var objKeyfilefileChooserlogservmaint ='noImage';
															if(filefileChooserlogservmaint){
															objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
															//alert(objKeyfilefileChooserlogservmaint);
															/*//alert(objKeyfilefileChooserlogservmaint);
															var jsonInputToAPI = {
																		"dealerId":null,
																		"userId":null,
																		"dealSearchId":null,
																		"carSearchId":null,
																		"refId":null,
																		"dealerStockNo":null,
																		"driveAwayPrice":null,
																		"modelYear":null,
																		"modelDisplay":null,
																		"modelName":null,
																		"modelTrim":null
																	}*/
															
															jsonInput = $scope.vehicleData;
															
															jsonInput["TranspServQuotId"]=null;
															//$scope.LeadSvQuoteId;
															//alert("dealer Lead id"+$scope.LeadSvQuoteId);
															//alert("rego end date"+$scope.finSvDOB);
															//alert("Exter dealer id"+$scope.ExtSvDealerId);
															//$scope.ExtDealerId=0;
															
															jsonInput["dealerId"]=$scope.ExtTpDealerId;
															jsonInput["driveAwayPrice"]=$scope.finTpAnnualIncome;
															jsonInput["offerPrice2"]=$scope.finTpAnnualIncome1;
															jsonInput["offerPrice3"]=$scope.finTpAnnualIncome2;
															jsonInput["offerValidDate"]=$scope.finTpDOB;
															// 07072017
															jsonInput["dealTranspServId"]=$scope.LeadTpQuoteId;
															jsonInput["address"]=objKeyfilefileChooserlogservmaint;
															jsonInput["modelYear"]=$scope.caryearsfin;
															        jsonInput["modelDisplay"]=$scope.carmakesfin;
															                    jsonInput["modelName"]=$scope.carmodelsfin;
															                              jsonInput["modelTrim"]=$scope.carmodelAutotrimsfin;
															                              
															                              jsonInput["fname"]=$scope.servSvAddNotes;
															var table1 = $("#my-table966");
								                            var table = table1.tableToJSON({
								                                ignoreColumns:[0],
								                                headings: ['extras1', 'extras2', 'amount']
								                              });
								                            //delete table[0];

								                            table.splice(0,1);

								                            jsonInput.vehQuotExtras = table ;
															//alert("value"+jsonInput);
															
															
															// Transfer the object to a JSON string
															var jsonstr1 = JSON.stringify(jsonInput);

															// HERE you do the transform
															
															//var new_jsonstr = jsonstr1.replace('"searchServMaintId"', '"carSearchId"');
															var new_jsonstr = jsonstr1.replace('"idp"', '"userId"');
															var new_jsonstr1 = new_jsonstr.replace('"creationDate"', '"userCreationDate"');
															var new_jsonstr2 = new_jsonstr1.replace('"regNo"', '"regoNo"');
															var new_jsonstr3 = new_jsonstr2.replace('"regoState"', '"regoStat"');
															//var new_jsonstr4 = new_jsonstr3.replace('"feulType"', '"fuelType"');
															//var new_jsonstr5 = new_jsonstr4.replace('"fname"', '"freeText"');
															//var new_jsonstr6 = new_jsonstr5.replace('"coveredUnderIns"', '"coveredUnderIns"');
															//var new_jsonstr7 = new_jsonstr6.replace('"curInsProv"', '"CURINSPROV"');
															//var new_jsonstr8 = new_jsonstr4.replace('"lookService"', '"flex1"');
															//var new_jsonstr9 = new_jsonstr8.replace('"carColor"', '"color"');
															// You probably want to parse the altered string later
															var new_obj = JSON.parse(new_jsonstr3);

															
															//alert("new"+JSON.stringify(new_obj));
															
															console.log(JSON.stringify(new_obj));
															//alert("Before Call");
															//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
															//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
															var wsURL = 'api/dealerQuotTpCreation?_method=PUT';
															//var wsURL = '';
															$body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: JSON.stringify(new_obj)

																			}).success(function(data) {
																				$body.removeClass("loading");
																				$scope.vehicleRetrievalforLogBook();
																				alert("Successfully Stored Quotation However, Plz wait for the images to upload.. don't refresh or switch from your page..  the upload of images will start soon..");
																				//alert("Service & Maintenance Successfully Stored..");


													                			if(filefileChooserlogservmaint){
													                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																				logServMaintloadImage();
																				//alert("Before reset correct15689899");
													                			document.getElementById("QuoteNewfrm").reset();
													                			}
													                			else {
												                                	alert("No upload of images found..");
												                                	//alert("Before reset correct15689899");
														                			document.getElementById("QuoteNewfrm").reset();
												                                }

																							});
														}
															};
														// end of QUotation Creation
														
														
														
														$scope.submitSvMyQuoteNewfrm = function(isValid) {
															//alert("inside Sesdarv Maint"+isValid);
															if (isValid) {
															/*alert("inside Sesdarv Maint");
															alert(myVehicleIDuse);*/
															/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
															var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/

															//logServMaintloadImage();
															var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
															var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
															var objKeyfilefileChooserlogservmaint ='noImage';
															if(filefileChooserlogservmaint){
															objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
															//alert(objKeyfilefileChooserlogservmaint);
															/*//alert(objKeyfilefileChooserlogservmaint);
															var jsonInputToAPI = {
																		"dealerId":null,
																		"userId":null,
																		"dealSearchId":null,
																		"carSearchId":null,
																		"refId":null,
																		"dealerStockNo":null,
																		"driveAwayPrice":null,
																		"modelYear":null,
																		"modelDisplay":null,
																		"modelName":null,
																		"modelTrim":null
																	}*/
															
															jsonInput = $scope.vehicleData;
															
															jsonInput["servMaintQuotId"]=null;
															//$scope.LeadSvQuoteId;
															//alert("dealer Lead id"+$scope.LeadSvQuoteId);
															//alert("rego end date"+$scope.finSvDOB);
															//alert("Exter dealer id"+$scope.ExtSvDealerId);
															$scope.ExtDealerId=0;
															
															jsonInput["dealerId"]=$scope.ExtSvDealerId;
															jsonInput["driveAwayPrice"]=$scope.finSvAnnualIncome;
															jsonInput["offerPrice2"]=$scope.finSvAnnualIncome1;
															jsonInput["offerPrice3"]=$scope.finSvAnnualIncome2;
															jsonInput["offerValidDate"]=$scope.finSvDOB;
															// 07072017
															jsonInput["dealServMaintId"]=$scope.LeadSvQuoteId;
															jsonInput["address"]=objKeyfilefileChooserlogservmaint;
															jsonInput["modelYear"]=$scope.caryearsfin;
															        jsonInput["modelDisplay"]=$scope.carmakesfin;
															                    jsonInput["modelName"]=$scope.carmodelsfin;
															                              jsonInput["modelTrim"]=$scope.carmodelAutotrimsfin;
															                              
															                              jsonInput["fname"]=$scope.servSvAddNotes;
															var table1 = $("#my-table955");
								                            var table = table1.tableToJSON({
								                                ignoreColumns:[0],
								                                headings: ['extras1', 'extras2', 'amount']
								                              });
								                            //delete table[0];

								                            table.splice(0,1);

								                            jsonInput.vehQuotExtras = table ;
															//alert("value"+jsonInput);
															
															
															// Transfer the object to a JSON string
															var jsonstr1 = JSON.stringify(jsonInput);

															// HERE you do the transform
															
															//var new_jsonstr = jsonstr1.replace('"searchServMaintId"', '"carSearchId"');
															var new_jsonstr = jsonstr1.replace('"idp"', '"userId"');
															var new_jsonstr1 = new_jsonstr.replace('"creationDate"', '"userCreationDate"');
															var new_jsonstr2 = new_jsonstr1.replace('"regNo"', '"regoNo"');
															var new_jsonstr3 = new_jsonstr2.replace('"regoState"', '"regoStat"');
															var new_jsonstr4 = new_jsonstr3.replace('"feulType"', '"fuelType"');
															//var new_jsonstr5 = new_jsonstr4.replace('"fname"', '"freeText"');
															//var new_jsonstr6 = new_jsonstr5.replace('"coveredUnderIns"', '"coveredUnderIns"');
															//var new_jsonstr7 = new_jsonstr6.replace('"curInsProv"', '"CURINSPROV"');
															var new_jsonstr8 = new_jsonstr4.replace('"lookService"', '"flex1"');
															var new_jsonstr9 = new_jsonstr8.replace('"carColor"', '"color"');
															// You probably want to parse the altered string later
															var new_obj = JSON.parse(new_jsonstr9);

															
															//alert("new"+JSON.stringify(new_obj));
															
															console.log(JSON.stringify(new_obj));
															//alert("Before Call");
															//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
															//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
															var wsURL = 'api/dealerQuotSmCreation?_method=PUT';
															//var wsURL = '';
															$body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: JSON.stringify(new_obj)

																			}).success(function(data) {
																				$body.removeClass("loading");
																				$scope.vehicleRetrievalforLogBook();
																				alert("Successfully Stored Quotation However, Plz wait for the images to upload.. don't refresh or switch from your page..  the upload of images will start soon..");
																				//alert("Service & Maintenance Successfully Stored..");


													                			if(filefileChooserlogservmaint){
													                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																				logServMaintloadImage();
																				//alert("Before reset correct15689899");
													                			document.getElementById("QuoteNewfrm").reset();
													                			}
													                			else {
												                                	alert("No upload of images found..");
												                                	//alert("Before reset correct15689899");
														                			document.getElementById("QuoteNewfrm").reset();
												                                }

																							});
														}
															};
														
															
															// start of External Dealer Insurance Creation
															$scope.submitCrtExtDlInsNewfrm = function(isValid) {
																//alert("inside creation SM Dealessssssr"+isValid+$scope.categorySvExt);
																if (isValid) {
																
																var jsonInputToAPI = { "category": $scope.categoryInsExt, "companyName": $scope.companyInsExt, "street": $scope.streetInsExt, "suburb": $scope.suborbInsExt, "state": $scope.stateInsExt, "postCode": $scope.postInsExt, "phone": $scope.phoneInsExt, "website": $scope.websiteInsExt, "mobile": $scope.mobileInsExt, "tollFree": $scope.tollfreeInsExt, "fax": $scope.faxInsExt, "afterHours": $scope.afterHoursInsExt, "postalAddress": $scope.postalAddressInsExt, "email": $scope.emailInsExt, "longitude": $scope.longitudeInsExt, "latitude": $scope.latitudeInsExt};
																	
																//alert("jsonInputToAPI"+jsonInputToAPI);
									                            var wsURL = 'api/extdealerInsCreation';
																//var wsURL = '';
																$body.addClass("loading");
																	    $http({
																					method : 'POST',
																					url : wsURL,
																					data: JSON.stringify(jsonInputToAPI)

																				}).success(function(data) {
																					$body.removeClass("loading");
																					alert("Successfully Stored create External Dealer Insurer's with id"+data.externalDealerId);
																					//alert("Service & Maintenance Successfully Stored..");



																								});
															}
																};
															// end of Insurance Dealer
																
																// start of Loyality Program Creation
																$scope.submitCrtExtDlLylNewfrm = function() {
																	//alert("inside creation SM Dealessssssr"+isValid+$scope.categorySvExt);
																	/*if (isValid) {*/
																	//alert("division by"+$scope.revDivBy);
																	var jsonInputToAPI = { "revName": $scope.reviewName, "revAction1": $scope.reviewNameAct, "revDivByAct1": $scope.revDivBy, "revAction2": $scope.reviewNameAct1, "revDivByAct2": $scope.revDivBy1,"blogName": $scope.blogName, "blogAction1": $scope.blogNameAct, "blogDivByAct1": $scope.blgDivBy, "blogAction2": $scope.blogNameAct1, "blogDivByAct2": $scope.blgDivBy1,"referredName": $scope.refedName, "referredAction1": $scope.refedNameAct, "referredDivByAct1": $scope.refedDivBy, "referredAction2": $scope.refedNameAct1, "referredDivByAct2": $scope.refedDivBy1,"userReferName": $scope.userRefedName, "userReferAction1": $scope.userRefedNameAct, "userReferDivByAct1": $scope.userReferDivBy, "userReferAction2": $scope.userRefedNameAct1, "userReferDivByAct2": $scope.userReferDivBy1,"typeOfTrans": $scope.valTransName, "buyCarDivByAct1": $scope.valTransDivBy, "buyCarAction1": $scope.valTransNameAct, "buyCarDivByAct2": $scope.valTransDivBy1, "buyCarAction2": $scope.valTransNameAct1, "typeOfSell": $scope.valSelTransName, "sellCarDivByAct1": $scope.valSelTransDivBy, "sellCarAction1": $scope.valSelTransNameAct, "sellCarDivByAct2": $scope.valSelTransDivBy1, "sellCarAction2": $scope.valSelTransNameAct1, "typeOfFin": $scope.valFinTransName, "finCarDivByAct1": $scope.valFinTransDivBy, "finCarAction1": $scope.valFinTransNameAct, "finCarDivByAct2": $scope.valFinTransDivBy1, "finCarAction2": $scope.valFinTransNameAct1, "typeOfIns": $scope.valInsTransName, "insCarDivByAct1": $scope.valInsTransDivBy, "insCarAction1": $scope.valInsTransNameAct, "insCarDivByAct2": $scope.valInsTransDivBy1, "insCarAction2": $scope.valInsTransNameAct1,"typeOfTrnp": $scope.valTrpTransName, "transpCarDivByAct1": $scope.valTrpTransDivBy, "transpCarAction1": $scope.valTrpTransNameAct, "transpCarDivByAct2": $scope.valTrpTransDivBy1, "transpCarAction2": $scope.valTrpTransNameAct1, "typeOfServ": $scope.valSrvTransName, "servCarDivByAct1": $scope.valSrvTransDivBy, "servCarAction1": $scope.valSrvTransNameAct, "servCarDivByAct2": $scope.valSrvTransDivBy1, "servCarAction2": $scope.valSrvTransNameAct1};
																		
																	//alert("jsonInputToAPI"+jsonInputToAPI);
																	//console.log(JSON.stringify(jsonInputToAPI));
										                            var wsURL = 'api/loyalPrgCreation';
																	//var wsURL = '';
																	$body.addClass("loading");
																		    $http({
																						method : 'POST',
																						url : wsURL,
																						data: JSON.stringify(jsonInputToAPI)

																					}).success(function(data) {
																						$body.removeClass("loading");
																						alert("Successfully Stored create loyality Program"+data.loyalityProgramId);
																						//alert("Service & Maintenance Successfully Stored..");



																									});
																/*}*/
																	};
																// end of Insurance Dealer
															
															// start of Finance Dealer
															// start of External Dealer SM Creation
															$scope.submitCrtExtDlFinNewfrm = function(isValid) {
																//alert("inside creation SM Dealessssssr"+isValid+$scope.categorySvExt);
																if (isValid) {
																
																var jsonInputToAPI = { "category": $scope.categoryFinExt, "companyName": $scope.companyFinExt, "street": $scope.streetFinExt, "suburb": $scope.suborbFinExt, "state": $scope.stateFinExt, "postCode": $scope.postFinExt, "phone": $scope.phoneFinExt, "website": $scope.websiteFinExt, "mobile": $scope.mobileFinExt, "tollFree": $scope.tollfreeFinExt, "fax": $scope.faxFinExt, "afterHours": $scope.afterHoursFinExt, "postalAddress": $scope.postalAddressFinExt, "email": $scope.emailFinExt, "longitude": $scope.longitudeFinExt, "latitude": $scope.latitudeFinExt};
																	
																//alert("jsonInputToAPI"+jsonInputToAPI);
									                            var wsURL = 'api/extdealerFinCreation';
																//var wsURL = '';
																$body.addClass("loading");
																	    $http({
																					method : 'POST',
																					url : wsURL,
																					data: JSON.stringify(jsonInputToAPI)

																				}).success(function(data) {
																					$body.removeClass("loading");
																					alert("Successfully Stored create External Dealer Financer's with id"+data.externalDealerId);
																					//alert("Service & Maintenance Successfully Stored..");



																								});
															}
																};
															// end of Finance Dealer
															
															// start of Transport Dealer
															
															$scope.submitCrtExtDlTpNewfrm = function(isValid) {
																//alert("inside creation SM Dealessssssr"+isValid+$scope.categorySvExt);
																if (isValid) {
																
																var jsonInputToAPI = { "category": $scope.categoryTpExt, "companyName": $scope.companyTpExt, "abnNumber": $scope.abnNumberTpExt, "contactPerson": $scope.contactPersonTpExt, "transportFrom": $scope.transportFromTpExt, "transportTo": $scope.transportToTpExt, "street": $scope.streetTpExt, "suburb": $scope.suborbTpExt, "state": $scope.stateTpExt, "postCode": $scope.postTpExt, "phone": $scope.phoneTpExt, "website": $scope.websiteTpExt, "mobile": $scope.mobileTpExt, "tollFree": $scope.tollfreeTpExt, "fax": $scope.faxTpExt, "afterHours": $scope.afterHoursTpExt, "postalAddress": $scope.postalAddressTpExt, "email": $scope.emailTpExt, "longitude": $scope.longitudeTpExt, "latitude": $scope.latitudeTpExt};
																	
																//alert("jsonInputToAPI"+jsonInputToAPI);
									                            var wsURL = 'api/extdealerTpCreation';
																//var wsURL = '';
																$body.addClass("loading");
																	    $http({
																					method : 'POST',
																					url : wsURL,
																					data: JSON.stringify(jsonInputToAPI)

																				}).success(function(data) {
																					$body.removeClass("loading");
																					alert("Successfully Stored create External Dealer Transport with id"+data.externalDealerId);
																					//alert("Service & Maintenance Successfully Stored..");



																								});
															}
																};
															// end of Transport Dealer
															
															
															// start of External Dealer SM Creation
															$scope.submitCrtExtDlSvNewfrm = function(isValid) {
																//alert("inside creation SM Dealessssssr"+isValid+$scope.categorySvExt);
																if (isValid) {
																
																var jsonInputToAPI = { "category": $scope.categorySvExt, "companyName": $scope.companySvExt, "street": $scope.streetSvExt, "suburb": $scope.suborbSvExt, "state": $scope.stateSvExt, "postCode": $scope.postSvExt, "phone": $scope.phoneSvExt, "website": $scope.websiteSvExt, "mobile": $scope.mobileSvExt, "tollFree": $scope.tollfreeSvExt, "fax": $scope.faxSvExt, "afterHours": $scope.afterHoursSvExt, "postalAddress": $scope.postalAddressSvExt, "email": $scope.emailSvExt, "longitude": $scope.longitudeSvExt, "latitude": $scope.latitudeSvExt};
																	
																//alert("jsonInputToAPI"+jsonInputToAPI);
																
																console.log(jsonInputToAPI);
									                            var wsURL = 'api/extdealerSvCreation';
																//var wsURL = '';
																$body.addClass("loading");
																	    $http({
																					method : 'POST',
																					url : wsURL,
																					data: JSON.stringify(jsonInputToAPI)

																				}).success(function(data) {
																					$body.removeClass("loading");
																					alert("Successfully Stored create External Dealer Sv with id"+data.externalDealerId);
																					//alert("Service & Maintenance Successfully Stored..");



																								});
															}
																};
															// end of External Dealer SM Creation
														
															// start of External Dealer Creation
															$scope.submitCrtExtDlNewfrm = function(isValid) {
																//alert("inside creation Dealessssssr"+isValid+$scope.categoryExt);
																if (isValid) {
																
																var jsonInputToAPI = { "category": $scope.categoryExt, "companyName": $scope.companyExt, "street": $scope.streetExt, "suburb": $scope.suborbExt, "state": $scope.stateExt, "postCode": $scope.postExt, "phone": $scope.phoneExt, "website": $scope.websiteExt, "mobile": $scope.mobileExt, "tollFree": $scope.tollfreeExt, "fax": $scope.faxExt, "afterHours": $scope.afterHoursExt, "postalAddress": $scope.postalAddressExt, "email": $scope.emailExt, "longitude": $scope.longitudeExt, "latitude": $scope.latitudeExt};
																	
																//alert("jsonInputToAPI"+jsonInputToAPI);
									                            var wsURL = 'api/extdealerCreation';
																//var wsURL = '';
																$body.addClass("loading");
																	    $http({
																					method : 'POST',
																					url : wsURL,
																					data: JSON.stringify(jsonInputToAPI)

																				}).success(function(data) {
																					$body.removeClass("loading");
																					alert("Successfully Stored create External Dealer with id"+data.externalDealerId);
																					//alert("Service & Maintenance Successfully Stored..");



																								});
															}
																};
															// end of External Dealer Creation
															
															
													$scope.submitMyQuoteNewfrm = function(isValid) {
														//alert("inside Sesdarv Maint"+isValid);
														if (isValid) {
														/*alert("inside Sesdarv Maint");
														alert(myVehicleIDuse);*/
														/*var vehicleTypeServMaint= stringToDate($('#vehicleTypeServMaint').val(),"dd/MM/yyyy","/");
														var nextServiceMaintenanceDate= stringToDate($('#nextServiceMaintenanceDate').val(),"dd/MM/yyyy","/");*/

														//logServMaintloadImage();
														var fileChooserlogservmaint = document.getElementById('file-chooser-logservmaint');
														var filefileChooserlogservmaint = fileChooserlogservmaint.files[0];
														var objKeyfilefileChooserlogservmaint ='noImage';
														if(filefileChooserlogservmaint){
														objKeyfilefileChooserlogservmaint = 'facebook-' + fbUserId + '/' + filefileChooserlogservmaint.name;}
														//alert(objKeyfilefileChooserlogservmaint);
														/*//alert(objKeyfilefileChooserlogservmaint);
														var jsonInputToAPI = {
																	"dealerId":null,
																	"userId":null,
																	"dealSearchId":null,
																	"carSearchId":null,
																	"refId":null,
																	"dealerStockNo":null,
																	"driveAwayPrice":null,
																	"modelYear":null,
																	"modelDisplay":null,
																	"modelName":null,
																	"modelTrim":null
																}*/
														
														jsonInput = $scope.vehicleData;
														
														jsonInput["quotId"]=null;
														//alert("dealer Search id"+$scope.LeadQuoteId);
														$scope.ExtDealerId=0;
														//$scope.LeadQuoteId=14;
														jsonInput["dealerId"]=$scope.ExtDealerId;
														jsonInput["driveAwayPrice"]=$scope.finAnnualIncome;
														jsonInput["offerPrice2"]=$scope.finAnnualIncome1;
														jsonInput["offerPrice3"]=$scope.finAnnualIncome2;
														jsonInput["basicPrice"]=$scope.finAnnualIncome4;
														jsonInput["regoEndDate"]=$scope.finDOB;
														jsonInput["dealSearchId"]=$scope.LeadQuoteId;
														jsonInput["address"]=objKeyfilefileChooserlogservmaint;
														jsonInput["modelYear"]=$scope.caryearsfin;
														        jsonInput["modelDisplay"]=$scope.carmakesfin;
														                    jsonInput["modelName"]=$scope.carmodelsfin;
														                              jsonInput["modelTrim"]=$scope.carmodelAutotrimsfin;
														                              
														                              jsonInput["fname"]=$scope.servAddNotes;
														var table1 = $("#my-table944");
							                            var table = table1.tableToJSON({
							                                ignoreColumns:[0],
							                                headings: ['extras1', 'extras2', 'amount']
							                              });
							                            //delete table[0];

							                            table.splice(0,1);

							                            jsonInput.vehQuotExtras = table ;
							                            
							                            var table2 = $("#my-table94424");
							                            var table0 = table2.tableToJSON({
							                                ignoreColumns:[0],
							                                headings: ['extras1', 'extras2', 'amount']
							                              });
							                            //delete table[0];

							                            table0.splice(0,1);

							                            jsonInput.vehQuotDoc = table0 ;
							                            //alert("vehExtras"+table);
														//alert("vehExtras"+jsonInput.vehQuotExtras);
							                            var table3 = $("#my-table94434");
							                            var table10 = table3.tableToJSON({
							                                ignoreColumns:[0],
							                                headings: ['extras1', 'extras2', 'amount']
							                              });
							                            //delete table[0];

							                            table10.splice(0,1);

							                            jsonInput.vehQuotTerm = table10 ;
														
														
														// Transfer the object to a JSON string
														var jsonstr1 = JSON.stringify(jsonInput);

														// HERE you do the transform
														var new_jsonstr = jsonstr1.replace('"userid"', '"userId"');
														var new_jsonstr1 = new_jsonstr.replace('"creationDate"', '"userCreationDate"');
														var new_jsonstr2 = new_jsonstr1.replace('"sModel"', '"transmission"');
														// You probably want to parse the altered string later
														var new_obj = JSON.parse(new_jsonstr2);

														
														//alert("new"+JSON.stringify(new_obj));
														
														//console.log(JSON.stringify(new_obj));
														//alert("Before Call");
														//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
														//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
														var wsURL = 'api/dealerQuotCreationExt?_method=PUT';
														//var wsURL = '';
														$body.addClass("loading");
															    $http({
																			method : 'POST',
																			url : wsURL,
																			data: JSON.stringify(new_obj)

																		}).success(function(data) {
																			$body.removeClass("loading");
																			$scope.vehicleRetrievalforLogBook();
																			alert("Successfully Stored Quotation However, Plz wait for the images to upload.. don't refresh or switch from your page..  the upload of images will start soon..");
																			//alert("Service & Maintenance Successfully Stored..");


												                			if(filefileChooserlogservmaint){
												                				alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																			logServMaintloadImage();
																			//alert("Before reset correct15689899");
												                			document.getElementById("QuoteNewfrm").reset();
												                			}
												                			else {
											                                	alert("No upload of images found..");
											                                	//alert("Before reset correct15689899");
													                			document.getElementById("QuoteNewfrm").reset();
											                                }

																						});
													}
														};



														$scope.VerfFrmSub = function(){
															//alert("inside submit update");
															
															alert($scope.carSearchId);
											        		/*alert($scope.mobCheck);
											        		alert($scope.VerfMob);
											        		alert($scope.VerfLIC);
											        		alert($scope.idCheck);*/
											        		var jsonInputToAPI = {"ID":$scope.carSearchId,
											        				"carSearchId":$scope.carSearchId,
											        				"mobCheck":$scope.mobCheck,
											        				"idCheck":$scope.idCheck,
											        				"VerfMob":$scope.VerfMob,
											        				"VerfLIC":$scope.VerfLIC
																	}
											        		//console.log(JSON.stringify(jsonInputToAPI));
											        		var wsURL = 'api/dealer/updateStatus';
															 //$body.addClass("loading");
																    $http({
																				method : 'POST',
																				url : wsURL,
																				data: jsonInputToAPI

																			}).success(function(data) {
																				 //$body.removeClass("loading");
																				alert("Successfully updated Status..");
																				//alert("Fuel Expenses Successfully Stored..");
																							});
														
														}
														$scope.submitMyVehicleFuelExpenses = function(isValid) {
															//alert("inside Fuel Expe"+isValid);
															if (isValid) {
															//alert("inside Fuel Expe")
															//logExpensesloadImage();
															var fileChooserLogExp = document.getElementById('file-chooser-lognewexp');
						var filelogexp = fileChooserLogExp.files[0];
						var objKeylogexp ='noImage';
						if(filelogexp){
						objKeylogexp = 'facebook-' + fbUserId + '/' + filelogexp.name;}
				//alert("Image of MyVehicle"+objKeylogexp);;

															//alert(myVehicleIDuse);
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


															//alert("Before Call");
															//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
															//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
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
																				//alert("Fuel Expenses Successfully Stored..");



																				if(filelogexp){
																					alert("Plz wait for the images to upload.. don't refresh or switch from dashboard.. the upload of images will start soon..");
																				logExpensesloadImage();
																				//alert("Before reset correct15689899");
																				document.getElementById("logexpensefrm").reset();
																				}
																				else {
												                                	alert("No upload of images found..");
												                                	//alert("Before reset correct15689899");
												                                	document.getElementById("logexpensefrm").reset();

												                                }


																							});
														}
															};




				});
//angular.bootstrap(document, ['mainApp1']);
//angular JS end




