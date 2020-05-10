class Solution {
    fun destCity(paths: List<List<String>>): String {
        var set = HashSet<String>()
        for(i in paths.indices){
            set.add(paths[i][0])
        }
        for(i in paths.indices){
            if(!set.contains(paths[i][1])){
                return paths[i][1]
            }
        }
        //answer is always guaranteed
        return ""
    }
}