package org.komodo.settings.preferences

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.TextView
import androidx.preference.PreferenceViewHolder
import lineageos.preference.LineagePartsPreference

import com.android.settings.R

class KomodoPreference : LineagePartsPreference {
    private var iconText: String? = null

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) 
        : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) 
        : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.KomodoPreference)
        iconText = a.getString(R.styleable.KomodoPreference_icon_text)
        a.recycle()
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        val iconTextView = holder.findViewById(R.id.icon_text) as? TextView
        iconTextView?.text = iconText
    }
}
