<template>
    <div>
        
        <form v-on:submit.prevent="editCard">
           <button class="btn deleteCard" v-on:click="deleteCard">Delete Card</button>
            <div class="form-element">
                 <label for="question">Question:</label>
                <!--<input id="question" type="text" v-model= "card.question"/>-->
                <textarea id="question" rows="4" cols="50" v-model="card.question"/>
            </div>
            <div class="form-element">
                 <label for="answer"></label>
                 <!--<input id="answer" type="text"  v-model= "card.answer"/>-->
                 <textarea id="answer" rows="4" cols="50" v-model="card.answer"/>
            </div>
            <div class="form-element">
                <label for="subject">Subject:</label>
                <input id="subject" type="text" v-model= "card.subject"/>
            </div>

            <div class="form-element">
                <label for="keywords">Keywords (space separated):</label>
                <input id="keywords" type="text"  />
            </div>
            <input id="submit" type="submit" value="Save Changes" />
            <input id="cancel" type="button" value="Cancel" v-on:click="cancelForm" />
        </form>
    </div>
</template>


<script>
import cardService from '../services/CardService'
export default {
    data(){
        return{
            card:{}
        }
    },


    methods:{
        editCard(){
            const deckId = this.$route.params.id;
            const newCard = {
                question:this.card.question,
                answer:this.card.answer,
                subject:this.card.subject,
                id:this.$route.params.cardId
            }

            cardService.updateCard(newCard).then(response => {
                if (response.status === 200) {
                    console.log(this.$route);
                    const pathToUse = `/user/decks/${deckId}`;
                    this.$router.push(pathToUse);
                }
             })
            .catch(error => {
              this.handleErrorResponse(error, "updating");
             });
             this.$router.push('/');

        },
        cancelForm() {
            this.$router.push('/');
        },
        //delete the card
         deleteCard() {
             const deckId = this.$route.params.id;
             if (
                confirm(
                 "Are you sure you want to delete this card? This action cannot be undone."
                 )) 
                 {
                    cardService.deleteCard(this.card.id).then(response => {
                        if (response.status === 200) {
                        alert("Card successfully deleted");
                        const pathToUse = `/user/decks/${deckId}`;
                         this.$router.push(pathToUse);
                        }
                    })
                .catch(error => {
                  if (error.response) {
                    this.errorMsg =
                      "Error deleting card. Response received was '" +
                        error.response.statusText + "'.";
                    } else if (error.request) {
                    this.errorMsg =
                      "Error deleting card. Server could not be reached.";
                  } else {
                     this.errorMsg =
                      "Error deleting card. Request could not be created.";
                  }
                
                });
            }
        }
    },
    created() {
    cardService.getCardById(this.$route.params.cardId).then(response => {
      this.card = response.data;
    });

  }
}
</script>



<style>
div.form-element {
  margin-top: 10px;
}

.btn.deleteCard {
  color: #fff;
  background-color: #e74051;
  border-color: #ef031a;
  margin-bottom: 10px;
}
#submit {
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
	font-size:14.5px;
	font-weight:normal;
	padding:4px 1px;
	text-decoration:none;
/* text-shadow:0px -1px 0px #2b665e; */
}

</style>