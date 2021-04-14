<template>
    <div>

         <br>
    <img src="@/assets/TEHOOT.png" alt="Tehoot logo">
        <div class = "container">
       
            <div v-if= "questionUp"  class="boxed question">
              {{card.question}}
              <button v-on:click = "questionUp = false">Show Answer</button>
            </div>
            <div v-on:click = "questionUp = true" v-if= "!questionUp" class="boxed answer">
                {{card.answer}}
            </div>
      </div>

    </div>
</template>