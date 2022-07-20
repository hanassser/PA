<template>
  <div id="tag" class="columns">
    <div class="column is-three-quarters">
      <el-card class="box-card" shadow="never">
        <div slot="header" class="">
          🔍 found <span class="has-text-info">{{ topics.length }}</span> posts related
          <span class="has-text-info">{{ this.$route.params.name }}</span>
          <!-- 的话题 -->
        </div>

        <div class="text item">
          <article v-for="(item, index) in topics" :key="index" class="media mt-3">
            <div class="media-content">
              <div class="content">
                <el-tooltip class="item" effect="dark" :content="item.title" placement="top">
                  <router-link :to="{ name: 'post-detail',params:{id: item.id } }">
                    {{ item.title }}
                  </router-link>
                </el-tooltip>
              </div>

              <nav class="level has-text-grey is-size-7">
                <div class="level-left">
                  <span>posted:{{ dayjs(item.createTime).format('YYYY-MM-DD HH:mm:ss') }}</span>

                  <span class="mx-3">view:{{ item.view }}</span>

                  <span>comments:{{ item.comments }}</span>
                </div>
              </nav>
            </div>
          </article>
        </div>
      </el-card>
    </div>

    <div class="column">
      <el-card class="box-card" shadow="hover">
        <div slot="header" class="clearfix">
          🤙 about tags
        </div>
        <div>
          <ul>
            <li class="content">Tags are posted and used by platform users</li>
            <li class="content">The system will regularly clean up useless labels every week</li>
          </ul>
        </div>
      </el-card>
      <el-card shadow="hover">
        <div slot="header">
          🏷 hot tag
        </div>
        <div>
          <ul>
            <li v-for="(tag,index) in tags" :key="index" style="padding: 6px 0">
              <router-link :to="{name:'tag',params:{name:tag.name}}">
                <span v-if="index<9" class="tag">
                  0{{ parseInt(index) + 1 }}
                </span>
                <span v-else class="tag">
                  {{ parseInt(index) + 1 }}
                </span>
                {{ tag.name }}
              </router-link>
            </li>
          </ul>
        </div>
      </el-card>
    </div>
  </div>

</template>

<script>
import { getTopicsByTag } from '@/api/tag'

export default {
  name: 'Tag',
  data() {
    return {
      topics: [],
      tags: [],
      paramMap: {
        name: this.$route.params.name,
        page: 1,
        size: 10
      }
    }
  },
  created() {
    this.fetchList()
  },
  methods: {
    fetchList: function() {
      getTopicsByTag(this.paramMap).then(response => {
        console.log(response)
        this.topics = response.data.topics.records
        this.tags = response.data.hotTags.records
      })
    }
  }
}
</script>

<style scoped>
#tag {
  min-height: 500px;
}
</style>
