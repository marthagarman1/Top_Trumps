<html>

            <head>
            <!-- Web page title -->
            <title>Top Trumps - Game</title>


            <!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
            <script
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
            <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
            <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/litera/bootstrap.min.css">

            <meta charset="utf-8">
            <meta name="viewport"
                content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
            <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=VT323" />
            <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/litera/bootstrap.min.css" rel="stylesheet" integrity="sha384-DkdUb51XC4VPExQljj9mtMYspLBzNJscXpAnuo0rcJcLd7aeOH3jnz6cS1v8OFMW" crossorigin="anonymous">
            <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/litera/bootstrap.min.css">
            <script
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
            <script
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
            <body onload="initalize()">
                <!-- Call the initalize method when the page loads -->

     </head>
                <style>
            #mainBody {
                padding: 5px;
                background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);
            }
            #mainBody1 {
                background: rgba(255, 255, 255, 0.8);
                align-items: baseline;
            }
            .btn {
                cursor: pointer;
                font-size: 25px;
                padding: 10px 10px;
                box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            }
            .row.content {
                height: auto;
                }
            #title12 {
                text-align: center;
                    }
            .cardsection {
                        margin: auto;
                       height: 480px;
                        width: 200px;
                        background-color: white;
                        border: 1px solid blue;
                            
                    }
                    .gamescreen {
                         max-width: 100%; 
                        max-height: 100%;
                    }
                    #gameStatus {
                    display: none;
                    }
                    #cardsWindow {
                    display: none;
                    }
                    #drawCard {
                    margin: auto;
                    display: none;
                    }
                    #playAgainButton {
                    display: none;
                    }
            </style>


            <body>


                    <nav style="background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
    <ul>
        <li><a href = "/toptrumps">Home</a></li>
        <li><a href = "/toptrumps/game">Play Game</a></li>
        <li><a href="/toptrumps/stats">View Statistics</a></li>
    </ul>
            </nav> 
   
             
                <div class="jumbotron" style="background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg); margin-top: 0%;" >
                <div id="startButton">
                <h1 id="title12"><p class="badge badge-info" style="font-size: 29px; color: black; background: none; margin: 0px;" >Top Trumps Card Game</p></h1>
              <p class="lead" id="title12" style="font-size: 20px; margin: 0px;">Choose How Many Players To Play Against</p>
              
				
                <p id="title12" style="font-size: 30px; ">
                <button type="button" class="btn btn-secondary" id="oneButton" style="color: Blue; font-size: 15px;">1</button>
                <button type="button" class="btn btn-secondary" id="twoButton" style="color: Blue; font-size: 15px;">2</button>
                <button type="button" class="btn btn-secondary" id="threeButton" style="color: Blue; font-size: 15px;">3</button>
                <button type="button" class="btn btn-secondary" id="fourButton" style="color: Blue; font-size: 15px;">4</button>
                    </p>

                    <script type="text/javascript">
                     // window.location='http://localhost:7777/toptrumps/setPlayers'; //need to confirm path
                      oneButton.setPlayers(1);
                      twoButton.setPlayers(2);
                      threeButton.setPlayers(3);
                      fourButton.setPlayers(4);
                    </script>

              
              <h3 id="title12"><p class="badge badge-secondary" id="title12">Click Start Game After Your Choice</p></h3>
              <p class="lead" id="title12" style="margin: auto;">
                <button class="btn btn-primary btn-lg" onclick="startGame();">Start Game</button>
                <button class="btn btn-primary btn-lg" onclick="openStatPage();" style=" padding-left: 5px;">View Statistics</button>
              </p></div>

                    <div class="jumbotron" style="text-align: center; background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg); margin-top: -15%;" id="gameStatus">
                        <h4>Active Player: <b><label id='activePlayer' style="color: green;"></label></b></h4>
                        <h4>Round Number: <label  id='roundCount' style="color: green;"></label></h4>
                        <h4>Cards in Pile: <label  id='commonPile' style="color: green;"></label></h4>
                        
                        <script type="text/javascript">
                          //window.location='http://localhost:7777/toptrumps/activePlayer'; //need to confirm path
                          activePlayerLabel.activePlayer();
                        </script>

                        <button class="btn btn-primary btn-lg" onclick="drawCardUpdate(); selectCategory(4);" id="drawCard">Draw A Card</button>
                        </div>
                    <div id="playAgainButton" class="jumbotron" style="text-align: center; padding-left: 5%; margin: 0%; background-image:    url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);" >
                        <button class="btn btn-primary btn-lg" onclick="" style="padding-left: 20px; margin: 0px;">Play Again</button>
                        
                        </div>
                        
                    <!--Cards Section-->
                    <div class="jumbotron" id="cardsWindow" style="margin-top: -5%; padding-left: 12%;">
                    <div class="row text-center" style="padding-left: 6.5%; background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);" >
                        <div class="col-md-2.5">
                <div class="cardsection" style="background: none;">
              <div class="card-header">Human Player</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%;">
               <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center" id="a1" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" id="a2" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" id="a3" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center" id="a4" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" id="a5" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>

              <script type="text/javascript">
                //window.location='http://localhost:7777/toptrumps/selectCategory'; //need to confirm path
                a1.selectCategory(1);
                a2.selectCategory(2);
                a3.selectCategory(3);
                a4.selectCategory(4);
                a5.selectCategory(5);
              </script>
                  <div class="card-footer text-muted" style="border: 1px solid gray;">Cards Left</div> 
            </ul>               
              </div>
              </div>
              </div>

                        <div class="col-md-2.5">
                    <div class="cardsection" style="background: none;">
              <div class="card-header">AI Player 1</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%">
                <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                    <div class="card-footer text-muted" style="border: 1px solid gray;">Cards Left</div> 
            </ul>
                
              </div>
                   
            </div>
             </div>

                        <div class="col-md-2.5">
                        <div class="cardsection" style="background: none;">
              <div class="card-header">AI Player 2</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%">
                <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                    <div class="card-footer text-muted" style="border: 1px solid gray;">Cards Left</div> 
            </ul>
                

              </div>
                   
            </div>
                        </div>
                            <div class="col-md-2.5">
                     <div class="cardsection" style="background: none;">
              <div class="card-header">AI Player 3</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%">
                <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                    <div class="card-footer text-muted" style="border: 1px solid gray;">Cards Left</div> 
            </ul>
                

              </div>
                   
            </div>
                        </div>
                        <div class="col-md-2.5">
              <div class="cardsection" style="background: none;">
              <div class="card-header">AI Player 4</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%">
                <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center disabled" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                    <div class="card-footer text-muted" style="border: 1px solid gray;">Cards Left</div> 
            </ul>
                

              </div>
                   
            </div>
                    </div>
                    </div>
                    </div>

                </div>


                <h3><div class="card-footer text-muted" style="text-align: center;">Error 404 Team Name Not Found</div></h3>
            </body>
            
<script type="text/javascript">
    
    function createCORSRequest(method, url) {
      var xhr = new XMLHttpRequest();
      if ("withCredentials" in xhr) {
        
        xhr.open(method, url, true);
      } else if (typeof XDomainRequest != "undefined") {
        
        xhr = new XDomainRequest();
        xhr.open(method, url);
      } else {
       
        xhr = null;
      }
      return xhr;
    }
    function showGameStatus() {
    	document.getElementById("gameStatus").style.display = "block";
  		}
  		
  	function showCards() {
    	document.getElementById("cardsWindow").style.display = "block";
  		}
  	function showDrawCard() {
    	document.getElementById("drawCard").style.display = "block";
  		}
    
    function hideSelection() {
	    var x = document.getElementById("startButton");
	    if (x.style.display === "none") {} else {
	      x.style.display = "none";
	    }
	 }
	 function drawCardUpdate() {
	 		selectCategory1(3);
	 		
	 		
	 		activePlayer();
            roundCount();
            commonPile();
            
	 }
	 function selectCategory1(x) {
      var number = x
      var xhr = createCORSRequest('GET',
        "http://localhost:7777/toptrumps/startGameee?SelectedCat="+ number); // Request type and URL+parameters
      if (!xhr) {
        alert("CORS not supported");
      }
      xhr.onload = function(e) {
      
    	  
      }
      xhr.send();
      
    } 
    
  </script>
                
            
    <script>
  
            function startGame() {
            
            activePlayer();
            roundCount();
            commonPile();
            showGameStatus();
            showDrawCard();
            showCards();
            
            hideSelection();
            
      var xhr = createCORSRequest('GET',
        "http://localhost:7777/toptrumps/startGamee"); // Request type and URL+parameters
      if (!xhr) {
        alert("CORS not supported");
      }
    xhr.onload = function(e){
        	
            
        
        
    }
    xhr.send(); 	  
      }
      
      function activePlayer() {
	
		var xhr = createCORSRequest('GET',
				"http://localhost:7777/toptrumps/activePlayer");
		if (!xhr) {
			alert("No active Player error");
		}
		xhr.onload = function(e) {
			
		var responseText = xhr.response; // the text of the response
		responseText = responseText.replace(/^"(.*)"$/, '$1');
		document.getElementById('activePlayer').innerHTML = responseText;
	
			
		}
		xhr.send();
	}
	
	function roundCount() {
	
		var xhr = createCORSRequest('GET',
				"http://localhost:7777/toptrumps/roundCount");
		if (!xhr) {
			alert("No round error");
		}
		xhr.onload = function(e) {
			
		var responseText = xhr.response; // the text of the response
		responseText = responseText.replace(/^"(.*)"$/, '$1');
		document.getElementById('roundCount').innerHTML = responseText;
	
			
		}
		xhr.send();
	}
        function commonPile() {
	
		var xhr = createCORSRequest('GET',
				"http://localhost:7777/toptrumps/commonPile");
		if (!xhr) {
			alert("No Pile error");
		}
		xhr.onload = function(e) {
			
		var responseText = xhr.response; // the text of the response
		responseText = responseText.replace(/^"(.*)"$/, '$1');
		document.getElementById('commonPile').innerHTML = responseText;
	
			
		}
		xhr.send();
	}
	
	   function selectCategory(x) {
      var number = x
      var xhr = createCORSRequest('GET',
        "http://localhost:7777/toptrumps/selectCate?SelectedCat="+ number); // Request type and URL+parameters
      if (!xhr) {
        alert("CORS not supported");
      }
      xhr.onload = function(e) {
      
    	  
      }
      xhr.send();
      
    } 
 
    function openStatPage() {
    window.location='http://localhost:7777/toptrumps/stats';
    	  }	  
    	       
</script>
</body>
   </html>
