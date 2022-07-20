<template>
  <section>
    <Me :user="topicUser"/>
    <!--是否登录-->
    <login-welcome />

    <!--今日赠言-->
    <!-- <tip-card /> -->

    <!--资源推介-->
    <PromotionCard />

  </section>
</template>

<script>
import TipCard from '@/views/card/Tip'
import PromotionCard from '@/views/card/Promotion'
import LoginWelcome from '@/views/card/LoginWelcome'


import { getTopic } from '@/api/post'
import Me from './Me.vue'


export default {
  name: 'CardBar',
  components: { LoginWelcome, PromotionCard, TipCard, Me },
   data() {
    return {
      topicUser: {}
    }
  },
  mounted: {
    
    log(){console.log(this.$store.user)},
    async fetchTopic() {
      getTopic(this.$route.params.id).then(response => {
        const { data } = response
        this.topicUser = data.user
  //      this.topicUser = this.$store.user
      
      })
    },
  }
}
</script>

<style scoped>
</style>
