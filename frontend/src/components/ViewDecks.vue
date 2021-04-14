<template>
    <div>

    </div>
    
</template>

<script>
export default {
    name:'view-decks',
    data(){
        return{
            cards: ''

        }
    },
    created(){
    this.cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }
    
}
</script>