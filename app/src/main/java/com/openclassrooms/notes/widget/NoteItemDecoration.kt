package com.openclassrooms.notes.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * A decoration that adds spacing between items in a RecyclerView.
 * @param spaceSize The size of the spacing in pixels.
 * @param spanCount The number of columns in the RecyclerView.
 */
class NoteItemDecoration(
    private val spaceSize: Int,
    private val spanCount: Int
) : ItemDecoration() {

    // Called each time an item (child view) is added to the RecyclerView
    override fun getItemOffsets(
        outRect: Rect, // store margin values for
        view: View, // current item view
        parent: RecyclerView, // RecyclerView
        state: RecyclerView.State // state of RecyclerView
    ) {
        with(outRect) {

            // The algorithm uses the position of the element within the RecyclerView and
            // the number of columns to determine the margins to add around each element.

            if (parent.getChildAdapterPosition(view) < spanCount) {
                // It adds additional margins at the top of the first row of elements
                top = spaceSize
            }

            if (parent.getChildAdapterPosition(view) % spanCount == 0) {
                // And at the left of the first column of elements
                left = spaceSize
            }

            // Then adds uniform margins around all other elements
            right = spaceSize
            bottom = spaceSize
        }
    }
}