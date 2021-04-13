<template>
    <div>
        <form v-on:submit.prevent="editCard">
            <div class="form-element">
                 <label for="question">Question:</label>
                <input id="question" type="text" v-model= "card.question"/>
            </div>
            <div class="form-element">
                 <label for="answer"></label>
                 <input id="answer" type="text"  v-model= "card.answer"/>
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

            const newCard = {
                question:this.card.question,
                answer:this.card.answer,
                subject:this.card.subject,
                id:this.$route.params.cardId
            }

            cardService.updateCard(newCard).then(response => {
                if (response.status === 200) {
                 this.$router.push(`/user/decks/{{this.$route.params.id}}`);
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
</style>