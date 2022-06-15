package org.zengxw.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合处理
 * @author zengxw
 * @version 2022/1/16
 */
public class CollectUtils {

    /**
     * list差集
     * @param sourceList 源list
     * @param reduceList 减list
     * @return 结果list
     */
    public static List<Integer> listReduce(List<Integer> sourceList, List<Integer> reduceList) {
        Integer[] tmpSource = new Integer[sourceList.size()];
        sourceList.toArray(tmpSource);
        Arrays.sort(tmpSource);

        Integer[] tmpReduce = new Integer[reduceList.size()];
        reduceList.toArray(tmpReduce);
        Arrays.sort(tmpReduce);

        List<Integer> tmpList = new ArrayList<Integer>();
        int m = 0;
        int n = 0;
        while(n < tmpReduce.length) {
            int m1 = tmpSource[m];
            int n1 = tmpReduce[n];
            if(m1 == n1) {
                m++;
                n++;
            } else if(m1 < n1) {
                tmpList.add(tmpSource[m]);
                m++;
            } else {
                n++;
            }
        }

        for(;m < tmpSource.length;m++)
            tmpList.add(tmpSource[m]);
        return tmpList;
    }
}
