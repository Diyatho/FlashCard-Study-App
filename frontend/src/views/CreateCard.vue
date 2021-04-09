<template>
<div>
    <form v-on:submit.prevent="addNewCard">

      <div class="status-message success" v-show="formAddedSuccess">Card created succesffully</div>
      <div class="status-message error" v-show="formAddedFailure">{{errorMsg}}</div>

     <div class="form-element">
        <label for="question">Question:</label>
        <input id="question" type="text" v-model="newCard.question" />
      </div>
      <div class="form-element">
        <label for="answer">Answer:</label>
        <input id="answer" type="text" v-model="newCard.answer" />
      </div>
      <div class="form-element">
        <label for="subject">Subject:</label>
        <input id="subject" type="text" v-model="newCard.subject" />
      </div>
      <div class="form-element">
        <label for="keywords">Keywords (space separated):</label>
        <input id="keywords" type="text" v-model="newCard.keywords" />
      </div>
      <input type="submit" value="Make Card" />
       <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>

</div>
    
</template>


<script>
import cardService from '@/services/CardService';
export default {
    name:"create-card",
    data(){
        return{
            newCard:{},
            formAddedSuccess: false, //controls display of success status message
            formAddedFailure: false, //controls display of error status message
            errorMsg: ''
        }
    },
    methods:{
    addNewCard() {
     cardService.createCard(this.newCard).then(response => {
         if (response.status === 201) { //201 = "Created"
         this.formAddedSuccess = true; //display success message
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

        this.formAddedFailure = true; //display error message
        });
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
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
</style>
