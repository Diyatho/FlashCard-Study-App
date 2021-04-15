<template>
    <div>
        <br>
         <img src="@/assets/TEHOOT.png" alt="logo">
         <br>
         <br>
         <br>
        <h1>Choose a deck to start study session</h1>
        <select v-model= deckName>
            <option v-for="deck in decks" v-bind:key = "deck.deckId" v-bind:value = "deck.deckId">
                {{deck.deckName}}
            </option>
        </select><br/>
        <button id="start" v-on:click="$router.push({name:'studyDeck',params:{deckId:deckName}})" >Start Study Session</button>
    <br>
    <br>
    <br>
     <img id="Owl" src="@/assets/TEHOOTOwl.png" alt="Owl">
    </div>
</template>

<script>
import deckService from '../services/DeckService';

export default {
    name:"decks",
    data(){
        return{
            decks:[],
            deckName:'--Deck name--'
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
#start {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-webkit-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-o-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-ms-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:linear-gradient(to bottom, #ffff00 5%, #ffff00 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#ffff00;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#00000b;
	font-family:Arial;
	font-size:20px;
	font-weight:bold;
	padding:11px 23px;
	text-decoration:none;
	/* text-shadow:0px -1px 0px #2b665e; */
}
</style>