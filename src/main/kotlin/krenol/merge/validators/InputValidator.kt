package krenol.merge.validators

class InputValidator() {
    private val REGEX = Regex("^(\\[(\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\](\\s)*((\\s)+\\[(\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\])*)\$")
    fun isValidInputString(inputString: String?) :  Boolean? {
        return inputString?.matches(REGEX)
    }
}