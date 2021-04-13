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
            <input type="submit" value="Save Changes" />
            <input type="button" value="Cancel" v-on:click="cancelForm" />
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
                    //this.$router.push('/user/decks/{{this.$route.params.id}}');
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
             if (
                confirm(
                 "Are you sure you want to delete this card? This action cannot be undone."
                 )) 
                 {
                    cardService.deleteCard(this.card.id).then(response => {
                        if (response.status === 200) {
                        alert("Card successfully deleted");
                        this.$router.push(`/board/${this.card.boardId}`);
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
</style>