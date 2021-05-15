<template>
  <div v-if="personen.length !== 0" class="table-striped well my-5">
    <div class="row">
      <div class="col-md-1 text-uppercase text-primary text-left font-weight-bold">#</div>
      <div class="col-md-2 text-uppercase text-primary  text-left">Voornaam</div>
      <div class="col-md-2 text-uppercase text-primary  text-left">Familie naam</div>
      <div class="col-md-2 text-left text-primary text-uppercase ">Email adres</div>
    </div>
    <div v-for="persoon in personen" class="row" v-bind:key="persoon.persoonId"
         v-on:click="showPersoonDetails(persoon.persoonId)"  >
      <div class="col-md-1 text-left" >
        {{persoon.persoonId}}
      </div>
      <div class="col-md-2 text-left titeltoegevoegd" >
        {{persoon.voornaam}}
      </div>
      <div class="col-md-2 text-left" >
        {{persoon.familienaam}}
      </div>
      <div class="col-md-2 text-left" >
        {{persoon.emailadress}}
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

async function getPersonen(){
  const url = 'http://localhost:8081/personen';
  let result = (await axios.get(url , {withCredentials : true})).data;

  return result;

}
export default {
  name: "PersonenTabel",
  data (){
    return {
      "personen" : [],

    }
  },
  created() {
    var result = getPersonen();
    result.then((res) => this.personen = res)
    console.log(this.personen);
  },
  methods: {
    showPersoonDetails(persoonId) {

      window.location.href = "/persoon/" + persoonId;
    }
  },
}



</script>

<style scoped>

</style>