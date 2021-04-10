<template>
    <div>
        <div class = "decks">
            <div
                class = "deck" 
                v-for= "deck in decks"
                v-bind:key = "deck.deck_id">
                <router-link v-bind:to="{ name: 'deck', params: { id: deck_id } }">
                    {{ deck.deckName }}
                </router-link>
            </div>
            
        </div>
    </div>  
</template>


<script>
import deckService from '../services/DeckService';

export default {
    name:"decks",
    data(){
        return{
            decks:[]
        }
    },
    created() {
    deckService.getDecks().then(response => {
      this.decks = response.data;
    });
  }
    
}
</script>

<style>
    .decks {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

</style>