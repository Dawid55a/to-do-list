package com.example.todolistkotlin

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class ListAdapter(
    groups: ArrayList<DaysClass>
):
    ExpandableRecyclerViewAdapter<DaysViewHolder, ItemViewHolder>(groups){

    lateinit var groups: ArrayList<DaysClass>
    init {
        this.groups = groups
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): DaysViewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.expandable_days, parent, false)
        return DaysViewHolder(v)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(v)
    }


    override fun onBindChildViewHolder(
        holder: ItemViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {
        val item: ItemClass = group!!.items.get(childIndex) as ItemClass
        holder!!.bind(item)

    }

    override fun onBindGroupViewHolder(
        holder: DaysViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        val day: DaysClass = group as DaysClass
        holder!!.bind(day)

    }


}
