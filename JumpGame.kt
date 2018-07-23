class SolutionCanJump    {
    fun canJump(A: IntArray): Boolean {

        if(A==null || A.size ==0 ){
            return false
        }
        var reach = 0
        for(i in 0 until A.size){
            reach = Math.max(reach , i+A[i])
        }

        if(reach < A.size -1)
            return false
        return true
    }

}