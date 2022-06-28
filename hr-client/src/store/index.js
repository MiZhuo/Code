import Vue from 'vue'
import Vuex from 'vuex'
import {Notification} from 'element-ui'
import {getRequest} from "../utils/api";
import {postRequest} from "../utils/api";
import {deleteRequest} from "../utils/api";
import '../utils/stomp'
import SockJS from '../utils/sockjs'

Vue.use(Vuex)

const now = new Date();

const store = new Vuex.Store({
    state:{
        routes : [],
        sessions:{},
        hrs:[],
        currentSession: null,
        currentHr: JSON.parse(window.sessionStorage.getItem("user")),
        filterKey:'',
        stomp: null,
        isDot: {}
    },
    getters:{

    },
    mutations:{
        initRoutes(state,data){
            state.routes = data;
        },
        changeCurrentSession (state,currentSession) {
            Vue.set(state.isDot,state.currentHr.username + '#' + currentSession.username,false);
            state.currentSession = currentSession;
        },
        addMessage (state,msg) {
            let message = state.sessions[state.currentHr.username + '#' + msg.to];
            if(!message){
                Vue.set(state.sessions,state.currentHr.username + '#' + msg.to,[]);
            }
            state.sessions[state.currentHr.username + '#' + msg.to].push({
                content:msg.content,
                date: new Date(),
                self: !msg.notSelf
            })
        },
        INIT_CURRENT_HR(state,hr){
            state.currentHr = hr;
        },
        INIT_DATA (state) {
            //浏览器本地历史聊天记录
            let data = localStorage.getItem("vue-chat-session");
            if(data){
                state.sessions = JSON.parse(data);
            }
        },
        INIT_HR(state,data){
            state.hrs = data;
        }
    },
    actions:{
        connect(context){
            context.state.stomp = Stomp.over(new SockJS('/ws/ep'));
            context.state.stomp.connect({},success=>{
                //上线
                postRequest('/common/online');
                //获取离线消息
                getRequest('/common/getOfflineMsg').then(resp=>{
                    if(resp){
                        context.state.sessions = resp.result;
                        deleteRequest('/common/delOfflineMsg');
                    }
                });
                //订阅消息
                context.state.stomp.subscribe('/user/queue/chat',msg=>{
                    let receiveMsg = JSON.parse(msg.body);
                    if(!context.state.currentSession || receiveMsg.from != context.state.currentSession.username){
                        Notification.info({
                            title:'【' + receiveMsg.fromName + '】发来了一条消息',
                            message:receiveMsg.content.length > 10 ? receiveMsg.content.substr(0,10) : receiveMsg.content,
                            position:'bottom-right'
                        });
                        Vue.set(context.state.isDot,context.state.currentHr.username + '#' + receiveMsg.from,true);
                    }
                    receiveMsg.notSelf = true;
                    receiveMsg.to = receiveMsg.from;
                    context.commit('addMessage',receiveMsg);
                });
            },error=>{

            });
        },
        initData (context) {
            context.commit('INIT_DATA')
            getRequest('/common/getHrs').then(resp=>{
                if(resp){
                    context.commit('INIT_HR',resp.result);
                }
            })
        }
    }
})


store.watch(function (state) {
    return state.sessions
},function (val) {
    localStorage.setItem('vue-chat-session', JSON.stringify(val));
},{
    deep:true/*这个貌似是开启watch监测的判断,官方说明也比较模糊*/
})


export default store;