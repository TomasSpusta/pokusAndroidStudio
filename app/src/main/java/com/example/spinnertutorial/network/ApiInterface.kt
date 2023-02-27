package com.example.spinnertutorial.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/*In ApiInterface interface, we declare all the REST request methods with individual paths for the endpoint.
Although example is shown for a typical POST call, we can use any REST methods on our own i.e. POST, GET, PUT, DELETE etc.*/



interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST ("get-contact-by-rfid")
    fun sendRequest (@Body requestModel: RequestModel): Call<ResponseModelList>

}