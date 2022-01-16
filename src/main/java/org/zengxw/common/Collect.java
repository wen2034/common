package org.zengxw.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 集合处理
 * @author zengxw
 * @version 2022/1/16
 */
public class Collect {

    /**
     * list差集
     * @param sourceList 源list
     * @param reduceList 减list
     * @return 结果list
     */
    public static List<Integer> listReduce(List<Integer> sourceList, List<Integer> reduceList) {
        sourceList = sourceList.stream().sorted().collect(Collectors.toList());
        reduceList = reduceList.stream().sorted().collect(Collectors.toList());

        List<Integer> tmpList = new ArrayList<>();
        Integer[] tmpSource = new Integer[sourceList.size()];
        sourceList.toArray(tmpSource);

        Integer[] tmpRemove = new Integer[reduceList.size()];
        reduceList.toArray(tmpRemove);

        int m = 0;
        int n = 0;
        while(n < tmpRemove.length) {
            int m1 = tmpSource[m];
            int n1 = tmpRemove[n];
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
