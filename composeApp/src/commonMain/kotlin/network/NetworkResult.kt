package network


sealed class NetWorkResult<out T>(val status: ApiStatus, val data: T?, val message: String?) {

    data class Success<out T>(val _data: T?) :
        NetWorkResult<T>(status = ApiStatus.SUCCESS, data = _data, message = null)

    data class Error<out T>(val _data: T?, val exception: String) :
        NetWorkResult<T>(status = ApiStatus.ERROR, data = _data, message = exception)

    data class Loading<out T>(val isLoading: Boolean) :
        NetWorkResult<T>(status = ApiStatus.LOADING, data = null, message = null)

//    companion object {
//        //Handles success
//        fun <T> success(data: T): NetWorkResult<T> = NetWorkResult(
//            status = ApiStatus.SUCCESS, data = data, message = null)
//        //Handles Loading
//        fun <T> loading(data: T?=null): NetWorkResult<T> = NetWorkResult(
//            status = ApiStatus.LOADING, data = data, message = null)
//        //Handles Error
//        fun <T> error(data: T?=null, error: String?=null): NetWorkResult<T> = NetWorkResult(
//            status = ApiStatus.ERROR, data = data, message=error)
//
//    }


}
enum class ApiStatus {
    SUCCESS,
    ERROR,
    LOADING,
}

