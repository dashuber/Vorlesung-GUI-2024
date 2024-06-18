<script setup lang="ts">
import { ref } from "vue";
import LocationForm from "@/LocationForm.vue";
import type { LocationModel } from "@/LocationModel";

const title = ref("Location");

function onSave(location: LocationModel) {
  console.log("Output from parent - got " + location);
}
</script>

<template>
  <div>
    <LocationForm :title="title" @save="onSave"></LocationForm>
  </div>
</template>

<style></style>
