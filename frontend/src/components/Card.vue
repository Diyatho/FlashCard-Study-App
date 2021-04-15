<template>
  <div>
    <div class="container">
      <transition name="flip" mode="out-in">
        <!--Front-->
        <div
          v-on:click="questionUp = false"
          v-if="questionUp"
          class="boxed question"
          key="front"
        >
          {{ card.question }} <br />
          <button class="edit" v-on:click="edit">Edit</button>
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
  </div>
</template>
<script>
export default {
  name:"card",
  props: ["card", "deckId"],
  data() {
    return {
      cards: "",
      questionUp: true,
    };
  },
  methods: {
    edit() {
      this.$router.push({
        name: "edit-card",
        params: { id: this.deckId, cardId: this.card.id },
      });
    },
  },
};
</script>
<style>
.container {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-wrap: wrap;
}
.boxed {
  text-align: center;
  background-color: rgb(184, 190, 201);
  line-height: 100px;
  height: 200px;
  padding: 20px;
  width: 400px;
  margin: auto;
  border: 1px solid green;
  border-radius: 10px;
}
.question {
  background: #BBE9FA;
}
.answer {
  background: #CFFAE0;
}
.card {
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
.edit {
  font-size: 18px;
}
/*Flip Transitions */
.flip-enter-from,
.flip-leave-to {
  opacity: 0;
  transform: rotateY(180deg);
}
.flip-enter-action,
.flip-leave-active {
  transition: all 0.2s ease-in-out;
}
</style>