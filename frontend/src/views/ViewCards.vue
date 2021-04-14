<template>
    <div>
      <h1>All Cards</h1>
      <div class = "cards">
            <div v-for = "card in cards" 
                 v-bind:key = "card.id">
                 <!--v-on:click="viewCardDetails(card.id)">-->
                <card v-bind:card="card"/>
            </div>
        </div>

    </div>
    
</template>

<script>
import cardService from '../services/CardService'
import Card from '../components/Card.vue'

export default {
    name:'view-cards',
    components:{
      Card
    },
    data(){
        return{
            cards: []

        }
    },
    created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }
    
}
</script>