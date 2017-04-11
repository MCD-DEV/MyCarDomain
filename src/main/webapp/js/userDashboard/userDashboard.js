// Check if "key" exists in the storage
var value = $.jStorage.get("key");
var fbUserId = $.jStorage.get("fbKey");
if(!value){
    // if not - load the data from the server
//alert("can inside");
    //value = load_data_from_server()
    // and save it
    $.jStorage.set("key",value);
}
//alert("can"+value.userId);
/*console.log(value);
alert(value);*/
//alert("can"+value.userId);
	
function signingout(){
	
	 $.jStorage.deleteKey("key");
	 $.jStorage.deleteKey("carKey");
	 $.jStorage.deleteKey("fbKey");
	 alert("Successfully Logged Out");
	 window.location="homepage10.html";
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
	
	var userDetails ='<a href="#" class="button btn-mini pull-right edit-profile-btn">EDIT PROFILE</a>\
		<h2 class="box-title fullname">' + value.firstName + '</h2>\
		<dl class="term-description">\
	    <dt>user name:</dt><dd>' +value.email+ '</dd>\
	    <dt>first name:</dt><dd>' +value.firstName+ '</dd>\
	    <dt>last name:</dt><dd>' +value.lastName+ '</dd>\
	    <dt>phone number:</dt><dd>' +value.mobile+ '</dd>\
	    <dt>Date of birth:</dt><dd>15 August 1985</dd>\
	    <dt>Street Address and number:</dt><dd>' +value.streetName+ '</dd>\
	    <dt>Town / City:</dt><dd>' +value.areaName+'</dd>\
	    <dt>ZIP code:</dt><dd>' +value.postCode+ '</dd>\
	    <dt>Country:</dt><dd>Australia</dd>\
		</dl>';
	/*alert("onload");
		alert(userDetails);
		console.log(userDetails);*/
	$(".userdetails").append(userDetails);

	
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
	
	userId = value.userId;
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
	
	
	
	
  
  //alert("Before call");
	dashBoardCallSearch('car-model-data',userId); 
  
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
}
function dashBoardPhotoUpdate()
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
	
	$.ajax({  
		type: "POST",  
		url: "api/eBid/updatePhoto?_method=PUT",
		data: jsonInputToAPI,
		contentType:'application/json',
		success: function(result){
			
			alert("Successfully upated photo to user");
			
		}
	});
	
}

function dashBoardCallSearch(model_data_id, userid)
{
	//alert("inside");
 this.model_data_id = model_data_id;
      //$("#"+this.model_data_id).html("Loading Model Data...");
    var sender = this;
    //var url = "http://www.autoscoop.com.au/api/user/"+userid;
   var url = "api/user/"+userid;
   //var url = "http://localhost:8080/MyCarDomain/api/user/"+userid;
//var url = "http://localhost:8080/MyCarDomain/api/user/"+userid;
//alert("user id"+url);

    //Get Car Model JSON for the selected make
    //http://localhost:8080/MyCarDomain/api/user/1
    /*alert("came here now changed are 3 Oct1");*/
    $.ajax({  
    	/*headers: {"X-My-Custom-Header": "*"},*/
   	    type: "GET",  
   	    url: url, 
   	 /*url: "http://localhost:8080/MyCarDomain/api/user/1",*/
   	       success: function(result){
   	    	   /*alert(result.abnNumber);
        	   alert(result.userId);
        	   alert(result.search);
        	   alert(result.search[0].carSearchId);
        	   alert(result.search.length);*/
   	    	   //alert("processing the data");
        	   out="";
        	   /*alert(Object.keys( result.search ).length);*/
        	   /*var json = JSON.parse(result1);*/
        	   /*var json = $.parseJSON(result1);*/
        	   var finMax = result.search.length;
        	   document.getElementById('finMax').innerHTML=finMax;
        	   //out += '<tr><th>'+"Car Search ID"+'</th><th>'+"Autoscoop Trim"+'</th><th>'+'</th><th>'+"Model Trim"+'</th><th>'+"Model Display"+'</th><th>'+"Model Year"+'</th><th>'+"Operation"+'</th></tr>';
        	   out += '<tr><th>'+"Car Ebid ID"+'</th><th>'+"Year"+'</th>'+'<th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Autoscoop Variant"+'</th><th>'+"Operation"+'</th></tr>';
        	   for(i=result.search.length-1;i>=0;i--)
       		{
       		/*alert(result.search[i].carSearchId); //111 111-1111
       		alert(result.search[i].modelDisplay);
       		alert(result.search[i].modelTrim);
       		alert(result.search[i].modelYear);*/
       		//out= out+'<tr>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td>'+result.search[i].modelTrim+'</td>'+'<td>'+result.search[i].modelDisplay+'</td>'+'<td>'+result.search[i].modelYear+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
        		   out= out+'<tr>'+'<td>'+result.search[i].carSearchId+'</td>'+'<td>'+result.search[i].modelYear+'<td>'+result.search[i].modelDisplay+'</td>'+'</td>'+'<td>'+result.search[i].modelName+'</td>'+'<td>'+result.search[i].sModel+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleSearchModal-' + result.search[i].carSearchId + '" data-details=\'' + JSON.stringify(result.search[i]) + '\' class="anchor-editDealerVehicleSearchModal" data-toggle="modal" data-target="#editDealerVehicleSearchModal">View</a></td></tr>';
       		
       		}
        	   //alert(out);
        	   forFinance("car-model-data",out);/*
        	   $("#"+sender.model_data_id).append(out);*/
        	   //alert("came here 2");
        	   out1="";
        	   /*alert(Object.keys( result.search ).length);*/
        	   /*var json = JSON.parse(result1);*/
        	   /*var json = $.parseJSON(result1);*/
        	   var finCt = result.search.length;
        	   document.getElementById('finCt').innerHTML=finCt;
        	   out1 += '<tr><th>'+"Car Finance ID"+'</th><th>'+"Vehicle Value"+'</th><th>'+"Balloon Pay"+'</th><th>'+"Loan Amount"+'</th><th>'+"Operation"+'</th></tr>';
        	   for(i=0;i<result.searchFinance.length;i++)
       		{
       		/*alert(result.search[i].carSearchId); //111 111-1111
       		alert(result.search[i].modelDisplay);
       		alert(result.search[i].modelTrim);
       		alert(result.search[i].modelYear);*/
       		out1= out1+'<tr>'+'<td>'+result.searchFinance[i].searchFinanceId+'</td>'+'<td>'+result.searchFinance[i].vehValue+'</td>'+'<td>'+result.searchFinance[i].balloonPay+'</td>'+'<td>'+result.searchFinance[i].loanAmount+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleFinanceModal-' + result.searchFinance[i].searchFinanceId + '" data-details=\'' + JSON.stringify(result.searchFinance[i]) + '\' class="anchor-editDealerVehicleFinanceModal" data-toggle="modal" data-target="#editDealerVehicleFinanceModal">View</a></td></tr>';
       		
       		
       		}
        	  forFinance("data1",out1);
        	   
        	   /*this.model_data_id = "data1";
        	   alert("came here"+this.model_data_id);
        	   $("#"+sender.model_data_id).append(out1);*/
        	  /* alert("came here"+this.model_data_id);
        	   */
        	  out2="";
        	  var insRCt=result.searchInsurance.length;
        	   document.getElementById('insRCt').innerHTML=insRCt;
        	   out2 += '<tr><th>'+"Car Insurance ID"+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th><th>'+"Operation"+'</th></tr>';
        	   for(i=0;i<result.searchInsurance.length;i++)
       		{
       		
       		out2= out2+'<tr>'+'<td>'+result.searchInsurance[i].searchInsuranceId+'</td>'+'<td>'+result.searchInsurance[i].insuranceType+'</td>'+'<td>'+result.searchInsurance[i].marketValue+'</td>'+'<td>'+result.searchInsurance[i].agreedValue+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleInsuranceModal-' + result.searchInsurance[i].searchInsuranceId + '" data-details=\'' + JSON.stringify(result.searchInsurance[i]) + '\' class="anchor-editDealerVehicleInsuranceModal" data-toggle="modal" data-target="#editDealerVehicleInsuranceModal">View</a></td></tr>';
       		
       		
       		}
        	   
        	   forFinance("car-model-data2",out2);
//alert("result.search.length"+result.vehicleQuotation.length);
        	   out3="";
        	   var qtRecd = result.vehicleQuotation.length;
        	   document.getElementById('qtRecd').innerHTML=qtRecd;
        	   out3 += '<tr><th>'+"Car Quotation ID"+'</th><th>'+"Dealer Name"+'</th><th>'+"Dealer Stock No"+'</th><th>'+"drive away Price"+'</th><th>'+"Operation"+'</th></tr>';
        	   for(i=0;i<result.vehicleQuotation.length;i++)
       		{
       		
       		out3= out3+'<tr>'+'<td>'+result.vehicleQuotation[i].quotId+'</td>'+'<td>'+result.vehicleQuotation[i].dealerName+'</td>'+'<td>'+result.vehicleQuotation[i].dealerStockNo+'</td>'+'<td>'+result.vehicleQuotation[i].driveAwayPrice+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleQuotationModal-' + result.vehicleQuotation[i].quotId + '" data-details=\'' + JSON.stringify(result.vehicleQuotation[i]) + '\' class="anchor-editDealerVehicleQuotationModal" data-toggle="modal" data-target="#editDealerVehicleQuotationModal">Edit</a></td></tr>';
       		
       		
       		}
        	   
        	   forFinance("quo-model-data",out3);
//alert("result.search.length"+result.financeQuotation.length);
out4="";
var finQCt=result.financeQuotation.length;
document.getElementById('finQCt').innerHTML=finQCt;
        	   out4 += '<tr><th>'+"Car Quotation ID"+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th></tr>';
        	   for(i=0;i<result.financeQuotation.length;i++)
       		{
       		
       		out4= out4+'<tr>'+'<td>'+result.financeQuotation[i].vehicleQuotationId+'</td>'+'<td>'+result.financeQuotation[i].vehicleQuotationId+'</td>'+'<td>'+result.financeQuotation[i].vehicleQuotationId+'</td>'+'<td>'+result.financeQuotation[i].vehicleQuotationId+'</td>'+'</tr>';
       		
       		
       		}
        	   
        	   forFinance("quo-data1",out4);
//alert("result.search.length"+result.insuranceQuotation.length);
out5="";
var insQCt=result.insuranceQuotation.length;
        	   document.getElementById('insQCt').innerHTML=insQCt;
        	   out5 += '<tr><th>'+"Car Quotation ID"+'</th><th>'+"Insurance Type"+'</th><th>'+"Market Value"+'</th><th>'+"Agreed Value"+'</th></tr>';
        	   for(i=0;i<result.insuranceQuotation.length;i++)
       		{
       		
       		out5= out5+'<tr>'+'<td>'+result.insuranceQuotation[i].insuranceQuotationId+'</td>'+'<td>'+result.insuranceQuotation[i].insuranceQuotationId+'</td>'+'<td>'+result.insuranceQuotation[i].insuranceQuotationId+'</td>'+'<td>'+result.insuranceQuotation[i].insuranceQuotationId+'</td>'+'</tr>';
       		
       		
       		}
        	   
        	   forFinance("quo-model-data2",out5);
        	   
        	 //alert("result.search.length"+result.insuranceQuotation.length);
        	   out6="";
        	  
        	               	   out6 += '<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Operation"+'</th></tr>';
        	               	   for(i=0;i<result.myVehicle.length;i++)
        	              		{
        	              		
        	              		out6= out6+'<tr>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].year+'</td>'+'<td>'+result.myVehicle[i].make+'</td>'+'<td>'+result.myVehicle[i].model+'</td>'+'<td><a href="#" id="anchor-editDealerVehicleDetailModal-' + result.myVehicle[i].myVehicleId + '" data-details=\'' + JSON.stringify(result.myVehicle[i]) + '\' class="anchor-editDealerVehicleDetailModal" data-toggle="modal" data-target="#editDealerVehicleDetailModal">View</a></td></tr>';
        	              		
        	              		
        	              		}
        	               	
        	               	   forFinance("quo-model-data4",out6);
        	               	   
        	               	   //start
        	               	 var options = '<option value="">Please choose a car</option>';  
        	                 for(i=0;i<result.myVehicle.length;i++)
        	            		{
        	            		
        	            		//out= out+'<tr>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].make+'</td>' + '</tr>';
        	            		options += '<option value="' +result.myVehicle[i].myVehicleId+ '">' +result.myVehicle[i].make + '</option>';
        	            		
        	            		}
        	            	   
        	                   //alert(options);
        	                   $("#vehicleTypeLogBook").html(options);
        	               	   // end
        	                   
        	                 //start
          	               	 var option1s = '<option value="">Please choose a car</option>';  
          	                 for(i=0;i<result.myVehicle.length;i++)
          	            		{
          	            		
          	            		//out= out+'<tr>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].make+'</td>' + '</tr>';
          	            		option1s += '<option value="' +result.myVehicle[i].myVehicleId+ '">' +result.myVehicle[i].make + '</option>';
          	            		
          	            		}
          	            	   
          	                   //alert(options);
          	                   $("#vehicleTypeServMaint").html(option1s);
          	               	   // end
          	                   
        	                   
        	               	 out7="";
        	           	  
      	               	   out7 += '<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th></tr>';
      	               	   for(i=0;i<result.myVehicle.length;i++)
      	              		{
      	              		
      	              		out7= out7+'<tr>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].year+'</td>'+'<td>'+result.myVehicle[i].make+'</td>'+'<td>'+result.myVehicle[i].model+'</td>'+'</tr>';
      	              		
      	              		
      	              		}
      	              
        	               	   forFinance("logBook4",out7);
        	               	   
        	               	out8="";
          	           	  
       	               	   out8 += '<tr><th>'+"Activity"+'</th><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th></tr>';
       	               	   for(i=0;i<result.myVehicle.length;i++)
       	              		{
       	              		
       	              		//out8= out8+'<tr><td><a href="#" id="anchor-editDealerVehicleInsuranceModal" class="logBookBtn">Log Book</a></td>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].year+'</td>'+'<td>'+result.myVehicle[i].make+'</td>'+'<td>'+result.myVehicle[i].model+'</td>'+'</tr>';
       	               		out8= out8+'<td><a href="#" id="anchor-editDealerVehicleDetailLogBookModal-' + result.myVehicle[i].myVehicleId + '" data-details=\'' + JSON.stringify(result.myVehicle[i]) + '\' class="anchor-editDealerVehicleDetailLogBookModal" data-toggle="modal" data-target="#editDealerVehicleDetailLogBookModal">LogBook</a></td><td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].year+'</td>'+'<td>'+result.myVehicle[i].make+'</td>'+'<td>'+result.myVehicle[i].model+'</td>'+'</tr>';
       	              		
       	              		}
       	               	   
         	               	forFinance("fuelCard4",out8);
         	               	//alert("logbook loaded");
         	               	
         	               out9="";
         	           	  
      	               	   out9 += '<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th></tr>';
      	               	   for(i=0;i<result.myVehicle.length;i++)
      	              		{
      	              		
      	              		out9= out9+'<tr>'+'<td>'+result.myVehicle[i].myVehicleId+'</td>'+'<td>'+result.myVehicle[i].year+'</td>'+'<td>'+result.myVehicle[i].make+'</td>'+'<td>'+result.myVehicle[i].model+'</td>'+'</tr>';
      	              		
      	              		
      	              		}
      	               	   
        	               	forFinance("servMaint4",out9);
        	               	registerEditDealerVehicleQuotationModal();
        	               	registerEditDealerVehicleSearchModal();
        	               	registerEditDealerVehicleFinanceModal();
        	               	registerEditDealerVehicleInsuranceModal();
        	               	registerEditDealerVehicleDetailModal();
        	               	registerEditDealerVehicleDetailLogBookModal();
           } 
   	  }); 
   /* $.ajax({
        url: "http://localhost:8080/MyCarDomain/api/user/70",
        data: { signature: authHeader },
        type: "GET",
        beforeSend: function(xhr){xhr.setRequestHeader('X-Test-Header', 'test-value');},
        success: function() { alert('Success!' + authHeader); }
     });*/
}

function forFinance(model_data_id, out)
{
 this.model_data_id = model_data_id;
      //$("#"+this.model_data_id).html("Loading Model Data...");
 //alert("came here 2 inside");
    
//alert("out"+out);
    
        	   //alert(out);
        	   $("#"+model_data_id).append(out);
        	   //alert("came here 2");
        	  
   /* $.ajax({
        url: "http://localhost:8080/MyCarDomain/api/user/70",
        data: { signature: authHeader },
        type: "GET",
        beforeSend: function(xhr){xhr.setRequestHeader('X-Test-Header', 'test-value');},
        success: function() { alert('Success!' + authHeader); }
     });*/
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
		
		var quotIdHiddenField = '<input type="hidden" name="quotId" value="' + data.quotId + '" />';
		var moveToUser = '<input type="checkbox" name="moveToUser" />'; 
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';
		
		
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
			</table></form>';
		
		$(".edit-dealer-vehicle-quotation-content").html(editDealerVehicleQuotationForm);
	});
	
	$('button.submit-editDealerVehicleQuotationModal').on('click', function(e) {
		
		var jsonInput = $("#edit-dealer-vehicle-quotation-content-form").convertFormDataToJSON();
		
		
		$.ajax({  
			type: "POST",  
			url: "api/vehicleQuotation?_method=PUT",
			data: jsonInput,
			contentType:'application/json',
			success: function(result){
				$("#anchor-editDealerVehicleQuotationModal-" + result.quotId).data('details', result);
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
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; 
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';*/
		
		alert(JSON.stringify(data));
		var editDealerVehicleSearchForm = '<form id="edit-dealer-vehicle-search-content-form"><table>\
			<tr><td>Search ID</td><td>' + data.carSearchId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Model Year</td><td>' + data.modelYear + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.modelName + '</td></tr>\
			<tr><td>Model Display</td><td>' + data.modelDisplay + '</td></tr>\
			<tr><td>Model Trim</td><td>' + data.modelTrim + '</td></tr>\
			<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
			<tr><td>Insurance</td><td>' + data.insurance + '</td></tr>\
			<tr><td>Dealer</td><td>' + data.dealer + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Body Type</td><td>' + data.bodyType + '</td></tr>\
			<tr><td>Car Color</td><td>' + data.carColor + '</td></tr>\
			<tr><td>State</td><td>' + data.state + '</td></tr>\
			<tr><td>Region</td><td>' + data.region + '</td></tr>\
			<tr><td>PostCode</td><td>' + data.postCode + '</td></tr>\
			<tr><td>Finance Amount Min</td><td>' + data.finAmountMin + '</td></tr>\
			<tr><td>Finance Amount Max</td><td>' + data.finAmountMax + '</td></tr>\
			<tr><td>Support 24/7</td><td>' + data.support247 + '</td></tr>\
			<tr><td>Road Side Assistance</td><td>' + data.roadSideAssistance + '</td></tr>\
			<tr><td>Guarantee Replacement</td><td>' + data.guaranteeReplacement + '</td></tr>\
			<tr><td>Hiring Car</td><td>' + data.hiringCar + '</td></tr>\
			<tr><td>Comprehensive Cover</td><td>' + data.comprehensiveCover + '</td></tr>\
			<tr><td>ThirdParty Cover</td><td>' + data.thirdPartyCover + '</td></tr>\
			<tr><td>AusCapTer</td><td>' + data.ausCapTer + '</td></tr>\
			<tr><td>SModel</td><td>' + data.sModel + '</td></tr>\
			<tr><td>SMake</td><td>' + data.sMake + '</td></tr>\
			<tr><td>Extra External 1</td><td>' + data.ExtraExter2 + '</td></tr>\
			<tr><td>Extra External 2</td><td>' + data.ExtraExter3 + '</td></tr>\
			<tr><td>Extra External 3</td><td>' + data.ExtraExter4 + '</td></tr>\
			<tr><td>Extra External 4</td><td>' + data.ExtraExter5 + '</td></tr>\
			<tr><td>Extra Internal 1</td><td>' + data.ExtraIntern1 + '</td></tr>\
			<tr><td>Extra Internal 2</td><td>' + data.ExtraIntern2 + '</td></tr>\
			<tr><td>Extra Internal 3</td><td>' + data.ExtraIntern3 + '</td></tr>\
			<tr><td>Extra Internal 4</td><td>' + data.ExtraIntern4 + '</td></tr>\
			<tr><td>Extra Internal 5</td><td>' + data.ExtraIntern5 + '</td></tr>\
			</table></form>';
		
		$(".edit-dealer-vehicle-search-content").html(editDealerVehicleSearchForm);
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
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; 
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';*/
		
		
		var editDealerVehicleFinanceForm = '<form id="edit-dealer-vehicle-finance-content-form"><table>\
			<tr><td>Search ID</td><td>' + data.searchFinanceId + '</td></tr>\
			<tr><td>' + quotIdHiddenField + '</td></tr>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model Name</td><td>' + data.model + '</td></tr>\
			<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
			<tr><td>Vehicle Value</td><td>' + data.vehValue + '</td></tr>\
			<tr><td>Balloon Pay</td><td>' + data.balloonPay + '</td></tr>\
			<tr><td>Loan Amount</td><td>' + data.loanAmount + '</td></tr>\
			<tr><td>Loan Period</td><td>' + data.loanPeriod + '</td></tr>\
			<tr><td>Annual Income</td><td>' + data.annualIncome + '</td></tr>\
			<tr><td>Income Type</td><td>' + data.incomeType + '</td></tr>\
			<tr><td>Credit Rating</td><td>' + data.creditRating + '</td></tr>\
			<tr><td>Date of Birth</td><td>' + data.dateOfBirth + '</td></tr>\
			<tr><td>Year Employment Business</td><td>' + data.yearEmploymentBusiness + '</td></tr>\
			<tr><td>Income Before Super Tax</td><td>' + data.incomeBeforeSuperTax + '</td></tr>\
			<tr><td>Income After Super Tax</td><td>' + data.incomeAfterSuperTax + '</td></tr>\
			<tr><td>If Business Provide ABN</td><td>' + data.ifBusinessProvideABN + '</td></tr>\
			</table></form>';
		
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
		
		var quotIdHiddenField = '<input type="hidden" name="financeSearchId" value="' + data.searchInsuranceId + '" />';
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; 
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';*/
		
		
		var editDealerVehicleInsuranceForm = '<form id="edit-dealer-vehicle-insurance-content-form"><table>\
			<tr><td>Search ID</td><td>' + data.searchInsuranceId + '</td></tr>\
			<tr><td>Post Code</td><td>' + data.postCode + '</td></tr>\
			<tr><td>Year</td><td>' + data.year + '</td></tr>\
			<tr><td>Make</td><td>' + data.make + '</td></tr>\
			<tr><td>Model</td><td>' + data.model + '</td></tr>\
			<tr><td>Variant</td><td>' + data.variant + '</td></tr>\
			<tr><td>insuranceType</td><td>' + data.insuranceType + '</td></tr>\
			<tr><td>Registration No:</td><td>' + data.regNo + '</td></tr>\
			<tr><td>Rego State</td><td>' + data.regoState + '</td></tr>\
			<tr><td>Market Value</td><td>' + data.marketValue + '</td></tr>\
			<tr><td>Agreed Value</td><td>' + data.agreedValue + '</td></tr>\
			<tr><td>Finance</td><td>' + data.finance + '</td></tr>\
			<tr><td>Finance Provider</td><td>'+ data.financeProvider + '</td></tr>\
			<tr><td>Driving License Type</td><td>' + data.drivingLicenseType + '</td></tr>\
			<tr><td>Driving License No:</td><td>' + data.drivingLicenseNo + '</td></tr>\
			<tr><td>Driving License Issue State</td><td>' + data.drivingLicenseIssueState + '</td></tr>\
			<tr><td>No Of AtFaults</td><td>' + data.noOfAtFaults + '</td></tr>\
			<tr><td>Other Issues</td><td>' + data.otherIssues + '</td></tr>\
			<tr><td>Current Ins-Prov</td><td>' + data.curInsProv + '</td></tr>\
			<tr><td>Pref Excess Amount</td><td>' + data.prefExcessAmount + '</td></tr>\
			<tr><td>DateOfBirth</td><td>' + data.dateOfBirth + '</td></tr>\
			<tr><td>Age Of Additional Driver</td><td>' + data.ageOfAdditionalDriver + '</td></tr>\
			</table></form>';
		
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
		
		
		var editDealerVehicleDetailForm = '<form id="edit-dealer-vehicle-detail-content-form"><table>\
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
		
		$(".edit-dealer-vehicle-detail-content").html(editDealerVehicleDetailForm);
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

// change here
	//alert("log html gene");
	//Add a Bootstrap Modal DIV to Edit Dealer Vehicle Quotation Details
	/*var editDealerVehicleDetailLogBookModal = '<div id="selectedRecord">\
		<h4><center>Log Book Details for Vehicle</center></h4><a class="button btn-mini pull-right" id="BackToVehicles">Back To Vehicles Log</a>\
		<div class="edit-dealer-vehicle-detail-logbook-content">\
	            </div>\
		<br/>\
		<br/>\
		<ul class="nav nav-tabs">\
	    <li class="active"><a data-toggle="tab" href="#logTrip">Log Trip</a></li>\
	    <li><a data-toggle="tab" href="#LogExp">Log Expenses</a></li>\
	    <li><a data-toggle="tab" href="#ServMain">Service & Maintenance Log</a></li>\
	  </ul>\
	  <div class="tab-content">\
	    <div id="logTrip" class="tab-pane fade in active">\
	    <div class="col-md-12"><button id="LogNewButton">Log a New Trip</button></div>\
		<div class="booking-section travelo-box" id="LogNew">\
		<form class="booking-form">\
    	<div class="form-group row">\
		   <div class="col-sm-6 col-md-6">\
				<label>Vehicle Type</label>\
				<input type="text" id="vehicleType" name="vehicleType" class="input-text full-width" value="" placeholder="" />\
			</div>\
			<div class="col-sm-6 col-md-6">\
					<label>Trip Type</label>\
					<div class="selector">\
						<select class="full-width" id="tripType" name="tripType">\
							<option>Private</option>\
							<option>Business</option>\
							<option>Other</option>\
						</select>\
					</div>\
			 </div>\
		</div>\
		<div class="form-group row">\
			<div class="col-sm-6 col-md-6">\
				<label>Trip Description</label>\
				<input type="text" id="tripDescription" name="tripDescription" class="input-text full-width" value="" placeholder="" />\
			</div>\
			<div class="col-sm-6 col-md-6">\
				<label>From Location Post Code</label>\
				<input type="text" id="lPostCode" name="lPostCode" class="input-text full-width" value="" placeholder="" />\
			</div>\
		</div>\
		<div class="form-group row">\
			<div class="col-sm-6 col-md-6">\
				<label>From Location Address</label>\
				<input type="text" id="lAPostCode" name="lAPostCode" class="input-text full-width" value="" placeholder="" />\
			</div>\
			<div class="col-sm-6 col-md-6">\
				<label>To Location Post Code</label>\
				<input type="text" id="tPostCode" name="tPostCode" class="input-text full-width" value="" placeholder="" />\
			</div>\
		</div>\
		<div class="form-group row">\
			<div class="col-sm-6 col-md-6">\
				<label>To Location Address</label>\
				<input type="text" id="tAPostCode" name="tAPostCode" class="input-text full-width" value="" placeholder="" />\
			</div>\
			<div class="col-sm-6 col-md-6">\
				<label>Odo Meter Start of the Trip Kms/Miles</label>\
				<input type="text" id="odoMeterStartTripKmsMiles" name="odoMeterStartTripKmsMiles" class="input-text full-width" value="" placeholder="" />\
			</div>\
		</div>\
		<div class="form-group row">\
			<div class="col-sm-6 col-md-6">\
				<label>Odometer End of the Trip</label>\
				<input type="text" id="odometerEndoftheTrip" name="odometerEndoftheTrip" class="input-text full-width" value="" placeholder="" />\
			</div>\
			 <div class="col-sm-6 col-md-6">\
				<label>Rout Kms/Miles</label>\
				<input type="text" id="routKmsMiles" name="routKmsMiles" class="input-text full-width" value="" placeholder="" />\
			</div>\
		</div>\
        <div class="form-group row">\
			<div class="col-sm-6 col-md-5">\
				<button type="button" class="full-width btn-large" id="LogSave" >Save</button>\
			</div>\
        </div>\
		</form>\
		</div>\
	    </div>\
	    <div id="LogExp" class="tab-pane fade">\
		<div class="col-md-12"><button id="LogNewExpButton">Log a New Expenses</button></div>\
	      <p>Your Expenses goes here</p>\
	    </div>\
	    <div id="ServMain" class="tab-pane fade">\
		<div class="col-md-12"><button id="LogNewSerButton">Log New Service & Maintenance</button></div>\
	      <p>Your Service & maintenance goes here</p>\
	    </div>\
	  </div>\
 	  </div>';*/

	//$(document.body).append(editDealerVehicleDetailLogBookModal);
		
	$('a.anchor-editDealerVehicleDetailLogBookModal').on('click', function(event) {
		alert("invoke sscnews click");
		$('#fuelCard4').toggle();
		//document.getElementById("fuelCard4").style.display = "none";
		var data = $(event.target).data('details');
		//var json = JSON.stringify(data);
		
		var quotIdHiddenField = '<input type="hidden" name="myVehicleId" value="' + data.myVehicleId + '" />';
		/*var moveToUser = '<input type="checkbox" name="moveToUser" />'; 
		if(data.moveToUser)
		  moveToUser = '<input type="checkbox" name="moveToUser" checked="checked" />';*/
		
		$('#fuelCard41').toggle();
		var wsURL = 'api/Myvehicle/'+data.myVehicleId;
		$.ajax({  
			type: "GET",  
			url: wsURL,
			contentType:'application/json',
			success: function(result){
				alert(JSON.stringify(result));
				var LogT = result.myVehicleLogBook;
				outLogT="";
				alert(LogT);
				alert(result.myVehicleLogBook.length);
				alert("viscuit");
				if(LogT)
					{
					/*var logTripTable = '<table>\
						<tr><th>'+"Trip Type"+'</th><th>'+"TripStart Addr"+'</th><th>'+"TripEnd Addr"+'</th><th>'+"Trip Date"+'</th><th>'+"OdoMeter Start"+'</th><th>'+"OdoMeter End"+'</th><th>'+"No of Kms"+'</th><th>'+"Purpose of Trim"+'</th><th>'+"Driver Name"+'</th><th>'+"Trip Log Date"+'</th></tr>\
						<tr><td>' + data.myVehicleId + '</td>\
						<td>' + data.year + '</td>\
						<td>' + data.make + '</td>\
						<td>' + data.model + '</td>\
						<td>' + data.variant + '</td></tr>\
						</table>';*/
					logTlen = result.myVehicleLogBook.length;
					outLogT += '<tr><th>'+"Trip Type"+'</th><th>'+"TripStart Addr"+'</th><th>'+"TripEnd Addr"+'</th><th>'+"Trip Date"+'</th><th>'+"OdoMeter Start"+'</th><th>'+"OdoMeter End"+'</th><th>'+"No of Kms"+'</th><th>'+"Purpose of Trip"+'</th><th>'+"Driver Name"+'</th><th>'+"Trip Log Date"+'</th></tr>';
	           	    for(i=0;i<logTlen;i++)
	          		 {
	           	    	outLogT= outLogT+'<tr>'+'<td>'+result.myVehicleLogBook[i].tripType+'</td>'+'<td>'+result.myVehicleLogBook[i].fromLocation+'</td>'+'<td>'+result.myVehicleLogBook[i].toLocation+'</td>'+'<td>'+result.myVehicleLogBook[i].date+'</td>'+'<td>'+result.myVehicleLogBook[i].odoMeterStartOfTrip+'</td>'+'<td>'+result.myVehicleLogBook[i].odoMeterEndOfTrip+'</td>'+'<td>'+result.myVehicleLogBook[i].routeKm+'</td>'+'<td>'+result.myVehicleLogBook[i].tripDescription+'</td>'+'<td>'+result.myVehicleLogBook[i].flex1+'</td></tr>';
	          		 }
					}
				else
					{
					outLogT='<h2>No records for Log Trips</h2>';
					}
				$('#logTripTable').html(outLogT);
				
				
				var LogE = result.myVehicleFuelExpenses;
				outLogE="";
				if(LogE)
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
					outLogE += '<tr><th>'+"Expensive Type"+'</th><th>'+"Expensive Category"+'</th><th>'+"Expensive Date"+'</th><th>'+"Expensive Description"+'</th><th>'+"Amount"+'</th><th>'+"Uploaded Photo"+'</th></tr>';
	           	    for(i=0;i<logElen;i++)
	          		 {
	           	    	outLogE= outLogE+'<tr>'+'<td>'+result.myVehicleFuelExpenses[i].recordType+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].business+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].date+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].others+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].amount+'</td>'+'<td>'+result.myVehicleFuelExpenses[i].photoOfInvoice+'</td></tr>';
	          		 }

				}
			else
				{
				outLogE='<h2>No records for log Expenses</h2>';
				}
				$('#logExpTable').html(outLogE);
				
				
				
				
				var LogS = result.myVehicleServMaint;
				outLogS="";
				if(LogS)
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
					outLogS += '<tr><th>'+"Type of Service"+'</th><th>'+"Date of Service"+'</th><th>'+"Mileage/OdoMeter @Service"+'</th><th>'+"Detail Work Performed"+'</th><th>'+"List of Service"+'</th><th>'+"Notes"+'</th><th>'+"Technician"+'</th><th>'+"Service & maintenancec Company"+'</th><th>'+"Uploaded Maintenance record"+'</th></tr>'; 
						
	           	    for(i=0;i<logSlen;i++)
	          		 {
	           	    	outLogS= outLogS+'<tr>'+'<td>'+result.myVehicleServMaint[i].typeOfServMaint+'</td>'+'<td>'+result.myVehicleServMaint[i].date+'</td>'+'<td>'+result.myVehicleServMaint[i].odoMeterKm+'</td>'+'<td>'+result.myVehicleServMaint[i].flex1+'</td>'+'<td>'+result.myVehicleServMaint[i].flex2+'</td>'+'<td>'+result.myVehicleServMaint[i].flex3+'</td><td>'+result.myVehicleServMaint[i].mechanicName+'</td>'+'<td>'+result.myVehicleServMaint[i].companyName+'</td><td>'+result.myVehicleServMaint[i].flex4+'</td></tr>';
	          		 }
				}
			else
				{
				outLogS='<h2>No records for Service maintenance</h2>';
				}
				$('#logServMainTable').html(outLogS);
			}
		});
		
		
		
		
		
		
		//document.getElementById("fuelCard41").style.display = "block";
		var editDealerVehicleDetailLogBookForm = '<table>\
			<tr><th>'+"My Vehicle ID"+'</th><th>'+"Year"+'</th><th>'+"Make"+'</th><th>'+"Model"+'</th><th>'+"Variant"+'</th></tr>\
			<tr><td>' + data.myVehicleId + '</td>\
			<td>' + data.year + '</td>\
			<td>' + data.make + '</td>\
			<td>' + data.model + '</td>\
			<td>' + data.variant + '</td></tr>\
			</table>';
		//$("#fuelCard41").append(editDealerVehicleDetailLogBookModal);
		$(".edit-dealer-vehicle-detail-logbook-content").html(editDealerVehicleDetailLogBookForm);
		 $("#BackToVehicles").click(function(){
		        $('#fuelCard41').hide();
		        //$( "#fuelCard41" ).empty();
		        $('#fuelCard4').show();
		        //document.getElementById("fuelCard41").style.display = "none";
		        //document.getElementById("fuelCard4").style.display = "block";
		        //alert("The paragraph ssswas showed.");
		    });
		 
		   
		 
		 $("#LogSave").click(function(){
		        //alert("Log Save alertsssaasa.");
		        //angular.element(document.getElementById('LogNew')).scope().submitSearchFormLogBook();

				//alert("inside Log Book");
				//alert(""+$('#vehicleTypeLogBook').val());
				var jsonInputToAPI = {"myVehicleId":data.myVehicleId,
						"myVehicleLogBookVO":{
							"myVehicleLogBookId":null,
							"recordType": $('#vehicleTypeLogBook').val(),															      
							"tripType":$('#tripType').val(),
									"tripDescription" :$('#tripDescription').val(),
									 "fromLocation":$('#lPostCode').val(),
									"toLocation":$('#tPostCode').val(),
									"flex1":$('#lAPostCode').val(),
									"flex2":$('#tAPostCode').val(),
									"odoMeterStartOfTrip":$('#odoMeterStartTripKmsMiles').val(),
									"odoMeterEndOfTrip":$('#odometerEndoftheTrip').val(),
									"routeKm":$('#routKmsMiles').val(),
									"flex5":0,
									"flex6":0,
									"flex7":0
						}
						}

				var wsURL = 'api/myvehicle/addMyVehicleLogBook';
				//alert("before Ajax");
				alert($('#lPostCode').val());
				$.ajax({  
					type: "POST",  
					url: wsURL,
					data: JSON.stringify(jsonInputToAPI),
					contentType:'application/json',
					success: function(result){
						
						alert("Successfully saved");
						
					}
				});
				
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

	var url="homepage10.html?userId="+userId+"&firstName="+firstName;
	
	window.location=url;
}


//angular JS start
var mainApp1 = angular.module("mainApp13", []);
mainApp1.controller('myController13',function($scope, $http) {
					//alert("in user con");
					$scope.submitSearchForm = function() {
												
												var jsonInputToAPI = {"userId":userId,
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


												//alert("Before Call");
												//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
												//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
												var wsURL = 'api/eBid/myVehicle';
												
													    $http({
																	method : 'POST',
																	url : wsURL,
																	data: jsonInputToAPI
																					
																}).success(function(data) {
																	alert("Successfully Stored..");
																					alert("Thank You. Your MyVehicle ID is " + data.myVehicleId);
																													
																				});													
												};

																			
											
												$scope.submitSearchFormLogBook = function() {
													//alert("inside Log Book");
													//alert(""+$('#vehicleTypeLogBook').val());
													var jsonInputToAPI = {"myVehicleId":$('#vehicleTypeLogBook').val(),
															"myVehicleLogBookVO":{
																"myVehicleLogBookId":null,
																"recordType": $('#vehicleTypeLogBook').val(),															      
																"tripType":$('#tripType').val(),
																		"tripDescription" :$('#tripDescription').val(),
																		 "fromLocation":$('#lPostCode').val(),
																		"toLocation":$('#tPostCode').val(),
																		"flex1":$('#lAPostCode').val(),
																		"flex2":$('#tAPostCode').val(),
																		"odoMeterStartOfTrip":$('#odoMeterStartTripKmsMiles').val(),
																		"odoMeterEndOfTrip":$('#odometerEndoftheTrip').val(),
																		"routeKm":$('#routKmsMiles').val(),
																		"flex5":0,
																		"flex6":0,
																		"flex7":0
															}
															}

													console.log(JSON.stringify(jsonInputToAPI));
													//alert("Before Call");
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
														      alert(status);
														      alert(statusText);
														      alert(JSON.stringify(data));
														      alert(headers);
														      alert(config);
														      alert("Successfully Stored..");
																alert("Thank You. Your MyVehicle ID is ");
															
														    }, function onError(response) {
														      // Handle error
														      /*var data = response.data;
														      var status = response.status;
														      var statusText = response.statusText;
														      var headers = response.headers;
														      var config = response.config;*/
														      alert("Something went wrong in error storing LogBook");
														     /* alert(status);
														      alert(statusText);
														      alert(JSON.stringify(data));
														      alert(headers);
														      alert(config);*/
														    });
													};
													
													$scope.submitSearchFormServMaint = function() {
														alert("inside Serv Maint");
														var jsonInputToAPI = {"userId":userId,
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


														//alert("Before Call");
														//var wsURL = 'http://localhost:8080/MyCarDomain/api/eBid/myVehicle/';
														//var wsURL = 'http://www.autoscoop.com.au/api/eBid/myVehicle/';
														var wsURL = 'api/eBid/myVehicle';
														
															    $http({
																			method : 'POST',
																			url : wsURL,
																			data: jsonInputToAPI
																							
																		}).success(function(data) {
																			alert("Successfully Stored..");
																							alert("Thank You. Your MyVehicle ID is " + data.myVehicleId);
																															
																						});													
														};


												
				});
//angular.bootstrap(document, ['mainApp1']);
//angular JS end




