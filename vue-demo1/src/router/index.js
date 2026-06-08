import Article from '@/views/Article.vue';
import Layout from '@/views/Layout.vue';
import ArticleDetail from '@/views/ArticleDetail.vue';
import Like from '@/views/Like.vue';
import User from '@/views/User.vue';
import Vue from 'vue'
import VueRouter from "vue-router";
import Collect from '@/views/Collect.vue';
Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      path: "/",
      component: Layout,
      children: [{
        path: '/article',
        component: Article
      },
      {
        path: "/collect",
        component: Collect
      },
      {
        path: '/like',
        component: Like
      },
      {
        path: '/user',
        component: User
      }
      ]//嵌套子路由
    },
    {
      path: '/detail',
      component: ArticleDetail
    },

  ]
})

export default router