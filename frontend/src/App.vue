<template>
  <div id="app">
    <div class="topnav">
 
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp; &nbsp;
      <router-link v-bind:to="{ name: 'about' }">About</router-link>&nbsp; &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
.topnav {
  background-color: #7DDFA4 ;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: right;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>