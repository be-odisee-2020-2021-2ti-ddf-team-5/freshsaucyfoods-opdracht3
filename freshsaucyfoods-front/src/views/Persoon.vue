<template>

  <div id="persoon">
    <div id="image">
      <img alt="Logo fsf" src="../assets/LogoFreshSaucyFoods.png" style="float: left; height: 3em" />
    </div>
    <personen-form/>
  </div>
</template>

<script>
import PersonenForm from "../components/PersonenForm";
export default {
  name: "Persoon",
  components: {PersonenForm}
}
</script>

<style scoped>

</style>