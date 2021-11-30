package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    public static <T> List<T> getPageByPageNum(List<T> data, int pageNum, Integer pageSize) {
        int total = data.size();
        int size = pageNum * pageSize;
        int prevSize = (pageNum - 1) * pageSize;
        if (size <= total) {
            return data.subList(prevSize, size);
        }
        if (prevSize < total) {
            return data.subList(prevSize, total);
        }
        return new ArrayList<>();
    }

    public static <T> List<T> getPageByOffset(List<T> data, int offset, Integer pageSize) {
        int total = data.size();
        int size = offset + pageSize;
        if (size <= total) {
            return data.subList(offset, size);
        }
        if (offset < total) {
            return data.subList(offset, total);
        }
        return new ArrayList<>();
    }

}
