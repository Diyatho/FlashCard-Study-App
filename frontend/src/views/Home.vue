<template>
  <div class="home">
    <!--<h1>Home</h1>-->
    <p id = "welcome">Welcome {{username}}!!</p>


   <!-- <router-link v-bind:to="{ name: 'createCard' }">Create A Deck</router-link><br/>-->
    <router-link v-bind:to="{ name: 'createDeck' }">Create A Deck</router-link><br/>
    <!--<router-link v-bind:to="{ name: 'viewDecks' }">View Saved Decks</router-link><br/>-->
    <router-link v-bind:to="{ name: 'studySession' }">Start a study session</router-link><br/>
    <router-link v-bind:to="{ name: 'viewCards' }">View All Cards</router-link>

    <decks/>
    <!--<card/>-->
      
  </div>
</template>

<script>

import Decks from '@/components/Decks.vue';
import Card from '@/components/Card.vue';


export default {
  name: "home",
  components:{
    Decks,
    Card

  },
  data(){
    return{
      
    }
  },
  computed:{
    username(){
      return this.$store.state.user.username.toUpperCase();
    }
  }

}
</script>

<style>


#welcome{
  font-size: 30px;
  text-align: left;
}
</style>


