<html>
	<head>
		<!-- Web page title -->
    	<title>Top Trumps- Statistics</title>
    	
        
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">
        <meta charset="utf-8">
        <meta name= "viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
        <body background= https://stmed.net/sites/default/files/aircraft-wallpapers-31766-1204680.jpg/body>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

	

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">
<style>
.navbar {
    font-size:20px;
    color: black;
	margin-bottom: 0;
	border-radius: 0;
	padding: 0;
}
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
    color: black;
	height: 100%
}
body {
	background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);
    background-size: cover;
	font-family:sans-serif;
	font-size: 25px;    
}
h1 {
    color:black;
	font-weight: 700;
	font-size: 45px;
}
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
#mainBody {
    color: black;
	background: rgba(255, 255, 255, 0.8);
	padding: 10px;
}
.table {
	border-radius: 5px;
	width: 50%;
	margin: 0px auto;
	float: none;
	font-size: 20px;
}
</style>
<body>
	<!-- Call the initalize method when the page loads -->
<!-- 	<body onload="initalize()"> -->

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			</div>
            
            <nav>
    <ul>
        <li><a href = "homescreen.html">Home</a></li>
        <li><a href = "GameScreen.html">Play Game</a></li>
        <li><a href = "howtoplay.html">How to Play</a></li>
        <li class = "active">View Statistics</li>
    </ul>
            </nav>          
		
	</nav>

	<div class="row">
		<div class="col-lg-12" style="padding: 15px;"></div>
	</div>

	<div class="row content">
		<div class="col-lg-2"></div>

		<div class="container-fluid text-center">
			<div class="col-lg-8 text-center" id="mainBody">
				<h1 align=center>Game Statistics</h1>
				
				<p id="testArea"></p>


				<table class="table table-lg">
					<tbody align=left>
						<tr>
							<th scope="row">Total Games Played</th>
							<td id="num1"></td>
						</tr>
						<tr>
							<th scope="row">Player Wins</th>
							<td id="num2"></td>
						</tr>
						<tr>
							<th scope="row">Computer Wins</th>
							<td id="num3"></td>
						</tr>
						<tr>
							<th scope="row">Largest Number of Rounds Played</th>
							<td id="num4"></td>
						</tr>
						<tr>
							<th scope="row">Average Draws Per Game</th>
							<td id="num5"></td>
						</tr>
					</tbody>
                </table>
			</div>

		</div>
	</div>
	<div class="row content">
		<div class="col-lg-12" style="padding: 10px;"></div>
	</div>

</body>

<script type="text/javascript">
src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	// Method that is called on page load
	
	
	function newGame() {
	window.location='http://localhost:7777/toptrumps/game';
		
	}
				</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method,url) {
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
		
		// Method that is called on page load
        			function initalize() {
        				Database();
        			}
        			// -----------------------------------------
        			// Add your other Javascript methods Here
        			// -----------------------------------------
        			function newGame() {
        				window.location='http://localhost:7777/toptrumps/game';
        			}
        			function createCORSRequest(method, url) {
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
					<script type="text/javascript">
					$(function(){
				
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/database"); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}
				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					var jsonObject = JSON.parse(responseText);
					$("#games").html(jsonObject["TotalGamesPlayed"]);
					$("#computer_wins").html(jsonObject["ComputerWins"]);
					$("#human_wins").html(jsonObject["PlayerWins"]);
					$("#max_rounds").html(jsonObject["LargestNumberofRoundsPlayed"]);
					$("#average_draws").html(jsonObject["AverageDrawsPerGame"]);
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();	
				
				
				
			});
		</script>
		
		</body>
