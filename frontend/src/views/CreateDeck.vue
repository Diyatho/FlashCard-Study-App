<template>
    <div>
        <div class = "deckName">
            <label for="deckName">Name of the Deck: </label>
            <input id="deckName" type="text" v-model="deckName" />
        </div>
        <div class = "deckDescription">
            <label for="deckDescription">Description: </label>
            <textarea id="deckDescription" name="deckDescription" rows="4" cols="30" v-model="deckDescription"></textarea>
        </div>

        <button class="addCards" v-if= "!showForm" v-on:click= "createNewDeck">Add cards to deck</button>
        <create-card v-if= "showForm" v-bind:deckName = "deckName" v-bind:deckDescription = "deckDescription"/>
        



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
            deckName:'',
            deckDescription:'',
        }
    },
    methods:{
        createNewDeck(){
            this.showForm = true;
            cardService.createDeck(this.deckName, this.deckDescription).then(response => {
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