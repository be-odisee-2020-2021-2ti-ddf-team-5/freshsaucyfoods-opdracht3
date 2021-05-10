<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link>
      |
      <a><router-link to="/bestelling">Bestelling</router-link></a> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view/>
    <footer-fsf/>
  </div>

</template>

<script>

import FooterFsf from './components/Footer.vue'

export default {
  name: 'App',
  components: {
    FooterFsf
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
