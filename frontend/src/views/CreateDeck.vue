<template>
    <div>
        <div class = "deckName">
            <label for="question">Name of the Deck: </label>
            <input id="question" type="text" v-model="deckName" />
        </div>

        <button class="addCards" v-if= "!showForm" v-on:click= "createNewDeck">Add cards to deck</button>
        <create-card v-if= "showForm" v-bind:deckName = "deckName"/>
        



    </div>
</template>

<script>
import CreateCard from '@/components/CreateCard.vue'
import cardService from '@/services/CardService';


export default {
    name:"create-deck",
    components:{
        CreateCard
    },
    data(){
        return{
            showForm:false,
            deckName:''
        }
    },
    methods:{
        createNewDeck(){
            this.showForm = true;
            cardService.createDeck(this.deckName).then(response => {
                console.log(response);
            });
        }
    }
    
    
}
</script>



<style>
    .deckName{
        padding : 20px;
        margin:20px;
    }

    .addCards{
        font-size:15px;
    }

</style>