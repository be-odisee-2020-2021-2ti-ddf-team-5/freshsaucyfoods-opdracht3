<template>
  <div id="bestelmlingForm">
    <input type="hidden" id="id" name="id" value="0"/>

    <div class="form-group">
      <label for="title">Voor naam:&nbsp;</label><br><input id="title" name="title" type="text" style="width: 40em" v-model="persoonData.voornaam" placeholder="[Jef]" /><br>
      <span class="validationError" ></span>
    </div>
    <div class="form-group">
      <label for="aantalLiter">Familie naam</label><br><input id="aantalLiter" name="aantalLiter" type="text" style="width: 40em" v-model="persoonData.familienaam" placeholder="[Lokers]"  /><br>
      <span class="validationError"  ></span>
    </div>
    <div class="form-group">
      <label for="leverDatum">Email adres:&nbsp;</label><br><input id="leverDatum" name="leverDatum" type="email" style="width: 40em" v-model="persoonData.emailadress" placeholder="[jef.lokers@test.com]" /><br>
      <span class="validationError" ></span>
    </div>
    <div v-if="this.$route.params.peroonId === 0" class="form-group my-4">
      <button v-on:click="submitForm" class="btn btn-primary btn-md" name="submit">Create persoon</button>
    </div>
    <div v-if="this.$route.params.peroonId !== 0" class="form-group my-4">
      <button v-on:click="submitForm" class="btn btn-primary btn-md" name="submit">Update persoon</button>
      <button  class="btn btn-default btn-md" name="inplannen">Persoon inplannen</button>
      <button v-on:click="deletePersoon" class="btn btn-danger btn-md" name="delete">Delete persoon</button>
      <button class="btn btn-warning btn-md" name="cancel">Cancel</button>
    </div>
   <personen-tabel></personen-tabel>
  </div>
</template>

<script>
import PersonenTabel from "./PersonenTabel";
import axios from "axios";
export default {
  name: "PersonenForm",
  components: {PersonenTabel},
  data(){
    return {"persoonData" : {
      "persoonId": 0,
        "emailadress" : "",
        "familienaam": "",
        "password": "",
        "status": "",
        "voornaam": "",
        "role":"",
    },
      "message" : "Maak aub een persoon aan",
      "componentKey" : 0,
    };

  },
  created() {
    let url;
    if(this.$route.params.peroonId != null){
      url = 'http://localhost:8081/persoon/' + this.$route.params.peroonId;
      this.message = "Wijzig, verwijder persoon of annuleer";
    }
    else {
      url = 'http://localhost:8081/personen';
    }

    axios.get(url , {withCredentials : true})
        .then((response) => {
          this.persoonData = response.data;
          console.log(this.$route.params.peroonId);
          if(response.status === 204){
            this.newForm();
          }
        })
        .catch((error) => {
          if (error.response.status === 403) {
            // entry forbidden for user
            this.message = "persoon met id "+this.$route.params.peroonId+" is niet gevonden";
            this.newForm();
          } else {

            console.log(error.message);
          }
        })
  },
  methods : {
    //update en creëren in een
    submitForm : function () {
      const url = "http://localhost:8081/createPersoon/" + this.$route.params.persoonId;
      const headers = {
        withCredentials: true
      };

      console.log(this.persoonData);

      axios.post(url, this.persoonData, headers)
          .then( (response) => {
            this.message = response.data;
            this.componentKey += 1;

            if (this.persoonData.persoonId !== 0) {
              this.persoonData.persoonId = 0; // klaar voor nieuwe entry nu
              this.newForm();
            }
          })
          .catch(function (error) {
            console.log(error)
          });
    },
    deletePersoon : function () {
      const url = "http://localhost:8081/deletePersoon/" + this.$route.params.peroonId;
      const headers = {
        withCredentials: true
      };

      axios.delete(url, this.persoonData, headers)
          .then( (response) => {
            this.message = response.data;
            this.componentKey += 1;
            this.newForm();
          })
          .catch(function (error) {
            if (error.response.status === 403) {

              this.message = "persoon met id "+this.$route.params.peroonId+" is verboden";

              this.newForm();
            } else {
              console.log(error.message);
            }
          });
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