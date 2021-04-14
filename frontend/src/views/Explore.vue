<template>
  <body>
    <div id="container">
     
       <br>
            <img id="logo1" src="@/assets/TEHOOT.png" alt="logo" />
        
        <div id="form1">
        
            <form class="form-options">
              <router-link
                class="signUp"
                v-bind:to="{ name: 'signUp' }"
                tag="button"
                >Sign Up</router-link>
              <br />
              <router-link
                class="logIn"
                v-bind:to="{ name: 'logIn' }"
                tag="button"
                >Log In</router-link
              >
              <br />
            </form>
          </div>	
       <!-- <div id="flip3a"> -->
            <div class="question" id="question">What is your favorite color?</div>
            <!-- <div class="answer" id="answer">Java Green</div> -->
        
        <p id="about">
		Wise up on any subject! <br />
		  <br />
          Create custom flash cards! <br />
      <br />
          Save decks for reference!<br />
      <br />
          Have study sessions!<br />
      <br />
        </p>
        <img id="Owl1" src="@/assets/TEHOOTOwl.png" alt="Owl" />
            <div id="answer">Java Green</div> 
          <!-- <div class="flip3b">
            <div id="question">What is your favorite color?</div>
        </div> -->
     
    </div>
  </body>
</template>

<style>
#logo1 {
  width: 100%;
  grid-area: logo;
}
#Owl1 {
  width: 275px;
  margin: 15px;
  justify-self: center;
  grid-area: Owl;
}
button {
  font-size: 20px;
  margin: 7px;
}
.signUp {
  -moz-box-shadow: inset 0px -1px 3px 0px #91b8b3;
  -webkit-box-shadow: inset 0px -1px 3px 0px #91b8b3;
  box-shadow: inset 0px -1px 3px 0px #91b8b3;
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #ffff00),
    color-stop(1, #ffff00)
  );
  background: -moz-linear-gradient(top, #c57bff 5%, #c57bff 100%);
  background: -webkit-linear-gradient(top, #c57bff 5%, #c57bff 100%);
  background: -o-linear-gradient(top, #c57bff 5%, #c57bff 100%);
  background: -ms-linear-gradient(top, #c57bff 5%, #c57bff 100%);
  background: linear-gradient(to bottom, #c57bff 5%, #c57bff 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
  background-color: #c57bff;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  border: 1px solid #566963;
  display: inline-block;
  cursor: pointer;
  color: #00000b;
  font-family: Arial;
  font-size: 20px;
  font-weight: bold;
  padding: 11px 23px;
  text-decoration: none;
}
.logIn {
  -moz-box-shadow: inset 0px -1px 3px 0px #91b8b3;
  -webkit-box-shadow: inset 0px -1px 3px 0px #91b8b3;
  box-shadow: inset 0px -1px 3px 0px #91b8b3;
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #ffff00),
    color-stop(1, #ffff00)
  );
  background: -moz-linear-gradient(top, #ffff00 5%, #ffff00 100%);
  background: -webkit-linear-gradient(top, #ffff00 5%, #ffff00 100%);
  background: -o-linear-gradient(top, #ffff00 5%, #ffff00 100%);
  background: -ms-linear-gradient(top, #ffff00 5%, #ffff00 100%);
  background: linear-gradient(to bottom, #ffff00 5%, #ffff00 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
  background-color: #ffff00;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  border: 1px solid #566963;
  /* display: inline-block; */
  cursor: pointer;
  color: #00000b;
  font-family: Arial;
  font-size: 20px;
  font-weight: bold;
  padding: 11px 23px;
  text-decoration: none;
}
#about {
  font-size: 22px;
  color: #f6f6fa;
  font-family: Futura;
  text-shadow: #91b8b3;
  text-align: left;
  grid-area: about;
}
#question {
  width: 515px;
  height: 271px;
  background: #bbe9fa; 
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 10px 10px 27px -5px rgba(0, 0, 0, 0.25); 
  border-radius: 20px;
  display: inline-block; 
  cursor: pointer;
  color: #00000b;
  font-family: Arial;
  font-size: 36px;
  font-weight: bold;
  padding: 110px 0px;
  text-align: center;
  text-decoration: none;
  grid-area: question;
  align-self: center;
  justify-self: center;
  
}
#answer {
  width: 515px;
  height: 271px;
  background: #cffae0;
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 10px 10px 27px -5px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  /* display: inline-block; */
  cursor: pointer;
  color: #00000b;
  font-family: Arial;
  font-size: 36px;
  font-weight: bold;
  padding: 110px 0px;
  text-align: center;
  text-decoration: none;
  grid-area: answer;
  justify-self: center;

  
}
#container {
  display: grid;
  grid-gap: 10px;
  grid-template-columns: .5fr 1fr 1fr 1fr .5fr;
  /* grid-template-rows: 1fr 1fr 1fr; */
  grid-template-areas:
  ". logo logo form ."
  ". question question about ."
  ". Owl answer answer .";
  /* align-self: left; */
 /* margin: 0px 50px; */
}
/* header {
  display: inline-block;
  padding: 0 10px;
  text-align: left;
} */
form {
  display: inline-block;
  font-size: 16px;
  padding: 15px;
  background: rgb(211, 211, 211);
  border-style: solid;
  
}
#form1 {
  grid-area: form;
  padding: 0 10px;
  /* text-align: right; */
}
div.form {
  display: block;
  /* text-align: right; */
}
/* .flip3d {

} */
</style>