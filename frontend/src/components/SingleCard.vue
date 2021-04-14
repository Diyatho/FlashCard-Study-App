<template>
    <div>
        <div class = "container">
            <div v-if= "questionUp"  class="boxed question">
              {{card.question}}
              <div>
               <button class = "showAnswer" v-on:click = "questionUp = false">Show Answer</button>
              </div>
              <div v-if= "endOfDeck" class = "alert"> 
                  <p>You have reached the end of the deck!</p>
              </div> 
              
            </div>
            <div v-on:click = "questionUp = true" v-if= "!questionUp" class="boxed answer">
                {{card.answer}}
            </div>
      </div>

    </div>
</template>

<script>
export default {
  props:["card"],
  data(){
    return{
      questionUp:true
    }
  }
  
}
</script>

<style scoped>
  
</style>