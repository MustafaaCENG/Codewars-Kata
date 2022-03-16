package KatasSolution;

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper<T> {
    private int count = 0;
    private int items = 0;

    public PaginationHelper(List<T> colls, int itemsPage) {
        this.count = colls.size();
        this.items = itemsPage;
    }

    public int pageItemCount(int index) {
        int c = pageCount();
        if (index < 0 || index >= c) {
            return -1;
        }
        if (index == c - 1) {
            return count % items;
        } else
            return items;
    }

    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= count) {
            return -1;
        }
        return (itemIndex - 1) / items;
    }


    public int itemCount() {
        return count;
    }

    public int pageCount() {
        return (count - 1) / items + 1;
    }

}
