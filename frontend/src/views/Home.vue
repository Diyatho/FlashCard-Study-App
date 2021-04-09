<template>
  <div class="home">
    <h1>Home</h1>
    <p id = "welcome">Welcome {{username}}!!</p>

    <decks/>

   <!-- <router-link v-bind:to="{ name: 'createCard' }">Create A Deck</router-link><br/>-->
    <router-link v-bind:to="{ name: 'createDeck' }">Create A Deck</router-link><br/>
    <!--<router-link v-bind:to="{ name: 'viewDecks' }">View Saved Decks</router-link><br/>-->
    <router-link v-bind:to="{ name: 'studySession' }">Start a study session</router-link><br/>
    <router-link v-bind:to="{ name: 'viewCards' }">View All Cards</router-link>
      
  </div>
</template>

<script>

import Decks from '@/components/Decks.vue';


export default {
  name: "home",
  components:{
    Decks

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
  font-size: 20px;
}
</style>


