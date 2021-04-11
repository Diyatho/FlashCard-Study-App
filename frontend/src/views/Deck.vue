<template>
    <div>
        abcd
        <h1>{{ deckName }}</h1>
        {{cards}}
        <div class = "cards">
            <div v-for = "card in cards" v-bind:key = "card.id">
                <p> card.question</p>
                <card/>
            </div>
        </div>
        

    </div>
</template>

<script>
import deckService from '../services/DeckService';
export default {
    name:"deck",
    data(){
        return{
            deckName:'',
            cards:[]
        }
    },
    created() {
    deckService.getCardsByDeckId(this.$route.params.id).then(response => {
      this.deckName = response.data.deckName;
      this.cards = response.data.cards;
    });
  }

    
}
</script>