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
            </style>


            <body>


                    <nav style="background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
    <ul>
        <li><a href = "/toptrumps">Home</a></li>
        <li><a href = "/toptrumps/game">Play Game</a></li>
        <li><a href = "">How to Play</a></li>
        <li><a href="/toptrumps/stats">View Statistics</a></li>
    </ul>
            </nav> 



                <div class="jumbotron" style="background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
                    <h1 id="title12"><p class="badge badge-info" style="font-size: 29px; color: black; background: none; margin: 0px;" >Top Trumps Card Game</p></h1>
              <p class="lead" id="title12" style="font-size: 20px; margin: 0px;">Choose How Many Players To Play Against</p>

                <p id="title12" style="font-size: 30px; ">
                <button type="button" class="btn btn-secondary" id="oneButton" style="color: Blue; font-size: 15px;">1</button>
                <button type="button" class="btn btn-secondary" id="twoButton" style="color: Blue; font-size: 15px;">2</button>
                <button type="button" class="btn btn-secondary" id="threeButton" style="color: Blue; font-size: 15px;">3</button>
                <button type="button" class="btn btn-secondary" id="fourButton" style="color: Blue; font-size: 15px;">4</button>
                    </p>

                    <script type="text/javascript">
                      window.location='http://localhost:7777/toptrumps/setPlayers'; //need to confirm path
                      oneButton.setPlayers(1);
                      twoButton.setPlayers(2);
                      threeButton.setPlayers(3);
                      fourButton.setPlayers(4);
                    </script>

              
              <h3 id="title12"><p class="badge badge-secondary" id="title12">Click Start Game After Your Choice</p></h3>
              <p class="lead" id="title12" style="margin: auto;">
                <a class="btn btn-primary btn-lg" href="/toptrumps/startGamee">Start Game</a>
              </p>

                    <div class="jumbotron" style="text-align: center; background-image:   url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);">
                        <h4>Active Player: <label id=activePlayerLabel  style="color: green;"> Player ..... </label></h4>
                        <h4>Round Number: <label  style="color: green;"> Round Number .... </label></h4>
                        <h4>Cards in Pile: <label  style="color: green;"> Cards in Pile .... </label></h4>
                        
                        <script type="text/javascript">
                          //window.location='http://localhost:7777/toptrumps/activePlayer'; //need to confirm path
                          activePlayerLabel.activePlayer();
                        </script>

                        <button class="btn btn-primary btn-lg" onclick="" >Draw A Card</button>
                        </div>
                    <div class="jumbotron" style="text-align: center; padding-left: 5%; margin: -9%; background-image:    url(https://upload.wikimedia.org/wikipedia/commons/8/8b/Aviation_Military_aircraft_flock_aircraft_012524_.jpg);" >
                        <button class="btn btn-primary btn-lg" onclick="" style="padding-left: 20px; margin: 0px;">Play Again</button>
                        <button class="btn btn-primary btn-lg" onclick="" style=" padding-left: 5px;">View Statisitics</button>
                        </div>
                    <!--Cards Section-->
                    <div class="jumbotron" id="backg">
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




                </body>
                </html>
