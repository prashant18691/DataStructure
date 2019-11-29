package com.test.prs.challenges.zalando;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> countMap = new HashMap<>();
        if(invalid(visits))
            return countMap;
        for(int i=0;i<visits.length;i++){
            Map<String, UserStats> eachVisit = visits[i];
            for (Map.Entry<String,UserStats> entry:eachVisit.entrySet()){
                if (!isParseable(entry.getKey())){
                    continue;
                }
                if (entry.getValue()==null){
                    continue;
                }
                if (!entry.getValue().getVisitCount().isPresent()){
                    continue;
                }
                Long key = Long.parseLong(entry.getKey());
                Long value = entry.getValue().getVisitCount().get();
                countMap.put(key,countMap.getOrDefault(key,0L)+value);
            }
        }
        return countMap;
    }

    private boolean isParseable(String key) {
        try {
            Long.parseLong(key);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    boolean invalid(Map[] visits){
        if (visits==null || visits.length==0)
            return true;
        return false;
    }


}

class UserStats{
    private Optional<Long> visitCount;

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }
}
