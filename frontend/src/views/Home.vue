<template>
  <div class="home">
    <img src="@/assets/TEHOOT.png" alt="logo">
    <p id = "welcome">Welcome {{username}}!!</p>

    
<div class="form">
  <form class="form-options">
    
   <router-link class=createADeck v-bind:to="{ name: 'createDeck' }" tag="button">Create A Deck</router-link>
    <!--<router-link v-bind:to="{ name: 'viewDecks' }">View Saved Decks</router-link><br/>-->
   <br>
    <router-link class=studySession v-bind:to="{ name: 'studySession' }" tag="button">Start A Study Session</router-link>
    <br>
<router-link class=viewCards v-bind:to="{ name: 'viewCards' }" tag="button">View All Cards</router-link>
  </form>
  </div>
   <br>
   <!--<img id="Owl" src="@/assets/TEHOOTOwl.png" alt="Owl"> -->
   <decks/>   
  </div>
</template>

<script>

import Decks from '@/components/Decks.vue';


export default {
  name: "home",
  components:{
    Decks

  },
  data(){
    return{
      
    }
  },
  computed:{
    username(){
      return this.$store.state.user.username.toUpperCase();
    }
  }

}
</script>

<style>
img{ 
  width: 800px;
}
#Owl{
  width: 275px;
  margin: 15px;
}
#welcome{
  font-size: 20px;
}
div.form
{
    display: block;
    text-align: center;
}
form {
  font-size: 20px;
  padding: 15px;
  background: rgb(211, 211, 211);
  border-style: solid;
  max-width: fit-content;
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
  
}

.form-control{
  margin: 10px;
  padding: 5px;
}

#welcome{
  font-size: 30px;
  text-align: left;
}
button{
  font-size: 20px;
  margin: 7px;
}
.createADeck {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-webkit-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-o-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:-ms-linear-gradient(top, #C57BFF 5%, #C57BFF 100%);
	background:linear-gradient(to bottom, #C57BFF 5%, #C57BFF 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#C57BFF;
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
/* text-shadow:0px -1px 0px #2b665e; */
}
.studySession {
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
	/* text-shadow:0px -1px 0px #2b665e; */
}
.viewCards {
  -moz-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px -1px 3px 0px #91b8b3;
	box-shadow:inset 0px -1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-webkit-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-o-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:-ms-linear-gradient(top, #80DA71 5%, #80DA71 100%);
	background:linear-gradient(to bottom, #80DA71 5%, #80DA71 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#80DA71;
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
/* text-shadow:0px -1px 0px #2b665e; */
}

</style>


