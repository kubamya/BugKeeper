<template>
    <div>
        <div>
            单向绑定demo:
            <input type="text" v-bind="ipt1">
            <input type="text" v-bind="ipt1">
        </div>
        <div>
            双向绑定demo:
            <input type="text" v-model="ipt2">
            <input type="text" v-model="ipt2">
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            ipt1:'',
            ipt2:''
        }
    },
}
</script>