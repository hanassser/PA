<template>
  <el-card class="box-card" shadow="never">
    <div slot="header">
      <span>💐 Post something</span>
    </div>
    <div v-if="token != null && token !== ''" class="has-text-centered">
      <b-button type="is-danger" tag="router-link" :to="{path:'/post/create'}" outlined>✍ share your ideas</b-button>
    </div>

    <div v-else class="has-text-centered">
      <b-button type="is-primary" tag="router-link" :to="{path:'/register'}" outlined>Register</b-button>
 
      <b-button type="is-danger" tag="router-link" :to="{path:'/login'}" outlined class="ml-2"> Login</b-button>
    </div>
  </el-card>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'LoginWelcome',
  computed: {
    ...mapGetters([
      'token'
    ])
  }
}
</script>

<style scoped>

</style>