<template>
    <div>
      <div class = "container">
            <div v-if= "questionUp"  class="boxed">
              
              {{card.question}}
             <button v-on:click = "questionUp = false">Show Answer</button>
             <button class = "edit" v-on:click = "edit">Edit</button>
            </div>
            <div v-on:click = "questionUp = true" v-if= "!questionUp" class="boxed">
                {{card.answer}}
            </div>
        
      </div>

    </div>
    
</template>


<script>
import cardService from '@/services/CardService';

export default {
  props: ["card"],
    data(){
      return{
       cards: '',
       questionUp : true,
      }
  },
  methods:{
    edit(){
      
    }
  }

    /*created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }*/
    
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