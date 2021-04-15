<template>
<div><br>
    <img src="@/assets/TEHOOT.png" alt="Tehoot logo">
    <div>
        <div class = "deckName">
            <label for="deckName">Deck Name: </label>
            <input id="deckName" type="text" v-model="deckName" />
        </div>
        <div class = "deckDescription">
            <label for="deckDescription">Description: </label>
            <textarea id="deckDescription" name="deckDescription" rows="4" cols="30" v-model="deckDescription"></textarea>
        </div>

        <button class="addCards" v-if= "!showForm" v-on:click= "createNewDeck">Add card to deck</button>
        <create-card v-if= "showForm" v-bind:deckName = "deckName" v-bind:deckDescription = "deckDescription"/>
        <br>
        <br>
        
        <br>
        <div>
        <img id="Owl" src="@/assets/TEHOOTOwl.png" alt="Owl"></div>


    </div>
    </div>
</template>

<script>
import CreateCard from '@/components/CreateCard.vue'
import cardService from '@/services/CardService';


export default {
    name:"create-deck",
    components:{
        CreateCard
    },
    data(){
        return{
            showForm:false,
            deckName:'',
            deckDescription:''
        }
    },
    methods:{
        createNewDeck(){
            this.showForm = true;
            cardService.createDeck(this.deckName, this.deckDescription).then(response => {
                console.log(response);
            });
        }
    }
    
    
}
</script>



<style>
    .deckName{
        padding : 20px;
        margin:20px;
        font-size: 28px;
    }

    .addCards{
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-webkit-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-o-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-ms-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:linear-gradient(to bottom, #ffff00 5%, #ffff00 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#ffff00;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#00000b;
	font-family:Arial;
	font-size:20px;
	font-weight:bold;
	padding:11px 23px;
	text-decoration:none;
	text-shadow:0px -1px 0px #2b665e;
}
    
.deckDescription {
    font-size: 18px;
}
#owl {
    align-content: center;
    width: 50%;
    height: auto;
}
input[type=text] {
  padding: 0;
  height: 30px;
  position: relative;
  left: 0;
  outline: none;
  border: 1px solid #cdcdcd;
  
  background-color: white;
  font-size: 16px;
}


</style>