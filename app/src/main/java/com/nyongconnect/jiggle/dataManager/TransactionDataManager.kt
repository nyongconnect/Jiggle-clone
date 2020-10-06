package com.nyongconnect.jiggle.dataManager

import com.nyongconnect.jiggle.model.Account
import com.nyongconnect.jiggle.model.Transaction
import com.nyongconnect.jiggle.model.User


class TransactionDataManager {
    val accounts = ArrayList<Account>()
    val transactions = ArrayList<Transaction>()
    val users = ArrayList<User>();
    init {
        initializeUsers()
        initializeAccounts()
        initializeTransactions()
    }

    private fun initializeUsers(){
        var user = User("nyong123", "Nsikak", "Nyong", "")
        users.add(user)
    }
    private fun initializeTransactions(){
        var transaction = Transaction("nyong123", 2000,"airtel123", "Airtel 08161218810", "PAYMENT from FLEX WALLET", "")
        transactions.add(transaction)

        transaction = Transaction("nyong123", 40000,"airtel12", "Airtel 08036774933", "PAYMENT from FLEX WALLET", "")
        transactions.add(transaction)

        transaction = Transaction("nyong123", 1000000,"airtel1", "Airtel 08030962698", "PAYMENT from FLEX WALLET", "")
        transactions.add(transaction)

    }

    private fun initializeAccounts(){
        var account = Account("nyong123",2000.0, 80000.0)
        accounts.add(account)
    }
}