/*
 * ownCloud Android client application
 *
 * @author Fernando Sanz Velasco
 * Copyright (C) 2021 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.owncloud.android.presentation.logging

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import java.io.File

class LoggingDiffUtil(private val oldList: List<File>, private val newList: List<File>) : DiffUtil.Callback() {

    companion object {
        private const val TAG = "LoggingDiffUtil"
    }

    override fun getOldListSize(): Int {
        Log.d(TAG, "Old list size: ${oldList.size}")
        return oldList.size
    }

    override fun getNewListSize(): Int {
        Log.d(TAG, "New list size: ${newList.size}")
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val areSame = oldItemPosition == newItemPosition
        Log.d(TAG, "Comparing items: Old position $oldItemPosition, New position $newItemPosition. Are items the same? $areSame")
        return areSame
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItemName = oldList[oldItemPosition].name
        val newItemName = newList[newItemPosition].name
        val areContentsSame = oldItemName == newItemName
        Log.d(TAG, "Comparing contents: Old item name '$oldItemName', New item name '$newItemName'. Are contents the same? $areContentsSame")
        return areContentsSame
    }
}
