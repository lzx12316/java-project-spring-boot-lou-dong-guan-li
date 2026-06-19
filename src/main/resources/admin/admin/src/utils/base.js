const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot4y8k8m47/",
            name: "springboot4y8k8m47",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot4y8k8m47/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于spring boot的楼栋管理系统"
        } 
    }
}
export default base
