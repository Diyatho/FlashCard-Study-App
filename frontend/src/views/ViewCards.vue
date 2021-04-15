<template>
    <div>
      <div>
        <label for="search">Search Cards By Keyword: </label>
        <input type="text"  placeholder="Type keyword here" v-model = "keyword">
      </div>
      <h1>All Cards</h1>
      <div class = "cards">
            <div v-for = "card in filteredCards" 
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
            cards: [],
            keyword:''

        }
    },
    computed: {
    filteredCards() {
      //const reviewsFilter = parseInt(this.$store.state.filter);
      const cards = this.cards;
      console.log(cards);
      return cards.filter((card) => {
        return this.keyword == '' ? true: card.keywords.includes(this.keyword);
      });
    },
  },
    created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }
    
}
</script>