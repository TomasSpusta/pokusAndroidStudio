package com.example.spinnertutorial.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*Finally, we implement the actual Service which we will directly invoke.
We call it service but don’t be confused with Android service.
If you feel you can rename the class as your own like with RestApiManager or ApiManager etc.*/


class RestApiManager {

    fun getUserData (requestModel: RequestModel, onResult: (ResponseModelList?) -> Unit){

        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.sendRequest(requestModel).enqueue(

            object : Callback <ResponseModelList> {

                override fun onFailure(call: Call<ResponseModelList>, t: Throwable) {
                    onResult(null)
                    println("Problemek onFailure funkce")
                }

                override fun onResponse(call: Call<ResponseModelList>, response: Response<ResponseModelList>) {
                    val cRMResponse = response.body()
                    onResult(cRMResponse)
/*
                    //Log.d("Response","${response.code()}")
                   // Log.d("Response","${response.body()?.size}")
                    //Log.d("Response","${response.body()}")
                    if (response.body()?.size != 0) {
                        Log.d("Response_","${response.body()?.get(0)?.userFirstName}")
                        //val odpoved = response.body()
                        //val userID = response.body()?.get(0)?.userID
                        //val userFirstName = response.body()?.get(0)?.userFirstName
                        //onResult(odpoved)


                    }else{
                        Log.d("Response_","User is not in database")
                    }

 */
                }
            }
        )
    }


}