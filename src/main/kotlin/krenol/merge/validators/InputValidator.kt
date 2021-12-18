package krenol.merge.validators

class InputValidator() {
    private val REGEX = Regex("^(\\[[0-9]+,(\\s)*[0-9]+\\](\\s)*((\\s)+\\[[0-9]+,(\\s)*[0-9]+\\])*)\$")
    fun isValidInputString(inputString: String?) :  Boolean? {
        return inputString?.matches(REGEX)
    }
}