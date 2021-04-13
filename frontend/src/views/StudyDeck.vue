<template>
    <div>
        <single-card v-bind:card = "cards[index]"/>
        {{cards[index].question}}

        
    </div>
    
</template>

<script>
import deckService from '../services/DeckService';
export default {
    data(){
        return{
            cards:[],
            index:0
        }
    },


    created() {
        deckService.getCardsByDeckId(this.$route.params.deckId).then(response => {
        this.deckName = response.data.deckName;
        this.deckDescription = response.data.deckDescription;
        this.deckId = response.data.deckId;
        this.cards = response.data.cards;
        });
    }   
}
</script>