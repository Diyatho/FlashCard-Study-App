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
  margin: 15px 0;
  font-size: 20px;
}
.boxed {
  width: 60%;
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
  background: #bbe9fa;
}
.answer {
  background: #cffae0;
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
.flip-enter-to,
.flip-leave-from {
  opacity: 1;
  transform: rotateY(0);
}
.flip-enter-action,
.flip-leave-active {
  transition: all 0.5s ease;
}
</style>