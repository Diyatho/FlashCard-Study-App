<template>
    <div>
        <h1>Choose a deck to start study session</h1>
        <select v-model= deckName>
            <option v-for="deck in decks" v-bind:key = "deck.deckId" v-bind:value = "deck.deckId">
                {{deck.deckName}}
            </option>
        </select><br/>
        <button v-on:click="$router.push({name:'studyDeck',params:{deckId:deckName}})" >Start Study Session</button>
    </div>
</template>

<script>
import deckService from '../services/DeckService';

export default {
    name:"decks",
    data(){
        return{
            decks:[],
            deckName:''
        }
    },
    created() {
    deckService.getDecks().then(response => {
      this.decks = response.data;
    });
  }
    
}
</script>