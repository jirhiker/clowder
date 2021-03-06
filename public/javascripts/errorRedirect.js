// File designed to handle ajax errors by allowing redirection to the login page with an appropriate message, as well as tracking
// the original URL that the user was on when the authentication failed. If they successfully authenticate, the user will be returned
// to the original URL.
//
// Referenced by: admin.scala.html, collectionofdatasets.scala.html, dataset.scala.html, datasetList.scala.html, 
//                datasetsContainingFile.scala.html, file.scala.html, filesList.scala.html
//
function checkErrorAndRedirect(jqXHR, userMsg) {
	var responseText = jqXHR.responseText;
    console.log("jqXHR.responseText is " + responseText);    
    if (responseText == "Not authenticated") {
    	var origUrl = window.location.href;
    	window.location.href = jsRoutes.controllers.Error.authenticationRequiredMessage(userMsg, origUrl).url;
        return true;
    }
    else {
        return false;                   
    }   
}