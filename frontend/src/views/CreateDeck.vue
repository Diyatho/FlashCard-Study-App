<template>
    <div>
        <div class = "deckName">
            <label for="question">Name of the Deck: </label>
            <input id="question" type="text" v-model="deckName" />
        </div>

        <button class="addCards" v-if= "!showForm" v-on:click= "showForm = true">Add cards to deck</button>
        <create-card v-if= "showForm"/>
        



    </div>
</template>

<script>
import CreateCard from '@/components/CreateCard.vue'


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