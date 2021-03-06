import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'  // HV mag weg later als ik HelloWorld wegwil
import Bestelling from '../views/Bestelling.vue'
import Persoon from "../views/Persoon";

Vue.use(VueRouter);

const routes = [

    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    },
    {
        path: '/bestelling',
        name: 'Bestelling',
        component: Bestelling
    },
    {
        path: '/bestelling/:id',
        name: 'Bestelling',
        component: Bestelling
    },
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/persoon',
        name: 'Persoon',
        component: Persoon
    },
    {
        path: '/persoon/:persoonId',
        name: 'Persoon',
        component: Persoon
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router
