class RotateRing {
  object Solution {
    def rotateString(A: String, B: String): Boolean = {
      (0 to A.length).exists(i => A.drop(i) + A.take(i) == B)
    }
  }
}
