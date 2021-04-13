<template>
    <div>
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