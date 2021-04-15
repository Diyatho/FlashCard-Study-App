<template>
    <div>
        <div>
            <single-card v-bind:card = "cards[index]" v-bind:questionUp = "true"/>
            <button v-on:click = "nextQuestion" class = "next"> Next </button>
        </div>
        <div>
        <button v-on:click = "markRight">Mark Right</button>
         </div>
        <div>
            <button v-on:click = "showFinalScore"> End Study Session</button>
        </div>
        <div v-if= "endOfDeck" class = "alert"> 
            <p>You have reached the end of the deck. Click on "End Study Session" to know the score!</p>
        </div> 
        <div v-if="showScore">
            Your score is {{score}} out of {{questions}}!
        </div>
    </div>
</template>
<script>
import deckService from '../services/DeckService';
import SingleCard from '../components/SingleCard'
export default {
    data(){
        return{
            cards:[],
            index:0,
            score:0,
            questions:1,
            showScore: false,
            endOfDeck:false
        }
    },
    components:{
        SingleCard
    },
    methods:{
        nextQuestion(){
            console.log(this.questions);
            if(this.questions != this.cards.length){
                this.questions++;
                this.index++;
            }
            else{
                this.endOfDeck = true;
            }
        },
        markRight(){
            this.score++;
        },
        showFinalScore(){
            this.showScore = true;
        }
    },
    created() {
        deckService.getCardsByDeckId(this.$route.params.deckId).then(response => {
        this.deckName = response.data.deckName;
        this.deckDescription = response.data.deckDescription;
        this.deckId = response.data.deckId;
        this.cards = response.data.cards;
        });
    }   
}
</script>
<style>
</style>