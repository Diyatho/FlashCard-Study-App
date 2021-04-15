<template>
  <div>
    <div class="decks">
      <div class="deck" v-for="deck in decks" v-bind:key="deck.deckId">
        <router-link v-bind:to="{ name: 'deck', params: { id: deck.deckId } }">
          {{ deck.deckName }}
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
import deckService from "../services/DeckService";

export default {
  name: "decks",
  data() {
    return {
      decks: [],
    };
  },
  created() {
    deckService.getDecks().then((response) => {
      this.decks = response.data;
    });
  },
};
</script>

<style>
    .decks {
        display: flex;
        flex-wrap:wrap;
        justify-content: space-between;
        align-items: center;
        
    }

.decks {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
}

.deck {
  background-color: #bbe9fa;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 20px 20px;
<<<<<<< HEAD
  font-size: 22px;
  font-family: copperplate;
  text-decoration: none;
=======
  font-size:22px;
  font-family:copperplate;
  text-decoration: none; 
>>>>>>> b6c78761a6b067c213a3a0109e9a4f51704d6b1f
  text-align: center;
}
</style>