<template>
    <div>
        <h1>{{ deckName }}</h1>
        <h3>{{deckDescription}}</h3>
        <div>
            <button class="addCards" v-if= "!showForm" v-on:click= "showForm = true">Add card</button>
            <create-card v-if= "showForm" 
                         v-bind:deckName = "deckName" 
                         v-bind:deckDescription = "deckDescription"
                         v-bind:deckId = "deckId"/>
        </div>
        <div class = "cards">
           <!-- <div v-for = "card in cards" 
                 v-bind:key = "card.id">
                 v-on:click="viewCardDetails(card.id)">-->
                <card v-for = "card in cards" v-bind:card="card" v-bind:key = "card.id" v-bind:deckId="deckId"/>
            <!--</div>-->
        </div>
        

    </div>
</template>

<script>
import deckService from '../services/DeckService';
import Card from '../components/Card.vue'
import CreateCard from '@/components/CreateCard.vue'

export default {
    name:"deck",
    
    components:{
        Card,
        CreateCard
    },
    data(){
        return{
            deckName:'',
            deckDescription:'',
            cards:[],
            questionUp : true,
            showForm:false,
            deckId:''
        }
    },
    methods: {
    viewCardDetails(cardID) {
      this.$router.push(`/decks/${this.$route.params.id}/card/${cardID}`);
    },
    },
    created() {
    deckService.getCardsByDeckId(this.$route.params.id).then(response => {
      this.deckName = response.data.deckName;
      this.deckDescription = response.data.deckDescription;
      this.deckId = response.data.deckId;
      this.cards = response.data.cards;
    });

  }

    
}
</script>

<style>
    .cards{
        display: flex;
        flex-wrap:wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    .main{
        display:flex;
        flex-direction: row;
    }



</style>

