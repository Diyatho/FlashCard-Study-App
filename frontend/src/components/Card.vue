<template>
    <div>
      <div class = "container">
       
            <div v-if= "questionUp"  class="boxed question">
              {{card.question}}
              <button v-on:click = "questionUp = false">Show Answer</button>
              <button class = "edit" v-on:click = "edit">Edit</button>
            </div>
            <div v-on:click = "questionUp = true" v-if= "!questionUp" class="boxed answer">
                {{card.answer}}
            </div>
      </div>
    </div>
</template>
<script>

export default {
  props: ["card", "deckId"],
    data(){
      return{
       cards: '',
       questionUp : true,
      }
  },
  methods:{
    edit(){
      this.$router.push({ name: "edit-card", params: { id:this.deckId,cardId: this.card.id } });
    }
  }
}
</script>
<style>
    .container{
      display:flex; 
      justify-content: space-evenly;
      align-items: center;
      flex-wrap: wrap;
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
    .question{
      background: #BBE9FA;
    }
    .answer{
      background: #CFFAE0;
    }
    .card{
        border-radius: 6px;
        padding: 1rem;
        margin: 10px;
    }
    .edit{
      font-size:12px;
    }
</style>