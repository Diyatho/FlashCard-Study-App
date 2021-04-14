<template>
<div>
    <form v-on:submit.prevent="addNewCard">

      <div class="status-message success" v-show="formAddedSuccess">Card created successfully</div>
      <div class="status-message error" v-show="formAddedFailure">{{errorMsg}}</div>

     <div class="form-element">
       {{deckName}}
        <label for="question">Question:</label>
        <!--<input id="question" type="text" v-model="newCard.question" />-->
        <textarea id="question" rows="4" cols="50" v-model="newCard.question"/>
      </div>
      <div class="form-element">
        <label for="answer">Answer:</label>
        <!--<input id="answer" type="text" v-model="newCard.answer" />-->
        <textarea id="answer" rows="4" cols="50" v-model="newCard.answer"/>
      </div>
      <div class="form-element">
        <label for="subject">Subject:</label>
        <input id="subject" type="text" v-model="newCard.subject" />
      </div>
      <div class="form-element">
        <label for="keywords">Keywords (space separated):</label>
        <input id="keywords" type="text" v-model="newCard.keywords" />
      </div>
      <input id="add" type="submit" value="Add to deck" />
       <input id="cancel" type="button" value="Cancel" v-on:click="resetForm" />
       <input id="view" type="button" value="View Deck" v-on:click="goHome" />

    </form>

</div>
    
</template>


<script>
import cardService from '@/services/CardService';
export default {
    name:"create-card",
    props: ["deckName"],
    data(){
        return{
            newCard:{
              deckName:this.deckName
              
            },
            formAddedSuccess: false, //controls display of success status message
            formAddedFailure: false, //controls display of error status message
            errorMsg: ''
        }
    },
    methods:{
    addNewCard() {
      this.newCard.deckName = this.deckName;
     cardService.createCard(this.newCard).then(response => {
         if (response.status === 201 || response.status === 200) { //201 = "Created"
         this.formAddedFailure = false;
         this.formAddedSuccess = true; //display success message
         this.resetForm();
        }
      })
      .catch((error) => {
        this.errorMsg = "";
        if (error.response) {
            if (error.response.status === 500) { // you can test for specific status codes if you want different actions to happen or messages to be displayed
            this.errorMsg = "Error submitting form. An internal server error occurred.";
          } else if (error.response.status === 404) {
             this.errorMsg = "Error submitting form. URL could not be found.";
          } else {
             this.errorMsg = "Error submitting form. Response received was code " + error.response.status + " '" + error.response.statusText + "'.";
          }
        }
        else if (error.request) {
          this.errorMsg = "Error submitting form. Server could not be reached.";

        } else {
          this.errorMsg = "Error submitting form. Request could not be created.";
        }
        this.formAddedSuccess = false;
        this.formAddedFailure = true; //display error message
        });
      this.resetForm();
    },

    // clears the form
    resetForm() {
      this.newCard = {};
    },

    //takes the user back to home page
    gotoDeckPage(){
      this.$router.push('/');

    }
  }
    
}
</script>

<style>

.status-message {
  border-radius: 5px;
  font-weight: bold;
  text-align: center;
  padding: 10px;
  width: 350px;
  margin: 0 auto 10px;
}
.status-message.success {
  background-color: #90EE90;
}
.status-message.error {
  background-color: #F08080;
}
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}
#add {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-webkit-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-o-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-ms-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:linear-gradient(to bottom, #C57BFF 5%, #C57BFF 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#C57BFF;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#00000b;
	font-family:Arial;
	font-size:14px;
	font-weight:bold;
  text-align: center;
	padding:5px 5px;
	text-decoration:none;
/* text-shadow:0px -1px 0px #2b665e; */
}
#cancel {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-webkit-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-o-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-ms-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:linear-gradient(to bottom, #ffff00 5%, #ffff00 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#ffff00;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#00000b;
	font-family:Arial;
	font-size:14px;
	font-weight:bold;
	padding:5px 5px;
	text-decoration:none;
	/* text-shadow:0px -1px 0px #2b665e; */
}
#view {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-webkit-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-o-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-ms-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:linear-gradient(to bottom, #80DA71 5%, #80DA71 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#80DA71;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#00000b;
	font-family:Arial;
	font-size:14px;
	font-weight:bold;
	padding:5px 5px;
	text-decoration:none;
/* text-shadow:0px -1px 0px #2b665e; */
}


</style>
