<template>
  <div id="bestelmlingForm">
    <input type="hidden" id="id" name="id" value="0"/>

    <div class="form-group">
      <label for="title">Titel:&nbsp;</label><br><input id="title" name="title" type="text" style="width: 40em" v-model="bestellingData.titel" placeholder="[Bestelling 1]" /><br>
      <span class="validationError" ></span>
    </div>
    <div class="form-group">
      <label for="aantalLiter">Aantal liter:&nbsp;</label><br><input id="aantalLiter" name="aantalLiter" type="number" style="width: 40em" v-model="bestellingData.aantalLiterBesteld"  /><br>
      <span class="validationError"  ></span>
    </div>
    <div class="form-group">
      <label for="leverDatum">Gewenste lever datum:&nbsp;</label><br><input id="leverDatum" name="leverDatum" type="date" style="width: 40em" v-model="bestellingData.voorafAfgesprokenEindDatum" /><br>
      <span class="validationError" ></span>
    </div>
    <div v-if="this.$route.params.id != null" >
      <label for="vooruitgang">Vooruitgang&nbsp;</label><br><input id="vooruitgang" name="vooruitgang" type="text" style="width: 40em" v-model="bestellingData.vooruitgang"/>
    </div>
    <div v-if="this.$route.params.id != null" class="form-group">
      <label for="startProductie">Start productie datum&nbsp;</label><br><input id="startProductie" name="startProductie" type="date" style="width: 40em" v-model="bestellingData.datumStartproductie" />
    </div>
    <div v-if="this.$route.params.id == null" class="form-group my-4">
      <button v-on:click="submitForm" class="btn btn-primary btn-md" name="submit">Create bestelling</button>

    </div>
    <div v-if="this.$route.params.id != null" class="form-group my-4">
      <button v-on:click="submitForm" class="btn btn-primary btn-md" name="submit">Update bestelling</button>
      <button v-on:click="deleteBestelling" class="btn btn-danger btn-md" name="delete">Delete bestelling</button>
      <button v-on:click="cancel" class="btn btn-warning btn-md" name="cancel">Cancel</button>


    </div>
    <bestellingen-table   ></bestellingen-table>
  </div>
</template>

<script>
import moment from "moment";
import axios from "axios";
import BestellingenTable from "@/components/BestellingenTable";

export default {
  name: "MainForm",
  components : {
    BestellingenTable
  },
  data(){
    return {
      "bestellingData": {
        "id": 0,
        "titel": "",
        "aantalLiterBesteld" : 0,
        "voorafAfgesprokenEindDatum" : moment().format("YYYY-MM-DD") ,
        "vooruitgang" : "",
        "datumStartproductie": moment().format("YYYY-MM-DD"),
      },
      "message" : "Maak aub een bestelling aan",
      "componentKey" : 0,
    };
  },
  created() {
    let url;
    if(this.$route.params.id != null){
      url = 'http://localhost:8080/bestellingen';
      this.message = "Wijzig, verwijder of plan een bestelling in - of annuleer";
    }
    else {
      url = 'http://localhost:8080/bestellingen';
    }

    axios.get(url , {withCredentials : true})
        .then((response) => {
          if(url !== 'http://localhost:8080/bestellingen'){
            this.persoonData = response.data;
          }
          console.log(this.persoonData);
          if(response.status === 204){
            this.newForm();
          }
        })
        .catch((error) => {
          if (error.response.status === 403) {
            // entry forbidden for user
            this.message = "bestelling met id "+this.$route.params.entryId+" is niet gevonden";
            this.newForm();
          } else {

            console.log(error.message);
          }
        })
  },
  methods : {
    //update en creëren in een
    submitForm : function () {
      let url = '';

      if(this.$route.params.id != null){
        url = "http://localhost:8080/bestelling/" + this.$route.params.id;
      }
      else {
        url = "http://localhost:8080/createBestelling";
      }
      const headers = {
        withCredentials: true
      };
      console.log(this.bestellingData)
      axios.post(url, this.bestellingData, headers)
          .then( (response) => {
            this.message = response.data;
            this.componentKey += 1;

            if (this.bestellingData.id !== 0) {
              this.bestellingData.id = 0; // klaar voor nieuwe entry nu
              this.newForm();
            }
          })
          .catch(function (error) {
            console.log(error)
          });
    },
    deleteBestelling : function () {
      const url = "http://localhost:8080/bestelling/" + this.$route.params.id;
      const headers = {
        withCredentials: true
      };

      axios.delete(url, this.bestellingData, headers)
          .then( (response) => {
            this.message = response.data;
            this.componentKey += 1;
            this.newForm();
          })
          .catch(function (error) {
            if (error.response.status === 403) {

              this.message = "bestelling met id "+this.$route.params.id+" is verboden";

              this.newForm();
            } else {
              console.log(error.message);
            }
          });
    },
    cancel : function(){
      window.location.href = "/bestelling";
    },
    newForm: function () {
      // redirect for newEntryData but after some delay
      setTimeout( () => this.$router.push({ name : ''}, () => { this.$router.go() } ), 1200);
    }
  }
}
</script>

<style scoped>

</style>