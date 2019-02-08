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
                background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);
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

            </style>


            <body>

                <!--<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 2px; width: 100%; height: 4.5%;">
              <h6 class="navbar-brand" href="#" style="padding-left: 15px; margin: 0.5%;">TOP TRUMPS GAME</h6>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>-->
                    <nav style="background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
    <ul>
        <li><a href = "/toptrumps">Home</a></li>
        <li><a href = "/toptrumps/game">Play Game</a></li>
        <li><a href = "">How to Play</a></li>
        <li><a href="/toptrumps/stats">View Statistics</a></li>
    </ul>
            </nav> 

              <!--<div class="collapse navbar-collapse" id="navbarColor02">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Top Trumps <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/toptrumps/game/">Game</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/toptrumps/stats/">Statistics</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                  </li>
                </ul>
              </div>-->
            <!--</nav>-->



                <div class="jumbotron" style="background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
                    <h1 id="title12"><p class="badge badge-info" style="font-size: 29px; color: black; background: none; margin: 0px;" >Top Trumps Card Game</p></h1>
              <p class="lead" id="title12" style="font-size: 20px; margin: 0px;">Choose How Many Players To Play Against</p>

                <p id="title12" style="font-size: 30px; ">
                <button type="button" class="btn btn-secondary" style="color: Blue; font-size: 15px;">1</button>
                <button type="button" class="btn btn-secondary" style="color: Blue; font-size: 15px;">2</button>
                <button type="button" class="btn btn-secondary" style="color: Blue; font-size: 15px;">3</button>
                <button type="button" class="btn btn-secondary" style="color: Blue; font-size: 15px;">4</button>
                    </p>

              
              <h3 id="title12"><p class="badge badge-secondary" id="title12">Click Start Game After Your Choice</p></h3>
              <p class="lead" id="title12" style="margin: auto;">
                <a class="btn btn-primary btn-lg" href="MScITProject.html" role="button" >Start Game</a>
              </p>

                    <div class="jumbotron" style="text-align: center; background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
                        <h4>Active Player: <label  style="color: green;"> Player ..... </label></h4>
                        <h4>Round Number: <label  style="color: green;"> Round Number .... </label></h4>
                        <h4>Cards in Pile: <label  style="color: green;"> Cards in Pile .... </label></h4>
                        <button class="btn btn-primary btn-lg" onclick="" >Draw A Card</button>
                        </div>
                    <div class="jumbotron" style="text-align: center; padding-left: 5%; margin: -9%; background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);" >
                        <button class="btn btn-primary btn-lg" onclick="" style="padding-left: 20px; margin: 0px;">Play Again</button>
                        <button class="btn btn-primary btn-lg" onclick="" style=" padding-left: 5px;">View Statisitics</button>
                        </div>
                    <!--Cards Section-->
                    <div class="jumbotron" id="backg">
                    <div class="row text-center" style="padding-left: 6.5%; background-image:		url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);" >
                        <div class="col-md-2.5">
                <div class="cardsection" style="background: none;">
              <div class="card-header">Human Player</div>
              <div class="card-body">
                <h5 class="card-title">Category Name</h5>
                  <img src="http://www.dcs.gla.ac.uk/~richardm/TopTrumps/350r.jpg" style="max-width: 100%;">
               <ul class="list-group">
              <a class="list-group-item d-flex justify-content-between align-items-center" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
                <a class="list-group-item d-flex justify-content-between align-items-center" href="MScITProject.html" role="button">
                Attribute
                <span class="badge badge-primary badge-pill">1</span>
              </a>
              <a class="list-group-item d-flex justify-content-between align-items-center" href="MScITProject.html" role="button">
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




                </body>
            </html>
