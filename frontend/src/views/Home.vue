<template>
  <div class="home">
    <h1>Home</h1>
    <p id = "welcome">Welcome {{username}}!!</p>
    <router-link v-bind:to="{ name: 'createCard' }">Create A Card</router-link><br/>
    <router-link v-bind:to="{ name: 'viewDecks' }">View Saved Decks</router-link><br/>
    <router-link v-bind:to="{ name: 'studySession' }">Start a study session</router-link><br/>
    <router-link v-bind:to="{ name: 'viewCards' }">View All Cards</router-link>
    <div v-for="card in cards" v-bind:key = "card.id">
    <div v-if= "questionUp"  class="boxed">
      {{card.question}}
      <button v-on:click = "questionUp = false">Show Answer</button>
    </div>
    <div v-if= "!questionUp" class="boxed">
      {{card.answer}}
    </div>
    </div>
  </div>
</template>
<script>
import cardService from '@/services/CardService';
export default {
  name: "home",
  data(){
    return{
      cards: '',
      questionUp : true,
      //answerUp: false
    }
  },
  computed:{
    username(){
      return this.$store.state.user.username.toUpperCase();
    }
  },
  methods:{
    showAnswer(){
      this.questionUp = false;
     // answerUp = true;
    }
  },
  created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;
    })
  }
};
</script>
<style>
.boxed {
  width:60%;
  text-align: center;
  background-color: rgb(191, 209, 243);
  height: 240px;
  width:540px;
  margin:auto;
  border: 1px solid green ;
}
#welcome{
  font-size: 20px;
}
</style>