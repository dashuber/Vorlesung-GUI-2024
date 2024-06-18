<script setup lang="ts">
import {computed, reactive} from 'vue';
import {LocationModel} from '@/LocationModel';

//interface for this component
const props = defineProps({
  title: String,
});
const emit = defineEmits(['save']);

//data & data binding
let location = reactive(new LocationModel());


function save() {
  console.log(location.toString())
  emit('save', location);
}

function reset() {
  Object.assign(location, new LocationModel());
}

const subTypes = computed(() => {
  if (location.type) {
    return ['Sub-' + location.type + ' 1', 'Sub-' + location.type + ' 2'];
  } else {
    return [];
  }
});


</script>

<template>
  <div id="location-form">
    <h3>{{ props.title }}</h3>
    <label for="id-input">Id</label>
    <input type="text" disabled="true" id="id-input" v-model="location.id"/>

    <label for="name-input">Name</label>
    <input type="text" id="name-input" v-model="location.name"/>

    <hr/>

    <label for="label-input">Label</label>
    <input type="text" id="label-input" v-model="location.label"/>

    <label for="type-input">Type</label>
    <select id="type-input" v-model="location.type">
      <option>Type A</option>
      <option>Type B</option>
      <option>Type C</option>
    </select>

    <label for="sub-type-input">Sub type</label>
    <select id="sub-type-input" v-model="location.subType">
      <option v-for="type in subTypes" :key="type">{{ type }}</option>
    </select>

    <label for="since-input">Since</label>
    <input type="date" id="since-input" v-model="location.since"/>

    <div></div>

    <div class="active-form">
      <input type="checkbox" id="active-input" v-model="location.active"/>
      <label for="active-input">active</label>
    </div>

    <hr/>

    <label>Address</label>
    <div class="street-form">
      <input
          type="text"
          id="street-input"
          placeholder="Street"
          v-model="location.street"
      />
      <input
          type="text"
          id="number-input"
          size="3"
          placeholder="Nr"
          v-model="location.streetNumber"
      />
    </div>

    <div class="city-form">
      <input
          type="text"
          id="zip-input"
          placeholder="zip"
          v-model="location.zip"
      />
      <input
          type="text"
          id="city-input"
          placeholder="city"
          v-model="location.city"
      />
    </div>

    <hr/>
    <label for="notes-input">Notes</label>
    <textarea id="notes-input" v-model="location.notes"></textarea>

    <div class="button-container">
      <button type="button" class="btn btn-sm" v-on:click="reset()">
        Reset
      </button>
      <button
          type="button"
          class="btn btn-sm btn-primary"
          id="save-button"
          v-on:click="save()"
      >
        Save
      </button>
      <button type="button" class="btn btn-sm">Cancel</button>
    </div>
  </div>
</template>

<style>
body {
  padding: 20px;
}

#location-form {
  display: grid;
  grid-template-columns: auto auto 1fr;
  grid-gap: 0.2em;
}

#location-form label {
  grid-column: 1/2;
}

#location-form > input[type="text"] {
  grid-column: span 2;
}

#location-form input[type="checkbox"] {
  align-self: center;
  grid-column: 2/3;
}

#location-form hr {
  grid-column: span 3;
  width: 100%;
}

.active-form {
  grid-column: 2/4;
}

.street-form {
  grid-column: span 2;
  display: grid;
  grid-template-columns: 1fr auto;
  grid-column-gap: 0.2em;
}

.city-form {
  grid-column: 2 / 4;
  display: grid;
  grid-template-columns: auto 1fr;
  grid-column-gap: 0.2em;
}

.button-container {
  grid-column: 2 / 4;
  display: grid;
  grid-template-columns: auto 1fr auto;
  grid-column-gap: 0.2em;
}

#save-button {
  justify-self: end;
}

#notes-input {
  height: 10em;
  grid-column: span 2;
}

@media (max-width: 500px) {
  #location-form {
    grid-template-columns: auto;
  }

  #location-form > input[type="text"] {
    grid-column: span 1;
  }

  #location-form hr {
    grid-column: span 1;
  }

  .active-form {
    grid-column: 1 / 2;
  }

  .city-form {
    grid-column: 1 / 2;
  }

  .street-form {
    grid-column: 1 / 2;
  }

  .button-container {
    grid-column: 1 / 2;
  }

  #notes-input {
    grid-column: span 1;
  }
}
</style>
