<template>
    <div>
      <div class = "container">
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

    </div>
    
</template>


<script>
import cardService from '@/services/CardService';

export default {
    data(){
    return{
      cards: '',
      questionUp : true,
    }
  },

    created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }
    
}
</script>

<style>
    .container{
      display:flex; 
      justify-content: space-evenly;
      align-items: center;
    }
    .boxed {
        width:60%;
        text-align: center;
        background-color: rgb(184, 190, 201);
        height: 100px;
        padding:30px;
        width:300px;
        margin:auto;
        border: 1px solid green ;
        border-radius: 10px;
    }
    .card{
        
        border-radius: 6px;
        padding: 1rem;
        margin: 10px;
    }

</style>