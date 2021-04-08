<template>
<div>
     <div class="form-element">
        <label for="question">Question:</label>
        <input id="question" type="text" v-model="newCard.question" />
      </div>
      <div class="form-element">
        <label for="answer">Answer:</label>
        <input id="answer" type="text" v-model="newCard.answer" />
      </div>
      <div class="form-element">
        <label for="subject">Subject:</label>
        <input id="subject" type="text" v-model="newCard.subject" />
      </div>
      <div class="form-element">
        <label for="keywords">Keywords:</label>
        <input id="keywords" type="text" v-model="newCard.keywords" />
      </div>
      <input type="submit" value="Make Card" />

</div>
    
</template>


<script>
export default {
    name:"create-card",
    data(){
        return{
            newCard:{}
        }
    }
    
}
</script>