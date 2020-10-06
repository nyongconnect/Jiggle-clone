package com.nyongconnect.jiggle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyongconnect.jiggle.adapter.TransactionAdapter
import com.nyongconnect.jiggle.dataManager.TransactionDataManager
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var rvTransactions : RecyclerView

    private lateinit var dataManager : TransactionDataManager
    private lateinit var mDisplayWelcomeNote : TextView
    private lateinit var mDisplayFlexBalance : TextView
    private lateinit var mDisplayBudgetBalance : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataManager = TransactionDataManager()
        mDisplayWelcomeNote = view.findViewById(R.id.tv_display_user_welcome_note)
        mDisplayFlexBalance = view.findViewById(R.id.tv_display_flex_balance)
        mDisplayBudgetBalance = view.findViewById(R.id.tv_display_budget_balance)
        rvTransactions = view.findViewById<RecyclerView>(R.id.rv_transaction)

    }


        private fun DisplayDummyData(
        ) {
            val myAdapter = TransactionAdapter(dataManager.transactions)
            val formatter = DecimalFormat("#,###")

            mDisplayWelcomeNote.setText("Welcome " + getCurrentUserName(dataManager))
            mDisplayBudgetBalance.setText("\u20A6" +formatter.format(getBudgetBalance(dataManager)))
            mDisplayFlexBalance.setText("\u20A6" +formatter.format(getFlexBalance(dataManager)))

            rvTransactions.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(getActivity())
                adapter = myAdapter

            }
        }

        private fun getBudgetBalance(dataManager: TransactionDataManager) =
            getUserAccount(dataManager).budgetBalance

        private fun getFlexBalance(dataManager: TransactionDataManager) =
            getUserAccount(dataManager).flexBalance

        private fun getUserAccount(dataManager: TransactionDataManager) =
            dataManager.accounts.get(0)

        private fun getCurrentUserName(dataManager: TransactionDataManager) =
            dataManager.users[0].firstName


    override fun onStart() {
        super.onStart()
        DisplayDummyData()

    }
    }