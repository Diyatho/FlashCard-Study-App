<template>
    <div><br>
         <img src="@/assets/TEHOOT.png" alt="logo">
         <br>
         <br>
         <br>
         <div>
            <single-card v-bind:card = "cards[index]" v-bind:questionUp = "true"/>
            <button v-on:click = "nextQuestion" class = "next"> Next </button>
        </div>
        <div>
        <button v-on:click = "markRight" class="correct">Mark Correct</button>
         </div>
        <div>
            <button v-on:click = "showFinalScore" class="end"> End Study Session</button>
        </div>
        <div v-if= "endOfDeck" class = "alert">
            <p>You have reached the end of the deck! Click "End Study Session" to see your score!</p>
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
    .next {
-moz-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    -webkit-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    box-shadow:inset 0px -1px 3px 0px #91B8B3;
    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #FFFF00), color-stop(1, #FFFF00));
    background:-moz-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
    background:-webkit-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
    background:-o-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
    background:-ms-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
    background:linear-gradient(to bottom, #C57BFF 5%, #C57BFF 100%);
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFF00', endColorstr='#FFFF00',GradientType=0);
    background-color:#C57BFF;
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
/* text-shadow:0px -1px 0px #2B665E; */
}
.correct {
  -moz-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    -webkit-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    box-shadow:inset 0px -1px 3px 0px #91B8B3;
    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #FFFF00), color-stop(1, #FFFF00));
    background:-moz-linear-gradient(top, #FFFF00 5%, #FFFF00 100%);
    background:-webkit-linear-gradient(top, #FFFF00 5%, #FFFF00 100%);
    background:-o-linear-gradient(top, #FFFF00 5%, #FFFF00 100%);
    background:-ms-linear-gradient(top, #FFFF00 5%, #FFFF00 100%);
    background:linear-gradient(to bottom, #FFFF00 5%, #FFFF00 100%);
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFF00', endColorstr='#FFFF00',GradientType=0);
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
    /* text-shadow:0px -1px 0px #2B665E; */
}
.end {
  -moz-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    -webkit-box-shadow:inset 0px -1px 3px 0px #91B8B3;
    box-shadow:inset 0px -1px 3px 0px #91B8B3;
    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #FFFF00), color-stop(1, #FFFF00));
    background:-moz-linear-gradient(top, #00AFEF 5%, #00AFEF 100%);
    background:-webkit-linear-gradient(top, #00AFEF 5%, #00AFEF 100%);
    background:-o-linear-gradient(top, #00AFEF 5%, #00AFEF 100%);
    background:-ms-linear-gradient(top, #00AFEF 5%, #00AFEF 100%);
    background:linear-gradient(to bottom, #00AFEF 5%, #00AFEF 100%);
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFF00', endColorstr='#FFFF00',GradientType=0);
    background-color:#00AFEF;
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
    /* text-shadow:0px -1px 0px #2B665E; */
}

</style>