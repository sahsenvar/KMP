import io.michaelrocks.libphonenumber.kotlin.PhoneNumberUtil
import io.michaelrocks.libphonenumber.kotlin.Phonenumber
import markers.response.KmpResponse

class ValidationService(

) {
    fun determineIdentifierType(input: String): KmpResponse<IdentifierType, ValidationError>{
        val identifier: String = input.trim()
        return when{
            identifier.contains('@') -> KmpResponse.Success(IdentifierType.Email)
            identifier.contains(regex = "[+0-9]+".toRegex()) -> KmpResponse.Success(IdentifierType.Phone)
            else -> KmpResponse.Failure(ValidationError.IdentifierDoesNotDetermined("identifier type didn't find. Please enter phone number or mail adress"))
        }
    }

    fun validateEmail(input: String){
        val email: String = input.trim()

    }

    fun validatePhoneNumber(phoneNumber: String){
        Phonenumber.PhoneNumber()
            .setCountryCode(90)
    }

    fun validatePassword(password: String){

    }



    companion object{
        val PHONE_REGEX = "(\\+[0-9]+[\\- \\.]*)?(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.]+[0-9])".toRegex()

    }
}