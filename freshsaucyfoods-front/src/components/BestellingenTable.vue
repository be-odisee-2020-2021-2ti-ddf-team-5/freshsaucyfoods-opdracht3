<template>
  <div v-if="bestellingen.length != 0" class="table-striped well">
    <div class="row">
      <div class="col-md-1 text-uppercase text-primary text-left font-weight-bold">#</div>
      <div class="col-md-2 text-uppercase text-primary  text-left">Naam</div>
      <div class="col-md-2 text-uppercase text-primary  text-left">Aantal liter</div>
      <div class="col-md-2 text-left text-primary text-uppercase ">Status</div>
      <div class="col-md-2 text-left text-primary text-uppercase ">Gewenste leverdatum</div>
      <div class="col-md-2 text-left text-primary text-uppercase ">Start productie</div>
    </div>
    <div v-for="bestelling in bestellingen" class="row" v-bind:key="bestelling.id"
         v-on:click="showEntryDetails(bestelling.id)"  >
      <div class="col-md-1 text-left" >
        {{bestelling.id}}
      </div>
      <div class="col-md-2 text-left titeltoegevoegd" >
        {{bestelling.title}}
      </div>
      <div class="col-md-2 text-left" >
        {{bestelling.aantalLiter}}
      </div>


      <div v-if="bestelling.vooruitgang ==='Klaar'">
        <div class="col-md-2 text-left bg-success" >
          {{bestelling.vooruitgang}}
        </div>
      </div>
      <div v-if="bestelling.vooruitgang ==='Aangemaakt'">
        <div class="col-md-2 text-left bg-info"  >
          {{bestelling.vooruitgang}}
        </div>
      </div>
      <div v-if="bestelling.vooruitgang ==='Weiger'">
        <div class="col-md-2 text-left bg-danger"  >
          {{bestelling.vooruitgang}}
        </div>
      </div>
      <div v-if="bestelling.vooruitgang ==='In Productie'">
        <div class="col-md-2 text-left bg-warning"  >
          {{bestelling.vooruitgang}}
        </div>
      </div>
      <div v-else>
        <div class="col-md-2 text-left"  >
          {{bestelling.vooruitgang}}
        </div>
      </div>
      <div class="col-md-2 text-left" >
        {{bestelling.leverDatum}}
      </div>
      <div class="col-md-2 text-left" >
        {{bestelling.startProductie}}
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

async function getBestellingen(){
  const url = '';
  let result = (await axios.get(url , {withCredentials : true})).data;
  return result;
}

export default {
  name: "BestellingenTable",

  data (){
    return {
      "bestellingen" : []
    }
  },
  created() {
    var result = getBestellingen();
    result.then((res) => this.bestellingen = res)
  }
}
</script>

<style scoped>

</style>