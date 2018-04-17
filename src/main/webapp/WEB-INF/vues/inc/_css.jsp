<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<style>
	
/* EN-TETE ---------------------------------------------------------------------------------------------------------- */

body>header {
    height: 8em;
    text-align: center;
}

#titre {
	text-align: center;
	z-index:1;
	position: absolute;
	width: 100%;
}

body>header>div>span>h1 {
    display: inline-block;
    vertical-align: top;
    text-align: center;
    padding-top:0.7em;
}

#message_user {
	height: 8em;
	width: 15em;
	/*background-color: red;*/
	margin-top: 1.5em;
	z-index: 10;
	position: absolute;
	right: 30px;
}

#message_perso {
	font-weight: bolder;
}

.button_header {
	width: 70%;
    border-radius: 15px;
    padding-bottom: 0.2em;
    margin-top: 1em;
    padding-top: 0.2em;
    /*margin: 5px 0;*/
}

nav {
    margin-top: 1em;
    margin-bottom: 1em;
    text-align: center;
    font-size: 1.3em;
}

.button_redho:hover {
	background-color: #CE5937;
	color: #FFFFFF;
}

.button_greenho:hover {
	background-color: #50E240;
	color: #FFFFFF;
}

.button_blueho:hover {
	background-color: #413BE2;
	color: #FFFFFF;
}

/* FOOTER ---------------------------------------------------------------------------------------------------------- */

footer {
    text-align: center;
    margin-top: 2em;
    border-style: solid;
    border-width: 0.1em;
    padding-bottom: 0.5em;
    padding-top: 0.5em;
    border-radius: 15px;
    margin-left: auto;
    margin-right: auto;
    width: 40%;
}

/* TABLES ---------------------------------------------------------------------------------------------------------- */

table {
	width: 70%;
    margin: 0 auto;
    padding: 1em;
}

table tfoot tr {
    text-align:center;
}

input[type=text] {
    width: 80%;
}

input[type=password] {
    width: 80%;
}

.submit {
	width: 30%;
    border-radius: 15px;
    padding-bottom: 0.2em;
    padding-top: 0.2em;
    margin-top: 2em;
}

.button_gestion {
    border-radius: 15px;
    padding-bottom: 0.2em;
    padding-top: 0.2em;
    margin: 5px 0;
}

#boutton_envoyer_mod {
	text-align:center;
	width: 30%;
	height: 3em;
}

#added {
	padding-top: 1em;
	text-align:center;
	font-weight: bolder;
	color: rgb(0, 200, 50);;
}

#bad {
	padding-top: 1em;
	text-align:center;
	font-weight: bolder;
	color: rgb(255, 0, 0);;
}

#div_image {
	margin-top: 2em;
	text-align:center;
}

#image_produit {
	margin-bottom: 2em;
	height: 15em;
}

</style>