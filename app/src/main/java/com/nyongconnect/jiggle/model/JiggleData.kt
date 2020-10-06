package com.nyongconnect.jiggle.model

class User (var id: String, var firstName : String, var lastName : String, var imageUrl: String ){
    override fun toString(): String {
        return firstName + " " + lastName
    }
}

class Transaction(var userId :String, var transaction_amount : Int, var transactionId : String, var transaction_title: String, var transaction_description : String, var transationUrl : String){
    override fun toString(): String {
        return transaction_title
    }
}
class Account(var userId : String, var flexBalance : Int, var budgetBalance : Int){

}