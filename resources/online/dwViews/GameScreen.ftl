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
                padding: 20px;
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

            </style>


            <body>

                <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="mainBody">
              <a class="navbar-brand" href="#">TOP TRUMPS GAME</a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>

              <div class="collapse navbar-collapse" id="navbarColor02">
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
              </div>
            </nav>



                <div class="jumbotron" id="backg">
                    <h1 id="title12"><p class="badge badge-info" style="font-size: 60px;" >Top Trumps Card Game</p></h1>
              <p class="lead" id="title12">Choose How Many Players To Play Against</p>

                <p id="title12">
                <button type="button" class="btn btn-secondary" style="color: Blue;">1</button>
                <button type="button" class="btn btn-secondary" style="color: Blue;">2</button>
                <button type="button" class="btn btn-secondary" style="color: Blue;">3</button>
                <button type="button" class="btn btn-secondary" style="color: Blue;">4</button>
                    </p>

              <hr class="my-4">
              <h3 id="title12"><p class="badge badge-secondary" id="title12">Click Start Game After Your Choice</p></h3>
              <p class="lead" id="title12">
                <a class="btn btn-primary btn-lg" href="MScITProject.html" role="button" >Start Game</a>
              </p>

                    <div class="jumbotron" style="text-align: center;">

                        <h3>Active Player: <b><label  style="color: green;"> Player ..... </label></b></h3>
                        <h3>Round Number: <label  style="color: green;"> Round Number .... </label></h3>
                        <h3>Cards in Pile: <label  style="color: green;"> Cards in Pile .... </label></h3>
                        <button class="btn btn-primary btn-lg" onclick="" >Draw A Card</button>
                        </div>

                    <div class="jumbotron" style="text-align: center;" style="padding-top: 20%;">
                        <button class="btn btn-primary btn-lg" onclick="" >Play Again</button>
                        <button class="btn btn-primary btn-lg" onclick="" >View Statisitics</button>
                        </div>




                    <!--Cards Section-->
                    <div class="jumbotron" id="backg">
                    <div class="row text-center" style="padding-left: 6.5%;" >
                        <div class="col-md-2.5">

                    <div class="card border-primary mb-3" style="max-width: 13rem;">
              <div class="card-header">Human Player</div>
              <div class="card-body">
                <h4 class="card-title">Category Name</h4>
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
            </ul>
                  <p>--------------------------</p>
              </div>
                        <div class="card-footer text-muted">Cards Left</div>
            </div>

                        </div>

                        <div class="col-md-2.5">
                    <div class="card border-primary mb-3" style="max-width: 13rem;">
              <div class="card-header">AI Player 1</div>
              <div class="card-body">
                <h4 class="card-title">Category Name</h4>

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
            </ul>
                  <p>--------------------------</p>

              </div>
                   <div class="card-footer text-muted">Cards Left</div>
            </div>
                        </div>

                        <div class="col-md-2.5">
                        <div class="card border-primary mb-3" style="max-width: 13rem;">
              <div class="card-header">AI Player 2</div>
              <div class="card-body">
                <h4 class="card-title">Category Name</h4>
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
            </ul>
                  <p>--------------------------</p>

              </div>
                            <div class="card-footer text-muted">Cards Left</div>
            </div>
                        </div>
                            <div class="col-md-2.5">
                        <div class="card border-primary mb-3" style="max-width: 13rem;">
              <div class="card-header">AI Player 3</div>
              <div class="card-body">
                <h4 class="card-title">Category Name</h4>
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
            </ul>
                  <p>--------------------------</p>

              </div>
                            <div class="card-footer text-muted">Cards Left</div>
            </div>
                        </div>
                        <div class="col-md-2.5">
                        <div class="card border-primary mb-3" style="max-width: 13rem;">
              <div class="card-header">AI Player 4</div>
              <div class="card-body">
                <h4 class="card-title">Category Name</h4>
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
            </ul>

                  <p>--------------------------</p>

              </div>
                            <div class="card-footer text-muted">Cards Left</div>
            </div>
                    </div>
                    </div>
                    </div>

                </div>


                <h3><div class="card-footer text-muted" style="text-align: center;">Error 404 Team Name Not Found</div></h3>
            </body>




                </body>
            </html>
