<template>
    <div>

        <form v-on:submit.prevent="editCard">
            <div class="form-element">
                 <label for="question">Question:</label>
                <input id="question" type="text" />
            </div>
            <div class="form-element">
                 <label for="answer">Answer:</label>
                 <input id="answer" type="text"  />
            </div>
            <div class="form-element">
                <label for="subject">Subject:</label>
                <input id="subject" type="text" />
            </div>
            <div class="form-element">
                <label for="keywords">Keywords (space separated):</label>
                <input id="keywords" type="text"  />
            </div>
            <input type="submit" value="Save Changes" />
            <input type="button" value="Cancel" v-on:click="resetForm" />
        </form>
    </div>
</template>

<script>
export default {
    
}
</script>

<style>

div.form-element {
  margin-top: 10px;
}

</style>