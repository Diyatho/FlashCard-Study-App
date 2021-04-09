<template>
    <div>
        
    </div>
    
</template>



<script>
import cardService from '@/services/CardService';
export default {
    name:"view-cards",
    data(){
        return{
            cards: ''

        }
    },
    created(){
    cardService.getCards().then(response =>{
      this.cards = response.data;

    })
  }
    
}
</script>