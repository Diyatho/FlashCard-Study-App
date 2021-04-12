<template>

  <div id="login" class="text-center">

    <img src="@/assets/TEHOOT.png" alt="Tehoot logo">
  
    <!--Test Logo-->
   
    <!--<h3>Create your own flashcards!<br>
        Wise up on any subject!</h3>-->

      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
   <div class="form">
   <form class="form-signin" @submit.prevent="login">

      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>

      
      <button a href="#" class=signIn type="submit">Sign in</button><br>
<router-link :to="{ name: 'register' }">Need an account?</router-link><br>
      <router-link :to="{ name: 'explore' }">Explore!</router-link>


    </form>
    </div>

  <img id="Owl" src="@/assets/TEHOOTOwl.png" alt="Owl">
  
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

/* Rectangle 4 */

body {
background: #7DDFA4;
text-align: center;
font-family: Helvetica, Arial, sans-serif;
}

h3{
  color: White;
}

img {
filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.1));
width: 50%;
}

#login{
  margin: auto;
}

#Owl{
  width: 275px;
  margin: 15px;
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
    align-content: center;
  
}

.form-control{
  margin: 10px;
  padding: 5px;
}

button{
  font-size: 20px;
  margin: 7px;
  
}
.signIn {
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
  /* &:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffff00), color-stop(1, #ffff00));
	background:-moz-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-webkit-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-o-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:-ms-linear-gradient(top, #ffff00 5%, #ffff00 100%);
	background:linear-gradient(to bottom, #ffff00 5%, #ffff00 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff00', endColorstr='#ffff00',GradientType=0);
	background-color:#ffff00;
}
 &:active {
	position:relative;
	top:1px;
} */
  
    

</style>

