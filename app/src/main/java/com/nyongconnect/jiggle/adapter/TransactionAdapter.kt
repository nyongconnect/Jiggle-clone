package com.nyongconnect.jiggle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyongconnect.jiggle.R
import com.nyongconnect.jiggle.adapter.TransactionAdapter.TransactionAdapterViewHolder
import com.nyongconnect.jiggle.model.Transaction
import java.text.DecimalFormat

class TransactionAdapter(private val transactions : ArrayList<Transaction>) : RecyclerView.Adapter<TransactionAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_list, parent, false)
        return TransactionAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
            return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionAdapterViewHolder, position: Int) {

        holder.displayTransactionTitle.setText(transactions.get(position).transaction_title)
        holder.displayTransactionDescription.setText(transactions.get(position).transaction_description)
        holder.displayTransactionAmount.setText(displayCurrency(transactions.get(position).transaction_amount))
    }
    private fun displayCurrency(number: Int) : String{
        val formatter = DecimalFormat("#,###")
        return "\u20A6"+formatter.format(number)
    }


    class TransactionAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val displayTransactionTitle : TextView = itemView.findViewById(R.id.tv_transaction_title)
        val displayTransactionDescription : TextView = itemView.findViewById(R.id.tv_transaction_description)
        val displayTransactionAmount : TextView = itemView.findViewById(R.id.tv_transaction_amount)
    }

}