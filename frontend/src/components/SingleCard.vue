<template>
    <div>
        <transition name="flip" mode="out-in">
        <!--Front-->
        <div
          v-on:click="questionUp = false"
          v-if="questionUp"
          class="boxed question"
          key="front"
        >
          {{ card.question }} <br />
        </div>
        <!--Back-->
        <div v-on:click="questionUp = true"
        v-else 
        class="boxed answer"
        key="back"
        >
          {{ card.answer }}
        </div>
      </transition>
    </div>
</template>
<script>
export default {
  props:["card","questionUp"],
  data(){
    return{
      questionUp:true
    }
  },
}
</script>
<style scoped>
</style>