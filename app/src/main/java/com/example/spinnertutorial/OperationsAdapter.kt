package com.example.spinnertutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import com.example.spinnertutorial.lists.OperationItem

class OperationsAdapter(context:Context, operationList:List <OperationItem>)
    :ArrayAdapter<OperationItem> (context, 0, operationList)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position,convertView,parent)
    }

    private fun myView (position: Int, convertView: View?, parent: ViewGroup): View {

        val list = getItem(position)
        val view = convertView?: LayoutInflater.from (context).inflate(R.layout.spinner_item,parent,false)

        list?.let {
            val txt = view.findViewById<TextView>(R.id.tv_itemName)

            txt.text= list.name
        }

        return view
    }


    }


