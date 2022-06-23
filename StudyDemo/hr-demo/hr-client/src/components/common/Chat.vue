<template>
    <div id="chat">
        <div class="sidebar">
            <Card></Card>
            <List></List>
        </div>
        <div class="main">
            <Message></Message>
            <UserText></UserText>
        </div>
    </div>
</template>

<script>
    import Card from "./Card"
    import List from "./List"
    import Message from "./Message"
    import UserText from "./UserText";

    export default {
        name: 'Chat',
        data () {
            return {

            }
        },
        mounted:function() {
            this.$store.dispatch('initData');
        },
        components:{
            UserText,
            Card,
            List,
            Message
        }
    }
</script>

<style lang="scss" scoped>
    #chat {
        margin: 20px auto;
        width: 800px;
        height: 600px;
        /*overflow: hidden;*/
        border-radius: 10px;
        .sidebar, .main {
            height: 100%;
        }
        .sidebar {
            float: left;
            color: #f4f4f4;
            background-color: #2e3238;
            width: 200px;
        }
        .main {
            position: relative;
            overflow: hidden;
            background-color: #eee;
        }
    }
</style>
