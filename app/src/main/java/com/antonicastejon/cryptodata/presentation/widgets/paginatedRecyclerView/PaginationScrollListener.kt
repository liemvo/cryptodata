package com.antonicastejon.cryptodata.presentation.widgets.paginatedRecyclerView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private val TAG: String = PaginationScrollListener::class.java.name

abstract class PaginationScrollListener(val layoutManager: androidx.recyclerview.widget.LinearLayoutManager) : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
    protected abstract fun loadMoreItems()
    abstract fun getTotalPageCount(): Int
    abstract fun isLastPage(): Boolean
    abstract fun isLoading(): Boolean

    override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (allowLoadMore() && isNearToLastItem(layoutManager)) {
            loadMoreItems()
        }
    }

    private fun allowLoadMore() = !isLoading() && !isLastPage()

    private fun isNearToLastItem(layoutManager: androidx.recyclerview.widget.LinearLayoutManager): Boolean {
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        return visibleItemCount + firstVisibleItemPosition >= totalItemCount &&
                firstVisibleItemPosition >= 0
    }
}