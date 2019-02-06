<html>
    	<title>Top Trumps - Home</title>
       
        <body>
             <h1>Top Trumps</h1>
    
          <div id=container>
          <p><button type= "button" class="btn btn-default btn-lg"style="font-size: 30px" role="button"><a href= "GameScreen.html">Play game</a></button></p>
          <p><button type= "button" class="btn btn-default btn-lg"style="font-size: 30px" role="button"><a href = "statistics.html">View Statistics</a> </button></p>
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
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}
				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}
				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
		</script>
    </body>
</html>
