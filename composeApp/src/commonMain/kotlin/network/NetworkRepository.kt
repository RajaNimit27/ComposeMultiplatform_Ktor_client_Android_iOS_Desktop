package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import models.ApiResponse

class NetworkRepository(private val httpClient: HttpClient) {

     fun getProductList(): Flow<NetWorkResult<ApiResponse?>> {
        return toResultFlow {
                val response = httpClient.get("https://dummyjson.com/products?limit=100&skip=5").body<ApiResponse>()
                 NetWorkResult.Success(response)
        }
    }


}