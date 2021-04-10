<template>
    <div>
        abcd
        <h1>{{ deckName }}</h1>
        {{cards}}
        <div class = "cards">
            <div v-for = "card in cards" v-bind:key ="card.id">
                <card/>
            </div>
        </div>
        

    </div>
</template>

<script>
export default {
    name:"deck",
    data(){
        return{
            deckName:'',
            cards:[]
        }
    },
    created() {
    deckService.getCardsByDeckId(this.$route.params.id).then(response => {
      this.deckName = response.data.deckName;
      this.cards = response.data.cards;
    });
  }

    
}
</script>