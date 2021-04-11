<template>
    <div>
        <h1>{{ deckName }}</h1>
        <div class = "cards">
            <div v-for = "card in cards" 
                 v-bind:key = "card.id"
                 v-on:click="viewCardDetails(card.id)">
                <card v-bind:card="card"/>
            </div>
        </div>
        

    </div>
</template>

<script>
import deckService from '../services/DeckService';
import Card from '../components/Card.vue'

export default {
    name:"deck",
    
    components:{
        Card
    },
    data(){
        return{
            deckName:'',
            cards:[],
            questionUp : true,
        }
    },
    methods: {
    viewCardDetails(cardID) {
      this.$router.push(`/decks/${this.$route.params.id}/card/${cardID}`);
    },
    },
    created() {
    deckService.getCardsByDeckId(this.$route.params.id).then(response => {
      this.deckName = response.data.deckName;
      //this.cards = response.data.cards;
      this.cards = response.data;
    });

  }

    
}
</script>