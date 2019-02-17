<html>
    	<title>Top Trumps - Home</title>
       
        <body>
             <h1>Top Trumps</h1>
    
          <div id=container>
          <p><button type= "button" class="btn btn-default btn-lg"style="font-size: 30px" role="button"><a href= "/toptrumps/game">Play game</a></button></p>
          <p><button type= "button" class="btn btn-default btn-lg"style="font-size: 30px" role="button"><a href = "/toptrumps/stats">View Statistics</a> </button></p>
          <p><button type= "button" class="btn btn-default btn-lg" style="font-size: 30px" role="button"><a href = "howtoplay.html">How to Play</a></button></p>         
            </div>                                         
        <footer style="font-size: 25px">
		Team: Error 404: Team Name Not Found
	    </footer>   
          
    	   	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/ -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" 
    	href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">
   
    	<meta charset= "utf-8">
    	<meta name ="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">     

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
                                                                        
    <style>
        <div class= "container">
        <div class="topnav">                  
* {
    margin: 1000;
    padding: 0;
        }
html, body{
    height: 100%;
    
}
h1{
    text-align: center;
    font-size: 100px;
    font-family: sans-serif;
    
}
#p{    
    align-items: baseline;
    }
#container{
    height: 80%;
    min-height: 80%;
    color: beige;
}
#main{
    overflow: auto;
    padding-bottom: 100px;
    
}
#footer{
    background-color:darkgreen;
    position: relative;
    height: 100px;
    
}
body {
       
    background-image: url(http://hdwpro.com/wp-content/uploads/2017/07/HD-Aircraft-Wallpaper.jpg);
    height: 80%;
    background-position:center;
    background-repeat: no-repeat;
    background-size: cover
}
height: 10.3;
}
h2 {
    margin-top: 1.3em;
}
a {
    color: black;
}
footer{
    font-family:sans-serif;
    font-size: 800px;
}
        
            </style>
		<!-- Here are examples of how to call REST API Methods -->
		//Method is called on page load
		<script type="text/javascript">
		
			// Method that is called on page load
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
				
			}
	
				// This is a reusable method for creating a CORS request. Do not edit this.
			  function createCORSRequest(method, url) {
			  var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList");
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {
    				
    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				
    			xhr.open(method, url, true);
  				
  				} else if (typeof XDomainRequest != "undefined") {
    				
    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);
 				
 				 } else {
    				
    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;
  				 }
  				 return xhr;
			}
		
		</script>

<!-- Here are examples of how to call REST API Methods -->
<script type="text/javascript">
		
			function playGame(){
        		window.location='http://localhost:7777/toptrumps/game';
    		}
    		
    		function viewStatistics(){
    			window.location='http://localhost:7777/toptrumps/stats';
    		}
		</script>
</body>
</html>
